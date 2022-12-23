package Algorithms;

import java.util.Arrays;

public class SortingAlgsCollection {

    // insertion sort 插排
    // 和排序扑克牌一样
    // worst case: θ(n^2)
    // avg case: θ(n^2)
    static int[] insertionSort(int[] inputArr) {
        //定义两个变量用来存储插入的数值，和将要插入的下标
        int insertValue;
        int insertIndex;
        //默认第一个数是有序的，从第二个数开始判断，直至最后一个数。
        for (int i = 1; i < inputArr.length; i++) {
            insertValue = inputArr[i];//待插入的值
            insertIndex = i - 1;//待插入的位置，第一次是要插入的前一个位置，然后往前移动
            while (insertIndex >= 0 && insertValue < inputArr[insertIndex]) {//如果待插入位置的数小于待插入的数就将此数后移；
                inputArr[insertIndex + 1] = inputArr[insertIndex];
                insertIndex--;
            }
            //当while循环结束，说明已经找到这个数此时待插入处的索引，不符合，所以待插入的位置应为insertIndex+1;
            //比如当索引为-1时，退出，则值应插入0处
            inputArr[insertIndex + 1] = insertValue;
        }
        return inputArr;
    }

    // merge sort 归并排序
    // 时间复杂度θ(nlog(2)n)
    private static int[] mergeSort(int[] sourceArray) {
        // 对arr进行拷贝, 不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        if (arr.length < 2) {
            return arr;
        }

        int middle = arr.length / 2;

        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);

        Arrays.sort(left);
        Arrays.sort(right);

        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0;
        while (left.length > 0 && right.length > 0) {
            if (left[0] <= right[0]) {
                result[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }

        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }

        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }

        return result;
    }

    // 主方法
    public static void main(String[] args) {
        System.out.println(Arrays.toString(insertionSort(new int[]{3, 4, 2, 1, 6, 9, 8, 4, 5, 10, 23, 39, -1})));
        System.out.println(Arrays.toString(mergeSort(new int[]{2, 3, 1, 5, 9, 3, 6})));
    }
}
