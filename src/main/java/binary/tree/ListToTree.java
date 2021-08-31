package binary.tree;

import java.util.Arrays;
import java.util.List;

public class ListToTree {

    public static void main(String[] args) {
        // Sample data
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 11, 13, 15, 17, 19);
        AVLTree<Integer> tree = ListToTree.toTree(list);
        // Prints out a depth-first representation of the tree.
        System.out.println(tree);
    }

    /**
     * Convert a list of data into an AVL Tree and return it. The data must implement the Comparable class.
     * @param list: The list of data to convert.
     * @param <T>: The data type of the list, which must extend Comparable.
     * @return A balanced AVL tree containing all data.
     */
    public static <T extends Comparable<T>> AVLTree<T> toTree (List<T> list) {
        AVLTree<T> tree = new AVLTree<>();
        for (T data: list) {
            tree.add(data);
        }
        return tree;
    }
}
