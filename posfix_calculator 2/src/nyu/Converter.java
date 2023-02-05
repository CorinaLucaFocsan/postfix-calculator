package nyu;


public class Converter extends CArrayStack{
	private String infix; // Private instance variable to store the infix String user inputs
	
	public Converter(String infix) { // Constructor
		super(infix.length()); 
		this.infix = infix; 

	}
	 /**
	   * Precedence method that looks at an operator or char and returns -1,1,2,3 indicating whether something has a higher or lower precedence
	   * @param charater. Either '+','-','*','/', '^', or other
	   * @return an int that indicates the precedence of the operator
	   */


	 static int prec(char ch) // Precedence method 
	    {
	        switch (ch) {
	        case '+':
	        case '-':
	            return 1;
	 
	        case '*':
	        case '/':
	            return 2;
	 
	        case '^':
	            return 3;
	        }
	        return -1;
	    }
	 
	 /**
	   * toPostfix method that looks at a char array of infix notation and uses a stack to output postfix notation of said char array
	   * @return an String of infix expression converted to postfix notation
	 * @throws InvalidInputException 
	   */
	public String toPostfix() throws InvalidInputException {
		char[] charr = this.infix.toCharArray(); // Turn infix to charArray
		
		CArrayStack s = new CArrayStack(charr.length); // Create an Character Array Stack 
		String output = ""; // Initialize string where I will be appending characters in such a way it contains the postfix expression
		
		for(int i = 0; i < charr.length; i++) { // Loop through char array
			char c = charr[i];
			
			if (Character.isDigit(c)) { // if it is a digit, append to output and check if next char is also digit 
	            output += charr[i];
	            
	            for (int j = i + 1; j < charr.length; ++j) {
	                if (Character.isDigit(charr[j])) {
	                    output += charr[j];
	                    i = j;
	                } else {
	                    break;
	                }
	            }
	            
	            output += " ";  // after all digits from a single number has been appended, add a space 
			}
			
			else if(c == '(') {s.push(c);} //push an open parenthesis
			
			else if(c == ')') { // if we encounter a closed parenthesis
					while(s.top() != '(') { // while we don't encounter an open parenthesis, print out top of stack and a space. Pop these off
					output += s.top() + " ";
					s.pop();
				}
					s.pop(); // pop off the open parenthesis
					
					}

			

			else if(c == '*' || c == '/' || 
	                   c == '+' || c == '^' || 
	                   c == '-') {
				
				if(s.size() == 0) {s.push(c);} // if this is the first 
				
				else {
				
					while(s.size() != 0 && prec(c) <= prec(s.top())){
						output += s.top() + " ";
						s.pop();
					}
					
					s.push(c);
				}
			}
			
			else if(c == ' ') {} // if c is a whitespace, ignore it
			// If a char is neither a whitespace, number, or operand, the input must be invalid so throw exception
			else {throw new InvalidInputException();} 
			
		}
		
		while(s.size() != 0) {
			output += s.top() + " ";
			s.pop();
			
		}
		return output;
	

	}

	
}
