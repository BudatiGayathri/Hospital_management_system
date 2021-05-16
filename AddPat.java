import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddPat extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel lblNewLabel_6;
	private JTextField textField_6;
	private JLabel lblNewLabel_7;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPat frame = new AddPat();
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
	public AddPat() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Age    :");
		lblNewLabel_1.setBounds(15, 82, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(53, 82, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Weight:");
		lblNewLabel_2.setBounds(15, 117, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(53, 114, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Gender:");
		lblNewLabel_3.setBounds(15, 142, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(53, 139, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Address:");
		lblNewLabel_4.setBounds(15, 171, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(63, 170, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Phone No. :");
		lblNewLabel_5.setBounds(15, 196, 57, 14);
		contentPane.add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		textField_5.setBounds(73, 193, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/CBS","root","");
//				String s1=lblNewLabel.getText();
//				String s2=lblNewLabel_1.getText();
//				String s3=lblNewLabel_2.getText();
//				String s4=lblNewLabel_3.getText();
//				String s5=lblNewLabel_4.getText();
//				String s6=lblNewLabel_5.getText();
				PreparedStatement ps=con.prepareStatement("insert into patienttable (Name,Age,Weight,Gender,Address,phoenno,docid) values (?,?,?,?,?,?,?)");
				//ps.setString(1,textField.getText());	//id
				ps.setString(1,textField_6.getText());//name
				ps.setString(2,textField_1.getText());//age
				ps.setString(3,textField_2.getText());//weight
				ps.setString(4,textField_3.getText());//gender
				ps.setString(5,textField_4.getText());//address
				ps.setString(6,textField_5.getText());//phoneno
				ps.setString(7,textField_7.getText());//docid
				int x=ps.executeUpdate();
				
				if(x>0) {
					System.out.println(x+"rows created");
				String s="select Id from patienttable where Name='"+textField_6.getText()+"'" ;
				Statement stm1=con.createStatement();
				ResultSet rs=stm1.executeQuery(s);
				if(rs.next()) {
					
				String y=rs.getString(1);
				int a=Integer.parseInt(y);
				JOptionPane.showMessageDialog(null,"Patient Id is "+a );
				AddPatient home=new AddPatient();
				home.setVisible(true);
				}
				else {JOptionPane.showMessageDialog(null, "Error Occured While extracting" );};
				}
				else {
					System.out.println("Error");
					}
				}
				
								
				
			 
			catch(Exception e) {System.out.print(e);}
			}
		});
		btnNewButton.setBounds(179, 214, 89, 23);
		contentPane.add(btnNewButton);
		
		lblNewLabel_6 = new JLabel("Name:");
		lblNewLabel_6.setBounds(15, 57, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		textField_6 = new JTextField();
		textField_6.setBounds(53, 54, 86, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		lblNewLabel_7 = new JLabel("Doctor_Id");
		lblNewLabel_7.setBounds(222, 171, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		textField_7 = new JTextField();
		textField_7.setBounds(278, 168, 86, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("ADD PATIENT DETAILS");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_8.setBounds(110, 11, 254, 32);
		contentPane.add(lblNewLabel_8);
	}
}
