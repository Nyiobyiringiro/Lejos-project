import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;

public class EV3Project {
    private static DataExchange DE;
    private static ObstacleDetector Obstacle;
    private static Linefollower black;
    //private static Avoidance avoidance;
	public static void main(String[] args) {
		DE=new DataExchange();//Data exchange
		Obstacle=new ObstacleDetector(DE);//Obstacle detector
		black=new Linefollower(DE);//Line follower
		//avoidance=new Avoidance(DE);//Obstacle avoidance
		Obstacle.start();
        black.start();
        //avoidance.start();
        while(!Button.ESCAPE.isDown()){
        	// 
        }
        LCD.drawString("Finished", 0, 7);
        LCD.refresh();
        System.exit(0);
	}

}
 