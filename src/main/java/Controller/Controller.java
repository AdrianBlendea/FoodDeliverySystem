package Controller;
import java.io.*;
import Model.*;
import View.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;

public class Controller {
    private FirstView firstView;
    private RegisterView registerView;

    private EmployeeView employeeView;
    private ArrayList<User> userList;
    private HashSet<MenuItem> products;

    public Controller(FirstView firstView, RegisterView registerView,  EmployeeView employeeView) {
        this.firstView = firstView;
        this.firstView.setVisible(true);
        this.registerView = registerView;


        this.employeeView = employeeView;
        this.userList = new ArrayList<User>();
        this.products = new HashSet<MenuItem>();
        readProducts();

        Admin a = new Admin("admin", "password", UserType.ADMINISTRATOR);
        Employee e = new Employee("employee", "password", UserType.EMPLOYEE);


        addUser(e);
        addUser(a);

        this.firstView.autentificareListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user;
                String username = firstView.getUsername();
                String password = firstView.getPassword();
                userList=Serializator.deserializeClients();
                System.out.println(userList);
                user = findAcount(username, password);

                       if(user!=null){
                if (user.getType() == UserType.ADMINISTRATOR){
                    AdministratorView a=new AdministratorView();
                   AdminController adminController=new AdminController(a,products);}

                if (user.getType() == UserType.CLIENT) {
                   ClientView clientView=new ClientView();
                   clientView.getWelcomeLabel().setText("Bine ai venit, "+user.getUsername());
                   ClientController clientController=new ClientController(clientView,products,user);
                }
                if (user.getType() == UserType.EMPLOYEE)
                    employeeView.setVisible(true);
            }}
        });


        this.firstView.inregisrareListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerView.setVisible(true);
            }
        });

        this.registerView.createListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = "";
                String password = "";
                String email = "";
                Boolean check = true;
                username = registerView.getUsername();
                password = registerView.getPassword();
                email = registerView.getEmail();

                if (password.length() < 8) {
                    JOptionPane.showMessageDialog(registerView, "Parola este prea scurta");
                    check = false;
                }
                if (username.length() < 6) {
                    JOptionPane.showMessageDialog(registerView, "Nume de utilizator prea scurt");
                    check = false;

                }

                if (email.length() < 8) {
                    JOptionPane.showMessageDialog(registerView, "Email invalid");
                    check = false;

                }
                if (check == true) {
                    Client c = new Client(username, password, UserType.CLIENT, email);
                    addUser(c);
                    Serializator.serializeClients(userList);
                    JOptionPane.showMessageDialog(registerView, "Inregistrarea a avut loc cu succes");


                }

            }
        });


    }

    public void addUser(User newUser) {
        this.userList.add(newUser);

    }

    public User findAcount(String username, String password) {
        User user = null;
        for (User u : userList) {
            if (username.equals(u.getUsername()) && password.equals(u.getPassword())) {
                user = u;
                break;
            }

        }
        return user;
    }



    public void readProducts() {

        String file = "src\\products.csv";
        BufferedReader reader = null;
        String line = "";

        try {
            reader = new BufferedReader(new FileReader(file));
            boolean firstLine=true;
            while((line = reader.readLine()) != null) {
                    if(!firstLine) {
                        String[] row = line.split(",");
                        BaseProduct b=new BaseProduct (row[0].toString(),Float.parseFloat(row[1].toString()),Integer.parseInt(row[2].toString()),Integer.parseInt(row[3].toString()),Integer.parseInt(row[4].toString()),Integer.parseInt(row[5].toString()),Integer.parseInt(row[6].toString()));
                        this.products.add(b);
                    }
                    firstLine=false;
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }




        }}
    }
