package App;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class SignUp extends JFrame{
    private JLabel nume_utilizator, parola, confirmare_parola;
    private JTextField username;
    private JPasswordField password, conf_pass;
    private JButton inregistrare, anulare;
    SignUp(){
        super("E-Taxi: Formular de inregistrare");
        GridBagConstraints gbc = new GridBagConstraints();
        nume_utilizator = new JLabel("Nume utilizator");
        parola = new JLabel("Parola");
        confirmare_parola = new JLabel("Confirmare parola");
        username = new JTextField(20);
        password = new JPasswordField(20);
        conf_pass = new JPasswordField(20);
        inregistrare = new JButton("Inregistrare");
        anulare = new JButton("Inapoi");
        inregistrare.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (username.getText().equals("") || password.getPassword().equals("") || conf_pass.getPassword().equals(""))
                    JOptionPane.showMessageDialog(null, "Nu ati completat toate campurile.");
                else if (!password.getPassword().equals(conf_pass.getPassword()))
                    JOptionPane.showMessageDialog(null, "Parolele nu corespund");
                else{
                    JOptionPane.showMessageDialog(null, "V-ati inregistrat cu succes!");
                    dispose();
                }
            }
        });
        JPanel panel = new JPanel(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 5, 10, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(nume_utilizator, gbc);
        gbc.gridx++;
        panel.add(username, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(parola, gbc);
        gbc.gridx++;
        panel.add(password, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(confirmare_parola, gbc);
        gbc.gridx++;
        panel.add(conf_pass, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(inregistrare, gbc);
        gbc.gridx++;
        panel.add(anulare, gbc);
        this.add(panel, BorderLayout.CENTER);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setSize(400, 250);
    }
}
