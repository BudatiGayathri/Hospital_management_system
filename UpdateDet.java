import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class UpdateDet extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateDet frame = new UpdateDet();
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
	public UpdateDet() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update Patient Details");
		lblNewLabel.setFont(new Font("Sitka Heading", Font.BOLD, 20));
		lblNewLabel.setBounds(105, 11, 211, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Patient Id:");
		lblNewLabel_1.setBounds(52, 55, 63, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(127, 52, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Name");
		comboBox.addItem("Age");
		comboBox.addItem("Weight");
		comboBox.addItem("Gender");
		comboBox.addItem("Address");
		comboBox.addItem("Phone No.");
		comboBox.addItem("DoctorId");
		comboBox.setBounds(159, 93, 109, 20);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Details To update:");
		lblNewLabel_2.setBounds(52, 96, 97, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Enter details which you want to update:");
		lblNewLabel_3.setBounds(52, 137, 199, 14);
		contentPane.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(259, 134, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/CBS","root","");
					if((String)comboBox.getSelectedItem()=="Name") {
						PreparedStatement ps=conn.prepareStatement("update patienttable set Name='"+textField_1.getText()+"' where Id="+textField.getText()+" ");
						ps.executeUpdate();
					}
					else if((String)comboBox.getSelectedItem()=="Address") {
						PreparedStatement ps=conn.prepareStatement("update patienttable set Address='"+textField_1.getText()+"' where Id="+textField.getText()+" ");
						ps.executeUpdate();
					}
					else if((String)comboBox.getSelectedItem()=="Age") {
						PreparedStatement ps=conn.prepareStatement("update patienttable set Age="+textField_1.getText()+" where Id="+textField.getText()+" ");
						ps.executeUpdate();
					}
					else if((String)comboBox.getSelectedItem()=="Weight") {
						PreparedStatement ps=conn.prepareStatement("update patienttable set Address="+textField_1.getText()+" where Id="+textField.getText()+" ");
						ps.executeUpdate();
					}
					else if((String)comboBox.getSelectedItem()=="Phone No.") {
						PreparedStatement ps=conn.prepareStatement("update patienttable set phoenno='"+textField_1.getText()+"' where Id="+textField.getText()+" ");
						ps.executeUpdate();
					}
					else if((String)comboBox.getSelectedItem()=="Gender") {
						PreparedStatement ps=conn.prepareStatement("update patienttable set Gender='"+textField_1.getText()+"' where Id="+textField.getText()+" ");
						ps.executeUpdate();
					}
				
					JOptionPane.showMessageDialog(null,"1 row updated");	
				}
				catch(Exception e1) {
					System.out.println(e1);
					//JOptionPane.showMessageDialog(null,e1);	
				}
			}
		});
		btnNewButton.setBounds(124, 191, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Home");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddPatient home=new AddPatient();
				home.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(270, 191, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
