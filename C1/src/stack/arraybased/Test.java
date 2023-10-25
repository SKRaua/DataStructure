package stack.arraybased;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

/**
 * Contains helper methods the array-based ADT list. 
 * @author Qi Wang
 * @version 1.0
 */
public class Test {
	/**
	 * Demonstrates and tests the ADT stack.
	 */
	public static void start() throws FileNotFoundException{
	    //Create a stack of novels
		StackArrayBased stack = new StackArrayBased();
		create(stack);
		
		stack.pop();
		
	    //Display them
		display(stack);
	}
	
	/**
	 * Creates a list of novels.
	 * @param list A reference to a list of data
	 */
	public static void create(StackArrayBased stack) throws FileNotFoundException{
		//Scanner input = new Scanner(new File("./src/data/novels.txt"));
		Scanner input = new Scanner(new File("novels.txt"));
		//Scanner input = new Scanner(new File("./src/novels.txt"));
		while(input.hasNext()){
			stack.push(input.nextLine());
		}
		input.close();
	}
	
	/**
	 * Displays a list of novels in order. 
	 * @param list A reference to a list of data
	 */
	public static void display(StackArrayBased stack){
		System.out.println("The stack has ");
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
}