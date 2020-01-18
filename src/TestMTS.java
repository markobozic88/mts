import java.util.Random;
import java.util.Scanner;

public class TestMTS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Unesite za koliko korisnika unosite podatke:");
        int brKorisnika = sc.nextInt();

        Korisnik[] korisnici = new Korisnik[brKorisnika];

        for (int i = 0; i < brKorisnika; i++){
            System.out.println("Unesite telefonski broj korisnika " + (i+1) + ":");
            String unetBroj = sc.next();
            if (!Korisnik.validanBroj(unetBroj)){
                i--;
            }
            System.out.println("Unesite 1 ili 2:\t1-prepaid korisnik\t2-postpaid korisnik");
            int preOrPost = sc.nextInt();
            switch (preOrPost){
                case 1:
                    System.out.println("Unesite kredit: ");
                    int unetiKredit = sc.nextInt();
                    String[] ffUneti = new String[3];
                    for (int j = 0; j < ffUneti.length; j++){
                        System.out.println("Unesite telefonski broj friends&family korisnika " + (j+1) + ":");
                        ffUneti[j] = sc.next();
                        if (!Korisnik.validanBroj(ffUneti[j])){
                            j--;
                        }
                    }
                    korisnici[i] = new Prepaid(unetBroj, unetiKredit, ffUneti);
                    break;
                case 2:
                    break;
            }
        }

        Random random = new Random();
        for (int i = 0; i < 5; i++){
            Korisnik izabraniKorisnik = korisnici[random.nextInt(korisnici.length)];
            System.out.println(izabraniKorisnik);

            if (izabraniKorisnik instanceof Prepaid){
                System.out.println("Unesite 1, 2 ili 3:\t1-dopuna\t2-razgovor\t3-sms");
                int izbor = sc.nextInt();
                switch (izbor){
                    case 1:
                        System.out.println("Unesite iznos dopune:");
                        ((Prepaid) izabraniKorisnik).dopuni_kredit(sc.nextInt());
                        System.out.println("Stanje korisnika:\n" + izabraniKorisnik);
                        break;
                    case 2:
                        System.out.println("Unesite broj koji se poziva:");
                        String brSaKojimSeRaz = sc.next();
                        System.out.println("Unesite trajanje razgovora:\nUnesite sati:");
                        int sati = sc.nextInt();
                        System.out.println("Unesite minute:");
                        int minuti = sc.nextInt();
                        System.out.println("Unesite sekunde:");
                        int sekunde = sc.nextInt();
                        if (Vreme.ispravnoVreme(sati, minuti, sekunde)){
                            izabraniKorisnik.azuriraj_racun_razgovor(new Razgovor(brSaKojimSeRaz, new Vreme(sati,
                                    minuti, sekunde)));
                            System.out.println("Stanje korisnika:\n" + izabraniKorisnik);
                            break;
                        } else {
                            System.out.println("Neispravno uneto vreme trajanja razgovora!");
                            i--;
                            continue;
                        }
                    case 3:
                        izabraniKorisnik.azuriraj_racun_SMS();
                        System.out.println("Stanje korisnika:\n" + izabraniKorisnik);
                        break;
                    default:
                        System.out.println("Pogresna opcija!");
                        i--;
                }
            } else {
                System.out.println("Unesite 1 ili 2:\t1-razgovor\t2-sms");

            }

        }







    }
}
