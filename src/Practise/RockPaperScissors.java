package Practise;

import java.util.*;

public class RockPaperScissors {
    static String[] components = {"Rock", "Scissor", "Paper", "Lizard", "Spock"};
    static int A = 0;
    static int B = 0;
    static ArrayList<Integer> a = new ArrayList<>();
    static ArrayList<Integer> b = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    static int cmp(int a, int b) {
        if (a == b) {
            return 0;
        } else if ((a==0 && b==1) || (a==1&&b==0)) {
            return (a > b ? 1 : -1);
        } else if ((a == 0 && b == 2) || (a == 2 && b == 0)) {
            return (a > b ? -1 : 1);
        } else if ((a == 0 && b == 3) || (a == 3 && b == 0)) {
            return (a > b ? -1 : 1);
        } else if ((a == 0 && b == 4) || (a == 4 && b == 0)) {
            return (a > b ? 1 : -1);
        } else if ((a == 1 && b == 2) || (a == 2 && b == 1)) {
            return a > b ? 1 : -1;
        } else if ((a == 1 && b == 3) || (a == 3 && b == 1)) {
            return a > b ? -1 : 1;
        } else if ((a == 1 && b == 4) || (a == 4 && b == 1)) {
            return a > b ? 1 : -1;
        } else if ((a == 2 && b == 3) || (a == 3 && b == 2)) {
            return a > b ? 1 : -1;
        } else if ((a == 2 && b == 4) || (a == 4 && b == 2)) {
            return a > b ? -1 : 1;
        } else {
            return a > b ? -1 : 1;
        }
    }
    public static void main(String[] args) {
        int N = scanner.nextInt();
        int Na = scanner.nextInt();
        int Nb = scanner.nextInt();

        for (int i = 0; i < Na; i++) {
            a.add(scanner.nextInt());
        }

        for (int i = 0; i < Nb; i++) {
            b.add(scanner.nextInt());
        }

        int APtr = 0;
        int BPtr = 0;
        for (int i = 0; i < N; i++) {

            if (cmp(a.get(APtr), b.get(BPtr)) == 1) {
                A++;
            } else if (cmp(a.get(APtr), b.get(BPtr)) == -1){
                B++;
            }
            APtr++;
            BPtr++;

            if (APtr == Na)
                APtr = 0;
            if (BPtr == Nb)
                BPtr = 0;
        }

        System.out.println(A + " " + B);
    }
}
