package Homework;

import java.util.Scanner;

public class Solution {
    // 蔡牧吟的代码, search方法的二维数组应用神中神了
    public static String[][] Search(String searchID, String[] records){
        String[][] results = new String[records.length][2];

        int inde = 0;
        for (int i = 0; i < records.length; i++){
            String a = records[i].substring(0, 5);
            if (a.equals(searchID)){
                results[inde] = new String[]{records[i].substring(5, 9), records[i].substring(9)};
                inde++;
            }
        }
        return results;
    }

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
