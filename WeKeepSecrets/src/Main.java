import java.util.Scanner;
import SecuritySystem.*;

public class Main {

	/* Commands Constants */
	private static final String REGISTER = "REGISTER" ;
	private static final String LISTUSERS = "LISTUSERS";
	private static final String UPLOAD_DOCUMENT = "UPLOAD";
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
	private static final String ERROR_REGIST = "Identifier %s is already assigned to another user.\n";
	private static final String ERROR_LIST_USERS = "There are no registered users.\n\n";
	private static final String ERROR_NOT_REGISTERED_UPLOAD = "User author %s is not a registered user.\n\n";
	private static final String ERROR_NOT_REGISTERED_WRITE = "Not a registered user.\n";
	private static final String ERROR_ALREADY_EXIST_DOCUMENT = "Document %s already exists in the user account.\n\n";
	private static final String ERROR_DOES_NOT_EXIST_DOCUMENT = "Document %s does not exist in the user acount.\n\n";
	private static final String ERROR_LOWER_CLEARANCE = "Insuficient security clearance.\n";
	private static final String ERROR_CAN_NOT_UPDATE = "Document %s cannot be updated.\n\n";
	private static final String ERROR_IS_CLERK = "Access to document %s has been denied.\n\n";
	private static final String ERROR_ALREADY_ACCESS = "Already has access to document %s.\n\n";
	private static final String ERROR_GRANT_NOT_EXIST = "Grant for officer does not exist.\n";
	private static final String ERROR_GRANT_ALREADY_REVOKED = "Grant for officer was already revoked.\n\n";
	private static final String ERROR_NO_ACCESSES = "There are no accesses.\n";
	private static final String ERROR_NO_GRANTS = "There are no grants.\n";
	private static final String ERROR_NO_TYPE = "There are no documents with security level %s./n/n";
	private static final String ERROR_NO_LEAKED = "There are no leaked documents.\n";
	private static final String ERROR_NO_OFFICER_GRANT = "No officer has given grants.\n";
	
	/* Success Constants */
	private static final String SUCCESS_REGIST = "User %s was registered.\n\n";
	private static final String SUCCESS_UPLOAD = "Document %s was uploaded.\n\n";
	private static final String SUCCESS_WRITE = "Document %s was updated.\n\n";
	private static final String SUCCESS_READ = "Document:";
	private static final String SUCCESS_GRANT = "Access to document %s has been granted.\n\n";
	private static final String SUCCESS_REVOKE = "Access to document %s was been revoked.\n\n";
	private static final String SUCCESS_USERDOCS = "%s: ";
 	private static final String SUCCESS_EXIT = "Bye!\n";
	private static final String SUCCESS_UNKOWN = "Unknown command. Type help to see available commands.\n";
	
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
			case UPLOAD_DOCUMENT:
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
			case EXIT:
				exit();
				break;
			default:
				System.out.println(SUCCESS_UNKOWN);
		}
	}
	
	private static void regist( Scanner in, SecuritySystem sec) {
		
	}
	
	private static void listUsers( SecuritySystem sec ) {

	}
	
	private static void uploadDocoment( Scanner in, SecuritySystem sec ) {

	}
	
	private static void readDocument( Scanner in, SecuritySystem sec ) {

	}
	
	private static void writeDocoment( Scanner in, SecuritySystem sec ) {

	}
	
	private static void grantAccess( Scanner in, SecuritySystem sec ) {

	}
	
	private static void userDocs( Scanner in, SecuritySystem sec ) {

	}
	
	private static void topLeaked( Scanner in, SecuritySystem sec ) {

	}
	
	private static void topGranters( Scanner in, SecuritySystem sec ) {

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
				+ "exit - terminates the execution of the program\n");
	}
	
	private static void exit() {
		System.out.println(SUCCESS_EXIT);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		SecuritySystem sec = new SecuritySystemClass();
		String cm;
		do{
			cm = readOption(in);
			exeOption(in, sec, cm);
		}while(!cm.equals(EXIT));

		in.close();
	}

}
