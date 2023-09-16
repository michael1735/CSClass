package SimonC_Challenges;

import java.util.Scanner;

public class InsertionSort {
    static int[] numArray = new int[10];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        for(int x = 0; x < 10; x++){
            numArray[x] = input.nextInt();
        }
        printArray("Original");
        insertionSort();
        printArray("\nSorted");
    }
    public static void printArray(String text){
        System.out.println(text);
        System.out.print("[ ");
        for(int x = 0; x < 10; x++){
            System.out.print(numArray[x] + " ");
        }
        System.out.println("] \n");
    }

    static int insertValue, insertPlace;
    public static void insertionSort(){
        // add your code here
        for (int i = 1; i < numArray.length; i++) {
            insertValue = numArray[i];
            insertPlace = i - 1;
            System.out.println("Item to insert = " + insertValue);

            while (insertPlace >= 0 && insertValue < numArray[insertPlace]) {
                numArray[insertPlace+1] = numArray[insertPlace];
                insertPlace -= 1;
                System.out.println("Smaller than " + numArray[insertPlace+1]);
            }
            if (insertPlace > -1)
                System.out.println("Bigger than " + numArray[insertPlace]);
            else if (insertPlace == -1)
                System.out.println("Smallest item");
            numArray[insertPlace+1] = insertValue;
        }
    }
}
