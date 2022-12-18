package ACSL;

import java.util.ArrayList;
import java.util.Scanner;

public class NextBase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int n = 0; // how many to generate
        int b = 0; // base
        int s = 0; // where the number starts
        String[] inArr = input.split(" "); // split inputs
        n = Integer.parseInt(inArr[0]);
        b = Integer.parseInt(inArr[1]);
        s = Integer.parseInt(inArr[2], b);
        int num = generate(n, b, s);
        // generate the next s numbers
        System.out.println(num);
    }

    static int generate(int n, int base, int s) {
        ArrayList<String> tempList = new ArrayList<>(n); // store the generated number
        ArrayList<String> occurredDigit = new ArrayList<>(20);
        // store the digits occurred inside the number;
        int start = s;
        for (int i = 0; i < n; i++) { // generate the numbers and store them into tempList
            if (base == 2) {
                tempList.add(Integer.toBinaryString(start));
            } else if (base == 10) {
                tempList.add(String.valueOf(start));
            } else if (base == 8) {
                tempList.add(Integer.toOctalString(start));
            } else if (base == 16) {
                tempList.add(Integer.toHexString(start));
            } else {
                tempList.add(Integer.toString(start, base));
            }
            start++;
        }

        for (String st : tempList) { // find the different digit occurring
            for (int i = 0; i < st.length(); i++) {
                if (!occurredDigit.contains(st.substring(i, i+1))) {
                    occurredDigit.add(st.substring(i, i+1));
                }
            }
        }
        int[] timeOccurred = new int[occurredDigit.size()]; // store the time each digit occurs inside the num
        String tempCh = "";
        int tempIndex = 0;
        for (String st : tempList) {
            for (int i = 0; i < st.length(); i++) { // count the number of times that each digit occurs
                tempCh = st.substring(i, i+1);
                tempIndex = occurredDigit.indexOf(tempCh);
                timeOccurred[tempIndex] += 1;
            }
        }

        int max = 0;
        for (int i = 0; i < timeOccurred.length; i++) { // find max time
            if (timeOccurred[i] > max) {
                max = timeOccurred[i];
            }
        }
        return max;
    }
}
