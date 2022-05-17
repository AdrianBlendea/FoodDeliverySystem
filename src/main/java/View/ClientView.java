package View;

import Model.MenuItem;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientView extends JFrame {

    private JPanel comandaList;
    private JTextField priceText;
    private JLabel menuLabel;
    private JLabel orderLabel;
    private JLabel priceLabel;
    private JLabel filtersLabel;
    private JLabel minLabel;
    private JLabel maxLabel;
    private JLabel caloriiLabel;
    private JLabel grasimiLabel;
    private JLabel proteineLabel;
    private JLabel sodiuLabel;
    private JLabel pretLabel;
    private JTextField numeTextField;
    private JSpinner minCalorii;
    private JSpinner maxCalorii;
    private JSpinner maxProteins;
    private JSpinner minFats;
    private JSpinner maxFats;
    private JLabel ratingLabel;
    private JLabel numeLabel;
    private JSpinner maxSodium;
    private JSpinner minPrice;
    private JSpinner maxPrice;
    private JButton plaseazaButton;
    private JButton filterButton;
    private JButton resetFiltersButton;
    private JButton resetButton;
    private JSpinner minProteins;
    private JSpinner minRating;
    private JSpinner minSodium;
    private JSpinner maxRating;
    private JList<MenuItem> orderList;
    private JScrollPane orderPane;
    private JList<MenuItem>menuList;
    private JScrollPane menuPane;
    private  DefaultListModel<MenuItem> menu;
    private  DefaultListModel<MenuItem> order;
    private JButton addButton;
    private  JButton stergeButton;
    private JLabel welcomeLabel;

    /**
     * Launch the application.
     */

    public ClientView() {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(100, 100, 672, 448);
        comandaList = new JPanel();
        comandaList.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(comandaList);
        comandaList.setLayout(null);

        menuLabel = new JLabel("Menu");
        menuLabel.setBounds(75, 10, 61, 13);
        comandaList.add(menuLabel);

        orderLabel = new JLabel("Comanda Ta:");
        orderLabel.setBounds(468, 27, 96, 13);
        comandaList.add(orderLabel);

        priceText = new JTextField();
        priceText.setEditable(false);
        priceText.setBounds(522, 154, 96, 19);
        comandaList.add(priceText);
        priceText.setColumns(10);

        priceLabel = new JLabel("Pret:");
        priceLabel.setBounds(448, 157, 45, 13);
        comandaList.add(priceLabel);

        filtersLabel = new JLabel("Filtru");
        filtersLabel.setBounds(10, 231, 45, 13);
        comandaList.add(filtersLabel);

        minLabel = new JLabel("Min");
        minLabel.setBounds(91, 231, 45, 13);
        comandaList.add(minLabel);

        maxLabel = new JLabel("Max");
        maxLabel.setBounds(202, 231, 45, 13);
        comandaList.add(maxLabel);

        minRating = new JSpinner();
        minRating.setModel(new SpinnerNumberModel(0, 0, 10, 1));
        minRating.setBounds(75, 326, 45, 17);
        comandaList.add(minRating);

        maxRating = new JSpinner();
        maxRating.setModel(new SpinnerNumberModel(10, 0, 10, 1));
        maxRating.setBounds(190, 326, 45, 17);
        comandaList.add(maxRating);

        ratingLabel = new JLabel("Rating");
        ratingLabel.setBounds(10, 326, 45, 13);
        comandaList.add(ratingLabel);

        sodiuLabel = new JLabel("Sodiu:");
        sodiuLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        sodiuLabel.setBounds(10, 349, 45, 13);
        comandaList.add(sodiuLabel);

        pretLabel = new JLabel("Pret");
        pretLabel.setBounds(10, 372, 45, 13);
        comandaList.add(pretLabel);

        numeLabel = new JLabel("Nume");
        numeLabel.setBounds(10, 398, 45, 13);
        comandaList.add(numeLabel);

        caloriiLabel = new JLabel("Calorii:");
        caloriiLabel.setBounds(10, 254, 45, 13);
        comandaList.add(caloriiLabel);

        grasimiLabel = new JLabel("Grasimi(g)");
        grasimiLabel.setBounds(10, 303, 74, 13);
        comandaList.add(grasimiLabel);

        proteineLabel = new JLabel("Proteine(g)");
        proteineLabel.setBounds(10, 280, 61, 13);
        comandaList.add(proteineLabel);

        numeTextField = new JTextField();
        numeTextField.setBounds(69, 395, 96, 16);
        comandaList.add(numeTextField);
        numeTextField.setColumns(10);

        minCalorii = new JSpinner();
        minCalorii.setModel(new SpinnerNumberModel(0, 0, 5000, 1));
        minCalorii.setBounds(75, 254, 45, 19);
        comandaList.add(minCalorii);

        maxCalorii = new JSpinner();
        maxCalorii.setModel(new SpinnerNumberModel(5000, 0, 5000, 1));
        maxCalorii.setBounds(190, 254, 45, 19);
        comandaList.add(maxCalorii);

        minProteins = new JSpinner();
        minProteins.setModel(new SpinnerNumberModel(0, 0, 5000, 1));
        minProteins.setBounds(75, 277, 45, 16);
        comandaList.add(minProteins);

        maxProteins = new JSpinner();
        maxProteins.setModel(new SpinnerNumberModel(5000, 0, 5000, 1));
        maxProteins.setBounds(190, 277, 45, 16);
        comandaList.add(maxProteins);

        minFats = new JSpinner();
        minFats.setModel(new SpinnerNumberModel(0, 0, 5000, 1));
        minFats.setBounds(75, 303, 45, 19);
        comandaList.add(minFats);

        maxFats = new JSpinner();
        maxFats.setModel(new SpinnerNumberModel(5000, 0, 5000, 1));
        maxFats.setBounds(190, 300, 45, 16);
        comandaList.add(maxFats);

        minSodium = new JSpinner();
        minSodium.setModel(new SpinnerNumberModel(0, 0, 5000, 1));
        minSodium.setBounds(75, 349, 45, 19);
        comandaList.add(minSodium);

        maxSodium = new JSpinner();
        maxSodium.setModel(new SpinnerNumberModel(5000, 0, 5000, 1));
        maxSodium.setBounds(190, 349, 45, 19);
        comandaList.add(maxSodium);

        minPrice = new JSpinner();
        minPrice.setModel(new SpinnerNumberModel(0, 0, 5000, 1));
        minPrice.setBounds(75, 372, 45, 19);
        comandaList.add(minPrice);

        maxPrice = new JSpinner();
        maxPrice.setModel(new SpinnerNumberModel(5000, 0, 5000, 1));
        maxPrice.setBounds(190, 369, 45, 16);
        comandaList.add(maxPrice);

        plaseazaButton = new JButton("Plaseaza comanda");
        plaseazaButton.setBounds(339, 180, 117, 21);
        comandaList.add(plaseazaButton);

        resetButton = new JButton("Reseteaza comanda");
        resetButton.setBounds(480, 180, 138, 21);
        comandaList.add(resetButton);

        filterButton = new JButton("Filtreaza");
        filterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        filterButton.setBounds(258, 272, 85, 21);
        comandaList.add(filterButton);

        resetFiltersButton = new JButton("Reseteaza filtre");
        resetFiltersButton.setBounds(258, 322, 110, 21);
        comandaList.add(resetFiltersButton);

       menu = new DefaultListModel<>();
    order=new DefaultListModel<>();

     //   JTextArea s=new JTextArea();
       // s.setText("faj8afsj8igdajhigdsaji[dasno[");
        //s.setBounds(250, 190, -218, -150);
        menuList = new JList<>(menu);;
        menuPane = new JScrollPane(menuList,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
       menuPane.setBounds(10, 50, 279, 151);

        comandaList.add(menuPane);




        orderList = new JList<>(order);
       orderPane = new JScrollPane(orderList,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        orderPane.setBounds(339, 50, 279, 96);
        comandaList.add(orderPane);


         addButton = new JButton("Adauga");
        addButton.setBounds(347, 23, 85, 21);
        comandaList.add(addButton);



         stergeButton = new JButton("Sterge");
        stergeButton.setBounds(537, 23, 85, 21);
        comandaList.add(stergeButton);


         welcomeLabel = new JLabel("New label");
        welcomeLabel.setBounds(519, 303, 130, 13);
        comandaList.add(welcomeLabel);


    }


    public DefaultListModel<MenuItem> getMenu() {
        return menu;
    }


    public DefaultListModel<MenuItem> getOrder() {
        return order;
    }

    public JList<MenuItem> getMenuList() {
        return menuList;
    }


    public JTextField getPriceText() {
        return priceText;
    }

    public JList<MenuItem> getOrderList() {
        return orderList;
    }

    public void addToOrderListener (ActionListener actionListener)
    {
        this.addButton.addActionListener(actionListener);
    }

    public void deleteFromOrderListener (ActionListener actionListener)
    {
        this.stergeButton.addActionListener(actionListener);
    }

    public void resetOrderListener (ActionListener actionListener)
    {
        this.resetButton.addActionListener(actionListener);
    }

    public void placeOrderListener (ActionListener actionListener)
    {
        this.plaseazaButton.addActionListener(actionListener);

    }

    public void filterListener (ActionListener actionListener)
    {
        this.filterButton.addActionListener(actionListener);

    }

    public void resetFilterListener (ActionListener actionListener)
    {
        this.resetFiltersButton.addActionListener(actionListener);

    }


    public JSpinner getMinCalorii() {
        return minCalorii;
    }

    public JSpinner getMaxCalorii() {
        return maxCalorii;
    }

    public JSpinner getMaxProteins() {
        return maxProteins;
    }

    public JSpinner getMinFats() {
        return minFats;
    }

    public JSpinner getMaxFats() {
        return maxFats;
    }

    public JSpinner getMaxSodium() {
        return maxSodium;
    }

    public JSpinner getMinPrice() {
        return minPrice;
    }

    public JSpinner getMaxPrice() {
        return maxPrice;
    }

    public JSpinner getMinProteins() {
        return minProteins;
    }

    public JSpinner getMinRating() {
        return minRating;
    }

    public JSpinner getMinSodium() {
        return minSodium;
    }

    public JSpinner getMaxRating() {
        return maxRating;
    }

    public JLabel getWelcomeLabel() {
        return welcomeLabel;
    }

    public JTextField getNumeTextField() {
        return numeTextField;
    }
}
