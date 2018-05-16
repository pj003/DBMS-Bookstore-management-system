import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SpringLayout;
import net.proteanit.sql.DbUtils;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class SelectFirst extends JFrame {
	private JTable table;
	public SelectFirst() {
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JScrollPane scrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, -35, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, -27, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -33, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, -25, SpringLayout.EAST, getContentPane());
		getContentPane().add(scrollPane);
		
		table = new JTable();
		springLayout.putConstraint(SpringLayout.NORTH, table, 23, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, table, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, table, 358, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, table, 635, SpringLayout.WEST, getContentPane());
		//scrollPane.setViewportView(table);
		getContentPane().add(table);
		
		JButton btnNewButton = new JButton("Load Report");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sysapp","jk3115");
					System.out.println("Connection successful");
					String sql = "select SSN, NAME, round(sysdate-doj), BID as DayswithCompany from f17_3_employee order by round(sysdate-DOJ) desc";
					PreparedStatement st = conn.prepareStatement(sql);
					ResultSet rs = st.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));

				}
			   	catch (Exception e) {
					e.printStackTrace();
				}
			       	
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 0, SpringLayout.NORTH, scrollPane);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -45, SpringLayout.WEST, scrollPane);
		getContentPane().add(btnNewButton);
	}
}
