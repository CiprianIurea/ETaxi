package App;
import javax.swing.*;
public class ETaxi {
    static int result, iesireapp, optiune;
    static String username, password;
    static void inregistrare(){
        SignUp inreg = new SignUp();
        int optiune = inreg.getResult();
        if (optiune == 1)
            conectare();
    }
    static void conectare(){
        boolean status;
        do{
            LogIn logare = new LogIn();
            result = logare.getResult();
            iesireapp = logare.getIesireapp();
            status = logare.credentiale(result);
            username = logare.getUsername();
            password = logare.getPassword();
            if (result == 1)
                inregistrare();
            if (result == -1)
                System.exit(0);
            if (status == false){
                logare.setUsername("");
                logare.setPassword("");
            }
        }while (status == false && result == 0);
        PaginaFormulare();
    }
    static void PaginaFormulare(){
        Object[] options = {"Inregistrare autoturism/e", "Inregistrare cursa", "Inregistrare polite", "Schimbare parola", "Iesire"};
        optiune = JOptionPane.showOptionDialog(null, "Salutare " + username + "!", "Formulare", 0, 3, null, options, options[options.length-1]);
    }
    public static void main (String[] args){
        conectare();
        switch(optiune){
            case 0 -> {
                Autoturisme auto = new Autoturisme();
            }
            case 1 -> {
                Curse curse = new Curse();
            }
            case 2 -> {
                Polite polite = new Polite();
            }
            case 3 -> {
                SchimbareParola schimbparola = new SchimbareParola();
            }
            case -1 -> System.exit(0);
        }
    }
}
