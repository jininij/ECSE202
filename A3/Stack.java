/**
 * 
 * @author Woojin Jang (Stduent # : 260762536)
 *
 */
public class Stack {
	/**
	 * @author Prof. Frank ferrie 
	 * this code is from lecture note
	 * 
	 */
	listNode top;

	// push argument into top of the stack
	public void push(String arg) {
		// push argument into a stack
		listNode node = new listNode();
		node.data = arg;
		node.next = top;
		top = node;
	}

	// pop the top argument from the stack
	public String pop() {

		// if there is no argument in the stack
		if (top == null) {
			return null;
		}
		// if there is argument on top of the stack
		// pop the argument and replace top with the next argument from the stack
		else {
			String data = top.data;
			top = top.next;
			return data;
		}
	}
}
