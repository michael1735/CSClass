package Homework;

import java.util.Scanner;

import static java.lang.Long.parseLong;

public class ACSLIntermediate {
    public static void main(String[] args) {
        /*
        char-->int-->long-->float-->double
        byte-->short-->int-->long-->float-->double
         */
        Scanner input  = new Scanner(System.in);
        String[] inputStr = new String[5];
        // String[] inputNumber = new String[5];
        // String[] inputLength = new String[5];
        long[][] inputContents = new long[5][2];
        for (int i = 0; i < 5; i++){
            inputStr[i] = input.nextLine();
        }
        for (int i = 0; i < 5; i++){
            String[] temp;
            temp = inputStr[i].split(" ");
            for (int j = 0; j < 2; j++) {
                // Exception in thread "main" java.lang.NumberFormatException: For input string: "54981230845791"
                //	at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
                //	at java.base/java.lang.Integer.parseInt(Integer.java:668)
                //	at java.base/java.lang.Integer.parseInt(Integer.java:784)
                //	at Homework.ACSLIntermediate.main(ACSLIntermediate.java:25)
                inputContents[i][j] = parseLong(temp[j].trim()); // <-- 这一行,我觉得我已经把空格去了
            }
        }
        for (long[] i : inputContents){
            for (long j : i){
                System.out.println(j);
            }
        }
    }
    /*
    public int calculateAns(String[] inputNumber, String[] inputLength){

    }
    */
}
