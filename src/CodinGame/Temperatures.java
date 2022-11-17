package CodinGame;

import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
public class Temperatures {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of temperatures to analyse
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int t = in.nextInt(); // a temperature expressed as an integer ranging from -273 to 5526
            arr[i] = t;
        }

        int posClosest = Integer.MAX_VALUE;
        int negClosest = Integer.MIN_VALUE;

        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");

        for (int temp : arr) {
            if (temp > 0) {
                if (posClosest > temp) {
                    posClosest = temp;
                }
            } else {
                if (negClosest < temp) {
                    negClosest = temp;
                }
            }
        }

        int result;

        if (posClosest > Math.abs(negClosest)) {
            // 条件改成了 >, 这两个测试数据没问题了
            result = posClosest;
        } else if (posClosest == Math.abs(negClosest)) {
            result = posClosest;
        } else {
            result = negClosest;
        }

        System.out.println(result);
    }
}
// 7 5 9 14
// 5526