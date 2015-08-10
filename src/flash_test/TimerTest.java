package flash_test;

import flash_timers.ContinuousTimer;
import flash_timers.RandomTimer;
import flash_timers.SingularTimer;
import flash_timers.TimerEventListener;
import genesis_util.SimpleHandled;
import genesis_util.Vector3D;
import genesis_video.GameWindow;

/**
 * TimerTest tests the timers
 * 
 * @author Mikko Hilpinen
 * @since 30.11.2014
 */
public class TimerTest extends SimpleHandled implements TimerEventListener
{
	// CONSTRUCTOR	-----------------------
	
	private TimerTest()
	{
		super(null);
		
		// The constructor is hidden since the interface is static
	}
	
	
	// IMPLEMENTED METHODS	----------------

	@Override
	public void onTimerEvent(int timerid)
	{
		System.out.println("Timer event from " + timerid);
	}
	
	// MAIN METHOD	-----------------------
	
	/**
	 * Starts the test
	 * @param args not used
	 */
	public static void main(String[] args)
	{
		GameWindow window = new GameWindow(new Vector3D(100, 100), "Test", true, 120, 20);
		TimerTest test = new TimerTest();
		
		new ContinuousTimer(100, 1, window.getHandlerRelay()).getListenerHandler().add(test);
		new RandomTimer(150, 300, 2, window.getHandlerRelay()).getListenerHandler().add(test);
		new SingularTimer(150, 3, window.getHandlerRelay()).getListenerHandler().add(test);
	}
}
