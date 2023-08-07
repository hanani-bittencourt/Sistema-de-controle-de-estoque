package CRUD;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroFuncionario {

	JFrame frame;
	private JTextField txtnome;
	private JTextField txtcontato;
	private JTextField txtcargo;
	private JTextField txtpid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroFuncionario window = new CadastroFuncionario();
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
	public CadastroFuncionario() {
		initialize();
		Connect();
	}
	Connection con;
	PreparedStatement pst;
	ResultSet rs;

	 public void Connect()
	    {
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost/estoque_db", "root","");
	            System.out.println("Success");
	        }
	        catch (ClassNotFoundException ex)
	        {
	                ex.printStackTrace();
	        }
	        catch (SQLException ex)
	        {
	            ex.printStackTrace();
	        }
	    }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 460, 441);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCadastroFuncionario = new JLabel("Cadastro Funcionario");
		lblCadastroFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCadastroFuncionario.setBounds(128, 11, 170, 14);
		frame.getContentPane().add(lblCadastroFuncionario);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 51, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtnome = new JTextField();
		txtnome.setColumns(10);
		txtnome.setBounds(60, 49, 192, 20);
		frame.getContentPane().add(txtnome);
		
		JLabel lblNewLabel_1_1 = new JLabel("Contato");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(10, 95, 46, 14);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		txtcontato = new JTextField();
		txtcontato.setColumns(10);
		txtcontato.setBounds(60, 93, 192, 20);
		frame.getContentPane().add(txtcontato);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Cargo");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(10, 136, 46, 14);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		txtcargo = new JTextField();
		txtcargo.setColumns(10);
		txtcargo.setBounds(60, 134, 192, 20);
		frame.getContentPane().add(txtcargo);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome,contato,cargo;

				nome = txtnome.getText();
				contato = txtcontato.getText();
				cargo = txtcargo.getText();

				try {
				      pst = con.prepareStatement("insert into Funcionario(nome,contato,cargo)values(?,?,?)");
				      pst.setString(1, nome);
				      pst.setString(2, contato);
				      pst.setString(3, cargo);
				      pst.executeUpdate();
				      JOptionPane.showMessageDialog(null,"Record Addedddddd!!!!");

				      txtnome.setText("");
				      txtcontato.setText("");
				      txtcargo.setText("");
				      txtnome.requestFocus();
				   }

				   catch (SQLException e1)
				   {
				      e1.printStackTrace();
				   }
			}
		});
		btnNewButton.setBounds(10, 180, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bid;

				  bid = txtpid.getText();


				   try {
				       pst = con.prepareStatement("delete from Funcionario  where pid = ?");
				       pst.setString(1, bid);

				       pst.executeUpdate();
				       JOptionPane.showMessageDialog(null, "Record Deleteeeeee!!!!!");

				       txtnome.setText("");
				       txtcontato.setText("");
				       txtcargo.setText("");
				       txtnome.requestFocus();
				       txtpid.setText("");
				     }

				     catch (SQLException e1)
				     {

				        e1.printStackTrace();
				      }
			}
		});
		btnDelete.setBounds(10, 214, 89, 23);
		frame.getContentPane().add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pid,nome,contato,cargo;

				 nome = txtnome.getText();
				 contato = txtcontato.getText();
				 cargo = txtcargo.getText();
				 pid = txtpid.getText();

				   try {
				         
				         pst = con.prepareStatement("update Funcionario set nome = ?,contato = ?,cargo = ? where pid = ?");
				         pst.setString(1, nome);
				         pst.setString(2, contato);
				         pst.setString(3, cargo);
				         pst.setString(4, pid);

				         pst.executeUpdate();
				         JOptionPane.showMessageDialog(null, "Record Updateee!!!!!");

				         txtnome.setText("");
				         txtcontato.setText("");
				         txtcargo.setText("");
				         txtnome.requestFocus();
				         txtpid.setText("");
				      }

				    catch (SQLException e1)
				      {

				         e1.printStackTrace();
				       }
			}
		});
		btnUpdate.setBounds(10, 248, 89, 23);
		frame.getContentPane().add(btnUpdate);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Id Funcionario");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1.setBounds(10, 304, 89, 14);
		frame.getContentPane().add(lblNewLabel_1_1_1_1);
		
		txtpid = new JTextField();
		txtpid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		txtpid.setColumns(10);
		txtpid.setBounds(94, 302, 158, 20);
		frame.getContentPane().add(txtpid);
		
		JButton pid = new JButton("Search");
		pid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

				      String pid = txtpid.getText();
				      pst = con.prepareStatement("select Nome,contato,cargo from Funcionario where pid = ?");
				      pst.setString(1, pid);
				       ResultSet rs = pst.executeQuery();

				       if(rs.next()==true)
				           {
				               String nome = rs.getString(1);
				               String contato = rs.getString(2);
				               String cargo = rs.getString(3);

				               txtnome.setText(nome);
				               txtcontato.setText(contato);
				               txtcargo.setText(cargo);
				           }
				          else
				           {
				                txtnome.setText("");
				                txtcontato.setText("");
				                txtcargo.setText("");
				                JOptionPane.showMessageDialog(null,"Invalid Product ID");

				             }
				   }

				    catch (SQLException ex) 
				     {
				         ex.printStackTrace();
				     }
				
			}
		});
		pid.setBounds(262, 301, 89, 23);
		frame.getContentPane().add(pid);
		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AplicationEstoque window = new AplicationEstoque();
				window.frame.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(345, 368, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
	}

}
