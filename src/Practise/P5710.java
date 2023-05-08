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
        浮点数最好不直接比较, 不然会产生精度误差, 正确的方式是比较这两个数之间的差值是否小于一定程度
        如Math.abs(a - b) < 1e-6成立即可以认为浮点数a和b相等
         */
    }
}
