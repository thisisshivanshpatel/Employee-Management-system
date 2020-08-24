package EMS;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PswdChangePage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField txtBack;
	private JTextField textField_2;
	private JTextField txtSet;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PswdChangePage frame = new PswdChangePage();
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
	public PswdChangePage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("imgs/businessman4.png"));
		setTitle("Employee Database Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(240, 100, 894, 598);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/lock.png")).getImage();
		lblLogin.setIcon(new ImageIcon(img));
		lblLogin.setBounds(415, 11, 90, 107);
		contentPane.add(lblLogin);
		
		JLabel lblEnterYourNew = new JLabel("Enter your new username and password");
		lblEnterYourNew.setForeground(new Color(255, 255, 255));
		lblEnterYourNew.setBackground(new Color(255, 255, 255));
		lblEnterYourNew.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEnterYourNew.setBounds(246, 109, 421, 86);
		contentPane.add(lblEnterYourNew);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField.setBounds(322, 231, 284, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField.setBounds(322, 301, 284, 30);
		contentPane.add(passwordField);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setForeground(new Color(0, 0, 0));
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUserName.setBounds(229, 234, 110, 22);
		contentPane.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(0, 0, 0));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(229, 303, 83, 22);
		contentPane.add(lblPassword);
		
		txtBack = new JTextField();
		txtBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SecondPage next=new SecondPage();
				next.setVisible(true);
				dispose();
				
			}
		});
		txtBack.setText("Back");
		txtBack.setHorizontalAlignment(SwingConstants.CENTER);
		txtBack.setForeground(Color.WHITE);
		txtBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtBack.setEditable(false);
		txtBack.setColumns(10);
		txtBack.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		txtBack.setBackground(new Color(153, 51, 153));
		txtBack.setBounds(189, 497, 96, 31);
		contentPane.add(txtBack);
		
		textField_2 = new JTextField();
		textField_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		textField_2.setText("Close");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setForeground(Color.WHITE);
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		textField_2.setBackground(new Color(255, 0, 51));
		textField_2.setBounds(592, 497, 96, 31);
		contentPane.add(textField_2);
		
		txtSet = new JTextField();
		txtSet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String username=textField.getText();
				String pass=passwordField.getText();
			
				if(pass.length()<4 || pass.length()>4)
				{
					int dialogButton =JOptionPane.CLOSED_OPTION;
				    JOptionPane.showConfirmDialog(null,"Password length should be 4 not more than 4 or less than 4","Warning", dialogButton);
				    
				}
				else
				{
					int password=Integer.parseInt(pass);
					
					try
					{
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/up","root","patel1102");
						
						PreparedStatement st = (PreparedStatement) con.prepareStatement("update employee set name=? , password=? where id=1");

						st.setString(1, username);
						st.setInt(2,password);
						int rs = st.executeUpdate();	
					}
					catch(Exception D)
					{
						System.out.println(D);
					}
					
					
					int dialogButton =JOptionPane.CLOSED_OPTION;
				    JOptionPane.showConfirmDialog(null,"Username and Password setted sucessfully","confirmation Message", dialogButton);
				   
				}
				
				 
			}
		});
		txtSet.setText("Set");
		txtSet.setHorizontalAlignment(SwingConstants.CENTER);
		txtSet.setForeground(Color.WHITE);
		txtSet.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtSet.setEditable(false);
		txtSet.setColumns(10);
		txtSet.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		txtSet.setBackground(new Color(0, 204, 51));
		txtSet.setBounds(402, 374, 96, 31);
		contentPane.add(txtSet);
		
		setUndecorated(true);
	}
}
