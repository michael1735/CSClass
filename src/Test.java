import java.util.Scanner;

public class Test {
    public static long power(int n, int m) {
        // write your code here
        if (m == 0) {
            return 1L;
        }
        long tmp = 1L;
        for (int i = 0; i < m; i++) {
            tmp *= n;
        }
        return tmp;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final int m = scanner.nextInt();
        System.out.println(power(n, m));
    }
}
