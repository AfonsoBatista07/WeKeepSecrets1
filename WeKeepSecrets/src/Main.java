import java.util.Scanner;

import securitySystem.*;

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
	private static final String ERROR_REGIST = "Identifier %s is already assigned to another user.\n\n";
	private static final String ERROR_LIST_USERS = "There are no registered users.\n\n";
	private static final String ERROR_USER_DONT_EXIST = "User %s is not a registered user.\n\n";
	private static final String ERROR_USERS_NOT_REGISTERED = "Not a registered user.\n";
	private static final String ERROR_ALREADY_EXIST_DOCUMENT = "Document %s already exists in the user account.\n\n";
	private static final String ERROR_DOES_NOT_EXIST_DOCUMENT = "Document %s does not exist in the user acount.\n\n";
	private static final String ERROR_LOWER_CLEARANCE = "Insuficient security clearance.\n";
	private static final String ERROR_CAN_NOT_UPDATE = "Document %s cannot be updated.\n\n";
	private static final String ERROR_IS_CLERK = "Access to document %s has been denied.\n\n";
	private static final String ERROR_ALREADY_ACCESS = "Already has access to document %s.\n\n";
	private static final String ERROR_NO_ACCESS = "Grant for officer does not exist.\n";
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
	private static final String SUCCESS_READ = "Document: %s\n\n";
	private static final String SUCCESS_GRANT = "Access to document %s has been granted.\n\n";
	private static final String SUCCESS_REVOKE = "Access to document %s has been revoked.\n\n";
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
				listUsers(sec);
				break;
			case UPLOAD_DOCUMENT:
				uploadDocoment(in,sec);
				break;
			case READ_DOCUMENT:
				readDocument(in,sec);
				break;
			case WRITE_DOCUMENT:
				writeDocoment(in,sec);
				break;
			case GRANT_ACCESS:
				grantAccess(in,sec);
				break;
			case REVOKE_ACCESS:
				revokeAccess(in,sec);
				break;
			case USERDOCS:
				userDocs(in,sec);
				break;
			case TOPLEAKED:
				topLeaked(in,sec);
				break;
			case TOPGRANTERS:
				topGranters(in,sec);
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
		String kind = in.next().toLowerCase();
		String id = in.next();
		String level = in.next().toLowerCase();
		in.nextLine();
		
		if(sec.idExist(id))
			System.out.printf(ERROR_REGIST, id);
		else {
			sec.regist(kind, id, level);
			System.out.printf(SUCCESS_REGIST, id);
		}
	}
	
	private static void listUsers( SecuritySystem sec ) {
		Iterator userList = sec.createIterator();
		if(!userList.hasNext())
			System.out.println(ERROR_LIST_USERS);
		else {
			while(userList.hasNext()) {
				ClerkClass user = userList.next();
			
				System.out.printf("%s %s %s\n", user.getKind(), user.getId(), user.getLevel());
			}
		}
		System.out.println("");
	}
	
	private static void uploadDocoment( Scanner in, SecuritySystem sec ) {
		String docName = in.next();
		String id = in.next();
		String docLevel = in.next().toLowerCase();
		String description = in.nextLine();
		
		if(!sec.idExist(id))
			System.out.printf(ERROR_USER_DONT_EXIST, id);
		else if(sec.docExist(id, docName))
			System.out.printf(ERROR_ALREADY_EXIST_DOCUMENT, docName);
		else if(sec.lowerSecurityLevel(id, docLevel))
			System.out.println(ERROR_LOWER_CLEARANCE);
		else {
			sec.newDocument(docName, id, docLevel, description);	
			System.out.printf(SUCCESS_UPLOAD, docName);
		}
		
	}
	
	private static void readDocument( Scanner in, SecuritySystem sec ) {
		String docName = in.next();
		String idManager = in.next();
		String idAcces = in.next();
		
		if( !sec.idExist(idManager) && !sec.idExist(idAcces) )
			System.out.println(ERROR_USERS_NOT_REGISTERED);
		else if(!sec.docExist(idManager, docName))
			System.out.printf(ERROR_DOES_NOT_EXIST_DOCUMENT, docName);
		else if(!sec.canManage(idAcces, docName))
			System.out.println(ERROR_LOWER_CLEARANCE);
		else {
			System.out.printf(SUCCESS_READ, sec.getDecription(docName));
		}
		
	}
	
	private static void writeDocoment( Scanner in, SecuritySystem sec ) {
		String docName = in.next();
		String idManager = in.next();
		String idAcces = in.next();
		String description = in.nextLine();
		
		if( !sec.idExist(idManager) && !sec.idExist(idAcces) )
			System.out.println(ERROR_USERS_NOT_REGISTERED);
		else if(!sec.docExist(idManager, docName))
			System.out.printf(ERROR_DOES_NOT_EXIST_DOCUMENT, docName);
		else if(sec.officialDoc(docName))
			System.out.printf(ERROR_CAN_NOT_UPDATE, docName);
		else if(!sec.canManage(idAcces, docName))
			System.out.println(ERROR_LOWER_CLEARANCE);
		else {
			sec.write(idManager , docName, description);
			System.out.printf(SUCCESS_WRITE, docName);
		}
	}
	
	private static void grantAccess( Scanner in, SecuritySystem sec ) {
		String docName = in.next();
		String idManager = in.next();
		String idGranted = in.next();
		in.hasNextLine();
		
		if( !sec.idExist(idManager) && !sec.idExist(idGranted) )
			System.out.println(ERROR_USERS_NOT_REGISTERED);
		else if(!sec.docExist(idManager, docName))
			System.out.printf(ERROR_DOES_NOT_EXIST_DOCUMENT, docName);
		else if(sec.userClerk(idGranted))
			System.out.printf(ERROR_IS_CLERK, docName);
		else if(sec.granted(idGranted, docName))
			System.out.printf(ERROR_ALREADY_ACCESS, docName);
		else {
			sec.grantUser(idGranted, docName);
			System.out.printf(SUCCESS_GRANT, docName);
		}
		
	}
	
	private static void revokeAccess( Scanner in, SecuritySystem sec ) {
		String docName = in.next();
		String idManager = in.next();
		String idGranted = in.next();
		in.hasNextLine();
		
		if( !sec.idExist(idManager) && !sec.idExist(idGranted) )
			System.out.println(ERROR_USERS_NOT_REGISTERED);
		else if(!sec.docExist(idManager, docName))
			System.out.printf(ERROR_DOES_NOT_EXIST_DOCUMENT, docName);
		else if(!sec.granted(idGranted, docName))
			System.out.printf(ERROR_NO_ACCESS, idGranted);
		else if(sec.revoked(idGranted, docName))
			System.out.printf(ERROR_GRANT_ALREADY_REVOKED, idGranted);
		else {
			sec.revokeUser(idGranted, docName);
			System.out.println(SUCCESS_REVOKE);
		}
		
	}
	
	private static void userDocs( Scanner in, SecuritySystem sec ) {
		String id = in.next();
		String level = in.next();
		
		if(!sec.idExist(id))
			System.out.printf(ERROR_USER_DONT_EXIST, id);
		else if(sec.lowerSecurityLevel(id, level))                                      // Completar !!!
			System.out.println(ERROR_LOWER_CLEARANCE);
		else
			System.out.println();
		
	}
	
	private static void topLeaked( Scanner in, SecuritySystem sec ) {

																	    // Completar !!!
		
	}
	
	private static void topGranters( Scanner in, SecuritySystem sec ) {

																		// Completar !!!
		
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
			System.out.print("> ");
			cm = readOption(in);
			exeOption(in, sec, cm);
		}while(!cm.equals(EXIT));

		in.close();
	}

}
