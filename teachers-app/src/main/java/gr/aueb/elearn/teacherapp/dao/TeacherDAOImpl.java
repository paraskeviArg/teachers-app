package gr.aueb.elearn.teacherapp.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import static gr.aueb.elearn.teacherapp.dao.dbutil.DBUtil.closeConnection;
import static gr.aueb.elearn.teacherapp.dao.dbutil.DBUtil.openConnection;

import gr.aueb.elearn.teacherapp.model.Teacher;
/**
 * Teacher DAO class
 * 
 * @author P. Argyroudaki
 *
 */
public class TeacherDAOImpl implements ITeacherDAO {
	
	/**
	 * ������� ��� ���������� ���� ��.
	 */
	@Override
	public void insert(Teacher teacher) throws SQLException {
		String sql = "INSERT INTO TEACHERS VALUES ('" + teacher.getId() + "', '" + teacher.getFname() + "', '" + 
					teacher.getSname() + "')";

		PreparedStatement pst = openConnection().prepareStatement(sql);

		int n = pst.executeUpdate(sql);
		JOptionPane.showMessageDialog(null, n + " ������� ����������", "INSERT", JOptionPane.PLAIN_MESSAGE);
		pst.close();
		closeConnection();
		
	}
	
	/**
	 * ��������� ��� ���������� ��� ��� ��.
	 */
	@Override
	public void delete(Teacher teacher) throws SQLException {
		String sql = "DELETE FROM TEACHERS WHERE TEACHER_ID = ?";
		
		PreparedStatement pst = openConnection().prepareStatement(sql);
		pst.setInt(1, teacher.getId());
		int dialogButton;
		dialogButton = JOptionPane.showConfirmDialog(null, "����� ��������;"
				,"Warning", JOptionPane.YES_NO_OPTION);
		if(dialogButton == JOptionPane.YES_OPTION) pst.execute();
		else {}
		pst.close();
		closeConnection();
	}

	/**
	 * ������� �� ����� ��� �������������� ���� ��.
	 */
	@Override
	public void update(Teacher oldTeacher, Teacher newTeacher) throws SQLException {
		String sql = "UPDATE TEACHERS SET TEACHER_SNAME = ?, TEACHER_FNAME = ? WHERE TEACHER_ID = ?";
		PreparedStatement pst = openConnection().prepareStatement(sql);
		pst.setString(1, newTeacher.getSname());
		pst.setString(2, newTeacher.getFname());
		pst.setInt(3, oldTeacher.getId());

		pst.executeUpdate();
		
		JOptionPane.showMessageDialog(null, "������ ����������", "UPDATE", JOptionPane.PLAIN_MESSAGE);
		pst.close();
		closeConnection();	
	}

	/**
	 * ���������� ����� �� ����������� ��� �� @param surname ������� �� ���� ��� ��������� � �������.
	 */
	@Override
	public List<Teacher> getTeacherBySurname(String surname) throws SQLException {
		String sql = "SELECT TEACHER_ID,TEACHER_FNAME,TEACHER_SNAME FROM TEACHERS WHERE TEACHER_SNAME LIKE ?";
		
		PreparedStatement pst = openConnection().prepareStatement(sql);
		pst.setString(1,  surname + '%');
		ResultSet rs = pst.executeQuery();
		List<Teacher> teachers = new ArrayList<Teacher>();
		while(rs.next()) {
			int id = rs.getInt("TEACHER_ID");
			String fname = rs.getString("TEACHER_FNAME");
			String sname = rs.getString("TEACHER_SNAME");
			Teacher teacher = new Teacher(id,fname,sname);
			teachers.add(teacher);
		}
		
		if(teachers.isEmpty()) {
			sql = "SELECT TEACHER_ID,TEACHER_FNAME,TEACHER_SNAME FROM TEACHERS";
			rs = pst.executeQuery();
		}
		while(rs.next()) {
			int id = rs.getInt("TEACHER_ID");
			String fname = rs.getString("TEACHER_FNAME");
			String sname = rs.getString("TEACHER_SNAME");
			Teacher teacher = new Teacher(id,fname,sname);
			teachers.add(teacher);
		}

		return teachers;
	}
	
	/**
	 * ���������� ���� ���������� {@link Teacher} ����� ��� ������ @param id.
	 */
	@Override
	public Teacher getTeacherById(int id) throws SQLException {
		String sql = "SELECT TEACHER_ID,TEACHER_FNAME,TEACHER_SNAME FROM TEACHERS WHERE TEACHER_ID = ?";
		
		PreparedStatement pst = openConnection().prepareStatement(sql);
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		Teacher teacher = null;
		if(rs.next()) {
			teacher = new Teacher();
			String fname = rs.getString("TEACHER_FNAME");
			String sname = rs.getString("TEACHER_SNAME");
			teacher = new Teacher(id,fname,sname);
		}
		
		return teacher;
	}



}
