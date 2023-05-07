package App;
import javax.swing.*;
public class ETaxi {
    static JTextField username = new JTextField();
    static JTextField password = new JTextField();
    static int result;
    ETaxi(){
        JFrame frame = new JFrame();
        Object[] options = {"Conectare", "Inregistrare"};
        Object[] labels = {"Nume utilizator: ", username, "Parola: ", password};
        result = JOptionPane.showOptionDialog(frame, labels, "ETaxi", 0, 3, null, options, options[1]);
    }
    static void inregistrare(){
        SignUp inreg = new SignUp();
        int optiune = inreg.getResult();
        if (optiune == 1)
            conectare();
    }
    static void conectare(){
        boolean status;
        do{
            ETaxi app = new ETaxi();
            String user = username.getText();
            String pass = password.getText();
            LogIn logare = new LogIn(user, pass);
            status = logare.credentiale(result);
            if (result == 1)
                inregistrare();
            if (status == false){
                username.setText("");
                password.setText("");
            }
        }while (status == false && result == 0);
    }
    static int PaginaFormulare(){
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Object[] options = {"Inregistrare autoturism/e", "Inregistrare cursa", "Inregistrare polite", "Schimbare parola", "Iesire"};
        result = JOptionPane.showOptionDialog(f, "Salutare " + username.getText() + "!", "Formulare", 0, 3, null, options, options[options.length-1]);
        return result;
    }
    public static void main (String[] args){
        conectare();
        PaginaFormulare();
    }
}