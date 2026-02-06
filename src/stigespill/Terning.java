package stigespill;

import java.util.Random;

/**
 * @author johannesantonsen
 * Enkel statisk hjelpeklasse som inneholder terning, og rulling av terning.
 */
public class Terning {
    public static int rull() {
        Random random = new Random();

        return random.nextInt(1,7);
    }
}
