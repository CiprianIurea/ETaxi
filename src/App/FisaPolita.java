package App;
public class FisaPolita implements Comparable<FisaPolita>{
    private String serie, polita, dela, panala;
    private StringBuffer sb;
    FisaPolita(String serie, String polita, String dela, String panala){
        this.serie = serie;
        this.polita = polita;
        this.dela = dela;
        this.panala = panala;
    }
    public String toString(){
        sb = new StringBuffer();
        sb.append(serie).append(" ");
        sb.append(polita).append(" ");
        sb.append(dela).append(" ");
        sb.append(panala);
        return sb.toString();
    }
    public String getSerie(){
        return serie;
    }
    public String getData(){
        return dela+panala;
    }

    @Override
    public int compareTo(FisaPolita o) {
        int a = (dela+panala).compareTo(o.getData());
        int b = serie.compareTo(o.getSerie());
        return a+b;
    }
}
