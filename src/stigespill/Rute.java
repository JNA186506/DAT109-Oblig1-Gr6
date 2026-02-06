package stigespill;

import java.util.ArrayList;

/**
 * @author johannesnikolai
 * @author magnemikael
 * Denne klassen skal inneholde rutenummer og brikkene som står på ruten.
 */

public class Rute {

    private ArrayList<Brikke> brikker;
    private int nummer;

    public Rute(int nummer) {
        this.nummer = nummer;
        brikker = new ArrayList<>();
    }

    public ArrayList<Brikke> getBrikker() {
        return brikker;
    }

    public void setBrikker(ArrayList<Brikke> brikker) {
        this.brikker = brikker;
    }

    public int getNummer() {
        return nummer;
    }

    public void leggTilBrikke(Brikke nyBrikke) {
        brikker.add(nyBrikke);
    }

    public void fjernBrikke(Brikke gammelBrikke) {
        brikker.remove(gammelBrikke);
    }
}
