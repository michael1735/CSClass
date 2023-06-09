package Algorithms.Simulation;

import java.io.IOException;

public class PingPong {
    // Âå¹ÈP1042
    static boolean[] winOrLose = new boolean[25 * 2500];
    static int huaHua, friend;

    static int[] scores = {11, 21};

    public static void main(String[] args) {
        String tmp = "";
        int count = 0;
        do {
            try {
                tmp = Character.toString(System.in.read());
            } catch (IOException e) {
                System.out.println("IO error!");
            }
            if (tmp.equals("W")) {
                winOrLose[count++] = true;
            } else if (tmp.equals("L")){
                winOrLose[count++] = false;
            }
        } while (!(tmp.equals("E")));
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < count; j++) {
                if (winOrLose[j]) {
                    huaHua++;
                } else {
                    friend++;
                }

                if (Math.max(huaHua, friend) == scores[i] || Math.abs(huaHua - friend) >= 2) {
                    System.out.printf("%d : %d\n", huaHua, friend);
                    huaHua = 0;
                    friend = 0;
                } else {
                    System.out.printf("%d : %d\n", huaHua, friend);
                }
            }
        }
    }
}
