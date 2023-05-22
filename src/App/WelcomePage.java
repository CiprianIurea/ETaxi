package App;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
public class WelcomePage extends JFrame{
    private JLabel bunvenit;
    private JButton inregAuto, cursa, polite, changePass, exit;
    WelcomePage(String username){
        super("E-Taxi");
        setSize(600, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        GridBagConstraints gbc = new GridBagConstraints();
        JPanel panel = new JPanel();
        bunvenit = new JLabel("Bun venit " + username + "!");
        gbc.gridx = 1;
        gbc.gridy = 0;
    }
}
