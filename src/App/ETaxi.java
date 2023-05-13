package App;
import javax.swing.*;
public class ETaxi {
    public static void main (String[] args){
        LogIn conectare = new LogIn();
        conectare.setSize(300, 200);
        conectare.setVisible(true);
        conectare.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        conectare.setLocationRelativeTo(null);
    }
}
