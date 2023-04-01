package JavaPackage;

import java.lang.Math;
import java.util.Scanner;

public class FunctionsTest {
    public static void main(String[] args) {
        double x1, y1, x2, y2, x3, y3, ans;
        Scanner scan = new Scanner(System.in);
        x1 = scan.nextDouble();
        y1 = scan.nextDouble();
        x2 = scan.nextDouble();
        y2 = scan.nextDouble();
        x3 = scan.nextDouble();
        y3 = scan.nextDouble();
        ans = dist(x1, y1, x2, y2);
        ans += dist(x1, y1, x3, y3);
        ans += dist(x2, y2, x3, y3);
        System.out.printf("%.2f", ans);
    }

    private static double sq(double x) {
        return x * x;
    }

    private static double dist(double x1, double y1, double x2, double y2) {
        return Math.sqrt(sq(x1 - x2) + sq(y1 - y2));
    }
}
