public class Main {
    public static void main(String[] args) {
        double temp = 5;
        System.out.println(temp);
        for (int i = 0; i < 10; i++) {
            temp = f(temp);
            System.out.println(temp);
        }
    }

    static double f(double n) {
        double res;
        if (n % 3 == 0) {
            res = 3 * n + 1;
        } else {
            res = 0.5 * n;
        }
        return res;
    }
}