package gr.aueb.elearn.teacherapp.viewcontroller;
/**
 * Teacher Insert View Controller class
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
import gr.aueb.elearn.teacherapp.exceptions.InvalidSymbolsException;
import gr.aueb.elearn.teacherapp.exceptions.TeacherIdAlreadyExistsException;
import gr.aueb.elearn.teacherapp.service.ITeacherService;
import gr.aueb.elearn.teacherapp.service.TeacherServiceImpl;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.border.CompoundBorder;

public class FrmEkpaideytesInsert extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private ITeacherDAO teacherDAO = new TeacherDAOImpl();
	private ITeacherService teacherService = new TeacherServiceImpl(teacherDAO);
	
	private JPanel contentPane;
	private JTextField txtField_id;
	private JTextField txtField_s;
	private JTextField txtField_f;


	/**
	 * Create the frame.
	 */
	public FrmEkpaideytesInsert() {
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				txtField_id.setText("");
				txtField_s.setText("");
				txtField_f.setText("");
			}
		});
		
		setFont(new Font("Dialog", Font.PLAIN, 14));
		setBackground(new Color(0, 0, 0));
		setTitle("\u0395\u03B9\u03C3\u03B1\u03B3\u03C9\u03B3\u03AE \u0395\u03BA\u03C0\u03B1\u03B9\u03B4\u03B5\u03C5\u03C4\u03AE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 326);
		
		JMenuBar menu = new JMenuBar();
		menu.setMargin(new Insets(2, 2, 2, 2));
		menu.setBackground(new Color(135, 206, 235));
		setJMenuBar(menu);
		
		JMenu menu_file = new JMenu("File");
		menu.add(menu_file);
		
		JMenu menu_file_app = new JMenu("App");
		menu_file.add(menu_file_app);
		
		JMenuItem menu_file_app_close = new JMenuItem("Close");
		menu_file_app_close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menu_file_app.add(menu_file_app_close);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 181));
		contentPane.setBorder(new CompoundBorder());
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(46, 169, 341, 2);
		contentPane.add(separator);
		
		JButton btn_insert = new JButton("Insert");
		btn_insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
				try {
					TeacherDTO teacherDTO = new TeacherDTO();
					teacherDTO.setId(Integer.parseInt(txtField_id.getText()));
					teacherDTO.setSname(txtField_s.getText());
					teacherDTO.setFname(txtField_f.getText());
					teacherService.insertTeacher(teacherDTO);
					
				} catch (TeacherIdAlreadyExistsException e1) {
					JOptionPane.showMessageDialog(null, "Λανθασμένο ID , παρακαλώ προσπαθήστε ξανά", "Σφάλμα", JOptionPane.WARNING_MESSAGE);
					initFields();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Σφάλμα, παρακαλώ προσπαθήστε ξανά", "Σφάλμα", JOptionPane.WARNING_MESSAGE);
					initFields();
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Το ID πρέπει να έχει 1 εως 10 ψηφία , παρακαλώ προσπαθήστε ξανά", "Σφάλμα", JOptionPane.WARNING_MESSAGE);
					initFields();
				} catch(InvalidSymbolsException e1) {
					JOptionPane.showMessageDialog(null, "Τα πεδία Όνομα και Επίθετο δέχονται μόνο γράμματα , παρακαλώ προσπαθήστε ξανά", "Σφάλμα", JOptionPane.WARNING_MESSAGE);
					initFields();
				} catch (EmptyFieldException e1) {
					JOptionPane.showMessageDialog(null, "Όλα τα πεδία είναι υποχρεωτικά, παρακαλώ προσπαθήστε ξανά", "Σφάλμα", JOptionPane.WARNING_MESSAGE);
				}
	
			}
		});
		
		btn_insert.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_insert.setBounds(56, 218, 89, 25);
		contentPane.add(btn_insert);
		
		JButton btn_close = new JButton("Close");
		btn_close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeachersApp.ekpaidSearchFrame.setVisible(true);
				TeachersApp.ekpaidInsertFrame.setVisible(false);
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
		txtField_id.setBounds(76, 13, 71, 25);
		panel.add(txtField_id);
		txtField_id.setBackground(Color.WHITE);
		txtField_id.setColumns(10);
		
		JLabel lbl_id = new JLabel("\u039A\u03C9\u03B4\u03B9\u03BA\u03CC\u03C2");
		lbl_id.setBounds(10, 11, 71, 25);
		panel.add(lbl_id);
		lbl_id.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lbl_s = new JLabel("\u0395\u03C0\u03AF\u03B8\u03B5\u03C4\u03BF");
		lbl_s.setBounds(10, 47, 71, 25);
		panel.add(lbl_s);
		lbl_s.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lbl_f = new JLabel("\u038C\u03BD\u03BF\u03BC\u03B1");
		lbl_f.setBounds(10, 83, 71, 25);
		panel.add(lbl_f);
		lbl_f.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtField_f = new JTextField();
		txtField_f.setBounds(76, 85, 138, 25);
		panel.add(txtField_f);
		txtField_f.setColumns(10);
		txtField_f.setBackground(Color.WHITE);
		
		txtField_s = new JTextField();
		txtField_s.setBounds(76, 49, 138, 25);
		panel.add(txtField_s);
		txtField_s.setColumns(10);
		txtField_s.setBackground(Color.WHITE);
		
	}
	
	private void initFields() {
		txtField_id.setText("");
		txtField_s.setText("");
		txtField_f.setText("");
	}
}
