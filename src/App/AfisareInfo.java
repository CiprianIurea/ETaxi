package App;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AfisareInfo {
    private String username, data, line, serie;
    private StringBuffer sb;
    AfisareInfo(String data, String username){
        this.data = data;
        this.username = username;
    }
    public String afiseazaAuto(){
        sb = new StringBuffer();
        File f = new File("autoturisme.txt");
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(f));
            String[] s;
            serie = null;
            try {
                while((line = br.readLine()) != null){
                    s = line.split(" ");
                    if (s[s.length-1].equals(username) && s[s.length-2].equals(data)){
                        for (int i = 0; i < s.length-2; i++){
                            sb.append(s[i]).append(" ");
                            if (i == 1)
                                serie = s[i];
                        }
                        afiseazaPolite(serie);
                        sb.append("\n");
                    }
                }
                if (serie == null){
                    sb.append("Nu exista date de afisat.\n");
                }
                br.close();
                afiseazaCurse();
            } catch (IOException ex) {
                Logger.getLogger(AfisareInfo.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AfisareInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sb.toString();   
    }
    public String afiseazaPolite(String serie){
        File g = new File("polite.txt");
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(g));
            String[] s;
            try {
                while((line = br.readLine()) != null){
                    s = line.split(" ");
                    if (s[0].equals(serie)){
                        for (int i = 1; i < s.length; i++)
                            sb.append(s[i]).append(" ");
                    }
                }
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(AfisareInfo.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AfisareInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sb.toString();
    }
    public String afiseazaCurse(){
        File g = new File("curse.txt");
        BufferedReader br;
        int i = 0;
        try {
            br = new BufferedReader(new FileReader(g));
            try {
                while((line = br.readLine()) != null){ 
                    if (line.equals(username)){
                        if ((line = br.readLine()).equals(data)){
                            while(!(line = br.readLine()).equals("")){
                                sb.append(line).append("\n");
                                i++;
                            }
                        }
                    }
                }
                if (i == 0)
                    sb.append("Nu ati efectuat nicio cursa.");
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(AfisareInfo.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AfisareInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sb.toString();
    }
}
