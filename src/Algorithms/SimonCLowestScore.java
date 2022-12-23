package Algorithms;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

/*
A golf club keeps records of every round played by their members. Each record is in the format .

member ID is a 4 digit number
date is in the format YYYYMMDD
score is a 3 digit integer
The pre-made code will create the array storing all of the records. It will also read in the target member ID.

You must create a function that will search through the records and return the members lowest score and the date they scored it on.

*hint: return both values using a 2D array, [0] for the score and [1] for the date. If the memberID is not found, return [0] = -1 and [1] = -1

The function is called LowestScore and takes 2 parameters: the memberID and the array records.

Input Format

MemberID to search A list of records to be added to the array

All of these inputs will be handled by the pre-written code

Constraints

All records will follow the same format, so you can code using these values (4 character ID, 8 character date, 3 character score)

You must output all 3 digits for the lowest score (include leading zero)

Output Format

Member memberID scored lowestScore on space separated date

Sample Input 0

1234
111219990218078
123420000929099
023420010131101
111220021110089
111220021111069
123420021201094
123420021202100
023420030101099
023420030124093
Sample Output 0

Member 1234 scored 094 on 2002 12 01
 */

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
