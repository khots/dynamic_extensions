package edu.common.dynamicextensions.napi;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import edu.common.dynamicextensions.domain.nui.Container;
import edu.common.dynamicextensions.domain.nui.Control;
import edu.common.dynamicextensions.domain.nui.FileUploadControl;
import edu.common.dynamicextensions.domain.nui.MultiSelectControl;
import edu.common.dynamicextensions.domain.nui.SubFormControl;
import edu.common.dynamicextensions.domain.nui.ValidationErrors;
import edu.common.dynamicextensions.domain.nui.ValidationStatus;

public class FormData {
	private Container container;
	
	private Long recordId;
	
	private Map<String, Object> appData = new HashMap<String, Object>();
	
	private Map<String, ControlValue> fieldValues = new LinkedHashMap<String, ControlValue>();
	
	private FormData parentFormData;

	public FormData(Container container) {
		this.container = container;
	}

	public Container getContainer() {
		return container;
	}

	public void setContainer(Container container) {
		this.container = container;
	}

	public Long getRecordId() {
		return recordId;
	}

	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}

	public Map<String, Object> getAppData() {
		return appData;
	}

	public void setAppData(Map<String, Object> appData) {
		this.appData = appData;
	}
	
	public Collection<ControlValue> getFieldValues() {
		return fieldValues.values();
	}

	public void setFieldValues(Map<String, ControlValue> fieldValues) {
		this.fieldValues = fieldValues;
	}
	
	public void addFieldValue(ControlValue controlValue) {
		fieldValues.put(controlValue.getControl().getName(), controlValue);
	}
	
	public ControlValue getFieldValue(String name) {
		return fieldValues.get(name);
	}

	public boolean isUsingUdn() {
		return isUsingUdn(appData);
	}

	public FormData getRootFormData() {
		FormData result = this;
		while (result.parentFormData != null) {
			result = result.parentFormData;
		}
		
		return result;		
	}

	
	public String toJson() {
		return toJson(false);
	}
	
	public String toJson(boolean includeUdn) {
		return new Gson().toJson(getFieldNameValueMap(includeUdn));
	}
	
	public static FormData fromJson(String json) {
		return fromJson(json, null);
	}
	
	@SuppressWarnings("unchecked")
	public static FormData fromJson(String json, Long containerId) {
		Type type = new TypeToken<Map<String, Object>>() {}.getType();
		Map<String, Object> valueMap = new Gson().fromJson(json, type);
		return fromValueMap(containerId, valueMap);
	}

	public static FormData fromValueMap(Long containerId, Map<String, Object> valueMap) {
		if (valueMap.get("containerId") == null && containerId == null) {
			throw new IllegalArgumentException("Input doesn't have mandatory property: containerId");
		}
				
		if (containerId == null) {
			containerId = ((Number)valueMap.get("containerId")).longValue();		
        }

		Container container = Container.getContainer(containerId);
		if (container == null) {
			throw new IllegalArgumentException("Input specifies invalid container id: " + containerId);
		}
		
		valueMap.remove("containerId");
		
		Map<String, Object> appData = (Map<String, Object>)valueMap.get("appData");
		boolean useUdn = isUsingUdn(appData);

		FormData formData = getFormData(container, valueMap, useUdn, null);		
		if (valueMap.get("recordId") != null) {
			formData.setRecordId(((Number)valueMap.get("recordId")).longValue());
		}
		
		return formData;
	}
		
	public static FormData getFormData(Container container, Map<String, Object> valueMap) {
		return getFormData(container, valueMap, false, null);
	}
	
	@SuppressWarnings("unchecked")
	public static FormData getFormData(Container container, Map<String, Object> valueMap, boolean useUdn, FormData parent) {
		FormData formData = new FormData(container);
		formData.parentFormData = parent;
		
		Map<String, Object> appData = (Map<String, Object>)valueMap.get("appData");
		formData.setAppData(appData);
				
		Number recordId = (Number)valueMap.get("id");
		if (recordId != null) {
			formData.setRecordId(recordId.longValue());
		}
		
		for (Map.Entry<String, Object> fieldValue : valueMap.entrySet()) {
			if (fieldValue.getKey().equals("id")) {
				continue;
			}
						
			Control ctrl = null;
			if (useUdn) {
				ctrl = container.getControlByUdn(fieldValue.getKey());
			} else {
				ctrl = container.getControl(fieldValue.getKey());
			}

			if (ctrl instanceof SubFormControl) {
				SubFormControl sfCtrl = (SubFormControl)ctrl;
				if (sfCtrl.isOneToOne()) {
					Map<String, Object> subValueMap = (Map<String, Object>)fieldValue.getValue();
					FormData subFormData = getFormData(sfCtrl.getSubContainer(), subValueMap, useUdn, formData);
					formData.addFieldValue(new ControlValue(ctrl, subFormData));					
				} else {
					List<Map<String, Object>> subValueMapList = (List<Map<String, Object>>)fieldValue.getValue();
					List<FormData> subFormData = new ArrayList<FormData>();
					if (subValueMapList != null) {
						for (Map<String, Object> subValueMap : subValueMapList) {
							subFormData.add(getFormData(sfCtrl.getSubContainer(), subValueMap, useUdn, formData));
						}
					} 
					
					formData.addFieldValue(new ControlValue(ctrl, subFormData));					
				}
			} else if (ctrl instanceof MultiSelectControl) {				
				List<String> values = (List<String>)fieldValue.getValue();
				formData.addFieldValue(new ControlValue(ctrl, values == null ? null : values.toArray(new String[0])));
			} else if (ctrl instanceof FileUploadControl) {
				FileControlValue fcv = null; 				
				if (fieldValue.getValue() instanceof Map) {
					fcv = FileControlValue.fromValueMap((Map<String, String>)fieldValue.getValue());
				}
				
				formData.addFieldValue(new ControlValue(ctrl,fcv));
			} else if (ctrl != null){
				formData.addFieldValue(new ControlValue(ctrl, fieldValue.getValue()));
			}			
		}
		
		return formData;
	}
						
	public Map<String, Object> getFieldNameValueMap(boolean includeUdn) {
		Map<String, Object> props = new HashMap<String, Object>();
		props.put("appData",getAppData());
		props.put("containerId", container.getId());
		props.put("id", recordId);
		
		for (ControlValue fieldValue : getFieldValues()) {
			String name = fieldValue.getControl().getName();
			if (includeUdn) {
				name = fieldValue.getControl().getUserDefinedName();
			}
			
			Object value = fieldValue.getValue();			
			if (value instanceof FileControlValue) {
				FileControlValue fcv = (FileControlValue)value;
				props.put(name, fcv.toValueMap());
			} else if (value instanceof List) {
				List<FormData> formDataList = (List<FormData>)value;
				
				List<Map<String, Object>> sfData = new ArrayList<Map<String, Object>>();
				for (FormData formData : formDataList) {
					sfData.add(formData.getFieldNameValueMap(includeUdn));
				}
				
				props.put(name, sfData);
			} else if (value instanceof FormData) {
				props.put(name, ((FormData)value).getFieldNameValueMap(includeUdn));
			} else if (value != null) {
				props.put(name, value);
			}			
		}
		
		return props;
	}
	
	public void validate() {
		validate(isUsingUdn());
	}
	
	public void validate(boolean useUdn) {
		ValidationErrors errors = new ValidationErrors();
		
		Map<String, Control> mandatory = new HashMap<String, Control>();
		for (Control ctrl : container.getControls()) {
			if (ctrl.isMandatory()) {
				mandatory.put(ctrl.getName(), ctrl);
			}
			
//			if (ctrl instanceof SubFormControl) {
//				mandatory.put(ctrl.getName(), ctrl);
//			}
		}
		
		for (ControlValue ctrlValue : fieldValues.values()) {
			Control ctrl = ctrlValue.getControl();
			mandatory.remove(ctrl.getName());
			
			if (ctrl instanceof SubFormControl) {
				SubFormControl sfCtrl = (SubFormControl)ctrl;
				
				List<FormData> subFormData = null;
				if (sfCtrl.isOneToOne()) {
					subFormData = Collections.singletonList((FormData)ctrlValue.getValue());
				} else {
					subFormData = (List<FormData>)ctrlValue.getValue();
				}
								
				if (subFormData == null || subFormData.isEmpty()) {
					subFormData = Collections.singletonList(new FormData(sfCtrl.getSubContainer()));
				}
				
				try {
					for(FormData sf : subFormData) {
						sf.validate(useUdn);
					}
				} catch (ValidationErrors e) {
					errors.addErrors(e.getErrors());
				}				
			} else {
				ValidationStatus status = ctrl.validate(ctrlValue.getValue());
				if (status != ValidationStatus.OK) {
					String field = useUdn ? ctrl.getUserDefinedName() : ctrl.getCaption();
					errors.addError(field, status);
				}
			}
		}
		
		for (Control ctrl : mandatory.values()) {
			String field = useUdn ? ctrl.getUserDefinedName() : ctrl.getCaption();
			errors.addError(field, ValidationStatus.NULL_OR_EMPTY);
		}
		
		errors.throwIfErrors();
	}
	
	private static boolean isUsingUdn(Map<String, Object> appData) {
		if (appData == null) {
			return false;
		}
		
		Object val = appData.get("useUdn");
		if (val instanceof String) {
			return ((String) val).trim().equals("true");
		} else if (val instanceof Boolean) {
			return ((Boolean) val).booleanValue();
		} else if (val instanceof Number) {
			return ((Number) val).intValue() == 1;
		}
		
		return false;
	}	
}
