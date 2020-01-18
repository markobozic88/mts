public class Postpaid extends Korisnik {
    private double racun;
    private static final double PRETPLATA = 150;
    private static final double RAZGOVOR_U_MREZI = 2.8;
    private static final double RAZGOVOR_NACIONALNI = 5.8;
    private static final double USPOSTAVA = 2.5;
    private static final double SMS = 2.2;
    public Postpaid(String brojTel) {
        super(brojTel);
        this.setRacun(getPRETPLATA());
    }
    public Postpaid(final Postpaid postpaid){
        super(postpaid.getTelBr());
        this.setRacun(postpaid.getRacun());
    }
    @Override
    public void azuriraj_racun_razgovor(Razgovor razgovor) {
        double cena = getRazgovorNacionalni();
        if (razgovor.getBrSaKojimSeRaz().startsWith("064")
                || razgovor.getBrSaKojimSeRaz().startsWith("065")
                || razgovor.getBrSaKojimSeRaz().startsWith("066")){
            cena = getRazgovorUMrezi();
        }
        double cenaRazgovora = (getUSPOSTAVA() + (razgovor.getTrajanjeRaz().getSat() * 3600
         + razgovor.getTrajanjeRaz().getMinut() * 60 + razgovor.getTrajanjeRaz().getSekund()))
                * cena / 60 * (100 + getPDV()) / 100;
        double trenutniRacun = this.getRacun();
        this.setRacun(trenutniRacun + cenaRazgovora);
    }
    @Override
    public void azuriraj_racun_SMS() {
        double trenutniRacun = this.getRacun();
        this.setRacun(trenutniRacun + getSMS() * (100 + getPDV()) / 100);
    }
    public double getRacun() {
        return racun;
    }
    public void setRacun(double racun) {
        this.racun = racun;
    }
    public static double getPRETPLATA() {
        return PRETPLATA;
    }
    public static double getRazgovorUMrezi() {
        return RAZGOVOR_U_MREZI;
    }
    public static double getRazgovorNacionalni() {
        return RAZGOVOR_NACIONALNI;
    }
    public static double getUSPOSTAVA() {
        return USPOSTAVA;
    }
    public static double getSMS() {
        return SMS;
    }
    @Override
    public String toString() {
        return super.toString() + "Racun: " + this.getRacun();
    }
}
