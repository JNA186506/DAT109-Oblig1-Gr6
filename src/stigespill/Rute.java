package stigespill;

import java.util.ArrayList;

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

    public boolean sjekkOmBrikke(Brikke brikke) {
        return brikker.contains(brikke);
    }

    public void leggTilBrikke(Brikke nyBrikke) {
        brikker.add(nyBrikke);
    }

    public void fjernBrikke(Brikke gammelBrikke) {
        brikker.remove(gammelBrikke);
    }
}
