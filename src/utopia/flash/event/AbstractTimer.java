package utopia.flash.event;

import utopia.genesis.event.Actor;
import utopia.inception.state.StateOperator;
import utopia.inception.state.StateOperatorListener;
import utopia.inception.util.SimpleHandled;

/**
 * AbstractTimer informs an object about the passing of time. Different Timers 
 * may inform the object differently. once or repeatedly, for example.
 * @author Mikko Hilpinen.
 * @since 30.11.2013
 */
public abstract class AbstractTimer extends SimpleHandled implements Actor, 
		StateOperatorListener
{
	// ATTRIBUTES	-----------------------------------------------------
	
	private TimerEventListenerHandler listenerHandler;
	private double timeleft;
	
	
	// CONSTRUCTOR	-----------------------------------------------------
	
	/**
	 * Creates a new timer and sets it to inform the listeners after delay steps. Remember 
	 * to add the timer to a working actor handler.
	 * @param delay The delay before the event
	 */
	public AbstractTimer(double delay)
	{
		// Initializes attributes
		this.timeleft = delay;
		this.listenerHandler = new TimerEventListenerHandler();
		
		getIsDeadStateOperator().getListenerHandler().add(this);
	}
	
	
	// ABSTRACT METHODS	-------------------------------------------------
	
	/**
	 * This method is called when the timer informs the user about an timer 
	 * event. The subclass should react to this event either by resetting or 
	 * stopping the timer
	 */
	protected abstract void onTimerEvent();
	
	
	// IMPELENTED METHODS	---------------------------------------------

	@Override
	public void act(double steps)
	{
		// Depletes the timer and may inform the user if the delay has passed
		this.timeleft -= steps;
		
		if (this.timeleft <= 0)
		{
			this.listenerHandler.onTimerEvent(this);
			// Also informs the subclass if it wants to react somehow
			onTimerEvent();
		}
	}

	@Override
	public void onStateChange(StateOperator source, boolean newState)
	{
		if (source == getIsDeadStateOperator() && newState)
		{
			// Clears listener handler and kills it
			this.listenerHandler.removeAllHandleds();
			this.listenerHandler.getIsDeadStateOperator().setState(true);
		}
	}
	
	
	// GETTERS & SETTERS	-------------------------
	
	/**
	 * @return The listener handler that informs objects about events in this timer
	 */
	public TimerEventListenerHandler getListenerHandler()
	{
		return this.listenerHandler;
	}
	
	
	// OTHER METHODS	--------------------------------------------------
	
	/**
	 * Delays the event by <i>delay</i> steps
	 * @param delay How many steps the event will be delayed
	 */
	protected void delay(double delay)
	{
		this.timeleft += delay;
	}
	
	/**
	 * Sets the event to be caused after <i>delay</i> steps
	 * @param delay How many steps there will be before an event is generated
	 */
	public void setDelay(double delay)
	{
		this.timeleft = delay;
	}
}
