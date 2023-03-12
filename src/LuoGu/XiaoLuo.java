package LuoGu;

import java.util.Scanner;

public class XiaoLuo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char c = scan.nextLine().charAt(0);
        switch (c) {
            case 'G' -> System.out.println("Hello, my master!\nI'm Xiaoluo.");
            case 'N' -> System.out.println("I'm Xiaoluo");
            case 'S' -> System.out.println("Teinei teinei teinei");
            case 'B', 'Q' -> System.out.println("Bye bye!");
            default -> System.out.println("Sorry...");
            /*
            switch语句如果不加break的话就会直接执行符合条件的语句以及其后面的语句直到break出现或者default
            这种情况下是不会判断值是否符合而是直接一股脑往下执行
             */
        }
    }
}
