package LuoGu;

import java.util.Scanner;

public class P5711 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        boolean p1 = x % 4 == 0;
        boolean p2 = x % 100 == 0;
        boolean p3 = x % 400 == 0;
        boolean p = p3 && (p1 || !p2);
        System.out.println(p ? 1 : 0);
    }
}
