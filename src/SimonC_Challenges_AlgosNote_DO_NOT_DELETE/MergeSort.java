package SimonC_Challenges_AlgosNote_DO_NOT_DELETE;

import java.util.Scanner;

public class MergeSort {
    static int[] numArray = new int[10];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        for(int x = 0; x < 10; x++){
            numArray[x] = input.nextInt();
        }
        printArray("Original", 0, 9);
        mergeSort(0,9);
        printArray("\nSorted", 0, 9);
    }
    public static void printArray(String text, int start, int end){
        System.out.println(text);
        System.out.print("[ ");
        for(int x = start; x <= end; x++){
            System.out.print(numArray[x] + " ");
        }
        System.out.println("] \n");
    }
    public static void mergeSort(int left, int right){
        if (left < right) {
            // find the middle so we can split the array in half
            int middle = (left + right) / 2;
      /* recursive call, allows us to take the left half of the
      array and continue splitting it in half until left is >= right
      i.e. it is a single element */
            mergeSort(left, middle);
            /* now we get the right side of the sub-array */
            mergeSort(middle + 1, right);
            /* once we have both sub-arrays, it's time to merge them*/
            merge(left, middle, right);
        }
    }
    public static void merge(int left, int middle, int right){
        int leftLength = middle - left + 1;
        int rightLength = right - middle;
        /* let's print the two sub-arrays so we can visualize what is going on */
        printArray("left",left,middle);
        printArray("right",middle+1,right);

        /* Create temp arrays */
        int L[] = new int[leftLength];
        int R[] = new int[rightLength];

        /* write code to copy data to temp arrays below */
        for (int i = 0; i < leftLength; i++) {
            L[i] = numArray[left + i];
        }

        for (int i = 0; i < rightLength; i++) {
            R[i] = numArray[middle + 1 + i];
        }
        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int leftIndex = 0, rightIndex = 0;
        // Initial index of merged subarry array
        int origIndex = left;

        while (leftIndex < leftLength && rightIndex < rightLength) {

      /* inside this loop, we need to compare the items in the L array
      with the items in the R array. If the L item is smaller, add it to
      numArray. If the R item is smaller, add it to numArray. Update the index
      variables as appropriate*/

            if (L[leftIndex] <= R[rightIndex]) {
                numArray[origIndex] = L[leftIndex];
                leftIndex++;
            } else {
                numArray[origIndex] = R[rightIndex];
                rightIndex++;
            }
            System.out.print(numArray[origIndex] + " ");
            origIndex++;
        }


        /* Copy remaining elements of L[] if any */
        while (leftIndex < leftLength) {
            // add code in here
            numArray[origIndex] = L[leftIndex];
            leftIndex++;
            System.out.print(numArray[origIndex] + " ");
            origIndex++;
        }

        /* Copy remaining elements of R[] if any */
        while (rightIndex < rightLength) {
            // add code in here
            numArray[origIndex] = R[rightIndex];
            rightIndex++;
            System.out.print(numArray[origIndex] + " ");
            origIndex++;
        }
        System.out.println("\n");
    }
}
