import java.util.*;

public class Main {
    static String[] newStack = new String[10];
    static int topOfStack = -1;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String operation = "";
        String data = "";

        initialize();

        while(input.hasNextLine()){
            operation = input.nextLine();
            if(operation.equals("pop")){
                // add your code here
                pop();
            }else if(operation.equals("push")){
                // add your code here
                data = input.nextLine();
                push(data);
            }else if(operation.equals("display")){
                System.out.println("");
                // add your code here
                display();
                System.out.println("");
            }
        }
    }

    public static void initialize(){
        for(int x = 0; x < 10; x++){
            newStack[x] = "";
        }
    }

    // add the pop(), push(), and display() modules
    public static void push(String data) {
        if (topOfStack < 9) {
            newStack[++topOfStack] = data;
            System.out.println(data + " has been pushed");
        } else {
            System.out.println("The stack is full. The item couldn't be pushed");
        }
    }

    public static void pop() {
        if (topOfStack == -1) {
            System.out.println("The stack is empty");
        } else {
            System.out.println(newStack[topOfStack--] + " has been popped");
        }
    }

    public static void display() {
        if (topOfStack == -1) {
            System.out.println("The stack is empty");
            return;
        }
        System.out.println("The current stack is: ");
        for (int i = topOfStack; i >= 0; i--) {
            System.out.println(newStack[i]);
        }
    }
}