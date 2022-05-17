package Model;

public class User implements java.io.Serializable{
    private static int counter=0;
    private int id;
    private String username;
    private String password;
    private UserType type;

    public User (String username,String password,UserType type)
    {
        this.id=counter;
        this.username=username;

        this.password=password;
        this.type=type;
       counter++;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public UserType getType() {
        return type;
    }

    public int getId()
    {return this.id;}
}
