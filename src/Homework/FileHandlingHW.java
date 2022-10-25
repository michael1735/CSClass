package Homework;

import java.io.*;

public class FileHandlingHW {
    public static void main(String[] args) {
        File file = new File("D:\\GitRepos\\learngit\\readme.txt");
        BufferedReader bf = null;

        try{
            bf = new BufferedReader(new FileReader(file));
            String strLine;
            while ((strLine = bf.readLine()) != null){
                System.out.println(strLine + "\n");
            }
            bf.close();
        } catch (IOException e){
            System.out.println("Interrrupted I/O operations");
        }
    }
}
