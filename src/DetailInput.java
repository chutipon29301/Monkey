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
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DetailInput {

	private static DetailInput window;
	private JFrame frame;
	private JLabel lblStudentId, lblSubject;
	private JTextField textField;
	private JButton btnCancel;
	private String inputTextbox = "";
	private JButton btnClear;
	private JButton btnPrint;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		window = new DetailInput();
		try {
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
		lblSubject.setBounds(99, 165, 471, 84);
		frame.getContentPane().add(lblSubject);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char charInput = arg0.getKeyChar();
				if(charInput == '\n'){
				}else {
					inputTextbox += charInput;
				}
			}
		});
		textField.setBounds(99, 373, 1036, 126);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.frame.setVisible(false);
				Index.main(null);
			}
		});
		btnCancel.setBounds(1466, 754, 227, 84);
		frame.getContentPane().add(btnCancel);
		
		btnClear = new JButton("Clear");
		btnClear.setBounds(1114, 754, 227, 84);
		frame.getContentPane().add(btnClear);
		
		btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(inputTextbox);
			}
		});
		btnPrint.setBounds(99, 754, 227, 89);
		frame.getContentPane().add(btnPrint);
	}
}
