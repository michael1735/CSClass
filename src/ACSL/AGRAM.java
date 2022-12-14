package ACSL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

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
        for (String s : myCard) {
            myRank.add(toRank(s));
            mySuit.add(s.substring(1, 2));
        }

        if (mySuit.contains(opponentSuit)) {
            output = sameSuit(opponentRank, opponentSuit, myRank, mySuit);
            // sameSuit已经可以不用管了
        } else {
            output = diffSuit(myRank, mySuit);
            // @TODO diffSuit完成后把这行注释取消
//            diffSuit(myRank, mySuit);
        }
        System.out.println(output);
    }


    public String diffSuit(ArrayList<Integer> myRank, ArrayList<String> mySuit) {
// @TODO 这个方法返回应该是String, 但是为了测试返回值改成了void, 记得改回来
        ArrayList<Integer> thisRank = new ArrayList<>(myRank.size());
        ArrayList<String> thisSuit = new ArrayList<>(mySuit.size());
        ArrayList<Integer> listOfIndices = new ArrayList<>(myRank.size()); // store the indices where the tie occurs
        int count = 0; // to help us determine whether there are ties
        String minSuit = ""; // to store the suit of the minimum rank

        for (int i = 0; i < myRank.size(); i++) {
            thisRank.add(myRank.get(i));
            thisSuit.add(mySuit.get(i));
        }
//        System.out.println(myRank);
//        System.out.println(mySuit);
//        System.out.println(thisRank);
//        System.out.println(thisSuit);

        ArrayList<Integer> tempRank = new ArrayList<>(thisRank.size());

        for (int i = 0; i < thisRank.size(); i++) {
            tempRank.add(thisRank.get(i));
        }
//        System.out.println(tempRank);
//        System.out.println(tempSuit);
        Collections.sort(tempRank);
//        System.out.println(tempRank);

        int minRank = tempRank.get(0);

        for (int i = 0; i < tempRank.size(); i++) {
            if (minRank >= thisRank.get(i)) {
                count++;
            }
        }
//        System.out.println(minRank);
//        System.out.println(count);

        minSuit = thisSuit.get(thisRank.indexOf(minRank));
//        System.out.println(minSuit);
        // @TODO 底下的是初步思路
        String returnStr = "";
        if (count == 1) {
             return minRank + minSuit;
            // @TODO 写完tie的解决方法(else)就可以把注释取消
        } else {
            for (int i = 0; i < thisRank.size(); i++) {
                if (thisRank.get(i) == minRank) {
                    listOfIndices.add(i);
                }
            }
//            System.out.println(listOfIndices);
            String outRank = toLetter(minRank);
            for (int i = 0; i < listOfIndices.size(); i++) {
                if (thisSuit.get(listOfIndices.get(i)).equals("C")) {
                    returnStr = outRank + "C";
                    break;
                } else if (thisSuit.get(listOfIndices.get(i)).equals("D")) {
                    returnStr = outRank + "D";
                    break;
                } else if (thisSuit.get(listOfIndices.get(i)).equals("H")) {
                    returnStr = outRank + "H";
                    break;
                } else {
                    returnStr = outRank + "S";
                    break;
                }
            }
        }
        return returnStr;
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
