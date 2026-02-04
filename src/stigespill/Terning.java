package stigespill;

import java.util.Random;

public class Terning {
    public static int rull() {
        Random random = new Random(System.currentTimeMillis());

        return random.nextInt(6) + 1;
    }
}
