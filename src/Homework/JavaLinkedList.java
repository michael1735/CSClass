package Homework;
import java.util.*;
class Node {
    // add code here for the node class
    private int data;
    private int nextNode;
    public Node(int data, int nextNode) {
        this.data = data;
        this.nextNode = nextNode;
    }

    public int getNextNode() {
        return nextNode;
    }

    public void setNextNode(int nextNode) {
        this.nextNode = nextNode;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
public class JavaLinkedList {
    // add new global instance of the node class called linkedList here.
    // Also add global variables startPointer and freePointer. Initialise as -1 and 0 respectively.
    static int startPointer = -1;
    static int freePointer = 0;
    static int place = 0;

    static Node[] linkedList = new Node[5];
    public static void main(String[] args) {
        init();
        displayList();
        add();
        displayList();
    }
    public static void init(){
        // initialise the list so all the data items are 0 and all the nextNode pointers are -1
        for (int i = 0; i < linkedList.length; i++) {
            linkedList[i] = new Node(0, -1);
        }
    }

    public static void add(){
        Scanner read = new Scanner(System.in);
        int times = 0;
        // add your code here to update the pointers startPointer and freePointer
        // you also need to add the data item into the linkedList
        if (place == 0) {
            startPointer = 0;
        } else if (place == linkedList.length - 1) {
            freePointer = -1;
        }
        while (read.hasNextLine()) {
            int input = read.nextInt();
            if (input == 0) {
                break;
            }
            if (place >= linkedList.length) {
                System.out.println("the list is full");
                times++;
                if (times >= 2) {
                    break;
                }
                continue;
            }
            linkedList[place].setData(input);
            if (place < linkedList.length - 1)
                linkedList[place].setNextNode(place + 1);
            else
                linkedList[place].setNextNode(-1);
            place++;
        }
    }

    // do not delete or change this section of code as it will be used to display your linked list.
    // the test cases will be expecting a certain format which this procedure will give you.
    public static void displayList(){
        System.out.println("Index | Data | nextNode");
        for(int x = 0; x < linkedList.length; x++){
            System.out.println("  " + x + "   |  " + linkedList[x].getData() + "   |    " + linkedList[x].getNextNode());
        }
    }
}
