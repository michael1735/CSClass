package CCC.CCC2019;

import java.util.Scanner;

public class TimeToDecompress {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        int L = scan.nextInt();
        String[][] input = new String[L][2];
        for (int i = 0; i < L; i++) {
            input[i] = scan.nextLine().split(" ");
        }
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < Integer.parseInt(input[i][0]); j++) {
                System.out.print(input[i][1]);
            }
        }
    }
}
