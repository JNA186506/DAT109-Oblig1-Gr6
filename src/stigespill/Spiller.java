package stigespill;

public class Spiller {

    private Brikke brikke;
    private int spillerNummer;

    /**
     *
     * @param spillerNummer spillernummer er også brikkenummer.
     *                      Man finner spillernummer ved å bruke brikke.getNummer()
     *
     * Denne klassen simulerer spillere. For å kunne skalere løsningen må denne klassen finnes.
     * Dette er for å lagre "gamestate".
     *
     */
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
