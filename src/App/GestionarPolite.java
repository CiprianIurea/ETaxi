package App;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.TreeSet;
import javax.swing.JOptionPane;

public class GestionarPolite {
    private TreeSet<FisaPolita> ts;
    private BufferedReader br;
    private PrintWriter pw;
    private String l;
    private FisaPolita fp;

    private static GestionarPolite instanta;
	
    private GestionarPolite(){
        File f=new File("polite.txt");
        ts=new TreeSet<>();
        String[] s;
        if (f.exists()){
            try{
                br=new BufferedReader(new FileReader(f));
                while ((l=br.readLine())!=null){
                    s=l.split(" ");
                    fp=new FisaPolita(s[0], s[1], s[2], s[3]);
                    ts.add(fp);
                }
            }catch(IOException ioe){ioe.printStackTrace();}	

        } else System.out.println("Fisierul nu exista");
    }		
    public void adaugaFisa(String serie, String polita, String dela, String panala){
            fp=new FisaPolita(serie, polita, dela, panala);
            ts.add(fp);
    }
    public String cautaFisa(String serie){
        for(FisaPolita f: ts){
            if(serie.equals(f.getSerie())) 
                return f.toString();
        }
        return "nu exista niciun autoturism cu seria "+ serie;
    }

    /*public void stergeFisa(String nume){
            Iterator<Fisa> it=ts.iterator();
            while (it.hasNext())	{
              if(nume.equalsIgnoreCase(it.next().getNume())) {
                it.remove();
                JOptionPane.showMessageDialog(null, "Fisa a fost stearsa din agenda telefonica", "Information", JOptionPane.INFORMATION_MESSAGE);
                return;
              }
            }	
            JOptionPane.showMessageDialog(null, "Fisa nu se gaseste in agenda telefonica", "Alert", JOptionPane.ERROR_MESSAGE);
    }*/

    public void salveaza(){
        try{
            pw=new PrintWriter(new FileWriter("polite.txt"));
            for(FisaPolita f: ts) {
                pw.println(f);
            }   
            pw.close();	
        }catch(IOException e){e.printStackTrace();}

    }

    public static GestionarPolite getInstanta(){
        if (instanta==null) 
            instanta=new GestionarPolite();
        return instanta;
    }	
    public TreeSet getTS(){
        if (ts!=null)
            return ts;
        return null;
    }
}
