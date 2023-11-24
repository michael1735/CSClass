package SimonC_Challenges_AlgosNote_DO_NOT_DELETE;

import java.util.*;

public class Simon_LinkedList {

    static node[] linkedList = new node[5];
    static int startPointer;
    static int freePointer;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        initList();
        printList();

        String[] data = input.nextLine().split(" ");

        while(data[0] != ""){

            if(data[0].equals("add")){

                if(addNode(data[1])) printList();
                else System.out.println("The list is full");

            }else{
                System.out.println("Invalid input");
            }

            if(input.hasNextLine()){
                data = input.nextLine().split(" ");
            }else data[0] = "";

        }
    }

    public static void initList(){

        startPointer = -1;
        freePointer = 0;
        int x = 0;

        while(x < linkedList.length-1){
            linkedList[x] = new node("*",x+1);
            System.out.println(linkedList[x].data + " " + linkedList[x].pointer);
            x++;
        }

        linkedList[x] = new node("*",-1);
        System.out.println(linkedList[x].data + " " + linkedList[x].pointer +"\n");
    }

    public static void printList(){

        if(startPointer == -1){
            System.out.println("the list is empty \n");
        }else{
            int nextNode = startPointer;
            System.out.println("The list contains :");
            while(nextNode != -1){
                System.out.println(linkedList[nextNode].data);
                nextNode = linkedList[nextNode].pointer;
            }
            System.out.println("\nthe physical storage is :");
            System.out.println("startPointer = " + startPointer);
            System.out.println("freePointer = " + freePointer + "\n");
            for(int x = 0;x < linkedList.length; x++){
                //System.out.println(x + " " + linkedList[x].data + " " + linkedList[x].pointer);
                System.out.printf(" %3s | %9s | %3s \n",x,linkedList[x].data, linkedList[x].pointer);
            }
            System.out.println("");
        }
    }

    public static boolean addNode(String dataToAdd){
        if (freePointer == linkedList.length) {
            return false; // list is full
        }

        if (startPointer == -1) {
            startPointer = 0;
            linkedList[startPointer] = new node(dataToAdd, -1);
            freePointer++;
            return true;
        }

        int newNodeIndex = freePointer;

        node newNode = new node(dataToAdd, -1);
        int curr = startPointer;
        int prev = -1;

        while (curr != -1 && linkedList[curr].data.compareTo(dataToAdd) < 0) {
            prev = curr;
            curr = linkedList[curr].pointer;
        }

        if (prev == -1) {
            newNode.pointer = startPointer;
            startPointer = newNodeIndex;
        } else {
            newNode.pointer = linkedList[prev].pointer;
            linkedList[prev].pointer = newNodeIndex;
        }

        linkedList[newNodeIndex] = newNode;
        freePointer++;
        return true;
    }

    /*
    GPT 回复:

    public static boolean addNode(String dataToAdd) {
    if (freePointer == linkedList.length) {
        return false; // The list is full
    }

    if (startPointer == -1) {
        startPointer = 0;
        linkedList[startPointer] = new node(dataToAdd, -1);
        freePointer++;
        return true;
    }

    int newNodeIndex = freePointer;

    node newNode = new node(dataToAdd, -1);

    int current = startPointer;
    int prev = -1;

    while (current != -1 && linkedList[current].data.compareTo(dataToAdd) < 0) {
        prev = current;
        current = linkedList[current].pointer;
    }

    if (prev == -1) {
        newNode.pointer = startPointer;
        startPointer = newNodeIndex;
    } else {
        newNode.pointer = linkedList[prev].pointer;
        linkedList[prev].pointer = newNodeIndex;
    }

    linkedList[newNodeIndex] = newNode;
    freePointer++;
    return true;
}

     */
}

class node{
    String data;
    int pointer;
    public node(String data, int pointer){
        this.data = data;
        this.pointer = pointer;
    }
}