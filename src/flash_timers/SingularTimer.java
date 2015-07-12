package flash_timers;

import genesis_event.HandlerRelay;

/**
 * SingularTimer is a timer that causes only a single TimerEvent and then dies.
 *
 * @author Mikko Hilpinen.
 * @since 30.11.2013.
 */
public class SingularTimer extends AbstractTimer
{
	// CONSTRUCTOR	-----------------------------------------------------
	
	/**
	 * Creates a new timer that will inform the user about an timer event after 
	 * <i>delay</i> steps.
	 *
	 * @param delay How many steps will pass before the event is thrown
	 * @param id The identifier of the timer, this will be given with the 
	 * thrown event. The user can differentiate events caused by this 
	 * particular timer using this id.
	 * @param handlers The handlers that will handle the timer
	 */
	public SingularTimer(int delay, int id, HandlerRelay handlers)
	{
		super(delay, id, handlers);
	}
	
	
	// IMPLEMENTED METHODS	---------------------------------------------

	@Override
	public void onTimerEvent()
	{
		// SingularTimer can only be used once
		getIsDeadStateOperator().setState(true);
	}
}
