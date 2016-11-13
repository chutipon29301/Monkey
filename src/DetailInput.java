import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

public class DetailInput {

	private static DetailInput window;
	private JFrame frame;
	private JLabel lblStudentId, lblSubject;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		window = new DetailInput();
		try {
			System.out.println(args[0]);
			window.lblStudentId.setText("Student ID: " + args[0].substring(0, args[0].length() - 1));
			window.lblSubject.setText("Subject: " + ((args[0].charAt(args[0].length() - 1) == '1') ? "Math" : "Physics"));
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(new JFrame(), "ID decrypt error return to Home");
			e1.printStackTrace();
			Index.main(null);
			return;
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index.main(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DetailInput() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1920, 1080);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblStudentId = new JLabel("Student ID: ");
		lblStudentId.setFont(new Font("Cordia New", Font.PLAIN, 72));
		lblStudentId.setBounds(99, 55, 484, 62);
		frame.getContentPane().add(lblStudentId);
		
		lblSubject = new JLabel("Subject");
		lblSubject.setFont(new Font("Cordia New", Font.PLAIN, 72));
		lblSubject.setBounds(99, 139, 471, 84);
		frame.getContentPane().add(lblSubject);
	}
}
