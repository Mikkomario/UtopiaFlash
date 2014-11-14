package timers;

import genesis_logic.LogicalHandled;

/**
 * TimerEventListeners react to events caused by timers. They often create 
 * and use Timers as well
 *
 * @author Mikko Hilpinen.
 * @since 30.11.2013.
 */
public interface TimerEventListener extends LogicalHandled
{
	/**
	 * This method is called by a Timer at certain periods.
	 * @param timerid The identifier of the timer that caused the event
	 */
	public void onTimerEvent(int timerid);
}
