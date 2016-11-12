
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import net.miginfocom.swing.MigLayout;

public class Home {

	private JFrame frame;
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
		frame = new JFrame();
		frame.setBounds(100, 100, 681, 321);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[665px]", "[22px][][260px]"));
		
		lblNewLabel = new JLabel("Scan Student ID");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Cordia New", Font.PLAIN, 18));
		frame.getContentPane().add(lblNewLabel, "cell 0 0,growx,aligny top");
		
		/**
		 * Store value input from user in variable input until user press enter
		 */
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char charInput = arg0.getKeyChar();
				if (charInput == '\n') {
					if ((input.charAt(input.length() - 1) != 1 || input.charAt(input.length() - 1) != 2) && input.length() != 6) {
						System.out.println("Invalid student id");
						homeWindow.textField.setText("");
						input = "";
						return;
					}
					homeWindow.textField.setText("");
					String array[] = {input};
					input = "";
					RequestInput.main(array);
				}else {
					input += charInput;
				}
			}
		});
		frame.getContentPane().add(textField, "cell 0 1,grow");
		textField.setColumns(10);
	}
	
	/**
	 * Set visible of the frame
	 * @param input boolean true or false
	 */
	protected void setVisible(boolean input){
		frame.setVisible(input);
	}

	protected void setLabelText(String input){
		lblNewLabel.setText(input);
	}
}
