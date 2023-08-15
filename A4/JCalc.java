/**
 * @author Woojin Jang (Student #: 260762536)
 * 
 */
import acm.program.ConsoleProgram;

/**
 * @author Prof. Frank ferri
 * this code is from the Assignment 4 description by Prof. Frank Perri.
 */

public class JCalc extends ConsoleProgram{
	postFix pf = new postFix();
	
	public void run() {
		println("Infix to Postfix conversion, enter expression of blank line to exit.");
		while (true) {
			String input = readLine("expr: ");
			if (input.equals("")) {
				break;
			}
			// parse input postfix string into a Queue Qin
			Queue Qin = pf.parse(input);
			// Qin to Qout according to In2Post method
			// number are directly into the Qout
			// operators and () are goes into stack then Qout
			Queue Qout = pf.In2Post(Qin); 
			// use toString method to store the order in Qout
			// into String
			String postString = Qout.toString(); 
			println(input+" => "+postString);
			// calculate the Qout, the result will be assigned to eval
			double eval = pf.PostEval(Qout); 
			println(postString+" evaluates to "+eval);
			}
		println("Program terminated."); 
		}
}
