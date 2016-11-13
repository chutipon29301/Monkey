import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class RequestInput {

	private JFrame frame;
	private static RequestInput requestWindow;
	private JLabel lblStudentId, lblSubject;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		requestWindow = new RequestInput();
		try {
			requestWindow.setStudentId("Student ID: " + args[0].substring(0, args[0].length() - 1));
			requestWindow.setSubject("Subject: " + ((args[0].charAt(args[0].length() - 1) == '1') ? "Math" : "Physics"));
		} catch (NullPointerException e2) {
			requestWindow.setStudentId("Student ID: " + 15999);
			requestWindow.setSubject("Subject: Math");
			args[0] = "159991";
			JOptionPane.showMessageDialog(new JFrame(), "Error");
			System.out.println("No args String input from pervious method");
		}catch (ArrayIndexOutOfBoundsException e) {
			requestWindow.setStudentId("Student ID: " + 15999);
			requestWindow.setSubject("Subject: Math");
			args[0] = "159991";
			System.out.println("Can't decode from last digit of the String");
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					requestWindow.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RequestInput() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow]", "[][][]"));
		
		lblStudentId = new JLabel("Student ID");
		frame.getContentPane().add(lblStudentId, "cell 0 0,growx");
		
		lblSubject = new JLabel("Subject\r\n");
		frame.getContentPane().add(lblSubject, "cell 0 1");
		
		textField = new JTextField();
		frame.getContentPane().add(textField, "cell 0 2,growx");
		textField.setColumns(10);
	}

	private void setStudentId(String input) {
		lblStudentId.setText(input);
	}
	private void setSubject(String input) {
		lblSubject.setText(input);
	}
}
