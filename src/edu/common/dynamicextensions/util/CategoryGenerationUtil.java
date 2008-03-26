
package edu.common.dynamicextensions.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.common.dynamicextensions.domaininterface.AssociationInterface;
import edu.common.dynamicextensions.domaininterface.CategoryEntityInterface;
import edu.common.dynamicextensions.domaininterface.EntityGroupInterface;
import edu.common.dynamicextensions.domaininterface.EntityInterface;
import edu.common.dynamicextensions.domaininterface.userinterface.ContainerInterface;
import edu.common.dynamicextensions.exception.DynamicExtensionsApplicationException;
import edu.common.dynamicextensions.exception.DynamicExtensionsSystemException;
import edu.common.dynamicextensions.util.parser.CategoryCSVConstants;

/**
 * @author kunal_kamble
 *
 */
public class CategoryGenerationUtil
{

	public static EntityInterface getEntity(String entityName, EntityGroupInterface entityGroup)
	{
		EntityInterface entityInterface = entityGroup.getEntityByName(entityName);
		return entityInterface;
	}
	/**
	 * @param multiplicity
	 * @return
	 */
	public static int getMultiplicityInNumbers(String multiplicity)
	{
		int multiplicityI = 1;
		if (multiplicity.equalsIgnoreCase(CategoryCSVConstants.MULTILINE))
		{
			multiplicityI = -1;
		}
		if (multiplicity.equalsIgnoreCase(CategoryCSVConstants.SINGLE))
		{
			multiplicityI = 1;
		}
		return multiplicityI;
	}

	/**
	 * @param containerCollection
	 * @param paths
	 * @param absolutePath
	 * @return
	 * @throws DynamicExtensionsSystemException
	 * @throws DynamicExtensionsApplicationException
	 */
	public static ContainerInterface getRootContainer(List<ContainerInterface> containerCollection, Map<String, List<String>> paths,
			Map<String, List<String>> absolutePath) throws DynamicExtensionsSystemException, DynamicExtensionsApplicationException
	{

		ContainerInterface rootContainer = null;
		for (ContainerInterface containerInterface : containerCollection)
		{
			CategoryEntityInterface categoryEntityInterface = (CategoryEntityInterface) containerInterface.getAbstractEntity();
			if (categoryEntityInterface.getParentCategoryEntity() == null)
			{
				rootContainer = containerInterface;
				break;
			}
		}

		for (String entityName : absolutePath.keySet())
		{
			if (absolutePath.get(entityName).size() == 1)
			{
				CategoryEntityInterface categoryEntityInterface = (CategoryEntityInterface) rootContainer.getAbstractEntity();
				if (!entityName.equals(categoryEntityInterface.getEntity().getName()))
				{
					EntityGroupInterface entityGroup = categoryEntityInterface.getEntity().getEntityGroup();
					EntityInterface entity = entityGroup.getEntityByName(entityName);

					CategoryHelperInterface categoryHelper = new CategoryHelper();
					ContainerInterface newRootContainer = categoryHelper.createCategoryEntityAndContainer(entity, null);
					newRootContainer.setAddCaption(false);

					categoryHelper.associateCategoryContainers(newRootContainer, rootContainer, paths.get(categoryEntityInterface.getEntity()
							.getName()), 1);

					rootContainer = newRootContainer;

				}
			}
		}
		return rootContainer;
	}
	
	/**
	 * @param containerCollection
	 * @param containerCaption
	 * @return
	 */
	public static ContainerInterface getContainer(List<ContainerInterface> containerCollection, String containerCaption)
	{
		ContainerInterface container = null;
		for (ContainerInterface containerInterface : containerCollection)
		{
			if (containerCaption.equals(containerInterface.getCaption()))
			{
				container = containerInterface;
				break;
			}

		}
		return container;
	}
	
	/**
	 * @param containerCollection
	 * @param entityName
	 * @return
	 */
	public static ContainerInterface getContainerWithEntityName(List<ContainerInterface> containerCollection, 
			String entityName)
	{
		ContainerInterface container = null;
		for (ContainerInterface containerInterface : containerCollection)
		{
			CategoryEntityInterface categoryEntity = (CategoryEntityInterface) containerInterface.getAbstractEntity();
			if (entityName.equals(categoryEntity.getEntity().getName()))
			{
				container = containerInterface;
				break;
			}

		}
		return container;
	}
	
	/**
	 * @param containerCollection
	 * @param categoryEntityName
	 * @return
	 */
	public static ContainerInterface getContainerWithCategoryEntityName(List<ContainerInterface> containerCollection, 
			String categoryEntityName)
	{
		ContainerInterface container = null;
		for (ContainerInterface containerInterface : containerCollection)
		{
			if (categoryEntityName.equals(containerInterface.getAbstractEntity().getName()))
			{
				container = containerInterface;
				break;
			}

		}
		return container;
	}
	
	/**
	 * @param paths
	 * @param entityGroup
	 * @return
	 */
	public static Map<String, List<String>> getAssociationList(Map<String, List<String>> paths, 
			EntityGroupInterface entityGroup)
	{
		Map<String, List<String>> listOfPath = new HashMap<String, List<String>>();

		Set<String> entityNames = paths.keySet();
		for (String entityName : entityNames)
		{

			List<String> list = getRelativePath(paths.get(entityName), listOfPath);
			List<String> assocaitionList = new ArrayList<String>();
			Iterator<String> entityNamesIterator = list.iterator();

			String sourceEntityName = entityNamesIterator.next();
			EntityInterface sourcEntity = entityGroup.getEntityByName(sourceEntityName);
			while (entityNamesIterator.hasNext())
			{
				EntityInterface targetEntity = entityGroup.getEntityByName(entityNamesIterator.next());
				for (AssociationInterface associationInterface : sourcEntity.getAssociationCollection())
				{
					if (associationInterface.getTargetEntity() == targetEntity)
					{
						assocaitionList.add(associationInterface.getName());
					}
				}
				sourcEntity = targetEntity;

			}
			listOfPath.put(entityName, assocaitionList);
		}
		return listOfPath;
	}

	/**
	 * This method gets the relative path.
	 * @param entityNameList ordered entities names in the path
	 * @param pathMap 
	 * @return
	 */
	public static List<String> getRelativePath(List<String> entityNameList, Map<String, List<String>> pathMap)
	{
		List<String> newEntityNameList = new ArrayList<String>();
		String lastProcessedEntityName = null;
		for (String entityName : entityNameList)
		{
			if (pathMap.get(entityName) == null)
			{
				newEntityNameList.add(entityName);
			}
			else
			{
				lastProcessedEntityName = entityName;
			}
		}
		if (lastProcessedEntityName != null && !newEntityNameList.contains(lastProcessedEntityName))
		{
			newEntityNameList.add(0, lastProcessedEntityName);
		}

		return newEntityNameList;
	}
	
	
	/**
	 * @param associationNamesMap
	 * @param containerInterface
	 * @return
	 */
	public static List<String> getAssociationNameList(Map<String, List<String>> associationNamesMap, ContainerInterface containerInterface)
	{
		CategoryEntityInterface categoryEntityInterface = (CategoryEntityInterface) containerInterface.getAbstractEntity();
		return associationNamesMap.get(categoryEntityInterface.getEntity().getName());

	}
}
