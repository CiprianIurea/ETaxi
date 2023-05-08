package App;
import javax.swing.*;
public class LogIn {
    private JTextField username = new JTextField();
    private JTextField password = new JTextField();
    private JFrame f;
    private String user, pass;
    private int result, iesireapp;
    LogIn(){
        f = new JFrame();
        Object[] options = {"Conectare", "Inregistrare"};
        Object[] labels = {"Nume utilizator: ", username, "Parola: ", password};
        result = JOptionPane.showOptionDialog(f, labels, "ETaxi", 0, 3, null, options, options[1]);
    }
    public boolean credentiale(int option){
        user = username.getText();
        pass = password.getText();
        if (option == 0){
            if (!user.equals("admin") && !pass.equals("admin") ){
                if (user.isBlank()&& pass.isBlank()){
                    JOptionPane.showMessageDialog(null, "Nu ati introdus toate credentialele.");
                    return false;
                }
                JOptionPane.showMessageDialog(null, "Nume de utilizator sau parola incorecte. Incearca din nou");
                return false;
            }   
        }
        return true;
    }
    public int getResult(){
        return result;
    }
    public int getIesireapp(){
        return iesireapp;
    }
    public String getUsername(){
        return user;
    }
    public String getPassword(){
        return pass;
    }
    public void setUsername(String utilizator){
        username.setText(utilizator);
    }
    public void setPassword(String parola){
        password.setText(parola);
    }
}
