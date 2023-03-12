package ACSL;

import java.util.Scanner;

public class ACSLdf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for( int c = 0; c < 5; c++) {
            String string1 = sc.nextLine().toUpperCase();
            String string2 = sc.nextLine().toUpperCase();
            String ref = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            for(int i = string1.length() - 1; i >= 0; i--) {
                if (!ref.contains(string1.substring(i, i+1))) {
                    string1 = string1.substring(0, i) + string1.substring(i+1);
                }
            }
            for(int i = string2.length() - 1; i >= 0; i--) {
                if (!ref.contains(string2.substring(i, i+1))) {
                    string2 = string2.substring(0, i) + string2.substring(i+1);
                }
            }
            System.out.println(diff(string1, string2));
        }
        sc.close();
    }
    public static int diff(String string1, String string2) {
        String temp = "";
        int tempcounter = 0;
        String right1 = ""; String left1 = "";
        String right2 = ""; String left2 = "";
        for (int i = 0; i < string1.length(); i++) {
            int counter = 1;
            while(i + counter <= string1.length() &&
                    string2.contains(string1.substring(i, i+counter))) {
                counter++;
            }
            counter--;
            if (counter > tempcounter) {
                tempcounter = counter;
                temp = string1.substring(i, i+counter);
            }
            else if (tempcounter != 0 && counter == tempcounter)
                temp = compare(temp, string1.substring(i, i+counter));
        }
        if(tempcounter == 0)
            return 0;
        int index1 = string1.indexOf(temp);
        left1 = string1.substring(0, index1);
        right1 = string1.substring(index1 + tempcounter);
        int index2 = string2.indexOf(temp);
        left2 = string2.substring(0, index2);
        right2 = string2.substring(index2 + tempcounter);
//System.out.println(left1 + " " + right1 + " / " + left2 + " " + right2);
        return tempcounter + diff(right1, right2) + diff(left1, left2);
    }
    public static String compare(String string1, String string2) {
        for (int i = 0; i < string1.length(); i++){
            if (string1.charAt(i) < string2.charAt(i))
                return string1;
            if (string1.charAt(i) > string2.charAt(i))
                return string2;
        }
        return string1;
    }

}
