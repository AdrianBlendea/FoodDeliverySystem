package Model;

public class Admin extends User {
    public Admin(String username, String password, UserType type) {
        super(username, password, UserType.ADMINISTRATOR);
    }
}
