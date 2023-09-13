import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numArray = new int[10];
        System.out.println("original");
        System.out.print("[ ");
        for(int x = 0; x < 10; x++){
            numArray[x] = input.nextInt();
            System.out.print(numArray[x] + " ");
        }
        System.out.println("] \n");
        // add your code here
        int outerExec = 0;
        int innerExec = 0;
        for (int i = 0; i < numArray.length - 1; i++) {
            for (int j = 0; j < numArray.length - 1 - i; j++) {
                if (numArray[j] < numArray[j + 1]) {
                    
                }
            }
        }
    }
}
