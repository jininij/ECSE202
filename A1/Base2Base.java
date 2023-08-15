
// Name: Woojin Jang (student ID: 260762536 )

import acm.program.ConsoleProgram;

// this code contains the template provided by Prof. ferrie
public class Base2Base extends ConsoleProgram {

	public void run() {

		while (true) {
			String input = readLine("input: ");
			if (input.equals("") || input.charAt(0) == '-')
				break;
			int inBase = readInt("input base: ");
			if (inBase < 2 || inBase > 16)
				break;
			int outBase = readInt("output base: ");
			if (outBase < 2 || outBase > 16)
				break;

			// need a String2Int method here
			int inVal = String2Int(input, inBase);
			if (inVal < 0) {
				println("Input inconsistent with base. Try again or exit program with blank line.");
			}

			// need a Int2String method here
			else {
				String outString = Int2String(inVal, outBase);
				// Display the output
				println(input + " has decimal value " + inVal + ".");
				println(input + " expressed in Base " + outBase + " = " + outString + ".");
				println();
			}
		}
		println("Program terminated.");
	}

	// this code is from TA Katrina Poulin in tutorial class
	// [visibility][returnType = output][Name](arguments)
	// Convert from char code to integer
	static int Char2Int(char c) {
		// 3cases
		int x = 0;

		// case 1 : c is a digit
		if ('0' <= c && c <= '9') {
			x = c - '0';
		}
		// case 2 : c is a LC letter
		else if ('a' <= c && c <= 'f') {
			x = c - 'a' + 10;
		}
		// case 3 : c is a UC letter
		else if ('A' <= c && c <= 'F') {
			x = c - 'A' + 10;

		} else {
			x = -1; // it tells you that your input is invalid

		}
		return x; // output is zero

	}

	// check if the input is valid

	// this code contains the template provided by Prof. ferrie
	// some of this code is from maddler in website geeksforgeeks
	// this code is a String to integer method
	private int String2Int(String input, int inBase) {
		// init
		// let sum= 0
		int sum = 0;
		// length of the input number
		int l = input.length();
		// power of the base
		int p = 1;

		// decimal equivalent is str [length - 1] + str [length -2 ]* base + str [lenth
		// - 3] * (base)^2 + ...
		// For index = length of string - 1 to 0 by -1
		for (int i = l - 1; i >= 0; i--) {
			// Get character at index position
			if (Char2Int(input.charAt(i)) >= inBase) {
				println("Invalid input number");
				return -1;
			}
			// Add to sum multiply by power
			sum += Char2Int(input.charAt(i)) * p;
			// Multiply power by inBase
			p *= inBase;
			// End for
		}
		// return sum
		return sum;
	}

	// this code contains the template provided by Prof. ferrie
	// this code is a integer to String method
	private String Int2String(int Val, int outBase) {
		String out = "";
		int current = 0;
		while (Val > 0) {
			current = Val % outBase;
			Val = Val / outBase;

			if (current < 10) {
				out = (char) (current + '0') + out;
			} else {
				out = (char) (current - 10 + 'a') + out;
			}
			// out = current + out;
		}

		return out;
	}
}
