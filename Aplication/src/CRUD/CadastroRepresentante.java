package CRUD;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class CadastroRepresentante {

	JFrame frame;
	private JTextField txtnome;
	private JTextField txtcontato;
	private JTextField txtpid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroRepresentante window = new CadastroRepresentante();
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
	public CadastroRepresentante() {
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
		frame.setBounds(100, 100, 437, 436);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCadastroRepresentante = new JLabel("Cadastro Representante");
		lblCadastroRepresentante.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCadastroRepresentante.setBounds(128, 11, 170, 14);
		frame.getContentPane().add(lblCadastroRepresentante);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 68, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtnome = new JTextField();
		txtnome.setColumns(10);
		txtnome.setBounds(55, 66, 192, 20);
		frame.getContentPane().add(txtnome);
		
		JLabel lblNewLabel_1_1 = new JLabel("Contato");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(10, 112, 46, 14);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		txtcontato = new JTextField();
		txtcontato.setColumns(10);
		txtcontato.setBounds(55, 110, 192, 20);
		frame.getContentPane().add(txtcontato);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome,contato;

				nome = txtnome.getText();
				contato = txtcontato.getText();
				

				try {
				      pst = con.prepareStatement("insert into Representante(nome,contato)values(?,?)");
				      pst.setString(1, nome);
				      pst.setString(2, contato);
				    
				      pst.executeUpdate();
				      JOptionPane.showMessageDialog(null,"Record Addedddddd!!!!");

				      txtnome.setText("");
				      txtcontato.setText("");
				   
				      txtnome.requestFocus();
				   }

				   catch (SQLException e1)
				   {
				      e1.printStackTrace();
				   }
				
			}
		});
		btnNewButton.setBounds(10, 156, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bid;

				  bid = txtpid.getText();


				   try {
				       pst = con.prepareStatement("delete from Representante  where pid = ?");
				       pst.setString(1, bid);

				       pst.executeUpdate();
				       JOptionPane.showMessageDialog(null, "Record Deleteeeeee!!!!!");

				       txtnome.setText("");
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
		btnDelete.setBounds(10, 190, 89, 23);
		frame.getContentPane().add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pid,nome,contato;

				nome = txtnome.getText();
				 contato = txtcontato.getText();
			
				 pid = txtpid.getText();

				   try {
				         
				         pst = con.prepareStatement("update Representante set nome = ?,contato = ? where pid = ?");
				         pst.setString(1, nome);
				         pst.setString(2, contato);
				       
				         pst.setString(3, pid);

				         pst.executeUpdate();
				         JOptionPane.showMessageDialog(null, "Record Updateee!!!!!");

				         txtnome.setText("");
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
		btnUpdate.setBounds(10, 224, 89, 23);
		frame.getContentPane().add(btnUpdate);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Id Representante");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(10, 284, 89, 14);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		txtpid = new JTextField();
		txtpid.setColumns(10);
		txtpid.setBounds(100, 282, 158, 20);
		frame.getContentPane().add(txtpid);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

				      String pid = txtpid.getText();
				      pst = con.prepareStatement("select nome,contato from Representante where pid = ?");
				      pst.setString(1, pid);
				       ResultSet rs = pst.executeQuery();

				       if(rs.next()==true)
				           {
				               String nome = rs.getString(1);
				               String contato = rs.getString(2);
				             

				               txtnome.setText(nome);
				               txtcontato.setText(contato);
				             
				           }
				          else
				           {
				                txtnome.setText("");
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
		btnNewButton_1.setBounds(270, 281, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AplicationEstoque window = new AplicationEstoque();
				window.frame.setVisible(true);
			}
			
		});
		btnNewButton_3.setBounds(322, 363, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
	}

}
