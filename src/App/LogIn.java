package App;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class LogIn extends JPanel{
    private JLabel l1, l2;
    private JTextField username;
    private JPasswordField password;
    private JButton login, signin;
    LogIn(){
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(new GridBagLayout());
        setVisible(true);
        l1 = new JLabel("Nume utilizator");
        l2 = new JLabel("Parola");
        username = new JTextField(20);
        password = new JPasswordField(20);
        login = new JButton("Conectare");
        signin = new JButton("Inregistrare");
        login.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!username.getText().equals("admin") && !password.getPassword().equals("admin")){
                    JOptionPane.showMessageDialog(null, "Nume de utilizator sau parola incorecte.");
                    username.setText("");
                    password.setText("");
                }
                else{
                    WelcomePage wp = new WelcomePage(username.getText());
                }
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 10, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(l1, gbc);
        gbc.gridx++;
        add(username, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        add(l2, gbc);
        gbc.gridx++;
        add(password, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.insets = new Insets(20, 5, 0, 5);
        add(login, gbc);
        gbc.gridx++;
        add(signin, gbc);
    }
    public String getUsername(){
        return username.getText();
    }
    public String getPassword(){
        String parola = new String(password.getPassword());
        return parola;
    }
    public JButton getSignInButton(){
        return signin;
    }
    public void setUsername(String user){
        username.setText(user);
    }
    public void setPassword(String pass){
        password.setText(pass);
    }
}
