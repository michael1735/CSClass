package ACSL;

import java.util.*;

public class fiboclockjr {
    static Scanner input = new Scanner(System.in);

    private int hour = 0;

    private int minutes = 0;

    private int seconds = 0;

    private int count = 1; // to ensure that we multiply the right length of the square
    public fiboclockjr(String inStr) {
        String[] in = new String[5];

        for (int i = 0; i < in.length; i++) {
            in[i] = inStr.substring(i, i+1);
        }
        String output = calculateTime(in);
        System.out.println(output);
    }

    public String calculateTime(String[] inStrArr) {
        int[] display = new int[3];
        for (String s : inStrArr) {
            if (count == 1) {
                if (s.equals("R")) {
                    this.hour += count;
                } else if (s.equals("G")) {
                    this.minutes += count * 5;
                } else if (s.equals("B")) {
                    this.seconds += count * 5;
                } else if (s.equals("Y")) {
                    this.hour += count;
                    this.minutes += count * 5;
                } else if (s.equals("C")) {
                    this.minutes += count * 5;
                    this.seconds += count * 5;
                } else if (s.equals("M")) {
                    this.hour += count;
                    this.seconds += count * 5;
                } else {
                    continue;
                }
            } else if (count == 2) {
                if (s.equals("R")) {
                    this.hour += 1;
                } else if (s.equals("G")) {
                    this.minutes += 1 * 5;
                } else if (s.equals("B")) {
                    this.seconds += 1 * 5;
                } else if (s.equals("Y")) {
                    this.hour += 1;
                    this.minutes += 1 * 5;
                } else if (s.equals("C")) {
                    this.minutes += 1 * 5;
                    this.seconds += 1 * 5;
                } else if (s.equals("M")) {
                    this.hour += 1;
                    this.seconds += 1 * 5;
                } else {
                    continue;
                }
            } else if (count == 3) {
                switch (s) {
                    case "R":
                        this.hour += 2;
                        break;
                    case "G":
                        this.minutes += 2 * 5;
                        break;
                    case "B":
                        this.seconds += 2 * 5;
                        break;
                    case "Y":
                        this.hour += 2;
                        this.minutes += 2 * 5;
                        break;
                    case "C":
                        this.minutes += 2 * 5;
                        this.seconds += 2 * 5;
                        break;
                    case "M":
                        this.hour += 2;
                        this.seconds += 2 * 5;
                        break;
                    default:
                        continue;
                }
            } else if (count == 4) {
                switch (s) {
                    case "R":
                        this.hour += 3;
                        break;
                    case "G":
                        this.minutes += 3 * 5;
                        break;
                    case "B":
                        this.seconds += 3 * 5;
                        break;
                    case "Y":
                        this.hour += 3;
                        this.minutes += 3 * 5;
                        break;
                    case "C":
                        this.minutes += 3 * 5;
                        this.seconds += 3 * 5;
                        break;
                    case "M":
                        this.hour += 3;
                        this.seconds += 3 * 5;
                        break;
                    default:
                }
            } else {
                switch (s) {
                    case "R":
                        this.hour += 5;
                        break;
                    case "G":
                        this.minutes += 5 * 5;
                        break;
                    case "B":
                        this.seconds += 5 * 5;
                        break;
                    case "Y":
                        this.hour += 5;
                        this.minutes += 5 * 5;
                        break;
                    case "C":
                        this.minutes += 5 * 5;
                        this.seconds += 5 * 5;
                        break;
                    case "M":
                        this.hour += 5;
                        this.seconds += 5 * 5;
                        break;
                    default:
                        continue;
                }
            }
            count++;
        }
        display[0] = this.seconds;
        display[1] = this.minutes;
        display[2] = this.hour;

        boolean modifiedSeconds = false;
        boolean modifiedMinutes = false;
        boolean modifiedHours = false;
        if (this.seconds >= 60) {
            this.seconds = this.seconds - 60;
            display[0] = this.seconds;
            modifiedSeconds = true;
        }

        if (this.minutes >= 60) {
            if (modifiedSeconds){
                this.minutes = this.minutes - 60 + 1;
            } else {
                this.minutes = this.minutes - 60;
            }
            display[1] = this.minutes;
            modifiedMinutes = true;
        }

        if (this.hour >= 12) {
            if (modifiedMinutes) {
                this.hour = this.hour - 12 + 1;
            } else {
                this.hour = this.hour - 12;
            }
            display[2] = this.hour;
            modifiedHours = true;
        }

        String[] display2 = new String[3];
        for (int i = 0; i < display.length; i++) {
            String tempStr = String.valueOf(display[i]);
            if (tempStr.length() < 2) {
                tempStr = "0" + tempStr;
            }
            display2[i] = tempStr;
        }

        return display2[2] + ":" + display2[1] + ":" + display2[0];
    }
    public static void main(String[] args) {
        String ln1 = input.nextLine();
        String ln2 = input.nextLine();
        String ln3 = input.nextLine();
        String ln4 = input.nextLine();
        String ln5 = input.nextLine();

        new fiboclockjr(ln1);
        new fiboclockjr(ln2);
        new fiboclockjr(ln3);
        new fiboclockjr(ln4);
        new fiboclockjr(ln5);
    }
}
/*
RWGBG
RCMGB
BYYGR
MRGBW
YYYYY
 */