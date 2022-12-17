package 算法;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

// 我的代码 问题在于我把字符串转换成了整数并且存了个值作比较, 然而并不需要, 只需要在条件里写就行了, 那样
// 省去了一堆代码: 已改正
public class SCLowestScore_Me {
    /*
    	Add your function lowestScore() here. It will return a 2D string array. It will be sent 2 parameters: memberID and the array containing all the records.
        It must return the lowest score and date for the memberID. If the memberID isn't found return "-1" for both the score and date
    */
    public static String[] lowestScore(String searchID, String[] records) {
        String thisID, thisScore, thisDate;
        String[] retArray = new String[2];
        int counter = 0;
        retArray[0] = "-1";
        retArray[1] = "-1";

        while (counter < 9) {
            thisID = records[counter].substring(0, 4);
            thisScore = records[counter].substring(12);
            thisDate = records[counter].substring(4, 12);
            if (thisID.equals(searchID)) {
                if (retArray[0].equals("-1") || parseInt(retArray[0]) > parseInt(thisScore)) {
                    retArray[0] = thisScore;
                    retArray[1] = thisDate;
                }
            }
            counter++;
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
