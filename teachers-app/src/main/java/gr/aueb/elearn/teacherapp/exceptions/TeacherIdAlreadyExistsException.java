package gr.aueb.elearn.teacherapp.exceptions;
/**
 * Teacher Exception class
 * 
 * @author P. Argyroudaki
 *
 */
public class TeacherIdAlreadyExistsException extends Exception{

	private static final long serialVersionUID = 1L;
	

	
	public TeacherIdAlreadyExistsException(int id) {
		super("Εκπαιδευτής με κλειδί: " + id + " υπάρχει, εισάγετε άλλο κλειδί");
	}

}
