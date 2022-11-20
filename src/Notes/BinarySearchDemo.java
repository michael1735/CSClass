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

    /**
     * 插值查找, 是在二分查找的基础上, 改变二分查找的区间缩减策略, 根据搜索的值来确定区间缩减幅度, 使其不再是固定的1/2
     */
    public static int interpolationSearch(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;
        // 终止条件
        while (left < right) {
            // 中间位置计算
            int mid = left + ((key - arr[left]) / (arr[right] - arr[left])) * (right - left);

            if (key == arr[mid]) {
                return mid;
            } else if (key < arr[mid]) {
                right = mid - 1; // 从左半部分查找
            } else {
                left = mid + 1; // 从右半部分查找
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {2, 4, 8, 8, 9, 10, 13};
        System.out.println(interpolationSearch(array, 4));
    }
}
