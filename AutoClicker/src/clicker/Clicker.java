package clicker;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Clicker {

	public static void main(String[] args) throws AWTException, InterruptedException {
		int count = 0;
		Robot clicker = new Robot();
	    Rectangle captureSize = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
	    BufferedImage bufferedImage = clicker.createScreenCapture(captureSize);
	    
	    while (true) {
	    	count++;
	    	System.out.println(count);
	    	// Stop after 300 clicks
	    	if (count == 300)
	    		break;
	    	Random rand = new Random();
	    	int randos_x = ThreadLocalRandom.current().nextInt(377, 1077 + 1);
	    	int randos_y = ThreadLocalRandom.current().nextInt(80, 480 + 1);

//	    	System.out.print(randos_x + ", ");
//	    	System.out.println(randos_y);
	    	
	    	// Move mouse to random location and click
	    	clicker.mouseMove(randos_x, randos_y);
		clicker.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		clicker.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(200);
	    }
	}
}
