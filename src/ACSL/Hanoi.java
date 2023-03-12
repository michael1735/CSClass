package ACSL;

import java.util.Scanner;

public class Hanoi {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        hanoi(num, 'A', 'B', 'C');
        System.out.println(factorial(12L));
        System.out.println(fib(12));
        System.out.println(flipStr("Hello"));
        countDown(3);
        System.out.println(reverseInt(1234));
    }

    public static void hanoi(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("第" + num + "个圆盘从" + a + " -> " + c);
        } else {
            hanoi(num - 1, a, c, b);
            System.out.println("第" + num + "个圆盘从" + a + " -> " + c);
            hanoi(num - 1, b, a, c);
        }
    }

    // 1.
    public static long factorial(long n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public static String flipStr(String s) {
        if (s.equals("")) {
            return "";
        } else {
            return flipStr(s.substring(1)) + s.charAt(0);
        }
    }

    public static void countDown(int number) {
        if (number == 0) {
            System.out.println(0);
        } else {
            System.out.println(number);
            countDown(number - 1);
        }
    }

    public static int reverseInt(int i) {
        int reverse = 0;
        int remainder;
        do {
            remainder = i % 10;
            reverse = reverse * 10 + remainder;
            i = i / 10;
        } while (i > 0);

        return i;
    }
}
