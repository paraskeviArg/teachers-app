package gr.aueb.elearn.teacherapp.viewcontroller;

/**
 * Teacher Search View Controller class
 * 
 * @author P. Argyroudaki
 *
 */
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Insets;

import javax.swing.JMenuItem;


import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;

public class SearchForm extends JFrame {

	private static final long serialVersionUID = 1L;
	
	static String searchEpwnymoVar;
	private JPanel contentPane;
	private JTextField txtField_s;

	/**
	 * Create the frame.
	 */
	public SearchForm() {
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				txtField_s.setText("");
			}
		});
		
		setBackground(new Color(0, 0, 0));
		setTitle("\u039C\u03B5\u03BD\u03BF\u03CD \u0395\u03BA\u03C0\u03B1\u03B9\u03B4\u03B5\u03C5\u03C4\u03CE\u03BD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menu = new JMenuBar();
		menu.setMargin(new Insets(2, 2, 2, 2));
		menu.setBackground(new Color(135, 206, 235));
		setJMenuBar(menu);
		
		JMenu menu_file = new JMenu("File");
		menu.add(menu_file);
		
		JMenu mnApp = new JMenu("App");
		menu_file.add(mnApp);
		
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
		
		JLabel menu_ekpaid_title = new JLabel("\u0395\u03C0\u03B9\u03BB\u03AD\u03BE\u03C4\u03B5 \u03B5\u03BD\u03AD\u03C1\u03B3\u03B5\u03B9\u03B1:");
		menu_ekpaid_title.setForeground(new Color(128, 0, 0));
		menu_ekpaid_title.setFont(new Font("Tahoma", Font.PLAIN, 19));
		menu_ekpaid_title.setBounds(39, 21, 165, 26);
		contentPane.add(menu_ekpaid_title);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(28, 58, 379, 6);
		contentPane.add(separator);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(28, 68, 379, 55);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btn_search = new JButton("\u0391\u03BD\u03B1\u03B6\u03AE\u03C4\u03B7\u03C3\u03B7 \u03B5\u03BA\u03C0\u03B1\u03B9\u03B4\u03B5\u03C5\u03C4\u03AE");
		btn_search.setBounds(192, 11, 177, 33);
		panel.add(btn_search);
		btn_search.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtField_s = new JTextField();
		txtField_s.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtField_s.setBounds(76, 11, 106, 33);
		panel.add(txtField_s);
		txtField_s.setColumns(10);
		
		JLabel lbl_s = new JLabel("\u0395\u03C0\u03CE\u03BD\u03C5\u03BC\u03BF:");
		lbl_s.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_s.setBounds(10, 11, 77, 33);
		panel.add(lbl_s);
		
		JButton btn_close = new JButton("Close");
		btn_close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeachersApp.mainFrame.setVisible(true);
				TeachersApp.ekpaidSearchFrame.setVisible(false);
			}
		});
		btn_close.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_close.setBounds(298, 189, 89, 25);
		contentPane.add(btn_close);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(28, 123, 379, 55);
		contentPane.add(panel_1);
		
		JButton btn_insert = new JButton("\u0395\u03B9\u03C3\u03B1\u03B3\u03C9\u03B3\u03AE \u0395\u03BA\u03C0\u03B1\u03B9\u03B4\u03B5\u03C5\u03C4\u03AE");
		btn_insert.setBounds(91, 11, 196, 33);
		panel_1.add(btn_insert);
		btn_insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeachersApp.ekpaidInsertFrame.setVisible(true);
				TeachersApp.ekpaidSearchFrame.setVisible(false);
			}
		});
		btn_insert.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		btn_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SearchForm.searchEpwnymoVar = txtField_s.getText();
				
				TeachersApp.ekpaidUpdateFrame.setVisible(true);
				TeachersApp.ekpaidSearchFrame.setVisible(false);
			}
		});
	}
	
}
