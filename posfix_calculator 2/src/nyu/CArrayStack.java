package nyu;


public class CArrayStack implements Stack {
	  /** Default array capacity. */
	  //public static int CAPACITY=1000;   // default array capacity

	  /** Generic array used for storage of stack elements. */
	  private Character[] arr;                        // generic array used for storage

	  /** Index of the top element of the stack in the array. */
	  private int t = -1;                      // index of the top element in stack

	  /**
	   * Constructs and empty stack with the given array capacity.
	   * @param capacity length of the underlying array
	   */

	  public CArrayStack(int capacity) {        // constructs stack with given capacity
	    arr =  new Character[capacity];     // safe cast; compiler may give warning
	  }

	  public Character[] getArrayStack() {
		  return arr;
		  
	  }
	  /**
	   * Returns the number of elements in the stack.
	   * @return number of elements in the stack
	   */
	  @Override
	  public int size() { return (t + 1); }

	  /**
	   * Tests whether the stack is empty.
	   * @return true if the stack is empty, false otherwise
	   */
	  @Override
	  public boolean isEmpty() { return (t == -1); }

	  /**
	   * Inserts an element at the top of the stack.
	   * @param e   the element to be inserted
	   * @throws IllegalStateException if the array storing the elements is full
	   */
	  public void push(Character e) throws IllegalStateException {
	    if (size() == arr.length) throw new IllegalStateException("Stack is full");
	    arr[++t] = e;                           // increment t before storing new item
	    //t++;
	  }

	  /**
	   * Returns, but does not remove, the element at the top of the stack.
	   * @return top element in the stack (or null if empty)
	   */
	  @Override
	  public Character top() {
	    if (isEmpty()) return '\0';
	    return arr[t];
	  }

	  /**
	   * Removes and returns the top element from the stack.
	   * @return element removed (or null if empty)
	   */
	  @Override
	  public Character pop() {
	    if (isEmpty()) return '\0';
	    char answer = arr[t];
	    arr[t] = '\0';                        // dereference to help garbage collection
	    t--;
	    return answer;
	  }

	  /**
	   * Produces a string representation of the contents of the stack.
	   * (ordered from top to bottom). This exists for debugging purposes only.
	   *
	   * @return textual representation of the stack
	   */
	  public String toString() {
	    StringBuilder sb = new StringBuilder("(");
	    for (int j = t; j >= 0; j--) {
	      sb.append(arr[j]);
	      if (j > 0) sb.append(", ");
	    }
	    sb.append(")");
	    return sb.toString();
	  }

	@Override
	public void push(Object e) {
		// TODO Auto-generated method stub
		
	}
	  
}

