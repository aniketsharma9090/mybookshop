package Book.Shop;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPasswordField;


public class book_shop {

	JFrame frame;
	private JTextField txtusername;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					book_shop window = new book_shop();
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
	public book_shop() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(244, 255, 147));
		frame.setBounds(100, 100, 1104, 745);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME TO MY BOOK SHOP");
		lblNewLabel.setForeground(new Color(64, 0, 0));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 41));
		lblNewLabel.setBounds(175, 121, 697, 70);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User Name");
		lblNewLabel_1.setBackground(new Color(0, 255, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(269, 228, 126, 34);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtusername = new JTextField();
		txtusername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtusername.setBounds(423, 228, 268, 34);
		frame.getContentPane().add(txtusername);
		txtusername.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBackground(new Color(0, 255, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(269, 273, 126, 34);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnlogin = new JButton("Login");
		btnlogin.setBackground(new Color(0, 255, 64));
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop", "root", "Aniket123@");
					String query = "select * from user_details where username = ?";
					PreparedStatement ps= con.prepareStatement(query);
					ps.setString(1, txtusername.getText());
					ResultSet rs= ps.executeQuery();
					String corrpassword = null;
					
					while(rs.next()) {
						corrpassword = rs.getString("password");
					}
					String inputpass = new String(passwordField.getPassword());
					
					if(corrpassword == null) {
						JOptionPane.showMessageDialog(btnlogin, " Wrong Username!");
					}
					else if(inputpass.compareTo(corrpassword)==0) {
						dashboard window = new dashboard();
						window.frame.setVisible(true);
//						JOptionPane.showMessageDialog(btnlogin, " Login successfully!");
						}
					else {
						JOptionPane.showMessageDialog(btnlogin, " Wrong password!");
					}
					
					ps.close();
					con.close();
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnlogin.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnlogin.setBounds(352, 349, 111, 34);
		frame.getContentPane().add(btnlogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBackground(new Color(255, 255, 0));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register window = new register();
				window.frame.setVisible(true);				
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnRegister.setBounds(513, 349, 148, 34);
		frame.getContentPane().add(btnRegister);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField.setBounds(423, 276, 268, 31);
		frame.getContentPane().add(passwordField);
	}
}
