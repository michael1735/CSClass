package Algorithms;

import java.util.Arrays;

public class SortingAlgsCollection {

    // insertion sort ����
    // �������˿���һ��
    // worst case: ��(n^2)
    // avg case: ��(n^2)
    static int[] insertionSort(int[] inputArr) {
        //�����������������洢�������ֵ���ͽ�Ҫ������±�
        int insertValue;
        int insertIndex;
        //Ĭ�ϵ�һ����������ģ��ӵڶ�������ʼ�жϣ�ֱ�����һ������
        for (int i = 1; i < inputArr.length; i++) {
            insertValue = inputArr[i];//�������ֵ
            insertIndex = i - 1;//�������λ�ã���һ����Ҫ�����ǰһ��λ�ã�Ȼ����ǰ�ƶ�
            while (insertIndex >= 0 && insertValue < inputArr[insertIndex]) {//���������λ�õ���С�ڴ���������ͽ��������ƣ�
                inputArr[insertIndex + 1] = inputArr[insertIndex];
                insertIndex--;
            }
            //��whileѭ��������˵���Ѿ��ҵ��������ʱ�����봦�������������ϣ����Դ������λ��ӦΪinsertIndex+1;
            //���統����Ϊ-1ʱ���˳�����ֵӦ����0��
            inputArr[insertIndex + 1] = insertValue;
        }
        return inputArr;
    }

    // merge sort �鲢����
    // ʱ�临�ӶȦ�(nlog(2)n)
    private static int[] mergeSort(int[] sourceArray) {
        // ��arr���п���, ���ı��������
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

    // ������
    public static void main(String[] args) {
        System.out.println(Arrays.toString(insertionSort(new int[]{3, 4, 2, 1, 6, 9, 8, 4, 5, 10, 23, 39, -1})));
        System.out.println(Arrays.toString(mergeSort(new int[]{2, 3, 1, 5, 9, 3, 6})));
    }
}
