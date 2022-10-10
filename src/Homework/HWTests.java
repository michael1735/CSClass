package Homework;

import java.util.Scanner;

public class HWTests {
    public static String[][] Search(String searchID, String[] records){
        String [][] results = new String[records.length][2];
    	/* return a 2D array that contains all the port numbers [0] and dates [1] for
        the search ID
        */
        return results;
    }
    // 如果ID是Simon就把它加入二维数组

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String searchID = input.nextLine();
        String[] records = new String[7];
        for(int x = 0; x < 7; x++){
            records[x] = input.nextLine();
        }
        String[][] userDets = Search(searchID, records);
        int count = 0;
        if(userDets[0][0] == null){
            System.out.println("no records");
        }else{
            String port, time, month, day, year = "";
            while(count < userDets.length && userDets[count][0] != null){
                port = userDets[count][0];
                time = userDets[count][1].substring(0,5);
                month = userDets[count][1].substring(5,8);
                day = userDets[count][1].substring(8,10);
                year = userDets[count][1].substring(10);
                System.out.println(port + " " + time + " " + month + " " + day + " " + year);
                count ++;
            }
        }
    }
}
