package Model;

public class Client extends User{

    private String emailAdress;


    public Client(String username, String password, UserType type,String emailAdress) {
        super(username, password, UserType.CLIENT);
        this.emailAdress = emailAdress;
    }
}
