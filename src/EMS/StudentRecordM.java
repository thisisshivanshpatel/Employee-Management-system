package EMS;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Formatter;

import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import com.toedter.calendar.JDateChooser;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.JProgressBar;
import javax.swing.JToggleButton;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StudentRecordM extends JFrame {

	private JPanel contentPane;
	private JTextField jtxtFirstName;
	private JTextField jtxtLastName;
	private JRadioButton male;
	private JRadioButton female;
	private JTextField adharno;
	private JTextField mob;
	private JTextField bank;
	private JTextField txtSelectImage;

	/**
	 * Launch the application.
	 */
	
	 static String imgadd;
	
	public static void pasteImgadd(String a)
	{
		imgadd=a;
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentRecordM frame = new StudentRecordM();
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
	public StudentRecordM() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("imgs/businessman4.png"));
		setTitle("Employee Database Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1182, 584);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(51, 153, 255), 12));
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(10, 11, 1146, 444);
		contentPane.add(panel);
		
		jtxtFirstName = new JTextField();
		jtxtFirstName.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		jtxtFirstName.setColumns(10);
		jtxtFirstName.setBounds(195, 22, 151, 26);
		panel.add(jtxtFirstName);
		
		JLabel label_1 = new JLabel("First Name:");
		label_1.setFont(new Font("Consolas", Font.BOLD, 18));
		label_1.setBounds(52, 26, 116, 25);
		panel.add(label_1);
		
		jtxtLastName = new JTextField();
		jtxtLastName.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		jtxtLastName.setColumns(10);
		jtxtLastName.setBounds(195, 63, 151, 26);
		panel.add(jtxtLastName);
		
		JLabel label_2 = new JLabel("Last Name:");
		label_2.setFont(new Font("Consolas", Font.BOLD, 18));
		label_2.setBounds(52, 64, 116, 25);
		panel.add(label_2);
		
		JLabel lblDesignation = new JLabel("Designation:");
		lblDesignation.setFont(new Font("Consolas", Font.BOLD, 18));
		lblDesignation.setBounds(52, 114, 133, 25);
		panel.add(lblDesignation);
		
		JLabel label_4 = new JLabel("Gender:");
		label_4.setFont(new Font("Consolas", Font.BOLD, 18));
		label_4.setBounds(52, 193, 116, 25);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("DOB:");
		label_5.setFont(new Font("Consolas", Font.BOLD, 18));
		label_5.setBounds(52, 225, 116, 25);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("Address:");
		label_6.setFont(new Font("Consolas", Font.BOLD, 18));
		label_6.setBounds(52, 272, 116, 25);
		panel.add(label_6);
		
		JTextArea jtxtAddress = new JTextArea();
		jtxtAddress.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		jtxtAddress.setBounds(195, 272, 238, 118);
		panel.add(jtxtAddress);
		
		male = new JRadioButton("Male");
		male.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(male.isSelected())
				{		
					female.setSelected(false);
				}
			}
		});
		male.setFont(new Font("Consolas", Font.BOLD, 18));
		male.setBackground(SystemColor.textHighlight);
		male.setBounds(193, 193, 65, 23);
		panel.add(male);
		
		female = new JRadioButton("Female");
		female.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(female.isSelected())
				{		
					male.setSelected(false);
				}
			}
		});
		female.setFont(new Font("Consolas", Font.BOLD, 18));
		female.setBackground(SystemColor.textHighlight);
		female.setBounds(270, 193, 90, 23);
		panel.add(female);
		
		JComboBox designation = new JComboBox();
		designation.setFont(new Font("Consolas", Font.BOLD, 12));
		designation.setBounds(195, 114, 151, 22);
		panel.add(designation);
		designation.addItem("None");
		designation.addItem("Software Devloper");
		designation.addItem("Web Devloper");
		designation.addItem("Data Analyst");
		designation.addItem("AI Devloper");
		designation.setSelectedItem("COURSES");
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(195, 225, 151, 25);
		panel.add(dateChooser);
		
		JLabel label_4_1 = new JLabel("Adhar No:");
		label_4_1.setFont(new Font("Consolas", Font.BOLD, 18));
		label_4_1.setBounds(52, 157, 116, 25);
		panel.add(label_4_1);
		
		adharno = new JTextField();
		adharno.setBounds(195, 158, 151, 23);
		panel.add(adharno);
		adharno.setColumns(10);
		
		JLabel label_4_1_3 = new JLabel("Image:");
		label_4_1_3.setFont(new Font("Consolas", Font.BOLD, 18));
		label_4_1_3.setBounds(597, 137, 116, 25);
		panel.add(label_4_1_3);
		
		JLabel label_4_1_2 = new JLabel("Bank Ac No:");
		label_4_1_2.setFont(new Font("Consolas", Font.BOLD, 18));
		label_4_1_2.setBounds(597, 78, 116, 25);
		panel.add(label_4_1_2);
		
		JLabel label_4_1_1 = new JLabel("Mobile No:");
		label_4_1_1.setFont(new Font("Consolas", Font.BOLD, 18));
		label_4_1_1.setBounds(597, 26, 116, 25);
		panel.add(label_4_1_1);
		
		mob = new JTextField();
		mob.setBounds(741, 25, 198, 26);
		panel.add(mob);
		mob.setColumns(10);
		
		bank = new JTextField();
		bank.setColumns(10);
		bank.setBounds(741, 76, 198, 26);
		panel.add(bank);
		
		txtSelectImage = new JTextField();
		txtSelectImage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel imageLabel = new JLabel("");
				imageLabel.setBounds(687, 178, 278, 255);
				panel.add(imageLabel);
				
				JFileChooser browseImageFile=new JFileChooser();
			     FileNameExtensionFilter fnef=new FileNameExtensionFilter("IMAGES", "png","PNG","jpg","JPG","jpeg");
			     browseImageFile.addChoosableFileFilter(fnef);
				int showopendialog= browseImageFile.showOpenDialog(null);
				if(showopendialog == JFileChooser.APPROVE_OPTION)
				{
				java.io.File selectedImageFile=	browseImageFile.getSelectedFile();
				String selectedImagepath= selectedImageFile.getAbsolutePath();
			//	JOptionPane.showMessageDialog(null,selectedImagepath);
				
				ImageIcon li=new ImageIcon(selectedImagepath);
				Image img=li.getImage().getScaledInstance(imageLabel.getWidth(),imageLabel.getHeight(), Image.SCALE_SMOOTH);
			  
				imageLabel.setIcon(new ImageIcon(img));
				
				pasteImgadd(selectedImagepath);
				}
			}
		});
		txtSelectImage.setText("select image");
		txtSelectImage.setHorizontalAlignment(SwingConstants.CENTER);
		txtSelectImage.setForeground(Color.WHITE);
		txtSelectImage.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtSelectImage.setEditable(false);
		txtSelectImage.setColumns(10);
		txtSelectImage.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		txtSelectImage.setBackground(new Color(0, 204, 51));
		txtSelectImage.setBounds(775, 138, 133, 31);
		panel.add(txtSelectImage);
		
	
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(51, 153, 255), 12));
		panel_2.setBackground(SystemColor.textHighlight);
		panel_2.setBounds(12, 466, 1144, 68);
		contentPane.add(panel_2);
		
		JButton button = new JButton("Confirm");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selection="none";
				if(male.isSelected())
				{
					selection="Male";
				}
				if(female.isSelected())
				{
					selection="Female";
				}
				java.text.SimpleDateFormat fmt = new java.text.SimpleDateFormat("dd-MM-yyy");
				String formattedDate1 = fmt.format(dateChooser.getDate());
				String FirstName=jtxtFirstName.getText(),
						LastName=jtxtLastName.getText(),
						DOB=formattedDate1 ,
						Address=jtxtAddress.getText(),
						Gender=selection,
						c1=designation.getSelectedItem().toString(),
				        Adhar=adharno.getText(),
				        mobile=mob.getText(),
				        bankac=bank.getText();
				
				if(mobile.length()>10 || mobile.length()<10)
				{
					int dialogButton =JOptionPane.CLOSED_OPTION;
				    JOptionPane.showConfirmDialog(null,"Mobile number should contain 10 digit","Warning", dialogButton);
				    
			    }
				else if(Adhar.length()>12 || Adhar.length()<12)
				{
					int dialogButton =JOptionPane.CLOSED_OPTION;
				    JOptionPane.showConfirmDialog(null,"Adhar number should contain 12 digit","Warning", dialogButton);
				    
				}
				else if(bankac.length()>10 || bankac.length()<10) {
					int dialogButton =JOptionPane.CLOSED_OPTION;
				    JOptionPane.showConfirmDialog(null,"Bank Account number should be of 10 digit","Warning", dialogButton);				    
				}
				else
				{
					try
					{
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/up","root","patel1102");
						
						PreparedStatement st = (PreparedStatement) con.prepareStatement("insert into employeedetails"
								+ "(Firstname,Lastname,designation,gender,adharno,dob,address,mobile,bankac,image)"
								+ "values(?,?,?,?,?,?,?,?,?,?);");
						

						st.setString(1,FirstName);
						st.setString(2,LastName);
						st.setString(3,c1);
						st.setString(4,Gender);
						st.setString(5, Adhar);
						st.setString(6, DOB);
						st.setString(7, Address);
						st.setString(8,mobile);
						st.setString(9,bankac);
						st.setString(10,imgadd);
						int rs = st.executeUpdate();
						
						int dialogButton =JOptionPane.CLOSED_OPTION;
					    JOptionPane.showConfirmDialog(null,"Employee Details saved Sucessfully","confirmation", dialogButton);				
						
					}
					catch(Exception D)
					{
						System.out.println(D);
					}
					
				}
			}
		});
		button.setFont(new Font("Consolas", Font.BOLD, 18));
		button.setBounds(46, 16, 135, 34);
		panel_2.add(button);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField temp=null;
				for(Component c:panel.getComponents()) {
					if(c.getClass().toString().contains("javax.swing.JTextField")) {
						temp=(JTextField)c;
						temp.setText(null);
					}
				}
		//	jtxtTranscript.setText(null);
			jtxtAddress.setText(null);
			}
			
		});
		btnReset.setFont(new Font("Consolas", Font.BOLD, 18));
		btnReset.setBounds(589, 16, 135, 34);
		panel_2.add(btnReset);
		
		JButton button_3 = new JButton("Exit");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	/*
				if(JOptionPane.showConfirmDialog(this, "Confirm if you want to exit", "Student information System",
						JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION ) {
					System.exit(0);
				}
	*/                  dispose();		
			}
		});
		button_3.setFont(new Font("Consolas", Font.BOLD, 18));
		button_3.setBounds(873, 16, 135, 34);
		panel_2.add(button_3);
		
		JButton button_4 = new JButton("Back");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SecondPage next=new SecondPage();
				next.setVisible(true);
				dispose();
			}
		});
		
		button_4.setFont(new Font("Consolas", Font.BOLD, 18));
		button_4.setBounds(292, 16, 135, 34);
		panel_2.add(button_4);
	}
}
