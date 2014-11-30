package flash_timers;

import genesis_event.HandlerType;

/**
 * FlashHandlerTypes are handlerTypes introduced in the Utopia Flash module.
 * 
 * @author Mikko Hilpinen
 * @since 30.11.2014
 */
public enum FlashHandlerType implements HandlerType
{
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
