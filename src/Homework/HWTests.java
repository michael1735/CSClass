package Homework;

import java.util.Scanner;

public class HWTests {
    // 2D arr exercises
    public static void main(String[] args) {
        // 1. 公司年销售额总和
        Scanner input = new Scanner(System.in);
        int result = 0;
        int[][] myArr = new int[4][3];
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 3; j++){
                System.out.print("输入第" + (i+1) + "季度" + "第" + (j+1) + "个月的销售额");
                myArr[i][j] = input.nextInt();
            }
        }

        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 3; j++){
                result = result + myArr[i][j];
            }
        }

        System.out.println("年度销售总额: " + result);
    }
}
