package Notes;

import java.util.Scanner;

public class Note1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        double b = s.nextDouble();
        String c = s.next();
        String d = s.nextLine();
        // nextLine() 会接受上面传入的
        System.out.println("----------------------------------------------------");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }
}

