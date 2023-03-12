package ACSL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ADF {
    // ACSL difference factor
    static Scanner scan = new Scanner(System.in);
    static ArrayList<String> longestCommonSubStr = new ArrayList<>();
    public static void main(String[] args) {
        String[] in1 = {"I am going home now", "I will go home now"};
        String[] in2 = {"The big black bear bit a big black bug", "The big black bug bled black blood"};
        String[] in3 = {"Complementary angle measures sum to 90 degrees.", "The measures of supplementary angles add to 180 degrees."};
        String[] in4 = {"A Tale of Two Cities was published by Dickens in 1859.", "In 1839, Charles Dickens published Nicholas Nickleby."};
        String[] in5 = {"Connecticut is The Constitution State.", "Hartford is the capital of Connecticut."};

        System.out.println(diffFactor(in1[0], in1[1]));
        System.out.println(diffFactor(in2[0], in2[1]));
        System.out.println(diffFactor(in3[0], in3[1]));
        System.out.println(diffFactor(in4[0], in4[1]));
        System.out.println(diffFactor(in5[0], in5[1]));
    }

    public static String getMaxSameString(String str1, String str2) {
        int[][] indexOfStrings = new int[str1.length()][str2.length()];
        int max = 0;
        ArrayList<Integer[]> coordinates = new ArrayList<>();
        // 将邻接矩阵的i=0, j=0 的列和行赋值为1
        for (int j = 0; j < str2.length(); j++) {
            if (str1.charAt(0) == str2.charAt(j)) {
                indexOfStrings[0][j] = 1;
            }
        }
        for (int i = 0; i < str1.length(); i++) {
            if (str2.charAt(0) == str1.charAt(i)) {
                indexOfStrings[i][0] = 1;
            }
        }
        // 给邻接矩阵赋值
        for (int i = 1; i < str1.length(); i++) {
            for (int j = 1; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) { // 如果str1和str2有一个相同的字符
                    indexOfStrings[i][j] = indexOfStrings[i - 1][j - 1] + 1; // 邻接矩阵的[i, j]位置赋值为左上方格子的值+1
                    // 给max赋值, 用以找到邻接矩阵最大的值, 并且保存此时的尾部字母坐标, 以便在str1和str2中截取相同字串
                    if (max < indexOfStrings[i][j]) { // 如果max小于邻接矩阵[i, j]位置的值, 则更新max
                        max = indexOfStrings[i][j];
                        // 每更新一次max就表明有新的更长的相同字串存在于两个字符串中, 需要清空用来存坐标的arraylist
                        coordinates.clear();
                        // 加入新的坐标
                        coordinates.add(new Integer[]{i, j});
                    } else if (max == indexOfStrings[i][j]) { // 有两个相同长度的字串的情况
                        // 加入新的不同内容相同长度的字串尾部字母坐标
                        coordinates.add(new Integer[]{i, j});
                    }
                }
            }
        }
        // 初始化一个数组, 用来存上一步邻接矩阵找出的相同长度不同内容的字符串
        String[] sameLongestSubStr = new String[coordinates.size()];
        ArrayList<Integer[]> place = new ArrayList<>();
        for (int i = 0; i < coordinates.size(); i++) {
            // 截取
            sameLongestSubStr[i] = str1.substring(coordinates.get(i)[0] - max + 1, coordinates.get(i)[0] + 1);
            place.add(new Integer[]{coordinates.get(i)[0] - max + 1, coordinates.get(i)[0] + 1});
        }
        // 找按照字母排序更前的那个字串
        // minString用来存compareTo(String anotherString)方法返回的某个字母ascii码更小(i.e.alphabetically first)的字串
        String minString = sameLongestSubStr[0];
        int minPos = coordinates.get(0)[0] - max + 1; // in str1
        // 比较minString和存储于sameLongestSubStr里的第[i]个字符串(这里因为已经赋值minString为0了就不浪费0的那一次循环了)
        // 如果minString大于sameLongestSubStr的第[i]个就直接把minString更新为更小的那个(字母顺序)
        for (int i = 1; i < coordinates.size(); i++) {
            if (minString.compareTo(sameLongestSubStr[i]) > 0) {
                minString = sameLongestSubStr[i];
                minPos = i;
            }
        }
        longestCommonSubStr.add(minString);
//        String leftPartIn1 = str1.substring();
        return minString;
    }

    public static int diffFactor(String str1, String str2) {
        String string1 = "";
        String string2 = "";
        int factor = 0;
        for (char c : str1.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                string1 = string1.concat(String.valueOf(c));
            } else if (Character.isDigit(c)) {
                string1 = string1.concat(String.valueOf(c));
            }
        }

        for (char c : str2.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                string2 = string2.concat(String.valueOf(c));
            } else if (Character.isDigit(c)) {
                string2 = string2.concat(String.valueOf(c));
            }
        }
        string1 = string1.toUpperCase();
        string2 = string2.toUpperCase();

        longestCommonSubStr.add(getMaxSameString(string1, string2));
        return factor;
    }
}
