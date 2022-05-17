package Model;

public class Employee extends User{

    public Employee(String username, String password, UserType type) {
        super(username, password, UserType.EMPLOYEE);
    }
}
