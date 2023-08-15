/**
 * 
 * @author Woojin Jang (Student #: 260762536)
 * 
 */
public class Queue {
/**
 * @author Prof. Frank ferrie
 * this code is from the lecture note
 * 
 */
	listNode head;
	listNode tail;
	
	// enqueue an argument to a queue (to tail)
	public void enqueue (String arg) {
		listNode node = new listNode ();
		// arg is added to the end of the queue
		node.data = arg;
		node.next = null;
		// if queue is not empty, arg become tail
		if (tail != null) {
			tail.next = node;
			tail = tail.next;
		}
		// if queue is empty, then arg become head and tail
		else {
			head = node;
			tail = node;
		}
	}
	// dequeue an argument from a queue (from head)
	public String dequeue() {
		// if queue is not empty
		if (head != null) {
			// if there is only one argument
			if (head == tail) {
				tail = null;
			}
			// if there are several argument
				String e = head.data;
				head = head.next; // second argument become head
				return e; // dequeue the head data
		}
		
		// if queue is empty
		else {
			return null;
			}
	}
		
	/**
	 * make a string with the arguments from the queue
	 * @author Katrina Poulin
	 * this code is from (TA) Katrina poulin
	 * in tutorial class
	 */
	
	public String toString(){
		//dequeue a node
		//add it to output string
		String result = "";
		while (head != null) {
			String data = this.dequeue();
			result = result + " " + data;
		}
		
		return result;
		}
	
	
}
