import lejos.hardware.Sound;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;

public class ObstacleDetector extends Thread{
	
       private DataExchange DEObj;
  //Initializing the port that is connected to EV3UltrasonicSensor.
       private static EV3UltrasonicSensor us = new EV3UltrasonicSensor(SensorPort.S1);
   //setting the color sensor in the getRedMode. 
       final SampleProvider sp = us.getDistanceMode();
       int distanceValue = 0;
       
  //setting the obstacle distance threshold to 25cm.
       private final int securityDistance = 25;

        public ObstacleDetector(DataExchange DE){
             DEObj = DE;
            
                  }
        public void run(){
  //this is a loop to detector the object distance from the robot.   	
	       while(true){
	    	float [] sample = new float[sp.sampleSize()];
   		    sp.fetchSample(sample, 0);
               distanceValue = (int)(sample[0]*100);
	           if( distanceValue> securityDistance){
	                   DEObj.setCmd(1);
	             }
	          
	            else {
	               DEObj.setCmd(0);
	 	           LCD.drawString("Object found!", 0,1);
	 	           LCD.refresh();
	 	           Sound.twoBeeps();
	 	           Sound.twoBeeps();
	            
	           }
	           
	      }
	    }
	 
	}
    