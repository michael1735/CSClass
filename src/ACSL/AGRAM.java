package ACSL;

import java.util.Arrays;
import java.util.Scanner;

public class AGRAM {

    static Scanner input = new Scanner(System.in);

    public AGRAM(String line) {
        // split data
        String currentLn = line;
        String[] currentLine = currentLn.split(", ");
        String opponentCard = currentLine[0];
        String[] myCard = Arrays.copyOfRange(currentLine, 1, currentLine.length);
        // System.out.println(Arrays.toString(myCard));
        // System.out.println(opponentCard);
        int opponentRank = toRank(opponentCard);
        // System.out.println(opponentRank);
        String opponentSuit = opponentCard.substring(1, 2);
        // System.out.println(opponentSuit);
        String[] mySuit = new String[myCard.length];
        int[] myRank = new int[myCard.length];
        for (int i = 0; i < myCard.length; i++) {
            myRank[i] = toRank(myCard[i]);
            mySuit[i] = myCard[i].substring(1, 2);
        }
        System.out.println(Arrays.toString(myRank));
        System.out.println(Arrays.toString(mySuit));
    }

    public int toRank(String card) {
        if (card.charAt(0) == 'A') {
            return 14;
        } else if (card.charAt(0) == 'K') {
            return 13;
        } else if (card.charAt(0) == 'Q') {
            return 12;
        } else if (card.charAt(0) == 'J') {
            return 11;
        } else if (card.charAt(0) == 'T')
            return 10;
        else
            return Integer.parseInt(card.substring(0, 1));
    }
    public static void main(String[] args) {
        String line1 = "5D, 2D, 6H, 9D, TD, 6H";
        String line2 = "TC, AC, KC, QH, JS, TD";
        String line3 = "3D, 4H, 5C, 6S, 2D, 7H";
        String line4 = "KS, TH, QC, 3D, 9H, 3H";
        String line5 = "AC, AD, KH, AS, KS, QS";

        AGRAM ln1 = new AGRAM(line1);
        AGRAM ln2 = new AGRAM(line2);
        AGRAM ln3 = new AGRAM(line3);
        AGRAM ln4 = new AGRAM(line4);
        AGRAM ln5 = new AGRAM(line5);
    }
}
