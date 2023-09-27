package A2CS;

public class RecursionDemo {
    static int sum(int i) {
        if (i == 1) {
            return 1;
        }

        return  i + sum(i - 1);
    }

    static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    static int fact_nonRec(int n) {
        int res = 1;
        for (int i = n; i >= 1; i--) {
            res *= i;
        }
        return res;
    }

    static int fib(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fib(n - 2) + fib(n - 1);
        }
    }
    public static void main(String[] args) {
        System.out.println("Sum of numbers up to 10 is: " + sum(20));
        System.out.println("The factorial of 3 is: " + factorial(3));
        System.out.println("The factorial of 3 is(non-recursive): " + fact_nonRec(3));
        System.out.println("The 3rd term in fibonacci sequence is: " + fib(3));
    }
}
