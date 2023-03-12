package CCC.CCC2019;

import java.util.Scanner;

public class WinningScore {
    static Scanner scan = new Scanner(System.in);
    static int[] score = new int[2];
    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            int temp = scan.nextInt();
            if (i < 3) {
                if (i == 0) {
                    score[0] += temp * 3;
                } else if (i == 1) {
                    score[0] += temp * 2;
                } else {
                    score[0] += temp;
                }
            } else {
                if (i == 3) {
                    score[1] += temp * 3;
                } else if (i == 4) {
                    score[1] += temp * 2;
                } else {
                    score[1] += temp;
                }
            }
        }
        if (score[0] > score[1]) {
            System.out.println("A");
        } else if (score[0] == score[1]) {
            System.out.println("T");
        } else {
            System.out.println("B");
        }
    }
}
