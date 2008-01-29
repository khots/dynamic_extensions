
package edu.common.dynamicextensions.domaininterface;

/**
 * 
 * @author mandar_shidhore
 *
 */
public interface CategoryAttributeInterface extends BaseAbstractAttributeInterface
{
	/**
	 *
	 * @return
	 */
	public AttributeInterface getAttribute();

	/**
	 *
	 * @param attribute
	 */
	public void setAttribute(AttributeInterface attribute);

	/**
	 *
	 * @return
	 */
	public CategoryEntityInterface getCategoryEntity();

	/**
	 *
	 * @param categoryEntityInterface
	 */
	public void setCategoryEntity(CategoryEntityInterface categoryEntityInterface);

	/**
	 * 
	 * @return
	 */
	public String getDefaultValue();

	/**
	 * 
	 * @param permissibleValueInterface
	 */
	public void setDefaultValue(PermissibleValueInterface permissibleValueInterface);

	/**
	 * 
	 * @param dataElementInterface
	 */
	public void setDataElement(DataElementInterface dataElementInterface);

}
