/**
 * 
 */
package edu.common.dynamicextensions.napi.impl;

import java.io.IOException;
import java.io.Writer;
import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import edu.common.dynamicextensions.domain.FormAuditEvent;
import edu.common.dynamicextensions.domain.nui.Container;
import edu.common.dynamicextensions.domain.nui.Control;
import edu.common.dynamicextensions.domain.nui.Label;
import edu.common.dynamicextensions.domain.nui.MultiSelectControl;
import edu.common.dynamicextensions.domain.nui.PageBreak;
import edu.common.dynamicextensions.domain.nui.SubFormControl;
import edu.common.dynamicextensions.domain.nui.UserContext;
import edu.common.dynamicextensions.napi.ControlValue;
import edu.common.dynamicextensions.napi.FormAuditManager;
import edu.common.dynamicextensions.napi.FormData;
import edu.common.dynamicextensions.ndao.JdbcDao;
import edu.common.dynamicextensions.ndao.JdbcDaoFactory;
import edu.common.dynamicextensions.ndao.ResultExtractor;

public class FormAuditManagerImpl implements FormAuditManager {	
	@Override
	public void audit(UserContext userCtxt, FormData formData, String operation) {
		try {
			audit(userCtxt, formData, operation, JdbcDaoFactory.getJdbcDao());
		} catch (Exception e) {
			throw new RuntimeException("Error saving form audit data", e);
		} 
	}
	@Override
	public void audit(UserContext userCtxt, FormData formData, String operation, JdbcDao jdbcDao) {
		StringBuilder xml = new StringBuilder();
		String formName = formData.getContainer().getName();
		Long recId = formData.getRecordId();
	
		xml.append("<form-submit>");	
		xml.append("<name>").append(formName).append("</name>");
		xml.append("<user>").append((userCtxt != null) ? userCtxt.getUserName() : "no-user").append("</user>");
		xml.append("<ip-address>").append((userCtxt != null) ? userCtxt.getIpAddress() : "no-ip").append("</ip-address>");
		xml.append("<record-identifier>").append(recId).append("</record-identifier>");	
		xml.append(getFieldSetsXml(formData));
		xml.append("</form-submit>");
		
		FormAuditEvent formAuditEvent = new FormAuditEvent();
		formAuditEvent.setFormName(formName);
		formAuditEvent.setRecordId(recId);
		formAuditEvent.setFormDataXml(xml.toString());
		formAuditEvent.setIpAddress(userCtxt.getIpAddress());
		formAuditEvent.setUserId(userCtxt.getUserId());
		formAuditEvent.setOperation(operation != null ? operation : "");
	
		persist(formAuditEvent, jdbcDao);
	}
	
	private String getFieldSetsXml(FormData formData) {
		StringBuilder xml = new StringBuilder();
		
		Container c = formData.getContainer();
		xml.append("<field-set>");
		xml.append("<container-name>").append(c.getName()).append("</container-name>");
		xml.append("<container-id>").append(c.getId()).append("</container-id>");
		xml.append("<db-table>").append(c.getDbTableName()).append("</db-table>");
		
		for (ControlValue fieldValue :formData.getFieldValues()) {
			Control ctrl = fieldValue.getControl();
			Object val = fieldValue.getValue();
			
			if (ctrl instanceof Label || ctrl instanceof PageBreak) {
				continue;
			}
			xml.append("<field>")
				.append("<control-name>").append(ctrl.getName()).append("</control-name>")
				.append("<ui-label>").append(ctrl.getCaption()).append("</ui-label>");
			
			if (ctrl instanceof SubFormControl) {
				List<FormData> subFormsData = (List<FormData>) val;
				if (subFormsData == null) {
					continue;
				}

				for (FormData subFormData : subFormsData) {
					xml.append(getFieldSetsXml(subFormData));
				}
				
			} else if (ctrl instanceof MultiSelectControl) {
				MultiSelectControl msCtrl = (MultiSelectControl) ctrl;
				xml.append("<collection>")
				   .append("<db-table>").append(msCtrl.getTableName()).append("</db-table>");
				
				String[] strValues = (String[])val;
				if (strValues != null) {
					for(String strVal : strValues) {
						xml.append("<element>")
							.append("<db-column>").append("VALUE").append("</db-column>")
							.append("<value>").append(strVal).append("</value>")
							.append("</element>");
					}
				}
				xml.append("</collection>");
			} else {
				xml.append("<db-column>").append(ctrl.getDbColumnName()).append("</db-column>")
					.append("<value>").append(val != null ? val.toString() : null).append("</value>");
			}
			xml.append("</field>");
		}
		xml.append("</field-set>");
		return xml.toString();
	}
	
	private void persist(FormAuditEvent formAuditEvent, JdbcDao jdbcDao) {		
		try {
			Long auditId = insertAndRetrieveAuditEvent(formAuditEvent, jdbcDao);
			formAuditEvent.setIdentifier(auditId);
			insertFormAuditEvent(formAuditEvent, jdbcDao);
		} catch (Exception e) {
			throw new RuntimeException("Failed to persist audit data", e);
		}
	}


	private Long insertAndRetrieveAuditEvent(FormAuditEvent auditEvent, JdbcDao jdbcDao) 
	throws Exception {		
		List<Object> params = new ArrayList<Object>();
		params.add(auditEvent.getIpAddress());
		params.add(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		params.add(auditEvent.getUserId());
		params.add(auditEvent.getOperation());

		Long auditId = null;
		Number key = jdbcDao.executeUpdateAndGetKey(INSERT_AUDIT_EVENT_SQL, params, "IDENTIFIER");
		if (key != null) {
			auditId = key.longValue();
		}
		return auditId;
	}

	private void insertFormAuditEvent(FormAuditEvent formAuditEvent, JdbcDao jdbcDao) 
	throws Exception {
		List<Object> params = new ArrayList<Object>();		
		params.add(formAuditEvent.getIdentifier());
		params.add(formAuditEvent.getFormName());
		params.add(formAuditEvent.getRecordId());
		
		jdbcDao.executeUpdate(INSERT_FORM_AUDIT_SQL, params);	
		params.clear();
		params.add(formAuditEvent.getIdentifier());
		
		Clob clob = jdbcDao.getResultSet(GET_AUDIT_XML_BY_ID_SQL, params, new ResultExtractor<Clob>() {
			@Override
			public Clob extract(ResultSet rs) 
			throws SQLException {
				rs.next();
				return rs.getClob("FORM_DATA_XML");
			}
		});
		
		writeToClob(clob, formAuditEvent.getFormDataXml());			
	}
	
	private void writeToClob(Clob clob, String auditXml) throws IOException {
		Writer clobOut = null;
		try {
			clobOut = clob.setCharacterStream(0);	
			clobOut.write(auditXml);
		} catch (Exception e) {
			throw new RuntimeException("Error writing clob", e);
		} finally {
				clobOut.close();
		}
	}


	private static final String INSERT_AUDIT_EVENT_SQL = 
			"INSERT INTO CATISSUE_AUDIT_EVENT(IDENTIFIER, IP_ADDRESS, EVENT_TIMESTAMP, USER_ID, EVENT_TYPE) VALUES(CATISSUE_AUDIT_EVENT_PARAM_SEQ.NEXTVAL, ?, ?, ?, ?)";

	private static final String INSERT_FORM_AUDIT_SQL = 
			"INSERT INTO DYEXTN_AUDIT_EVENT (IDENTIFIER, FORM_NAME, RECORD_ID, FORM_DATA_XML) VALUES(?, ?, ?,  empty_clob())";

	private static final String GET_AUDIT_XML_BY_ID_SQL = "SELECT FORM_DATA_XML, FORM_NAME, RECORD_ID"
			+ " FROM DYEXTN_AUDIT_EVENT WHERE IDENTIFIER = ? FOR UPDATE";

}
