package restful;
import java.io.File;
import lejos.hardware.Sound;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.utility.Delay;

public class Linefollower extends Thread {
	 private DataExchange DEObj;

		static EV3LargeRegulatedMotor motorC=new EV3LargeRegulatedMotor(MotorPort.C);
		static EV3LargeRegulatedMotor motorD=new EV3LargeRegulatedMotor(MotorPort.D);
		
		public Linefollower(DataExchange DE){
            DEObj = DE;
            //
                 }
	       
		public void run() {
			
			while(true){
				int highspeed=DEObj.getMotorc();
				int lowspeed=DEObj.getMotord();
				float colorvalue=DEObj.getColor();
				int count = DEObj.getRound();
				
			     if(DEObj.getCmd()==1) {
			    	 if(colorvalue<=DEObj.getLinecolor()) {
		     		    	motorD.setSpeed(highspeed);    
		                	motorC.setSpeed(lowspeed); 
		            		motorC.forward();
		    	       		motorD.forward();
		    	       		     	       		 
		    	       		 }
		     		      else {
		     		    	  
		     		    	 
			    	        motorD.setSpeed(lowspeed);    
               		    	motorC.setSpeed(highspeed);
		     		    	motorC.forward();
		     		    	motorD.forward();
		     		 
			       		 }
				     }
			     else {
			    	 DEObj.setRound(1);
			 
					if(count <= 1) {
			    		motorD.setSpeed(360);
			    		motorC.setSpeed(180); 

			    		motorC.forward();
			    		motorD.forward();
		 
						Delay.msDelay(1500); 
						DEObj.setStatus(0);
						
						motorD.setSpeed(180);
						motorC.setSpeed(360);

						motorD.forward();
						motorC.forward();
						
						Delay.msDelay(3000); 
						
						
						
						motorD.setSpeed(360);
						motorC.setSpeed(180);

						motorC.forward();
						motorD.forward();

						Delay.msDelay(1200);
			    	}
			    	else {
			    		motorD.stop();
			    		motorC.stop();
			    		Sound.playSample(new File ("flexa.wav"), Sound.VOL_MAX);
						Sound.playSample(new File ("flexa.wav"), Sound.VOL_MAX);
						Delay.msDelay(12000);
			    	}
	     		    }
	            }
		
	          
	        }
		}
  
