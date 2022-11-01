package Homework;

public class MultiplicationTable {
    public static void main(String[] args) {
        int[][] myArray = new int[9][];

        for (int i = 1; i <= 9; i++) {
            myArray[i - 1] = new int[i];
            for (int j = 1; j <= myArray[i - 1].length; j++) {
                myArray[i - 1][j - 1] = j * i;
                System.out.print(i + "x" + j + "=" + myArray[i - 1][j - 1] + "\t");
            }
            System.out.println();
        }
    }
}
