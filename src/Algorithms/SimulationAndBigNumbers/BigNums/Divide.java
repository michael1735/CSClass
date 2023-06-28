package Algorithms.SimulationAndBigNumbers.BigNums;

import java.util.Arrays;
import java.util.Scanner;

public class Divide {
    /*
    除以高精度数: 减法模拟除法

    商的最大位数 = 被除数长度 - 除数长度 + 1

    比如78945/345
    78945
    -34500------ quotient[3]++ _____________ 原因是，我们的高精度数组是倒序存储的

    44445
    -34500-------- quotient[3]++

    9945
    -3450------ quot[2]++

    6495
    -3450------ quot[2]++

    3045
    -345 ------ quot[1]++
      .
      .
      .
    一共 x8次减法
    285 ---- 余数



    小技巧: int数组中, 0号位存数字长度, 从1号位开始存数字 -> 方便比较两个数字的大小
     */

    static String c1, c2;
    static int[] dividend = new int[1000], divisor = new int[1000], tempDivisor = new int[1000];
    static int[] quotient = new int[1000];

    // 小技巧: int数组中, 0号位存实际的数字长度, 从1号位开始存数字 -> 方便比较两个数字的大小
    static int intCmp(int[] a, int[] b) {
        if (a[0] > b[0]) {
            return 1; // a大
        }
        if (a[0] < b[0]) {
            return -1; // b大
        }

        for (int i = a[0]; i > 0; i--) { // 不用a.length, 因为我们0号位存的就是长度, 而且还要反向读取
            // 逐位比较
            if (a[i] > b[i]) {
                return 1;
            }
            if (a[i] < b[i]) {
                return -1;
            }
        }
        return 0; // a, b完全一样
    }

    // 高精度减法
    static void sub(int[] a, int[] b) {
        if (intCmp(a, b) == 0) {
            a[0] = 0;
            return;
        }

        for (int i = 1; i <= a[0]; i++) {
            // 借位
            if (a[i] < b[i]) {
                a[i+1]--;
                a[i] += 10;
            }
            // 减法
            a[i] -= b[i];
        }

        // 处理前导零
        while (a[0] > 0 && a[a[0]] == 0) {
            // 每当出现数字有前导零: 数组的最后一位——数字的第一位=0，就将数字长度减少1, 直到出现非0才会退出
            // 相当于是没回收内存只是改了指针
            a[0]--;
        }
    }

    // 数组复制
    static void copy(int[] a, int[] b, int j) {
        if (a[0] >= 0) System.arraycopy(a, 1, b, j, a[0]);
        b[0] = a[0] + j - 1;
    }

    static void reverseAndPutInt(char[] c, int[] a) {
        a[0] = c.length;
        for (int i = 0; i < a[0]; i++) {
            a[a[0] - i] = c[i] - '0';
        }
    }
    static void print(int[] a) {
        if (a[0] == 0) {
            System.out.println(0);
        }
        for (int i = a[0]; i > 0; i--) {
            System.out.print(a[i]);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        c1 = scanner.next();
        c2 = scanner.next();
        // c1倒序存到dividend中, c2倒序到divisor中
        reverseAndPutInt(c1.toCharArray(), dividend);
        reverseAndPutInt(c2.toCharArray(), divisor);

        // 商的最大位数
        quotient[0] = dividend[0] - divisor[0] + 1;
        for (int i = quotient[0]; i > 0; i--) {
            // 每次重新开始循环时将temp清零
            Arrays.fill(tempDivisor, 0);
            copy(divisor, tempDivisor, i);
            while (intCmp(dividend, tempDivisor) >= 0) {
                sub(dividend, tempDivisor);
                quotient[i]++;
            }
        }

        // 处理商的位数
        while (quotient[0] > 0 && quotient[quotient[0]] == 0) {
            quotient[0]--;
        }
        // 输出商和余数
        // 商
        print(quotient);
        // 余数
        print(dividend);
    }

    /*
    78945 345
    之后拿这个dry run一下看看到底怎么移位divisor的
     */
}
