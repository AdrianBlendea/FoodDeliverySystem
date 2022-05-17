package Controller;

import Model.MenuItem;
import Model.Order;
import Model.User;

import java.io.*;
import java.util.*;

public abstract class Serializator {
    private static HashMap<Order,ArrayList<MenuItem>> orderHistory=new HashMap<Order,ArrayList<MenuItem>>();
    private static HashSet<MenuItem> productsDatabase=new HashSet<MenuItem>();

    public static ArrayList<User> deserializeClients() {

        try {
            FileInputStream fileIn = new FileInputStream("database.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ArrayList<User> userList;
            userList = (ArrayList<User>) in.readObject();
            in.close();
            fileIn.close();
            return userList;

        } catch (IOException i) {
            i.printStackTrace();
            return null;
        } catch (ClassNotFoundException c) {
            // System.out.println("Employee class not found");
            c.printStackTrace();
            return null;
        }
    }


    public static void serializeClients(ArrayList<User> userList) {

        try {
            FileOutputStream fileOut =
                    new FileOutputStream("database.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(userList);
            out.close();
            fileOut.close();
            //  System.out.printf("Serialized data is saved in /tmp/employee.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
    public  static void serializeOrders(HashMap<Order,ArrayList<MenuItem>> orders) {

        try {
            FileOutputStream fileOut =
                    new FileOutputStream("orderHistory.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(orders);
            out.close();
            fileOut.close();

        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static HashMap<Order,ArrayList<MenuItem>> deserializeOrders() {
        HashMap<Order,ArrayList<MenuItem>> orders=new HashMap<Order,ArrayList<MenuItem>>();
        try {
            FileInputStream fileIn = new FileInputStream("orderHistory.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            orders = (HashMap<Order, ArrayList<MenuItem>>) in.readObject();
            if(orders!=null)
                return orders;
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return null;
        } catch (ClassNotFoundException c) {

            c.printStackTrace();
            return null;
        }
        return null;
    }

    public  static void serializeProducts(HashSet<MenuItem> products) {

        try {
            FileOutputStream fileOut =
                    new FileOutputStream("productsDatabase.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(products);
            out.close();
            fileOut.close();

        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static HashSet<MenuItem> deserializeProducts() {

        try {
            FileInputStream fileIn = new FileInputStream("productsDatabase.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            productsDatabase = (HashSet<MenuItem>)  in.readObject();
            in.close();
            fileIn.close();
            return productsDatabase;
        } catch (IOException i) {
            i.printStackTrace();
            return null;
        } catch (ClassNotFoundException c) {

            c.printStackTrace();
            return null;
        }
    }


    public static Map<Order, ArrayList<MenuItem>> getOrderHistory() {
        return orderHistory;
    }
}
