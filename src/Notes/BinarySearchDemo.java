package Notes;

public class BinarySearchDemo {
    /**
     * 二分搜索要求搜索的数组或区间是排好序的
     * 返回的是key的索引
     */
   public static int binarySearch(int[] arr, int key) {
       int begin = 0;
       int end = arr.length - 1;
       while (begin < end) {
           int mid = (begin + end) / 2;
           if (key == arr[mid]) {
               return mid; // 查找成功
           } else if (key < arr[mid]) {
               end = mid - 1; // 从左半部分查找
           } else {
               begin = mid + 1; // 从右半部分查找
           }
       }
       return -1;
    }

    public static void main(String[] args) {
        int[] array = {2, 4, 8, 8, 9, 10, 13};
        System.out.println(binarySearch(array, 4));
    }
}
