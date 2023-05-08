package JavaPackage.UsefulModules;

import java.util.Scanner;
import java.util.Stack;

public class StackDemo {
    static Stack<Character> s = new Stack<>();
    static int num;

    static char transform(char c) {
        if (c == ')')
            return '(';
        if (c == ']')
            return '[';
        if (c == '}')
            return '{';
        return '\0';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str;

        while (!s.empty()) {
            s.pop();
        }
        str = scanner.nextLine();
        for (int i = 0; i < str.length(); i++) {
            if (s.empty()) {
                s.push(str.charAt(i));
                continue;
            }
            if (transform(str.charAt(i)) == s.peek()) {
                s.pop();
            } else {
                s.push(str.charAt(i));
            }
        }

        if (s.empty()) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
