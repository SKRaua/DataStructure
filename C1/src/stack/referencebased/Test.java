package stack.referencebased;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

/**
 * Contains helper methods of the reference-based stack. 
 * @author Qi Wang
 * @version 1.0
 */
public class Test {
	/**
	 * Demonstrates and tests the ADT stack.
	 */
	public static void start() throws FileNotFoundException{
	    //Create a stack of novels
		StackReferenceBased<String> stack = new StackReferenceBased<String>();
		fillList(stack);
		
	    //Display them
		displayList(stack);
		
	}
	
	/**
	 * Creates a list of novels.
	 * @param list A reference to a list of data
	 */
	public static void fillList(StackReferenceBased<String> stack) throws FileNotFoundException{
		Scanner input = new Scanner(new File("novels.txt"));
		while(input.hasNext()){
			stack.push(input.nextLine());
		}
		input.close();
	}
	
	/**
	 * Displays a list of novels in order. 
	 * @param list A reference to a list of data
	 */
	public static void displayList(StackReferenceBased<String> stack){
		while (!stack.isEmpty()) {
			  System.out.println(stack.pop());
		}
		
		//How to display items without popping them?
	}
}