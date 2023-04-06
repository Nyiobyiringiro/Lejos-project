import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;

public class EV3Project {
    private static DataExchange DE;
    private static ObstacleDetector Obstacle;
    private static Linefollower black;
    private static Colordetector color;
    
	public static void main(String[] args) {
		DE=new DataExchange();
		Obstacle=new ObstacleDetector(DE);
		black=new Linefollower(DE);
	    color=new Colordetector(DE);
		Obstacle.start();
		color.start();
        black.start();
        while(!Button.ESCAPE.isDown()){
        	// 
        }
        LCD.drawString("Finished", 0, 7);
        LCD.refresh();
        System.exit(0);
	}

}
 