package Homework;

import java.io.*;

public class FileHandling1 {
    public static void main(String[] args) {
        File file = new File("D:\\GitRepos\\learngit\\readme.txt");
        BufferedReader bf = null;
        String strLine = null;
        String strData = "";

        try{
            bf = new BufferedReader(new FileReader(file));

            while ((strLine = bf.readLine()) != null){
                strLine = strLine + "\n";
                strData += strLine;
            }
            System.out.println(strData);
            bf.close();
        } catch (FileNotFoundException e){
            System.out.println("file not found in the directory");
        } catch (IOException e){
            System.out.println("IOException occured.");
        }
    }
}
