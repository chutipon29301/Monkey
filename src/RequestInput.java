import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;

public class RequestInput {

	private JFrame frame;
	private static RequestInput requestWindow;
	private JLabel lblStudentId, lblSubject;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		requestWindow = new RequestInput();
		requestWindow.setStudentId("Student ID: " + args[0].substring(0, args[0].length() - 2));
		requestWindow.setSubject("Subject: " + 2);
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
		frame.getContentPane().setLayout(new MigLayout("", "[]", "[][]"));
		
		lblStudentId = new JLabel("Student ID");
		frame.getContentPane().add(lblStudentId, "cell 0 0,growx");
		
		lblSubject = new JLabel("Subject\r\n");
		frame.getContentPane().add(lblSubject, "cell 0 1");
	}

	private void setStudentId(String input) {
		lblStudentId.setText(input);
	}
	private void setSubject(String input) {
		lblSubject.setText(input);
	}
}
