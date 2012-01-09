
package edu.common.dynamicextensions.importer.xml;

import java.util.Date;

import edu.common.dynamicextensions.domain.DomainObjectFactory;
import edu.common.dynamicextensions.domaininterface.AttributeInterface;
import edu.common.dynamicextensions.domaininterface.EntityInterface;
import edu.common.dynamicextensions.exception.DynamicExtensionsApplicationException;
import edu.common.dynamicextensions.importer.jaxb.Attribute;
import edu.common.dynamicextensions.ui.util.Constants;
import edu.common.metadata.ClassMetadata;

/**
 * @author Kunal
 * Processes the Attribute tag from simplifiedMetadataXml.xsd
 *
 */
public class AttributeTypeProcessor
{

	/**
	 * DE entity used for persisting metadata 
	 */
	private EntityInterface entity;

	/**
	 * Hibernate metadata of the class
	 */
	private ClassMetadata classMetadata;

	public AttributeTypeProcessor(EntityInterface entity, ClassMetadata classMetadata)
	{
		this.entity = entity;
		this.classMetadata = classMetadata;
	}

	public void process(Attribute attribute) throws DynamicExtensionsApplicationException
	{
		//Step 1: Creates if attribute with name is not found in the entity
		AttributeInterface attributeInterface = getAttribute(attribute);

		//Step 2: Update entity references
		entity.addAttribute(attributeInterface);
		attributeInterface.setEntity(entity);

		//Step 3: Update the name in the Attribute class
		attributeInterface.setName(attribute.getName());

		//Step 4: Set default values if any, these values are note provided in the xml
		setDefault(attributeInterface);

		//Step 5: Set all the primitive attributes of the Attribute class
		setPrimitiveAttributes(attributeInterface);

		//Step 6: Set the column name.
		setColumnProperties(attributeInterface);

	}

	private AttributeInterface getAttribute(Attribute attribute)
			throws DynamicExtensionsApplicationException
	{
		AttributeInterface attributeInterface = null;
		if (classMetadata.getProperty(attribute.getName()) != null )
		{
			attributeInterface = entity.getAttributeByName(attribute.getName());
			if(attributeInterface == null)
			{
				DomainObjectFactory.getInstance().createAttribute(
						classMetadata.getProperty(attribute.getName()).getPropertyType());
			}
			
		}
		else
		{
			throw new DynamicExtensionsApplicationException("Attribute " + attribute.getName()
					+ " does not exist in hbm.");
		}
		return attributeInterface;
	}

	private void setColumnProperties(AttributeInterface attributeInterface)
	{
		attributeInterface.getColumnProperties().setName(
				classMetadata.getProperty(attributeInterface.getName()).getColumnName());
	}

	private void setPrimitiveAttributes(AttributeInterface attributeInterface)
	{
		attributeInterface.setIsPrimaryKey(attributeInterface.getName().equals(
				classMetadata.getIdMetadata().getPropertyName()));
	}

	private void setDefault(AttributeInterface attributeInterface)
	{
		attributeInterface.setActivityStatus(Constants.ACTIVE);
		attributeInterface.setCreatedDate(new Date());
	}

}
