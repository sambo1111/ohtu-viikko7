/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameModes;

import AI.InterfaceTekoaly;
import AI.Tekoaly;
import AI.TekoalyParannettu;
import java.util.Scanner;
import ohtu.kivipaperisakset.Tuomari;

/**
 *
 * @author hasasami
 */
public abstract class KPS implements KPSInterface {
    Scanner scanner;
    Tuomari tuomari;
    
    public KPS(Scanner s, Tuomari t) {
        this.scanner = s;
        this.tuomari = t;
    }
    
    @Override
    public void pelaa() {
        
        String ekanSiirto = annaSiirto();
        String tokanSiirto = annaSiirto();

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari + "\n");

            ekanSiirto = annaSiirto();
            tokanSiirto = annaSiirto();
            asetaSiirto(ekanSiirto);
        }
        
        System.out.println("\nKiitos!\n" + tuomari);
        tuomari.nollaa();
    }
    
    public boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
    
    protected abstract String annaSiirto();
    
    protected abstract void asetaSiirto(String siirto);
}
