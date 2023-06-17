package App;
public class FisaAuto implements Comparable<FisaAuto>{
    private String model, serie, nrInmatriculare, km;
    private String polita, dela, panala;
    private StringBuffer sb;
    FisaAuto(String model, String serie, String nrInmatriculare, String km){
        model.replaceAll(" ", "");
        this.model = model;
        this.serie = serie;
        this.nrInmatriculare = nrInmatriculare;
        this.km = km;
    }
    public String toString(){
        model.replaceAll(" ", "");
        sb = new StringBuffer();
        sb.append(model).append(" ");
        sb.append(serie).append(" ");
        sb.append(nrInmatriculare).append(" ");
        sb.append(km);
        return sb.toString();
    }
    public String getSerie(){
        return serie;
    }

    @Override
    public int compareTo(FisaAuto o) {
        return serie.compareTo(o.getSerie());
    }
}
