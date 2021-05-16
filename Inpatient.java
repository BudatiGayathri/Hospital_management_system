import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollBar;
import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Inpatient extends JFrame {

	private JPanel contentPane;
	private final JLabel lblInPatient = new JLabel("IN PATIENT");
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inpatient frame = new Inpatient();
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
	public Inpatient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblInPatient.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblInPatient.setBounds(138, 0, 139, 31);
		contentPane.add(lblInPatient);
		
		JLabel lblNewLabel = new JLabel("Patient Id:");
		lblNewLabel.setBounds(43, 51, 63, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Date of Admission:");
		lblNewLabel_1.setBounds(43, 87, 100, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Disease:");
		lblNewLabel_2.setBounds(43, 124, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Doctor Id:");
		lblNewLabel_3.setBounds(43, 153, 63, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Doctor Name:");
		lblNewLabel_4.setBounds(43, 193, 77, 14);
		contentPane.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(103, 48, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(103, 121, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(103, 150, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(113, 190, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Add Patient");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/CBS","root","");
					PreparedStatement ps=conn.prepareStatement("insert into inpatient (Id,Name,dateofadmi,RoomId,disease,DocId,docname) values (?,?,?,?,?,?,?)");
					ps.setString(1,textField.getText());
					ps.setString(2,textField_5.getText());
					ps.setString(3,textField_4.getText());
					ps.setString(4,textField_6.getText());
					ps.setString(5,textField_1.getText());
					ps.setString(6,textField_2.getText());
					ps.setString(7,textField_3.getText());
					int x=ps.executeUpdate();
					JOptionPane.showMessageDialog(null,x+"row created");
//					String s="delete from inpatient where DocId=1";
//					Statement stm=conn.createStatement();
//					int c=stm.executeUpdate(s);
//					JOptionPane.showMessageDialog(null, c+"rows deleted");
				}
				catch(Exception e1) {
					//System.out.println(e1);
					JOptionPane.showMessageDialog(null,e1);	
				}
			}
		});
		btnNewButton.setBounds(153, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		textField_4 = new JTextField();
		textField_4.setBounds(142, 84, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Name:");
		lblNewLabel_5.setBounds(217, 51, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		textField_5.setBounds(263, 48, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("RoomId:");
		lblNewLabel_6.setBounds(241, 87, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		textField_6 = new JTextField();
		textField_6.setBounds(290, 84, 86, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
	}
}
