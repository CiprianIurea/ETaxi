package App;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
public class WelcomePage extends JFrame{
    private JLabel bunvenit, info;
    private String[] ButtonLabels;
    private JButton[] b;
    private JButton ok;
    private Curse curse;
    private int pozY;
    private GestorEvenimente ge;
    private String username;
    private String[] z, l, a;
    private JComboBox zi, luna, an;
    WelcomePage(String username){
        super("E-Taxi");
        setSize(700, 400);
        setLayout(null);
        pozY = 50;
        ge = new GestorEvenimente();
        ButtonLabels = new String[] {"Autoturisme", "Inregistrare cursa", "Adaugare polite","Schimbare parola", "Iesire"};
        b = new JButton[ButtonLabels.length];
        for (int i = 0; i < ButtonLabels.length; i++){
            b[i] = new JButton(ButtonLabels[i]);
            b[i].setBounds(50, pozY, 200, 50);
            b[i].addActionListener(ge);
            pozY+=50;
            add(b[i]);
        }
        bunvenit = new JLabel(username);
        bunvenit.setBounds(400, 50, 100, 25);
        bunvenit.setFont(new Font("Calibri", Font.PLAIN, 18));
        add(bunvenit);
        info = new JLabel("Informatii din: ");
        info.setBounds(300, 75, 100, 25);
        add(info);
        z = new String[32];
        z[0] = "Zi";
        for (int i = 1; i <= 31; i++){
            z[i] = String.valueOf(i);
        }
        zi = new JComboBox(z);
        zi.setBounds(400, 75, 75, 25);
        add(zi);
        l = new String[] {"Luna", "Ianuarie", "Februarie", "Martie", "Aprilie", "Mai", "Iunie",
                             "Iulie", "August", "Septembrie", "Octombrie", "Decembrie"};
        luna = new JComboBox(l);
        luna.setBounds(475, 75, 100, 25);
        add(luna);
        Calendar data = Calendar.getInstance();
        a = new String[] {"An", String.valueOf(data.get(Calendar.YEAR)), String.valueOf(data.get(Calendar.YEAR)-1), String.valueOf(data.get(Calendar.YEAR)+1)};
        an = new JComboBox(a);
        an.setBounds(575, 75, 100, 25);
        add(an);
        setVisible(true);
        this.username = username;
    }
    private class GestorEvenimente implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == b[0]){
                Autoturisme auto = new Autoturisme();
                auto.setLocationRelativeTo(null);
            }
            else if (e.getSource() == b[1]){
                Curse cursa = new Curse();
                cursa.setLocationRelativeTo(null);
            }
            else if (e.getSource() == b[2]){
                Polite polita = new Polite();
                polita.setLocationRelativeTo(null);
            }
            else if (e.getSource() == b[3]){
                SchimbareParola sp = new SchimbareParola(username);
                sp.setLocationRelativeTo(null);
            }
            else{
                int result;
                result = JOptionPane.showConfirmDialog(null, "Esti sigur/a ca doresti sa parasesti aplicatia?", "E-Taxi", JOptionPane.YES_NO_OPTION);
                if (result == 0)
                    System.exit(0);
            }
        }
        
    }
}
