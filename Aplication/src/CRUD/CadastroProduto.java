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

public class CadastroProduto {

	JFrame frame;
	private JTextField txtnome;
	private JTextField txtcodigo;
	private JTextField txtdescricao;
	private JTextField txtpid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroProduto window = new CadastroProduto();
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
	public CadastroProduto() {
		initialize();
		Connect();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 459, 441);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCadastroProduto = new JLabel("Cadastro Produto");
		lblCadastroProduto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCadastroProduto.setBounds(139, 11, 121, 23);
		frame.getContentPane().add(lblCadastroProduto);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 63, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		txtnome = new JTextField();
		txtnome.setBounds(66, 60, 180, 23);
		frame.getContentPane().add(txtnome);
		txtnome.setColumns(10);
		
		JLabel lblCdigo = new JLabel("Código ");
		lblCdigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCdigo.setBounds(10, 109, 46, 14);
		frame.getContentPane().add(lblCdigo);
		
		txtcodigo = new JTextField();
		txtcodigo.setColumns(10);
		txtcodigo.setBounds(66, 107, 180, 23);
		frame.getContentPane().add(txtcodigo);
		
		JLabel lblDescrio = new JLabel("Descrição");
		lblDescrio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDescrio.setBounds(10, 155, 46, 14);
		frame.getContentPane().add(lblDescrio);
		
		txtdescricao = new JTextField();
		txtdescricao.setColumns(10);
		txtdescricao.setBounds(66, 153, 180, 23);
		frame.getContentPane().add(txtdescricao);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome,codigo,descricao;
				
			nome=	txtnome.getText();
			codigo = txtcodigo.getText();
			descricao = txtdescricao.getText();
				try {
				      pst = con.prepareStatement("insert into Produtos(nome,codigo,descricao)values(?,?,?)");
				      pst.setString(1, nome);
				      pst.setString(2, codigo);
				      pst.setString(3, descricao);
					   
				   
				      pst.executeUpdate();
				    

				      txtnome.setText("");
				      txtcodigo.setText("");
				      txtdescricao.setText("");
				      txtnome.requestFocus();
				   }

				   catch (SQLException e1)
				   {
				      e1.printStackTrace();
				   }
				}
			});
		
		btnNewButton.setBounds(10, 200, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bid;

				  bid = txtpid.getText();


				   try {
				       pst = con.prepareStatement("delete from Produtos  where pid = ?");
				       pst.setString(1, bid);

				       pst.executeUpdate();
				      

				       txtnome.setText("");
				       txtcodigo.setText("");
				       txtdescricao.setText("");
				       txtnome.requestFocus();
				       txtpid.setText("");
				     }

				     catch (SQLException e1)
				     {

				        e1.printStackTrace();
				      }
			}
		});
		btnDelete.setBounds(10, 234, 89, 23);
		frame.getContentPane().add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pid,nome,codigo,descricao;

				nome = txtnome.getText();
				 codigo = txtcodigo.getText();
				 descricao = txtdescricao.getText();
				 pid = txtpid.getText();

				   try {
				         
				         pst = con.prepareStatement("update Produtos set nome = ?,codigo = ?,descricao = ? where pid = ?");
				         pst.setString(1, nome);
				         pst.setString(2, codigo);
				         pst.setString(3, descricao);
				         pst.setString(4, pid);

				         pst.executeUpdate();
				         

				         txtnome.setText("");
				         txtcodigo.setText("");
				         txtdescricao.setText("");
				         txtnome.requestFocus();
				         txtpid.setText("");
				      }

				    catch (SQLException e1)
				      {

				         e1.printStackTrace();
				       }
			}
		});
		btnUpdate.setBounds(10, 271, 89, 23);
		frame.getContentPane().add(btnUpdate);
		
		JLabel lblNewLabel_1 = new JLabel("Id Produto");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 336, 89, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtpid = new JTextField();
		txtpid.setBounds(88, 334, 158, 20);
		frame.getContentPane().add(txtpid);
		txtpid.setColumns(10);
		
		JButton pid = new JButton("Search");
		pid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

				      String pid = txtpid.getText();
				      pst = con.prepareStatement("select nome,codigo,descricao from Produtos where pid = ?");
				      pst.setString(1, pid);
				       ResultSet rs = pst.executeQuery();

				       if(rs.next()==true)
				           {
				               String nome = rs.getString(1);
				               String codigo = rs.getString(2);
				               String descricao = rs.getString(3);

				               txtnome.setText(nome);
				               txtcodigo.setText(codigo);
				               txtdescricao.setText(descricao);
				           }
				          else
				           {
				        	  txtnome.setText("");
				        	  txtcodigo.setText("");
				        	  txtdescricao.setText("");
				               
				             }
				   }

				    catch (SQLException ex) 
				     {
				         ex.printStackTrace();
				     }
			}
		});
		pid.setBounds(256, 333, 89, 23);
		frame.getContentPane().add(pid);
		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AplicationEstoque window = new AplicationEstoque();
				window.frame.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(344, 368, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
	}
}
