package Homework;

import java.util.Scanner;

public class HWTests {
    // 2D arr exercises
    public static void main(String[] args) {
        // 1. ��˾�����۶��ܺ�
        /*
        Scanner input = new Scanner(System.in);
        int result = 0;
        int[][] myArr = new int[4][3];
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 3; j++){
                System.out.print("�����" + (i+1) + "����" + "��" + (j+1) + "���µ����۶�");
                myArr[i][j] = input.nextInt();
            }
        }

        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 3; j++){
                result = result + myArr[i][j];
            }
        }

        System.out.println("��������ܶ�: " + result);
         */
        int[][] arr = new int[10][10];
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j <= i; j++){
                if (j == 0 || j == i){
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                }

                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
