package securitySystem;

public interface UserCollection {
	void addUser(String id, String level, String kind);
	User getUser(String id);
	boolean idExist(String id);
}
