package ACSL;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 这个方法的最后一部分(61-65)只写了找出最大的字符串, 而没有实现截取掉最大的字符串
 * 所以还需要加compareTo(sameLongestSubStr[i])==0)(两个字符串一样, 所以截取并重新赋值字符串->递归调用)
 * compareTo(sameLongestSubStr[i] < 0)(minString < 另一个字符串, minString的字符序列和另一个比起来字母更小, 所以截取+递归)
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
                        coordinates.add(new Integer[]{i, j}); // ij坐标
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
        // 初始化一个数组, 用来存上一步邻接矩阵找出的相同长度不同内容的字符串
        String[] sameLongestSubStr = new String[coordinates.size()];
        ArrayList<Integer[]> index = new ArrayList<>();
        // coordinates 记录的是相同字串最后一个字符在两个字符串中的位置
        for (int i = 0; i < coordinates.size(); i++) {
            // 截取
            sameLongestSubStr[i] = str1.substring(coordinates.get(i)[0] - max + 1, coordinates.get(i)[0] + 1);
//            System.out.printf("%d %d%n", coordinates.get(i)[0] - max + 1, coordinates.get(i)[0] + 1);
//            System.out.println(sameLongestSubStr[i]);
           index.add(new Integer[]{coordinates.get(i)[0] + 1, coordinates.get(i)[1] + 1});
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
