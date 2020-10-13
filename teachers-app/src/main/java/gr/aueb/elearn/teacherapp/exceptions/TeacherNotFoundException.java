package gr.aueb.elearn.teacherapp.exceptions;
/**
 * Teacher Exception class
 * 
 * @author P. Argyroudaki
 *
 */
public class TeacherNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;

	public TeacherNotFoundException(int id) {
		super("Δεν υπάρχει εκπαιδευτής με κλειδί: " + id);
	}
	
}
