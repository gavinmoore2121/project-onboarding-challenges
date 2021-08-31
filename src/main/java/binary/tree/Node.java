package binary.tree;

public class Node<T extends Comparable<T>> {
    T data;
    Node<T> left;
    Node<T> right;

    Node(T data) {
        left = null;
        right = null;
        this.data = data;
    }

    /**
     * Determine whether to add the node to the left or right child, then add it appropriately.
     * If a node on the respective position already exists, recursively call addNode on the child.
     * @param node The node to add.
     */
    void addNode(Node<T> node) {
        if (this.data.compareTo(node.getData()) > 0) {
            // Add smaller values to left child.
            if (this.left == null) left = node;
            else left.addNode(node);
            left = left.balance();
        }
        else {
            // Add greater or duplicate values to right child.
            if (this.right == null) right = node;
            else right.addNode(node);
            right = right.balance();
        }
    }

    /**
     * Rebalance tree and return new head.
     * @return new head.
     */
    Node<T> balance() {
        int balanceFactor = this.getBalanceFactor();
        if (balanceFactor > 1) {
            System.out.println("I should rotate right.");
            if (left.getBalanceFactor() == 1) { // Straight right rotation
                Node<T> newHead = left;
                left = left.getRight();
                newHead.setRight(this);
                return newHead;
            }
            else { // Left-Right rotation
                left.getRight().setLeft(left);
                left = left.getRight();
                left.getLeft().setRight(null);
                Node<T> newHead = left;
                left = left.getRight();
                newHead.setRight(this);
                return newHead;
            }
        }
        else if (balanceFactor < -1) {
            if (right.getBalanceFactor() == 1) { // Right-Left rotation
                right.getLeft().setRight(right);
                right = right.getLeft();
                right.getRight().setLeft(null);
                Node<T> newHead = right;
                right = right.getLeft();
                newHead.setLeft(this);
                return newHead;
            }
            else { // Straight Left rotation
                Node<T> newHead = right;
                right = right.getLeft();
                newHead.setLeft(this);
                return newHead;
            }
        }
        return this;
    }

    /**
     * Calculate and return the AVL balance factor of the node.
     * Absolute values greater than 1 indicate an unbalanced tree, with positives indicating the left
     * side has a larger height and negatives indicating the right side has a higher height.
     * @return The AVL balance factor.
     */
    int getBalanceFactor() {
        return height(left) - height(right);
    }

    /**
     * Calculate and return the height of the target node, where the height is equal to the number of children + 1.
     * @param node: The node to find the height of.
     * @return The height of the node, or 0 if the node is null.
     */
    int height(Node<T> node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public String toString() {
        return this.data.toString() + " "
                + (left==null ? "null" : left.toString()) + " "
                + (right==null ? "null" : right.toString());
    }


    /**
     * Setters and getters.
     */
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }
}
