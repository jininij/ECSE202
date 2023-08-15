/** Woojin Jang (Student #260762536)
* this code is from lecture note created by professor frank p. ferrie
*/
public class bTree {

	bNode root;
	
	// bNode nested class 
	class bNode {
		String data;
		bNode left, right;
		
		// constructor of bNode
		public bNode(String data) {
			this.data = data;
		}
	}
	
	/** this code is from lecture note created by professor frank p. ferrie
	 */
	public void addNode(String data) {
		bNode current;
		// empty tree
		if (root == null) {
			this.root = new bNode(data);
		} 
		// not empty
		else {
			current = this.root;
			while (true) {
				// the return value is negative 
				// which means the name (data) comes first compare to the root
				if (keyCompareToIgnoreCase(data, current.data) < 0) {
					// left pointer is empty
					if (current.left == null) {
						current.left = new bNode(data);
						break;
					} 
					// left pointer is not empty
					else {
						current = current.left;
					}
				} 
				else {
					// right pointer is empty
					if (current.right == null) {
						current.right = new bNode(data);
						break;
					}
					// right pointer is not empty
					else {
						current = current.right;
					}
				}
			}
		}
	}

	/**
	 *  this code is from lecture note by professor frank p. ferrie
	 */
	// inorder left root right
	public void displayInOrder(bNode current) {
		// try catch is from geeks&geeks website
		try {
			if (current.left != null)
				displayInOrder(current.left);
			System.out.println(current.data);
			if (current.right != null)
				displayInOrder(current.right);
		}
		// if there is no input it's nullpointerexception
		catch (NullPointerException e) {
			System.out.println("NullPointerException");
		}
		
	}

	/**
	 *  this code is from lecture note by professor frank p. ferrie
	 */
	// reverse inorder right root left
	public void displayInReverseOrder(bNode current) {
		try {
			if (current.right != null)
				displayInReverseOrder(current.right);
			System.out.println(current.data);
			if (current.left != null)
				displayInReverseOrder(current.left);
		}
		// if there is no input it's nullpointerexception
		catch(NullPointerException e) {
			System.out.println("NullPointerException");
		}
	}
	/**
	 *  this code is provided by Katrina Pouline 
	 */
	// compare 2 last name to compare
	public int keyCompareToIgnoreCase(String name1, String name2) {
		// getting an empty index before last name
		int lastIndex1 = name1.lastIndexOf(" ");
		int lastIndex2 = name2.lastIndexOf(" ");
		// put last name index to last name
		// lastIndex contains a space, to ignore that need to add 1
		String lastName1 = name1.substring(lastIndex1 + 1); 
		String lastName2 = name2.substring(lastIndex2 + 1);
		// return if the lastName 2 goes to left (<0) or right (>0)
		return lastName1.compareToIgnoreCase(lastName2);
	}
}
