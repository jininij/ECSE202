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
 *  this code contains Katrina poulin's code
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
				
				while(true) {
					String previousOperator = stack.pop();	
					// check if there is a previous operator on the stack
					if(previousOperator != null) {
				
						// compare the element to the previous operator on the stack with the precedence
						// if the previous operator has higher precedence
						if (precedence(previousOperator) >= precedence(e)){
							// if (P(top) >= P(e)) enqueue previous to Qout
							Qout.enqueue(previousOperator);
						}
						// else push (top)
						// push e
						else {
							// if the previous operator's precedence is less than the current operator
							// push the previous operator to the stack
							stack.push(previousOperator);
							break;
						}
					}else { 
					// if top is null, break;
					break;
				}
				}
				// push the current operator to the stack
				stack.push(e);
				
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
	 * from Qout we put all the operands to the stack
	 * and when we encounter operator we pop two operands from the stack and calculate them.
	 * then put the answer to the stack until there is only one value in the stack.
	 * @author Katrina Poulin (TA)
	 * @param Qout
	 * @return Double result
	 */
	public double PostEval (Queue Qout) {
		Stack postEvalStack = new Stack(); // stack to push/pop operands
		Double result;
		
		while (Qout.head != null) { // until queue is empty
			 String e = Qout.dequeue();
			 // what to do with element
			 if (isOperator(e)) {
				 // pop 2 operands A and B
				 String elA = postEvalStack.pop(); // element A
				 String elB = postEvalStack.pop(); // element B
				 
				 // change string to double
				 Double A = Double.parseDouble(elA);
				 Double B = Double.parseDouble(elB);
				 
				 // perform operation B [op] A
				 switch (e) {
				 case "+":
					 result = B + A;
					 break;
				 case "-":
					 result = B - A;
					 break;
				 case "*":
					 result = B * A;
					 break;
				 case "/":
					 result = B / A;
					 break;
				 default:
					 result = 0.0;
				 }
				 postEvalStack.push(Double.toString(result)); 
				 
			 }else {
				 // push element to stack
				 postEvalStack.push(e);
			 } 
		}
		// at this point there is only 1 element on the stack; the result
		String r = postEvalStack.pop();
		return Double.parseDouble(r);
	} 
	
	/**
	 * check if string s is an operator
	 * if it is an operator then return true
	 * if it is not an operator then return false
	 * @author Woojin Jang
	 * @param s
	 * @return true / false
	 */
	public boolean isOperator (String s) {
		int l = operators.length;
		// check if string s is an operator 
		// loop through an operator array
		for (int i = 0; i < l; i++) {
			// if s is an operator then return true
			if (operators[i]==s.charAt(0)) {
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
	 * @author Woojin Jang
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
