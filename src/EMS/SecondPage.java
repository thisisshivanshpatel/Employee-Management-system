package EMS;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SecondPage extends JFrame {

	private JPanel contentPane;
	private JTextField txtfield1;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField txt6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecondPage frame = new SecondPage();
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
	public SecondPage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("imgs/businessman4.png"));
		setTitle("Employee Database Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(240, 100, 894, 598);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/businessman3.png")).getImage();
		lblLogin.setIcon(new ImageIcon(img));
		lblLogin.setBounds(383, 11, 128, 128);
		contentPane.add(lblLogin);
		
		txtfield1 = new JTextField();
		txtfield1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				txtfield1.setBackground(Color.ORANGE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				txtfield1.setBackground(new Color(0,204,51));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				StudentRecordM next =new StudentRecordM();
				next.setVisible(true);
				dispose();
			}
		});
		txtfield1.setText("Add Employee");
		txtfield1.setHorizontalAlignment(SwingConstants.CENTER);
		txtfield1.setForeground(Color.WHITE);
		txtfield1.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtfield1.setEditable(false);
		txtfield1.setColumns(10);
		txtfield1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		txtfield1.setBackground(new Color(0, 204, 51));
		txtfield1.setBounds(303, 174, 297, 38);
		contentPane.add(txtfield1);
		
		textField_1 = new JTextField();
		textField_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				textField_1.setBackground(Color.ORANGE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				textField_1.setBackground(new Color(0,204,51));
			}
		});
		textField_1.setText("Delete Employee Details");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		textField_1.setBackground(new Color(0, 204, 51));
		textField_1.setBounds(303, 300, 297, 38);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				textField_2.setBackground(Color.ORANGE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				textField_2.setBackground(new Color(0,204,51));
			}
		});
		textField_2.setText("View Employee Details");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setForeground(Color.WHITE);
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		textField_2.setBackground(new Color(0, 204, 51));
		textField_2.setBounds(303, 365, 297, 38);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				textField_3.setBackground(Color.ORANGE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				textField_3.setBackground(new Color(0,204,51));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				PswdChangePage next=new PswdChangePage();
				next.setVisible(true);
				dispose();
			}
		});
		textField_3.setText("Set Username and Password");
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setForeground(Color.WHITE);
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		textField_3.setBackground(new Color(0, 204, 51));
		textField_3.setBounds(303, 425, 297, 38);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		textField_4.setText("Close");
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setForeground(Color.WHITE);
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		textField_4.setBackground(new Color(255, 0, 51));
		textField_4.setBounds(403, 510, 96, 31);
		contentPane.add(textField_4);
		
		txt6 = new JTextField();
		txt6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				txt6.setBackground(Color.ORANGE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				txt6.setBackground(new Color(0,204,51));
			}
		});
		txt6.setText("Edit Employee Details");
		txt6.setHorizontalAlignment(SwingConstants.CENTER);
		txt6.setForeground(Color.WHITE);
		txt6.setFont(new Font("Tahoma", Font.BOLD, 15));
		txt6.setEditable(false);
		txt6.setColumns(10);
		txt6.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		txt6.setBackground(new Color(0, 204, 51));
		txt6.setBounds(303, 234, 297, 38);
		contentPane.add(txt6);
		
		setUndecorated(true);
	}
}
