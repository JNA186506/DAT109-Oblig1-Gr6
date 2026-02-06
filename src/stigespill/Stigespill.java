package stigespill;

import javax.swing.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author magnemikael
 * @author johannesantonsen
 * Stigespill-klassen skal inneholde spill-logikken. Dette inkluderer rulling av terning og spille-regler.
 * Klassen inneholder core-gameloop.
 */
public class Stigespill {

    private final Timer timer;
    private AtomicInteger spillerSinTur;
    private ArrayList<Spiller> spillere = new ArrayList<>();
    private ArrayList<Brikke> brikker = new ArrayList<>();
    private Brett brett;
    private final int MAXROLLS = 3;

    public Stigespill(int antallSpillere) {
        timer = new Timer(1000, e -> gameTick());
        spillerSinTur = new AtomicInteger(0);

        for (int i = 1; i <= antallSpillere; i++) {
            spillere.add(new Spiller(i));
            brikker.add(spillere.get(i - 1).getBrikke());
        }

        brett = new Brett(brikker);
    }

    public void startTimer() {
        timer.start();
    }

    public void stopTimer() {
        timer.stop();
    }

    public void gameTick() {

        Brikke aktivBrikke = getBrikkeSomSpiller();

        if (aktivBrikke.erIFengsel()) {
            int rullet = Terning.rull();

            if (rullet == 6) {
                System.out.println("Spiller " + aktivBrikke.getNummer() + " har rullet 6 og slippes ut av fengsel... ");
                System.out.println();

                inkrementerSpiller();
                return;
            }

            System.out.println("Spiller " + aktivBrikke.getNummer() + " har rullet " + rullet + " og fortsetter fengselsoppholdet... ");
            System.out.println();

        } else {
            int antallSeks = 0;

            while (antallSeks < MAXROLLS) {
                int rullet = Terning.rull();

                brett.flyttBrikke(aktivBrikke, rullet);

                if (aktivBrikke.vantSpilleren()) {
                    System.out.println("Spiller " + aktivBrikke.getNummer() + " vant...");
                    stopTimer();
                    return;
                }

                if (rullet == 6) {
                    antallSeks++;
                } else {
                    break;
                }

                if (antallSeks == MAXROLLS) {
                    brett.settIFengsel(aktivBrikke);
                    aktivBrikke.setFengsel(true);
                    break;
                }
            }
        }

       inkrementerSpiller();
    }

    public Brikke getBrikkeSomSpiller() {
        return brikker.get(spillerSinTur.get());
    }

    public Brett getBrett() {
        return brett;
    }

    public void inkrementerSpiller() {
        spillerSinTur.incrementAndGet();
        spillerSinTur.set(spillerSinTur.get() % spillere.size());
    }

}
