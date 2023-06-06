package App;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
public class WelcomePage extends JFrame{
    private JLabel bunvenit;
    private String[] ButtonLabels;
    private JButton[] b;
    private Autoturisme auto;
    private Curse curse;
    private Polite polite;
    private int pozY;
    WelcomePage(String username){
        super("E-Taxi");
        setSize(600, 400);
        setLayout(null);
        pozY = 50;
        b = new JButton[5];
        ButtonLabels = new String[] {"Autoturisme", "Inregistrare cursa", "Schimbare parola", "Iesire"};
        for (int i = 0; i < ButtonLabels.length; i++){
            b[i] = new JButton(ButtonLabels[i]);
            b[i].setBounds(50, pozY, 200, 50);
            pozY+=50;
            add(b[i]);
        }
        setVisible(true);
    }
}
