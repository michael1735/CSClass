package ACSL;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Str_2_sr_test {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        /*String ln1 = scan.nextLine();
        String ln2 = scan.nextLine();
        String ln3 = scan.nextLine();
        String ln4 = scan.nextLine();
        String ln5 = scan.nextLine();*/
        String ln1 = "523.125, 6, 2";
        String ln2 = "+523.125, 6, 1";
        String ln3 = "-523.163, 6, 1";
        String ln4 = "523.125, 4, 2";
        String ln5 = "-523.12, 6, 1";

        String[] line1 = ln1.split(", ");
        String[] line2 = ln2.split(", ");
        String[] line3 = ln3.split(", ");
        String[] line4 = ln4.split(", ");
        String[] line5 = ln5.split(", ");

        String result1 = STR(line1[0], Integer.parseInt(line1[1]), Integer.parseInt(line1[2]));
        String result2 = STR(line2[0], Integer.parseInt(line2[1]), Integer.parseInt(line2[2]));
        String result3 = STR(line3[0], Integer.parseInt(line3[1]), Integer.parseInt(line3[2]));
        String result4 = STR(line4[0], Integer.parseInt(line4[1]), Integer.parseInt(line4[2]));
        String result5 = STR(line5[0], Integer.parseInt(line5[1]), Integer.parseInt(line5[2]));

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);
    }

    public static String STR(String floatExpression, int length, int decimal) {
        String sign, magnitude;
        sign = "";
        int thisLength = length;
        if (floatExpression.charAt(0) == '+' || floatExpression.charAt(0) == '-') {
            sign = floatExpression.substring(0, 1);
            magnitude = floatExpression.substring(1);
        } else {
            magnitude = floatExpression;
        }
        int indexOfPoint = magnitude.indexOf(".");
        StringBuilder result = new StringBuilder();
        String integerPart = magnitude.substring(0, indexOfPoint);
        String floatPart = magnitude.substring(indexOfPoint + 1);
        // generate final number
        String tempFloatPt;
        String tempFloat = "";
        if (Integer.parseInt(floatPart.substring(decimal, decimal + 1)) >= 5) {
            tempFloatPt = floatPart.substring(0, decimal);
            /*System.out.println(tempFloatPt); // @TODO : test line
            tempFloat = tempFloatPt.replace(
                    tempFloatPt.charAt(tempFloatPt.length() - 1),
                    (char) (Integer.parseInt(String.valueOf(tempFloatPt.charAt(tempFloatPt.length() - 1))) + 1)
            );
            System.out.println(tempFloat); // TODO: test line*/

            // decimalFormat类的测试方法
            // 后面加入decimal-1个#，然后创建decimalFormat()
            DecimalFormat df = new DecimalFormat("#." + "0".repeat(decimal)
                    // 后面加入decimal-1个#，然后创建decimalFormat()
            );
            String resultStr = df.format(Double.parseDouble(floatExpression));
        } else {
            tempFloatPt = floatPart.substring(0, decimal);
        }
        thisLength = thisLength - tempFloatPt.length() - 1; // 剪掉了截取的小数部分和小数点的长度。
        int fromIndexInt = integerPart.length() - thisLength;
        String tmpIntegerPt = integerPart.substring(fromIndexInt);
        result.append(sign).append(tmpIntegerPt).append(".").append(tempFloat);
        return result.toString();
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