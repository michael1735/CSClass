package Algorithms.Simulation;

import java.util.Scanner;

public class AplusBProblem {
    // A+B Problem 高精
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(scanner.nextBigInteger().add(scanner.nextBigInteger()));

        /*
        用java的话就不用自己手搓数组实现的高精算法啦
        直接用自带的big系列高精实现就行
         */
    }
}
