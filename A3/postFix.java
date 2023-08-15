import java.util.StringTokenizer;
/**
 * 
 * @author Woojin Jang (Student #: 260762536)
 * This code is containing (TA) Katrina Poulin's code 
 *
 */
public class postFix {
	
	//TODO add operators / precedences
	Character[] operators = {'+','-','*','/','^'};
	Integer [] precedences = {2, 2, 3, 3, 4};
	
/**
 * Take in a String entered by user (infix notation)
 * and return a Queue of theses elements, in the same order
 * @param data
 * @author Katrina Poulin
 * @return
 */
	public Queue parse(String data) {
		// if there is an empty space " " then replace it to ""
		data = data.replaceAll("\\s+","");
		Queue Qin = new Queue ();
		StringTokenizer st = new StringTokenizer (data , "+-*/^()", true);
		while (st.hasMoreTokens()) {
			Qin.enqueue(st.nextToken());
		}
		return Qin; 
	}
/**
 * 	take a Qin = tokenized infix expression
 *  and returns Qout = postfix expression
 *  
 * @param Qin
 * @return Qout
 */
	
	public Queue In2Post(Queue Qin) {
		Stack stack = new Stack();
		Queue Qout = new Queue();
		
		String e;
		while ((e = Qin.dequeue()) != null) {
			// 1. check if the element is an operator
			if (isOperator(e)) {
				// 
				String previousOperator = stack.pop();	
				// compare the element to the previous operator on the stack with the precedence
				// if the previous operator has higher precedence
				if (precedence(previousOperator) >= precedence(e)){
					// if (P(top) >= P(e)) enqueue previous to Qout
					Qout.enqueue(previousOperator);
					// push the current operator to the stack
					stack.push(e);
				}
				// else push (top)
				// push e
				else {
					// if the previous operator's precedence is less than the current operator
					// check if there is a previous operator on the stack
					if (previousOperator != null) {
						// push the previous operator to the stack
						stack.push(previousOperator);
					}
					// push the current operator to the stack
					stack.push(e);
				}
				
			}
			// 2. if the element is (
			else if (e.charAt(0)== '(') {
				//push to stack
				stack.push(e);
			}
			// 3. if the element is )
			else if (e.charAt(0)== ')') {
				// pop all stacks and enqueue to Qout until I reach (
				while (!((e = stack.pop()).equals("("))) {
					Qout.enqueue(e);
				}
				// discard the ()
				//  ( still popped but not pushed into Qout
				// already discarded
				
			}
			// 4. if the element is a number
			else {
				Qout.enqueue(e);
			}
		}
		
		// enqueue all the elements to Qout from stack
		String p;
		while ((p = stack.pop())!= null) {
			Qout.enqueue(p); // empty stack and enqueue onto output
			
		}
		
		return Qout;
	}
	
	/**
	 * check if string s is an operator
	 * if it is an operator then return ture
	 * if it is not an operator then return false
	 * @param s
	 * @return true / false
	 */
	public boolean isOperator (String s) {
		int l = operators.length;
		// check if string s is an operator 
		// loop through an operator array
		for (int i = 0; i < l; i++) {
			// if s is an operator then return true
			if (operators[i].toString().equals(s)) {
				return true;
			}
		}
		// s is not an operator then return false
		return false;
	}
	
	/**
	 * if s is an operator, 
	 * must figure out which has a precedence
	 * bigger precedence calculate first
	 * using array index
	 * @param s
	 * @return precedence
	 */
	public int precedence (String s) {
		// index of operator and precedence
		int index = 0;
		//look for the operator in operator array
		for (char e : operators) {
			if (String.valueOf(e).equals(s)) {
				return precedences[index];
			}
			index ++;
		}
		// if e is not in the operator array then return -1
		return -1;
	}
}
