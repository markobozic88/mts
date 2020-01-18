import java.util.Scanner;

public class TestMTS {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Unesite broj korisnika:");
        String unetBroj = sc.next();
        Korisnik.validanBroj(unetBroj);

    }
}
