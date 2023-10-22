

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Tests the design of ADT Queue.
 * 
 * @author Qi Wang
 * @version 1.0
 */
public class Test {
	/**
	 * Start testing.
	 * 
	 * @throws FileNotFoundException
	 */
	public static void start() throws FileNotFoundException {
		QueueArrayBased queue = new QueueArrayBased();
		create(queue);
		while (!queue.isEmpty()) {
			System.out.println(queue.dequeue());
		}
	}

	/**
	 * Creates a list of novels.
	 * 
	 * @param list A reference to a queue of data
	 */
	public static void create(QueueArrayBased queue) throws FileNotFoundException {
		Scanner input = new Scanner(new File("novels.txt"));
		while (input.hasNext()) {
			queue.enqueue(input.nextLine());
		}
		input.close();
	}
}
