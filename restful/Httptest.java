package restful;

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

        URL url1 = null;
        HttpURLConnection conn1 = null;
        InputStreamReader isr1 = null;
        BufferedReader br1 = null;

        URL urlObstacleDistance = null;
        HttpURLConnection connObstacleDistance = null;
        InputStreamReader isrObstacleDistance = null;
        BufferedReader brObstacleDistance = null;

        URL urlColorSensor = null;
        HttpURLConnection connColorSensor = null;
        InputStreamReader isrColorSensor = null;
        BufferedReader brColorSensor = null;

        try {
            // sending speeds to the database to the robot
            while (true) {
                url1 = new URL("http://192.168.0.101:8080/rest/robot18services/getfunctions");
                conn1 = (HttpURLConnection) url1.openConnection();
                InputStream is1 = null;
                try {
                    is1 = conn1.getInputStream();
                } catch (Exception e) {
                    System.out.println("Exception conn1.getInputStream()");
                    e.printStackTrace();
                    System.out.println("Cannot get InputStream from URL 1!");
                }
                isr1 = new InputStreamReader(is1);
                br1 = new BufferedReader(isr1);
                String robot18 = null;
                while ((robot18 = br1.readLine()) != null) {
                    String[] values = robot18.split(" ");
                    int motorc = Integer.parseInt(values[0]);
                    DEObj.setMotorc(motorc);
                    int motord = Integer.parseInt(values[1]);
                    DEObj.setMotord(motord);
                    float linecolor = Float.valueOf(values[2]);
                    DEObj.setLinecolor(linecolor);
                    int sec_distance = Integer.parseInt(values[3]);
                    	DEObj.setSec_distance(sec_distance);
                }

                // sending distance detected to the database
                if (DEObj.getStatus() == 1) {
                    int obstacleDistanceValue = DEObj.getDistanceValue();
                    urlObstacleDistance = new URL("http://192.168.0.101:8080/rest/statistics/getdistance/" + obstacleDistanceValue);
                    connObstacleDistance = (HttpURLConnection) urlObstacleDistance.openConnection();
                    InputStream isObstacleDistance = null;
                    try {
                        isObstacleDistance = connObstacleDistance.getInputStream();
                    } catch (Exception e) {
                        System.out.println("Exception connObstacleDistance.getInputStream()");
                        e.printStackTrace();
                        System.out.println("Cannot get InputStream from URL Obstacle Distance!");
                    }
                    isrObstacleDistance = new InputStreamReader(isObstacleDistance);
                    brObstacleDistance = new BufferedReader(isrObstacleDistance);
                    String sObstacleDistance = null;
                    System.out.println("Obstacle Distance: " + sObstacleDistance);
                }

                // sending linecolor detected by the robot to the database
                urlColorSensor = new URL("http://192.168.0.101:8080/rest/statistics/getcolor/" + DEObj.getColor());
                connColorSensor = (HttpURLConnection) urlColorSensor.openConnection();
                InputStream isColorSensor = null;
                try {
                    isColorSensor = connColorSensor.getInputStream();
                } catch (Exception e) {
                    System.out.println("Exception connColorSensor.getInputStream()");
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
                if (br1 != null)
                    br1.close();
                if (isr1 != null)
                    isr1.close();
                if (conn1 != null)
                    conn1.disconnect();
                if (brObstacleDistance != null)
                    brObstacleDistance.close();
                if (isrObstacleDistance != null)
                    isrObstacleDistance.close();
                if (connObstacleDistance != null)
                    connObstacleDistance.disconnect();
                if (brColorSensor != null)
                    brColorSensor.close();
                if (isrColorSensor != null)
                    isrColorSensor.close();
                if (connColorSensor != null)
                    connColorSensor.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
