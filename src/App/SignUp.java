package App;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class SignUp extends JFrame{
    private AscultatorButoane ab;
    private JLabel nume_utilizator, parola, confirmare_parola;
    private JTextField username;
    private JPasswordField password, conf_pass;
    private JButton inregistrare, anulare;
    private PrintWriter pw;
    SignUp(){
        setTitle("Inregistrare E-Taxi");
        setSize(400, 400);
        setLayout(null);
        ab = new AscultatorButoane();
        nume_utilizator = new JLabel("Nume utilizator");
        parola = new JLabel("Parola");
        confirmare_parola = new JLabel("Confirmare parola");
        username = new JTextField(20);
        password = new JPasswordField(20);
        conf_pass = new JPasswordField(20);
        inregistrare = new JButton("Inregistrare");
        anulare = new JButton("Inapoi");
        nume_utilizator.setBounds(50, 50, 150, 25);
        parola.setBounds(50, 100, 150, 25);
        confirmare_parola.setBounds(50, 150, 150, 25);
        username.setBounds(160, 50, 150, 25);
        password.setBounds(160, 100, 150, 25);
        conf_pass.setBounds(160, 150, 150, 25);
        inregistrare.setBounds(50, 250, 150, 50);
        anulare.setBounds(200, 250, 150, 50);
        inregistrare.addActionListener(ab);
        anulare.addActionListener(ab);
        add(nume_utilizator);
        add(parola);
        add(confirmare_parola);
        add(username); add(password); add(conf_pass);
        add(inregistrare); add(anulare);
        setVisible(true);
    }
    private class AscultatorButoane implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == inregistrare){
                if (username.getText().equals("") && new String(password.getPassword()).equals("") && new String(conf_pass.getPassword()).equals("")){
                    JOptionPane.showMessageDialog(null, "Nu ati completat toate campurile");
                    username.setText("");
                    password.setText("");
                    conf_pass.setText("");
                }
                else if (!new String(password.getPassword()).equals(new String(conf_pass.getPassword()))){
                    JOptionPane.showMessageDialog(null, "Parolele nu corespund");
                }
                else{
                    try {
                        pw = new PrintWriter(new FileWriter("credentiale.txt"));
                        pw.println(username.getText());
                        pw.println(new String(password.getPassword()));
                        pw.close();
                    } catch (IOException ex) {
                        Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    LogIn conectare = new LogIn();
                    conectare.setLocationRelativeTo(null);
                    conectare.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    dispose();
                }
            }
            else if (e.getSource() == anulare){
                int result = JOptionPane.showConfirmDialog(null, "Esti sigur ca doresti sa parasesti aceasta pagina? Modificarile nu vor fi salvate", getTitle(), JOptionPane.YES_NO_OPTION);
                if (result == 0){
                    LogIn conectare = new LogIn();
                    conectare.setLocationRelativeTo(null);
                    conectare.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    dispose();
                }
            }
        }
        
    }
}
