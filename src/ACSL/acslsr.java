package ACSL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class acslsr {
    static Scanner scanner = new Scanner(System.in);
    static int n = scanner.nextInt();
    static char[][] table = new char[n][n];

    public static void main(String[] args) {
        ArrayList<String> targets = new ArrayList<>();
        String tmp = "";
        while (true) {
            tmp = scanner.next();
            if (tmp.length() < 4)
                targets.add(tmp);
            else
                break;
        }
        processTarget(targets);
        String lineArrows = tmp;
        String colArrows = scanner.next();
        String temp = scanner.nextLine();
        temp = scanner.nextLine(); // 接受换行符
        String[] tmpArray = temp.split(" ");
        ArrayList<String> arrows = new ArrayList<>(Arrays.asList(tmpArray));

        processArrows(arrows);

        for (char[] arr : table) { // 展示矩阵
            for (char c : arr) {
                System.out.print(c + ", ");
            }
            System.out.println();
        }
    }

    static void processTarget(ArrayList<String> target) {
        for (String s : target) {
            table[s.charAt(0) - '0'][s.charAt(1) - '0'] = 't';
        }
    }

    static void processArrows(ArrayList<String> arrows) {
        for (String s : arrows) {
            table[s.charAt(0) - '0'][s.charAt(1) - '0'] = s.charAt(2);
        }
    }

    static String findErrCoor(ArrayList<String> arrows, String lineArrows, String colArrows) {
        String ans = "";
        String[] lnArrowArr = lineArrows.split("");
        ArrayList<String> lnArrow = new ArrayList<>(Arrays.asList(lnArrowArr));
        String[] colArrowArr = colArrows.split("");
        ArrayList<String> colArrow = new ArrayList<>(Arrays.asList(colArrowArr));
        for (int i = 0; i < n; i++) {
            int arrowLn = lnArrow.get(i).charAt(0) - '0';
            if (arrowLn != 0) { // 如果在标记为lnArrow.get(i).charAt(0) - '0'的行有箭头则去箭头的表格里查找
                int cnt = 0;
                while (cnt < arrows.size()) {
                    if (arrows.get(cnt).charAt(0) - '0' == i) {
                        cnt++;
                    }
                }
                if (cnt != arrowLn) {
                    ans = ans.concat(String.valueOf(cnt));
                }
            }

            int arrowCol = colArrow.get(i).charAt(0) - '0';
            if (arrowCol != 0) {
                int cnt = 0;
                while (cnt < arrows.size()) {
                    if (arrows.get(cnt).charAt(0) - '0' == i) {
                        cnt++;
                    }
                }
                if (cnt != arrowCol) {
                    ans = ans.concat(String.valueOf(cnt));
                }
            }
        }
        return ans;
    }
}
