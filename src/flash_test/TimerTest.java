package flash_test;

import flash_timers.ContinuousTimer;
import flash_timers.RandomTimer;
import flash_timers.SingularTimer;
import flash_timers.TimerEventListener;
import genesis_event.ActorHandler;
import genesis_util.StateOperator;
import genesis_util.Vector2D;
import genesis_video.GameWindow;
import genesis_video.MainPanel.ScreenSplit;

/**
 * TimerTest tests the timers
 * 
 * @author Mikko Hilpinen
 * @since 30.11.2014
 */
public class TimerTest implements TimerEventListener
{
	// ATTRIBUTES	----------------------
	
	private StateOperator isDeadOperator;
	
	
	// CONSTRUCTOR	-----------------------
	
	private TimerTest()
	{
		// The constructor is hidden since the interface is static¨
		this.isDeadOperator = new StateOperator(false, true);
	}
	
	
	// IMPLEMENTED METHODS	----------------

	@Override
	public StateOperator getIsDeadStateOperator()
	{
		return this.isDeadOperator;
	}

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
		GameWindow window = new GameWindow(new Vector2D(100, 100), "Test", true, 120, 20, 
				ScreenSplit.HORIZONTAL, false);
		ActorHandler actorHandler = new ActorHandler(true, window.getHandlerRelay());
		TimerTest test = new TimerTest();
		new ContinuousTimer(100, 1, actorHandler, test);
		new RandomTimer(150, 300, 2, actorHandler, test);
		new SingularTimer(150, 3, actorHandler, test);
	}
}
