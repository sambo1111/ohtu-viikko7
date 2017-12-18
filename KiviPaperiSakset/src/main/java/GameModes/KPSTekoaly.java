package GameModes;

import AI.InterfaceTekoaly;
import AI.Tekoaly;
import AI.TekoalyParannettu;
import java.util.Scanner;
import ohtu.kivipaperisakset.Tuomari;

public class KPSTekoaly extends KPS {

    InterfaceTekoaly tekoaly;
    private int vuoro;

    public KPSTekoaly(Scanner s, Tuomari t, InterfaceTekoaly teko) {
        super(s, t);
        this.tekoaly = teko;
        vuoro = 1;
    }

    @Override
    protected String annaSiirto() {
        if (vuoro == 1) {
            vuoro = 2;
            System.out.println("Ensimmäisen pelaajan siirto: ");
            return scanner.nextLine();
        }

        String siirto = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + siirto);
        vuoro = 1;
        return siirto;
    }

    @Override
    protected void asetaSiirto(String siirto) {
        tekoaly.asetaSiirto(siirto);
    }
    
    public static KPSTekoaly createNormal() {
        return new KPSTekoaly(new Scanner(System.in), new Tuomari(), new Tekoaly());
    }
    
    public static KPSTekoaly createHard() {
        return new KPSTekoaly(new Scanner(System.in), new Tuomari(), new TekoalyParannettu(20));
    }
}
