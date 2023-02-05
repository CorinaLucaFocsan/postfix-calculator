package nyu;

public class InvalidInputException extends Exception {
	public InvalidInputException() {
		super("Input must consist of numbers, whitespaces, and operands");
	}
}
