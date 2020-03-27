package securitySystem;

public class SecuritySystemClass implements SecuritySystem {

	@Override
	public boolean idExist(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean docExist(String id, String docName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canManage(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean officialDoc(String docName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean userClerk(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean granted(String id, String docName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean revoked(String id, String docName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator createIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void regist(String kind, String id, String level) {
		// TODO Auto-generated method stub

	}

	@Override
	public void newDocument(String docName, String id, String level, String description) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDescription(String description) {
		// TODO Auto-generated method stub

	}

	@Override
	public void accessToDocument(String id, String docName) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getDecription(String docName) {
		// TODO Auto-generated method stub
		return null;
	}

}
