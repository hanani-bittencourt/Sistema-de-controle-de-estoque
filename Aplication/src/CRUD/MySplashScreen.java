package CRUD;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;
import java.awt.Color;

public class MySplashScreen extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JProgressBar progressBar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MySplashScreen frame = new MySplashScreen(null);
			frame.setVisible(true);
			
			

		} catch (Exception e) {
			
			
			e.printStackTrace();
		}
	
	try {
		
		TelaLogin window = new TelaLogin();
		window.frame.setVisible(true);
		

	} catch (Exception e) {
		
		
		e.printStackTrace();
	}
}

	/**
	 * Create the frame.
	 */
	public MySplashScreen(JFrame parent) throws Exception {
		super(parent);
		setUndecorated(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		java.awt.Point center= java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		int windowWidth=450;
		int windowHeight=300;		
		setBounds(center.x-windowWidth/2, center.y - windowHeight/2, windowWidth, windowHeight);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 450, 300);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Aspire\\Downloads\\TecInfo (1).png"));
		lblNewLabel.setBounds(10, 86, 430, 144);
		panel.add(lblNewLabel);

		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setBounds(60, 275, 327, 14);
		panel.add(progressBar);

		this.setVisible(true);
		this.repaint();
		Thread th = new Thread(new Runnable() {
			public void run() {
				try {
					for (int i = 0; i <= 50; i++) {
						Thread.sleep(100);
						progressBar.setValue(i * 2);
						

					}
				} catch (Exception e) {
					System.out.println(e);
				}

			}

		});
		th.start();
		th.join();
	}

	public JProgressBar getProgressBar() {
		return progressBar;
	}

	public void closeMySplashScreen() {
		this.setVisible(false);
		this.dispose();
		
		

	}
}
