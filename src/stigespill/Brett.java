package stigespill;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author johannesantonsen
 * @author magnemikael
 * Denne klassen inneholder brettet, som eier rutene. Klassen skal initialisere brett, ruter og stiger/slanger.
 * Brettet handterer flytting av brikker, dette inkluderer flytting til fengsel.
 */

public class Brett {

    private Rute[] ruter;
    private Map<Integer, Integer> stigerOgSlanger;

    public Brett(ArrayList<Brikke> brikker) {
        ruter = new Rute[100];
        stigerOgSlanger = new HashMap<>();
        initRuter();
        initBrett(brikker);
        initStigerOgSlanger();
    }

    /**
     *
     * @param brikker legger til brikkene i spillet i rute 1
     */
    private void initBrett(ArrayList<Brikke> brikker) {
        brikker.forEach(b -> ruter[0].leggTilBrikke(b));
    }

    private void initRuter() {
        for (int i = 1; i <= 100; i++) {
            Rute rute = new Rute(i);
            ruter[i - 1] = rute;
        }
    }

    private void initStigerOgSlanger() {
        stigerOgSlanger.put(3, 8);
        stigerOgSlanger.put(6, 26);
        stigerOgSlanger.put(20, 39);
        stigerOgSlanger.put(36, 57);
        stigerOgSlanger.put(51, 72);
        stigerOgSlanger.put(71, 92);
        stigerOgSlanger.put(80, 99);

        stigerOgSlanger.put(16, 5);
        stigerOgSlanger.put(47, 25);
        stigerOgSlanger.put(49, 11);
        stigerOgSlanger.put(56, 53);
        stigerOgSlanger.put(62, 19);
        stigerOgSlanger.put(64, 60);
        stigerOgSlanger.put(87, 24);
        stigerOgSlanger.put(93, 73);
        stigerOgSlanger.put(95, 75);
        stigerOgSlanger.put(98, 78);
    }

    /**
     *
     * @param brikke brikken til spilleren som skal gjøre trekk
     * @param sum summen som ble trillet
     */
    public void flyttBrikke(Brikke brikke, int sum) {

        System.out.println("Spiller " + brikke.getNummer() + " sto på rute " + ruter[brikke.getPos()].getNummer() + " og rullet " + sum);

        int nyPos = sum + brikke.getPos();

        if (nyPos >= 100) {
            System.out.println("Spiller " + brikke.getNummer() + " kom over rute 100, og blir stående...");
            return;
        }

        ruter[brikke.getPos()].fjernBrikke(brikke);

        if (stigerOgSlanger.containsKey(nyPos)) {
            System.out.println("Spiller " + brikke.getNummer()  + " traff en spesiell rute... ");
            brikke.updatePos(stigerOgSlanger.get(nyPos));
        } else {
            brikke.updatePos(nyPos);
        }

        ruter[brikke.getPos()].leggTilBrikke(brikke);

        System.out.println("og landet på " + ruter[brikke.getPos()].getNummer());
        System.out.println();
    }

    /**
     *
     * @param brikke brikken som skal settes i fengsel etter å ha rullet for mange 6-ere,
     *               fengsel er referanse til rute 1. Spilleren må deretter rulle 6 for å
     *               slippe ut
     */
    public void settIFengsel(Brikke brikke) {
        brikke.setFengsel(true);

        ruter[brikke.getPos()].fjernBrikke(brikke);
        ruter[0].leggTilBrikke(brikke);
        brikke.updatePos(0);

        System.out.println("Spiller " + brikke.getNummer() + " trillet 6 for mange ganger, og settes i fengsel...");
        System.out.println();
    }

}
