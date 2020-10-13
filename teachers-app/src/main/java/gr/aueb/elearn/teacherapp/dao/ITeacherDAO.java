package gr.aueb.elearn.teacherapp.dao;
/**
 * Teacher DAO interface
 * 
 * @author P. Argyroudaki
 *
 */
import java.util.List;
import java.sql.SQLException;

import gr.aueb.elearn.teacherapp.model.Teacher;

public interface ITeacherDAO {
	
	void insert(Teacher teacher) throws SQLException;
	void delete(Teacher teacher) throws SQLException;
	void update(Teacher oldTeacher, Teacher newTeacher) throws SQLException;
	List<Teacher> getTeacherBySurname(String surname) throws SQLException;
	Teacher getTeacherById(int id) throws SQLException;
	
}
