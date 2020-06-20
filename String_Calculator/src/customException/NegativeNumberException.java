package customException;

//custom exception class 
public class NegativeNumberException extends Exception {	
	public NegativeNumberException(String message) {
		super(message);
	}
}
