package Practise;

import java.util.Scanner;

public class P5707 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
        int s = Integer.parseInt(input[0]);
        int v = Integer.parseInt(input[1]);
        int consumption = (int) (Math.ceil((double) s / v) + 10);
        // (double) (s / v)�����Ȱ�s / v�������Ȼ���ٰ�Ū������������double, �ǵ�Ȼ��1.0������Ҫ��1.01010101...
        // (double) s / v���Ե�ԭ�����Ȱ�sǿת��doubleȻ��double / int�����ʽת����double
        // ��ʽת��˳��: byte -> short -> char -> int -> long -> float -> double
        // char��С2�ֽ�
        final int total = (8 + 24) * 60;
        // tΪ��ǰһ��0�㵽����ʱ�̵ļ��ʱ��
        int t = total - consumption;

        if (t > 24 * 60) {
            t -= 24 * 60;
            // ����ǵ����������Ҫ����׼��, ��Ϊt/60�����h�Ǵӻ�׼�㵽����ʱ�侭���˼���Сʱ
        }
        int h = t / 60;
        int m = t % 60;
        System.out.printf("%02d:%02d", h, m);
    }
}
