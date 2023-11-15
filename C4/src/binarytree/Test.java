package module04.chapter21.trees.binarytree;

/**
 * Tests the design of ADT binary tree. 
 * @author Qi Wang
 * @version 1.0
 */
public class Test {
	/**
	 * Builds a sample binary tree. 
	 * 			60
	 *         /   \
	 * 		20 		70
	 *    /   \
	 * 	10 		40
	 *        /   \
	 * 		30 		50
	 * @param args A reference to an command-line arguments
	 */
	public static void start() {
		 //Note: This method can be decomposed. 
		 BinaryTree<Integer> tree, tree1, tree2, tree3, leftTree;
		 TreeIterator<Integer> iterator, leftIterator;
		 
		  //Build the tree from leaves to root
		  tree1 = new BinaryTree<Integer>();
		  
		  tree1.setRoot(40);
		  tree1.attachLeft(30);
		  tree1.attachRight(50);

		  tree2 = new BinaryTree<Integer>();
		  tree2.setRoot(20);
		  tree2.attachLeft(10);
		  tree2.attachRightSubtree(tree1);

		  tree3 = new BinaryTree<Integer>(70);
		  tree =  new BinaryTree<Integer>(60, tree2, tree3);

		  //Traverse inorder
		  iterator = new TreeIterator<Integer>(tree);
		  iterator.setInorder();
		  System.out.println("Inorder traversal");
		  while(iterator.hasNext()){
			  System.out.print(iterator.next() + " ");
			  
		  }
		  System.out.println();
		  // iterate through the left subtree in preorder
		  leftTree = tree.detachLeftSubtree();
		  leftIterator = new TreeIterator<Integer>(leftTree);
          leftIterator.setPreorder();System.out.println("Preorder traversal");
		  while(leftIterator.hasNext()){
			  System.out.print(leftIterator.next() + " ");
		  }
		}
	
	}
