package A2CS;

class IntObj {
    public int value;
}

class Node {
    public int value;
    public Node next;
}

class NodeSE {
    public String data;
    public int pointer;

    public NodeSE(String data, int pointer) {
        this.data = data;
        this.pointer = pointer;
    }
}
public class PointerExample {
    public static void main(String[] args) {
        IntObj x, y;

        x = new IntObj();
        x.value = 42;
//        y.value = 13;

        y = x;
        y.value = 13; // 此时x, y都将指向13(指针共享性)

        // 链表
        Node a;
        Node b;
        Node c;

        a = new Node();
        b = new Node();
        c = new Node();

        a.value = 1;
        b.value = 2;
        c.value = 3;
        a.next = b;
        b.next = c;
        c.next = null;
    }
}
