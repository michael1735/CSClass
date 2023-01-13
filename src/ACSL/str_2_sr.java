package ACSL;

import org.w3c.dom.css.CSSStyleSheet;

import javax.imageio.ImageTranscoder;
import java.util.Stack;

public class str_2_sr {
    public static void main(String[] args) {
        String in1 = "523.125, 6, 2"; // 523.13
        String in2 = "+523.125, 6, 1"; // +523.1
        String in3 = "-523.163, 6, 1"; // -523.2
        String in4 = "523.125, 4, 2"; // #.##
        String in5 = "-523.12, 6, 1"; // -523.1

        String[] line1 = in1.split(", ");
        String[] line2 = in2.split(", ");
        String[] line3 = in3.split(", ");
        String[] line4 = in4.split(", ");
        String[] line5 = in5.split(", ");

        String out1 = STR(line1[0], Integer.parseInt(line1[1]), Integer.parseInt(line1[2]));
        String out2 = STR(line2[0], Integer.parseInt(line2[1]), Integer.parseInt(line2[2]));
        String out3 = STR(line3[0], Integer.parseInt(line3[1]), Integer.parseInt(line3[2]));
        String out4 = STR(line4[0], Integer.parseInt(line4[1]), Integer.parseInt(line4[2]));
        String out5 = STR(line5[0], Integer.parseInt(line5[1]), Integer.parseInt(line5[2]));

        System.out.println(out1);
        System.out.println(out2);
        System.out.println(out3);
        System.out.println(out4);
        System.out.println(out5);
    }

    public static String STR(String floatExpr, int length, int decimal) {
        String sign = "";
        String magnitude;
        if (floatExpr.charAt(0) == '+' || floatExpr.charAt(0) == '-') {
            sign = floatExpr.substring(0, 1);
            magnitude = floatExpr.substring(1);
        } else {
            magnitude = floatExpr;
        }
        double doubleMagnitude = Double.parseDouble(magnitude);
        doubleMagnitude = roundDouble(doubleMagnitude, decimal);
        magnitude = String.valueOf(doubleMagnitude);
        StringBuilder tempMagnitude = new StringBuilder();
        if (magnitude.length() < length) {
            int i = magnitude.length();
            tempMagnitude.append(magnitude);
            while (i < length) {
                tempMagnitude.insert(0, "#");
                i++;
            }
        } else if (magnitude.length() > length) {
            if (length % 2 == 0) {
                for (int i = 0; i < length; i++) {
                    if (i == length / 2) {
                        tempMagnitude.append(".");
                    } else {
                        tempMagnitude.append("#");
                    }
                }
            } else {
                for (int i = 0; i < length; i++) {
                    if (i == length / 2 + 1) {
                        tempMagnitude.append(".");
                    } else {
                        tempMagnitude.append("#");
                    }
                }
            }
        }
        magnitude = tempMagnitude.toString();
        return sign + magnitude;
    }

    static double roundDouble(double doubleExpr, int decimal) {
        double thisDoubleExpr = doubleExpr;
        thisDoubleExpr *= Math.pow(10, decimal);
        if (thisDoubleExpr * 10 - (int) (thisDoubleExpr) * 10 >= 5) {
            thisDoubleExpr = Math.ceil(thisDoubleExpr);
        } else {
            thisDoubleExpr = Math.floor(thisDoubleExpr);
        }
        return thisDoubleExpr / Math.pow(10, decimal);
    }
}
