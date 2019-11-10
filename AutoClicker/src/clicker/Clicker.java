//package clicker;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;

public class Clicker {

	static boolean stop;
	public static void main(String[] args) throws AWTException, InterruptedException {
		int count = 0;
		stop = false;
		Timer timer = new Timer();
		Robot clicker = new Robot();
		Rectangle captureSize = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage bufferedImage = clicker.createScreenCapture(captureSize);		
//		String delayStr = JOptionPane.showInputDialog(
  //              null, "How many minutes do you want to run the bot for?");
String delayStr = args[0];		
		// Delay in milliseconds
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				stop = true;
			}
		};
		int delay = Integer.parseInt(delayStr) * 60000;
		timer.schedule(task, delay);
long timeElapsed = System.currentTimeMillis();
		while (true) {
System.out.println((System.currentTimeMillis() - timeElapsed)/1000);
			count++;

			// Stop after set time
			if (stop)
				System.exit(1);
			Random rand = new Random();
			//int randos_x = ThreadLocalRandom.current().nextInt(0, captureSize.width + 1);
			//int randos_y = ThreadLocalRandom.current().nextInt(10, captureSize.height + 1);

			int randos_x = ThreadLocalRandom.current().nextInt(240, 1680 + 1);
			int randos_y = ThreadLocalRandom.current().nextInt(10, 1080 + 1);
			//	    	System.out.print(randos_x + ", ");
			//	    	System.out.println(randos_y);

			// Move mouse to random location and click
			clicker.mouseMove(randos_x, randos_y);
//					clicker.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//					clicker.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			Thread.sleep(200);
		}
	}
}
