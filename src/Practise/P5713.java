package Practise;

import java.util.Scanner;

public class P5713 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        if ((5 * n) < (11 + 3 * n)) {
            System.out.println("Local");
        } else {
            System.out.println("Luogu");
        }
    }
}
