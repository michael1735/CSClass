package ACSL;

import java.util.Scanner;

public class ForceFindPrimeFactors {
    // ǿ�зֽ��������ķ���
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int k = 2;
        System.out.print(m + " = ");
        while (k <= m) {
            if (k == m) {
                System.out.println(m);
                break;
            } else if (m % k == 0) {
                System.out.print(k + " * ");
                m = m / k;
            } else {
                k++; // k�����ı��
            }
        }
    }
}
