package stigespill;

public class Spiller {

    private Brikke brikke;
    private int spillerNummer;

    public Spiller(int spillerNummer) {
        this.spillerNummer = spillerNummer;
        brikke = new Brikke(spillerNummer);
    }

    public Brikke getBrikke() {
        return brikke;
    }

    public int getSpillerNummer() {
        return spillerNummer;
    }
}
