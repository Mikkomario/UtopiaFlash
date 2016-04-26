package utopia.flash.event;

import utopia.inception.handling.Handler;
import utopia.inception.handling.HandlerType;

/**
 * TimerEventListenerHandler informs numerous timerEventListeners about timer events
 * @author Mikko Hilpinen
 * @since 30.11.2014
 */
public class TimerEventListenerHandler extends Handler<TimerEventListener> implements
		TimerEventListener
{
	// ATTRIBUTES	-----------------------------
	
	private AbstractTimer lastSource;
	
	
	// IMPLEMENTED METHODS	--------------------

	@Override
	public void onTimerEvent(AbstractTimer source)
	{
		this.lastSource = source;
		handleObjects(true);
		this.lastSource = null;
	}

	@Override
	public HandlerType getHandlerType()
	{
		return FlashHandlerType.TIMEREVENTLISTENERHANDLER;
	}

	@Override
	protected boolean handleObject(TimerEventListener h)
	{
		h.onTimerEvent(this.lastSource);
		return true;
	}
}
