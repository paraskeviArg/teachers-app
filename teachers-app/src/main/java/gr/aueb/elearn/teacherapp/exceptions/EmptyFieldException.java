package gr.aueb.elearn.teacherapp.exceptions;
/**
 * Teacher Exception class
 * 
 * @author P. Argyroudaki
 *
 */
public class EmptyFieldException extends Exception{

	private static final long serialVersionUID = 1L;

	public EmptyFieldException() {
		super("Όλα τα πεδία είναι υποχρεωτικά");
	}

}