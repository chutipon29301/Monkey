
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;

public class Home {

	private JFrame frmAdmin;
	private JLabel lblNewLabel;
	private static Home homeWindow;
	private JTextField textField;
	private String input = "";
	
	public static void main(String[] args) {
		homeWindow = new Home();
		
		/**
		 * Run Home Window
		 */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homeWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdmin = new JFrame();
		frmAdmin.setTitle("Admin");
		frmAdmin.setBounds(100, 100, 681, 321);
		frmAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdmin.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("73px"),
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				RowSpec.decode("35px"),
				RowSpec.decode("59px"),
				RowSpec.decode("20px"),}));
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 36));
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char charInput = arg0.getKeyChar();
				if (charInput == '\n') {
					if ((input.charAt(input.length() - 1) != 1 || input.charAt(input.length() - 1) != 2) && input.length() != 6) {
						System.out.println("Invalid student id");
						homeWindow.textField.setText("");
						input = "";
						JOptionPane.showMessageDialog(new JFrame(), "Invalid Student ID\nPlease enter again");
						return;
					}
					try {
						homeWindow.textField.setText("");
					} catch (Exception e) {
						JOptionPane.showMessageDialog(new JFrame(), "Error-0101 (Can't reset text field)\nLocation: Home.java:80\n" + e.getMessage());
					}
					String array[] = {input};
					input = "";
					try {
						homeWindow.setVisible(false);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(new JFrame(), "Error-0102 (Can't set visibility of Home window)\nLocation: Home.java:87" + e.getMessage());
					}
					try {
						RequestInput.main(array);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(new JFrame(), "Error-0103 (Can't call RequestInput.main())\nLocation: Home.java:92" + e.getMessage());
					}
				}else {
					try {
						input += charInput;
					} catch (Exception e) {
						JOptionPane.showMessageDialog(new JFrame(), "Error-0102 (Can't concad input char to String)\nLocation: Home.java:98" + e.getMessage());
					}
				}
			}
		});
		
		lblNewLabel = new JLabel("Scan Student ID");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Cordia New", Font.PLAIN, 18));
		frmAdmin.getContentPane().add(lblNewLabel, "2, 1, fill, top");
		frmAdmin.getContentPane().add(textField, "2, 2, fill, fill");
		textField.setColumns(10);
		
		/**
		 * Store value input from user in variable input until user press enter
		 */
	}
	
	/**
	 * Set visible of the frame
	 * @param input boolean true or false
	 */
	protected void setVisible(boolean input){
		frmAdmin.setVisible(input);
	}

	protected void setLabelText(String input){
		lblNewLabel.setText(input);
	}
}
