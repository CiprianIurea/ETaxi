package App;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Locale;

public class Curse extends JFrame{
    private JTextField[] tf;
    private JLabel[] l;
    private String[] labels1; 
    private String[] textfields = {"intrareServiciu", "kmIntern", "kmExtern", "kmNeplatiti", "timpStationar","consum", "pretCombustibil"};
    private JButton save;
    private SalvareCursa sc;
    private String username;
    Curse(String username){
        setTitle("Inregistrare cursa");
        setSize(400, 350);
        setLayout(null);
        this.username = username;
        labels1 = new String[] {"Km intrare serviciu", "Km parcursi intern", "Km parcursi extern", 
                                "Km neplatiti", "Timp stationar: ","Consum combustibil", "Pret combustibil"};
        l = new JLabel[labels1.length];
        tf = new JTextField[textfields.length];
        sc = new SalvareCursa();
        int pozY = 25;
        for (int i = 0; i < labels1.length; i++){
            l[i] = new JLabel(labels1[i]);
            l[i].setBounds(50, pozY, 150, 25);
            add(l[i]);
            pozY+=30;
        }
        pozY = 25;
        for (int i = 0; i < textfields.length; i++){
            tf[i] = new JTextField();
            tf[i].setName(textfields[i]);
            tf[i].setBounds(200, pozY, 150, 25);
            add(tf[i]);
            pozY+=30;
        }
        this.tf = tf;
        save = new JButton("Calculeaza");
        save.setBounds(125, pozY+30, 150, 50);
        save.addActionListener(sc);
        save.setFocusable(false);
        add(save);
        setVisible(true);
    }
    Curse(){};
    public String getKmInterni(JTextField[] tf){
        for (int i = 0; i < textfields.length; i++){
            if (tf[i].getName().equals("kmIntern"))
                return tf[i].getText();
        }
        return null;
    }
    public String getKmExterni(JTextField[] tf){
        for (int i = 0; i < textfields.length; i++){
            if (tf[i].getName().equals("kmExtern"))
                return tf[i].getText();
        }
        return null;
    }
    public String getKmNeplatiti(JTextField[] tf){
        for (int i = 0; i < textfields.length; i++){
            if (tf[i].getName().equals("kmNeplatiti"))
                return tf[i].getText();
        }
        return null;
    }
    public String getTimpStationar(JTextField[] tf){
        for (int i = 0; i < textfields.length; i++){
            if (tf[i].getName().equals("timpStationar"))
                return tf[i].getText();
        }
        return null;
    }
    public String getConsum(JTextField[] tf){
        for (int i = 0; i < textfields.length; i++){
            if (tf[i].getName().equals("consum"))
                return tf[i].getText();
        }
        return null;
    }
    public String getPret(JTextField[] tf){
        for (int i = 0; i < textfields.length; i++){
            if (tf[i].getName().equals("pretCombustibil"))
                return tf[i].getText();
        }
        return null;
    }
    private class SalvareCursa implements ActionListener{
        private GestionareCursa gc;
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == save){
                try{
                    for (int i = 1; i < textfields.length; i++){
                        Float.parseFloat(tf[i].getText());
                    }
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Nu s-au putut salva modificarile! Camp(uri) completate gresit. Incercari din nou");
                }
                gc = new GestionareCursa(username);
                if (gc.Profit(tf) == 0)
                    dispose();
            }
        }
    
    }  
}
