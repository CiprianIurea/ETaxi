package App;
import java.util.*;
import java.io.*; 
import javax.swing.*;
public class GestionarAutoturisme{
	private TreeSet<FisaAuto> ts;
	private BufferedReader br;
	private PrintWriter pw;
	private String l;
	private FisaAuto fisa;
	
	private static GestionarAutoturisme instanta;
	
    private GestionarAutoturisme(){
        File f=new File("autoturisme.txt");
        ts=new TreeSet<>();
        String[] s;
        if (f.exists()){
            try{
                br=new BufferedReader(new FileReader(f));
                while ((l=br.readLine())!=null){
                s=l.split(" ");
                fisa=new FisaAuto(s[0], s[1], s[2], s[3]);
                ts.add(fisa);
                }
            }catch(IOException ioe){ioe.printStackTrace();}	

        } else System.out.println("Fisierul nu exista");
    }		
    public void adaugaFisa(String model, String serie, String nrInmatriculare, String km){
        fisa=new FisaAuto(model, serie, nrInmatriculare, km);
        ts.add(fisa);
    }
    public void salveaza(String username){
        Calendar cal = Calendar.getInstance();
        try{
            String s = String.valueOf(cal.get(Calendar.DATE))+ 
                   cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH)+
                   String.valueOf(cal.get(Calendar.YEAR));
            pw=new PrintWriter(new FileWriter("autoturisme.txt"));
            for(FisaAuto f: ts) {
                pw.println(f+" "+s+" "+username);
            }
            pw.close();	
        }catch(IOException e){e.printStackTrace();}

    }
    public static GestionarAutoturisme getInstanta(){
            if (instanta==null) 
                instanta=new GestionarAutoturisme();
            return instanta;
    }
    public TreeSet getTS(){
        if (ts != null)
            return ts;
        return null;
    }
}
