package utopia.flash.event;

/**
 * SingularTimer is a timer that causes only a single TimerEvent and then dies.
 * @author Mikko Hilpinen.
 * @since 30.11.2013.
 */
public class SingularTimer extends AbstractTimer
{
	// CONSTRUCTOR	-----------------------------------------------------
	
	/**
	 * Creates a new timer that will inform the user about an timer event after 
	 * <i>delay</i> steps. Remember to add the timer to a working actor handler.
	 * @param delay How many steps will pass before the event is thrown
	 * particular timer using this id.
	 */
	public SingularTimer(double delay)
	{
		super(delay);
	}
	
	
	// IMPLEMENTED METHODS	---------------------------------------------

	@Override
	public void onTimerEvent()
	{
		// SingularTimer can only be used once
		getIsDeadStateOperator().setState(true);
	}
}
