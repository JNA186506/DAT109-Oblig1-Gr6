package stigespillTest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stigespill.Brett;
import stigespill.Brikke;
import stigespill.Spiller;
import stigespill.Terning;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BrettTest {

    @Test
    public void testTerning() {
        for (int i = 0; i < 100; i++) {
            int sum = Terning.rull();
            assertTrue(sum >= 1 && sum <= 6);
        }
    }

    @Test
    public void testBrikke() {
        Brikke brikke1 = new Brikke(1);
        Brikke brikke2 = new Brikke(2);
        Brikke brikke3 = new Brikke(3);

        assertEquals(0, brikke1.getPos());
        brikke1.updatePos(3);
        assertEquals(3, brikke1.getPos());

        assertEquals(0, brikke2.getPos());
        brikke2.updatePos(3);
        assertEquals(3, brikke2.getPos());

        assertEquals(0, brikke3.getPos());
        brikke3.updatePos(3);
        assertEquals(3, brikke3.getPos());
    }

    @Test
    public void testSpiller() {
        Spiller spiller1 = new Spiller(1);

        assertEquals(1, spiller1.getSpillerNummer());
        assertEquals(1, spiller1.getBrikke().getNummer());

        Spiller spiller2 = new Spiller(2);

        assertEquals(2, spiller2.getSpillerNummer());
        assertEquals(2, spiller2.getBrikke().getNummer());
    }

    @Test
    public void testBrett() {
        Spiller spiller = new Spiller(1);

        ArrayList<Brikke> brikker = new ArrayList<>();
        brikker.add(spiller.getBrikke());

        Brett brett = new Brett(brikker);

        brett.flyttBrikke(spiller.getBrikke(), 6);

        assertEquals(6, spiller.getBrikke().getPos());

        spiller.getBrikke().updatePos(0);

        brett.flyttBrikke(spiller.getBrikke(), 3);

        assertEquals(8, spiller.getBrikke().getPos());

    }
}
