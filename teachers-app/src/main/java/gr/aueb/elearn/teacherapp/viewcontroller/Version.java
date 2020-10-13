package gr.aueb.elearn.teacherapp.viewcontroller;
/**
 * Teacher Version View Controller class
 * 
 * @author P. Argyroudaki
 *
 */
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Insets;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.border.CompoundBorder;

public class Version extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Version() {
		setTitle("\u0388\u03BA\u03B4\u03BF\u03C3\u03B7");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menu = new JMenuBar();
		menu.setMargin(new Insets(2, 2, 2, 2));
		menu.setBackground(new Color(135, 206, 235));
		setJMenuBar(menu);
		
		JMenu mnFile = new JMenu("File");
		menu.add(mnFile);
		
		JMenu menu_file_app = new JMenu("App");
		mnFile.add(menu_file_app);
		
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
		
		JLabel lblNewLabel = new JLabel("\u0388\u03BA\u03B4\u03BF\u03C3\u03B7 0.1");
		lblNewLabel.setForeground(new Color(139, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(169, 78, 96, 19);
		contentPane.add(lblNewLabel);
		
		JButton btn_close = new JButton("Close");
		btn_close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeachersApp.mainFrame.setVisible(true);
				TeachersApp.version.setVisible(false);
			}
		});
		btn_close.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_close.setBounds(298, 189, 89, 25);
		contentPane.add(btn_close);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(27, 172, 379, 6);
		contentPane.add(separator);
	}
}
