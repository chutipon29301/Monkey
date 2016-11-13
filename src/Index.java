//Copyright [2016] [Chutipon]
//
//Licensed under the Apache License, Version 2.0 (the "License");
//you may not use this file except in compliance with the License.
//You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
//Unless required by applicable law or agreed to in writing, software
//distributed under the License is distributed on an "AS IS" BASIS,
//WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//See the License for the specific language governing permissions and
//limitations under the License.

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Index {

	private static Index window;
	private JFrame frame;
	private JTextField textField;
	private String inputTextbox = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new Index();
					window.inputTextbox = "";
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Index() {
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
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char charInput = arg0.getKeyChar();
				if (charInput == '\n') {
					if (inputTextbox.length() != 6 && (inputTextbox.charAt(inputTextbox.length() - 1) != 1 || inputTextbox.charAt(inputTextbox.length() - 1) != 2)) {
						window.textField.setText("");
						inputTextbox = "";
						JOptionPane.showMessageDialog(new JFrame(), "Invalid Student ID\nPlease enter again");
						return;
					}
					try {
						String input[] = {inputTextbox};
						window.frame.setVisible(false);
						DetailInput.main(input);
					} catch (Exception e) {
						System.out.println("Can't load DetailInput");
						e.printStackTrace();
					}
				}else {
					inputTextbox += charInput;
				}
			}
		});
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Cordia New", Font.PLAIN, 90));
		textField.setBounds(238, 370, 1470, 161);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblScanStudentId = new JLabel("Scan Student ID");
		lblScanStudentId.setFont(new Font("Cordia New", Font.PLAIN, 72));
		lblScanStudentId.setBounds(778, 162, 349, 94);
		frame.getContentPane().add(lblScanStudentId);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Pressed");
			}
		});
		btnClear.setFont(new Font("Courier New", Font.PLAIN, 48));
		btnClear.setBounds(1393, 817, 315, 94);
		frame.getContentPane().add(btnClear);
	}
}
