package ACSL;

import java.util.ArrayList;
import java.util.Scanner;

public class ADF {
    // ACSL difference factor
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        String[] in1 = {"I am going home now", "I will go home now"};
        String[] in2 = {"The big black bear bit a big black bug", "The big black bug bled black blood"};
        String[] in3 = {"Complementary angle measures sum to 90 degrees.", "The measures of supplementary angles add to 180 degrees."};
        String[] in4 = {"A Tale of Two Cities was published by Dickens in 1859.", "In 1839, Charles Dickens published Nicholas Nickleby."};
        String[] in5 = {"Connecticut is The Constitution State.", "Hartford is the capital of Connecticut."};

        System.out.println(diffFactor(in1[0], in1[1]));
        System.out.println(diffFactor(in2[0], in2[1]));
        System.out.println(diffFactor(in3[0], in3[1]));
        System.out.println(diffFactor(in4[0], in4[1]));
        System.out.println(diffFactor(in5[0], in5[1]));
    }

    public static int diffFactor(String str1, String str2) {
        ArrayList<String> longestCommonSubStr = new ArrayList<>();
        String string1 = "";
        String string2 = "";
        for (char c : str1.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                string1 = string1.concat(String.valueOf(c));
            }
        }

        for (char c : str2.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                string2 = string2.concat(String.valueOf(c));
            }
        }
        string1 = string1.toUpperCase();
        string2 = string2.toUpperCase();

        
        return 0;
    }
}
