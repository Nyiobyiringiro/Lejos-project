//import lejos.hardware.lcd.LCD;
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
			float colorvalue=DEObj.getcolor();
			while(true){
				
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
			    	int count=0;
			    	if(count==0) {
			    		motorD.setSpeed(180);
			    		motorC.setSpeed(320); 

			    		motorC.forward();
			    		motorD.forward();
		 
						Delay.msDelay(1000);
						//Sound.buzz();
						
						motorD.setSpeed(250);
						motorC.setSpeed(120);

						motorD.forward();
						motorC.forward();
						
						Delay.msDelay(3000); 
						//Sound.buzz();
						
						
						motorD.setSpeed(90);
						motorC.setSpeed(300);

						motorC.forward();
						motorD.forward();

						Delay.msDelay(750);
			    	}
			    	else {
			    		motorD.stop();
			    		motorC.stop();
			    		
			    	}
	     		    }
	            }
		
	          
	        }
		}
  
