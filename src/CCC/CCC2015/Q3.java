package CCC.CCC2015;

import java.util.Scanner;

public class Q3 {
//    long start =
    static char[] vowels = {'a', 'e', 'i', 'o', 'u'};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputString = scan.nextLine();
        StringBuilder result = new StringBuilder(30);
        for (char c : inputString.toCharArray()) {
            if (isConsonant(c)) {
                result.append(c).append(closestVowel(c)).append(nextConsonant(c));
            } else {
                result.append(c);
            }
        }
        System.out.println(result);
    }

    public static boolean isConsonant(char ch) {
        boolean consonant = true;
        for (char c : vowels) {
            if (ch == c) {
                consonant = false;
                break;
            }
        }
        return consonant;
    }

    public static char closestVowel(char ch) {
        char retChar = 0;
        int tempCharSub = ch - vowels[0];
        for (int i = 1; i < vowels.length; i++) {
            if (Math.abs(ch - vowels[i]) < Math.abs(tempCharSub)) {
                retChar = vowels[i];
                tempCharSub = ch - vowels[i];
            }
        }
        return retChar;
    }

    public static char nextConsonant(char ch) {
        if (isConsonant((char) (ch + 1))) {
            return (char) (ch + 1);
        } else {
            return (char) (ch + 2);
        }
    }
}
