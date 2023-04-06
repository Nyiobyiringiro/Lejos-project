import lejos.hardware.Button;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;  
import lejos.hardware.sensor.EV3ColorSensor;
//import lejos.hardware.sensor.SensorMode;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;

public class Linefollower extends Thread {
	 private DataExchange DEObj;

		static EV3LargeRegulatedMotor motorC=new EV3LargeRegulatedMotor(MotorPort.C);
		static EV3LargeRegulatedMotor motorD=new EV3LargeRegulatedMotor(MotorPort.D);
		static EV3ColorSensor  cs=new EV3ColorSensor(SensorPort.S2);
		
		public Linefollower(DataExchange DE){
            DEObj = DE;
           //
                 }
	       
		public void run() {
			  SampleProvider csp =cs.getRedMode();
		        float colorvalue;
	         while(!Button.ESCAPE.isDown())
	            { 
	        	 float [] colorsample = new float[csp.sampleSize()];
	  		     csp.fetchSample(colorsample, 0);
	  		     colorvalue = (colorsample[0]); 
			     //System.out.println("Color: " + colorvalue);
			     if(DEObj.getCmd()==1) {
	     		    if(colorvalue<=0.05) {
	     		    	motorD.setSpeed(200);    
	                	motorC.setSpeed(340); 
	            		motorC.forward();
	    	       		motorD.forward();
	    	       		     	       		 
	    	       		 }
	     		      else {
	     		    	 
	     		    	 motorD.setSpeed(340);    
		                 motorC.setSpeed(200); 
		            	 motorC.forward();
		    	       	 motorD.forward();
		       		 }
			     }
			     else {
//			    	   motorD.stop();
//     		    	   motorC.stop();
//     		    	   motorD.rotate(90);
//     		    	   motorD.setSpeed(200);    
//		               motorC.setSpeed(100); 
//	                   motorD.forward();
//	                   motorC.forward();
//	                   Delay.msDelay(3000);
//	                   motorC.rotate(90);
//	                   motorD.setSpeed(90);    
//		               motorC.setSpeed(200); 
//	                   motorD.forward();
//	                   motorC.forward(); 
			    	  
	     		    }
	            }
	            
	            System.exit(0);
	        }
		}
  
