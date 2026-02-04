package stigespill;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

    private void initBrett(ArrayList<Brikke> brikker) {
        brikker.forEach(b -> ruter[0].leggTilBrikke(b));
    }

    private void initRuter() {
        for (int i = 0; i < 100; i++) {
            Rute rute = new Rute(i + 1);
            ruter[i] = rute;
        }
    }

    private void initStigerOgSlanger() {
        stigerOgSlanger.put(3,8);
        //TODO flere stiger og slanger
    }

    public void flyttBrikke(Brikke brikke, int sum) {

        System.out.println("Du rullet " + sum);

        int nyPos = sum + brikke.getPos();

        if (nyPos > 100) {
            System.out.println("Du kom over rute 100, du blir stående...");
            return;
        }

        ruter[brikke.getPos()].fjernBrikke(brikke);

        if (stigerOgSlanger.containsKey(nyPos)) {
            System.out.println("Du traff en spesiell rute... ");
            brikke.updatePos(stigerOgSlanger.get(nyPos));
        } else {
            brikke.updatePos(nyPos);
        }

        ruter[brikke.getPos()].leggTilBrikke(brikke);
    }

}
