package Algorithms.SimulationAndBigNumbers;

import java.io.IOException;
import java.util.ArrayList;

public class PingPong {
    // ���P1042
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
    ����˵, Ҫôֱ�Ӷ�ȡ���ֱ���char����, Ҫô�Բ������ͽ���ArrayList, ��Ϊ���ֱ�ӽ�������ᵼ��
    �������������û����ϸ���ж�arrayӦ�ö�������(��ʵ���������Ӧ�ý���char��������, �ô��ֱܷ��ж��������)
     */
}
