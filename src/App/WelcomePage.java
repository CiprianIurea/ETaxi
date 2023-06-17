package App;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class WelcomePage extends JFrame{
    private JLabel info;
    private String[] ButtonLabels;
    private JButton[] b;
    private JButton ok;
    private int pozY;
    private GestorEvenimente ge;
    private String username;
    private String[] z, l, luna30, luna31, luna28,a;
    private JComboBox zi, luna, an;
    private JTextArea ta;
    private Calendar data = Calendar.getInstance();
    private Data d;
    WelcomePage(String username){
        super("E-Taxi -> " + username);
        setSize(900, 400);
        setLayout(null);
        d = new Data();
        pozY = 25;
        ge = new GestorEvenimente();
        ButtonLabels = new String[] {"Inregistrare autoturism", "Inregistrare cursa", "Adaugare polita","Schimbare parola", "Dezactivare cont","Iesire"};
        b = new JButton[ButtonLabels.length];
        for (int i = 0; i < ButtonLabels.length; i++){
            b[i] = new JButton(ButtonLabels[i]);
            b[i].setBounds(50, pozY, 200, 50);
            b[i].addActionListener(ge);
            b[i].setFocusable(false);
            pozY+=50;
            add(b[i]);
        }
        info = new JLabel("Informatii din: ");
        info.setBounds(300, 25, 100, 25);
        add(info);
        z = new String[32];
        z[0] = "Zi";
        for (int i = 1; i <= 31; i++){
            z[i] = String.valueOf(i);
        }
        zi = new JComboBox(z);
        zi.setBounds(400, 25, 75, 25);
        zi.addActionListener(d);
        add(zi);
        l = new String[] {"Luna", "January", "February", "March", "April", "May", "June",
                             "July", "August", "September", "October", "November","December"};
        luna30 = new String[] {"Luna", "April", "June", "September", "November", "December"};
        luna31 = new String[] {"Luna", "January", "March", "May", "July", "August", "October", "December"};
        luna = new JComboBox(l);
        luna.setBounds(475, 25, 100, 25);
        luna.addActionListener(d);
        add(luna);
        a = new String[] {"An", String.valueOf(data.get(Calendar.YEAR)), String.valueOf(data.get(Calendar.YEAR)-1)};
        an = new JComboBox(a);
        an.setBounds(575, 25, 100, 25);
        an.addActionListener(d);
        add(an);
        ta = new JTextArea();
        ta.setEnabled(false);
        JScrollPane scroll = new JScrollPane (ta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(300, 75, 500, 275);
        add(scroll);
        ok = new JButton("Ok");
        ok.setBounds(700, 25, 50, 25);
        ok.addActionListener(ge);
        add(ok);
        setVisible(true);
        this.username = username;
    }
    private class GestorEvenimente implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == b[0]){
                AutoturismNouFrame auto = new AutoturismNouFrame(username);
                auto.setLocationRelativeTo(null);
            }
            else if (e.getSource() == b[1]){
                Curse cursa = new Curse(username);
                cursa.setLocationRelativeTo(null);
            }
            else if (e.getSource() == b[2]){
                Polite polita = new Polite(username);
                polita.setLocationRelativeTo(null);
            }
            else if (e.getSource() == b[3]){
                SchimbareParola sp = new SchimbareParola(username);
                sp.setLocationRelativeTo(null);
            }
            else if (e.getSource() == b[4]){
                DezactivareCont dc = new DezactivareCont();
                try {
                    if (dc.raspuns(username)){
                        JOptionPane.showMessageDialog(null, "Contul dvs a fost dezactivat cu succes!");
                        dispose();
                        LogIn login = new LogIn();
                        login.setLocationRelativeTo(null);
                        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Contul nu a putut fi dezactivat.");
                } catch (IOException ex) {
                    Logger.getLogger(WelcomePage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(e.getSource() == ok){
                String s = String.valueOf(zi.getSelectedItem())+String.valueOf(luna.getSelectedItem())+String.valueOf(an.getSelectedItem());
                   String.valueOf(data.get(Calendar.YEAR));
                AfisareInfo ai = new AfisareInfo(s, username);
                ta.setText(ai.afiseazaAuto());
            }
            else{
                int result;
                result = JOptionPane.showConfirmDialog(null, "Esti sigur/a ca doresti sa parasesti aplicatia?", "E-Taxi", JOptionPane.YES_NO_OPTION);
                if (result == 0)
                    System.exit(0);
            }
        }
        
    }
    private class Data implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == zi){
                String n = (String)zi.getSelectedItem();
                switch (n){
                    case "29":
                        if (luna.getSelectedItem().equals("Februarie")){
                            a = new String[] {"An", String.valueOf(data.get(Calendar.YEAR)+1)};
                            DefaultComboBoxModel <String> model = new DefaultComboBoxModel<>(a);
                            an.setModel(model);
                        }
                        break;
                    case "30":
                        DefaultComboBoxModel <String> model = new DefaultComboBoxModel<>(luna30);
                        luna.setModel(model);
                        break;
                    case "31":
                        DefaultComboBoxModel <String> model1 = new DefaultComboBoxModel<>(luna31);
                        luna.setModel(model1);
                        break;
                    default:
                        DefaultComboBoxModel <String> model2 = new DefaultComboBoxModel<>(l);
                        luna.setModel(model2);
                        break;
                }
            }
        }
    }
}
