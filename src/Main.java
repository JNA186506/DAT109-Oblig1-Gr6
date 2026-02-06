import stigespill.Stigespill;

import javax.swing.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int antallSpillereInput;

        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Skriv inn antall spiller fra 2 til 4:");
            try {
                antallSpillereInput = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Ugyldig input");
                continue;
            }
            if (antallSpillereInput < 2 || antallSpillereInput > 4) {
                System.out.println("Tallet må være fra 2 til 4...");
            } else {
                break;
            }
        }

        final int antallSpillere = antallSpillereInput;

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Stigespill");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            Stigespill stigespill = new Stigespill(antallSpillere);
            stigespill.startTimer();

            frame.setVisible(true);
        });

    }
}