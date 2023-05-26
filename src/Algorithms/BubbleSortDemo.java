public class BubbleSortDemo {
    public static int[] bubbleSort(int[] array){
       if(array.length == 0 || array.length == 1){
           return array;
       }
       for (int i = 0; i < array.length - 1; i++){
           for (int j = 0; j < array.length - i - 1; j++){
               if(array[j] < array[j + 1]){
                   int temp = array[j];
                   array[j] = array[j + 1];
                   array[j + 1] = temp;
               }
           }
       }
       return array;
    }

    public static void main(String[] args) {
        int[] myArray = {10, 20, 30, 40};
        bubbleSort(myArray);
        for (int i = 0; i < myArray.length; i++){
            System.out.println(myArray[i]);
        }
    }
}
// unsolved problem of how to reprogramme the toString() method