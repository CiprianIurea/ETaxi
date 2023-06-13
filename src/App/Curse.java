package App;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Curse extends JFrame{
    private JTextField[] tf;
    private JLabel[] l;
    private String[] labels1, labels2;
    private String[] textfields = {"intrareServiciu", "kmIntern", "kmExtern", "kmNeplatiti", "consum", "pretCombustibil"};
    private String[] textfields2 = {"incasariinterne", "incasariexterne", "incasaristationar", "totalincasari", "platacomb", "rest"};
    private JButton save;
    private SalvareCursa sc;
    Curse(){
        setTitle("Inregistrare cursa");
        setSize(400, 350);
        setLayout(null);
        labels1 = new String[] {"Km intrare serviciu", "Km parcursi intern", "Km parcursi extern", 
                                "Km neplatiti", "Consum combustibil", "Pret combustibil"};
        labels2 = new String[] {"Data: ","Km iesire serviciu: ", "Incasari interne: ", "Incasari externe: ", "Incasari in mod stationar: ", 
                                "Total incasari: ", "Plata combustibil: ", "Rest monetar: "};
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
            String s = tf[i].getName();
            if (s.equals("intrareServiciu")){
                tf[i].setText("0");
                tf[i].setEnabled(false);
            }
                
            add(tf[i]);
            pozY+=30;
        }
        save = new JButton("Calculeaza");
        save.setBounds(125, pozY+30, 150, 50);
        save.addActionListener(sc);
        add(save);
        setVisible(true);
        
    }
    private class SalvareCursa implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == save){
                try{
                    for (int i = 0; i < textfields.length; i++){
                        Integer.parseInt(tf[i].getText());
                    }
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Nu s-au putut salva modificarile! Camp(uri) completate gresit. Incercari din nou");
                }
            }
        }
    }
    
}
