import java.io.IOException;
import java.util.*;

public class Prithee {
    private static final String SonnetVerse = "Two households, both alike in dignity, \nIn fair Verona, where we lay our scene, \nFrom ancient grudge break to new mutiny, \nWhere civil blood makes civil hands unclean. \nFrom forth the fatal loins of these two foes \nA pair of star-cross’d lovers take their life; \nWhose misadventured piteous overthrows \nDo with their death bury their parents’ strife. \nThe fearful passage of their death-mark’d love, \nAnd the continuance of their parents’ rage, \nWhich, but their children’s end, nought could remove, \nIs now the two hours’ traffic of our stage; \nThe which if you with patient ears attend, \nWhat here shall miss, our toil shall strive to mend.";
    private static final String[] SonnetArray = SonnetVerse.split(" ");
    private static final String[] CleanedSonnetArray = SonnetVerse.replaceAll(",", "").replaceAll("\\.", "").toLowerCase().split(" ");
    private static final Scanner input = new Scanner(System.in);

    public static String getSonnetVerse() {
        return SonnetVerse;
    }

    public static String[] getSonnetArray() {
        return SonnetArray;
    }

    public static String[] getCleanedSonnetArray() {
        return CleanedSonnetArray;
    }

    public static void promptEnterKey(){
        System.out.println("Press \"ENTER\" to continue...");
        try {
            int _ = System.in.read(new byte[2]);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void pritheeLoop () {
        int numCorrect = 0;
        int numIncorrect = 0;
        while (numCorrect < 3 && numIncorrect < 3) {
            int randomDigit = new Random().nextInt(CleanedSonnetArray.length);

            if (pritheeGame(randomDigit)) {
                System.out.println("Correct!");
                numCorrect++;
            }
            else {
                numIncorrect++;
                System.out.println("Incorrect...");
            }
            System.out.printf("You have %d correct and %d incorrect", numCorrect, numIncorrect);
            System.out.println();
            if (numCorrect < 3 && numIncorrect < 3) promptEnterKey();
        }
        System.out.println("Game over.");
    }

    public static boolean pritheeGame(int randomDigit) {
        for (int i = 0; i < randomDigit; i++) {
            System.out.print(SonnetArray[i] + " ");
        }

        for (int i = 0; i < CleanedSonnetArray[randomDigit].length(); i++) {
            System.out.print("_");
        }
        System.out.println();
        System.out.println("------------------------------------");

        System.out.print("INPUT YOUR GUESS HERE: ");

        String matchInput = input.next();
        return matchInput.equalsIgnoreCase(CleanedSonnetArray[randomDigit]);
    }
}
