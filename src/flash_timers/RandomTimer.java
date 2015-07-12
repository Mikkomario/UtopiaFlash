package flash_timers;

import genesis_event.HandlerRelay;

import java.util.Random;

/**
 * RandomTimer works like a ContinuousTimer except that it uses random intervals 
 * instead of static intervals. The user of the timer will be informed at 
 * varying intervals
 *
 * @author Mikko Hilpinen.
 *         Created 30.11.2013.
 */
public class RandomTimer extends AbstractTimer
{
	// ATTRIBUTES	-----------------------------------------------------
	
	private Random rand;
	private int minimun, maximum;
	
	
	// CONSTRUCTOR	-----------------------------------------------------

	/**
	 * Creates a new RandomTimer that will start to inform the user about timer 
	 * events at intervals randomized between the given values.
	 *
	 * @param mindelay How long is the shortest possible delay before an event 
	 * is thrown (in steps)
	 * @param maxdelay How long is the longest possible delay before an event 
	 * is thrown (in steps)
	 * @param id The identifier of the timer, this will be given with the 
	 * thrown event. The user can differentiate events caused by this 
	 * particular timer using this id.
	 * @param handlers The handlers that will handle the timer
	 */
	public RandomTimer(int mindelay, int maxdelay, int id, HandlerRelay handlers)
	{
		super(100, id, handlers);

		// Initializes attributes
		this.rand = new Random();
		this.minimun = mindelay;
		this.maximum = maxdelay;
		
		// Randomizes the delay
		setDelay(getRandomDelay());
	}
	
	
	// IMPLEMENTED METHODS	---------------------

	@Override
	public void onTimerEvent()
	{
		// Randomizes the delay
		setDelay(getRandomDelay());
	}
	
	
	// OTHER METHODS	--------------------------------------------------

	private int getRandomDelay()
	{
		return this.minimun + this.rand.nextInt(this.maximum - 
				this.minimun + 1);
	}
}
