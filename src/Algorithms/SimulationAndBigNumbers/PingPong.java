package Algorithms.SimulationAndBigNumbers;

import java.io.IOException;
import java.util.ArrayList;

public class PingPong {
    // 洛谷P1042
    static ArrayList<Boolean> winOrLose = new ArrayList<>();

    public static void main(String[] args) {
        String tmp = "";
        do {
            try {
                tmp = Character.toString(System.in.read());
//                System.out.print(tmp);
            } catch (IOException e) {
                System.out.println("IO error!");
            }
            if (tmp.equals("W")) {
                winOrLose.add(true);
            } else if (tmp.equals("L")) {
                winOrLose.add(false);
            }
        } while (!(tmp.equals("E")));

        process(11);
        System.out.println();
        process(21);
    }

    public static void process(int win) {
        int w = 0, l = 0;
        for (Boolean aBoolean : winOrLose) {
            if (aBoolean) {
                w++;
            } else {
                l++;
            }

            if ((l >= win && l - w >= 2) || (w >= win && w - l >= 2)) {
                System.out.printf("%d:%d%n", w, l);
                l = 0;
                w = 0;
            }
        }
        System.out.printf("%d:%d\n", w, l);
    }

    /*
    所以说, 要么直接读取并分别处理char数据, 要么对布尔类型建立ArrayList, 因为如果直接建立数组会导致
    布尔数组过长而没法精细的判断array应该读到哪里(其实这种情况就应该建立char类型数组, 好歹能分别判断三种情况)
     */
}
