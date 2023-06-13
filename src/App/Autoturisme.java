package App;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Autoturisme extends JFrame{
    private JLabel[] l;
    private JTextField[] tf;
    private JButton save;
    private String[] tflabels = {"nume", "serie", "nr", "km"};
    private int d;
    private SalvareAuto sa;
    Autoturisme(){
        setTitle("Autoturisme E-Taxi");
        setSize(350, 250);
        setLayout(null);
        int pozY = 25;
        sa = new SalvareAuto();
        String[] labels = {"Nume model", "Serie sasiu", "Numar inmatriculare", "Kilometraj"};
        l = new JLabel[labels.length];
        for (int i = 0; i < labels.length; i++){
            l[i] = new JLabel(labels[i]);
            l[i].setBounds(25, pozY, 150, 25);
            add(l[i]);
            pozY+=30;
        }
        pozY = 25;
        tf = new JTextField[tflabels.length];
        for (int i = 0; i < tflabels.length; i++){
            tf[i] = new JTextField();
            tf[i].setName(tflabels[i]);
            tf[i].setBounds(150, pozY, 150, 25);
            add(tf[i]);
            pozY+=30;
        }
        save = new JButton("Salvare");
        save.setBounds(125, pozY, 100, 50);
        save.addActionListener(sa);
        add(save);
        setVisible(true);
    }
    private class SalvareAuto implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == save){
                try {
                    for (int i = 0; i < tflabels.length; i++){
                        if (i != 2 || i != 0)
                            Integer.parseInt(tf[i].getText());
                    }
               }
               catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Nu s-au putut salva modificarile! Camp(uri) completate gresit. Incercari din nou");
               }
            }
        }
        
    }
}
