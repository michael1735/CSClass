package Notes;

public class BubbleSort {
    public static int[] bs(int[] arr) {

        if (arr.length == 0 || arr.length == 1) {
            System.out.println("ÄãÎªÉ¶ÒªÅÅĞò");
            return arr;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] array = {3, 2, -1, 0};
        System.out.println(bs(array));
    }
}
