package gr.aueb.elearn.teacherapp.exceptions;
/**
 * Teacher Exception class
 * 
 * @author P. Argyroudaki
 *
 */
public class InvalidSymbolsException extends Exception{

	private static final long serialVersionUID = 1L;

	public InvalidSymbolsException() {
		super("Επιτρέπονται μόνο γράμματα");
	}

}
