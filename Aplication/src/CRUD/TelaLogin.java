package CRUD;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaLogin {

	JFrame frame;
	private JTextField txtuser;
	private JPasswordField txtpssword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin window = new TelaLogin();
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
	public TelaLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 832, 487);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sistema de Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(327, 11, 263, 37);
		frame.getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 53, 796, 11);
		frame.getContentPane().add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Aspire\\Downloads\\icons8-password-24.png"));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(327, 191, 127, 52);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtuser = new JTextField();
		txtuser.setBounds(272, 138, 213, 20);
		frame.getContentPane().add(txtuser);
		txtuser.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("User");
		lblNewLabel_1_1.setIcon(new ImageIcon("C:\\Users\\Aspire\\Downloads\\icons8-user-30.png"));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(337, 75, 170, 52);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		txtpssword = new JPasswordField();
		txtpssword.setBounds(272, 255, 213, 20);
		frame.getContentPane().add(txtpssword);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password =  txtpssword.getText();
				String username = txtuser.getText();
				
				if(password.contains("king") && username.contains("one")) {
					 txtpssword.setText(null);
					 txtuser.setText(null);
					 AplicationEstoque window = new AplicationEstoque();
						window.frame.setVisible(true);
				}
				else {
					JOptionPane.showInternalMessageDialog(null, "Invalid Login Detals", "Login Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Aspire\\Downloads\\icons8-login-30.png"));
		btnNewButton.setBounds(131, 370, 127, 46);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setIcon(new ImageIcon("C:\\Users\\Aspire\\Downloads\\icons8-exit-30.png"));
		btnExit.setBounds(482, 370, 127, 46);
		frame.getContentPane().add(btnExit);
	}
}
