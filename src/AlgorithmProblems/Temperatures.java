package AlgorithmProblems;

import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
public class Temperatures {
    // From CodinGame

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of temperatures to analyse
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int t = in.nextInt(); // a temperature expressed as an integer ranging from -273 to 5526
            arr[i] = t;
        }

        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");

        if (n == 0) {
            System.out.println("0");
        } else {
            int min = Integer.MAX_VALUE;

            for (int temperature : arr) {
                if (Math.abs(temperature) < Math.abs(min) || (temperature == -min && temperature > 0)) {
                    min = temperature;
                }
            }
            System.out.println(min);
        }
    }
}
// 7 5 9 14
// 5526