package ACSL;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * ������������һ����(61-65)ֻд���ҳ������ַ���, ��û��ʵ�ֽ�ȡ�������ַ���
 * ���Ի���Ҫ��compareTo(sameLongestSubStr[i])==0)(�����ַ���һ��, ���Խ�ȡ�����¸�ֵ�ַ���->�ݹ����)
 * compareTo(sameLongestSubStr[i] < 0)(minString < ��һ���ַ���, minString���ַ����к���һ����������ĸ��С, ���Խ�ȡ+�ݹ�)
 */
public class LongestSubStr {
    static int ADF = 0;
    public static int getMaxSameString(String str1, String str2) {
        if (str1.equals("") || str2.equals("")) {
            return 0;
        }
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
                        coordinates.add(new Integer[]{i, j}); // ij����
                    }
                }
            }
        }
        for (Integer[] coordinate : coordinates) {
            System.out.println(Arrays.toString(coordinate));
        }
        // test line
//        System.out.println(max);
//        for (Integer[] coordinate : coordinates) {
//            System.out.println(Arrays.toString(coordinate));
//        }
        // ��ʼ��һ������, ��������һ���ڽӾ����ҳ�����ͬ���Ȳ�ͬ���ݵ��ַ���
        String[] sameLongestSubStr = new String[coordinates.size()];
        ArrayList<Integer[]> index = new ArrayList<>();
        // coordinates ��¼������ͬ�ִ����һ���ַ��������ַ����е�λ��
        for (int i = 0; i < coordinates.size(); i++) {
            // ��ȡ
            sameLongestSubStr[i] = str1.substring(coordinates.get(i)[0] - max + 1, coordinates.get(i)[0] + 1);
//            System.out.printf("%d %d%n", coordinates.get(i)[0] - max + 1, coordinates.get(i)[0] + 1);
//            System.out.println(sameLongestSubStr[i]);
           index.add(new Integer[]{coordinates.get(i)[0] + 1, coordinates.get(i)[1] + 1});
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

        String leftOfLongSub1 = str1.substring(0, index.get(minPos)[0] - max);
        String rightOfLongSub1 = str1.substring(index.get(minPos)[0]);
        String leftOfLongSub2 = str2.substring(0, index.get(minPos)[1] - max);
        String rightOfLongSub2 = str2.substring(index.get(minPos)[1]);
        return minString.length() + getMaxSameString(leftOfLongSub1, leftOfLongSub2) + getMaxSameString(rightOfLongSub1, rightOfLongSub2);
    }

    public static void main(String[] args) {
        String str1="asdasdashello1dnjhfkjsabcdefeldfghij";
        String str2="sdormcohello1aspabcdefasdfghij";
//        System.out.println(str1.substring(13, 28));
//        System.out.println(str2.substring(12, 22));
        int adf = getMaxSameString(str1, str2);
        System.out.println(adf);
    }
}

class Clc {

}
