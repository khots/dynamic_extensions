package edu.common.dynamicextensions.domain.nui;

import static edu.common.dynamicextensions.nutility.XmlUtil.writeElementEnd;
import static edu.common.dynamicextensions.nutility.XmlUtil.writeElementStart;

import java.io.Writer;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import edu.common.dynamicextensions.domain.nui.ColumnDef;
import edu.common.dynamicextensions.domain.nui.Control;
import edu.common.dynamicextensions.domain.nui.DataType;
import edu.common.dynamicextensions.domain.nui.LookupControl;
import edu.common.dynamicextensions.ndao.ColumnTypeHelper;
import edu.common.dynamicextensions.ndao.JdbcDaoFactory;
import edu.common.dynamicextensions.ndao.ResultExtractor;

public abstract class AbstractLookupControl extends Control implements LookupControl {
	private static final long serialVersionUID = 1L;
	
	private static final String LU_KEY_COLUMN = "IDENTIFIER";
	
	private static final String LU_VALUE_COLUMN = "NAME";
	
	private static final String IS_KEY_EXISTS_SQL = "select count(*) from %s where %s = ?";
	
	@Override
	public DataType getDataType() {
		return DataType.INTEGER;
	}

	@Override
	public List<ColumnDef> getColumnDefs() {
		return Collections.singletonList(ColumnDef.get(getDbColumnName(), ColumnTypeHelper.getIntegerColType()));
	}

	@SuppressWarnings("unchecked")
	@Override
	public Long fromString(String value) {
		if (value == null || value.trim().isEmpty()) {
			return null;
		}
		
		return new BigDecimal(value).longValue();
	}

	public abstract void getProps(Map<String, Object> props);
	
	public abstract String getTableName();		

	@Override
	public String getParentKey() {
		return getDbColumnName();
	}

	@Override
	public String getLookupKey() {
		return LU_KEY_COLUMN;
	}

	@Override
	public String getValueColumn() {
		return LU_VALUE_COLUMN;
	}

	@Override
	public DataType getValueType() {
		return DataType.STRING;
	}

	@Override
	public abstract Properties getPvSourceProps();
	
	protected void serializeToXml(String field, Writer writer, Properties props) {
		writeElementStart(writer, field);
		super.serializeToXml(writer, props);
		writeElementEnd(writer, field);						
	}	

	@Override
	public ValidationStatus validate(Object value) {
		boolean empty = value == null || value.toString().trim().isEmpty();		
		if (!empty) {
			empty = fromString(value.toString()).equals(-1L);
		}
		
		if (isMandatory() && empty) {
			return ValidationStatus.NULL_OR_EMPTY;
		}
				
		
		if (empty) {
			return ValidationStatus.OK;
		}
	
		if (!isValid(value)) {
			return ValidationStatus.INVALID_VALUE;
		}
		
		return ValidationStatus.OK;
	}
	
	private boolean isValid(Object value) {
		return JdbcDaoFactory.getJdbcDao().getResultSet(
				String.format(IS_KEY_EXISTS_SQL, getTableName(), getLookupKey()), 
				Collections.singletonList(fromString(value.toString())), 
				new ResultExtractor<Boolean>() {
					@Override
					public Boolean extract(ResultSet rs) throws SQLException {
						rs.next();
						return rs.getLong(1) > 0;
					}
				});
	}	
}