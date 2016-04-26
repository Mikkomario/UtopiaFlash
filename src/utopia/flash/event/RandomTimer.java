package utopia.flash.event;

import java.util.Random;

/**
 * RandomTimer works like a ContinuousTimer except that it uses random intervals 
 * instead of static intervals. The user of the timer will be informed at 
 * varying intervals
 * @author Mikko Hilpinen.
 * @since 30.11.2013.
 */
public class RandomTimer extends AbstractTimer
{
	// ATTRIBUTES	-----------------------------------------------------
	
	private Random rand;
	private double minimun, maximum;
	
	
	// CONSTRUCTOR	-----------------------------------------------------

	/**
	 * Creates a new RandomTimer that will start to inform the user about timer 
	 * events at intervals randomised between the given values. Remember to add the timer 
	 * to a working actor handler.
	 * @param mindelay How long is the shortest possible delay before an event 
	 * is thrown (in steps)
	 * @param maxdelay How long is the longest possible delay before an event 
	 * is thrown (in steps)
	 */
	public RandomTimer(double mindelay, double maxdelay)
	{
		super(100);

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

	private double getRandomDelay()
	{
		return this.minimun + this.rand.nextDouble() * (this.maximum - 
				this.minimun);
	}
}
