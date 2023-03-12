package LuoGu;

import java.util.Scanner;

public class P5712 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        System.out.print("Today I ate " + x + " apple");
        if (x != 0 && x != 1) {
            System.out.print("s");
        }
        System.out.print(".");
    }
}
