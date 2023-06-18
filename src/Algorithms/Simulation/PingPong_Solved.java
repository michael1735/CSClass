package Algorithms.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PingPong_Solved {
    //存放用来判别的字符串
    static char[] race = new char[100000];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        char c;
        int i = 0;
        while ((c = (char) bufferedReader.read()) != 'E') {
            race[i++] = c;
        }
        //进行11赛制的比赛
        process(11);
        System.out.println();
        //进行21赛制的比赛
        process(21);
    }

    /**
     * 进行比赛
     *
     * @param win 赛制
     */
    public static void process(int win) {
        //记录分数
        int l = 0, w = 0;
        //进行比赛
        for (int i = 0; i < race.length; i++) {
            //注意，也许有换行符
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
        //输出正在进行的比赛
        System.out.printf("%d:%d\n", w, l);
    }
}
