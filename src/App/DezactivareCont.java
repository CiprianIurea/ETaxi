package App;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class DezactivareCont{
    DezactivareCont() {};
    public boolean raspuns(String username) throws IOException{
       int rez = JOptionPane.showOptionDialog(null, "Sunteti sigur/a ca doriti sa dezactivati contul? Toate informatiile vor fi pierdute!", "Atentie!", 
               0, 0, null, null, null);
       if (rez == 0){
           try {
               String oldfile = "credentiale.txt";
               String path = null;
               path = new File(oldfile).getAbsoluteFile().getParent();
               File o = new File(path + "\\" + oldfile);
               String newfile = "tempc.txt";
               File f = new File(path + "\\" + newfile);
               BufferedReader br = new BufferedReader(new FileReader(o));
               PrintWriter pw = new PrintWriter(new FileWriter(f));
               String line = null;
               try {
                   while ((line = br.readLine()) != null){
                       if (line.equals(username))
                           br.readLine();
                       else pw.println(line);
                   }
               } catch (IOException ex) {
                   Logger.getLogger(DezactivareCont.class.getName()).log(Level.SEVERE, null, ex);
               }
               br.close();
               pw.close();
               boolean succes = o.delete();
               f.renameTo(o);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(DezactivareCont.class.getName()).log(Level.SEVERE, null, ex);
            }
            stergeAuto(username);
            stergeCurse(username);
            return true;
       }
       return false;
    }
    public void stergeAuto(String username) throws IOException{
        try {
               String oldfile = "autoturisme.txt";
               String path = null;
               path = new File(oldfile).getAbsoluteFile().getParent();
               File o = new File(path + "\\" + oldfile);
               String newfile = "tempa.txt";
               File f = new File(path + "\\" + newfile);
               BufferedReader br = new BufferedReader(new FileReader(o));
               PrintWriter pw = new PrintWriter(new FileWriter(f));
               String line = null;
               String[] s;
               try {
                   while ((line = br.readLine()) != null){
                       s = line.split(" ");
                       if (!s[s.length-1].equals(username))
                           pw.println(line);
                   }
               } catch (IOException ex) {
                   Logger.getLogger(DezactivareCont.class.getName()).log(Level.SEVERE, null, ex);
               }
               br.close();
               pw.close();
               boolean succes = o.delete();
               f.renameTo(o);
           } catch (FileNotFoundException ex) {
               Logger.getLogger(DezactivareCont.class.getName()).log(Level.SEVERE, null, ex);
           }
    }
    public void stergeCurse(String username) throws IOException{
        try {
               String oldfile = "curse.txt";
               String path = null;
               path = new File(oldfile).getAbsoluteFile().getParent();
               File o = new File(path + "\\" + oldfile);
               String newfile = "tempc.txt";
               File f = new File(path + "\\" + newfile);
               BufferedReader br = new BufferedReader(new FileReader(o));
               PrintWriter pw = new PrintWriter(new FileWriter(f));
               String line = null;
               String[] s;
               try {
                   while ((line = br.readLine()) != null){
                       if (line.equals(username)){
                           while(!(line = br.readLine()).equals(""));
                       }
                       else
                           pw.println(line);
                   }
               } catch (IOException ex) {
                   Logger.getLogger(DezactivareCont.class.getName()).log(Level.SEVERE, null, ex);
               }
               br.close();
               pw.close();
               boolean succes = o.delete();
               f.renameTo(o);
           } catch (FileNotFoundException ex) {
               Logger.getLogger(DezactivareCont.class.getName()).log(Level.SEVERE, null, ex);
           }
    }
}
