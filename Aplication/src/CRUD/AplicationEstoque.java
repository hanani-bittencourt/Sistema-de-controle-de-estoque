package CRUD;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;

public class AplicationEstoque {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AplicationEstoque window = new AplicationEstoque();
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
	public AplicationEstoque() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 828, 486);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SISTEMA DE CADASTRO DE ESTOQUE");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Aspire\\Downloads\\icons8-caixa-50.png"));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(224, 11, 415, 59);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Cadastrar Estoque");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Aspire\\Downloads\\icons8-system-30.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroEstoque window = new CadastroEstoque();
				window.frame.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(21, 92, 157, 39);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cadastrar Produtos");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Aspire\\Downloads\\icons8-system-30.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroProduto window = new CadastroProduto();
				window.frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(17, 161, 161, 39);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cadastrar  Fabricantes");
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\Aspire\\Downloads\\icons8-system-30.png"));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroFabricante window = new CadastroFabricante();
				window.frame.setVisible(true);
				
			}
		});
		btnNewButton_2.setBounds(224, 92, 168, 39);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Cadastrar Representantes");
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\Aspire\\Downloads\\icons8-system-30.png"));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroRepresentante window = new CadastroRepresentante();
				window.frame.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(232, 161, 160, 39);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Cadastrar Funcionarios");
		btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\Aspire\\Downloads\\icons8-system-30.png"));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroFuncionario window = new CadastroFuncionario();
				window.frame.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(428, 92, 168, 39);
		frame.getContentPane().add(btnNewButton_4);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(17, 68, 785, 13);
		frame.getContentPane().add(separator);
	}
}
