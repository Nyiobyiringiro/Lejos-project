import lejos.hardware.Button;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.SampleProvider;

public class Colordetector extends Thread{
	
       private DataExchange DEObj;
  //Initializing the port that is connected to color sensor.     
       static EV3ColorSensor  cs=new EV3ColorSensor(SensorPort.S2);
		
		public Colordetector(DataExchange DE){
           DEObj = DE;
           cs.setFloodlight(true);
                }
		
		
		SensorMode csp =cs.getRedMode();
        float colorvalue;
        
		public void run() {
//			  SampleProvider csp =cs.getRedMode();

       
		        while(true)
	            { 
	        	 float [] colorsample = new float[csp.sampleSize()];
	  		     csp.fetchSample(colorsample, 0);
	  		     colorvalue = (colorsample[0]); 
	  		     
	             DEObj.setcolor(colorvalue);
	            }
	    }
	 
	}
    