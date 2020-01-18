public class Razgovor {
    private String brSaKojimSeRaz;
    private Vreme trajanjeRaz;
    public Razgovor(String broj, Vreme vremeTrajanja){
        this.setBrSaKojimSeRaz(broj);
        this.setTrajanjeRaz(vremeTrajanja);
    }
    public Razgovor(final Razgovor r){
        this.setBrSaKojimSeRaz(r.getBrSaKojimSeRaz());
        this.setTrajanjeRaz(r.getTrajanjeRaz());
    }
    public String getBrSaKojimSeRaz() {
        return brSaKojimSeRaz;
    }
    public void setBrSaKojimSeRaz(String brSaKojimSeRaz) {
        this.brSaKojimSeRaz = brSaKojimSeRaz;
    }
    public Vreme getTrajanjeRaz() {
        return trajanjeRaz;
    }
    public void setTrajanjeRaz(Vreme trajanjeRaz) {
        this.trajanjeRaz = trajanjeRaz;
    }
    @Override
    public String toString() {
        return "Razgovor sa brojem " + getBrSaKojimSeRaz() + " je trajao " + getTrajanjeRaz();
    }
}
