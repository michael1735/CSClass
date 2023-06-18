package Algorithms.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PingPong_Solved {
    //��������б���ַ���
    static char[] race = new char[100000];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        char c;
        int i = 0;
        while ((c = (char) bufferedReader.read()) != 'E') {
            race[i++] = c;
        }
        //����11���Ƶı���
        process(11);
        System.out.println();
        //����21���Ƶı���
        process(21);
    }

    /**
     * ���б���
     *
     * @param win ����
     */
    public static void process(int win) {
        //��¼����
        int l = 0, w = 0;
        //���б���
        for (int i = 0; i < race.length; i++) {
            //ע�⣬Ҳ���л��з�
            if (race[i] == 'L') {
                l++;
            } else if (race[i] == 'W') {
                w++;
            }
            if ((l >= win && l - w >= 2) || (w >= win && w - l >= 2)) {
                System.out.printf("%d:%d\n", w, l);
                l = 0;
                w = 0;
            }
        }
        //������ڽ��еı���
        System.out.printf("%d:%d\n", w, l);
    }
}
