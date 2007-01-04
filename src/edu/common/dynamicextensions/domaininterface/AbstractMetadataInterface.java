
package edu.common.dynamicextensions.domaininterface;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * This is an interface extended by EntityInterface,EntityGroupInterface,AttributeInterface.This interface contains
 * basic information needed for each metadata objects. 
 * @author sujay_narkar
 *
 */
public interface AbstractMetadataInterface 
{

	/**
	 * This method returns the Created Date of the AbstractMetadata.
	 * @return the createdDate of the AbstractMetadata.
	 */
	Date getCreatedDate();

	/**
	 * This method sets the Created Date of the AbstractMetadata.
	 * @param createdDate The createdDate to set.
	 */
	void setCreatedDate(Date createdDate);

	/**
	 * This method returns the description of the AbstractMetadata.
	 * @return the description of the AbstractMetadata.
	 */
	String getDescription();

	/**
	 * This method sets the description of the AbstractMetadata.
	 * @param description The description to set.
	 */
	void setDescription(String description);

	/**
	 * This method returns the unique identifier of the AbstractMetadata.
	 * @return the identifier of the AbstractMetadata.
	 */
	Long getId();

	/**
	 * This method sets the unique identifier of the AbstractMetadata.
	 * @param id The identifier to set.
	 */
	void setId(Long id);

	/**
	 * The last updated date of metadata object.
	 * @return Returns the lastUpdated.
	 */
	Date getLastUpdated();

	/**
	 * The method sets the date of last updation of the meta data to the given date.
	 * @param lastUpdated the date to be set as last updation date.
	 */
	void setLastUpdated(Date lastUpdated);

	/**
	 * This method returns the name of the AbstractMetadata.
	 * @return the name of the AbstractMetadata.
	 */
	String getName();

	/**
	 * This method sets the name of the AbstractMetadata to the given name.
	 * @param name the name to be set.
	 */
	void setName(String name);

	/**
	 * This method returns the Collection of SemanticProperties of the AbstractMetadata.
	 * @return the Collection of SemanticProperties of the AbstractMetadata.
	 */
	Collection<SemanticPropertyInterface> getSemanticPropertyCollection();

	/**
	 * This method adds a SemanticProperty to the AbstractMetadata.
	 * @param semanticPropertyInterface A SemanticProperty to be added.
	 */
	void addSemanticProperty(SemanticPropertyInterface semanticProperty);
	
	/**
	 * This method removes a SemanticProperty from the AbstractMetadata.
	 * @param semanticPropertyInterface A SemanticProperty to be removed.
	 */
	public void removeSemanticProperty(SemanticPropertyInterface semanticPropertyInterface);
	
	/**
	 * This method removes all SemanticProperties from AbstractMetadata.
	 */
	public void removeAllSemanticProperties();
    /**
     * 
     * @return
     */
    Collection<TaggedValueInterface> getTaggedValueCollection();
    /**
     * Setter method for taggedValueCollection
     * @param taggedValueCollection Collection of tagged values.
     */
    void setTaggedValueCollection(
            Collection<TaggedValueInterface> taggedValueCollection);
   
    /**
     * 
     * @param taggedValueInterface
     */
    void addTaggedValue(TaggedValueInterface taggedValueInterface);
    
    /**
     * Method returns sorted semantic properties based on the sequence number.
     * @return
     */
    List getOrderedSemanticPropertyCollection();

}
