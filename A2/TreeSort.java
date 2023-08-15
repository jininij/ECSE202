
/** 
* Woojin Jang (Student #260762536)
*this println sentences are from Assignment 2 description note by professor frank p. ferrie
*/

import java.util.Scanner;

public class TreeSort {

	public static void main(String[] args) {
		// insturction to the program
		System.out.println("Text Sorting Program: (ECSE 202 - Assignment 2)");
		System.out.println("Enter names to be sorted, line by line. A blank line terminates.");
		System.out.println("you can cut and paste text into this window: ");
		// creating a btree
		bTree names = new bTree();
		// using scanner to get the user input
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			
			String print = scanner.nextLine();
			// user inputs empty space it ends the loop
			if (print.equals("")) {
				break;
			}
			names.addNode(print);
		}
		// output inorder
		System.out.println("Text in sort order: \n");
		
		names.displayInOrder(names.root);
		System.out.println("");
		// output reverseinorder
		System.out.println("Text in reverse sort order: \n");
		names.displayInReverseOrder(names.root);
		System.out.println("");
		System.out.println("Program terminated.");
	}
}
