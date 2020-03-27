package SecuritySystem;

public class ClassifiedDocumentClass extends DocumentClass{
	private String level;
	
	private String[] grants;
	
	private int numGrants;
	
	private static final int MAX_GRANTS = 100;

	public ClassifiedDocumentClass(String manager, String name, String level, String description) {
		super(manager, name, description);
		this.level = level;
		
		numGrants = 0;
		grants = new String[MAX_GRANTS];
	}
	
	// falta lista de names e se são write ou read
	//falta tb implementar o metodo de dar grants
	

}
