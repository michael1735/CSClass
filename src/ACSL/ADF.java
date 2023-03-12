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
        // ���ڽӾ����i=0, j=0 ���к��и�ֵΪ1
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
        // ���ڽӾ���ֵ
        for (int i = 1; i < str1.length(); i++) {
            for (int j = 1; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) { // ���str1��str2��һ����ͬ���ַ�
                    indexOfStrings[i][j] = indexOfStrings[i - 1][j - 1] + 1; // �ڽӾ����[i, j]λ�ø�ֵΪ���Ϸ����ӵ�ֵ+1
                    // ��max��ֵ, �����ҵ��ڽӾ�������ֵ, ���ұ����ʱ��β����ĸ����, �Ա���str1��str2�н�ȡ��ͬ�ִ�
                    if (max < indexOfStrings[i][j]) { // ���maxС���ڽӾ���[i, j]λ�õ�ֵ, �����max
                        max = indexOfStrings[i][j];
                        // ÿ����һ��max�ͱ������µĸ�������ͬ�ִ������������ַ�����, ��Ҫ��������������arraylist
                        coordinates.clear();
                        // �����µ�����
                        coordinates.add(new Integer[]{i, j});
                    } else if (max == indexOfStrings[i][j]) { // ��������ͬ���ȵ��ִ������
                        // �����µĲ�ͬ������ͬ���ȵ��ִ�β����ĸ����
                        coordinates.add(new Integer[]{i, j});
                    }
                }
            }
        }
        // ��ʼ��һ������, ��������һ���ڽӾ����ҳ�����ͬ���Ȳ�ͬ���ݵ��ַ���
        String[] sameLongestSubStr = new String[coordinates.size()];
        ArrayList<Integer[]> place = new ArrayList<>();
        for (int i = 0; i < coordinates.size(); i++) {
            // ��ȡ
            sameLongestSubStr[i] = str1.substring(coordinates.get(i)[0] - max + 1, coordinates.get(i)[0] + 1);
            place.add(new Integer[]{coordinates.get(i)[0] - max + 1, coordinates.get(i)[0] + 1});
        }
        // �Ұ�����ĸ�����ǰ���Ǹ��ִ�
        // minString������compareTo(String anotherString)�������ص�ĳ����ĸascii���С(i.e.alphabetically first)���ִ�
        String minString = sameLongestSubStr[0];
        int minPos = coordinates.get(0)[0] - max + 1; // in str1
        // �Ƚ�minString�ʹ洢��sameLongestSubStr��ĵ�[i]���ַ���(������Ϊ�Ѿ���ֵminStringΪ0�˾Ͳ��˷�0����һ��ѭ����)
        // ���minString����sameLongestSubStr�ĵ�[i]����ֱ�Ӱ�minString����Ϊ��С���Ǹ�(��ĸ˳��)
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
