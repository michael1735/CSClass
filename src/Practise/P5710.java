package Practise;

import java.util.Scanner;

public class P5710 {
    static int a, u, b, z;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        boolean p1 = n % 2 == 0;
        boolean p2 = 4 < n && n <= 12;
        a = p1 && p2 ? 1 : 0;
        u = p1 || p2 ? 1 : 0;
        b = p1 ^ p2 ? 1 : 0;
        z = !p1 && !p2 ? 1 : 0;
        System.out.printf("%d %d %d %d", a, u, b, z);
        /*
        ��������ò�ֱ�ӱȽ�, ��Ȼ������������, ��ȷ�ķ�ʽ�ǱȽ���������֮��Ĳ�ֵ�Ƿ�С��һ���̶�
        ��Math.abs(a - b) < 1e-6������������Ϊ������a��b���
         */
    }
}
