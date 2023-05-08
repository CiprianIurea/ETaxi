package App;
import javax.swing.*;
public class SignUp {
    private JTextField numeutilizator = new JTextField();
    private JTextField parola = new JTextField();
    private JTextField confpass = new JTextField();
    private int result;
    SignUp(){
        Object[] labels = {"Nume utilizator: ", numeutilizator, "Parola: ", parola, "Confirmare parola: ", confpass};
        Object[] options = {"Inregistrare", "Anulare"};
        result = JOptionPane.showOptionDialog(null, labels, "Inregistrare E-Taxi", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
    }
    public boolean Pas2(){
        if (result == 0){
            if (numeutilizator.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Nu ati introdus numele de utilizator.");
                return false;
            }
            else if (!parola.getText().equals(confpass.getText()) || (parola.getText().isBlank() || confpass.getText().isBlank())){
                    JOptionPane.showMessageDialog(null, "Parolele nu corespund.");
                    return false;
            }
            JOptionPane.showMessageDialog(null, "V-ati inregistrat cu succes!");
            return true;
        }
        if (result == -1)
            System.exit(0);
        return false;
    }
    public int getResult(){
        return result;
    }
}
