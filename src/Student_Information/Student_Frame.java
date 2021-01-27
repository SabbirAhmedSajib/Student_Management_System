package Student_Information;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.mysql.jdbc.Statement;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Student_Frame {
	
	protected static final JLabel JtextAreatext = null;
	Connection con =null;
	PreparedStatement pst;
	ResultSet rs;
	
	private JFrame frame;
	private JTextField jtextStudent_Id;
	private JTextField jtextStudent_name;
	private JTextField jtextnumber;
	private JTextField jtextgender;
	private JTextField jtextBirthdate;
	protected JLabel jtextArea_2;
	private JTextField jtextSearchField;

	/**
	 * Launch the application.
	 */
	void Connection(){
		con = Connect.dbConnect();
		java.sql.Connection dis = Display.dbDisplay();
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
					Student_Frame window = new Student_Frame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Student_Frame() {
		initialize();
		Connection();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1450, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 506, 539);
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(SystemColor.scrollbar);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 12));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel level_1 = new JLabel("Student_ID :");
		level_1.setBounds(43, 50, 167, 25);
		level_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		level_1.setBackground(Color.WHITE);
		panel.add(level_1);
		
		JLabel level_2 = new JLabel("Student_Name :");
		level_2.setBounds(43, 134, 167, 25);
		level_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		level_2.setBackground(Color.WHITE);
		panel.add(level_2);
		
		JLabel level_3 = new JLabel("Phone_Number :");
		level_3.setBounds(43, 216, 188, 25);
		level_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		level_3.setBackground(Color.WHITE);
		panel.add(level_3);
		
		JLabel level_4 = new JLabel("Gender :");
		level_4.setBounds(53, 380, 167, 25);
		level_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		level_4.setBackground(Color.WHITE);
		panel.add(level_4);
		
		JLabel level_15 = new JLabel("Address :");
		level_15.setBounds(43, 452, 167, 25);
		level_15.setFont(new Font("Tahoma", Font.BOLD, 20));
		level_15.setBackground(Color.WHITE);
		panel.add(level_15);
		
		jtextStudent_Id = new JTextField();
		jtextStudent_Id.setBounds(220, 41, 188, 50);
		panel.add(jtextStudent_Id);
		jtextStudent_Id.setColumns(10);
		
		jtextStudent_name = new JTextField();
		jtextStudent_name.setBounds(220, 118, 188, 65);
		jtextStudent_name.setColumns(10);
		panel.add(jtextStudent_name);
		
		jtextnumber = new JTextField();
		jtextnumber.setBounds(220, 207, 188, 50);
		jtextnumber.setColumns(10);
		panel.add(jtextnumber);
		
		jtextgender = new JTextField();
		jtextgender.setBounds(221, 368, 187, 56);
		jtextgender.setColumns(10);
		panel.add(jtextgender);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth:");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDateOfBirth.setBackground(Color.WHITE);
		lblDateOfBirth.setBounds(43, 290, 188, 25);
		panel.add(lblDateOfBirth);
		
		jtextBirthdate = new JTextField();
		jtextBirthdate.setColumns(10);
		jtextBirthdate.setBounds(220, 280, 188, 50);
		panel.add(jtextBirthdate);
		
		JTextArea jtextAddress = new JTextArea();
		jtextAddress.setBounds(220, 436, 188, 76);
		panel.add(jtextAddress);
		
		JPanel part_2 = new JPanel();
		part_2.setBounds(526, 11, 361, 539);
		part_2.setBackground(Color.LIGHT_GRAY);
		part_2.setForeground(UIManager.getColor("Button.shadow"));
		part_2.setBorder(new LineBorder(SystemColor.controlText, 12));
		frame.getContentPane().add(part_2);
		part_2.setLayout(null);
		
		JButton btnNewButton = new JButton("Reset");
		btnNewButton.addActionListener(new ActionListener() {
			private JLabel jtextTranscript;

			public void actionPerformed(ActionEvent e) {
				
				JTextField temp = null;
				for(Component c:panel.getComponents())
				{
					if(c.getClass().toString().contains("javax.swing.JTextField")){
						temp = (JTextField)c;
						temp.setText(null);
					}
				}
				
				jtextAddress.setText(null);
				jtextTranscript.setText(null);
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(23, 38, 132, 39);
		part_2.add(btnNewButton);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSearch.addKeyListener(new KeyAdapter() {
		
		}
			
		);
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSearch.setBounds(23, 131, 124, 39);
		part_2.add(btnSearch);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frame,"Confirm if you want to exit","Student Result System",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnExit.setBounds(23, 343, 132, 39);
		part_2.add(btnExit);
		
		jtextSearchField = new JTextField();
		jtextSearchField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try {
					String sql = "select * from stdent where id= ?";
					pst = con.prepareStatement(sql);
					pst.setString(1, jtextSearchField.getText());
					rs= pst.executeQuery();
					if(rs.next())
					{
						String add1= rs.getString("Student_Id");
						jtextStudent_Id.setText(add1);
						String add2= rs.getString("Student_Name");
						jtextStudent_name.setText(add2);
						String add3= rs.getString("Phone_Number");
						jtextnumber.setText(add2);
						String add4= rs.getString("Birth_of_Date");
						jtextBirthdate.setText(add2);
						String add5= rs.getString("Gender");
						jtextgender.setText(add2);
						String add6= rs.getString("Address");
						jtextAddress.setText(add2);
						
					}
				}catch(Exception E){
					JOptionPane.showMessageDialog(null, "Information not found");
				}
				
			}
		});
		jtextSearchField.setColumns(10);
		jtextSearchField.setBounds(157, 129, 188, 50);
		part_2.add(jtextSearchField);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 try {
				        Class.forName("com.mysql.jdbc.Driver");
				        Connection con= DriverManager.getConnection("jdbc:mysql://localhost/student_information?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
				        Statement stmt=(Statement) con.createStatement();
				        String Student_Id = jtextStudent_Id.getText();
				        String Student_name = jtextStudent_name.getText();
				        String number = jtextnumber.getText();
				        String Birthdate = jtextBirthdate.getText();
				        String gender = jtextgender.getText();
				        String Address = jtextAddress.getText();
				        String sql="Insert into library values("
				                +"Student_Id"
				                +"Student_name"
				                +"Phone_number"
				                +"Birthdate"+"gender"+"Address)"
				                + "values('"+jtextStudent_Id.getText()+ "','"
				                +jtextStudent_name.getText()+ "','"+jtextnumber.getText()+ "','"+jtextBirthdate.getText()+ "','"+jtextgender.getText()+"','"+jtextAddress.getText()+"')";
				        stmt.executeUpdate(sql);
				      JOptionPane.showMessageDialog(null, "Saved");
				        
				 }catch(Exception e) {
				        JOptionPane.showMessageDialog(null, e);
				    }
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAdd.setBounds(23, 254, 132, 39);
		part_2.add(btnAdd);
		
		JPanel part_3 = new JPanel();
		part_3.setBackground(Color.LIGHT_GRAY);
		part_3.setBorder(new LineBorder(new Color(0, 0, 0), 12));
		part_3.setBounds(897, 11, 463, 539);
		frame.getContentPane().add(part_3);
		part_3.setLayout(null);
		
		JTextArea jtextTranscript = new JTextArea();
		jtextTranscript.setBounds(15, 11, 438, 517);
		part_3.add(jtextTranscript);
	}
}
