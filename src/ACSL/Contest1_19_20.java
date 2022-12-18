package ACSL;

import java.util.*;

public class Contest1_19_20 {
    // Number Transformation
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String input2 = sc.nextLine();
        String input3 = sc.nextLine();
        String input4 = sc.nextLine();
        String input5 = sc.nextLine();

        inputHandle(input);
        inputHandle(input2);
        inputHandle(input3);
        inputHandle(input4);
        inputHandle(input5);
    }

    static void inputHandle(String input) {
        String N = "";
        int P = 0;
        String[] inputArr = input.split(" ");
        N += inputArr[0];
        P += Integer.parseInt(inputArr[1]);
        String res = transform(N, P);
        System.out.println(res);
    }

    public static String transform(String N, int pos) {
        int posDigit = 0;
        int count = 1;
        int indexOfPos = 0;
        for (int i = N.length() - 1; i >= 0; i--) {
            if (count == pos) {
                posDigit = Integer.parseInt(N.substring(i, i+1));
                indexOfPos = i;
                break;
            }
            count++;
        }
        ArrayList<String> outArr = new ArrayList<>(20);
        for (int i = 0; i < N.length(); i++) {
            if (i < indexOfPos) {
                outArr.add(String.valueOf(Integer.parseInt(N.substring(i, i+1)) + posDigit));
            } else if (i == indexOfPos) {
                outArr.add(String.valueOf(PFNum(Long.parseLong(N))));
            } else {
                outArr.add(String.valueOf(Math.abs(Integer.parseInt(N.substring(i, i+1)) - posDigit)));
            }
        }

        String output = "";
        // 把 array里的数加到output里并且返回
        for (int i = 0; i < outArr.size(); i++) {
            output += outArr.get(i);
        }
        return output;
    }

    static int PFNum(long N) {

        long k = 2L;
        long m = N;
        ArrayList<Long> existFacts = new ArrayList<>();
        if (N == 1) {
            return 0;
        }

        while (k <= m) {
            if (k == m) {
                if (!existFacts.contains(m))
                    existFacts.add(m);
                break;
            } else if (m % k == 0) {
                m = m / k;
                if (!existFacts.contains(k)) {
                    existFacts.add(k);
                }
            } else {
                k++;
            }
        }
        return existFacts.size();
    }
}
/*
102438 3
4329 1
6710 2
16807 1
60098065452 7
 */

/*
test:
43287 3
72431685 1
246897532573 12
96783 5
16058314729 3
 */