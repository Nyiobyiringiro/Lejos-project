
public class DataExchange {
    
    private boolean  obstacleDedected=false;
    
    private int cmd=1;
    private float color;
    private int count = 1;
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
	
	public int getCycle() {
		return count;
	}

	public void setCycle(int cycle) {
		this.count = this.count + cycle;
	}
	
	
}