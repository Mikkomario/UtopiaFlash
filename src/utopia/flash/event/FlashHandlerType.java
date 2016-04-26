package utopia.flash.event;

import utopia.inception.handling.HandlerType;

/**
 * FlashHandlerTypes are the handler types introduced in the Utopia Flash module.
 * @author Mikko Hilpinen
 * @since 30.11.2014
 */
public enum FlashHandlerType implements HandlerType
{
	// TODO: Rename
	/**
	 * TimerEventListeners are informed about timer events
	 */
	TIMEREVENTLISTENERHANDLER;

	
	// IMPLEMENTED METHODS	-----------------------------
	
	@Override
	public Class<?> getSupportedHandledClass()
	{
		return TimerEventListener.class;
	}
}
