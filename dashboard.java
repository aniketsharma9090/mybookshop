package Book.Shop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class dashboard  {

	JFrame frame;
	private JTextField txtbookid;
	private JTextField txtbookname;
	private JTextField txtauthor;
	private JTextField txtprice;
	private JTextField txtquantity;
	private JTextField txtstockbookid;
	private JTextField txtstockbookname;
	private JTextField txtstockauthor;
	private JTextField txtstockprice;
	private JTextField txtsearchbookid;
	private JTextField txtstockquanity;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dashboard window = new dashboard();
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
	public dashboard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 172));
		frame.setBounds(100, 100, 1106, 758);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME TO BOOKSHOP DASHBOARD");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(207, 10, 611, 50);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnlogout = new JButton("Logout");
		btnlogout.setBackground(new Color(255, 0, 0));
		btnlogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btnlogout, " Thanks logout Successful!");
				book_shop window = new book_shop();
				window.frame.setVisible(true);
				
			}
		});
		btnlogout.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnlogout.setBounds(908, 623, 125, 31);
		frame.getContentPane().add(btnlogout);
		
		JButton btnStockDetails = new JButton("All Stocks");
		
		btnStockDetails.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnStockDetails.setBackground(Color.GREEN);
		btnStockDetails.setBounds(707, 92, 188, 31);
		frame.getContentPane().add(btnStockDetails);
		
		JPanel panelstock = new JPanel();
		panelstock.setBackground(new Color(202, 202, 255));
		panelstock.setBounds(34, 70, 508, 307);
		frame.getContentPane().add(panelstock);
		panelstock.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelstock.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Book Id");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(34, 22, 103, 26);
		panelstock.add(lblNewLabel_1);
		
		txtbookid = new JTextField();
		txtbookid.setVerifyInputWhenFocusTarget(false);
		txtbookid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtbookid.setBounds(181, 22, 295, 26);
		panelstock.add(txtbookid);
		txtbookid.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Book Name");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(34, 69, 137, 26);
		panelstock.add(lblNewLabel_1_1);
		
		txtbookname = new JTextField();
		txtbookname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtbookname.setColumns(10);
		txtbookname.setBounds(181, 69, 295, 26);
		panelstock.add(txtbookname);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("AUTHOR");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1_1.setBounds(34, 121, 137, 26);
		panelstock.add(lblNewLabel_1_1_1);
		
		txtauthor = new JTextField();
		txtauthor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtauthor.setColumns(10);
		txtauthor.setBounds(181, 121, 295, 26);
		panelstock.add(txtauthor);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Price");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1_2.setBounds(34, 172, 137, 26);
		panelstock.add(lblNewLabel_1_1_2);
		
		txtprice = new JTextField();
		txtprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtprice.setColumns(10);
		txtprice.setBounds(181, 172, 295, 26);
		panelstock.add(txtprice);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Quantity");
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1_3.setBounds(34, 220, 137, 26);
		panelstock.add(lblNewLabel_1_1_3);
		
		txtquantity = new JTextField();
		txtquantity.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtquantity.setColumns(10);
		txtquantity.setBounds(181, 220, 295, 26);
		panelstock.add(txtquantity);
		
		JButton btnaddanotherbook = new JButton("Add Book");
		btnaddanotherbook.setBackground(new Color(0, 255, 128));
		
		btnaddanotherbook.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnaddanotherbook.setBounds(71, 256, 144, 34);
		panelstock.add(btnaddanotherbook);
		
		JButton btnsell = new JButton("Sell Book");
		
		btnsell.setBackground(new Color(255, 128, 0));
		btnsell.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnsell.setBounds(267, 256, 137, 32);
		panelstock.add(btnsell);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(588, 145, 454, 454);
		frame.getContentPane().add(scrollPane);
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("Verdana", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Book Id", "Book Name", "Author", "Price", "Stock Count"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(202, 202, 255));
		panel_1.setBounds(34, 387, 508, 292);
		frame.getContentPane().add(panel_1);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setLayout(null);
		
		
		JLabel lblNewLabel_1_2 = new JLabel("Book Id");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(30, 100, 103, 26);
		panel_1.add(lblNewLabel_1_2);
		
		txtstockbookid = new JTextField();
		txtstockbookid.setEditable(false);
		txtstockbookid.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtstockbookid.setColumns(10);
		txtstockbookid.setBounds(205, 100, 256, 26);
		panel_1.add(txtstockbookid);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("Book Name");
		lblNewLabel_1_1_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1_4.setBounds(30, 135, 137, 26);
		panel_1.add(lblNewLabel_1_1_4);
		
		txtstockbookname = new JTextField();
		txtstockbookname.setEditable(false);
		txtstockbookname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtstockbookname.setColumns(10);
		txtstockbookname.setBounds(205, 135, 256, 26);
		panel_1.add(txtstockbookname);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("AUTHOR");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1_1_1.setBounds(30, 171, 137, 26);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		txtstockauthor = new JTextField();
		txtstockauthor.setEditable(false);
		txtstockauthor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtstockauthor.setColumns(10);
		txtstockauthor.setBounds(205, 171, 256, 26);
		panel_1.add(txtstockauthor);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Price");
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1_2_1.setBounds(30, 207, 137, 26);
		panel_1.add(lblNewLabel_1_1_2_1);
		
		txtstockprice = new JTextField();
		txtstockprice.setEditable(false);
		txtstockprice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtstockprice.setColumns(10);
		txtstockprice.setBounds(205, 207, 256, 26);
		panel_1.add(txtstockprice);
		
		JLabel lblNewLabel_1_1_3_1 = new JLabel("Stock Quantity");
		lblNewLabel_1_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1_3_1.setBounds(30, 243, 150, 26);
		panel_1.add(lblNewLabel_1_1_3_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Stock Detail");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel_1_2_1.setBounds(151, 10, 218, 40);
		panel_1.add(lblNewLabel_1_2_1);
		
		txtstockquanity = new JTextField();
		txtstockquanity.setEditable(false);
		txtstockquanity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtstockquanity.setColumns(10);
		txtstockquanity.setBounds(205, 243, 256, 26);
		panel_1.add(txtstockquanity);
		
		JLabel lblNewLabel_2 = new JLabel("Book Id");
		lblNewLabel_2.setBounds(30, 60, 307, 30);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		txtsearchbookid = new JTextField();
		txtsearchbookid.setBounds(132, 62, 205, 28);
		panel_1.add(txtsearchbookid);
		txtsearchbookid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtsearchbookid.setColumns(10);
		
		
		JButton btnsearch = new JButton("Search Details");
		btnsearch.setBounds(347, 60, 151, 30);
		panel_1.add(btnsearch);
		btnsearch.setBackground(new Color(255, 255, 0));
		
		btnsearch.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		btnsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop", "root", "Aniket123@");
					String query = "select * from book_details where bookid = ?";
					PreparedStatement ps= con.prepareStatement(query);
					ps.setString(1, txtsearchbookid.getText());
					ResultSet rs= ps.executeQuery();
					if(rs.next()) {
						String bookid = rs.getString("bookid");
						String bookname = rs.getString("bookname");
						String author = rs.getString("author");
						String price = rs.getString("price");
						String stockcount = rs.getString("stockcount");
						txtstockbookid.setText(bookid);
						txtstockbookname.setText(bookname);
						txtstockauthor.setText(author);
						txtstockprice.setText(price);
						txtstockquanity.setText(stockcount);
					}
					else {
						txtstockbookid.setText("");
						txtstockbookname.setText("");
						txtstockauthor.setText("");
						txtstockprice.setText("");
						txtstockquanity.setText("");
						JOptionPane.showMessageDialog(btnsearch, "Bookid not found");
						
					}
					txtsearchbookid.setText("");
					ps.close();
					con.close();
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(btnsearch, "Bookid not found");
					e1.printStackTrace();
				}
			
			}
			
		});
		btnaddanotherbook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					scrollPane.setVisible(false);
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop", "root", "Aniket123@");
					Integer bookid = Integer.parseInt(txtbookid.getText());
				
					String bookname = txtbookname.getText();
					String bookauthor = txtauthor.getText();
					Integer price = Integer.parseInt(txtprice.getText());
					Integer quantity = Integer.parseInt(txtquantity.getText());
					
					String query = "select * from book_details where bookid = ? "
							+ "AND bookname = ? AND author =? AND price = ? ";
					PreparedStatement ps= con.prepareStatement(query);
					ps.setInt(1, bookid);
					ps.setString(2, bookname);
					ps.setString(3, bookauthor);
					ps.setInt(4, price);
					ResultSet rs= ps.executeQuery();
					Integer oldquantity = null;
					if(rs.next()) {
						oldquantity = rs.getInt("stockcount");
					}
					Integer newstock = quantity;
					
					if(oldquantity != null) {
						newstock +=oldquantity;
						query = "update book_details set stockcount = ? where bookid = ? "
								+ "AND bookname = ? AND author =? AND price = ? ";
						ps = con.prepareStatement(query);
						ps.setInt(1, newstock);
						ps.setInt(2, bookid);
						ps.setString(3, bookname);
						ps.setString(4, bookauthor);
						ps.setInt(5, price);
					}
					else {
						query = "insert into book_details Values(?,?,?,?,?)";
						ps = con.prepareStatement(query);
						ps.setInt(5, newstock);
						ps.setInt(1, bookid);
						ps.setString(2, bookname);
						ps.setString(3, bookauthor);
						ps.setInt(4, price);
					}
					int i = ps.executeUpdate();
					txtbookid.setText("");
					txtbookname.setText("");
					txtauthor.setText("");
					txtprice.setText("");
					txtquantity.setText("");
					JOptionPane.showMessageDialog(btnaddanotherbook, " Book added Successfully!");
					
					ps.close();
					con.close();
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(btnaddanotherbook, "Please fill all details Correctly!");
					e1.printStackTrace();
				}
			}
		});
		
		btnsell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					scrollPane.setVisible(false);
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop", "root", "Aniket123@");
					Integer bookid = Integer.parseInt(txtbookid.getText());
				
					String bookname = txtbookname.getText();
					String bookauthor = txtauthor.getText();
					Integer price = Integer.parseInt(txtprice.getText());
					Integer quantity = Integer.parseInt(txtquantity.getText());
					
					String query = "select * from book_details where bookid = ? "
							+ "AND bookname = ? AND author =? AND price = ? ";
					PreparedStatement ps= con.prepareStatement(query);
					ps.setInt(1, bookid);
					ps.setString(2, bookname);
					ps.setString(3, bookauthor);
					ps.setInt(4, price);
					ResultSet rs= ps.executeQuery();
					Integer oldquantity = null;
					if(rs.next()) {
						oldquantity = rs.getInt("stockcount");
					}
					Integer newstock = quantity;
					if(oldquantity != null && oldquantity >= quantity) {
						newstock = oldquantity-quantity;
						query = "update book_details set stockcount = ? where bookid = ? "
								+ "AND bookname = ? AND author =? AND price = ? ";
						ps = con.prepareStatement(query);
						ps.setInt(1, newstock);
						ps.setInt(2, bookid);
						ps.setString(3, bookname);
						ps.setString(4, bookauthor);
						ps.setInt(5, price);
						int i = ps.executeUpdate();
						txtbookid.setText("");
						txtbookname.setText("");
						txtauthor.setText("");
						txtprice.setText("");
						txtquantity.setText("");
						JOptionPane.showMessageDialog(btnsell, " Book sell Successfully!");
					}
					else {
						JOptionPane.showMessageDialog(btnsell, " Book out of Stock");
					}
					ps.close();
					con.close();
					
				}
			
				catch(Exception e1) {
					JOptionPane.showMessageDialog(btnsell, "Please fill all details Correctly!");
					e1.printStackTrace();
				}
			}
		});
		
		btnStockDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane.setVisible(true);
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop", "root", "Aniket123@");
					String query = "select * from book_details";
					DefaultTableModel tblModel = (DefaultTableModel) table.getModel();
					tblModel.setRowCount(0);
					PreparedStatement ps= con.prepareStatement(query);
					ResultSet rs= ps.executeQuery();
					ResultSetMetaData rsmd = rs.getMetaData();
					int cols = rsmd.getColumnCount();
					String[] colName = new String[cols];
					for(int i=0; i<cols; i++) {
						colName[i] =  rsmd.getColumnName(i+1);	
					}
					tblModel.setColumnIdentifiers(colName);
					while(rs.next()) {
						Integer bookid = rs.getInt("bookid");
						String bookname = rs.getString("bookname");
						String author = rs.getString("author");
						Integer price = rs.getInt("price");
						Integer stockcount = rs.getInt("stockcount");
						
						Object tbData[] = {bookid, bookname,author, price, stockcount};
//						DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
						tblModel.addRow(tbData);
					}
					ps.close();
					con.close();
					
				} catch (ClassNotFoundException | SQLException e1) {
					JOptionPane.showMessageDialog(btnStockDetails, " Record not found!");
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
}
