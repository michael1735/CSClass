import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String url = scanner.nextLine();
        String[] split = url.split("\\?");
        String needed = split[1];
        String pw = null;
        for (String s : needed.split("&")) {
            String[] arr = s.split("=");
            if (arr.length == 2) {
                System.out.println(arr[0] + " " + ": " + arr[1]);
            } else if (arr.length == 1) {
                System.out.println(arr[0] + " " + ": " + "not found");
            }

            if ("pass".equals(arr[0])) {
                pw = arr[1];
            }
        }
        if (pw != null) {
            System.out.println("password : " + pw);
        }
    }
}
