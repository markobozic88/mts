public class Vreme {
    private int sat;
    private int minut;
    private int sekund;
    public Vreme(int sat, int minut, int sekund){
        this.setSat(sat);
        this.setMinut(minut);
        this.setSekund(sekund);
    }
    public Vreme(final Vreme v){
        this.setSat(v.getSat());
        this.setMinut(v.getMinut());
        this.setSekund(v.getSekund());
    }
    public static boolean ispravnoVreme(int s, int m, int sd){
        return s >= 0 && (m >= 0 && m <= 59) && (sd >= 0 && sd <= 59);
    }
    public Vreme naredniMinut(){
        if (this.getMinut() + 1 <= 59){
            return new Vreme(0, this.getMinut() + 1, 0);
        } else {
            return new Vreme(this.getSat() + 1, 0, 0);
        }
    }
    public int getSat() {
        return sat;
    }
    public void setSat(int sat) {
        this.sat = sat;
    }
    public int getMinut() {
        return minut;
    }
    public void setMinut(int minut) {
        this.minut = minut;
    }
    public int getSekund() {
        return sekund;
    }
    public void setSekund(int sekund) {
        this.sekund = sekund;
    }
    @Override
    public String toString() {
        return getSat() + ":" + getMinut() + ":" + getSekund();
    }
}
