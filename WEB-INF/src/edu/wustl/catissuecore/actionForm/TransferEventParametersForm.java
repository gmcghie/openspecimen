/**
 * <p>Title: TransferEventParametersForm Class</p>
 * <p>Description:  This Class handles the Transfer Event Parameters.
 * <p> It extends the EventParametersForm class.    
 * Copyright:    Copyright (c) 2005
 * Company: Washington University, School of Medicine, St. Louis.
 * @author Mandar Deshmukh
 * @version 1.00
 * Created on July 28th, 2005
 */

package edu.wustl.catissuecore.actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import edu.wustl.catissuecore.domain.TransferEventParameters;
import edu.wustl.catissuecore.util.StorageContainerUtil;
import edu.wustl.catissuecore.util.global.Constants;
import edu.wustl.common.domain.AbstractDomainObject;
import edu.wustl.common.util.global.ApplicationProperties;
import edu.wustl.common.util.global.Validator;
import edu.wustl.common.util.logger.Logger;

/**
 * @author mandar_deshmukh
 *
 *  This Class handles the Transfer Event Parameters.
 */
public class TransferEventParametersForm extends SpecimenEventParametersForm
{

	private static final long serialVersionUID = 1L;

	/**
	 * logger Logger - Generic logger.
	 */
	private static Logger logger = Logger.getCommonLogger(TransferEventParametersForm.class);
	/**
	 * Reference to dimensional position one of the specimen in previous storage container before transfer.
	 */
	protected int fromPositionDimensionOne;

	/**
	 * Reference to dimensional position two of the specimen in previous storage container before transfer.
	 */
	protected int fromPositionDimensionTwo;

	/**
	 * Reference to dimensional position one of the specimen in new storage container after transfer.
	 */
	protected String positionDimensionOne;

	/**
	 * Reference to dimensional position two of the specimen in new storage container after transfer.
	 */
	protected String positionDimensionTwo;

	/**
	 * Storage Container to which the transfer is made. 
	 */
	protected String storageContainer;

	/**
	 * Storage Container from which the transfer is made.
	 */
	protected long fromStorageContainerId;

	/*
	 * Used for getting the TO and FROM Positions from the JSP 
	 */
	protected String fromPosition;

	protected String positionInStorageContainer;

	/**
	 *  Radio button to choose dropdown or map to select storage container.
	 */
	private int stContSelection = 1;
	/**
	 * Storage container name selected from map
	 */
	private String selectedContainerName;
	/**
	 * Storage pos1 selected from map
	 */
	private String pos1;
	/**
	 * Storage pos2 selected from map
	 */
	private String pos2;
	/**
	 * Storage Id selected from map
	 */
	protected String fromPositionData;
	private String containerId;

	/**
	

	/**
	 * Returns the Reference to dimensional position one of the specimen in previous storage container before transfer.
	 * @return fromPositionDimensionOne.
	 */
	public int getFromPositionDimensionOne()
	{
		return this.fromPositionDimensionOne;
	}

	/**
	 * Sets the fromPositionDimensionOne. 
	 * @param fromPositionDimensionOne
	 * Reference to dimensional position one of the specimen in previous storage container before transfer.
	 */
	public void setFromPositionDimensionOne(int fromPositionDimensionOne)
	{
		this.fromPositionDimensionOne = fromPositionDimensionOne;
	}

	/**
	 * Returns the Reference to dimensional position two of the specimen in previous storage container before transfer.
	 * @return fromPositionDimensionTwo.
	 */
	public int getFromPositionDimensionTwo()
	{
		return this.fromPositionDimensionTwo;
	}

	/**
	 * Sets the fromPositionDimensionTwo. 
	 * 
	 * @param fromPositionDimensionTwo
	 * Reference to dimensional position two of the specimen in previous storage container before transfer.
	 */
	public void setFromPositionDimensionTwo(int fromPositionDimensionTwo)
	{
		this.fromPositionDimensionTwo = fromPositionDimensionTwo;
	}

	/**
	 * Returns the Reference to dimensional position one of the specimen in new storage container after transfer.
	 * @return toPositionDimensionOne.
	 */
	public String getPositionDimensionOne()
	{
		return this.positionDimensionOne;
	}

	/**
	 * Sets the toPositionDimensionOne. 
	 * @param toPositionDimensionOne
	 * Reference to dimensional position one of the specimen in new storage container after transfer.
	 */
	public void setPositionDimensionOne(String toPositionDimensionOne)
	{
		this.positionDimensionOne = toPositionDimensionOne;
	}

	/**
	 * Returns the Reference to dimensional position two of the specimen in new storage container after transfer.
	 * @return toPositionDimensionTwo.
	 */
	public String getPositionDimensionTwo()
	{
		return this.positionDimensionTwo;
	}

	/**
	 * Sets the toPositionDimensionTwo. 
	 * @param toPositionDimensionTwo
	 * Reference to dimensional position two of the specimen in new storage container after transfer.
	 */
	public void setPositionDimensionTwo(String toPositionDimensionTwo)
	{
		this.positionDimensionTwo = toPositionDimensionTwo;
	}

	/**
	 * Returns the new StorageContainer.  
	 * @return the new StorageContainer. 
	 */
	public String getStorageContainer()
	{
		return this.storageContainer;
	}

	/**
	 * @param toStorageContainerId
	 *            The to StorageContainerId to set.
	 */
	public void setStorageContainer(String toStorageContainerId)
	{
		this.storageContainer = toStorageContainerId;
	}

	/**
	 * Returns the old StorageContainer. 
	 * @return the old StorageContainer. 
	 */
	public long getFromStorageContainerId()
	{

		return this.fromStorageContainerId;
	}

	/**
	 * @param fromStorageContainer The from StorageContainer to set.
	 */
	public void setFromStorageContainerId(long fromStorageContainerId)
	{
		this.fromStorageContainerId = fromStorageContainerId;
	}

	//	 ----- SUPERCLASS METHODS
	/**
	 * @return TRANSFER_EVENT_PARAMETERS_FORM_ID
	 */
	@Override
	public int getFormId()
	{
		return Constants.TRANSFER_EVENT_PARAMETERS_FORM_ID;
	}

	/**
	 * Populates all the fields from the domain object to the form bean.
	 * @param abstractDomain An AbstractDomain Object  
	 */
	@Override
	public void setAllValues(AbstractDomainObject abstractDomain)
	{
		try
		{
			super.setAllValues(abstractDomain);
			final TransferEventParameters transferEventParametersObject = (TransferEventParameters) abstractDomain;
			if (transferEventParametersObject.getFromStorageContainer() != null)
			{
				this.fromStorageContainerId = transferEventParametersObject
						.getFromStorageContainer().getId().longValue();
				this.fromPositionDimensionOne = transferEventParametersObject
						.getFromPositionDimensionOne().intValue();
				this.fromPositionDimensionTwo = transferEventParametersObject
						.getFromPositionDimensionTwo().intValue();
				this.fromPosition = transferEventParametersObject.getFromStorageContainer()
						.getStorageType().getName()
						+ " : "
						+ this.fromStorageContainerId
						+ " Pos("
						+ this.fromPositionDimensionOne + "," + this.fromPositionDimensionTwo + ")";

			}
			else
			{
				this.fromStorageContainerId = 0;
				this.fromPositionDimensionOne = 0;
				this.fromPositionDimensionTwo = 0;
				this.fromPosition = "Virtual Location";
			}
			this.positionDimensionOne = transferEventParametersObject.getToPositionDimensionOne()
					.toString();
			this.positionDimensionTwo = transferEventParametersObject.getToPositionDimensionTwo()
					.toString();

			this.storageContainer = transferEventParametersObject.getToStorageContainer().getId()
					.toString();

			this.selectedContainerName = transferEventParametersObject.getToStorageContainer()
					.getName();

			this.positionInStorageContainer = transferEventParametersObject.getToStorageContainer()
					.getStorageType().getName()
					+ " : "
					+ this.storageContainer
					+ " Pos("
					+ this.positionDimensionOne
					+ ","
					+ this.positionDimensionTwo + ")";
			this.fromPosition = transferEventParametersObject.getFromStorageContainer()
					.getStorageType().getName()
					+ " : "
					+ this.fromStorageContainerId
					+ " Pos("
					+ this.fromPositionDimensionOne
					+ "," + this.fromPositionDimensionTwo + ")";
		}
		catch (final Exception excp)
		{
			TransferEventParametersForm.logger.error(excp.getMessage(),excp);
			excp.printStackTrace() ;
		}
	}

	/**
	 * Overrides the validate method of ActionForm.
	 * @return error ActionErrors instance
	 * @param mapping Actionmapping instance
	 * @param request HttpServletRequest instance
	 */
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
	{
		final ActionErrors errors = super.validate(mapping, request);
		final Validator validator = new Validator();

		try
		{
			// check the FROM Position
			if (Validator.isEmpty(String.valueOf(this.fromPosition)))
			{
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("errors.item.required",
						ApplicationProperties.getValue("transfereventparameters.fromposition")));
			}

			if (this.stContSelection == 1)
			{
				if (Validator.isEmpty(this.positionDimensionOne)
						|| Validator.isEmpty(this.positionDimensionTwo)
						|| Validator.isEmpty(this.storageContainer))
				{
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("errors.item.required",
							ApplicationProperties.getValue("transfereventparameters.toposition")));
				}
				else
				{
					if (!validator.isNumeric(this.positionDimensionOne, 1)
							|| !validator.isNumeric(this.positionDimensionTwo, 1)
							|| !validator.isNumeric(this.storageContainer, 1))
					{
						errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("errors.item.format",
								ApplicationProperties
										.getValue("transfereventparameters.toposition")));
					}

				}
			}
			else if (this.stContSelection == 2)
			{
				final boolean flag = StorageContainerUtil.checkPos1AndPos2(this.pos1, this.pos2);
				if (flag)
				{
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("errors.item.format",
							ApplicationProperties.getValue("transfereventparameters.toposition")));
				}
			}

		}
		catch (final Exception excp)
		{
			TransferEventParametersForm.logger.error(excp.getMessage(),excp);
			excp.printStackTrace();
		}
		return errors;
	}

	/**
	 * Resets the values of all the fields.
	 */
	@Override
	protected void reset()
	{
		//        super.reset();
		//        this.fromPositionDimensionOne = 0;
		//        this.fromPositionDimensionTwo = 0;
		//        this.positionDimensionOne = 0;
		//        this.positionDimensionTwo = 0;
		//        this.fromStorageContainerId = -1;
		//        this.storageContainer = -1;
		//        this.fromPosition = null;
		//        this.positionInStorageContainer = null;

	}

	/**
	 * @return Returns the fromPosition.
	 */
	public String getFromPosition()
	{
		return this.fromPosition;
	}

	/**
	 * @param fromPosition The fromPosition to set.
	 */
	public void setFromPosition(String fromPosition)
	{
		this.fromPosition = fromPosition;
	}

	/**
	 * @return Returns the toPosition.
	 */
	public String getPositionInStorageContainer()
	{
		return this.positionInStorageContainer;
	}

	/**
	 * @param toPosition The toPosition to set.
	 */
	public void setPositionInStorageContainer(String toPosition)
	{
		this.positionInStorageContainer = toPosition;
	}

	/**
	 * @return Returns the containerId.
	 */
	public String getContainerId()
	{
		return this.containerId;
	}

	/**
	 * @param containerId The containerId to set.
	 */
	public void setContainerId(String containerId)
	{
		this.containerId = containerId;
	}

	/**
	 * @return Returns the pos1.
	 */
	public String getPos1()
	{
		return this.pos1;
	}

	/**
	 * @param pos1 The pos1 to set.
	 */
	public void setPos1(String pos1)
	{
		this.pos1 = pos1;
	}

	/**
	 * @return Returns the pos2.
	 */
	public String getPos2()
	{
		return this.pos2;
	}

	/**
	 * @param pos2 The pos2 to set.
	 */
	public void setPos2(String pos2)
	{
		this.pos2 = pos2;
	}

	/**
	 * @return Returns the selectedContainerName.
	 */
	public String getSelectedContainerName()
	{
		return this.selectedContainerName;
	}

	/**
	 * @param selectedContainerName The selectedContainerName to set.
	 */
	public void setSelectedContainerName(String selectedContainerName)
	{
		this.selectedContainerName = selectedContainerName;
	}

	/**
	 * @return Returns the stContSelection.
	 */
	public int getStContSelection()
	{
		return this.stContSelection;
	}

	/**
	 * @param stContSelection The stContSelection to set.
	 */
	public void setStContSelection(int stContSelection)
	{
		this.stContSelection = stContSelection;
	}

	public String getFromPositionData()
	{
		return this.fromPositionData;
	}

	public void setFromPositionData(String fromPositionData)
	{
		this.fromPositionData = fromPositionData;
	}

	@Override
	public void setAddNewObjectIdentifier(String arg0, Long arg1)
	{
		// TODO Auto-generated method stub

	}
}
