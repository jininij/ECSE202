/**
 * @author Woojin Jang (Student #: 260762536)
 * this code contains Katrina Poulin's code from the tutorial
 * this code contains Prof. Frank Perri's code from the assignment 4 description
 */
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JTextField;

import acm.gui.TableLayout;
import acm.program.Program;

/**
 * this code is from the tutorial 7 & 8 by TA Katrina Poulin
 * @author Katrina Poulin (TA)
 * 
 */

public class JCalcGUI extends Program{

	
	// JButton
	// JTextField
	JTextField expression = new JTextField("");
	JTextField result = new JTextField("");
	postFix pf = new postFix();
	
	
	/**
	 * this code is from the tutorial 7 & 8 by TA Katrina Poulin
	 * @author Katrina Poulin (TA)
	 * 
	 */
	public static void main (String[] args) {
		new JCalcGUI().start(args);
		// create JcalcGUI object / instance
	}
	
	/**
	 * this code is from the tutorial 7 & 8 by TA Katrina Poulin
	 * @author Katrina Poulin (TA)
	 * 
	 */
	// initailization (adding buttons, welcome messages..)
	public void init() {
		this.resize(300,300);
		createInterface();
		addActionListeners(); //listen for button presses
		
		expression.addActionListener(this);
		expression.setActionCommand("expression"); // when we enter on the keyboard
	}
	
	// GUI action when button pressed.
	public void actionPerformed( ActionEvent e) {
		String command = e.getActionCommand(); //"Quit"
		
		// switch case with value
		switch (command) {
		// quit button -> close the java applet
		case "Quit":
			// close program
			System.exit(ABORT);
			break;
		case "C":
			// clear the expression text field
			expression.setText("");
			// clear the result text field
			result.setText("");
			break;
		case "=":
			if (!expression.getText().contains("=")) {
				// answer in result text field
				computeResult();
				addToExpression(command);
			}
			break;
		// this is when we use enter in keyboard
		case "expression":
			if (!expression.getText().contains("=")) {
				// answer in result text field
				computeResult();
				addToExpression("=");
			}
			break;
		case "x": //  because x is not an * in this case
			addToExpression("*");
			break;
		default: // inputs are going to be stored in an expressionvalue string
			addToExpression(command);
		}
	}
	// input string to result double value
	public void computeResult () {
		// get input expression and assign it to string
		String input = expression.getText();
		// parse input string to Qin
		Queue Qin = pf.parse (input); 
		// in2post Qin to Qout order
		Queue pfResult = pf.In2Post (Qin); 
		// calculate the result from Qout
		double eval = pf.PostEval(pfResult);
		// double value to string
		result.setText(Double.toString(eval));
	}
	
	
	// when we press = 
	public void addToExpression(String s) {
		String expr = expression.getText();
		expr += s;
		expression.setText(expr);
	}
	
	 // Add all buttons and fields to layout.
	public void createInterface() {
		setLayout(new TableLayout (9,4)); // 9 rows and 4 columns
		// add fields
		add(expression, "gridwidth = 4"); // gridwidth 4 is merge 4 columns together.
		add(result, "gridwidth = 4");
		// first row
		add (new JButton ("C"),"width=75");
		add (new JButton (""),"width=75");
		add (new JButton (""),"width=75");
		add (new JButton ("/"),"width=75");
		// second row
		add (new JButton ("7"),"width=75");
		add (new JButton ("8"),"width=75");
		add (new JButton ("9"),"width=75");
		add (new JButton ("x"),"width=75");
		// third row
		add (new JButton ("4"),"width=75");
		add (new JButton ("5"),"width=75");
		add (new JButton ("6"),"width=75");
		add (new JButton ("-"),"width=75");
		// forth row
		add (new JButton ("1"),"width=75");
		add (new JButton ("2"),"width=75");
		add (new JButton ("3"),"width=75");
		add (new JButton ("+"),"width=75");
		// fifth row
		add (new JButton ("0"),"width=75");
		add (new JButton ("."),"width=75");
		add (new JButton (""),"width=75");
		add (new JButton ("="),"width=75");
		// sixth row
		add (new JButton ("("),"width=75");
		add (new JButton (")"),"width=75");
		add (new JButton (""),"width=75");
		add (new JButton (""),"width=75");
		// seventh row
		add (new JButton (""),"width=75");
		add (new JButton (""),"width=75");
		add (new JButton (""),"width=75");
		add (new JButton ("Quit"),"width=75");
		
		setBackground(Color.blue);
		
				
	}

}
