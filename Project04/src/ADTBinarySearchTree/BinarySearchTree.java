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
     * @param item The element to search(May only have a attribute for comparison)
     * @return The tree node of the item
     */
    public E search(E item) {
        if (isEmpty()) {
            throw new TreeException("Empty tree.");
        } else {
            TreeNode<E> current = root;
            int compareResult;
            // Loop searches until the compareResult between item and current is 0.
            while ((compareResult = item.compareTo(current.getElement())) != 0) {
                // If the compareResult is less than 0, current enters the left subtree,
                // and if it is greater than 0, it enters the right subtree。
                current = (compareResult < 0) ? current.getLeft() : current.getRight();
                if (current == null) {
                    throw new TreeException("There is no " + item + " in the tree.");
                }
            }
            return current.getElement();
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
            TreeNode<E> current = this.root, next = null;
            int compareResult;
            // Searches for the location to add this node.
            // Loop searches until the compareResult between item and current is 0.
            while ((compareResult = item.compareTo(current.getElement())) != 0) {
                // If the compareResult is less than 0, next enters the left subtree,
                // and if it is greater than 0, it enters the right subtree。
                next = compareResult < 0 ? current.getLeft() : current.getRight();
                // Next is null, inserts a new node at this position。
                if (next == null) {
                    if (compareResult < 0) {
                        // If compareResult is less than 0, inserts a node to the left of current.
                        current.setLeft(new TreeNode<E>(item));
                        return;
                    } else {
                        // If compareResult is more than 0, inserts a node to the right of current.
                        current.setRight(new TreeNode<E>(item));
                        return;
                    }
                }
                // The insertion position has not been found yet, current moves to the next.
                current = next;
            }
            // compareResult is 0
            throw new TreeException("This element already exists in the tree");
        }
    }

    /**
     * Deletes the item in the tree
     * 
     * @param item The element to be deleted
     */
    public void delete(E item) {
        if (isEmpty()) {
            throw new TreeException("Empty tree.");
        } else {
            TreeNode<E> current = root, pareant = null;
            int compareResult;
            // Searches for the node that needs to be deleted.
            // Loop searches until the compareResult between item and current is 0.
            while ((compareResult = item.compareTo(current.getElement())) != 0) {
                pareant = current;
                // If the compareResult is less than 0, current enters the left subtree,
                // and if it is greater than 0, it enters the right subtree。
                current = (compareResult < 0) ? current.getLeft() : current.getRight();
                if (current == null) {
                    throw new TreeException("There is no " + item + " in the tree.");
                }
            }
            // Deletes the current code.
            // Number of child nodes = 0 or 1.
            if (current.getLeft() == null || current.getRight() == null) {
                TreeNode<E> successor = current.getLeft() != null ? current.getLeft() : current.getRight();
                if (current == root) {
                    // The deleted node is the root.
                    this.root = successor;
                } else {
                    // The deleted node is a leaf node.
                    if (pareant.getLeft() == current) {
                        // The deleted node is the left node of the parent node.
                        pareant.setLeft(successor);
                    } else {
                        // The deleted node is the right node of the parent node.
                        pareant.setRight(successor);
                    }
                }
            } else {
                // Number of child nodes = 2.
                TreeNode<E> successor = current.getRight();
                // Find the largest node in the right subtree of the deleted node.
                while (successor.getLeft() != null) {
                    successor = successor.getLeft();
                }
                // Deletes the successor node used to replace the current node's element.
                this.delete(successor.getElement());
                // Replaces the current node's element with the successor node's element.
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
        throw new UnsupportedOperationException();
    }
}
