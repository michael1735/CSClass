package ACSL;
public class BooleanSolverCmq {

    public static int[][] parse(String s) {
        int[][] arr = new int[4][4];
        int digit;
        for (int i=0; i<4; i++) {
            String c = s.substring(i, i+1);
            if (c.equals("A")) {
                digit = 10;
            } else if (c.equals("B")) {
                digit = 11;
            } else if (c.equals("C")) {
                digit = 12;
            } else if (c.equals("D")) {
                digit = 13;
            } else if (c.equals("E")) {
                digit = 14;
            } else if (c.equals("F")) {
                digit = 15;
            } else {
                digit = Integer.parseInt(c);
            }
            arr[i][0] = digit / 8;
            digit %= 8;
            arr[i][1] = digit / 4;
            digit %= 4;
            arr[i][2] = digit / 2;
            digit %= 2;
            arr[i][3] = digit;
        }
        return arr;
    }

    private static boolean checkAndRemoveEightRow(int[][] arr, int n) {
        for (int i=0; i<4; i++) {
            if (arr[n][i] == 0 || arr[n+1][i]==0) {
                return false;
            }
        }
        // remove all 1s
        for (int i=0; i<4; i++) {
            arr[n][i] = 0;
            arr[n+1][i] = 0;
        }
        return true;
    }

    private static boolean checkAndRemoveEightCol(int[][] arr, int n) {
        for (int i=0; i<4; i++) {
            if (arr[i][n] == 0 || arr[i][n+1] == 0) {
                return false;
            }
        }
        for (int i=0; i<4; i++) {
            arr[i][n] = 0;
            arr[i][n+1] = 0;
        }
        return true;
    }

    private static boolean checkAndRemoveEightAdjRow(int[][]arr) {
        int curr = 3;
        int next = 0;
        for (int i=0; i<4; i++) {
            if (arr[curr][i] == 0 || arr[next][i] == 0) {
                return false;
            }
        }
        for (int i=0; i<4; i++) {
            arr[curr][i] = 0;
            arr[next][i] = 0;
        }
        return true;
    }

    private static boolean checkAndRemoveEightAdjCol(int[][]arr) {
        int curr = 3;
        int next = 0;
        for (int i=0; i<4; i++) {
            if (arr[i][curr] == 0 || arr[i][next] == 0) {
                return false;
            }
        }
        for (int i=0; i<4; i++) {
            arr[i][curr] = 0;
            arr[i][next] = 0;
        }
        return true;
    }

    public static String findEight(int[][] arr) {
        // check full rows
        int i;
        for (i=0; i<3; i++) {
            if (checkAndRemoveEightRow(arr, i)) {
                switch (i) {
                    case 0:
                        return "B";
                    case 1:
                        return "D";
                    case 2:
                        return "~B";
                }
            }
        }
        // check full cols
        for (i=0; i<3; i++) {
            if (checkAndRemoveEightCol(arr, i)) {
                switch (i) {
                    case 0:
                        return "A";
                    case 1:
                        return "C";
                    case 2:
                        return "~A";
                }
            }
        }
        // check adajacent endrows
        if (checkAndRemoveEightAdjRow(arr)) {
            return "~D";
        } else if (checkAndRemoveEightAdjCol(arr)) { // check adajacent endcols
            return "~C";
        }
        return "";
    }
}
