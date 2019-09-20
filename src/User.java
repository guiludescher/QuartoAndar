
public class User {
	
	public long id;
	public String name, login, password;
	public UserTypes type;
	
	public enum UserTypes {
		Manager = 0,
        Agent = 1
	}
}


