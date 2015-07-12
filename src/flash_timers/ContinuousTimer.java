package flash_timers;

import genesis_event.HandlerRelay;

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
	 * @param interval How many steps there are between each timer event
	 * @param id The identifier of the timer, this will be given with the 
	 * thrown event. The user can differentiate events caused by this 
	 * particular timer using this id.
	 * @param handlers The handlers that will handle the timer
	 */
	public ContinuousTimer(int interval, int id, HandlerRelay handlers)
	{
		super(interval, id, handlers);
		
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
