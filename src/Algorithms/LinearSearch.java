package Algorithms;

import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a value to search: ");
        int searchValue = input.nextInt();
        int[] myList = {2, 3, 4, 45, 34, 556};
        int size = myList.length;
        boolean found = false;
        int i = 0;

        while (i < size && !found) {
            if (myList[i] == searchValue) {
                found = true;
            } else {
                i++;
            }
        }

        if (found) {
            System.out.println("Value found at index " + i);
        } else {
            System.out.println("Value not found");
        }
    }
}
