import java.util.Scanner;

import documents.ClassifiedDocument;
import documents.Document;
import securitySystem.*;
import users.User;
import users.Officer;

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
	private static final String ERROR_LIST_USERS = "There are no registered users.\n";
	private static final String ERROR_USERS_NOT_REGISTERED = "Not a registered user.";
	private static final String ERROR_ALREADY_EXIST_DOCUMENT = "Document %s already exists in the user account.\n";
	private static final String ERROR_DOES_NOT_EXIST_DOCUMENT = "Document %s does not exist in the user account.\n";
	private static final String ERROR_LOWER_CLEARANCE = "Insufficient security clearance.";
	private static final String ERROR_CAN_NOT_UPDATE = "Document %s cannot be updated.\n";
	private static final String ERROR_IS_CLERK = "Grants can only be issued between officers.\n";
	private static final String ERROR_ALREADY_ACCESS = "Already has access to document %s.\n";
	private static final String ERROR_GRANT_ALREADY_REVOKED = "Grant for officer %s was already revoked.\n";
	private static final String ERROR_NO_DOCUMENTS = "There are no %s documents.\n";
	private static final String ERROR_INAPPROPRIATE_LEVEL = "Inappropriate security level.";
	private static final String ERROR_NO_ACCESSES = "There are no accesses.";
	private static final String ERROR_NO_GRANTS = "There are no grants.";
	private static final String ERROR_NO_TYPE = "There are no documents with security level %s.";
	private static final String ERROR_NO_LEAKED = "There are no leaked documents.\n";
	private static final String ERROR_NO_OFFICER_GRANT = "No officer has given grants.\n";
	
	/* Success Constants */
	private static final String SUCCESS_REGIST = "User %s was registered.\n";
	private static final String SUCCESS_UPLOAD = "Document %s was uploaded.\n";
	private static final String SUCCESS_WRITE = "Document %s was updated.\n";
	private static final String SUCCESS_READ = "Document: %s\n";
	private static final String SUCCESS_GRANT = "Access to document %s has been granted.\n";
	private static final String SUCCESS_REVOKE = "Access to document %s has been revoked.\n";
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
				System.out.printf(SUCCESS_UNKOWN);
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		SecuritySystem sec = new SecuritySystemClass();
		String cm;
		do{
			cm = readOption(in);
			in.nextLine();
			exeOption(in, sec, cm);
		}while(!cm.equals(EXIT));

		in.close();
	}
	
	private static void help() {
		System.out.printf("register - registers a new user\n"
				+ "listusers - list all registered users\n"
				+ "upload - upload a document\n"
				+ "read - read a document\n"
				+ "write - write a document\n"
				+ "grant - grant access to a document\n"
				+ "revoke - revoke a grant to access a document\n"
				+ "userdocs - list the official or classified documents of an user\n"
				+ "topleaked - list the top 10 documents with more grants\n"
				+ "topgranters - list the top 10 officers that have given more grants\n"
				+ "help - shows the available commands\n"
				+ "exit - terminates the execution of the program\n");
	}
	
	
	private static void regist( Scanner in, SecuritySystem sec) {
		String kind = in.next().toLowerCase();
		String UserId = in.next();
		String level = in.next().toLowerCase();
		in.nextLine();
		
		if(sec.idExist(UserId))
			System.out.printf(ERROR_REGIST, UserId);
		else {
			sec.regist(kind, UserId, level);
			System.out.printf(SUCCESS_REGIST, UserId);
		}
	}
	
	private static void listUsers( SecuritySystem sec ) {
		IteratorUser userList = sec.createIteratorUser();
		if(!userList.hasNext())
			System.out.println(ERROR_LIST_USERS);
		else {
			while(userList.hasNext()) {
				User user = userList.next();
			
				System.out.printf("%s %s %s\n", user.getKind(), user.getId(), user.getLevel());
			}
		}
	}
	
	private static void uploadDocoment( Scanner in, SecuritySystem sec ) {
		String docName = in.next();
		String userId = in.next();
		String docLevel = in.next().toLowerCase();
		in.nextLine();
		String description = in.nextLine();
		
		if(!sec.idExist(userId))
			System.out.println(ERROR_USERS_NOT_REGISTERED);
		else if(sec.docExist(userId, docName))
			System.out.printf(ERROR_ALREADY_EXIST_DOCUMENT, docName);
		else if(sec.lowerSecurityLevel(userId, docLevel))
			System.out.println(ERROR_LOWER_CLEARANCE);
		else {
			sec.newDocument(docName, userId, docLevel, description);	
			System.out.printf(SUCCESS_UPLOAD, docName);
		}
		
	}
	
	private static void readDocument( Scanner in, SecuritySystem sec ) {
		String docName = in.next();
		String idManager = in.next();
		String idAcces = in.next();
		
		if( !sec.idExist(idManager) || !sec.idExist(idAcces) )
			System.out.println(ERROR_USERS_NOT_REGISTERED);
		else if(!sec.docExist(idManager, docName))
			System.out.printf(ERROR_DOES_NOT_EXIST_DOCUMENT, docName);
		else if(!sec.canManage(idAcces, docName))
			System.out.println(ERROR_LOWER_CLEARANCE);
		else {
			sec.read(idAcces, docName);
			System.out.printf(SUCCESS_READ, sec.getDecription(docName));
		}
		
	}
	
	private static void writeDocoment( Scanner in, SecuritySystem sec ) {
		String docName = in.next();
		String idManager = in.next();
		String idAccess = in.next();
		in.nextLine();
		String description = in.nextLine();
		
		if( !sec.idExist(idManager) || !sec.idExist(idAccess) )
			System.out.println(ERROR_USERS_NOT_REGISTERED);
		else if(!sec.docExist(idManager, docName))
			System.out.printf(ERROR_DOES_NOT_EXIST_DOCUMENT, docName);
		else if(sec.officialDoc(docName))
			System.out.printf(ERROR_CAN_NOT_UPDATE, docName);
		else if(!sec.canManage(idAccess, docName))
			System.out.println(ERROR_LOWER_CLEARANCE);
		else {
			sec.write(idAccess , docName, description);
			System.out.printf(SUCCESS_WRITE, docName);
		}
	}
	
	private static void grantAccess( Scanner in, SecuritySystem sec ) {
		String docName = in.next();
		String idManager = in.next();
		String idGranted = in.next();
		in.nextLine();
		
		if( !sec.idExist(idManager) || !sec.idExist(idGranted) )
			System.out.println(ERROR_USERS_NOT_REGISTERED);
		else if(!sec.docExist(idManager, docName))
			System.out.printf(ERROR_DOES_NOT_EXIST_DOCUMENT, docName);
		else if(sec.userClerk(idGranted))
			System.out.printf(ERROR_IS_CLERK);
		else if(sec.canManage(idGranted, docName))
			System.out.printf(ERROR_ALREADY_ACCESS, docName);
		else {
			sec.grantUser(idGranted, idManager, docName);
			System.out.printf(SUCCESS_GRANT, docName);
		}
		
	}
	
	private static void revokeAccess( Scanner in, SecuritySystem sec ) {
		String docName = in.next();
		String idManager = in.next();
		String idGranted = in.next();
		in.nextLine();
		
		if( !sec.idExist(idManager) || !sec.idExist(idGranted) )
			System.out.println(ERROR_USERS_NOT_REGISTERED);
		else if(!sec.docExist(idManager, docName))
			System.out.printf(ERROR_DOES_NOT_EXIST_DOCUMENT, docName);
		else if(sec.userClerk(idGranted))
			System.out.printf(ERROR_IS_CLERK);
		else if(sec.revoked(idGranted, docName))
			System.out.printf(ERROR_GRANT_ALREADY_REVOKED, idGranted);
		else {
			sec.revokeUser(idGranted,idManager, docName);
			System.out.printf(SUCCESS_REVOKE, docName);
		}
		
	}
	
	private static void userDocsClassified(IteratorUser userList, IteratorString StringList, String error) {
		if(!userList.hasNext() || !StringList.hasNext())
			System.out.println(error);
		else {
			while(userList.hasNext() && StringList.hasNext()) {
				String type = StringList.next();
				User user = userList.next();
				System.out.printf("%s [%s, %s]", user.getId(), user.getLevel(), type);
				if(userList.hasNext())
					System.out.print(", ");
			}
			System.out.println("");
		}
	}
	
	private static void userDocsOfficial(IteratorUser userList, String error) {
		if(!userList.hasNext())
			System.out.println(error);
		else {
			while(userList.hasNext()) {
				User user = userList.next();
				System.out.printf("%s [%s]", user.getId(), user.getLevel());
				if(userList.hasNext())
					System.out.print(", ");
			}
			System.out.println("");
		}
	}
	
	private static void userDocs( Scanner in, SecuritySystem sec ) {
		String userId = in.next();
		String type = in.next().toLowerCase();
		in.nextLine();
		
		if(!sec.idExist(userId))
			System.out.println(ERROR_USERS_NOT_REGISTERED);
		else if(sec.matchesType(userId, type))                                      
			System.out.println(ERROR_INAPPROPRIATE_LEVEL);
		else {
			IteratorDocs docList = sec.createIteratorDocs(userId, type);
			if(!docList.hasNext())
				System.out.printf(ERROR_NO_DOCUMENTS, type);
			else {
				while(docList.hasNext()) {
					Document doc = docList.next();
					if(type.equals("official")) {
						System.out.printf("%s %s: ", doc.getDocName(), doc.getNumAccesses());
						IteratorUser userList = sec.createIteratorAccessesOfficial(doc.getDocName());
						
						userDocsOfficial(userList, ERROR_NO_ACCESSES);
						
					} else {
						System.out.printf("%s %s %s\n", doc.getDocName(), doc.getLevel(), doc.getNumAccesses());
						IteratorUser userListAccess = sec.createIteratorAccessesClassified(doc.getDocName());
						IteratorString accessType = sec.createIteratorStringAccesses(doc.getDocName());
						
						userDocsClassified(userListAccess, accessType, ERROR_NO_ACCESSES);
						
						IteratorUser userListGrants = sec.createIteratorGrants(doc.getDocName());
						IteratorString grantsType = sec.createIteratorStringGrants(doc.getDocName());
						
						userDocsClassified(userListGrants, grantsType, ERROR_NO_GRANTS);
					}
				}
			}
		}
	}
	
	private static void topLeaked( Scanner in, SecuritySystem sec ) {
		IteratorDocs docList = sec.createIteratorDocsByGrant();
		if(!docList.hasNext())
			System.out.printf(ERROR_NO_LEAKED);
		else {
			int pos = 0;
			while(docList.hasNext() && pos < 10) {
				ClassifiedDocument doc = (ClassifiedDocument) docList.next();
				System.out.printf("%s %s %s %d %d %d\n", doc.getDocName(), doc.getManager(), doc.getLevel(), doc.getNumAccesses(), doc.getNumGrants(), doc.getNumRevoked());
				pos++;
			}
		}
	}
	
	private static void topGranters( Scanner in, SecuritySystem sec ) {
		IteratorUser userList = sec.createIteratorUserByGrant();
		if(!userList.hasNext())
			System.out.printf(ERROR_NO_OFFICER_GRANT);
		else {
			int pos = 0;
			while(userList.hasNext() && pos < 10) {
				Officer user = (Officer) userList.next();
				System.out.printf("%s %s %d %d %d\n",user.getId(),user.getLevel(), user.getNumDocs(), user.getNumGrants(), user.getNumRevokes());
				pos++;
			}
		}
	}
	
	private static void exit() {
		System.out.printf(SUCCESS_EXIT);
	}

}
