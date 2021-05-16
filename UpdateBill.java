import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class UpdateBill extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateBill frame = new UpdateBill();
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
	public UpdateBill() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bill No:");
		lblNewLabel.setBounds(50, 26, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Patient Id:");
		lblNewLabel_1.setBounds(50, 70, 57, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Details you want to update");
		lblNewLabel_2.setBounds(50, 116, 144, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Enter Value to be Added:");
		lblNewLabel_3.setBounds(50, 157, 132, 14);
		contentPane.add(lblNewLabel_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("DoctorCharge");
		comboBox.addItem("MedicineBill");
		comboBox.setBounds(192, 113, 106, 20);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			//private JComboBox comboBox;

			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/CBS","root","");
					
					if((String)comboBox.getSelectedItem()=="DoctorCharge") {
						
						String p="select Doccharge from doctoedet where DocId like (select DocId from inpatient where Id="+textField_1.getText()+")";
						Statement st=conn.createStatement();
						ResultSet m=st.executeQuery(p);
						int h1=0;
						if(m.next()) {
							String h=m.getString(1);
							h1=Integer.parseInt(h);
						}
						String s="select Doccharge,Bill from billing where Id="+textField_1.getText()+"";
						Statement stm=conn.createStatement();
						ResultSet rs=stm.executeQuery(s);
						if(rs.next()) {
						String a=rs.getString(1);
						String b=rs.getString(2);
						int c=Integer.parseInt(a);
						int d=Integer.parseInt(b);
						int f=Integer.parseInt(textField_2.getText())*h1;
						int g=d-c + f;
						String h=Integer.toString(f);
						String i=Integer.toString(g);
						PreparedStatement ps=conn.prepareStatement("update billing set Doccharge=?,Bill=? where Id="+textField_1.getText()+" and BillNo="+textField.getText() +" ");
						ps.setString(1, h);
						ps.setString(2, i);
						ps.executeUpdate();
						int x=ps.executeUpdate();
						if(x==1) {
							JOptionPane.showMessageDialog(null, x+" Row Updated");
						}
						else {
						
								JOptionPane.showMessageDialog(null, "Incorrect match for bill no. and patient id");
						}
						}
						
					}
					else if((String)comboBox.getSelectedItem()=="MedicineBill") {
						
						String s="select Medicinecharge,Bill from billing where Id="+textField_1.getText()+"";
						Statement stm=conn.createStatement();
						ResultSet rs=stm.executeQuery(s);
						if(rs.next()) {
						String a=rs.getString(1);
						String b=rs.getString(2);
						//System.out.println(a);
						//System.out.println(b);
						int c=Integer.parseInt(a);
						int d=Integer.parseInt(b);
						int f=c + Integer.parseInt(textField_2.getText());
						int g=d + Integer.parseInt(textField_2.getText());
						String h=Integer.toString(f);
						String i=Integer.toString(g);
						//System.out.println(h);
						//System.out.println(i);
						
						PreparedStatement ps=conn.prepareStatement("update billing set Medicinecharge=?,Bill=? where Id="+textField_1.getText()+" and BillNo="+textField.getText() +" ");
						ps.setString(1, h);
						ps.setString(2, i);
						ps.executeUpdate();
						
						int x=ps.executeUpdate();
						if(x==1) {
							JOptionPane.showMessageDialog(null, x+" Row Updated");
						}
						else {
							JOptionPane.showMessageDialog(null, "Incorrect match for bill no. and patient id");
						}
						
						}
				}
					}
					
				
				catch(Exception e1) {System.out.println(e1);}
			}
		});
		btnNewButton.setBounds(68, 206, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Home");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddPatient home=new AddPatient();
				home.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(258, 206, 89, 23);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(96, 23, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(108, 67, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
		
		textField_2 = new JTextField();
		textField_2.setBounds(183, 154, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
	}
}
