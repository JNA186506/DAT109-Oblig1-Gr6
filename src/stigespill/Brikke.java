package stigespill;

public class Brikke {

    private int nummer;
    private int pos;
    private boolean erVinner;
    private boolean erIFengsel;

    /**
     *
     * @param nummer
     * Pos er indeks, ikke paa brettet "fysisk".
     * Brikken inneholder informasjon om spilleren som eier brikken er vinner, og om brikken er i fengsel.
     * Brikken har også kontroll på hvilken posisjon den står på, dette brukes direkte i brett.flyttBrikke().
     */

    public Brikke(int nummer) {
        this.nummer = nummer;
        this.pos = 0;
        this.erVinner = false;
        this.erIFengsel = false;
    }

    public int getNummer() {
        return nummer;
    }

    public int getPos() {
        return pos;
    }

    public void updatePos(int nyPos) {
        this.pos = nyPos;
    }

    public boolean erIFengsel() {
        return erIFengsel;
    }

    /**
     *
     * @param erIFengsel setter verdien til om brikke er satt i fengsel
     */
    public void setFengsel(boolean erIFengsel) {
        this.erIFengsel = erIFengsel;
    }

    public boolean vantSpilleren() {

        if (this.pos == 99) {
            this.erVinner = true;
        }

        return erVinner;
    }

}
