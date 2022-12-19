package �㷨;

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

    // ������
    public static void main(String[] args) {
        System.out.println(Arrays.toString(insertionSort(new int[]{3, 4, 2, 1, 6, 9, 8, 4, 5, 10, 23, 39, -1})));
    }
}
