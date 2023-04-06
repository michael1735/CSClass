package LuoGu;

import java.util.Scanner;

record Student (
        StringBuilder name,
        int chinese, int math, int english
) {}
public class RecordType {
    public static void main(String[] args) {
        Student student1;
        Scanner scan = new Scanner(System.in);
        StringBuilder name = new StringBuilder(scan.next());
        int chinese = scan.nextInt(), math = scan.nextInt(), english = scan.nextInt();
        student1 = new Student(name, chinese, math, english);
        System.out.println(student1);
    }
}
