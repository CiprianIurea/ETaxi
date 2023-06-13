package App;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
public class SchimbareParola extends JFrame{
    private JLabel parolacurenta, parolanoua, confparolanoua;
    private JPasswordField currentpass, newpass, newpassconf;
    private JButton save;
    private ChangePass cp;
    private BufferedReader br;
    private String username, newfile, oldfile, name, line, pass;
    private PrintWriter pw;
    SchimbareParola(String username){
        setTitle("Schimbare parola E-Taxi");
        setSize(350, 250);
        setLayout(null);
        this.username = username;
        cp = new ChangePass();
        parolacurenta = new JLabel("Parola curenta");
        parolacurenta.setBounds(25, 25, 150, 25);
        add(parolacurenta);
        parolanoua = new JLabel("Parola noua");
        parolanoua.setBounds(25, 55, 150, 25);
        add(parolanoua);
        confparolanoua = new JLabel("Confirmare parola noua");
        confparolanoua.setBounds(25, 85, 150, 25);
        add(confparolanoua);
        currentpass = new JPasswordField();
        currentpass.setBounds(175, 25, 150, 25);
        add(currentpass);
        newpass = new JPasswordField();
        newpass.setBounds(175, 55, 150, 25);
        add(newpass);
        newpassconf = new JPasswordField();
        newpassconf.setBounds(175, 85, 150, 25);
        add(newpassconf);
        save = new JButton("Salavare");
        save.setBounds(100, 125, 100, 50);
        save.addActionListener(cp);
        add(save);
        setVisible(true);
    }
    private class ChangePass implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == save){
                try {
                    oldfile = "credentiale.txt";
                    String p = new File(oldfile).getAbsoluteFile().getParent();
                    File o = new File(p + "\\" + oldfile);
                    br = new BufferedReader(new FileReader(o));
                    while ((name = br.readLine()) != null){
                        if (name.equals(username))
                            break;
                    }
                    pass = br.readLine();
                    br.close();
                    if (!new String(currentpass.getPassword()).equals(pass)){
                        JOptionPane.showMessageDialog(null, "Parola incorecta");
                        currentpass.setText("");
                        newpass.setText("");
                        newpassconf.setText("");
                    }
                    else if (!new String(newpass.getPassword()).equals(new String(newpassconf.getPassword()))){
                        JOptionPane.showMessageDialog(null, "Parolele nu corespund");
                        newpass.setText("");
                        newpassconf.setText("");
                    }
                    else{
                        newfile = "tempc.txt";
                        File f = new File(p + "\\" + newfile);
                        pw = new PrintWriter(new FileWriter(f));
                        br = new BufferedReader(new FileReader(o));
                        try{
                            while((line = br.readLine()) != null){
                                if (line.equals(username)){
                                    pw.println(line);
                                    pw.println(new String(newpass.getPassword()));
                                }
                                else if (line.equals(pass)){
                                    br.readLine();
                                }
                                
                            }
                        } catch (IOException ex){
                            Logger.getLogger(SchimbareParola.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        br.close();
                        pw.close();
                        boolean succes = o.delete();
                        if (succes)
                            System.out.println("Succes!");
                        if (f.renameTo(o)){
                            JOptionPane.showMessageDialog(null, "Parola schimbata cu succes");
                            dispose();
                        }
                        else
                            JOptionPane.showMessageDialog(null, "Eroare. Nu s-a putut efectua operatiunea");
                        
                    }
                } catch (IOException ex) {
                    Logger.getLogger(SchimbareParola.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
