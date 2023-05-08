package Practise;

import java.util.Scanner;

public class P5707 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
        int s = Integer.parseInt(input[0]);
        int v = Integer.parseInt(input[1]);
        int consumption = (int) (Math.ceil((double) s / v) + 10);
        // (double) (s / v)等于先把s / v计算出来然后再把弄出来的整数变double, 那当然是1.0而非需要的1.01010101...
        // (double) s / v可以的原因是先把s强转成double然后double / int结果隐式转换成double
        // 隐式转换顺序: byte -> short -> char -> int -> long -> float -> double
        // char大小2字节
        final int total = (8 + 24) * 60;
        // t为从前一天0点到出发时刻的间隔时间
        int t = total - consumption;

        if (t > 24 * 60) {
            t -= 24 * 60;
            // 如果是当天出发则需要换基准点, 因为t/60算出的h是从基准点到出发时间经过了几个小时
        }
        int h = t / 60;
        int m = t % 60;
        System.out.printf("%02d:%02d", h, m);
    }
}
