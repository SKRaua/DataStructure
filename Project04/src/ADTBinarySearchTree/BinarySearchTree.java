package ADTBinarySearchTree;

/**
 * A binary search tree
 * 
 * @author Xinyang Zhou
 * @version 1.0
 */
public class BinarySearchTree<E extends Comparable<E>> extends BaseBinaryTree<E> {
    /**
     * Creates an empty binary tree.
     */
    public BinarySearchTree() {
        super();
    }

    /**
     * Creates a one node binary tree.
     * 
     * @param rootItem The root of this tree
     */
    public BinarySearchTree(E rootItem) {
        super(rootItem);
    }

    /**
     * Creates a binary tree with root.
     * 
     * @param rootNode A reference to a node
     */
    protected BinarySearchTree(TreeNode<E> rootNode) {
        this.root = rootNode;
    }

    /**
     * Searches the item in the tree
     * 
     * @param item The element to search
     * @return Is this element present in the tree.
     */
    public boolean search(E item) {
        if (isEmpty()) {
            return false;
        } else {
            TreeNode<E> current = root;
            int compareResult;
            // Loop searches until the compareResult between item and current is 0.
            while ((compareResult = item.compareTo(current.getElement())) != 0) {
                // If the compareResult is less than 0, current enters the left subtree,
                // and if it is greater than 0, it enters the right subtree。
                current = (compareResult < 0) ? current.getLeft() : current.getRight();
                if (current == null) {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * Inserts the item into the tree
     * 
     * @param item The element to into
     */
    public void insert(E item) {
        if (isEmpty()) {
            this.root = new TreeNode<E>(item);
        } else {
            TreeNode<E> current = this.root, parent = null;
            int compareResult = 0;

            // Searches for the location to add this node.
            while (current != null) {
                // Compare result between the item to insert and the current element
                compareResult = item.compareTo(current.getElement());
                if (compareResult == 0) {
                    throw new TreeException("This element already exists in the tree");
                }

                // Updates the parent node and the current node.
                parent = current;
                current = (compareResult < 0) ? current.getLeft() : current.getRight();
            }

            // Inserts the new node.
            TreeNode<E> newNode = new TreeNode<>(item);
            if (compareResult < 0) {
                parent.setLeft(newNode);
            } else {
                parent.setRight(newNode);
            }
        }
    }

    /**
     * Deletes the item in the tree
     * 
     * @param item The element to be deleted
     */
    public void delete(E item) {
        if (isEmpty()) {
            throw new TreeException("Cannot delete from an empty tree.");
        } else {
            TreeNode<E> current = root, parent = null;
            int compareResult;

            // Searches for the node that needs to be deleted.
            // Loop searches until the compareResult between item and current is 0.
            while ((compareResult = item.compareTo(current.getElement())) != 0) {
                // Updates the parent node and the current node.
                parent = current;
                current = (compareResult < 0) ? current.getLeft() : current.getRight();
                if (current == null) {
                    throw new TreeException("There is no " + item + " in the tree.");
                }
            }

            // Deletes the current code.
            if (current.getLeft() == null || current.getRight() == null) {
                // Child nodes number of the deleted node = 0 or 1.

                // Gets a successor node to replace the deleted node.
                TreeNode<E> successor = current.getLeft() != null ? current.getLeft() : current.getRight();
                if (current == root) {
                    // The deleted node is the root, replaces it.
                    this.root = successor;
                } else {
                    // Replaces the child node of the parent node.
                    if (parent.getLeft() == current) {
                        parent.setLeft(successor);
                    } else {
                        parent.setRight(successor);
                    }
                }
            } else {
                // Child nodes number of the deleted node = 2.

                // Finds a successor node to replace the deleted node.
                // Finds The maximum node in the right subtree
                TreeNode<E> successor = current.getRight();
                while (successor.getLeft() != null) {
                    successor = successor.getLeft();
                }
                // Deletes the successor node and replace the current node's element.
                this.delete(successor.getElement());
                current.setElement(successor.getElement());
            }
        }
    }

    /**
     * Constructs and return an iterator of this tree.
     * 
     * @return An iterator of this tree
     */
    public TreeIterator<E> iterator() {
        return new TreeIterator<E>(this);
    }

    /**
     * Changes the root element of this binary tree.
     * 
     * @param newItem A reference to the new root
     * @throws UnsupportedOperationException if operation is not supported.
     */
    public void setRoot(E newItem) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Binary search trees do not support directly changing the root node");
    }
}