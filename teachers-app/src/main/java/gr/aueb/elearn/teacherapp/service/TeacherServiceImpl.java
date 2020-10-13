package gr.aueb.elearn.teacherapp.service;
/**
 * Teacher Service class
 * 
 * @author P. Argyroudaki
 *
 */
import java.util.List;
import java.sql.SQLException;

import gr.aueb.elearn.teacherapp.dao.ITeacherDAO;
import gr.aueb.elearn.teacherapp.dto.TeacherDTO;
import gr.aueb.elearn.teacherapp.exceptions.EmptyFieldException;
import gr.aueb.elearn.teacherapp.exceptions.EmptyListException;
import gr.aueb.elearn.teacherapp.exceptions.InvalidSymbolsException;
import gr.aueb.elearn.teacherapp.exceptions.TeacherIdAlreadyExistsException;
import gr.aueb.elearn.teacherapp.exceptions.TeacherNotFoundException;
import gr.aueb.elearn.teacherapp.model.Teacher;

public class TeacherServiceImpl implements ITeacherService {
	
	private final ITeacherDAO teacherDAO;
	
	public TeacherServiceImpl(ITeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}
	
	/**
	 * @exception {@link TeacherIdAlreadyExistsException} εάν ο χρήστης προσπαθεί να εισάγει εκπαιδευτή με id που υπάρχει ήδη.
	 * @exception {@link InvalidSymbolsException} εάν ο χρήστης προσπαθέι να δώσει όνομα ή επίθετο που περιέχει οτιδήποτε άλλο εκτός απο γράμματα.
	 * @exception {@link EmptyFieldException} εάν δεν έχει δωθεί τιμή σε κάποιο ή κάποια πεδία.
	 */
	
	@Override
	public void insertTeacher(TeacherDTO teacherDTO) throws TeacherIdAlreadyExistsException, SQLException, InvalidSymbolsException, EmptyFieldException {
		Teacher teacherToInsert = new Teacher();
		teacherToInsert.setId(teacherDTO.getId());
		teacherToInsert.setSname(teacherDTO.getSname());
		teacherToInsert.setFname(teacherDTO.getFname());
		
		if(teacherToInsert.getFname().equals("") || teacherToInsert.getSname().equals("")) throw new EmptyFieldException();
		if(!teacherToInsert.getFname().matches ("[a-zA-Z]+\\.?") && !teacherToInsert.getSname().matches ("[α-ωΑ-Ω]+\\.?")) throw new InvalidSymbolsException();
		
		if((teacherDAO.getTeacherById(teacherToInsert.getId())) == null) {
			teacherDAO.insert(teacherToInsert);
		} else {
			throw new TeacherIdAlreadyExistsException(teacherToInsert.getId());
		}
		
	}
	
	/**
	 * @exception {@link TeacherNotFoundException} εάν ο χρήστης προσαθήσει να διαγράψει χρήστη με id που δεν υπάρχει.
	 */
	@Override
	public void deleteTeacher(TeacherDTO teacherDTO) throws TeacherNotFoundException, SQLException {
		Teacher teacherToDelete = new Teacher();
		teacherToDelete.setId(teacherDTO.getId());
		teacherToDelete.setSname(teacherDTO.getSname());
		teacherToDelete.setFname(teacherDTO.getFname());
		
		if((teacherDAO.getTeacherById(teacherToDelete.getId())) != null) {
			teacherDAO.delete(teacherToDelete);
		} else {
			throw new TeacherNotFoundException(teacherToDelete.getId());
		}
		
	}
	
	/**
	 * @throws EmptyFieldException 
	 * @exception {@link TeacherNotFoundException} εάν ο χρήστης προσαθήσει να διαγράψει χρήστη με id που δεν υπάρχει.
	 * @exception {@link InvalidSymbolsException} εάν ο χρήστης προσπαθέι να δώσει όνομα ή επίθετο που περιέχει οτιδήποτε άλλο εκτός απο γράμματα.
	 * @exception {@link EmptyFieldException} εάν δεν έχει δωθεί τιμή σε κάποιο ή κάποια πεδία.
	 */

	@Override
	public void updateTeacher(TeacherDTO oldTeacherDTO, TeacherDTO newTeacherDTO)
			throws TeacherNotFoundException, SQLException, InvalidSymbolsException, EmptyFieldException {
		
		Teacher oldTeacher = new Teacher();
		Teacher newTeacher = new Teacher();
		
		oldTeacher.setId(oldTeacherDTO.getId());
		newTeacher.setId(newTeacherDTO.getId());

		newTeacher.setSname(newTeacherDTO.getSname());
		newTeacher.setFname(newTeacherDTO.getFname());
		oldTeacher.setSname(oldTeacherDTO.getSname());
		oldTeacher.setFname(oldTeacherDTO.getFname());
		
		if(newTeacher.getFname().equals("") || newTeacher.getSname().equals("")) throw new EmptyFieldException();
		boolean invSymb = false;
		
		//Πρέπει να είναι όνομα και επίθετο ταυτόχρονα είτε Ελληνικά είτε Αγγλικά.
		if((!newTeacher.getFname().matches("[α-ωΑ-Ω]+") || !newTeacher.getSname().matches("[α-ωΑ-Ω]+")) && 
				(!newTeacher.getFname().matches("[a-zA-Z]+") || !newTeacher.getSname().matches("[a-zA-Z]+"))) throw new InvalidSymbolsException();

		
		if((teacherDAO.getTeacherById(newTeacher.getId())) != null) {
			teacherDAO.update(oldTeacher, newTeacher);
		} else {
			throw new TeacherNotFoundException(newTeacher.getId());
		}
		
	}
	
	/**
	 * @exception {@link EmptyListException} εάν η λίστα του αποτελέσματος αναζήτησης είναι άδεια. Αυτό συμβαίνει στη περίπτωση που δωθεί λάθος επίθετο, ή διαγραφούν όλα τα στοιχεία της λίστας.
	 */

	@Override
	public List<Teacher> getTeacherBySurname(String surname) throws SQLException, EmptyListException {
		
		if(teacherDAO.getTeacherBySurname(surname).isEmpty()) throw new EmptyListException();
		
		return teacherDAO.getTeacherBySurname(surname);
	}

}
