package aug.thirty.binary.tree;

public class AVLTree<T extends Comparable<T>> {
    Node<T> head;

    public AVLTree() {
        this.head = null;
    }

    /**
     * Add a data point to the tree. Self-balances.
     * @param data The data of the same type to add.
     */
    public void add(T data) {
        Node<T> node = new Node<T>(data);
        if (head == null) head = node;
        else head.addNode(node);
        head = head.balance();
    }

    /**
     * Create a depth-first String representation of the tree.
     * @return the String.
     */
    public String toString() {
        return head.toString();
    }

}
