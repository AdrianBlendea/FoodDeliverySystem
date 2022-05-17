package Controller;

import Model.*;
import View.AdministratorView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AdminController {
    private AdministratorView administratorView;
    private HashSet<MenuItem> products;

    public AdminController(AdministratorView administratorView, HashSet<MenuItem> products)
    {
        this.administratorView=administratorView;
        this.administratorView.setVisible(true);
    this.products=products;

        administratorView.dinCsvListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(MenuItem m:products) {
                    // System.out.println("a intrat");
                  administratorView.getMenu().addElement(m);
                }
            }
        });

        this.administratorView.adaugaListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addToComposite();

            }
        });

        this.administratorView.stergeListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            removeFromComposite();
            }
        });
    this.administratorView.creareListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            createNew();
            Serializator.serializeProducts(products);

        }
    });
    this.administratorView.dinBazaListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            HashSet<MenuItem> p=Serializator.deserializeProducts();
            List<MenuItem> list = new ArrayList<MenuItem>(p);
            Collections.sort(list);


            for(MenuItem m:list) {
                // System.out.println("a intrat");
                administratorView.getMenu().addElement(m);

            }
        }
    });
    this.administratorView.addBase(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            MenuItem m= addBase();

            if(m !=null)
            {
                administratorView.getMenu().addElement(m);
                products.add(m);
                Serializator.serializeProducts(products);
            }


        }
    });
    this.administratorView.deleteBase(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            deleteBase();
            Serializator.serializeProducts(products);
        }
    });

    this.administratorView.loadToModify(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
    loadToModify();
        }
    });

    this.administratorView.modifyBase(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int index = administratorView.getMenuList().getSelectedIndex();
            if(index == -1)
                JOptionPane.showMessageDialog(administratorView, "Va rugam selectati un produs");

            else{
               Modify();
            }
        }
    });
    this.administratorView.raport1Listenr(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                raport1();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }


        }

    });
    this.administratorView.raport2Listenr(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                raport2();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    });
    this.administratorView.raport3Listenr(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                raport3();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    });
    this.administratorView.raport4Listenr(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                raport4();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    });
    }
    public void addToComposite()
    {
        int index = administratorView.getMenuList().getSelectedIndex();
        if(index == -1)
            JOptionPane.showMessageDialog(administratorView, "Va rugam selectati un produs");

        else
        {   MenuItem m=administratorView.getMenu().elementAt(index);
            administratorView.getCompositeProduct().addElement(m);


        }


    }

    public void removeFromComposite()
    {
        int index = administratorView.getNewMenuList().getSelectedIndex();
        if(index == -1)
            JOptionPane.showMessageDialog(administratorView, "Va rugam selectati un produs");

        else{
            administratorView.getCompositeProduct().remove(index);


        }


    }

    public void createNew ()
    {
        String nume;
        nume=administratorView.getNume();

        if(nume.equals(""))
            JOptionPane.showMessageDialog(administratorView, "Va rugam adaugati un nume");

        else
        {
            CompositeProduct c=new CompositeProduct(nume);

            for(int i=0; i< administratorView.getCompositeProduct().size();i++)
            {   BaseProduct b= (BaseProduct) administratorView.getCompositeProduct().get(i);
                c.getProducts().add(b);
            }
            administratorView.getMenu().addElement(c);
            products.add(c);

        }


    }
    public void deleteBase()
    {
        int index = administratorView.getMenuList().getSelectedIndex();
        if(index == -1)
            JOptionPane.showMessageDialog(administratorView, "Va rugam selectati un produs pentru stergere");

        else{
           MenuItem m= administratorView.getMenu().get(index);
            administratorView.getMenu().remove(index);
            boolean b=products.remove(m);

        }

    }
    public MenuItem addBase()
    {   MenuItem m;
        try
        {String title=administratorView.getTitleTextField().getText();
            Float rating = Float.parseFloat(administratorView.getRatingTextField().getText());
            int price =Integer.parseInt(administratorView.getPriceTextField().getText());
            int calories=Integer.parseInt(administratorView.getCaloriesTextField().getText());
            int proteins =Integer.parseInt(administratorView.getProteinsTextField().getText());
            int fats=Integer.parseInt(administratorView.getFatsTextField().getText());
            int sodium=Integer.parseInt(administratorView.getSodiumTextField().getText());

             m= new BaseProduct(title,rating,calories,proteins,fats,sodium,price);
            return m;
        }
        catch(InputMismatchException ec)
        {
            JOptionPane.showMessageDialog(administratorView,"Va rugam introduceti date corecte");
            return null;
        }

    }
public void loadToModify()
{ int index = administratorView.getMenuList().getSelectedIndex();
    if(index == -1)
        JOptionPane.showMessageDialog(administratorView, "Va rugam selectati un produs");
    else {
        BaseProduct b = (BaseProduct) administratorView.getMenu().get(index);

        administratorView.getTitleTextField().setText(b.getTitle());
        administratorView.getRatingTextField().setText(String.valueOf(b.getRating()));
        administratorView.getPriceTextField().setText(String.valueOf(b.getPrice()));
        administratorView.getCaloriesTextField().setText(String.valueOf(b.getCalories()));
        administratorView.getProteinsTextField().setText(String.valueOf(b.getProteins()));
        administratorView.getFatsTextField().setText(String.valueOf(b.getFats()));
        administratorView.getSodiumTextField().setText(String.valueOf(b.getSodium()));
    }
}

    public void Modify()
    { int index = administratorView.getMenuList().getSelectedIndex();
        if(index == -1) {

            JOptionPane.showMessageDialog(administratorView, "Va rugam selectati un produs");

        }
        else {
           BaseProduct b=(BaseProduct) administratorView.getMenu().get(index);
           b.setTitle(administratorView.getTitleTextField().getText());
           b.setCalories(Integer.parseInt(administratorView.getCaloriesTextField().getText()));
           b.setPrice(Integer.parseInt(administratorView.getPriceTextField().getText()));
           b.setRating(Float.parseFloat(administratorView.getRatingTextField().getText()));
           b.setProteins(Integer.parseInt(administratorView.getProteinsTextField().getText()));
           b.setFats(Integer.parseInt(administratorView.getFatsTextField().getText()));
           b.setSodium(Integer.parseInt(administratorView.getSodiumTextField().getText()));





        }
    }
    public void raport1() throws FileNotFoundException {
        HashMap<Order,ArrayList<MenuItem>> orders;
        orders=Serializator.deserializeOrders();
        System.out.println(orders.size());
        int startHour =Integer.parseInt(administratorView.getInfoRaportTextField().getText());
        int endHour =Integer.parseInt(administratorView.getInfoRaportTextField2().getText());


        Set<Order> match= (Set<Order>) orders.keySet().stream().filter(o-> o.getOrderDate().getHour()>=startHour && o.getOrderDate().getHour()<endHour).collect(Collectors.toSet());

      //  for(Order o:match)
      //      System.out.println(o.getOrderDate().getHour());

        FileOutputStream fileOut =
                new FileOutputStream("Raport1 " +".txt");
        PrintStream printStream = new PrintStream(fileOut);
        String raport1="Comenzi intre orele " + startHour +" si" +endHour+" \n";

        for(Order o:match)
        {
            raport1+=o.toString()+"\n";
        }

        printStream.print(raport1);
    JOptionPane.showMessageDialog(administratorView,"Raport generat cu succes");
    }

    public void raport2() throws FileNotFoundException {HashMap<Order,ArrayList<MenuItem>> orders;
        orders=Serializator.deserializeOrders();
        FileOutputStream fileOut =
                new FileOutputStream("Raport2 " +".txt");
        PrintStream printStream = new PrintStream(fileOut);
        int moreThan=Integer.parseInt(administratorView.getInfoRaportTextField().getText());
        String raport2="Produsele care au fost comandate de mai mult de "+ moreThan+" ori sunt \n";
        ArrayList<MenuItem> prod=new ArrayList<MenuItem>();
        ArrayList<MenuItem>res=new ArrayList<MenuItem>();
        TreeSet<MenuItem>resultProducts =new TreeSet<MenuItem>();
        for(ArrayList<MenuItem> a:orders.values())
        {
            for(MenuItem m:a)
            {
                prod.add(m);
            }


        }
        products=Serializator.deserializeProducts();

        products.forEach(menuItems->{

            int count =(int) prod.stream().filter(x-> x.getTitle().equals(menuItems.getTitle())).count();
            if(count > moreThan)
            {
                resultProducts.add(menuItems);
            }
        });

        for(MenuItem m:resultProducts)
        {
            raport2+=m.getTitle()+"\n";
        }
        printStream.print(raport2);
        JOptionPane.showMessageDialog(administratorView,"Raport generat cu succes");
    }

    public void raport3() throws FileNotFoundException {
        int numberOfTimes =Integer.parseInt(administratorView.getInfoRaportTextField().getText());
        int moreThanSum =Integer.parseInt(administratorView.getInfoRaportTextField2().getText());
        String raport3="Persoane au avut mai mult de " +numberOfTimes +" comenzi cu valoarea mai mare de" +moreThanSum+"\n";
        HashMap<Order,ArrayList<MenuItem>> orders;
        orders=Serializator.deserializeOrders();
        ArrayList<User> clients=Serializator.deserializeClients();
        ArrayList<String>names=new ArrayList<String>();

        clients.forEach(client->{
         int  count = (int)orders.keySet().stream().filter(o-> o.getClientId()==client.getId() && o.getOrderPrice()>moreThanSum).count();

         if(count>numberOfTimes)
             names.add(client.getUsername());


        });
        for(String s:names)
        {
            raport3+=s+"\n";
        }
        FileOutputStream fileOut =
                new FileOutputStream("Raport3 " +".txt");
        PrintStream printStream = new PrintStream(fileOut);
        printStream.print(raport3);
        JOptionPane.showMessageDialog(administratorView,"Raport generat cu succes");
    }
    public void raport4() throws FileNotFoundException {
        System.out.println("a intrat");
        int dayofMonth =Integer.parseInt(administratorView.getInfoRaportTextField().getText());
        String raport4="Produse comandate in ziua " +dayofMonth+"\n";
        HashMap<Order,ArrayList<MenuItem>> orders;
       Set<MenuItem> products=new TreeSet<MenuItem>();
        orders=Serializator.deserializeOrders();

        Set<Order> productsOrdered = orders.keySet().stream().filter(x -> x.getOrderDate().getDayOfMonth() ==dayofMonth).collect(Collectors.toSet());

        for (Order order : productsOrdered) {
            if (orders.containsKey(order)) {
                products.addAll(orders.get(order).stream().collect(Collectors.toSet()));
            }
        }

        for(MenuItem m:products)
        {
            raport4+=m.toString()+" \n";
        }
        FileOutputStream fileOut =
                new FileOutputStream("Raport4 " +".txt");
        PrintStream printStream = new PrintStream(fileOut);
        printStream.print(raport4);
        JOptionPane.showMessageDialog(administratorView,"Raport generat cu succes");


    }

}
