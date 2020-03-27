package SecuritySystem;

public interface Document {

	public void read(String userId);
	
	public String getLevel();
	
	public String getDescription();
	
	public String getManager();
	
	public String getName();
	
	public void write(String description);
}
