package ACSL;

import java.util.Scanner;

public class Factorial {
    /**Main method*/
    public static void main(String[] args) {
        // Create a scanner
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a non-negative number");
        int n = input.nextInt();

        // Display factorial
        System.out.println("Factorial of " + n + " is " + factorial(n));
    }

    /**Return the factorial for the specified number*/
    public static long factorial(int n) {
/*
  if the base case is not specified or the base case is not converged to by the recursion, an infinite recursion
  occur. That will cause a StackOverflowError
 */
        if (n == 0) { // Base case
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
