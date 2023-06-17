package App;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class GestionareCursa{
    private final float tarifIntern = 3, tarifExtern = 5, tarifStationar = 1.75f;
    private Curse cursa;
    private PrintWriter pw;
    private static String[] labels2 = {"Km iesire serviciu: ", "Incasari interne: ", "Incasari externe: ", "Incasari in mod stationar: ", 
                                "Total incasari: ", "Plata combustibil: ", "Rest monetar: "};
    private String username;
    GestionareCursa(String username){
        this.username = username;
    }
    private static final DecimalFormat df = new DecimalFormat("0.00");
    public float TotalKm(JTextField[] tf) {
        String ab = cursa.getKmInterni(tf);
        float a = Float.parseFloat(cursa.getKmInterni(tf));
        float b = Float.parseFloat(cursa.getKmExterni(tf));
        float c = Float.parseFloat(cursa.getKmNeplatiti(tf));
        df.format(a); df.format(b); df.format(c);
        return a+b+c;
    }

    public float IncasariInterne(JTextField[] tf) {
        float a = Float.parseFloat(cursa.getKmInterni(tf));
        df.format(a);
        return a*tarifIntern;
    }

    public float IncasariExterne(JTextField[] tf) {
        float a = Float.parseFloat(cursa.getKmExterni(tf));
        df.format(a);
        return a*tarifExtern;
    }

    public float IncasariStationar(JTextField[] tf) {
        float a = Float.parseFloat(cursa.getTimpStationar(tf));
        df.format(a);
        return a*tarifStationar;
    }

    public float PlataCombustibil(JTextField[] tf) {
        float a = Float.parseFloat(cursa.getConsum(tf));
        float b = Float.parseFloat(cursa.getPret(tf));
        df.format(a); df.format(b);
        return a*b*TotalKm(tf)/100;
    }
    
    public float TotalIncasari(JTextField[] tf) {
        float s = IncasariInterne(tf)+IncasariExterne(tf)+IncasariStationar(tf);
        df.format(s);
        return s;
    }

    public float RestMonetar(JTextField[] tf) {
        float s = TotalIncasari(tf)-PlataCombustibil(tf);
        df.format(s);
        return s;
    }
    public int Profit(JTextField[] tf){
        Calendar data = Calendar.getInstance();
        cursa = new Curse();
        String s = String.valueOf(data.get(Calendar.DATE)) +  
                   data.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH) + 
                   String.valueOf(data.get(Calendar.YEAR));
        String[] l2 = {String.valueOf(TotalKm(tf)), 
                       String.valueOf(IncasariInterne(tf)), 
                       String.valueOf(IncasariExterne(tf)),
                       String.valueOf(IncasariStationar(tf)), 
                       String.valueOf(TotalIncasari(tf)),
                       String.valueOf(PlataCombustibil(tf)),
                       String.valueOf(RestMonetar(tf))};
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < l2.length; i++){
            sb.append(labels2[i]).append(l2[i]).append("\n");
        }
        int rez = JOptionPane.showOptionDialog(null, sb, "Inregistrare cursa", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, 0);
        if (rez == 0){
            try {
                File f = new File("curse.txt");
                pw = new PrintWriter(new FileWriter(f, true));
                pw.println(username);
                pw.println(s);
                pw.println(sb.toString()+"\n");
                pw.close();
            } catch (IOException ex) {
                Logger.getLogger(Curse.class.getName()).log(Level.SEVERE, null, ex);
            }
            return 0;
        }
        return -1;
    }
}
