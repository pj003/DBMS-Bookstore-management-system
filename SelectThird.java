import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import net.proteanit.sql.DbUtils;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class SelectThird extends JFrame 
{
	private JTable table;
	private JTextField bid;
	//JButton backButton = new JButton("BACK");
	//backButton.addActionListener();

	public SelectThird() {
		getContentPane().setLayout(null);
		setSize(1360, 725);
		
		JButton btnLoadReport = new JButton("Load Report");
		btnLoadReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sysapp","jk3115");
					System.out.println("Connection successful");
					String sql = "select p.bid, sum(selling_price), Cost as f17_3_expenses, (sum(selling_price) - cost) as Profit from f17_3_expenses e,f17_3_purchase p, f17_3_branch b where b.bid = ? and b.bid=p.bid and b.bid=e.bid and p.bid=e.bid group by p.bid,Cost order by (sum(selling_price) - cost) desc";
					PreparedStatement st = conn.prepareStatement(sql);
					st.setString(1, bid.getText());
					//ResultSet rs = st.executeQuery();
					ResultSet rs = st.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));

				}
				catch (Exception e) {
					e.printStackTrace();
				}
			    
	
			}
		});
		btnLoadReport.setBounds(10, 11, 114, 23);
		getContentPane().add(btnLoadReport);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 87, 788, 304);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Back button clicked");
	        	setVisible(false);
	        	new BookstoreGUI().setVisible(true);
			}
		});
		btnNewButton.setBounds(137, 11, 89, 23);
		getContentPane().add(btnNewButton);
		
		bid = new JTextField();
		bid.setBounds(534, 12, 86, 20);
		getContentPane().add(bid);
		bid.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Branch ID");
		lblNewLabel.setBounds(407, 15, 78, 14);
		getContentPane().add(lblNewLabel);
	}
}

