package gr.aueb.elearn.teacherapp.viewcontroller;
/**
 * Teacher Main Window View Controller class
 * 
 * @author P. Argyroudaki
 *
 */
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Insets;
import javax.swing.border.CompoundBorder;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setForeground(new Color(0, 0, 0));
		setFont(new Font("Dialog", Font.PLAIN, 14));
		setBackground(new Color(0, 0, 0));
		setTitle("Teachers Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 399, 284);
		
		JMenuBar menu = new JMenuBar();
		menu.setMargin(new Insets(2, 2, 2, 2));
		menu.setBackground(new Color(135, 206, 235));
		setJMenuBar(menu);
		
		JMenu menu_file = new JMenu("File");
		menu_file.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		menu_file.setBackground(new Color(119, 136, 153));
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
		contentPane.setBackground(new Color(255, 222, 173));
		contentPane.setBorder(new CompoundBorder());
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_main_title = new JLabel("\u03A0\u03BF\u03B9\u03CC\u03C4\u03B7\u03C4\u03B1 \u03C3\u03C4\u03B7\u03BD \u0395\u03BA\u03C0\u03B1\u03AF\u03B4\u03B5\u03C5\u03C3\u03B7");
		lbl_main_title.setForeground(new Color(0, 0, 128));
		lbl_main_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_main_title.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lbl_main_title.setBounds(56, 37, 271, 40);
		contentPane.add(lbl_main_title);
		
		JLabel lbl_main_title_shadow = new JLabel("\u03A0\u03BF\u03B9\u03CC\u03C4\u03B7\u03C4\u03B1 \u03C3\u03C4\u03B7\u03BD \u0395\u03BA\u03C0\u03B1\u03AF\u03B4\u03B5\u03C5\u03C3\u03B7");
		lbl_main_title_shadow.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_main_title_shadow.setForeground(new Color(105, 105, 105));
		lbl_main_title_shadow.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lbl_main_title_shadow.setBounds(57, 38, 271, 40);
		contentPane.add(lbl_main_title_shadow);
		
		JButton btn_Ekpaideytes = new JButton("\u0395\u03BA\u03C0\u03B1\u03B9\u03B4\u03B5\u03C5\u03C4\u03AD\u03C2");
		btn_Ekpaideytes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Ekpaideytes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeachersApp.ekpaidSearchFrame.setVisible(true);
				TeachersApp.mainFrame.setVisible(false);
			}
		});
		btn_Ekpaideytes.setBounds(54, 120, 110, 28);
		contentPane.add(btn_Ekpaideytes);
		
		JButton btn_ekdosi = new JButton("\u0388\u03BA\u03B4\u03BF\u03C3\u03B7");
		btn_ekdosi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_ekdosi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeachersApp.version.setVisible(true);
				TeachersApp.mainFrame.setVisible(false);
			}
		});
		btn_ekdosi.setBounds(218, 120, 110, 28);
		contentPane.add(btn_ekdosi);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(35, 86, 314, 2);
		contentPane.add(separator);
	}
}
