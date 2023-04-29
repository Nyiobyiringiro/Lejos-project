import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;

public class EV3Project {
    private static DataExchange DE;
    private static ObstacleDetector Obstacle;
    private static Linefollower black;
    //private static Avoidance avoidance;
    
	public static void main(String[] args) 
	    {
		DE=new DataExchange();
		Obstacle=new ObstacleDetector(DE);
		black=new Linefollower(DE);
		Obstacle.start();
        black.start();
        while(!Button.ESCAPE.isDown()){
        	// 
        }
        LCD.drawString("Finished", 0, 7);
        LCD.refresh();
        System.exit(0);
	    }

}
 