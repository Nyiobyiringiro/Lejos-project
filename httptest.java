import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Httptest extends Thread {
	
	private static DataExchange DEObj;
	
	public Httptest(DataExchange DE) {
		DEObj = DE;
	}
	
	public void run() {

	        System.out.println("Read some text from URL\n");
	        System.out.println("Press any key to start");
	        
//	        Button.waitForAnyPress();

	        URL url1 = null;
		    HttpURLConnection conn1 = null;
		    InputStreamReader isr1 = null;
		    BufferedReader br1 = null;

		    URL url2 = null;
		    HttpURLConnection conn2 = null;
		    InputStreamReader isr2 = null;
		    BufferedReader br2 = null;
		    
		    URL url3 = null;
		    HttpURLConnection conn3 = null;
		    InputStreamReader isr3 = null;
		    BufferedReader br3 = null;
		    
		    URL url4 = null;
		    HttpURLConnection conn4 = null;
		    InputStreamReader isr4 = null;
		    BufferedReader br4 = null;
		    
		        // Send Obstacle Distance to the database
		 		URL urlObstacleDistance = null;
		 		HttpURLConnection connObstacleDistance = null;
		 		InputStreamReader isrObstacleDistance = null;
		 		BufferedReader brObstacleDistance = null;

		 		// Send Color Sensor Values to the database
		 		URL urlColorSensor = null;
		 		HttpURLConnection connColorSensor = null;
		 		InputStreamReader isrColorSensor = null;
		 		BufferedReader brColorSensor = null;
		    try {
		        while (true) {
		            url1 = new URL("http://192.168.43.193:8080/rest/robot18services/getmotorc/1");
		            conn1 = (HttpURLConnection) url1.openConnection();
		            InputStream is1 = null;
		            try {
		                is1 = conn1.getInputStream();
		            } catch (Exception e) {
		                System.out.println("Exception conn1.getInputSteam()");
		                e.printStackTrace();
		                System.out.println("Cannot get InputStream from URL 1!");
		            }
		            isr1 = new InputStreamReader(is1);
		            br1 = new BufferedReader(isr1);
		            String s1 = null;
		            while ((s1 = br1.readLine()) != null) {
		                int leftmotor = Integer.parseInt(s1);
		                DEObj.setMotorc(leftmotor);
		            }
		            url2 = new URL("http://192.168.43.193:8080/rest/robot18services/getmotord/1");
		            conn2 = (HttpURLConnection) url2.openConnection();
		            InputStream is2 = null;
		            try {
		                is2 = conn2.getInputStream();
		            } catch (Exception e) {
		                System.out.println("Exception conn1.getInputSteam()");
		                e.printStackTrace();
		                System.out.println("Cannot get InputStream from URL 1!");
		            }
		            isr2 = new InputStreamReader(is2);
		            br2= new BufferedReader(isr2);
		            String s2 = null;
		            while ((s2 = br1.readLine()) != null) {
		                int rightmotor = Integer.parseInt(s2);
		                DEObj.setMotord(rightmotor);
		            }
		            url3 = new URL("http://192.168.43.193:8080/rest/robot18services/getsec_distance/1");
		            conn3 = (HttpURLConnection) url1.openConnection();
		            InputStream is3 = null;
		            try {
		                is3 = conn3.getInputStream();
		            } catch (Exception e) {
		                System.out.println("Exception conn1.getInputSteam()");
		                e.printStackTrace();
		                System.out.println("Cannot get InputStream from URL 1!");
		            }
		            
		            url4 = new URL("http://192.168.43.193:8080/rest/robot18services/getlinecolor/1");
		            conn4 = (HttpURLConnection) url1.openConnection();
		            InputStream is4 = null;
		            try {
		                is4 = conn4.getInputStream();
		            } catch (Exception e) {
		                System.out.println("Exception conn1.getInputSteam()");
		                e.printStackTrace();
		                System.out.println("Cannot get InputStream from URL 1!");
		            }
		            isr4 = new InputStreamReader(is4);
		            br4 = new BufferedReader(isr4);
		            String s4 = null;
		            while ((s4 = br4.readLine()) != null) {
		                float linecolor = Integer.parseInt(s4);
		                DEObj.setLinecolor(linecolor);
		            }
		         // Send Cycle to database if robot detects an obstacle
					
						int obstacleDistanceValue = DEObj.getDistanceValue();
						
						urlObstacleDistance = new URL("http://192.168.43.193:8080/rest/statistics/getdistance/" + obstacleDistanceValue);
						connObstacleDistance = (HttpURLConnection) urlObstacleDistance.openConnection();
						InputStream isObstacleDistance = null;
						try {
							isObstacleDistance = connObstacleDistance.getInputStream();
						} catch (Exception e) {
							System.out.println("Exception conn1.getInputSteam()");
							e.printStackTrace();
							System.out.println("Cannot get InputStream from URL Obstacle Distance!");
						}
						isrObstacleDistance = new InputStreamReader(isObstacleDistance);
						brObstacleDistance = new BufferedReader(isrObstacleDistance);
						String sObstacleDistance = null;

					
					// Sending values to the codetector in the database
					urlColorSensor = new URL(
							"http://192.168.43.193:8080/rest/statistics/getcolor/" + DEObj.getColor());
					connColorSensor = (HttpURLConnection) urlColorSensor.openConnection();
					InputStream isColorSensor = null;
					try {
						isColorSensor = connColorSensor.getInputStream();
					} catch (Exception e) {
						System.out.println("Exception connColorSensor.getInputSteam()");
						e.printStackTrace();
						System.out.println("Cannot get InputStream from URL ColorSensor!");
					}
					isrColorSensor = new InputStreamReader(isColorSensor);
					brColorSensor = new BufferedReader(isrColorSensor);
					String sColorSensor = null;
					
					Thread.sleep(1000); 
				}

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Some problem!");
			} finally {
		        try {
		            if (br1 != null) br1.close();
		            if (isr1 != null) isr1.close();
		            if (conn1 != null) conn1.disconnect();
		            if (br2 != null) br2.close();
		            if (isr2 != null) isr2.close();
		            if (conn2 != null) conn2.disconnect();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }

		  	    }
}
