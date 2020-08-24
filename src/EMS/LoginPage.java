package EMS;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class LoginPage extends JFrame {
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField txtClose;
	private JTextField txtLogin;
	private JPanel contentPane;
	

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
		setIconImage(Toolkit.getDefaultToolkit().getImage("imgs/businessman4.png"));
		setTitle("Employee Database Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(320, 180, 629, 356);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(65, 105, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(194, 159, 245, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField.setBounds(194, 218, 245, 31);
		contentPane.add(passwordField);
		
		txtClose = new JTextField();
		txtClose.setEditable(false);
		txtClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		txtClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		txtClose.setBackground(new Color(255, 0, 51));
		txtClose.setForeground(new Color(255, 255, 255));
		txtClose.setHorizontalAlignment(SwingConstants.CENTER);
		txtClose.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtClose.setText("Close");
		txtClose.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		txtClose.setColumns(10);
		txtClose.setBounds(406, 280, 96, 31);
		contentPane.add(txtClose);
		
		txtLogin = new JTextField();
		txtLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String username =textField.getText();
				String password = passwordField.getText();
				
			try
			{
				
		//		Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/up","root","patel1102");
						
				PreparedStatement st = (PreparedStatement) con.prepareStatement("Select name,password from employee where name=? and password=?");

				st.setString(1, username);
				st.setString(2, password);
				ResultSet rs = st.executeQuery();			
			
				if (rs.next()) {

					SecondPage next=new SecondPage();
					next.setVisible(true);
					dispose();

					}
				else
				{
				int dialogButton =JOptionPane.CLOSED_OPTION;
			    JOptionPane.showConfirmDialog(null,"Username or password is incorrect","Warning", dialogButton);
			    
				}
			}
			catch(Exception s)
			{
				System.out.println(s);
			}
			}
		});
	
		
		
		txtLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		txtLogin.setEditable(false);
		txtLogin.setText("Login");
		txtLogin.setHorizontalAlignment(SwingConstants.CENTER);
		txtLogin.setForeground(Color.WHITE);
		txtLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtLogin.setColumns(10);
		txtLogin.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		txtLogin.setBackground(new Color(0, 204, 51));
		txtLogin.setBounds(153, 280, 96, 31);
		contentPane.add(txtLogin);
		
		JLabel lblLogin = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/businessman3.png")).getImage();
		lblLogin.setIcon(new ImageIcon(img));
		lblLogin.setBounds(257, 20, 128, 128);
		contentPane.add(lblLogin);
		
		JLabel lblUsername = new JLabel("");
		Image imgs=new ImageIcon(this.getClass().getResource("/businessman4.png")).getImage();
		lblUsername.setIcon(new ImageIcon(imgs));
		lblUsername.setBounds(153, 146, 74, 44);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("");
		Image imgss=new ImageIcon(this.getClass().getResource("/lock.png")).getImage();
		lblPassword.setIcon(new ImageIcon(imgss));
		lblPassword.setBounds(153, 201, 74, 51);
		contentPane.add(lblPassword);
		
		setUndecorated(true); //to remove the frame outline
	}
}
