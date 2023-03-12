package ACSL;

public class RecursionPractise {
    static int[] arr = new int[100];

    public static int betterNthFib(int n) {
        if (n <= 1) {
            return 1;
        } else {
            if (arr[n] == 0) {
                arr[n] = betterNthFib(n - 1) + betterNthFib(n - 2);
                return arr[n];
            } else {
                return arr[n];
            }
        }
    }

    public static int goUp(int N) {
        if (N == 1) {
            return 1;
        } else if (N == 2) {
            return 2;
        } else {
                return goUp(N - 1) + goUp(N - 2);
        }
    }
    public static void main(String[] args) {
        System.out.println(betterNthFib(6));
        int i = goUp(4);
        System.out.println(i);
    }
}
