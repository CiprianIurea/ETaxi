package App;
import javax.swing.*;
public class WelcomePage {
    private JLabel welcome = new JLabel();
    private int optiune;
    WelcomePage(String username){
        Object[] options = {"Inregistrare autoturism/e", "Inregistrare cursa", "Inregistrare polite", "Schimbare parola", "Iesire"};
        optiune = JOptionPane.showOptionDialog(null, "Salutare " + username + "!", "Formulare", 0, 3, null, options, options[options.length-1]);
    }
}
