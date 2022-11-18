package ACSL;

public class MultiplicationTabWithRecursion {

    public static void main(String[] args) {
        printTab(9);
    }

    private static void printTab(int ix) {
        if (ix == 1) {
            System.out.println("1x1=1");
            printTab(ix + 1);
        }

        for (int i = 1; i <= ix; i++) {
            System.out.print(i + "x" + ix + "=" + i*ix + "\t");
        }
        System.out.println();
    }
}
