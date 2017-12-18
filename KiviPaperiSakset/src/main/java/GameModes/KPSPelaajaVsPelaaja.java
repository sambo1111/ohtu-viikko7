package GameModes;

import java.util.Scanner;
import ohtu.kivipaperisakset.Tuomari;

public class KPSPelaajaVsPelaaja extends KPS {
    
    private int vuoro;

    public KPSPelaajaVsPelaaja(Scanner s, Tuomari t) {
        super(s, t);
        vuoro = 1;
    }

    @Override
    protected String annaSiirto() {
        if (vuoro == 1) {
            System.out.println("Ensimmäisen pelaajan siirto: ");
        } else {
            System.out.println("Toisen pelaajan siirto: ");
        }
        
        vuoro = 3 - vuoro;
        String siirto = scanner.nextLine();
        return siirto;
    }

    @Override
    protected void asetaSiirto(String siirto) {

    }
    
    public static KPSPelaajaVsPelaaja create() {
        return new KPSPelaajaVsPelaaja(new Scanner(System.in), new Tuomari());
    }
}
