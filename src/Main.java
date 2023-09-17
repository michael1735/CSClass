import java.util.*;

public class Main {
    static String[] arr = new String[50];
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        // add your code here
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextLine();
        }
        Arrays.sort(arr);
        String key = sc.nextLine();
        binarySearch(key);
    }

    public static void binarySearch(String key) {
        int start = 0;
        int end = arr.length - 1;
        int mid = (start + end) / 2;
        while (start < end) {
            if (key.equals(arr[mid])) {
                System.out.println(key + " is in element " + mid);
                return;
            } else if (key.compareTo(arr[mid]) < 0) {
                end = mid - 1;
                mid = (start + end) / 2;
            } else if (key.compareTo(arr[mid]) > 0) {
                start = mid + 1;
                mid = (start + end) / 2;
            }
        }
        System.out.println("Unfortunately, " + key + " isn't in the list");
    }
}