import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        String s = "";
        int num = 1;
        char last = ' ';
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            s = reader.readLine();
            for (char c : s.toCharArray()) {
                if (c == ' ' && c != last) {
                    last = c;
                    num++;
                    continue;
                }
                last = c;
            }
        } catch (IOException e) {
            System.err.println("IO Exception occurred!" + e.getMessage());
        }

        if (s.isEmpty()) {
            System.out.println(0);
            return;
        }
        System.out.println(num);
    }
}
