package App;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class LogIn extends JFrame{
    private AscultatorButoane ab;
    private JLabel l1, l2;
    private JTextField username;
    private JPasswordField password;
    private JButton login, signin;
    private BufferedReader br;
    private String name, pass;
    LogIn(){
        setTitle("E-Taxi");
        setSize(400, 300);
        setLayout(null);
        l1 = new JLabel("Nume utilizator");
        l2 = new JLabel("Parola");
        username = new JTextField(20);
        password = new JPasswordField(20);
        login = new JButton("Conectare");
        signin = new JButton("Inregistrare");
        ab = new AscultatorButoane();
        login.addActionListener(ab);
        signin.addActionListener(ab);
        l1.setBounds(50, 50, 100, 25);
        l2.setBounds(50, 100,100, 25);
        username.setBounds(150, 50, 150, 25);
        password.setBounds(150, 100, 150, 25);
        login.setBounds(50, 150, 150, 50);
        signin.setBounds(200, 150, 150, 50);
        login.setFocusable(false);
        signin.setFocusable(false);
        add(l1); add(l2); add(username); add(password); add(login); add(signin);
        setVisible(true);
    }
    private class AscultatorButoane implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==login){
                File f = new File("credentiale.txt");
                if (f.exists()){
                    try{
                        br = new BufferedReader(new FileReader(f));
                        try {
                            String s = new String(password.getPassword());
                            while ((name = br.readLine())!= null){
                                if (name.equals(username.getText()))
                                    break;
                                else br.readLine(); 
                            }
                            pass = br.readLine();
                            br.close();
                            if (username.getText().equals(name) && s.equals(pass)){
                                WelcomePage wp = new WelcomePage(username.getText());
                                wp.setLocationRelativeTo(null);
                                wp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                dispose();
                            }
                            else{
                                username.setText("");
                                password.setText("");
                                JOptionPane.showMessageDialog(null, "Nume de utilizator sau parola incorecte.");
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
            }
            else if (e.getSource() == signin){
                SignUp sup = new SignUp();
                sup.setLocationRelativeTo(null);
                sup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                dispose();
            }
        }
    }
}
