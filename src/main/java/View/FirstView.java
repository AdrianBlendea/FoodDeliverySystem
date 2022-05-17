package View;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class FirstView extends JFrame {

    private JPanel contentPane;
    private JLabel userLabel;
    private JTextField userText;
    private JTextField passwordText;
    private JLabel passwordLabel;
    private JButton loginButton;
    private JLabel contLabel;
    private JButton inregistrareButton;


    public FirstView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 655, 528);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        userLabel = new JLabel("Nume utilizator:");
        userLabel.setBounds(73, 151, 104, 24);
        contentPane.add(userLabel);

        userText = new JTextField();
        userText.setBounds(242, 154, 112, 21);
        contentPane.add(userText);
        userText.setColumns(10);

        passwordText = new JTextField();
        passwordText.setBounds(242, 219, 112, 19);
        contentPane.add(passwordText);
        passwordText.setColumns(10);

        passwordLabel = new JLabel("Parola:");
        passwordLabel.setBounds(73, 219, 72, 16);
        contentPane.add(passwordLabel);

        loginButton = new JButton("Autentificare");
        loginButton.setBounds(200, 287, 178, 34);
        contentPane.add(loginButton);

        contLabel = new JLabel("Nu aveti cont ?");
        contLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contLabel.setBounds(46, 352, 469, 13);
        contentPane.add(contLabel);

        inregistrareButton = new JButton("Inregistrare");
        inregistrareButton.setBounds(200, 398, 175, 34);
        contentPane.add(inregistrareButton);
    }

    public void inregisrareListener (ActionListener actionListener)
    {
        this.inregistrareButton.addActionListener(actionListener);
    }

    public void autentificareListener (ActionListener actionListener)
    {
        this.loginButton.addActionListener(actionListener);
    }
    public String getUsername (){
     return userText.getText();

    }

    public String getPassword ()
    {
        return passwordText.getText();

    }


}
