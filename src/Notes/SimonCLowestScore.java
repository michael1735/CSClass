package Notes;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class SimonCLowestScore {
    public static String[] lowestScore(String searchID, String[] recordArr) {
        String[] lowest = new String[2];
        lowest[0] = "-1"; // stores the score
        lowest[1] = "-1"; // stores the date

        for (String s : recordArr) {
            String thisID = s.substring(0, 4);
            String thisScore = s.substring(12);
            String thisDate = s.substring(4, 12);

            if (thisID.equals(searchID)) {
                if (lowest[0].equals("-1") || parseInt(lowest[0]) > parseInt(thisScore)) {
                    lowest[0] = thisScore;
                    lowest[1] = thisDate;
                }
            }
        }
        return lowest;
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
