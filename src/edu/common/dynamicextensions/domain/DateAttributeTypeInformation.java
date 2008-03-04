
package edu.common.dynamicextensions.domain;

import java.text.ParseException;
import java.util.Date;

import edu.common.dynamicextensions.domaininterface.DateTypeInformationInterface;
import edu.common.dynamicextensions.domaininterface.DateValueInterface;
import edu.common.dynamicextensions.domaininterface.PermissibleValueInterface;
import edu.common.dynamicextensions.entitymanager.EntityManagerConstantsInterface;
import edu.common.dynamicextensions.processor.ProcessorConstants;
import edu.common.dynamicextensions.util.DynamicExtensionsUtility;
import edu.wustl.common.util.Utility;

/**
 * @version 1.0
 * @created 28-Sep-2006 12:20:07 PM
 * @hibernate.joined-subclass table="DYEXTN_DATE_TYPE_INFO"
 * @hibernate.joined-subclass-key column="IDENTIFIER"
 */
public class DateAttributeTypeInformation extends AttributeTypeInformation
        implements
            DateTypeInformationInterface
{

    /**
     * Serial Version Unique Identifier
     */
    private static final long serialVersionUID = 5655678242696814276L;

    /**
     * format of the attribute value (Data entry/display)
     */
    protected String format;

    /**
     * Empty Constructor
     */
    public DateAttributeTypeInformation()
    {

    }

    /**This method returns the format of the DateAttributeTypeInformation.
     * @hibernate.property name="format" type="string" column="FORMAT"
     * @return Returns the format.
     */
    public String getFormat()
    {
        return format;
    }

    /**
     * @param format The format to set.
     */
    public void setFormat(String format)
    {
        this.format = format;
    }

	/**
	 * @see edu.common.dynamicextensions.domaininterface.AttributeTypeInformationInterface#getDataType()
	 */
	public String getDataType()
	{

		return EntityManagerConstantsInterface.DATE_ATTRIBUTE_TYPE;
	}
	
	/**
	 * 
	 */
	public PermissibleValueInterface getPermissibleValueForString(String value) throws ParseException {
		DomainObjectFactory domainObjectFactory = DomainObjectFactory.getInstance();
		DateValueInterface dateValueInterface = domainObjectFactory.createDateValue();
		
		if (format.equals(ProcessorConstants.MONTH_YEAR_FORMAT))
        {
            value = DynamicExtensionsUtility.formatMonthAndYearDate(value);
            value = value.substring(0, value.length()-4);
        }
        if (format.equals(ProcessorConstants.YEAR_ONLY_FORMAT))
        {
            value = DynamicExtensionsUtility.formatYearDate(value);
            value = value.substring(0, value.length()-4);
        }

		Date date = Utility.parseDate(value, "MM-dd-yyyy");
		dateValueInterface.setValue(date);
		return dateValueInterface ;
	}

}