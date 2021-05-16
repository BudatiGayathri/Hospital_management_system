import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

public class ViewDoct extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewDoct frame = new ViewDoct();
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
	public ViewDoct() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 25, 588, 236);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("View Details");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/CBS","root","");
					String s="select * from doctoedet";
					Statement stm1=conn.createStatement();
					ResultSet rs=stm1.executeQuery(s);
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch(Exception e1) {System.out.println(e1);}
			}
		});
		btnNewButton.setBounds(256, 0, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Home");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddPatient home=new AddPatient();
				home.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(256, 272, 89, 23);
		contentPane.add(btnNewButton_1);
		
//		JComboBox comboBox = new JComboBox();
//		//comboBox.addItem("");
//		comboBox.setBounds(50, 90, 28, 20);
//		contentPane.add(comboBox);
//		
//		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
//		rdbtnNewRadioButton.setBounds(102, 89, 109, 23);
//		contentPane.add(rdbtnNewRadioButton);
	}
}
