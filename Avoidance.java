import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;

public class Avoidance extends Thread {
	private DataExchange DEObj;

	static EV3LargeRegulatedMotor motorC=new EV3LargeRegulatedMotor(MotorPort.C);
	static EV3LargeRegulatedMotor motorD=new EV3LargeRegulatedMotor(MotorPort.D);
	
	public Avoidance(DataExchange DE){
        DEObj = DE;
       
             }
	 public void run(){
	     while(true){
	    	   if(DEObj.getCmd()==0) {
	     		      	motorD.rotate(90);    
	                	motorD.forward();
	                	motorC.rotate(90);
	                	motorC.forward();
	                	motorD.rotate(-90);
	                	motorD.forward();     	       		 
	    	       		}
	       }
	 }
}
/*import lejos.hardware.Sound;

//define the notes and their durations
int[] notes = {659, 659, 880, 880, 987, 987, 880,
            659, 659, 880, 880, 987, 987, 880,
            659, 659, 880, 880, 987, 987, 880,
            987, 987, 1318, 1318, 1175, 1175, 880};
int[] durations = {200, 200, 200, 200, 200, 200, 400,
                200, 200, 200, 200, 200, 200, 400,
                200, 200, 200, 200, 200, 200, 400,
                200, 200, 200, 200, 200, 200, 400};

//play the song
for (int i = 0; i < notes.length; i++) {
 Sound.playTone(notes[i], durations[i]);
}
*/