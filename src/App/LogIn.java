package App;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class LogIn extends JFrame{
    private JLabel l1, l2;
    private JTextField username;
    private JPasswordField password;
    private JButton login, signin;
    LogIn(){
        super("E-Taxi");
        GridBagConstraints gbc = new GridBagConstraints();
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
            }
        });
        signin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                SignUp inregistrare = new SignUp();
            }
            
        });
        JPanel panel = new JPanel(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 10, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(l1, gbc);
        gbc.gridx++;
        panel.add(username, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(l2, gbc);
        gbc.gridx++;
        panel.add(password, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.insets = new Insets(20, 5, 0, 5);
        panel.add(login, gbc);
        gbc.gridx++;
        panel.add(signin, gbc);
        this.add(panel, BorderLayout.CENTER);
    }
}
