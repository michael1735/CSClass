package À„∑®;

import java.io.*;

public class MethodsDemo {
    public static String[] hireTime = new String[10];
    public static int[] duration = new int[10];
    public static double[] costs = new double[10];
    public static double dailyTakings = 0;

    public static void main(String[] args) {
        try{
            RecordHire(2, "12:00", 3, 12.0);
        } catch (IOException e){
            System.out.println("I/O error occurred when writing to HireLog.txt");
        }
    }
    public static void RecordHire(int boatNum, String hireStartTime, int durationInMinutes, double cost) throws IOException {
        final String COMMA = ",";

        hireTime[boatNum] = hireStartTime;
        duration[boatNum] = durationInMinutes;
        costs[boatNum] = cost;

        dailyTakings = dailyTakings + cost;

        File file = new File("D:\\CS± º«\\HireLog.txt");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
        pw.write(boatNum + COMMA + hireStartTime + COMMA + durationInMinutes + COMMA + cost);
        pw.flush();
        pw.close();
    }
}
