package ACSL;

import javax.print.DocFlavor;
import java.lang.reflect.Array;
import java.util.*;

public class AGRAM {

    static Scanner input = new Scanner(System.in);

    private int myOutRank;

    private String myOutSuit;

    private String output;

    public AGRAM(String line) {
        // split data
        String[] currentLine = line.split(", ");
        String opponentCard = currentLine[0];
        String[] myCard = Arrays.copyOfRange(currentLine, 1, currentLine.length);
        // System.out.println(Arrays.toString(myCard));
        // System.out.println(opponentCard);
        int opponentRank = toRank(opponentCard);
        // System.out.println(opponentRank);
        String opponentSuit = opponentCard.substring(1, 2);
        // System.out.println(opponentSuit);
        ArrayList<String> mySuit = new ArrayList<>();
        ArrayList<Integer> myRank = new ArrayList<>();
        for (int i = 0; i < myCard.length; i++) {
            myRank.add(toRank(myCard[i]));
            mySuit.add(myCard[i].substring(1, 2));
        }

        if (mySuit.contains(opponentSuit)) {
            output = sameSuit(opponentRank, opponentSuit, myRank, mySuit);
        } else {
//            output = diffSuit(myRank, mySuit);
            // @TODO 差一个diffSuit时的处理方法
        }
    }

    public String sameSuit(int oppoRank, String oppoSuit, ArrayList<Integer> myRank, ArrayList<String> mySuit) {
        String thisOppoSuit = oppoSuit; // opponentSuit when calling this func
        int thisOppoRank = oppoRank; // opponent rank
        ArrayList<Integer> thisRank = new ArrayList<>(myRank.size()); // stores stores my card ranks that have the same suit as o
        ArrayList<String> thisSuit = new ArrayList<>(mySuit.size()); // stores stores the same card suit

        for (int i = 0; i < myRank.size(); i++) {
            if (mySuit.get(i).equals(thisOppoSuit)) {
                thisRank.add(myRank.get(i));
                thisSuit.add(mySuit.get(i));
            }
        }
        // thisRank, thisSuit出现Null的原因是长度设置，，，用arrayList算了
        // System.out.println(thisRank);
        // System.out.println(thisSuit);

        Integer[] tempRank = new Integer[thisRank.size()]; // stores the sorted thisRank
        for (int i = 0; i < thisRank.size(); i++) {
            tempRank[i] = thisRank.get(i);
        }
        Arrays.sort(tempRank, Collections.reverseOrder());
//        System.out.println(Arrays.toString(tempRank));
        Integer tempLargerRank = 0;
        Integer tempLowestRank = tempRank[0];
        for (Integer i : tempRank) {
            if (i >= thisOppoRank)
                tempLargerRank = i;
            else
                tempLowestRank = i;
        }
//        System.out.println(tempLargerRank);
//        System.out.println(tempLowestRank);
        String suit = thisSuit.get(0);
        String returnLargerRank = toLetter(tempLargerRank);
        String returnLowestRank = toLetter(tempLowestRank);
        if (tempLargerRank == 0)
            return returnLowestRank + suit;
        else
            return returnLargerRank + suit;
    }

    public String toLetter(int cardRank) {
        if (cardRank == 1) {
            return "A";
        } else if (cardRank == 13) {
            return "K";
        } else if (cardRank == 12) {
            return "Q";
        } else if (cardRank == 11) {
            return "J";
        } else if (cardRank == 10) {
            return "T";
        } else {
            return String.valueOf(cardRank);
        }
    }
    public int toRank(String card) {
        if (card.charAt(0) == 'A') {
            return 1;
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
