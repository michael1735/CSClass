package Algorithms.SimulationAndBigNumbers.BigNums;

import java.math.BigInteger;

public class BigCalcMain {

    public static void main(String[] args) {
//        BigNumberCalculator calculator = new BigNumberCalculator();
//        Scanner scanner = new Scanner(System.in);
//        int[] a = new int[1004];
//        a = calculator.read(a);
//        int b = scanner.nextInt();
//        int[] res = new int[1004];
//        calculator.divShort(a, b, res);
//        calculator.print(res);
        BigInteger a = new BigInteger("4321");
        BigInteger b = new BigInteger("21");
        System.out.println(a.divide(b));
    }
}
