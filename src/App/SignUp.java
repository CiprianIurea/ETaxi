package App;
import javax.swing.*;
public class SignUp {
    private JTextField nume = new JTextField();
    private JTextField prenume = new JTextField();
    private JTextField varsta = new JTextField();
    private JTextField CNP = new JTextField();
    private JTextField domiciliu = new JTextField();
    private int result;
    SignUp(){
        Object[] labels = {"Nume: ", nume, "Prenume: ", prenume, "Varsta: ", varsta, "CNP: ", CNP, "Domiciliu: ", domiciliu};
        Object[] options = {"Inregistrare", "Anulare"};
        result = JOptionPane.showOptionDialog(null, labels, "Inregistrare E-Taxi", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
    }
    public int getResult(){
        return result;
    }
}
