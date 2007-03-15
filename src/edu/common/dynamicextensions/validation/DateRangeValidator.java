
package edu.common.dynamicextensions.validation;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.common.dynamicextensions.domain.DateAttributeTypeInformation;
import edu.common.dynamicextensions.domaininterface.AttributeInterface;
import edu.common.dynamicextensions.domaininterface.AttributeTypeInformationInterface;
import edu.common.dynamicextensions.exception.DynamicExtensionsValidationException;
import edu.wustl.common.util.Utility;

/**
 * @author chetan_patil
 *
 */
public class DateRangeValidator implements ValidatorRuleInterface
{

	/**
	 * @see edu.common.dynamicextensions.validation.ValidatorRuleInterface#validate(edu.common.dynamicextensions.domaininterface.AttributeInterface, java.lang.Object, java.util.Map)
	 * @throws DynamicExtensionsValidationException
	 */
	public boolean validate(AttributeInterface attribute, Object valueObject,
			Map<String, String> parameterMap) throws DynamicExtensionsValidationException
	{
		boolean valid = true;

		/* Check for the validity of the date */
		DateValidator dateValidator = new DateValidator();
		dateValidator.validate(attribute, valueObject, parameterMap);

		AttributeTypeInformationInterface attributeTypeInformation = attribute
				.getAttributeTypeInformation();
		if (((valueObject != null) && (!((String) valueObject).trim().equals("")))
				&& ((attributeTypeInformation != null))
				&& (attributeTypeInformation instanceof DateAttributeTypeInformation))
		{
			DateAttributeTypeInformation dateAttributeTypeInformation = (DateAttributeTypeInformation) attributeTypeInformation;
			String dateFormat = dateAttributeTypeInformation.getFormat();
			String attributeName = attribute.getName();
			String value = (String) valueObject;

			Set<Map.Entry<String, String>> parameterSet = parameterMap.entrySet();
			for (Map.Entry<String, String> parameter : parameterSet)
			{
				String parameterName = parameter.getKey();
				String parameterValue = parameter.getValue();
				Date parameterDate = null, valueDate = null;
				try
				{
					parameterDate = Utility.parseDate(parameterValue, dateFormat);
					valueDate = Utility.parseDate(value, dateFormat);
				}
				catch (ParseException ParseException)
				{
					List<String> placeHolders = new ArrayList<String>();
					placeHolders.add(attributeName);
					placeHolders.add(dateFormat);
					throw new DynamicExtensionsValidationException("Validation failed", null,
							"dynExtn.validation.Date", placeHolders);
				}

				if (parameterName.equals("min"))
				{
					checkMinDate(parameterDate, valueDate, attributeName, parameterValue);
				}
				else if (parameterName.equals("max"))
				{
					checkMaxDate(parameterDate, valueDate, attributeName, parameterValue);
				}
			}
		}
		return valid;
	}

	private void checkMinDate(Date parameterDate, Date valueDate, String attributeName, String parameterValue)
			throws DynamicExtensionsValidationException
	{
		if (valueDate.before(parameterDate))
		{
			List<String> placeHolders = new ArrayList<String>();
			placeHolders.add(attributeName);

			placeHolders.add(parameterValue);
			throw new DynamicExtensionsValidationException("Validation failed", null,
					"dynExtn.validation.Date.Min", placeHolders);
		}
	}

	private void checkMaxDate(Date parameterDate, Date valueDate, String attributeName, String parameterValue)
			throws DynamicExtensionsValidationException
	{
		if (valueDate.after(parameterDate))
		{
			List<String> placeHolders = new ArrayList<String>();
			placeHolders.add(attributeName);

			placeHolders.add(parameterValue);
			throw new DynamicExtensionsValidationException("Validation failed", null,
					"dynExtn.validation.Date.Max", placeHolders);
		}
	}

}
