package Algorithms.TwoPointers;

import java.util.Scanner;

public class VerifyPalindrome_125 {

    public static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }

        if (s.equals("") || s.length() == 1) {
            return true;
        }

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static String processString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                sb.append(s.charAt(i));
            } else if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                char c = (char) (s.charAt(i) - 'A' + 'a');
                sb.append(c);
            } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String processed = processString(s);
        System.out.println(isPalindrome(processed));
    }
}
