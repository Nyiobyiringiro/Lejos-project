
public class DataExchange {
    
    private boolean  obstacleDedected=false;
    
    private int cmd=1;
    
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
	
	
}