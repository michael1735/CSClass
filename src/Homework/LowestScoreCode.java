package Homework;

import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

public class LowestScoreCode {
    /*
    	Add your function lowestScore() here. It will return a 2D string array. It will be sent 2 parameters: memberID and the array containing all the records.
        It must return the lowest score and date for the memberID. If the memberID isn't found return "-1" for both the score and date
    */
    public static String[] lowestScore(String searchID, String[] records) {
        String thisID, thisScore, thisDate;
        String[] retArray = new String[2];
        int counter = 0;
        int minScore = 999;
        int count = 0;

        while (counter < 9) {
            thisID = records[counter].substring(0, 4);
            thisScore = records[counter].substring(12);
            thisDate = records[counter].substring(4, 12);
            if (thisID.equals(searchID)) {
                if (minScore > parseInt(thisScore)) {
                    minScore = parseInt(thisScore);
                    retArray[1] = thisDate;
                }
                retArray[0] = valueOf(minScore);
                count++;
            }
            counter++;
        }

        if (count == 0) {
            retArray[0] = "-1";
            retArray[1] = "-1";
        }
        return retArray;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String memberID = input.nextLine();
        int fileLen = 9;
        String[] records = new String[fileLen];
        for(int x = 0; x < records.length; x++){
            records[x] = input.nextLine();
        }
        String[] lowest = lowestScore(memberID, records);
        if(lowest[0].equals("-1")){
            System.out.println("Member ID not found");
        }else{
            String year, month, day;
            year = lowest[1].substring(0,4);
            month = lowest[1].substring(4,6);
            day = lowest[1].substring(6);
            System.out.println("Member " + memberID + " scored " + lowest[0] + " on " + year + " " + month + " " + day);
        }
    }
}
