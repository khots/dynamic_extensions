/*
 * Created on Nov 15, 2006
 * @author
 *
 */
package edu.common.dynamicextensions.ui.webui.actionform;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import edu.common.dynamicextensions.processor.ProcessorConstants;
import edu.common.dynamicextensions.ui.interfaces.GroupUIBeanInterface;
import edu.wustl.common.actionForm.AbstractActionForm;
import edu.wustl.common.domain.AbstractDomainObject;
import edu.wustl.common.util.global.ApplicationProperties;
import edu.wustl.common.util.global.Validator;

/**
 * @author preeti_munot
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class GroupForm extends AbstractActionForm implements GroupUIBeanInterface
{
	protected String createGroupAs;
	protected String groupName;
	protected String groupDescription; 
	protected List groupList;
	protected String groupOperation;
	public String getGroupOperation()
	{
		return this.groupOperation;
	}
	public void setGroupOperation(String groupOperation)
	{
		this.groupOperation = groupOperation;
	}
	public List getGroupList()
	{
		return this.groupList;
	}
	public void setGroupList(List groupList)
	{
		this.groupList = groupList;
	}
	public GroupForm()
	{
		this.createGroupAs=ProcessorConstants.DEFAULT_GROUP_CREATEAS;
	}
	public String getCreateGroupAs()
	{
		return this.createGroupAs;
	}

	public void setCreateGroupAs(String createGroupAs)
	{
		this.createGroupAs = createGroupAs;
	}

	public String getGroupDescription()
	{
		return this.groupDescription;
	}

	public void setGroupDescription(String groupDescription)
	{
		this.groupDescription = groupDescription;
	}

	public String getGroupName()
	{
		return this.groupName;
	}

	public void setGroupName(String groupName)
	{
		this.groupName = groupName;
	}

	/* (non-Javadoc)
	 * @see edu.wustl.common.actionForm.AbstractActionForm#getFormId()
	 */
	@Override
	public int getFormId()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see edu.wustl.common.actionForm.AbstractActionForm#reset()
	 */
	@Override
	protected void reset()
	{
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see edu.wustl.common.actionForm.AbstractActionForm#setAllValues(edu.wustl.common.domain.AbstractDomainObject)
	 */
	@Override
	public void setAllValues(AbstractDomainObject arg0)
	{
		// TODO Auto-generated method stub

	}
	/**
	 * Overrides the validate method of ActionForm.
	 * @param mapping ActionMapping mapping
	 * @param request HttpServletRequest request
	 * @return ActionErrors ActionErrors
	 */
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
	{
		ActionErrors errors = new ActionErrors();
		Validator validator = new Validator();

		if (groupName == null || validator.isEmpty(String.valueOf(groupName)))
		{
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("errors.item.required", ApplicationProperties.getValue("eav.att.GroupTitle")));
		}
		if (createGroupAs == null)
		{
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("errors.item.required", ApplicationProperties.getValue("eav.att.NewGroup")));
		}
		return errors;
	}

}
