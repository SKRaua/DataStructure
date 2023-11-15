package ADTBinarySearchTree;

/**
 * A base binary tree
 * 
 * @author Xinyang Zhou
 * @version 1.0
 */
public abstract class BaseBinaryTree<E> {
    /**
     * The root of this tree
     */
    protected TreeNode<E> root;

    /**
     * Creates an empty binary tree.
     */
    public BaseBinaryTree() {
        this.root = null;
    }

    /**
     * Creates a one-node binary tree whose root contains a root item.
     * 
     * @param rootItem The item of the root
     */
    public BaseBinaryTree(E rootItem) {
        this.root = new TreeNode<E>(rootItem, null, null);
    }

    /**
     * Returns is the tree is empty.
     * 
     * @return Is the tree is empty
     */
    public boolean isEmpty() {
        return this.root == null;
    }

    /**
     * Removes all nodes from the tree.
     */
    public void makeEmpty() {
        this.root = null;
    }

    /**
     * Returns the element of the tree's root.
     * 
     * @return A reference to the element of the root
     * @throws TreeException if the tree is empty
     */
    public E getRoot() throws TreeException {
        if (this.root == null) {
            throw new TreeException("Empty tree");
        } else {
            return this.root.getElement();
        }
    }

    /**
     * Changes the root element of this binary tree.
     * 
     * @param newItem A reference to the new root
     * @throws UnsupportedOperationException if operation is not supported.
     */
    public abstract void setRoot(E newItem) throws UnsupportedOperationException;
}
