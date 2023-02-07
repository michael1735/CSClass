package Homework;
import java.util.*;
class node{
    int data;

    public void setNextNode(int nextNode) {
        this.nextNode = nextNode;
    }

    int nextNode;
    public node(int data, int nextNode){
        this.data = data;
        this.nextNode = nextNode;
    }
}

public class JavaLinkedList {
    static node[] linkedList = new node[5];
    static int startPointer = -1;
    static int freePointer = 0;

    public static void main(String[] args) {
        init();
        displayList();
        add();
    }

    public static void init(){
        for(int i = 0; i < linkedList.length; i++){
            linkedList[i] = new node(0, -1);
        }
    }

    public static void add(){
        int nextLine;
        Scanner read = new Scanner(System.in);
        // add your code here
        while (true) {
            if (freePointer == -1) {
                System.out.println("the list is full");
                displayList();
                break;
            }
            nextLine = read.nextInt();
            if (freePointer == 0) {
                startPointer = freePointer;
            }
            if (freePointer != -1) {
                linkedList[freePointer] = new node(nextLine, ++freePointer);
            }
            if (freePointer > linkedList.length - 1) {
                linkedList[freePointer - 1].setNextNode(-1);
                freePointer = -1;
            }
            displayList();
        }
    }

    public static void displayList(){
        int x = 0;
        System.out.println("Index | Data | nextNode");
        for(node item : linkedList){
            System.out.println("  " + x + "   |  " + item.data + "   |    " + item.nextNode);
            x++;
        }
        System.out.println("start pointer = " + startPointer);
        System.out.println("freePointer = " + freePointer + "\n");
    }
}
