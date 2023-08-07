package CRUD;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
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

public class CadastroFabricante {

	JFrame frame;
	private JTextField txtnome;
	private JTextField txtendereco;
	private JTextField txtcontato;
	private JTextField txtpid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroFabricante window = new CadastroFabricante();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
	 * Create the application.
	 */
	public CadastroFabricante() {
		initialize();
		Connect();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 463, 437);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 447, 2);
		frame.getContentPane().add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("Cadastro Fabricante");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(161, 11, 142, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 61, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtnome = new JTextField();
		txtnome.setBounds(66, 59, 192, 20);
		frame.getContentPane().add(txtnome);
		txtnome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Endereço");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 105, 57, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		txtendereco = new JTextField();
		txtendereco.setColumns(10);
		txtendereco.setBounds(66, 103, 192, 20);
		frame.getContentPane().add(txtendereco);
		
		JLabel lblNewLabel_2_1 = new JLabel("Contato");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_1.setBounds(10, 153, 57, 14);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		txtcontato = new JTextField();
		txtcontato.setColumns(10);
		txtcontato.setBounds(66, 151, 192, 20);
		frame.getContentPane().add(txtcontato);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome,endereco,contato;

				nome= txtnome.getText();
				endereco = txtendereco.getText();
				contato = txtcontato.getText();

				try {
				      pst = con.prepareStatement("insert into Fabricante(nome,endereco,contato)values(?,?,?)");
				      pst.setString(1, nome);
				      pst.setString(2, endereco);
				      pst.setString(3, contato);
				      pst.executeUpdate();
				     

				      txtnome.setText("");
				      txtendereco.setText("");
				      txtcontato.setText("");
				      txtnome.requestFocus();
				   }

				   catch (SQLException e1)
				   {
				      e1.printStackTrace();
				   }
			}
		});
		btnNewButton.setBounds(10, 206, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bid;

				  bid = txtpid.getText();


				   try {
				       pst = con.prepareStatement("delete from Fabricante  where pid = ?");
				       pst.setString(1, bid);

				       pst.executeUpdate();
				      

				       txtnome.setText("");
				       txtendereco.setText("");
				       txtcontato.setText("");
				       txtnome.requestFocus();
				       txtpid.setText("");
				     }

				     catch (SQLException e1)
				     {

				        e1.printStackTrace();
				      }
			}
		});
		btnDelete.setBounds(10, 240, 89, 23);
		frame.getContentPane().add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pid,nome,endereco,contato;

				 nome = txtnome.getText();
				 endereco = txtendereco.getText();
				 contato = txtcontato.getText();
				 pid = txtpid.getText();

				   try {
				         
				         pst = con.prepareStatement("update Fabricante set nome = ?,endereco = ?,contato = ? where pid = ?");
				         pst.setString(1, nome);
				         pst.setString(2, endereco);
				         pst.setString(3, contato);
				         pst.setString(4, pid);

				         pst.executeUpdate();
				         

				         txtnome.setText("");
				         txtendereco.setText("");
				         txtcontato.setText("");
				         txtnome.requestFocus();
				         txtpid.setText("");
				      }

				    catch (SQLException e1)
				      {

				         e1.printStackTrace();
				       }
				
			}
		});
		btnUpdate.setBounds(10, 274, 89, 23);
		frame.getContentPane().add(btnUpdate);
		
		JLabel lblNewLabel_1_1 = new JLabel("Id Fabricante");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(10, 330, 89, 14);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		txtpid = new JTextField();
		txtpid.setColumns(10);
		txtpid.setBounds(90, 328, 158, 20);
		frame.getContentPane().add(txtpid);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

				      String pid = txtpid.getText();
				      pst = con.prepareStatement("select nome,endereco,contato from Fabricante where pid = ?");
				      pst.setString(1, pid);
				       ResultSet rs = pst.executeQuery();

				       if(rs.next()==true)
				           {
				               String nome = rs.getString(1);
				               String endereco = rs.getString(2);
				               String contato = rs.getString(3);

				               txtnome.setText(nome);
				               txtendereco.setText(endereco);
				               txtcontato.setText(contato);
				           }
				          else
				           {
				                txtnome.setText("");
				                txtendereco.setText("");
				                txtcontato.setText("");
				                JOptionPane.showMessageDialog(null,"Invalid Product ID");

				             }
				   }

				    catch (SQLException ex) 
				     {
				         ex.printStackTrace();
				     }
			}
		});
		btnNewButton_1.setBounds(258, 327, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AplicationEstoque window = new AplicationEstoque();
				window.frame.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(348, 364, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
	}

}
