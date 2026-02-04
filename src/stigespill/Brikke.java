package stigespill;

public class Brikke {

    private int nummer;
    private int pos;

    /**
     *
     * @param nummer
     * Pos er indeks, ikke paa brettet "fysisk".
     */

    public Brikke(int nummer) {
        this.nummer = nummer;
        this.pos = 0;
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

}
