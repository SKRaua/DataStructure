package binarytree;

/**
 * Tests the TreeIterator.
 * 
 * @author Xinyang Zhou
 * @version 1.0
 */
public class Test {

	/**
	 * The main method to test all the methods in TreeIterator class.
	 * 
	 * @param args A reference to an command-line arguments
	 */
	public static void main(String[] args) {
		// Creates a tree.
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		create(tree);

		// Tests the iterator.
		TreeIterator<Integer> iterator = new TreeIterator<Integer>(tree);
		testIterator(iterator);
	}

	/**
	 * Creates a binary tree.
	 * 
	 * @param tree A reference to a binary tree
	 */
	public static void create(BinaryTree<Integer> tree) {
		// Creates two trees and attaches their sub nodes.
		BinaryTree<Integer> tree1 = new BinaryTree<Integer>(2);
		tree1.attachLeft(1);
		tree1.attachRight(3);
		BinaryTree<Integer> tree2 = new BinaryTree<Integer>(6);
		tree2.attachLeft(5);
		tree2.attachRight(7);

		// Creates the tree by attaching two sub trees.
		tree.setRoot(4);
		tree.attachLeftSubtree(tree1);
		tree.attachRightSubtree(tree2);
	}

	/**
	 * Tests the tree iterator.
	 * 
	 * @param iterator A reference to a binary tree iterator
	 */
	public static void testIterator(TreeIterator<Integer> iterator) {
		// Tests the preorder.
		iterator.setPreorder();
		System.out.print("The preorder of the tree: ");
		display(iterator);

		// Tests the inorder.
		iterator.setInorder();
		System.out.print("The inorder of the tree: ");
		display(iterator);

		// Tests the postorder.
		iterator.setPostorder();
		System.out.print("The postorder of the tree: ");
		display(iterator);
	}

	/**
	 * Displays the items in the iterator.
	 * 
	 * @param iterator A reference to a binary tree iterator
	 */
	public static void display(TreeIterator<Integer> iterator) {
		// If the iteration has more elements.
		while (iterator.hasNext()) {
			// Prints the next element in the iteration.
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
	}
}
