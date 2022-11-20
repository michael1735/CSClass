package Notes;

public class BinarySearchDemo {
    /**
     * ��������Ҫ��������������������ź����
     * ���ص���key������
     */
   public static int binarySearch(int[] arr, int key) {
       int begin = 0;
       int end = arr.length - 1;
       while (begin < end) {
           int mid = (begin + end) / 2;
           if (key == arr[mid]) {
               return mid; // ���ҳɹ�
           } else if (key < arr[mid]) {
               end = mid - 1; // ����벿�ֲ���
           } else {
               begin = mid + 1; // ���Ұ벿�ֲ���
           }
       }
       return -1;
    }

    /**
     * ��ֵ����, ���ڶ��ֲ��ҵĻ�����, �ı���ֲ��ҵ�������������, ����������ֵ��ȷ��������������, ʹ�䲻���ǹ̶���1/2
     */
    public static int interpolationSearch(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;
        // ��ֹ����
        while (left < right) {
            // �м�λ�ü���
            int mid = left + ((key - arr[left]) / (arr[right] - arr[left])) * (right - left);

            if (key == arr[mid]) {
                return mid;
            } else if (key < arr[mid]) {
                right = mid - 1; // ����벿�ֲ���
            } else {
                left = mid + 1; // ���Ұ벿�ֲ���
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {2, 4, 8, 8, 9, 10, 13};
        System.out.println(interpolationSearch(array, 4));
    }
}
