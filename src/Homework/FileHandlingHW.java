package Homework;

import java.io.*;

public class FileHandlingHW {
    public static void main(String[] args) {
        File file = new File("D:\\CS±Ê¼Ç\\test.txt");
        BufferedReader bf = null;
        String strLine = "";
        String prevStr = "";

        try{
            bf = new BufferedReader(new FileReader(file));
            while ((strLine = bf.readLine()) != null){
                if (prevStr.length() < strLine.length()){
                    prevStr = strLine;
                }
            }
            System.out.println("The longest str is: " + prevStr);
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } catch (IOException e) {
            System.out.println("an IO error occurs");
        }
    }
}
