package App;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class ETaxi extends JFrame{
    ETaxi(){
        super("E-Taxi");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    public static void main (String[] args){
        ETaxi app = new ETaxi();
        LogIn conectare = new LogIn();
        SignUp inreg = new SignUp();
        app.add(conectare, BorderLayout.NORTH);
        conectare.getSignInButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                app.add(inreg, BorderLayout.NORTH);
                inreg.setVisible(true);
                conectare.setVisible(false);
            }
        });
        inreg.getAnulareButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "Esti sigur ca doresti sa parasesti pagina?", null, JOptionPane.YES_NO_OPTION);
                if (result == 0){
                    inreg.setVisible(false);
                    conectare.setUsername("");
                    conectare.setPassword("");
                    conectare.setVisible(true);
                }
            }
        });
        inreg.getInregistrareButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (inreg.getUsername().equals("") || inreg.getPassword().equals("") || inreg.getConfPass().equals(""))
                    JOptionPane.showMessageDialog(null, "Nu ati completat toate campurile.");
                else if (!inreg.getPassword().equals(inreg.getConfPass()))
                    JOptionPane.showMessageDialog(null, "Parolele nu corespund");
                else
                    JOptionPane.showMessageDialog(null, "V-ati inregistrat cu succes!");
                    inreg.setUsername("");
                    inreg.setPassword("");
                    inreg.setConfPass("");
                    inreg.setVisible(false);
                    conectare.setVisible(true);
            }
            
        });
        app.setVisible(true);
    }
}
