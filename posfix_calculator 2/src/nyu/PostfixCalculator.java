package nyu;
import java.util.*;

public class PostfixCalculator {
	
	public static double calculator(String postfix) {
		
		char[] arr = postfix.toCharArray(); //turn postfix String expression to char array
		FArrayStack st = new FArrayStack(arr.length); // initialize st– an Float Array Stack 
		//where I will be storing the numbers of the postfix expression and performing operations on them
		
		for(int i = 0; i < arr.length; i++) { // For loop to parse through charr array of postfix exp
			char c = arr[i]; // assign variable to simplify
			
			String n = ""; // Initialize string n where I will be appending digits of a full number
			
			if(Character.isDigit(c)) { // check if character the loop is looking at is a digit
				n += arr[i]; // append it to String n
	            
	            for (int j = i + 1; j < arr.length; ++j) { // loop to check if characters next to this number are also digits that form a number
	                if (Character.isDigit(arr[j])) {
	                    n += arr[j]; // append any digits to n
	                    i = j;
	                } else {
	                    break;
	                }
	                
	            }
	            //By now we have checked if a number has multiple digits 
	            //and appended all of them to n
	            
	            st.push(Float.parseFloat(n));  //Turn n from String to FLoat and push it into st since it only accepts Float values
	            
	           
			}
			// check if character the loop is looking at is a an operator 
			else if (c == '*' || c == '/' || 
	                   c == '+' || c == '^' || 
	                   c == '-'){
				float num2 = st.pop() ; // top number is stored in num2 and it is popped off the stack
				float num1 = st.pop() ; // top number is stored in num1 and it is popped off the stack
				
				 
				
				switch(c) { // check which of the operators this character is, perform the respective operation and push the number back into the stack
				
				case '+':  
					st.push(num1+num2);
					break;
				case '-':  
					st.push(num1-num2);
					break;
				case '*':  
					st.push(num1*num2 );
					break;
				case '/':  
					if(num2!=0) {st.push(num1 / num2);} // make sure denom is not 0
					else {throw new ArithmeticException("Cannot divide by 0!");} // if it is, throw exception to warn user with message
				
					break;
				case '^':  
					float pow = (float) Math.pow(num1, num2);
					st.push(pow);
					break;
				
				}
				
			}
			
			
				
				
			}
			

		return  st.pop(); // after all operations have been done, there will only be one element in the top of the stack. Pop it off, this is the answer.
		
	}
	
	public static void main(String[] args) throws InvalidInputException{
		Scanner scn = new Scanner(System.in); // instantiate scanner object
		System.out.println("type your infix expression: "); 
		String infix = scn.nextLine(); // store user answer as String
		
		if(infix.equals("")) {throw new InvalidInputException();} // Check if string is empty, if so throw exception. If not, instantiate object with non-empty string.
		
		else {
		Converter con = new Converter(infix); // instantiate Converter object
		
		

		System.out.println("converted to postfix: " + con.toPostfix()); // call toPostix method in Converter class and print out the String that is returned 
		System.out.println(String.format("answer is %.1f ", calculator(con.toPostfix()))); //call calculator method and print out the answer
		}
		
	}

}
