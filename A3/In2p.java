/**
 * infix to postfix conversion
 * using a Qin, Qout, and stack
 * @author Woojin Jang (260762536)
 */


import acm.program.ConsoleProgram;

public class In2p extends ConsoleProgram{
	
	public void run() {
		postFix myPostFix = new postFix();
		String str;

		// 1. welcome message
		println ("Infix to Postfix conversion, enter expression or blank line to exit.");
		// 2. get input from user
		while (true){
			str = readLine ("expr: ");	
			// if a blank line is entered
			if (str.equals("")) {
				break;
			}
			else {
				// 3. parse input
				Queue Qin = myPostFix.parse(str);
				// 4. in2post
				Queue Qout = myPostFix.In2Post(Qin);
				// 5. toString() queue
				// 6. print output to user
				print(str + " ==>"+ Qout.toString());
				println("");
			}
				
		}
		println("Program terminated");
	}
}

