package ACSL;

public class Tree {
    /*
    Root - a special node (no parent)

    Node - value & children(Nodes)

    Leaf - a special node(no children)

    Height - The Longest distance from current node to a Leaf node
     */

    /*
    Binary tree: (BST)
    1.has two children at maximum(for a Node)
    2.Value of left node < value at current node < ......right node
     */
}

class Node {
    private Node left;
    private Node Right;
    private Integer Val;

    public boolean hasValue(int k) { // DFS(¼òµ¥°æ)
        if (Val == k) {
            return true;
        } else if (Val < k) {
            if (Right == null) return false;
            else return Right.hasValue(k);
        } else {
            if (left == null) return false;
            else return left.hasValue(k);
        }
    }
}
