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
            switch����������break�Ļ��ͻ�ֱ��ִ�з�������������Լ����������ֱ��break���ֻ���default
            ����������ǲ����ж�ֵ�Ƿ���϶���ֱ��һ��������ִ��
             */
        }
    }
}
