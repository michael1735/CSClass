package ACSL;

public class str_2_sr {
    public static void main(String[] args) {
        String in1 = "523.125, 6, 2"; // 523.13
        String in2 = "+523.125, 6, 1"; // +523.1
        String in3 = "-523.163, 6, 1"; // -523.2
        String in4 = "523.125, 4, 2"; // #.##
        String in5 = "-523.12, 6, 1"; // -523.1

        String test1 = "14.967, 6, 2"; // #14.97
        String test2 = "671.23, 7, 2"; // #671.23
        String test3 = "-25.4958, 5, 1"; // -25.5
        String test4 = "259.24, 4, 1"; // ##.#
        String test5 = "-129.997, 7, 2"; // -130.00

        String[] line1 = in1.split(", ");
        String[] line2 = in2.split(", ");
        String[] line3 = in3.split(", ");
        String[] line4 = in4.split(", ");
        String[] line5 = in5.split(", ");

        String[] testLine1 = test1.split(", ");
        String[] testLine2 = test2.split(", ");
        String[] testLine3 = test3.split(", ");
        String[] testLine4 = test4.split(", ");
        String[] testLine5 = test5.split(", ");

        String out1 = STR(line1[0], Integer.parseInt(line1[1]), Integer.parseInt(line1[2]));
        String out2 = STR(line2[0], Integer.parseInt(line2[1]), Integer.parseInt(line2[2]));
        String out3 = STR(line3[0], Integer.parseInt(line3[1]), Integer.parseInt(line3[2]));
        String out4 = STR(line4[0], Integer.parseInt(line4[1]), Integer.parseInt(line4[2]));
        String out5 = STR(line5[0], Integer.parseInt(line5[1]), Integer.parseInt(line5[2]));

        String out6 = STR(testLine1[0], Integer.parseInt(testLine1[1]), Integer.parseInt(testLine1[2]));
        String out7 = STR(testLine2[0], Integer.parseInt(testLine2[1]), Integer.parseInt(testLine2[2]));
        String out8 = STR(testLine3[0], Integer.parseInt(testLine3[1]), Integer.parseInt(testLine3[2]));
        String out9 = STR(testLine4[0], Integer.parseInt(testLine4[1]), Integer.parseInt(testLine4[2]));
        String out10 = STR(testLine5[0], Integer.parseInt(testLine5[1]), Integer.parseInt(testLine5[2]));

        System.out.println(out1);
        System.out.println(out2);
        System.out.println(out3);
        System.out.println(out4);
        System.out.println(out5);

        System.out.println(out6);
        System.out.println(out7);
        System.out.println(out8);
        System.out.println(out9);
        System.out.println(out10);
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
        boolean executed = false;
        if (magnitude.length() < length) { //
            int i = magnitude.length() + 1;
            tempMagnitude.append(magnitude);
            while (i < length) {
                tempMagnitude.insert(0, "#");
                i++;
            }
            executed = true;
        } else if (magnitude.length() > length) {
            if (length % 2 == 0) {
                for (int i = 1; i <= length; i++) {
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
            executed = true;
        }
        if (executed) {
            magnitude = tempMagnitude.toString();
        }
        return sign + magnitude;
    }

    static double roundDouble(double doubleExpr, int decimal) { // 要进行保留小数位数的时候, 最好用数字类型来处理
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
