package LuoGu;

import java.util.Scanner;

public class B2005 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String repeated1 = new String(new char[3]).replace("\0", str); // before java10, \0指的是一个空白(空值)
        String repeated2 = new String(new char[5]).replace("\0", str);// before java10
        System.out.println("  " + str + "  ");
        System.out.println(" " + str.repeat(3) + " ");
        System.out.println(str.repeat(5));
        System.out.println(repeated2);
        System.out.println(" " + repeated1 + " ");
    }
}
