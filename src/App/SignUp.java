package App;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class SignUp extends JPanel{
    private JLabel nume_utilizator, parola, confirmare_parola;
    private JTextField username;
    private JPasswordField password, conf_pass;
    private JButton inregistrare, anulare;
    SignUp(){
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(new GridBagLayout());
        setVisible(true);
        nume_utilizator = new JLabel("Nume utilizator");
        parola = new JLabel("Parola");
        confirmare_parola = new JLabel("Confirmare parola");
        username = new JTextField(20);
        password = new JPasswordField(20);
        conf_pass = new JPasswordField(20);
        inregistrare = new JButton("Inregistrare");
        anulare = new JButton("Inapoi");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 5, 10, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(nume_utilizator, gbc);
        gbc.gridx++;
        add(username, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        add(parola, gbc);
        gbc.gridx++;
        add(password, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        add(confirmare_parola, gbc);
        gbc.gridx++;
        add(conf_pass, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        add(inregistrare, gbc);
        gbc.gridx++;
        add(anulare, gbc);
    }
    public JButton getAnulareButton(){
        return anulare;
    }
    public JButton getInregistrareButton(){
        return inregistrare;
    }
    public String getUsername(){
        return username.getText();
    }
    public String getPassword(){
        return new String(password.getPassword());
    }
    public String getConfPass(){
        return new String(conf_pass.getPassword());
    }
    public void setUsername(String s){
        username.setText(s);
    }
    public void setPassword(String s){
        password.setText(s);
    }
    public void setConfPass(String s){
        conf_pass.setText(s);
    }
}
