package utopia.flash.event;

import utopia.inception.handling.Handled;

/**
 * TimerEventListeners react to events caused by timers. They often create 
 * and use Timers as well
 * @author Mikko Hilpinen.
 * @since 30.11.2013.
 */
public interface TimerEventListener extends Handled
{
	/**
	 * This method is called by a Timer at certain periods.
	 * @param source The timer that caused the event
	 */
	public void onTimerEvent(AbstractTimer source);
}
