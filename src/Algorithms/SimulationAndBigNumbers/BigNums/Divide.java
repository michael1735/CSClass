package Algorithms.SimulationAndBigNumbers.BigNums;

import java.util.Arrays;
import java.util.Scanner;

public class Divide {
    /*
    ���Ը߾�����: ����ģ�����

    �̵����λ�� = ���������� - �������� + 1

    ����78945/345
    78945
    -34500------ quotient[3]++ _____________ ԭ���ǣ����ǵĸ߾��������ǵ���洢��

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
    һ�� x8�μ���
    285 ---- ����



    С����: int������, 0��λ�����ֳ���, ��1��λ��ʼ������ -> ����Ƚ��������ֵĴ�С
     */

    static String c1, c2;
    static int[] dividend = new int[1000], divisor = new int[1000], tempDivisor = new int[1000];
    static int[] quotient = new int[1000];

    // С����: int������, 0��λ��ʵ�ʵ����ֳ���, ��1��λ��ʼ������ -> ����Ƚ��������ֵĴ�С
    static int intCmp(int[] a, int[] b) {
        if (a[0] > b[0]) {
            return 1; // a��
        }
        if (a[0] < b[0]) {
            return -1; // b��
        }

        for (int i = a[0]; i > 0; i--) { // ����a.length, ��Ϊ����0��λ��ľ��ǳ���, ���һ�Ҫ�����ȡ
            // ��λ�Ƚ�
            if (a[i] > b[i]) {
                return 1;
            }
            if (a[i] < b[i]) {
                return -1;
            }
        }
        return 0; // a, b��ȫһ��
    }

    // �߾��ȼ���
    static void sub(int[] a, int[] b) {
        if (intCmp(a, b) == 0) {
            a[0] = 0;
            return;
        }

        for (int i = 1; i <= a[0]; i++) {
            // ��λ
            if (a[i] < b[i]) {
                a[i+1]--;
                a[i] += 10;
            }
            // ����
            a[i] -= b[i];
        }

        // ����ǰ����
        while (a[0] > 0 && a[a[0]] == 0) {
            // ÿ������������ǰ����: ��������һλ�������ֵĵ�һλ=0���ͽ����ֳ��ȼ���1, ֱ�����ַ�0�Ż��˳�
            // �൱����û�����ڴ�ֻ�Ǹ���ָ��
            a[0]--;
        }
    }

    // ���鸴��
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
        // c1����浽dividend��, c2����divisor��
        reverseAndPutInt(c1.toCharArray(), dividend);
        reverseAndPutInt(c2.toCharArray(), divisor);

        // �̵����λ��
        quotient[0] = dividend[0] - divisor[0] + 1;
        for (int i = quotient[0]; i > 0; i--) {
            // ÿ�����¿�ʼѭ��ʱ��temp����
            Arrays.fill(tempDivisor, 0);
            copy(divisor, tempDivisor, i);
            while (intCmp(dividend, tempDivisor) >= 0) {
                sub(dividend, tempDivisor);
                quotient[i]++;
            }
        }

        // �����̵�λ��
        while (quotient[0] > 0 && quotient[quotient[0]] == 0) {
            quotient[0]--;
        }
        // ����̺�����
        // ��
        print(quotient);
        // ����
        print(dividend);
    }

    /*
    78945 345
    ֮�������dry runһ�¿���������ô��λdivisor��
     */
}
