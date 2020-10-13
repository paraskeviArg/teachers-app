package gr.aueb.elearn.teacherapp.viewcontroller;
/**
 * Teacher Update View Controller class
 * 
 * @author P. Argyroudaki
 *
 */
import javax.swing.JFrame;
import javax.swing.JPanel;

import gr.aueb.elearn.teacherapp.dao.ITeacherDAO;
import gr.aueb.elearn.teacherapp.dao.TeacherDAOImpl;
import gr.aueb.elearn.teacherapp.dto.TeacherDTO;
import gr.aueb.elearn.teacherapp.exceptions.EmptyFieldException;
import gr.aueb.elearn.teacherapp.exceptions.EmptyListException;
import gr.aueb.elearn.teacherapp.exceptions.InvalidSymbolsException;
import gr.aueb.elearn.teacherapp.exceptions.TeacherNotFoundException;
import gr.aueb.elearn.teacherapp.model.Teacher;
import gr.aueb.elearn.teacherapp.service.ITeacherService;
import gr.aueb.elearn.teacherapp.service.TeacherServiceImpl;

import javax.swing.JMenuBar;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.border.CompoundBorder;

public class FrmEkpaideytesUpdate extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private ITeacherDAO teacherDAO = new TeacherDAOImpl();
	private ITeacherService teacherService = new TeacherServiceImpl(teacherDAO);

	private JPanel contentPane;
	private JTextField txtField_id;
	private JTextField txtField_f;
	private JTextField txtField_s;
	private List<Teacher> searchedTeachers = new ArrayList<Teacher>();
	private Teacher currentTeacher = new Teacher();
	ListIterator<Teacher> i;

	
	/**
	 * Create the frame.
	 */
	public FrmEkpaideytesUpdate() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				try {			
					searchedTeachers = teacherService.getTeacherBySurname(SearchForm.searchEpwnymoVar);
					i = searchedTeachers.listIterator();
					currentTeacher = i.next();
					txtField_id.setText(Integer.toString(currentTeacher.getId()));
					txtField_f.setText(currentTeacher.getFname());
					txtField_s.setText(currentTeacher.getSname());

				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Σφάλμα. Παρακαλώ προσπαθήστε ξανά", "Σφάλμα", JOptionPane.WARNING_MESSAGE);
				} catch (EmptyListException e1) {
					TeachersApp.ekpaidSearchFrame.setVisible(true);
					TeachersApp.ekpaidUpdateFrame.setVisible(false);
					JOptionPane.showMessageDialog(null, "Η λίστα είναι άδεια", "Κενό αποτέλεσμα", JOptionPane.WARNING_MESSAGE);
				}
			}
		
	public void windowDeactivated(WindowEvent e) {
			txtField_id.setText("");
			txtField_s.setText("");
			txtField_f.setText("");
			}
		});
		
		setTitle("\u0395\u03BD\u03B7\u03BC\u03AD\u03C1\u03C9\u03C3\u03B7/\u0394\u03B9\u03B1\u03B3\u03C1\u03B1\u03C6\u03AE \u0395\u03BA\u03C0\u03B1\u03B9\u03B4\u03B5\u03C5\u03C4\u03CE\u03BD");
		setBackground(new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 325);
		
		JMenuBar menu = new JMenuBar();
		menu.setBackground(new Color(135, 206, 235));
		setJMenuBar(menu);
		
		JMenu mnFile = new JMenu("File");
		menu.add(mnFile);
		
		JMenu mnApp = new JMenu("App");
		mnFile.add(mnApp);
		
		JMenuItem menu_file_app_close = new JMenuItem("Close");
		menu_file_app_close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnApp.add(menu_file_app_close);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 181));
		contentPane.setBorder(new CompoundBorder());
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_close = new JButton("Close");
		btn_close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeachersApp.ekpaidSearchFrame.setVisible(true);
				TeachersApp.ekpaidUpdateFrame.setVisible(false);
			}
		});
		btn_close.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_close.setBounds(298, 218, 89, 25);
		contentPane.add(btn_close);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(56, 23, 322, 135);
		contentPane.add(panel);
		
		txtField_id = new JTextField();
		txtField_id.setColumns(10);
		txtField_id.setBackground(Color.WHITE);
		txtField_id.setBounds(76, 13, 71, 25);
		panel.add(txtField_id);
		
		JLabel lbl_id = new JLabel("\u039A\u03C9\u03B4\u03B9\u03BA\u03CC\u03C2");
		lbl_id.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_id.setBounds(10, 11, 71, 25);
		panel.add(lbl_id);
		
		JLabel lbl_s = new JLabel("\u0395\u03C0\u03AF\u03B8\u03B5\u03C4\u03BF");
		lbl_s.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_s.setBounds(10, 47, 71, 25);
		panel.add(lbl_s);
		
		JLabel lbl_f = new JLabel("\u038C\u03BD\u03BF\u03BC\u03B1");
		lbl_f.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_f.setBounds(10, 83, 71, 25);
		panel.add(lbl_f);
		
		txtField_f = new JTextField();
		txtField_f.setColumns(10);
		txtField_f.setBackground(Color.WHITE);
		txtField_f.setBounds(76, 85, 138, 25);
		panel.add(txtField_f);
		
		txtField_s = new JTextField();
		txtField_s.setColumns(10);
		txtField_s.setBackground(Color.WHITE);
		txtField_s.setBounds(76, 49, 138, 25);
		panel.add(txtField_s);
		
		JLabel lblNewLabel = new JLabel("(id can not be updated)");
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setBounds(157, 18, 138, 14);
		panel.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(46, 169, 341, 2);
		contentPane.add(separator);
		
		JButton btn_close_1 = new JButton("Delete");
		btn_close_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherDTO teacherToDelete = new TeacherDTO(currentTeacher.getId(),currentTeacher.getFname(),currentTeacher.getSname());
				try {
					teacherService.deleteTeacher(teacherToDelete);
				} catch (TeacherNotFoundException e1) {
					JOptionPane.showMessageDialog(null, "Λανθασμένο ID , παρακαλώ προσπαθήστε ξανά", "Σφάλμα", JOptionPane.WARNING_MESSAGE);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Σφάλμα. Παρακαλώ προσπαθήστε ξανά", "Σφάλμα", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btn_close_1.setForeground(new Color(255, 0, 0));
		btn_close_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_close_1.setBounds(145, 218, 89, 25);
		contentPane.add(btn_close_1);
		
		JButton btn_close_2 = new JButton("Update");
		btn_close_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TeacherDTO teacherToUpdate = new TeacherDTO(currentTeacher.getId(),currentTeacher.getFname(),currentTeacher.getSname());
					TeacherDTO newTeacherDTO = new TeacherDTO(Integer.parseInt(txtField_id.getText()), txtField_f.getText(), txtField_s.getText()); 
					teacherService.updateTeacher(teacherToUpdate, newTeacherDTO);
				} catch (TeacherNotFoundException e1) {
					JOptionPane.showMessageDialog(null, "Λανθασμένο ID , παρακαλώ προσπαθήστε ξανά", "Σφάλμα", JOptionPane.WARNING_MESSAGE);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Σφάλμα. Παρακαλώ προσπαθήστε ξανά", "Σφάλμα", JOptionPane.WARNING_MESSAGE);
				} catch(InvalidSymbolsException e1) {
					JOptionPane.showMessageDialog(null, "Τα πεδία Όνομα και Επίθετο δέχονται μόνο γράμματα , παρακαλώ προσπαθήστε ξανά", "Σφάλμα", JOptionPane.WARNING_MESSAGE);
				} catch (EmptyFieldException e1) {
					JOptionPane.showMessageDialog(null, "Όλα τα πεδία είναι υποχρεωτικά, παρακαλώ προσπαθήστε ξανά", "Σφάλμα", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		btn_close_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_close_2.setBounds(46, 218, 89, 25);
		contentPane.add(btn_close_2);
		
		JButton btnFirst = new JButton("");
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentTeacher = searchedTeachers.get(0);
				txtField_id.setText(Integer.toString(currentTeacher.getId()));
				txtField_s.setText(currentTeacher.getSname());
				txtField_f.setText(currentTeacher.getFname());
			}
		});
		btnFirst.setIcon(new ImageIcon(FrmEkpaideytesUpdate.class.getResource("/gr/aueb/elearn/teacherapp/viewcontroller/First record.png")));
		btnFirst.setBounds(56, 180, 32, 25);
		contentPane.add(btnFirst);
		
		JButton btnPrevious = new JButton("");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					currentTeacher = i.previous();
					txtField_id.setText(Integer.toString(currentTeacher.getId()));
					txtField_s.setText(currentTeacher.getSname());
					txtField_f.setText(currentTeacher.getFname());
				} catch(NoSuchElementException e1) {
					JOptionPane.showMessageDialog(null, "Αρχή λίστας", "Κενό αποτέλεσμα", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnPrevious.setIcon(new ImageIcon(FrmEkpaideytesUpdate.class.getResource("/gr/aueb/elearn/teacherapp/viewcontroller/Previous_record.png")));
		btnPrevious.setBounds(98, 180, 32, 25);
		contentPane.add(btnPrevious);
		
		JButton btnNext = new JButton("");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					currentTeacher = i.next();
					txtField_id.setText(Integer.toString(currentTeacher.getId()));
					txtField_s.setText(currentTeacher.getSname());
					txtField_f.setText(currentTeacher.getFname());
				} catch(NoSuchElementException e1) {
					JOptionPane.showMessageDialog(null, "Τέλος λίστας", "Κενό αποτέλεσμα", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNext.setIcon(new ImageIcon(FrmEkpaideytesUpdate.class.getResource("/gr/aueb/elearn/teacherapp/viewcontroller/Next_track.png")));
		btnNext.setBounds(140, 180, 32, 25);
		contentPane.add(btnNext);
		
		JButton btnLast = new JButton("");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentTeacher = searchedTeachers.get(searchedTeachers.size()-1);
				txtField_id.setText(Integer.toString(currentTeacher.getId()));
				txtField_s.setText(currentTeacher.getSname());
				txtField_f.setText(currentTeacher.getFname());
			}
		});
		btnLast.setIcon(new ImageIcon(FrmEkpaideytesUpdate.class.getResource("/gr/aueb/elearn/teacherapp/viewcontroller/Last_Record.png")));
		btnLast.setBounds(182, 180, 32, 25);
		contentPane.add(btnLast);
	}
}
