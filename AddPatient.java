import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class AddPatient extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPatient frame = new AddPatient();
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
	public AddPatient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Add Patient");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			try {
			AddPat add=new AddPat();
				add.setVisible(true);				
				}
			 
			catch(Exception e) {System.out.print(e);}
				
			}		

			
		});
		btnNewButton.setBounds(10, 61, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View Patient Details");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewPat view=new ViewPat();
				view.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(252, 61, 135, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("View Doctor Details");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewDoct a=new ViewDoct();
				a.setVisible(true);
				}
		});
		btnNewButton_3.setBounds(10, 163, 135, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("F6 HOSPITAL");
		lblNewLabel.setFont(new Font("Georgia", Font.PLAIN, 20));
		lblNewLabel.setBounds(146, 11, 146, 51);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_4 = new JButton("Insert New Bill");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertBill insert =new InsertBill();
				insert.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(10, 207, 121, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Update Existing Bill");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateBill update=new UpdateBill();
				update.setVisible(true);
			}
		});
		btnNewButton_5.setBounds(146, 207, 135, 23);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("View Bill");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewBill viewbill=new ViewBill();
				viewbill.setVisible(true);
			}
		});
		btnNewButton_6.setBounds(298, 207, 89, 23);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Add Inpatient");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inpatient inpatient=new Inpatient();
				inpatient.setVisible(true);
			}
		});
		btnNewButton_7.setBounds(10, 116, 99, 23);
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("View Room Details");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RoomDet room=new RoomDet();
				room.setVisible(true);
			}
		});
		btnNewButton_8.setBounds(252, 164, 135, 23);
		contentPane.add(btnNewButton_8);
		
		JButton btnNewButton_10 = new JButton("View Inpatient");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Viewinpat view=new Viewinpat();
				view.setVisible(true);
			}
		});
		btnNewButton_10.setBounds(280, 116, 107, 23);
		contentPane.add(btnNewButton_10);
		
		JButton btnNewButton_2 = new JButton("Out patient");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Outpatient outpatient=new Outpatient();
				outpatient.setVisible(true);
				
			}
		});
		btnNewButton_2.setBounds(146, 61, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_9 = new JButton("View Outpatient");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewOutpat outpat=new ViewOutpat();
				outpat.setVisible(true);
			}
		});
		btnNewButton_9.setBounds(146, 116, 89, 23);
		contentPane.add(btnNewButton_9);
	}
}
