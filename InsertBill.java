import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class InsertBill extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertBill frame = new InsertBill();
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
	public InsertBill() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 514, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Patient Id:");
		lblNewLabel_1.setBounds(40, 70, 83, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Patient Name:");
		lblNewLabel_2.setBounds(40, 109, 83, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("No Of Times Doctor Visited:");
		lblNewLabel_3.setBounds(40, 151, 138, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Medicine Charge:");
		lblNewLabel_4.setBounds(40, 190, 83, 14);
		contentPane.add(lblNewLabel_4);
		
		textField_1 = new JTextField();
		textField_1.setBounds(125, 67, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(125, 106, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(125, 187, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("Insert");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/CBS","root","");
					PreparedStatement ps=conn.prepareStatement("insert into billing (Id,PatientName,Doccharge,Medicinecharge,NoOfDays,RoomChargePerDay,TotalRoomCharge,Bill) values(?,?,?,?,?,?,?,?)");
					ps.setString(1,textField_1.getText() );
					ps.setString(2,textField_2.getText());
					ps.setString(4, textField_4.getText());
					int a7=Integer.parseInt(textField_4.getText());
					//doctorCharge
					String s=textField.getText();
					int a=Integer.parseInt(s);
					String s1="select Doccharge from doctoedet where DocId like (select DocId from patienttable where Id like "+textField_1.getText()+")";
					Statement stm=conn.createStatement();
					ResultSet rs=stm.executeQuery(s1);
					String s2=null;
					if(rs.next()) {
						s2=rs.getString(1);
					}
					int a1=Integer.parseInt(s2);
					int b=a*a1;
					String s3=Integer.toString(b);
					ps.setString(3, s3);
					
					//No.of days
					String s4="select dateofdisc from outpatient where Id like "+textField_1.getText()+" ";
					Statement stm1=conn.createStatement();
					ResultSet rs1=stm1.executeQuery(s4);
					String s5=null;
					if(rs1.next()) {
						s5=rs1.getString(1);
						System.out.println(s5);
					}
					String s6="select dateofadmi from inpatient where Id like "+textField_1.getText()+" ";
					Statement stm2=conn.createStatement();
					ResultSet rs2=stm2.executeQuery(s6);
					String s7=null;
					if(rs2.next()) {
						s7=rs2.getString(1);
						System.out.println(s7);
					}
					//System.out.println(a);
					//System.out.println(c);
					SimpleDateFormat myFormat=new SimpleDateFormat("yyyy-mm-dd");
					try {
						Date d1=myFormat.parse(s5);
						Date d2=myFormat.parse(s7);
						long diff=d1.getTime()-d2.getTime();
						//System.out.println(diff);
						long f=diff/(1000*60*60*24);
						
						System.out.println(f);
						String s8=Long.toString(f);
						ps.setString(5, s8);
						int a3=Integer.parseInt(s8);
						
						//RoomCharge
						String s9="Select RoomId from inpatient where Id="+textField_1.getText()+" ";
						Statement stm3=conn.createStatement();
						ResultSet rs3=stm3.executeQuery(s9);
						String s10=null;
						if(rs3.next()) {
						s10=rs3.getString(1);
						}
						System.out.print(s10);
						int a2=Integer.parseInt(s10);
						String s11="select RoomCharge from roomtable where RoomId="+a2+"";
						Statement stm4=conn.createStatement();
						ResultSet rs4=stm4.executeQuery(s11);
						String s12=null;
						if(rs4.next()) {
							s12=rs4.getString(1);
						}
						ps.setString(6, s12);
						int a4=Integer.parseInt(s12);
						int a5=a3*a4;
						String s13=Integer.toString(a5);
						ps.setString(7, s13);
						int a6=b+a7+a5;
						String s14=Integer.toString(a6);
						ps.setString(8, s14);
						int x=ps.executeUpdate();
						if(x==1) {
							String l="select BillNo from billing where Id="+textField_1.getText()+" " ;
							Statement stm5=conn.createStatement();
							ResultSet rs5=stm5.executeQuery(l);
							if(rs5.next()) {
								
							String y=rs5.getString(1);
							int j=Integer.parseInt(y);
							JOptionPane.showMessageDialog(null,"Bill No.  is "+j );
					}
					
						}
					}
					catch(Exception e1) {System.out.println(e1);}
					
					
					}
					
				
				catch(Exception e1) {System.out.println(e1);}
			}
		});
		btnNewButton.setBounds(63, 266, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateBill update=new UpdateBill();
				update.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(204, 266, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Home");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddPatient home=new AddPatient();
				home.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(340, 266, 89, 23);
		contentPane.add(btnNewButton_2);
		
		textField = new JTextField();
		textField.setBounds(183, 148, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
