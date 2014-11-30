package flash_timers;

import genesis_event.ActorHandler;

/**
 * ContinuousTimer will inform the user about timer events constantly after 
 * certain intervals.
 *
 * @author Mikko Hilpinen.
 * @since 30.11.2013.
 */
public class ContinuousTimer extends AbstractTimer
{
	// ATTRIBUTES	------------------------------------------------------
	
	private int interval;
	
	
	// CONSTRUCTOR	------------------------------------------------------
	
	/**
	 * Creates a new timer that will start to inform the user at given intervals
	 *
	 * @param user The timer listener that will be informed about the timer 
	 * events (optional)
	 * @param interval How many steps there are between each timer event
	 * @param actorhandler The actorhandler that will inform the timer about 
	 * steps (optional)
	 * @param id The identifier of the timer, this will be given with the 
	 * thrown event. The user can differentiate events caused by this 
	 * particular timer using this id.
	 */
	public ContinuousTimer(int interval, int id, 
			ActorHandler actorhandler, TimerEventListener user)
	{
		super(interval, id, actorhandler, user);
		
		// Initializes attributes
		this.interval = interval;
	}
	
	
	// IMPLEMENTED METHODS	--------------------------------------------

	@Override
	public void onTimerEvent()
	{
		// Resets the timer
		delay(this.interval);
	}
	
	
	// OTHER METHODS	------------------------------------------------
	
	/**
	 * Resets the timer back to the start of the delay as if a cycle had just 
	 * ended
	 */
	public void reset()
	{
		setDelay(this.interval);
	}
}
