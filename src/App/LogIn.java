package App;
import javax.swing.*;
public class LogIn {
    private String username, password;
    LogIn(String username, String password){
        this.username = username;
        this.password = password;
    }
    public boolean credentiale(int option){
        if (option == 0){
            if (!username.contains("admin") && !password.contains("admin") ){
                if (username.isBlank()&& password.isBlank()){
                    JOptionPane.showMessageDialog(null, "Nu ati introdus toate credentialele.");
                    return false;
                }
                JOptionPane.showMessageDialog(null, "Nume de utilizator sau parola incorecte. Incearca din nou");
                return false;
            }   
        }
        return true;
    }
}
