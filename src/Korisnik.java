public abstract class Korisnik {
    private String telBr;
    private final static int PDV = 18;
    public Korisnik(String brojTel){
        this.setTelBr(brojTel);
    }
    public Korisnik(final Korisnik k){
        this.setTelBr(k.getTelBr());
    }
    public static int getPDV() {
        return PDV;
    }
    public String getTelBr() {
        return telBr;
    }
    public void setTelBr(String telBr) {
        this.telBr = telBr;
    }
    public abstract void azuriraj_racun_razgovor(Razgovor razgovor);
    public abstract void azuriraj_racun_SMS();
    public static boolean validanBroj(String unetBroj){
        if (!((unetBroj.startsWith("064") || unetBroj.startsWith("065") || unetBroj.startsWith("066"))
                && (unetBroj.length() == 9 || unetBroj.length() == 10))){
            System.out.println("Neispravno unet broj - broj pocinje sa 064, 065 ili 066 i sastoji se od 9 ili 10 " +
                    "cifara");
            return false;
        }
        for (int i = 0; i < unetBroj.length(); i++){
            if (!Character.isDigit(unetBroj.charAt(i))) {
                System.out.println("Neispravno unet broj - broj se sastoji samo od cifara");
                return false;
            }
        }
        return true;
    }
    @Override
    public String toString() {
        return "Broj korisnika: " + getTelBr();
    }
}
