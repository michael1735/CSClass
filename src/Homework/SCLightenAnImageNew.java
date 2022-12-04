package Homework;

import java.util.Scanner;

public class SCLightenAnImageNew {
    static int[][] picture = {{200,78,143,90},{1,123,204,87},{199,3,178,99},{99,200,175,201}};

    public static int[][] Lighten(int[][] pictures){
        for (int i=0;i<4;i++){
            for (int j=0;j<4;j++){
                // 这两行代码完美规避了float表示无法精确导致取整系列函数返回错误的问题
                int a = pictures[i][j]/10 + (pictures[i][j] % 10!=0 ? 1:0);
                pictures[i][j] = pictures[i][j] + a;
            }
        }
        return pictures;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        for (int j = 0;j<num;j++){
            picture = Lighten(picture);
            if (picture[0][0] >= 255){
                System.out.println("The image has been burnt out");
                System.out.println("");
                break;
            }

        }

        for (int i=0;i<4;i++){
            System.out.println((Math.min(picture[i][0], 255)) + " " + (Math.min(picture[i][1], 255)) + " "
                    + (Math.min(picture[i][2], 255)) + " " + (Math.min(picture[i][3], 255)) + " ");
        }
    }
}
