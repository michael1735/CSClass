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

    public boolean checkAndRemoveEightCol(int[][] arr, int n) {
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

    public boolean checkAndRemoveEightColAdj(int[][] arr) {
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

    public boolean checkAndRemoveEightRow(int[][] arr, int n) {
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

    public boolean checkAndRemoveEightRowAdj(int [][] arr) {
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

    public String findEight(int[][] arr) {
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
        }
        // check adjacent columns
        if (checkAndRemoveEightColAdj(arr)) {
            return "~C";
        }
        return "";
    }
}
