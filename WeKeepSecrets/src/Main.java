import java.util.Scanner;

public class Main {

<<<<<<< HEAD
	/* Commands Constants */
	private static final String REGISTER = "REGISTER" ;
	private static final String LISTUSERS = "LISTUSERS";
	private static final String UPLOAD = "UPLOAD";
	private static final String READ_DOCUMENT = "READ";
	private static final String WRITE_DOCUMENT = "WRITE";
	private static final String GRANT_ACCESS = "GRANT";
	private static final String REVOKE_ACCESS = "REVOKE";
	private static final String USERDOCS = "USERDOCS";
	private static final String TOPLEAKED = "TOPLEAKED";
	private static final String TOPGRANTERS = "TOPGRANTERS";
	private static final String EXIT = "EXIT";
	private static final String HELP = "HELP";
	
	/* Error Constants */
	
	
	/* Success Constants */
	private static final String SUCCESS_EXIT = "Bye!";
	
	private static String readOption( Scanner in ) {
		return in.next().toUpperCase();
	}
	
	private static void exeOption( Scanner in, SecuritySystem sec, String option ) {
		switch(option) {
			case REGISTER:
				regist(in,sec);
				break;
			case LISTUSERS:
				break;
			case UPLOAD:
				break;
			case READ_DOCUMENT:
				break;
			case WRITE_DOCUMENT:
				break;
			case GRANT_ACCESS:
				break;
			case REVOKE_ACCESS:
				break;
			case USERDOCS:
				break;
			case TOPLEAKED:
				break;
			case TOPGRANTERS:
				break;
			case HELP:
				help();
				break;
			default:
				System.out.println();
		}
	}
	
	private static void regist( Scanner in, SecuritySystem sec) {
=======
	public static void main(String[] args) {
		// TODO Auto-generated method stub
>>>>>>> master
		
	}
	
	private static void help() {
		System.out.println("register - registers a new user\n"
				+ "listUsers - list all registered users\n"
				+ "upload - upload a document\n"
				+ "read - read a document\n"
				+ "write - write a document\n"
				+ "grant - grant access a document\n"
				+ "revoke - revoke a grant to access a document\n"
				+ "userdocs - list the ocial or classified documents of an user\n"
				+ "topleaked - list the top 10 documents with more grants\n"
				+ "topgranters - list the top 10 officers that have given more grants\n"
				+ "help - shows the available commands\n"
				+ "exit - terminates the execution of the program");
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		SecuritySystem sec = new SecuritySystemClass();
		do {
			
		}while(readOption(in).equals(EXIT));
		System.out.println(SUCCESS_EXIT);
		in.close();
	}

}
