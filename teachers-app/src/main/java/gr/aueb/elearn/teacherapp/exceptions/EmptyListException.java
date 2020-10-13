package gr.aueb.elearn.teacherapp.exceptions;
/**
 * Teacher Exception class
 * 
 * @author P. Argyroudaki
 *
 */
public class EmptyListException extends Exception{

	private static final long serialVersionUID = 1L;

	public EmptyListException() {
		super("Η λίστα είναι άδεια");
	}

}
