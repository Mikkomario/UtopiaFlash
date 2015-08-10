package flash_timers;

import genesis_event.Handler;
import genesis_event.HandlerType;

/**
 * TimerEventListenerHandler informs numerous timerEventListeners about timer events
 * 
 * @author Mikko Hilpinen
 * @since 30.11.2014
 */
public class TimerEventListenerHandler extends Handler<TimerEventListener> implements
		TimerEventListener
{
	// ATTRIBUTES	-----------------------------
	
	private int lastTimerID;
	
	
	// CONSTRUCTOR	-----------------------------
	
	/**
	 * Creates a new handler
	 * @param autoDeath Will the handler die once it runs out of handleds
	 */
	public TimerEventListenerHandler(boolean autoDeath)
	{
		super(autoDeath);
	}
	
	
	// IMPLEMENTED METHODS	--------------------

	@Override
	public void onTimerEvent(int timerid)
	{
		this.lastTimerID = timerid;
		handleObjects(true);
	}

	@Override
	public HandlerType getHandlerType()
	{
		return FlashHandlerType.TIMEREVENTLISTENERHANDLER;
	}

	@Override
	protected boolean handleObject(TimerEventListener h)
	{
		h.onTimerEvent(this.lastTimerID);
		return true;
	}
}
