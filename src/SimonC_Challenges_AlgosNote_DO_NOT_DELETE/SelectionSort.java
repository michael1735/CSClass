package SimonC_Challenges_AlgosNote_DO_NOT_DELETE;

import java.util.Scanner;

public class SelectionSort {
    static int[] arr = new int[10];
    static int inner = 0, outer = 0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x = 0;
        while(input.hasNextLine()){
            arr[x] = input.nextInt();
            x++;
        }
        printArr("Original");
        selectionSort();
        printArr("\nSorted");
        System.out.println("Outer = " + outer);
        System.out.println("Inner = " + inner);
    }
    public static void printArr(String text){
        System.out.println(text);
        System.out.print("[ ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("]\n");
    }
    public static void selectionSort(){
        // add your code here
        int min, temp, minIndex;
        boolean haveSmaller = false;
        for (int i = 0; i < arr.length - 1; i++) {
            min = arr[i];
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    haveSmaller = true;
                    min = arr[j];
                    minIndex = j;
                }
                inner++;
            }
            System.out.println(min + " is the smallest item");
            if (haveSmaller) {
                temp = arr[i];
                arr[i] = min;
                arr[minIndex] = temp;
            }
            outer++;
        }
    }
}
