import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import net.proteanit.sql.DbUtils;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class SelectFifthb extends JFrame 
{
	private JTable table;
	//JButton backButton = new JButton("BACK");
	//backButton.addActionListener();

	public SelectFifthb() {
		getContentPane().setLayout(null);
		setSize(1360, 725);
		
		JButton btnLoadReport = new JButton("Load Report");
		btnLoadReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sysapp","jk3115");
					System.out.println("Connection successful");
					String sql = "select * from (select bprod_id,count(bprod_id)from f17_3_purchase,f17_3_books where bprod_id=prod_id and (sell_date-sysdate)<=90 group by(bprod_id) order by count(bprod_id))where rownum = 1";
					PreparedStatement st = conn.prepareStatement(sql);
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
	}


}
