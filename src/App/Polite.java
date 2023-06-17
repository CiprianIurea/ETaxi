package App;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Polite extends JFrame{
    private JLabel tippolita, valabildela, valabilpanala, auto;
    private JComboBox cbpolita;
    private String[] tip = {"None", "RCA", "CASCO"};
    private String[] autos, serie;
    private String username;
    private JButton save;
    private JComboBox zi1, zi2, luna1, luna2, an1, an2, cbautoturisme;
    private String[] zi, luna30, luna31, luna28, luna, an;
    private SalvareInfo si;
    private Data d;
    private Calendar data = Calendar.getInstance();
    private TreeMap<String, String> tm;
    Polite(String username){
        setTitle("Adaugare polita de asigurare");
        setSize(500, 300);
        setLayout(null);
        this.username = username;
        int pozX = 25;
        int pozY = 25;
        try {
            BufferedReader br = new BufferedReader(new FileReader("autoturisme.txt"));
            String line;
            String[] s;
            int i = 0;
            autos = new String[50];
            serie = new String[50];
            try {
                while ((line = br.readLine())!= null){
                    s = line.split(" ");
                    if (s[s.length-1].equals(username)){
                        autos[i] = s[0]; serie[i] = s[1];i++;
                    } 
                }
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(Polite.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Polite.class.getName()).log(Level.SEVERE, null, ex);
        }
        auto = new JLabel("Autoturism: ");
        auto.setBounds(pozX, pozY, 100, 25);
        add(auto);
        pozX+=100;
        cbautoturisme = new JComboBox(autos);
        cbautoturisme.setBounds(pozX, pozY, 150, 25);
        add(cbautoturisme);
        pozY+=40;
        pozX = 25;
        tippolita = new JLabel("Tip polita: ");
        tippolita.setBounds(pozX, pozY, 100, 25);
        add(tippolita);
        pozX+=100;
        cbpolita = new JComboBox(tip);
        cbpolita.setBounds(pozX, pozY, 100, 25);
        add(cbpolita);
        pozX = 25;
        pozY+= 50;
        valabildela = new JLabel("Valabil de la: ");
        valabildela.setBounds(pozX, pozY, 100, 25);
        add(valabildela);
        zi = new String[32];
        zi[0] = "Zi";
        for (int i = 1; i <= 31; i++){
            zi[i] = String.valueOf(i);
        }
        pozX+=100;
        d = new Data();
        zi1 = new JComboBox(zi);
        zi1.setBounds(pozX, pozY, 75, 25);
        zi1.addActionListener(d);
        add(zi1);
        zi2 = new JComboBox(zi);        
        zi2.addActionListener(d);
        luna = new String[] {"Luna", "January", "February", "March", "April", "May", "June",
                             "July", "August", "September", "October", "November","December"};
        luna30 = new String[] {"Luna", "April", "June", "September", "November", "December"};
        luna31 = new String[] {"Luna", "January", "March", "May", "July", "August", "October", "December"};
        pozX+=75;
        luna1 = new JComboBox(luna);
        luna1.setBounds(pozX, pozY, 100, 25);
        add(luna1);
        luna2 = new JComboBox(luna);
        an = new String[] {"An", String.valueOf(data.get(Calendar.YEAR)), String.valueOf(data.get(Calendar.YEAR)-1)};
        pozX+=100;
        an1 = new JComboBox(an);
        an1.setBounds(pozX, pozY, 75, 25);
        add(an1);
        pozX = 25;
        pozY+=40;
        valabilpanala = new JLabel("pana la: ");
        valabilpanala.setBounds(pozX, pozY, 100, 25);
        add(valabilpanala);
        pozX+=100;
        zi2.setBounds(pozX, pozY, 75, 25);
        add(zi2);
        pozX+=75;
        luna2.setBounds(pozX, pozY, 100, 25);
        add(luna2);
        pozX+=100;
        an = new String[] {"An", String.valueOf(data.get(Calendar.YEAR)+1),String.valueOf(data.get(Calendar.YEAR)), String.valueOf(data.get(Calendar.YEAR)-1)};
        an2 = new JComboBox(an);
        an2.setBounds(pozX, pozY, 75, 25);
        add(an2);
        pozY+=50;
        pozX = 200;
        si = new SalvareInfo();
        save = new JButton("Salvare");
        save.setBounds(pozX, pozY, 100, 50);
        save.addActionListener(si);
        save.setFocusable(false);
        add(save);
        setVisible(true);
    }
    private class SalvareInfo implements ActionListener{
        private GestionarPolite gp;
        SalvareInfo(){
            gp = GestionarPolite.getInstanta();
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == save){
                if (zi1.getSelectedItem().equals("Zi") || luna1.getSelectedItem().equals("Luna") || an1.getSelectedItem().equals("An")
                    || zi2.getSelectedItem().equals("Zi") || luna2.getSelectedItem().equals("Luna") || an2.getSelectedItem().equals("An"))
                    JOptionPane.showMessageDialog(null, "Data/date invalide. Incercati din nou");
                else if (zi1.getSelectedIndex() > zi2.getSelectedIndex()){
                    if (luna1.getSelectedIndex() > luna2.getSelectedIndex()){
                        if (an1.getSelectedIndex() > an2.getSelectedIndex()){
                            JOptionPane.showMessageDialog(null, "Imposibil de calculat");
                        }  
                    }   
                }
                else if (cbpolita.getSelectedItem().equals("None"))
                    JOptionPane.showMessageDialog(null, "Polita nedetectata");
                else if (cbautoturisme.getSelectedItem()== null)
                    JOptionPane.showMessageDialog(null, "Autoturism neidentificat");
                else{
                    String s1 = (String)zi1.getSelectedItem() + (String)luna1.getSelectedItem() + (String)an1.getSelectedItem();
                    String s2 = (String)zi2.getSelectedItem() + (String)luna2.getSelectedItem() + (String)an2.getSelectedItem();
                    for(int i = 0; i < autos.length; i++){
                        if (autos[i].equals((String)cbautoturisme.getSelectedItem())){
                            gp.adaugaFisa(serie[i], (String)cbpolita.getSelectedItem(), s1, s2);
                            gp.salveaza();
                            JOptionPane.showMessageDialog(null, "Polita adaugata cu succes");
                            dispose();
                            break;
                        }
                            
                    }
                }   
                
            }
        }
    }
    private class Data implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == zi1){
                String n = (String)zi1.getSelectedItem();
                switch (n){
                    case "29":
                        if (luna1.getSelectedItem().equals("Februarie")){
                            an = new String[] {"An", String.valueOf(data.get(Calendar.YEAR)+1)};
                            DefaultComboBoxModel <String> model = new DefaultComboBoxModel<>(an);
                            an1.setModel(model);
                        }
                        break;
                    case "30":
                        DefaultComboBoxModel <String> model = new DefaultComboBoxModel<>(luna30);
                        luna1.setModel(model);
                        break;
                    case "31":
                        DefaultComboBoxModel <String> model1 = new DefaultComboBoxModel<>(luna31);
                        luna1.setModel(model1);
                        break;
                    default:
                        DefaultComboBoxModel <String> model2 = new DefaultComboBoxModel<>(luna);
                        luna1.setModel(model2);
                        break;
                }
            }
            else if (e.getSource() == zi2){
                String m = (String)zi2.getSelectedItem();
                switch (m){
                    case "29":
                        if (luna2.getSelectedItem().equals("Februarie")){
                            an = new String[] {"An", String.valueOf(data.get(Calendar.YEAR)+1)};
                            DefaultComboBoxModel <String> model = new DefaultComboBoxModel<>(an);
                            an2.setModel(model);
                        }
                            
                        break;
                    case "30":
                        DefaultComboBoxModel <String> model = new DefaultComboBoxModel<>(luna30);
                        luna2.setModel(model);
                        break;
                    case "31":
                        DefaultComboBoxModel <String> model1 = new DefaultComboBoxModel<>(luna31);
                        luna2.setModel(model1);
                        break;
                    default:
                        DefaultComboBoxModel <String> model2 = new DefaultComboBoxModel<>(luna);
                        luna2.setModel(model2);
                        break;
                }
            }
            
        }
        
    }
}
