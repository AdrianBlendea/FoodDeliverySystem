package Controller;

import Model.BaseProduct;
import Model.MenuItem;
import Model.Order;
import Model.User;
import View.ClientView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static Controller.Serializator.deserializeOrders;
import static Controller.Serializator.getOrderHistory;

public class ClientController {
    private ClientView clientView;
 //  private HashMap<Order,ArrayList<MenuItem>> orderHistory;
    private User client;
    int orderPrice=0;

    public ClientController (ClientView clientView, HashSet<MenuItem> products, User client)
    {  // deserialize();
        this.clientView=clientView;
        this.clientView.setVisible(true);
       // this.orderHistory=new HashMap<Order,ArrayList<MenuItem>>();
        this.client=client;
        addProducts(products);
       // for(MenuItem m:products) {
           // System.out.println("a intrat");
       //     this.clientView.getMenu().addElement(m);
     //   }

        clientView.addToOrderListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addToOrder();

            }
        });

        clientView.deleteFromOrderListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        deleteFromOrder();
            }
        });

        clientView.resetOrderListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetOrder();
            }
        });

        clientView.placeOrderListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    HashMap<Order,ArrayList<MenuItem>> orders=new HashMap<Order,ArrayList<MenuItem>>();
                    if(deserializeOrders()!=null)
                    orders=deserializeOrders();
                try {
                    orders=createOrder(orders);
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                Serializator.serializeOrders(orders);

            }
        });

        clientView.filterListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
    filter(products);
            }
        });
clientView.resetFilterListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {

        clientView.getMenu().clear();
        addProducts(products);
    }
});
    }

    public void addToOrder()
    {
        int index = clientView.getMenuList().getSelectedIndex();
        if(index == -1)
            JOptionPane.showMessageDialog(clientView, "Va rugam selectati un produs");
        
        else
        {   MenuItem m=clientView.getMenuList().getSelectedValue();
            clientView.getOrder().addElement(m);
           clientView.getPriceText().setEditable(true);
           orderPrice+= m.computePrice();
           clientView.getPriceText().setText(Integer.toString(orderPrice));
           clientView.getPriceText().setEditable(false);

        }


    }

    public void deleteFromOrder()
    {
        int index= clientView.getOrderList().getSelectedIndex();

        if(index ==-1)
            JOptionPane.showMessageDialog(clientView, "Va rugam selectati un produs");

        else
        {   MenuItem m=clientView.getOrderList().getSelectedValue();
            clientView.getOrder().remove(index);
            clientView.getPriceText().setEditable(true);
            orderPrice-= m.computePrice();
            clientView.getPriceText().setText(Integer.toString(orderPrice));
            clientView.getPriceText().setEditable(false);
        }

    }


    public void resetOrder()
    {
        this.clientView.getOrder().clear();
        orderPrice=0;
        clientView.getPriceText().setEditable(true);;
        clientView.getPriceText().setText(Integer.toString(orderPrice));
        clientView.getPriceText().setEditable(false);

    }

    public  HashMap<Order,ArrayList<MenuItem>> createOrder(HashMap<Order,ArrayList<MenuItem>> orders) throws FileNotFoundException {
        if(clientView.getOrder().isEmpty()==true)
        {
            JOptionPane.showMessageDialog(clientView, "Va rugam, adaugati produse la comanda");

        }
        else
        {   LocalDate currentDate = LocalDate.now();
            LocalTime currentTime = LocalTime.now();
            LocalDateTime fromDateAndTime = LocalDateTime.of(currentDate,
                    currentTime);

            ArrayList<MenuItem> ord= new ArrayList<MenuItem>();
            Order o =new Order(client.getId(),fromDateAndTime,orderPrice);
            for(int i=0;i<clientView.getOrder().size();i++)
            {
                ord.add(clientView.getOrder().get(i));
            }

         orders.put(o,ord);

            JOptionPane.showMessageDialog(clientView, "Comanda plasata cu succes");
        //    this.clientView.getOrder().clear();
            generateBill(o,ord,orderPrice);
            resetOrder();
            return orders;

        }

return null;
    }

   /* public void serialize() {

        try {
            FileOutputStream fileOut =
                    new FileOutputStream("orderHistory.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(orderHistory);
            out.close();
            fileOut.close();

        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public void deserialize() {

        try {
            FileInputStream fileIn = new FileInputStream("database.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            this.orderHistory = (HashMap<Order,ArrayList<MenuItem>>)  in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {

            c.printStackTrace();
            return;
        }
    }*/
    public void generateBill(Order o,ArrayList<MenuItem> ord,int orderPrice) throws FileNotFoundException {

        FileOutputStream fileOut =
                new FileOutputStream("Order " + o.getOrderId()+".txt");
        PrintStream printStream = new PrintStream(fileOut);
        String bill="";
        bill+="Order id " + o.getOrderId() + "\n";
        bill+="Order date and time  " +o.getOrderDate()+"\n";
        bill+= "Your order: " + "\n";

        for(MenuItem m:ord)
        {
            bill+=ord.toString();
        }
        bill+="Total price : " + orderPrice;
       printStream.print(bill);
    }
    public void filter(HashSet<MenuItem> products)
    {
        ArrayList<BaseProduct> aux = new ArrayList<BaseProduct>();
        List<BaseProduct> res ;
        for(int i=0;i<clientView.getMenu().size();i++)
                if(clientView.getMenu().get(i) instanceof BaseProduct)
            aux.add((BaseProduct)clientView.getMenu().get(i));
        else
                {
                    continue;
                }
    int minPrice= (int) clientView.getMinPrice().getValue();
    int maxPrice =(int)clientView.getMaxPrice().getValue();
    int minRating=(int)clientView.getMinRating().getValue();
   int maxRating=(int)clientView.getMaxRating().getValue();
    int minCalories=(int)clientView.getMinCalorii().getValue();
    int maxcalories=(int)clientView.getMaxCalorii().getValue();
    int minProteins=(int)clientView.getMinProteins().getValue();
    int maxProteins = (int)clientView.getMaxProteins().getValue();
    int minFats=(int)clientView.getMinFats().getValue();
    int maxFats=(int)clientView.getMaxFats().getValue();
    int minSodium=(int)clientView.getMinSodium().getValue();
    int maxSodium=(int)clientView.getMaxSodium().getValue();
    String searchTitle=clientView.getNumeTextField().getText();

        res=  aux.stream().filter(m-> m.containsTitle(searchTitle))
                .filter(m->  m.getPrice()>=minPrice &&m.getPrice()<=maxPrice  )
                .filter( m-> m.getRating()>=minRating && m.getRating()<=maxRating)
                .filter(m-> inInterval(minCalories,maxcalories,m.getCalories()))
                .filter(m-> inInterval(minProteins,maxProteins,m.getProteins()))
                .filter(m-> inInterval(minFats,maxFats,m.getFats()))
                .filter(m-> inInterval(minSodium,maxSodium,m.getSodium()))
                .collect(Collectors.toList());
        this.clientView.getMenu().clear();

        for(BaseProduct b:res)
            this.clientView.getMenu().addElement(b);
    }

    public void addProducts(HashSet<MenuItem> products)
    {
        for(MenuItem m:products) {
            // System.out.println("a intrat");
            this.clientView.getMenu().addElement(m);
        }
    }
public boolean inInterval(int lowerBound,int upperBound,int nr)
{
    if(nr>=lowerBound && nr <=upperBound)
        return true;

    return false;
}
}
