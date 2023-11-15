package ADTBinarySearchTree;

import java.util.LinkedList;

/**
 * An iterator over a binary search tree
 * 
 * @author Xinyang Zhou
 * @version 1.0
 */
public class TreeIterator<E> implements java.util.Iterator<E> {
    /**
     * The collection traversed by this iterator
     */
    private BaseBinaryTree<E> tree;

    /**
     * An ordered list of nodes traversed by this iterator.
     */
    private LinkedList<TreeNode<E>> list;

    /**
     * Constructs an iterator over a base binary tree.
     * 
     * @param tree A reference to a base binary tree
     */
    public TreeIterator(BaseBinaryTree<E> tree) {
        this.tree = tree;
        this.list = new LinkedList<TreeNode<E>>();
    }

    /**
     * Returns true if the iteration has more elements.
     * 
     * @return If there is an element to be returned
     */
    public boolean hasNext() {
        return !this.list.isEmpty();
    }

    /**
     * Returns the next element in the iteration.
     * 
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    public E next() throws java.util.NoSuchElementException {
        // Retrieves and removes the head of the list then return it.
        // The head reference points to the next of the head.
        return this.list.remove().getElement();
    }

    /**
     * The remove operation is not supported
     * 
     * @throws UnsupportedOperationException if the remove operation is not
     *                                       supported by this iterator
     */
    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    /**
     * Sets the traversal type to be preorder.
     */
    public void setPreorder() {
        this.list.clear();
        this.preorder(this.tree.root);
    }

    /**
     * Sets the traversal type to be inorder.
     */
    public void setInorder() {
        this.list.clear();
        this.inorder(this.tree.root);
    }

    /**
     * Sets the traversal type to be postorder.
     */
    public void setPostorder() {
        this.list.clear();
        this.postorder(this.tree.root);
    }

    /**
     * Traverses in preorder.
     * 
     * @param treeNode A reference to a tree node
     */
    private void preorder(TreeNode<E> treeNode) {
        if (treeNode != null) {
            this.list.add(treeNode);
            preorder(treeNode.getLeft());
            preorder(treeNode.getRight());

        }
    }

    /**
     * Traverses in inorder.
     * 
     * @param treeNode A reference to a tree node
     */
    private void inorder(TreeNode<E> treeNode) {
        if (treeNode != null) {
            inorder(treeNode.getLeft());
            this.list.add(treeNode);
            inorder(treeNode.getRight());
        }
    }

    /**
     * Traverses in postorder.
     * 
     * @param treeNode A reference to a tree node
     */
    private void postorder(TreeNode<E> treeNode) {
        if (treeNode != null) {
            postorder(treeNode.getLeft());
            postorder(treeNode.getRight());
            this.list.add(treeNode);
        }
    }
}