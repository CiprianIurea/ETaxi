package App;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class AutoturismNouFrame extends JFrame{
    private JLabel[] l;
    private JTextField[] tf;
    private JButton save;
    private String[] tflabels = {"nume", "serie", "nr", "km"};
    private SalvareAuto sa;
    private PrintWriter pw;
    private String username;
    AutoturismNouFrame (String username){
        setTitle("Autoturisme E-Taxi");
        setSize(350, 250);
        setLayout(null);
        this.username = username;
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
        save.setFocusable(false);
        add(save);
        setVisible(true);
    }
    AutoturismNouFrame(){}
    private class SalvareAuto implements ActionListener{
        private GestionarAutoturisme ga;
        SalvareAuto(){
            ga = GestionarAutoturisme.getInstanta();
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == save){
                String line = null;
                boolean succes = true;
                try {
                    BufferedReader br = new BufferedReader(new FileReader("autoturisme.txt"));
                    while ((line = br.readLine())!=null){
                        if (line.equals(tf[1].getText())){
                            JOptionPane.showMessageDialog(null, "Automobilul este deja inregistrat!");
                            succes = false;
                        }
                            
                    }
                } catch (IOException ex) {
                    Logger.getLogger(AutoturismNouFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (succes){
                    String s = tf[0].getText().replaceAll(" ", "");
                    ga.adaugaFisa(s, tf[1].getText(), tf[2].getText(), tf[3].getText());
                    ga.salveaza(username);
                    JOptionPane.showMessageDialog(null, "Autoturism inregistrat cu succes");
                    dispose();
                }
            }
        }
        
    }
}
