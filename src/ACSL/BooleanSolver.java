package ACSL;

public class BooleanSolver {
    public static int[][] parse(String s) {
        int[][] arr = new int[4][4];
        int digit;
        for (int i = 0; i < 4; i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'A' -> digit = 10;
                case 'B' -> digit = 11;
                case 'C' -> digit = 12;
                case 'D' -> digit = 13;
                case 'E' -> digit = 14;
                case 'F' -> digit = 15;
                default -> digit = Integer.parseInt(String.valueOf(c));
            }
            arr[i][3] = digit % 2;
            digit /= 2;
            arr[i][2] = digit % 2;
            digit /= 2;
            arr[i][1] = digit % 2;
            digit /= 2;
            arr[i][0] = digit % 2;
        }
        return arr;
    }

    public static boolean checkAndRemoveEightCol(int[][] arr, int n) {
        for (int i = 0; i < 4; i++) {
            if (arr[i][n] == 0 || arr[i][n+1] == 0) {
                return false;
            }
        }
        // remove all 1s
        for (int i = 0; i < 4; i++) {
            arr[i][n] = 0;
            arr[i][n+1] = 0;
        }
        return true;
    }

    public static boolean checkAndRemoveEightColAdj(int[][] arr) {
        int curr = 3;
        int next = 0;
        for (int i = 0; i < 4; i++) {
            if (arr[i][curr] == 0 || arr[i][next] == 0) {
                return false;
            }
        }
        // remove all 1s
        for (int i = 0; i < 4; i++) {
            arr[i][curr] = 0;
            arr[i][next] = 0;
        }
        return true;
    }

    public static boolean checkAndRemoveEightRow(int[][] arr, int n) {
        for (int i = 0; i < 4; i++) {
            if (arr[n][i] == 0 || arr[n+1][i] == 0) {
                return false;
            }
        }
        // remove all 1s
        for (int i = 0; i < 4; i++) {
            arr[n][i] = 0;
            arr[n+1][i] = 0;
        }
        return true;
    }

    public static boolean checkAndRemoveEightRowAdj(int[][] arr) {
        int curr = 3;
        int next = 0;
        for (int i = 0; i < 4; i++) {
            if (arr[curr][i] == 0 || arr[next][i] == 0) {
                return false;
            }
        }
        // remove all 1s
        for (int i = 0; i < 4; i++) {
            arr[curr][i] = 0;
            arr[next][i] = 0;
        }
        return true;
    }

    public static String findEight(int[][] arr) {
        // check full rows
        for (int i = 0; i < 3; i++) {
            if (checkAndRemoveEightRow(arr, i)) {
                switch (i) {
                    case 0 -> {
                        return "B";
                    }
                    case 1 -> {
                        return "D";
                    }
                    case 2 -> {
                        return "~B";
                    }
                }
            }
        }
        // check full cols
        for (int i = 0; i < 3; i++) {
            if (checkAndRemoveEightCol(arr, i)) {
                switch (i) {
                    case 0 -> {
                        return "B";
                    }
                    case 1 -> {
                        return "D";
                    }
                    case 2 -> {
                        return "~B";
                    }
                }
            }
        }
        // check adjacent rows
        if (checkAndRemoveEightRowAdj(arr)) {
            return "~D";
        } else if (checkAndRemoveEightColAdj(arr)) { // check adjacent columns
            return "~C";
        }
        return "";
    }
    public static boolean checkAndRemoveFourRow(int[][] arr, int n) {
        for (int i = 0; i < 4; i++) {
            if (arr[n][i] == 0) {
                return false;
            }
        }
        // remove all 1s
        for (int i = 0; i < 4; i++) {
            arr[n][i] = 0;
        }
        return true;
    }

    public static boolean checkAndRemoveFourCol(int[][] arr, int n) {
        for (int i = 0; i < 4; i++) {
            if (arr[i][n] == 0) {
                return false;
            }
        }
        // remove all 1s
        for (int i = 0; i < 4; i++) {
            arr[i][n] = 0;
        }
        return true;
    }
    
    public static boolean checkAndRemoveFourBlock(int[][] arr, int n) {
        int up = n % 3; // 用于存储矩阵中横向的地址, 也就是arr[i][j]中的j
        int left = 0; // i
        switch (n) {
            case 0, 1, 2 -> {
            }
            case 3, 4, 5 -> left = 1;
            case 6, 7, 8 -> left = 2;
        }
        for (int i = up; i < up + 2; i++) {
            if (arr[left][i] == 0 || arr[left+1][i] == 0) {
                return false;
            }
        }
        // remove all 1s
        for (int i = up; i < up + 2; i++) {
            arr[left][i] = 0;
            arr[left+1][i] = 0;
        }
        return true;
    }

    public static String findFour(int[][] arr) {
        for (int i = 0; i < 4; i++) {
            if (checkAndRemoveFourRow(arr, i)) {
                switch (i) {
                    case 0 -> {
                        return "B~D";
                    }
                    case 1 -> {
                        return "BD";
                    }
                    case 2 -> {
                        return "~BD";
                    }
                    case 3 -> {
                        return "~B~D";
                    }
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            if (checkAndRemoveFourCol(arr, i)) {
                switch (i) {
                    case 0 -> {
                        return "A~C";
                    }
                    case 1 -> {
                        return "AC";
                    }
                    case 2 -> {
                        return "~AC";
                    }
                    case 3 -> {
                        return "~A~C";
                    }
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            if (checkAndRemoveFourBlock(arr, i)) {
                switch (i) {
                    case 0 -> {
                        return "AB";
                    }
                    case 1 -> {
                        return "BC";
                    }
                    case 2 -> {
                        return "~AB";
                    }
                    case 3 -> {
                        return "A~B";
                    }
                    case 4 -> {
                        return "~BC";
                    }
                    case 5 -> {
                        return "~A~B";
                    }
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        int[][] firstLn = parse("FF33");
        System.out.println(findEight(firstLn));
    }
}
