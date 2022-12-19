package 算法;

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

    // 主方法
    public static void main(String[] args) {
        System.out.println(Arrays.toString(insertionSort(new int[]{3, 4, 2, 1, 6, 9, 8, 4, 5, 10, 23, 39, -1})));
    }
}
