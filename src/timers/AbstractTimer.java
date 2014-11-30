package timers;

import genesis_event.Actor;
import genesis_event.ActorHandler;
import genesis_util.LatchStateOperator;
import genesis_util.StateOperator;
import genesis_util.StateOperatorListener;

/**
 * AbstractTimer informs an object about the passing of time. Different Timers 
 * may inform the object differently. once or repeatedly, for example.
 *
 * @author Mikko Hilpinen.
 * @since 30.11.2013.
 */
public abstract class AbstractTimer implements Actor, StateOperatorListener
{
	// ATTRIBUTES	-----------------------------------------------------
	
	private TimerEventListenerHandler listenerHandler;
	private double timeleft;
	private StateOperator isDeadOperator, activeStateOperator;
	private int id;
	
	
	// CONSTRUCTOR	-----------------------------------------------------
	
	/**
	 * Creates a new timer and sets it to inform an user after delay steps.
	 *
	 * @param user The listener that the timer will inform about the event(s) (optional)
	 * @param delay The delay before the event
	 * @param actorhandler The handler which will inform the timer about 
	 * act-events, null if the timer will be handled manually
	 * @param id The identifier of the timer, this will be given with the 
	 * thrown event. The user can differentiate events caused by this 
	 * particular timer using this id.
	 */
	public AbstractTimer(int delay, int id,
			ActorHandler actorhandler, TimerEventListener user)
	{
		// Initializes attributes
		this.timeleft = delay;
		this.id = id;
		this.listenerHandler = new TimerEventListenerHandler(false);
		this.isDeadOperator = new LatchStateOperator(false);
		this.activeStateOperator = new StateOperator(true, true);
		
		// Adds the object to the handler
		if (actorhandler != null)
			actorhandler.add(this);
		this.isDeadOperator.getListenerHandler().add(this);
		if (user != null)
			this.listenerHandler.add(user);
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
			this.listenerHandler.onTimerEvent(this.id);
			// Also informs the subclass if it wants to react somehow
			onTimerEvent();
		}
	}
	
	@Override
	public StateOperator getIsDeadStateOperator()
	{
		return this.isDeadOperator;
	}

	@Override
	public void onStateChange(StateOperator source, boolean newState)
	{
		if (source == getIsDeadStateOperator() && newState)
		{
			// Clear listener handler first
			this.listenerHandler.removeAllHandleds();
			this.listenerHandler.getIsDeadStateOperator().setState(true);
		}
	}

	@Override
	public StateOperator getIsActiveStateOperator()
	{
		return this.activeStateOperator;
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
	 *
	 * @param delay How many steps the event will be dalayed
	 */
	protected void delay(int delay)
	{
		this.timeleft += delay;
	}
	
	/**
	 * Sets the event to be caused after <i>delay</i> steps
	 *
	 * @param delay How many steps there will be before an event is thrown
	 */
	public void setDelay(int delay)
	{
		this.timeleft = delay;
	}
}
