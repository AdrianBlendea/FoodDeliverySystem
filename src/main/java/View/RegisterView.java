package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class RegisterView extends JFrame {

    private JPanel contentPane;
    private JTextField username;
    private JTextField password;
    private JTextField email;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel emailLabel;
    private JButton createButton;


    public RegisterView() {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(100, 100, 665, 436);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

       username = new JTextField();
        username.setBounds(272, 79, 96, 19);
        contentPane.add(username);
        username.setColumns(10);

        password = new JTextField();
        password.setBounds(272, 155, 96, 19);
        contentPane.add(password);
        password.setColumns(10);

        email = new JTextField();
        email.setBounds(272, 234, 96, 19);
        contentPane.add(email);
        email.setColumns(10);

        usernameLabel = new JLabel("Nume utilizator");
        usernameLabel.setBounds(82, 82, 83, 13);
        contentPane.add(usernameLabel);

        passwordLabel = new JLabel("Parola");
        passwordLabel.setBounds(82, 158, 72, 13);
        contentPane.add(passwordLabel);

        emailLabel = new JLabel("Adresa Email");
        emailLabel.setBounds(82, 237, 83, 13);
        contentPane.add(emailLabel);

        createButton = new JButton("Creare cont");
        createButton.setVerticalAlignment(SwingConstants.BOTTOM);
        createButton.setBounds(253, 306, 115, 21);
        contentPane.add(createButton);
    }

    public void createListener (ActionListener actionListener)
    {
        this.createButton.addActionListener(actionListener);
    }

    public String getUsername ()
    {
        return this.username.getText();

    }

    public String getPassword ()
    {
        return this.password.getText();

    }

    public String getEmail ()
    {
        return this.email.getText();

    }
}
