package Homework;

import java.util.Scanner;

public class SCLightenImage {
    static int[][] picture = {{200,78,143,90},{1,123,204,87},{199,3,178,99},{99,200,175,201}};


    /*
        add the function, Lighten, here.
        loop through all 'pixels' and increase their value by 10%.
        if the value of any pixels >= 255 then return TRUE and set the value to be 255
    */
    public static boolean Lighten(int n) {
        boolean burnt = false;
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    // picture[j][k] = (int) ceil((double)picture[j][k] * 1.1);
                    // ��Ϊ�������͵����(90.0 * 1.1 = 99.00001), �����޷���ȷ��ת��, �����Ҫ������ֱ��Ū
                    // int����double/float�ǿ���ֱ�Ӽ����, ������Ľ����ֱ����������
                    // *1.1����ԭ���ݼ�ԭ����*0.1,
                    picture[j][k] += (picture[j][k] * 0.1) + 0.9;
                    if (picture[j][k] >= 255) {
                        burnt = true;
                        picture[j][k] = 255;
                    }
                }
            }
        }
        return burnt;
    }

    public static void main(String[] args) {
        /*
        	take in an integer, n, as the amount of loops that needs to be run.
            each loop should call the function Lighten.
            if the image becomes 'burnt out' then exit the loop.
            after the loop, display the values of the image row by row
        */
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        boolean burntOut;
        burntOut = Lighten(n);
        if (burntOut) {
            System.out.println("The image has been burnt out" + "\n");
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    System.out.print(picture[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    System.out.print(picture[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
