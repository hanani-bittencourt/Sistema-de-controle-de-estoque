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

public class CadastroEstoque {

	JFrame frame;
	private JTextField txtendereco;
	private JTextField txtpid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroEstoque window = new CadastroEstoque();
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
	public CadastroEstoque() {
		initialize();
		Connect();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 419, 366);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro Estoque");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(151, 11, 121, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Endereço");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 66, 96, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtendereco = new JTextField();
		txtendereco.setBounds(86, 67, 193, 20);
		frame.getContentPane().add(txtendereco);
		txtendereco.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String endereco;
			endereco=	txtendereco.getText();
			try {
			      pst = con.prepareStatement("insert into Estoque(Endereco)values(?)");
			      pst.setString(1, endereco);
			   
			      pst.executeUpdate();
			     

			      txtendereco.setText("");
			      txtendereco.requestFocus();
			   }

			   catch (SQLException e1)
			   {
			      e1.printStackTrace();
			   }
			}
		});
		btnNewButton.setBounds(10, 98, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bid;

				  bid = txtpid.getText();


				   try {
				       pst = con.prepareStatement("delete from Estoque  where pid = ?");
				       pst.setString(1, bid);

				       pst.executeUpdate();
				      

				       txtpid.setText("");
				      
				       txtpid.requestFocus();
				       
				     }

				     catch (SQLException e1)
				     {

				        e1.printStackTrace();
				      }
			}
		});
		btnNewButton_1.setBounds(10, 132, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String endereco,pid;

				endereco= txtendereco.getText();
				 pid = txtpid.getText();

				   try {
				         
				         pst = con.prepareStatement("update Estoque set endereco = ? where pid = ?");
				         pst.setString(1, endereco);
				       
				         pst.setString(2, pid);

				         pst.executeUpdate();
				        

				         txtendereco .setText("");
				         
				         txtpid.setText("");
				      }

				    catch (SQLException e1)
				      {

				         e1.printStackTrace();
				       }
			}
		});
		btnNewButton_2.setBounds(10, 166, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("Id Endereço");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 231, 89, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		txtpid = new JTextField();
		txtpid.setBounds(93, 232, 186, 14);
		frame.getContentPane().add(txtpid);
		txtpid.setColumns(10);
		
		JButton pid = new JButton("Search");
		pid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

				      String pid = txtpid.getText();
				      pst = con.prepareStatement("select Endereco from Estoque where pid = ?");
				      pst.setString(1, pid);
				       ResultSet rs = pst.executeQuery();

				       if(rs.next()==true)
				           {
				               String endereco = rs.getString(1);
				               
				               txtendereco.setText(endereco);
				           }

				               
				          else
				           {
				        	  
				        	  txtendereco.setText("");
				           

				             }
				   }

				    catch (SQLException ex) 
				     {
				         ex.printStackTrace();
				     }
			}
		});
		pid.setBounds(289, 228, 89, 23);
		frame.getContentPane().add(pid);
		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AplicationEstoque window = new AplicationEstoque();
				window.frame.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(289, 293, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
	}
}
