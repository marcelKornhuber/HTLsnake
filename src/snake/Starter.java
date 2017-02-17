package snake;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author Marcel Kornhuber
 *
 */
public class Starter {
	private Frame frame;
	private ScheduledThreadPoolExecutor exec;
	private Player player;

	public Starter() {
		exec = new ScheduledThreadPoolExecutor(0);
	}

	public void start(Player player) {
		frame = new Frame(player);
		this.player = player;
		frame.setVisible(true);
		exec.schedule(new TickShedule(), 1, TimeUnit.SECONDS);
	}

	private class TickShedule implements Runnable {
		private final static int cap = 20;
		// Executions per 1000 seconds
		private final static int normal = 2500;

		@Override
		public void run() {
			frame.tick();
			exec.schedule(this, 1000000000 / (normal + (player.getScore() / cap) * 200), TimeUnit.MICROSECONDS);
		}

	}
}
