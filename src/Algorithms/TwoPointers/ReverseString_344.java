package Algorithms.TwoPointers;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseString_344 {
    // LC. 344
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        char[] str = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            str[i] = s.charAt(i);
        }

        reverseString(str);

        System.out.println(Arrays.toString(str));
    }

    public static void reverseString(char[] s) {
        if (s.length == 0 || s.length == 1) {
            return;
        }

        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;
        }
    }
}
