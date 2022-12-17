package 算法;

public class BinarySearchInTwoDimensions {
    /**
     * 二维数组的二分搜索也是需要每一行递增, 每一列递增(有序数组). 你可以选择从左下角开始也可以从右上角开始
     */
    public static boolean binarySearch4TwoDimArr(int[][] arr, int target) {
        // 这里选择从右上角开始遍历
        // 如果数组为空, 返回false
        if (arr.length == 0 || arr[0].length == 0) {
            return false;
        }

        // 如果target比最小的还小(左上角元素), 或比最大的还大(右下角元素), 返回false
        if (target < arr[0][0] || target > arr[arr.length - 1][arr[0].length - 1]) {
            return false;
        }

        // 二分法查找, 以左下角或右上角为分界点, 假设以右上角为分界点, 记为val
        // 如果val == target, 直接返回true
        // 如果val < target, 那么第一行中所有的数据都小于val, 自然第一行中所有的数也就小于target, 第一行排除,
        // val下移到第二行的最后一个元素
        // 如果val > target， 那么最后一列中所有的数都是大于val的. 自然最后一列中所有的数也就大于target, 最后一列排除
        // val前移到第一行的倒数第二个元素
        // 重复上述步骤

        // 标记右上角的行号和列号
        int row = 0;
        int col = arr[0].length - 1;

        // 因为设置开始的位置为右上角, 逐渐向左下角收缩, 所以终止条件应该为收缩到左下角
        // 左下角列号为0, 行号为arr.length - 1
        while (col >= 0 && row <= arr.length - 1) {
            if (arr[row][col] == target) {
                return true;
            } else if (target > arr[row][col]) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] twoDimArr = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        boolean i = binarySearch4TwoDimArr(twoDimArr, 12);
        if (i) {
            System.out.println("found");
        } else {
            System.out.println("Not found in arr");
        }
    }
}
