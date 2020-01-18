import java.util.Arrays;

public class Prepaid extends Korisnik {
    private double kredit;
    private static final double RAZGOVOR = 7.5;
    private static final double FF = 4.5;
    private static final double USPOSTAVA = 2.8;
    private static final double SMS = 0.9;
    private String[] fAndFbroj = new String[3];
    public Prepaid(String telBroj, double kredit, String[] fAndF){
        super(telBroj);
        this.setKredit(kredit);
        for (int i = 0; i < fAndF.length; i++){
            this.setfAndFbroj(fAndF);
        }
    }
    public Prepaid(final Prepaid prepaid){
        super(prepaid.getTelBr());
        this.setKredit(prepaid.getKredit());
        for (int i = 0; i < prepaid.getfAndFbroj().length; i++){
            this.setfAndFbroj(prepaid.getfAndFbroj());
        }
    }

    public void dopuni_kredit(int dopuna){
        double trenutniKredit = this.getKredit();
        this.setKredit(trenutniKredit + dopuna);
    }

    @Override
    public void azuriraj_racun_razgovor(Razgovor razgovor) {
        double cena = getRAZGOVOR();
        Vreme v;
        if (razgovor.getTrajanjeRaz().getSat() == 0 && razgovor.getTrajanjeRaz().getMinut() == 0){
            v = new Vreme(0, 1, 0);
        } else if (razgovor.getTrajanjeRaz().getSekund() > 30){
            v = razgovor.getTrajanjeRaz().naredniMinut();
        } else {
            v = new Vreme(razgovor.getTrajanjeRaz().getSat(), razgovor.getTrajanjeRaz().getMinut(), 0);
        }

        for (int i = 0; i < this.getfAndFbroj().length; i++){
            if (razgovor.getBrSaKojimSeRaz().equals(this.getfAndFbroj()[i])){
                cena = getFF();
                break;
            }
        }

        double cenaRazgovora = (getUSPOSTAVA() + (v.getSat() * 60 + v.getMinut()) * cena) * (100 + getPDV()) / 100;
        if (this.getKredit() < cenaRazgovora){
            this.setKredit(0);
        } else {
            double trenutniKredit = this.getKredit();
            this.setKredit(trenutniKredit - cenaRazgovora);
        }
    }

    @Override
    public void azuriraj_racun_SMS() {
        double trenutniKredit = this.getKredit();
        if (trenutniKredit < 1){
            this.setKredit(0);
        } else {
            this.setKredit(trenutniKredit * (100 + getPDV()) / 100);
        }
    }
    public double getKredit() {
        return kredit;
    }
    public void setKredit(double kredit) {
        this.kredit = kredit;
    }
    public String[] getfAndFbroj() {
        return fAndFbroj;
    }
    public void setfAndFbroj(String[] fAndFbroj) {
        this.fAndFbroj = fAndFbroj;
    }
    public static double getRAZGOVOR() {
        return RAZGOVOR;
    }
    public static double getFF() {
        return FF;
    }
    public static double getUSPOSTAVA() {
        return USPOSTAVA;
    }
    public static double getSMS() {
        return SMS;
    }



    @Override
    public String toString() {
        return "Prepaid{" +
                "kredit=" + kredit +
                ", fAndFbroj=" + Arrays.toString(fAndFbroj) +
                '}';
    }
}
