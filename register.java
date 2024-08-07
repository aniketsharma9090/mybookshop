package Book.Shop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class register extends JFrame {

	JFrame frame;
	private JTextField txtname;
	private JTextField txtcontactno;
	private JTextField txtemailid;
	private JTextField txtusername;
	private JPasswordField passwordField;
	private JPasswordField confirmpasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register window = new register();
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
	public register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 128, 255));
		frame.setBounds(100, 100, 1104, 762);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTER TO BOOKSHOP");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 38));
		lblNewLabel.setBounds(210, 52, 564, 56);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(217, 158, 147, 28);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtname = new JTextField();
		txtname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtname.setBounds(397, 156, 330, 30);
		frame.getContentPane().add(txtname);
		txtname.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Contact No");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(217, 214, 147, 28);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		txtcontactno = new JTextField();
		txtcontactno.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtcontactno.setColumns(10);
		txtcontactno.setBounds(397, 212, 330, 30);
		frame.getContentPane().add(txtcontactno);
		
		JLabel lblNewLabel_1_2 = new JLabel("Email id");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(217, 271, 147, 28);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		txtemailid = new JTextField();
		txtemailid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtemailid.setColumns(10);
		txtemailid.setBounds(397, 269, 330, 30);
		frame.getContentPane().add(txtemailid);
		
		JLabel lblNewLabel_1_3 = new JLabel("Username");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_3.setBounds(217, 326, 147, 28);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		txtusername = new JTextField();
		txtusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtusername.setColumns(10);
		txtusername.setBounds(397, 324, 330, 30);
		frame.getContentPane().add(txtusername);
		
		JLabel lblNewLabel_1_4 = new JLabel("Password");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_4.setBounds(217, 376, 147, 28);
		frame.getContentPane().add(lblNewLabel_1_4);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBackground(new Color(0, 255, 255));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtname.getText();
				String contactno = txtcontactno.getText();
				String emailid = txtemailid.getText();
				String username = txtusername.getText();
				char[] password = passwordField.getPassword();
				char[] confirmpassword = confirmpasswordField.getPassword();
				String passText = new String(passwordField.getPassword());
				boolean isCorrectpassword = Arrays.equals (password, confirmpassword);
				if(name.isBlank() || contactno.isBlank() || emailid.isBlank() || 
						username.isBlank() || passText.isBlank()) {
					JOptionPane.showMessageDialog(btnRegister, "Please fill all details");
				}
				else if(isCorrectpassword){
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop", "root", "");
						String query = "insert into user_details VALUES (?, ?, ?, ?, ?)";
						PreparedStatement ps= con.prepareStatement(query);
						ps.setString(1, txtname.getText());
						ps.setString(2, txtcontactno.getText());
						ps.setString(3, txtemailid.getText());
						ps.setString(4, txtusername.getText());
						ps.setString(5, passText);
						int i = ps.executeUpdate();
						txtname.setText("");
						txtcontactno.setText("");
						txtemailid.setText("");
						txtusername.setText("");
						passwordField.setText("");
						confirmpasswordField.setText("");
						JOptionPane.showMessageDialog(btnRegister, " Registration Successful!");
						ps.close();
						con.close();
						book_shop window = new book_shop();
						window.frame.setVisible(true);
					}
					catch(Exception e1) {
						e1.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(btnRegister, " Password not match");
				}	
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnRegister.setBounds(435, 509, 129, 42);
		frame.getContentPane().add(btnRegister);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("");
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordField.setBounds(397, 370, 330, 34);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Confirm Password");
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_4_1.setBounds(217, 433, 170, 28);
		frame.getContentPane().add(lblNewLabel_1_4_1);
		
		confirmpasswordField = new JPasswordField();
		confirmpasswordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		confirmpasswordField.setBounds(397, 427, 330, 34);
		frame.getContentPane().add(confirmpasswordField);
		
		JButton btnback = new JButton("Back");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				book_shop window = new book_shop();
				window.frame.setVisible(true);
			}
		});
		btnback.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnback.setBackground(Color.CYAN);
		btnback.setBounds(895, 656, 129, 28);
		frame.getContentPane().add(btnback);
	}
}
