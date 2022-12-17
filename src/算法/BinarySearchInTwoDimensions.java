package �㷨;

public class BinarySearchInTwoDimensions {
    /**
     * ��ά����Ķ�������Ҳ����Ҫÿһ�е���, ÿһ�е���(��������). �����ѡ������½ǿ�ʼҲ���Դ����Ͻǿ�ʼ
     */
    public static boolean binarySearch4TwoDimArr(int[][] arr, int target) {
        // ����ѡ������Ͻǿ�ʼ����
        // �������Ϊ��, ����false
        if (arr.length == 0 || arr[0].length == 0) {
            return false;
        }

        // ���target����С�Ļ�С(���Ͻ�Ԫ��), ������Ļ���(���½�Ԫ��), ����false
        if (target < arr[0][0] || target > arr[arr.length - 1][arr[0].length - 1]) {
            return false;
        }

        // ���ַ�����, �����½ǻ����Ͻ�Ϊ�ֽ��, ���������Ͻ�Ϊ�ֽ��, ��Ϊval
        // ���val == target, ֱ�ӷ���true
        // ���val < target, ��ô��һ�������е����ݶ�С��val, ��Ȼ��һ�������е���Ҳ��С��target, ��һ���ų�,
        // val���Ƶ��ڶ��е����һ��Ԫ��
        // ���val > target�� ��ô���һ�������е������Ǵ���val��. ��Ȼ���һ�������е���Ҳ�ʹ���target, ���һ���ų�
        // valǰ�Ƶ���һ�еĵ����ڶ���Ԫ��
        // �ظ���������

        // ������Ͻǵ��кź��к�
        int row = 0;
        int col = arr[0].length - 1;

        // ��Ϊ���ÿ�ʼ��λ��Ϊ���Ͻ�, �������½�����, ������ֹ����Ӧ��Ϊ���������½�
        // ���½��к�Ϊ0, �к�Ϊarr.length - 1
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
