package View;

import Model.MenuItem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class AdministratorView extends JFrame {

    private JPanel contentPane;
    private JList menuList;
    private JList newMenuList;
    private JScrollPane menuListPane;
    private JScrollPane newMenuListPane;
    private JLabel newMeniuLabel;
    private JTextField numeTextField;
    private JLabel nameLabel;
    private JButton adaugaButton;
    private JButton finishButton;
    private JButton bazaButton;
    private JButton importCsvButton;
    private DefaultListModel<MenuItem> menu;
    private  DefaultListModel<MenuItem> compositeProduct;
    private JButton stergeButton;
    private  JButton addBaseButton;
    private  JButton modifyBaseButton;
    private  JButton deleteBaseButton;
    private JButton loadToModify;
    private JTextField titleTextField;
    private JTextField priceTextField;
    private JTextField ratingTextField;
    private JTextField caloriesTextField;
    private JTextField proteinsTextField;
    private JTextField fatsTextField;
    private JTextField sodiumTextField;
    private JLabel titluLAbel;
    private JLabel priceLabel;
    private JLabel ratingLabel;
    private JLabel caloriesLabel;
    private JLabel proteinsLabel;
    private JLabel fatsLabel;
    private JLabel Sodium;
    private JButton raport1Button;
    private JButton raport2Button;
    private JButton raport3Button;
    private JButton raport4Button;
    private JTextField infoRaportTextField;
    private JTextField infoRaportTextField2;


    public AdministratorView() {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(100, 100, 671, 450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        menu = new DefaultListModel<>();
        menuList = new JList<>(menu);
         menuListPane= new JScrollPane(menuList,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        menuListPane.setBounds(35, 58, 272, 158);

        contentPane.add(menuListPane);

        compositeProduct =new DefaultListModel<>();

        newMenuList = new JList(compositeProduct);
        newMenuListPane= new JScrollPane(newMenuList,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        newMenuListPane.setBounds(395, 65, 232, 113);
        contentPane.add(newMenuListPane);

        JLabel curentLabel = new JLabel("Meniu curent:");
        curentLabel.setBounds(128, 35, 98, 13);
        contentPane.add(curentLabel);

        newMeniuLabel = new JLabel("Creare meniu nou");
        newMeniuLabel.setBounds(478, 35, 104, 13);
        contentPane.add(newMeniuLabel);

        numeTextField = new JTextField();
        numeTextField.setBounds(517, 199, 110, 19);
        contentPane.add(numeTextField);
        numeTextField.setColumns(10);

        nameLabel = new JLabel("Nume Meniu");
        nameLabel.setBounds(395, 202, 88, 14);
        contentPane.add(nameLabel);

        adaugaButton = new JButton("Adauga la meniu");
        adaugaButton.setBounds(367, 236, 126, 21);
        contentPane.add(adaugaButton);

        finishButton = new JButton("Finalizare meniu");
        finishButton.setBounds(527, 236, 120, 21);
        contentPane.add(finishButton);

        importCsvButton = new JButton("Din CSV");
        importCsvButton.setBounds(33, 31, 85, 21);
        contentPane.add(importCsvButton);

        bazaButton = new JButton("Din baza");
        bazaButton.setBounds(209, 31, 85, 21);
        contentPane.add(bazaButton);


        stergeButton = new JButton("Sterge din meniu");
        stergeButton.setBounds(367, 267, 126, 21);
        contentPane.add(stergeButton);


         addBaseButton = new JButton("Add");

        addBaseButton.setBounds(10, 236, 85, 21);
        contentPane.add(addBaseButton);

         modifyBaseButton = new JButton("Modify");

        modifyBaseButton.setBounds(114, 236, 85, 21);
        contentPane.add(modifyBaseButton);

        deleteBaseButton = new JButton("Delete");
        deleteBaseButton.setBounds(222, 236, 85, 21);
        contentPane.add(deleteBaseButton);


        loadToModify = new JButton("LoadToModify");
        loadToModify.setBounds(114, 267, 98, 21);
        contentPane.add(loadToModify);

        titleTextField = new JTextField();
        titleTextField.setBounds(69, 299, 96, 19);
        contentPane.add(titleTextField);
        titleTextField.setColumns(10);

        priceTextField = new JTextField();
        priceTextField.setBounds(69, 328, 96, 19);
        contentPane.add(priceTextField);
        priceTextField.setColumns(10);

        ratingTextField = new JTextField();
        ratingTextField.setBounds(69, 357, 96, 19);
        contentPane.add(ratingTextField);
        ratingTextField.setColumns(10);

        caloriesTextField = new JTextField();
        caloriesTextField.setBounds(69, 384, 96, 19);
        contentPane.add(caloriesTextField);
        caloriesTextField.setColumns(10);

        proteinsTextField = new JTextField();
        proteinsTextField.setBounds(247, 299, 96, 19);
        contentPane.add(proteinsTextField);
        proteinsTextField.setColumns(10);

        fatsTextField = new JTextField();
        fatsTextField.setBounds(247, 328, 96, 19);
        contentPane.add(fatsTextField);
        fatsTextField.setColumns(10);

        sodiumTextField = new JTextField();
        sodiumTextField.setBounds(247, 357, 96, 19);
        contentPane.add(sodiumTextField);
        sodiumTextField.setColumns(10);

        titluLAbel = new JLabel("Title");
        titluLAbel.setBounds(14, 302, 45, 13);
        contentPane.add(titluLAbel);

        priceLabel = new JLabel("Price");
        priceLabel.setBounds(14, 331, 45, 13);
        contentPane.add(priceLabel);

        ratingLabel = new JLabel("Rating");
        ratingLabel.setBounds(14, 360, 45, 13);
        contentPane.add(ratingLabel);

        caloriesLabel = new JLabel("Calories");
        caloriesLabel.setBounds(10, 387, 45, 13);
        contentPane.add(caloriesLabel);

        proteinsLabel = new JLabel("Proteins");
        proteinsLabel.setBounds(190, 298, 45, 13);
        contentPane.add(proteinsLabel);

        fatsLabel = new JLabel("Fats");
        fatsLabel.setBounds(192, 331, 45, 13);
        contentPane.add(fatsLabel);

        Sodium = new JLabel("sodiumLabel");
        Sodium.setBounds(190, 360, 45, 13);
        contentPane.add(Sodium);

        raport1Button = new JButton("Raport1");
        raport1Button.setBounds(367, 298, 85, 21);
        contentPane.add(raport1Button);

        raport2Button = new JButton("Raport2");
        raport2Button.setBounds(367, 327, 85, 21);
        contentPane.add(raport2Button);

        raport3Button = new JButton("Raport3");


        raport3Button.setBounds(367, 356, 85, 21);
        contentPane.add(raport3Button);

        raport4Button = new JButton("Raport4");
        raport4Button.setBounds(367, 383, 85, 21);
        contentPane.add(raport4Button);

        infoRaportTextField = new JTextField();
        infoRaportTextField.setBounds(478, 328, 96, 19);
        contentPane.add(infoRaportTextField);
        infoRaportTextField.setColumns(10);

        infoRaportTextField2 = new JTextField();
        infoRaportTextField2.setBounds(478, 357, 96, 19);
        contentPane.add(infoRaportTextField2);
        infoRaportTextField2.setColumns(10);
    }

    public void dinCsvListener (ActionListener actionListener)
    {
        this.importCsvButton.addActionListener(actionListener);

    }

    public void adaugaListener (ActionListener actionListener)
    {
        this.adaugaButton.addActionListener(actionListener);

    }

    public void stergeListener (ActionListener actionListener)
    {
        this.stergeButton.addActionListener(actionListener);

    }

    public void creareListener (ActionListener actionListener)
    {
        this.finishButton.addActionListener(actionListener);

    }

    public void dinBazaListener (ActionListener actionListener)
    {
        this.bazaButton.addActionListener(actionListener);

    }
    public void addBase (ActionListener actionListener)
    {
        this.addBaseButton.addActionListener(actionListener);

    }

    public void modifyBase (ActionListener actionListener)
    {
        this.modifyBaseButton.addActionListener(actionListener);

    }
public void loadToModify (ActionListener actionListener)
{
    this.loadToModify.addActionListener(actionListener);
}

    public void deleteBase (ActionListener actionListener)
    {
        this.deleteBaseButton.addActionListener(actionListener);

    }

    public void raport1Listenr (ActionListener actionListener)
    {
        this.raport1Button.addActionListener(actionListener);

    }
    public void raport2Listenr (ActionListener actionListener)
    {
        this.raport2Button.addActionListener(actionListener);

    }

    public void raport3Listenr (ActionListener actionListener)
    {
        this.raport3Button.addActionListener(actionListener);

    }
    public void raport4Listenr (ActionListener actionListener)
    {
        this.raport4Button.addActionListener(actionListener);

    }
    public DefaultListModel<MenuItem> getMenu() {
        return menu;
    }

    public JList getMenuList() {
        return menuList;
    }

    public JList getNewMenuList() {
        return newMenuList;
    }

    public DefaultListModel<MenuItem> getCompositeProduct() {
        return compositeProduct;
    }

    public String getNume()
    {
         return this.numeTextField.getText();
    }

    public JTextField getTitleTextField() {
        return titleTextField;
    }

    public JTextField getPriceTextField() {
        return priceTextField;
    }

    public JTextField getRatingTextField() {
        return ratingTextField;
    }

    public JTextField getCaloriesTextField() {
        return caloriesTextField;
    }

    public JTextField getProteinsTextField() {
        return proteinsTextField;
    }

    public JTextField getFatsTextField() {
        return fatsTextField;
    }

    public JTextField getSodiumTextField() {
        return sodiumTextField;
    }

    public JTextField getInfoRaportTextField() {
        return infoRaportTextField;
    }

    public JTextField getInfoRaportTextField2() {
        return infoRaportTextField2;
    }
}
