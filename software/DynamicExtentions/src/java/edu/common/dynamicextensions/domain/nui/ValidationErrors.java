package edu.common.dynamicextensions.domain.nui;

import java.util.HashMap;
import java.util.Map;

public class ValidationErrors extends IllegalArgumentException {
	private static final long serialVersionUID = -6356806118030154082L;
	
	public Map<String, ValidationStatus> errors = new HashMap<String, ValidationStatus>();

	public void addError(String field, ValidationStatus error) {
		if (error == ValidationStatus.OK) {
			return;
		}
		
		errors.put(field, error);
	}
	
	public Map<String, ValidationStatus> getErrors() {
		return errors;
	}
	
	public void addErrors(Map<String, ValidationStatus> errors) {
		this.errors.putAll(errors);
	}
	
	public void throwIfErrors() {
		if (!errors.isEmpty()) {
			throw this;
		}
	}
}
