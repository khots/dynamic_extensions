
package edu.common.dynamicextensions.domain.userinterface;

import edu.common.dynamicextensions.domaininterface.CategoryAssociationInterface;
import edu.common.dynamicextensions.domaininterface.userinterface.CategoryAssociationControlInterface;
import edu.common.dynamicextensions.exception.DynamicExtensionsSystemException;

/**
 * This Class represents the category.
 * @hibernate.joined-subclass table="DYEXTN_CATEGORY_ASSOCIATION_CONTROL"
 * @hibernate.joined-subclass-key column="IDENTIFIER"
 */
public class CategoryAssociationControl extends AbstractContainmentControl implements CategoryAssociationControlInterface
{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 */
	public CategoryAssociationControl()
	{
		super();
	}

	/**
	 * This method returns true if the cardinality of the Containment Association is One to Many.
	 * @return true if Caridnality is One to Many, false otherwise.
	 */
	public boolean isCardinalityOneToMany()
	{
		boolean isOneToMany = false;
		CategoryAssociationInterface associationInterface = (CategoryAssociationInterface) this.getBaseAbstractAttribute();
		if (associationInterface.getCategoryEntity().getNumberOfEntries() == -1)
		{
			isOneToMany = true;
		}
		return isOneToMany;
	}

}
