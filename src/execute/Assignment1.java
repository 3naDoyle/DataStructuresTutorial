/* 
 * Triona Doyle
 *  Question 3 
 *  
 * 				Test Cases:
 * 6 * 4 ( 3 + 2 ) + 7 * 3 / 2     POSTFIX = 6  4  3  2 + * 7  3 * 2/+  RESULT=30.5
* 
 * 4 * 8 + 3 / 2 ( 2 - 4 ) + 3 * 8 / 2  POSTFIX 4  8 * 3  2  2  4 - /+ 3  8 * 2/+  RESULT=14
 * 
* 2 + 6 ( 9 * 8 ) - 4 / 6 + 2 * 3 POSTFIX  2  6  9  8 * + 4  6 /- 2  3*+  RESULT=83.33333333333333
 * 
* 1 + 3 * 6 - 9 + ( 6 * 7 ) - 10 POSTFIX 1  3  6 * + 9 -  6  7 * + 10- RESULT= 42
* 
* website checker http://scriptasylum.com/tutorials/infix_postfix/infix_postfix.html
* 
* 
* * Algorithm:
*  			If STACK operator is HIGHER or equal priority to read operator - POP until we meet LOWER priority operator or left bracket 
*  			: then push read operator to stack
*  			if READ operator HIGHER than stack - push read operator to stack	
*/


package execute;

import java.util.Scanner;

import dataStructures.LinkedStack;
import dataStructures.Stack;


public class Assignment1 {

	private static final LinkedStack<String> String = null;

	public static void main(String[] args) {

		// Print program instructions
		printInstructions();
		
		// Read input expression
		Scanner sc = new Scanner(System.in);
		System.out.print("\nPlease input an infix expression: ");
		String infix = sc.nextLine();
		System.out.println("Infix expression: " + infix);
		
		// Convert to postfix
		String postfix = infixToPostfix(infix);
		System.out.println("Postfix expression: " + postfix);
		
		// Evaluate postfix
		double result = postfixEvaluate(postfix);
		System.out.println("Expression result: " + result);
	}
	
	public static String infixToPostfix(String infix){

		
		String postfix = ""; //output string
		String s;
		//create linked stack
		Stack<String> stk = new LinkedStack<String>();
		
		Scanner sc = new Scanner(infix);
		
		while (sc.hasNext()) {
			s = sc.next();

			if (isNumber(s)) {  //if number - put on outputstring
				System.out.println("Number:" + s);
				postfix=postfix.concat(s+" "); //add number value to output string
		
				System.out.println("postfix variable values "+postfix);
				} //close if
			
			else if (isOperator(s)) { 
				System.out.println("Operator:" + s);
				
					if(stk.isEmpty()==true){ //stack is empty
						stk.push(s);
						System.out.println(s +" has been pushed to empty stack");
					} // close if
					
					else{  // stack is NOT empty
						
						String peekCheck=stk.peek();//check what operator is top of stack 
						System.out.println("Peek Check ="+peekCheck);
							
						if (peekCheck.equals("(")){  // if peek value is left bracket - any read operator can be pushed to stack (on top of it)
						//if( stk.peek().charAt(0)=='('){
								stk.push(s);
								System.out.println("operator pushed to stack - on top of ( ");
						}
							
							//else if (s==")") {  //if read-in is right bracket (assume left bracket already on stack)
						
						else if (s.charAt(0)==')'){
								System.out.println("Right Bracket - pop values untill meet ( left bracket");
								
								
								while( (stk.peek().charAt(0)!='(') && (stk.isEmpty()==false) ){
								System.out.println("after right bracket ");
								
								postfix=postfix.concat(stk.pop()+" ");
								}
								
										if(stk.peek().equals("(") ){
											stk.pop(); //pop left brackek (remove from stack) - but do nothing with it
											System.out.println(" ( popped coz in if statement");
										} 
									
						 }//close else if
													
							//if read value is HIGH or equal priority - pop until peek priority is low
						
						else if ( (s.equals("*")||s.equals("/")||s.equals("%")) && ( peekCheck.equals("*")||peekCheck.equals("/")||peekCheck.equals("%")) ) {
								System.out.println("ELSE IF -> High priority in equation - High to be popped from stack");
								
								//pop while equal or higher priority && stack not empty
								while( (stk.peek().charAt(0)=='*'|| stk.peek().charAt(0)=='/'|| stk.peek().charAt(0)=='%') && (stk.isEmpty()==false)){
									System.out.println("equal */% type operator will be POPPED from stack");
									String poppedValue = stk.pop();
									System.out.println("Actual value popped is : "+poppedValue);
									postfix=postfix.concat(poppedValue+" ");		//pop-value from stack and add to outputstring
								
								}
								
								stk.push(s);  //push infix expression value onto stack
								
							}
							
							// if expression value and peek value are equal priority  (both low)
						 else if ( (s.equals("+")||s.equals("-")) && (peekCheck.equals("+")|| peekCheck.equals("-")) ){
								
								//pop while peek values are equal to peek value
								while((peekCheck.equals("+")||peekCheck.equals("-") ) && (stk.isEmpty()==false)){
								postfix=postfix.concat(stk.pop()+" ");		//pop-value from stack and add to output-string
								System.out.println("equal + or - type operator POPPED from stack");
								} 
								
								stk.push(s); //push read value onto stack
								
						  }
							
							//if expression operator is lower priority than what's on stack - 
							else if ( (s.equals("+") || s.equals("-"))  && 
									 (peekCheck.equals("*") || peekCheck.equals("/") || peekCheck.equals("%")) ){ //if read operator is lower than operator on stack
									
									
								//Pop while stack values are of greater or equal priority to expression-operator
								while (  (!peekCheck.equals("(")) && (stk.isEmpty()==false)) {
										postfix=postfix.concat(stk.pop()+" "); //pop and add to output string
										System.out.println("popped and concated higher priority */%  from stack");
								}
								stk.push(s); //push expression operator to stack
 
							}
							
							else if (   ( s.equals("*") || s.equals("/") || s.equals("%") )   &&		//if read operator is higherer priority than stack-push read value to stack
									( peekCheck.equals("+") || peekCheck.equals("-"))  ) {
									
									stk.push(s);  //push to stack
									System.out.println(s+ "operator has been PUSHED to stack");
									
							}
							
							else if ( s.equals("(") ){  //left bracket
									
									stk.push(s);
									System.out.println(" ( left bracket pushed to stack");
							}
							
							
							
					
					}//close else (if operator)
					
			}//close if else
									
		
			else {
				System.out.println("Invalid expression");
				System.exit(1);
			}
			
			
		} //close while loop
		
		
	while(stk.isEmpty()==false){
		
		System.out.println("POPing reaming values from stack ->");
			
		if(stk.peek().charAt(0)!='('){
			
			postfix=postfix.concat(stk.pop()+" ");
		}
		
		else{
			
			stk.pop(); 	// pop bracket but do not concat
			System.out.println("Bracket popped from reamining stack but not written ");
		}
	}
		
	
		return postfix;
	}
	
	public static double postfixEvaluate(String postfix){
		
		double result = 0;
		Scanner sc = new Scanner(postfix);
		//create stack
		Stack<String> stk2 = new LinkedStack<String>();
		
		double dCalc=0;
		
		while (sc.hasNext()){
			String s2=sc.next(); // s2 will contain next value of postfix expression
			
			//check if next value in postfix if OPERATOR or NUMBER
			if (isNumber(s2)){
				System.out.println("IS number "+s2);
				stk2.push(s2);
				System.out.println("number PUSHED to stack ");
				
			}//close if
			
			else if (isOperator(s2)) {
				System.out.println("IS operator ! "+s2);
				
				double val1=Double.parseDouble(stk2.pop());  //pop and parse to double
				double val2=Double.parseDouble(stk2.pop());   //pop and parse to double		
				System.out.println(" 2 values popped from stack "+val1+" and "+val2);
			
				if(s2.equals("*")){
					
					dCalc=val1*val2; //perform calculation
					System.out.println(" values multiplied ");
					
				}//close if
				
				else if (s2.equals("/")){
					
					dCalc=val2/val1;
					System.out.println(" values divided ");
					
				}// close elseif1
				
				else if (s2.equals("-")){
					
					dCalc=val2-val1;
					System.out.println(" values subtracted ");				
				}//close elseif2
				
				else if (s2.equals("+")){
					
					dCalc=val1+val2;
					System.out.println(" values added ");					
				}//close elseif3
				
				else if (s2.equals("%")){
					
					dCalc=val1%val2;
					System.out.println(" values MOD-ed ");	
				}
				
				
				stk2.push(Double.toString(dCalc)); //parse calculation back to String and push to stack			
				System.out.println("Peek to check calc on TOP of STACK "+stk2.peek());
		
		  }//close else if(operator)
			
		}// close outter while (exits when no values left in postfix expression)
		
		
		result=Double.parseDouble(stk2.pop()); // pop result from stack and parse to double
		System.out.println("Pop Result Value ");
		return result;
		
	}

	public static void printInstructions() {
		System.out
				.println("This program takes an infix expression and first converts "
						+ "it to an equivalent \npostfix expression and then evaluates "
						+ "the resulting postfix expression");
		System.out
				.println("\nInput is an infix expression that uses spaces to "
						+ "delimit the tokens in the expression");
		System.out.println("\nFor example:");
		System.out
				.println("-2 + ( 4 * 5 ) / 2 - 4 is a valid infix expression");
		System.out.println("-2+(4*5)/2-4 is invalid");
	}

	/*
	 * Determines if the given String can be interpreted as a numeric value
	 */
	public static boolean isNumber(String s) {

		Scanner sc = new Scanner(s);

		if (sc.hasNextInt() || sc.hasNextDouble()) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * Determines if the given String can be interpreted as a mathematical
	 * operator
	 * 
	 * For the purposes of this program an operator can be one of: +, -, *, /,
	 * %, (, )
	 */
	public static boolean isOperator(String s) {
		boolean op = false;

		if (s.length() > 1) {
			op = false;
		} else {
			char c = s.charAt(0);
			if (c == '+' || c == '-' || c == '*' || c == '/' || c == '%'
					|| c == '(' || c == ')') {
				op = true;
			}
		}

		return op;
	}
}