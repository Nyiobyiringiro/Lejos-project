//This class is used to exchange data in the three threads using an object to call this class.
public class DataExchange {
    
    private boolean  obstacleDedected=false;
    
    private int cmd=1;
    private float color;
    private int count = 1;
    private int motorc;
    private int motord; 
    public DataExchange() {
    	//
    }
    public void setObstacleDedected(boolean status) {
		 obstacleDedected = status;
	}
    
	public boolean isObstacleDedected() {
		return obstacleDedected;
	}
	
	public void setCmd(int command) {
		cmd = command;
	}
	public int getCmd() {
		return cmd;
	}
	public float getColor() {
		return color;
	}
	public void setColor(float color) {
		this.color = color;
	}
	
	public int getRound() {
		return count;
	}

	public void setRound(int Round) {
		this.count = this.count + Round;
	}
	public int getMotorc() {
		return motorc;
	}
	public void setMotorc(int motorc) {
		this.motorc = motorc;
	}
	public int getMotord() {
		return motord;
	}
	public void setMotord(int motord) {
		this.motord = motord;
	}
	
	
	
}