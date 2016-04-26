package utopia.flash.event;

/**
 * ContinuousTimer will inform the user about timer events constantly after 
 * certain intervals.
 * @author Mikko Hilpinen.
 * @since 30.11.2013.
 */
public class ContinuousTimer extends AbstractTimer
{
	// ATTRIBUTES	------------------------------------------------------
	
	private double interval;
	
	
	// CONSTRUCTOR	------------------------------------------------------
	
	/**
	 * Creates a new timer that will start to inform the user at given intervals. Remember 
	 * to add the timer to a working actor handler.
	 * @param interval How many steps there are between each timer event
	 * thrown event. The user can differentiate events caused by this 
	 * particular timer using this id.
	 */
	public ContinuousTimer(double interval)
	{
		super(interval);
		
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
