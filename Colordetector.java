import lejos.hardware.Button;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.SampleProvider;

public class Colordetector extends Thread{
	
       private DataExchange DEObj;
       static EV3ColorSensor  cs=new EV3ColorSensor(SensorPort.S2);
		
		public Colordetector(DataExchange DE){
           DEObj = DE;
           cs.setFloodlight(true);
                }
	       
		public void run() {
			  SampleProvider csp =cs.getRedMode();
		        float colorvalue;
       
		        while(!Button.ESCAPE.isDown())
	            { 
	        	 float [] colorsample = new float[csp.sampleSize()];
	  		     csp.fetchSample(colorsample, 0);
	  		     colorvalue = (colorsample[0]); 
	  		     
	             DEObj.setcolor(colorvalue);
	            }
	    }
	 
	}
    