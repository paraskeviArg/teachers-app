package gr.aueb.elearn.teacherapp.service;
/**
 * Teacher Service interface
 * 
 * @author P. Argyroudaki
 *
 */
import java.util.List;
import java.sql.SQLException;

import gr.aueb.elearn.teacherapp.dto.TeacherDTO;
import gr.aueb.elearn.teacherapp.exceptions.EmptyFieldException;
import gr.aueb.elearn.teacherapp.exceptions.EmptyListException;
import gr.aueb.elearn.teacherapp.exceptions.InvalidSymbolsException;
import gr.aueb.elearn.teacherapp.exceptions.TeacherIdAlreadyExistsException;
import gr.aueb.elearn.teacherapp.exceptions.TeacherNotFoundException;
import gr.aueb.elearn.teacherapp.model.Teacher;

public interface ITeacherService {
	
	void insertTeacher(TeacherDTO teacherDTO) throws TeacherIdAlreadyExistsException, SQLException, InvalidSymbolsException, EmptyFieldException;
	void deleteTeacher(TeacherDTO teacherDTO) throws TeacherNotFoundException, SQLException;	
	void updateTeacher(TeacherDTO oldTeacherDTO, TeacherDTO newTeacherDTO) throws TeacherNotFoundException, SQLException, InvalidSymbolsException, EmptyFieldException;
	List<Teacher> getTeacherBySurname(String surname) throws SQLException, EmptyListException;

}
