/**
 * 
 */

package edu.common.dynamicextensions.ui.webui.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import edu.common.dynamicextensions.domaininterface.AbstractAttributeInterface;
import edu.common.dynamicextensions.domaininterface.userinterface.ContainerInterface;
import edu.common.dynamicextensions.domaininterface.userinterface.ControlInterface;
import edu.common.dynamicextensions.domaininterface.validationrules.RuleInterface;
import edu.common.dynamicextensions.exception.DynamicExtensionsSystemException;
import edu.wustl.common.util.global.ApplicationProperties;

/**
 * @author chetan_patil
 *
 */
public class UserInterfaceiUtility
{

	/**
	 * 
	 * @param stringBuffer
	 * @param controlInterface
	 * @param containerInterface
	 * @throws DynamicExtensionsSystemException
	 */
	@SuppressWarnings("unchecked")
	public static String generateHTMLforGrid(ContainerInterface subContainer) throws DynamicExtensionsSystemException
	{
		StringBuffer stringBuffer = new StringBuffer();
		List<ControlInterface> controlsList = new ArrayList<ControlInterface>(subContainer.getControlCollection());
		Collections.sort(controlsList);

		stringBuffer.append("<tr width='100%'><td class='formRequiredNotice'>&nbsp;</td>");
		stringBuffer.append("<td colspan='2' class='formField'>");
		stringBuffer.append("<div style='display:none' id='" + subContainer.getId() + "_substitutionDiv'>");
		stringBuffer.append("<table>");
		stringBuffer.append("<tr width='100%'>");
		stringBuffer.append("<td class='formRequiredNotice' width='1%'>&nbsp;</td>");
		for (ControlInterface control : controlsList)
		{
			control.setIsSubControl(true);
			stringBuffer.append("<td class='formField'>");
			stringBuffer.append(control.generateHTML());
			stringBuffer.append("</td>");
		}
		stringBuffer.append("</tr>");
		stringBuffer.append("</table>");
		stringBuffer.append("</div>");

		stringBuffer.append("<input type='hidden' name='" + subContainer.getId() + "_rowCount' id= '" + subContainer.getId()
				+ "_rowCount' value='0'/> ");
		stringBuffer.append("</td></tr>");

		stringBuffer.append("<tr width='100%'>");
		stringBuffer.append("<td class='formRequiredNotice' align='left'>&nbsp;</td>");
		stringBuffer.append("<td class='formField' colspan='2' align='center'>");
		stringBuffer.append("<table cellpadding='3' cellspacing='0' align='center' width='100%'>");

		stringBuffer.append("<tr width='100%'>");
		stringBuffer.append("<td class='formTitle' colspan='3' align='left'>");
		stringBuffer.append(subContainer.getCaption());
		stringBuffer.append("</td>");
		stringBuffer.append("</tr>");

		stringBuffer.append("<tr width='100%'>");
		stringBuffer.append("<td class='formField' colspan='3'>");
		stringBuffer.append("<table id='" + subContainer.getId() + "_table' cellpadding='3' cellspacing='0' align='center' width='100%'>");

		stringBuffer.append("<tr width='100%'>");
		stringBuffer.append("<th class='formRequiredNotice' width='1%'>");
		stringBuffer.append("<input type='checkbox' name='dummy' disabled/>");
		stringBuffer.append("</th>");
		for (ControlInterface control : controlsList)
		{
			boolean isControlRequired = isControlRequired(control);
			if (isControlRequired)
			{
				stringBuffer.append("<th class='formRequiredLabel'>");
				stringBuffer.append(subContainer.getRequiredFieldIndicatior() + "&nbsp;" + control.getCaption());
			}
			else
			{
				stringBuffer.append("<th class='formLabel'>");
				stringBuffer.append("&nbsp;" + control.getCaption());
			}
			stringBuffer.append("</th>");
		}

		stringBuffer.append("<th class='formLabel' align='center'>");
		stringBuffer.append("<button type='button' class='actionButton' id='addMore' onclick=\"addRow('" + subContainer.getId() + "')\">");
		stringBuffer.append(ApplicationProperties.getValue("eav.button.AddRow"));
		stringBuffer.append("</button>");
		stringBuffer.append("</th>");
		stringBuffer.append("</tr>");
		stringBuffer.append("</table>");
		stringBuffer.append("<table><tr><td class='formRequiredLabel'>&nbsp;</td>");
		stringBuffer.append("<td>");
		stringBuffer
				.append("<button type='button' class='actionButton' id='removeRow' onclick=\"removeCheckedRow('" + subContainer.getId() + "')\">");
		stringBuffer.append(ApplicationProperties.getValue("buttons.delete"));
		stringBuffer.append("</button>");
		stringBuffer.append("</td></tr></table>");

		stringBuffer.append("</td>");
		stringBuffer.append("</tr>");

		stringBuffer.append("</table></td></tr>");

		return stringBuffer.toString();
	}

	/**
	 * 
	 * @param controlInterface
	 * @return
	 */
	public static boolean isControlRequired(ControlInterface controlInterface)
	{
		AbstractAttributeInterface abstractAttribute = controlInterface.getAbstractAttribute();
		Collection<RuleInterface> ruleCollection = abstractAttribute.getRuleCollection();
		boolean required = false;
		if (ruleCollection != null && !ruleCollection.isEmpty())
		{
			for (RuleInterface attributeRule : ruleCollection)
			{
				if (attributeRule.getName().equals("required"))
				{
					required = true;
					break;
				}
			}
		}
		return required;
	}

}
