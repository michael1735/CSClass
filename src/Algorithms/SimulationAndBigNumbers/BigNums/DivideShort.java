package Algorithms.SimulationAndBigNumbers.BigNums;

import java.util.Scanner;

public class DivideShort {
    /*
    高精度/低精度的情况
    先按正常代码写，之后再迁移到Calc里

    除法是从左往右顺序计算，和其他三则运算不同
     */
    static String input;
    static int[] a = new int[100], res = new int[100];
    static int len, remainder;
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        input = scanner.next();
        len = input.length();

        for (int i = 0; i < len; i++) {
            a[i] = input.charAt(i) - '0';
        }

        int x = scanner.nextInt(); // 代表除数，是一个低精度数字
        remainder = 0; // 余数

        for (int i = 0; i < len; i++) {
            res[i] = (remainder * 10 + a[i]) / x;
            remainder = (remainder * 10 + a[i]) % x;
        }

        // 有些情况，如9876 / 21，会出现前导0
        // 处理:
        int firstNonZeroPos = 0; // 第一个非0数的位置
        // 检查前导0
        while (res[firstNonZeroPos] == 0 && firstNonZeroPos < len) {
            firstNonZeroPos++;
        }

        // 输出商
        for (int i = firstNonZeroPos; i < len; i++) {
            System.out.print(res[i]);
        }
        System.out.println();
        // 输出余数
        System.out.println(remainder);
    }
}
