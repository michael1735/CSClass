package AlgorithmsAndDataStructures;

public class LinkedListsDemo {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(10);
        list.add(20);
        list.add(12);
        list.insertAtStart(25);
        list.insertAt(0, 55);
        list.deleteAt(2);

        list.show();
    }
}

class LinkedList {
    Node start;

    public void add(int data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;

        if (start == null) {
            start = newNode;
        } else {
            Node n = start;

            while (n.next != null) {
                n = n.next;
            }

            n.next = newNode;
        }
    }

    public void insertAtStart(int data) {
        Node node = new Node();
        node.data = data;
        node.next = start;
        start = node;
    }

    public void insertAt(int index, int data) {
        Node node = new Node();
        node.data = data;

        if (index == 0) { // ���⣬��Ϊֱ�Ӱ�����ķ����Ὣ���ݲ���0��1֮��
            insertAtStart(data);
            return;
        }

        Node n = start;
        for (int i = 0; i < index - 1; i++) { // �պõ���index-1��λ��
            n = n.next;
        }
        node.next = n.next;
        n.next = node;
    }

    public void deleteAt(int index) {
        if (index == 0) {
            start = start.next;
        } else {
            Node n = start;
            Node n1 = null;
            for (int i = 0; i < index - 1; i++) {
                n = n.next;
            }
            n1 = n.next;
            n.next = n1.next;
            // System.out.println("The node is removed at " + index + " " + n1.data);
            n1 = null; // ˦��gc
        }
    }

    public void show() {
        Node n = start;
        while (n != null) {
            System.out.println(n.data);
            n = n.next;
        }
    }
}

class Node {
    int data;
    Node next;
}
