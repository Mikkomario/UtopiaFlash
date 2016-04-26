package utopia.flash.test;

import utopia.flash.event.AbstractTimer;
import utopia.flash.event.ContinuousTimer;
import utopia.flash.event.RandomTimer;
import utopia.flash.event.SingularTimer;
import utopia.flash.event.TimerEventListener;
import utopia.genesis.event.StepHandler;
import utopia.inception.util.SimpleHandled;

/**
 * TimerTest tests the timers
 * @author Mikko Hilpinen
 * @since 30.11.2014
 */
class TimerTest extends SimpleHandled implements TimerEventListener
{
	// CONSTRUCTOR	-----------------------
	
	private TimerTest()
	{	
		// The constructor is hidden since the interface is static
	}
	
	
	// IMPLEMENTED METHODS	----------------

	@Override
	public void onTimerEvent(AbstractTimer timer)
	{
		System.out.println("Timer event from " + timer.getClass().getSimpleName());
	}
	
	// MAIN METHOD	-----------------------
	
	/**
	 * Starts the test
	 * @param args not used
	 */
	public static void main(String[] args)
	{
		StepHandler stepHandler = new StepHandler(120, 20);
		TimerTest test = new TimerTest();
		
		AbstractTimer continuous = new ContinuousTimer(100);
		AbstractTimer random = new RandomTimer(150, 300);
		AbstractTimer single = new SingularTimer(150);
		
		continuous.getListenerHandler().add(test);
		random.getListenerHandler().add(test);
		single.getListenerHandler().add(test);
		
		stepHandler.add(continuous);
		stepHandler.add(single);
		stepHandler.add(random);
		
		single.setDelay(200);
		random.setDelay(200.5);
		
		stepHandler.start();
	}
}
