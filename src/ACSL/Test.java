package ACSL;

public class Test {
    public static void main(String[] args) {
        int a = myFunc(100, 36) - myFunc(36, 100);
        System.out.println(a);
    }

    public static int myFunc(int x, int y) {
        if (x * y <= 10) {
            return x * y - x - y;
        } else if (x * y > 10 && x * y < 50) {
            return myFunc(2*x, y-3) + 1;
        } else {
            return myFunc(x/2, y/2) + 2;
        }
    }
}
