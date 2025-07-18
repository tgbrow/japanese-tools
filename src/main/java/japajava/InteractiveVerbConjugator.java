package japajava;

import java.util.Scanner;

public class InteractiveVerbConjugator {
    public static void main(String[] args) {
        System.out.println("\nWelcome to Teddy's Japanese verb conjugator!\n");

        try (final Scanner scan = new Scanner(System.in)) {
            boolean keepGoing = true;
            while (keepGoing) {
                final Verb verb = getVerb(scan);

                System.out.println();
                System.out.println("dictionary:  " + verb.dictionary());
                System.out.println("polite:      " + verb.polite());
                System.out.println("past:        " + verb.past());
                System.out.println("past polite: " + verb.pastPolite());

                keepGoing = promptYesOrNo(scan, "Would you like to try another verb?");
            }
        }

        System.out.println("\nThank you for using Teddy's Japanese verb conjugator. Have a nice day!\n");
    }

    private static Verb getVerb(Scanner scan) {
        System.out.print("\nPlease enter the dictionary form of your verb: ");

        String input;
        do {
            input = scan.nextLine().trim();
        } while (input.isEmpty());

        if (input.equals("行く")) {
            return IrregularVerb.IKU;
        }

        if (input.equals("来る")) {
            return IrregularVerb.KURU;
        }

        if (input.equals("する")) {
            return IrregularVerb.SURU;
        }

        if (input.equals("いく") || input.equals("くる")) {
            // TODO
            throw new UnsupportedOperationException("\nFAILURE: ambiguous verb!\n");
        }

        if (Verb.getLastHiragana(input) == Hiragana.RU) {
            final boolean isIchidan = promptYesOrNo(scan, "Is this an ichidan verb, aka a る-verb?");
            return isIchidan ? new IchidanVerb(input) : new GodanVerb(input);
        }

        return new GodanVerb(input);
    }

    private static boolean promptYesOrNo(Scanner scan, String prompt) {
        System.out.print("\n" + prompt + " (y/n): ");
        return scan.nextLine().trim().toLowerCase().charAt(0) == 'y';
    }
}
