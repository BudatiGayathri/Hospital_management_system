import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN PAGE");
		lblNewLabel.setFont(new Font("MS UI Gothic", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(148, 11, 130, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username:");
		lblNewLabel_1.setBounds(86, 81, 63, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setBounds(86, 126, 63, 14);
		contentPane.add(lblNewLabel_2);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(156, 78, 134, 20);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(160, 123, 130, 20);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				try {
//					Class.forName("com.mysql.jdbc.Driver");
//					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/CBS","root","");
//					Statement stm=con.createStatement();
//					String s="select * from logintb where username='"+txtUsername.getText()+"' and password='"+passwordField.getText()+"'";
//					ResultSet rs=stm.executeQuery(s);
//					if(rs.next()) {
//						JOptionPane.showMessageDialog(null, "Login Successful");
//						AddPatient Home=new AddPatient();
//						Home.setVisible(true);
//					}
//					else {
//						JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
//					}
//				}
//				catch(Exception e) {System.out.print(e);}
					
				if((txtUsername.getText().equals("Seshasai") && passwordField.getText().equals("RawGroup")) || (txtUsername.getText().equals("Sanjay") && passwordField.getText().equals("Admin")) || (txtUsername.getText().equals("Lalitha") && passwordField.getText().equals("Admin"))) {
					JOptionPane.showMessageDialog(null, "Login Successful");
    				AddPatient Home=new AddPatient();
  					Home.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
				}
						
						
			}
			
		});
		btnNewButton.setBounds(148, 192, 89, 23);
		contentPane.add(btnNewButton);
		
		
	}
}
