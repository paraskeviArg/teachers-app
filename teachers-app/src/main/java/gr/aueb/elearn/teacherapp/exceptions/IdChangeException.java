package gr.aueb.elearn.teacherapp.exceptions;
/**
 * Teacher Exception class
 * 
 * @author P. Argyroudaki
 *
 */
public class IdChangeException extends Exception{

	private static final long serialVersionUID = 1L;

	public IdChangeException() {
		super("Το πεδίο ID δεν αλλάζει");
	}

}
