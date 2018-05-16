//select bprod_id,count(bprod_id) from f17_3_purchase,f17_3_books where bprod_id=prod_id and (sell_date-sysdate)<=90 group by(bprod_id) having count(bprod_id)>0 order by count(bprod_id) desc;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import net.proteanit.sql.DbUtils;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SelectFifth extends JFrame 
{
	private JTable table;
	private JTextField sdate;
	private JTextField edate;
	//JButton backButton = new JButton("BACK");
	//backButton.addActionListener();

	public SelectFifth() {
		getContentPane().setLayout(null);
		setSize(1360, 725);
		
		JButton btnLoadReport = new JButton("Load Report");
		btnLoadReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sysapp","jk3115");
					System.out.println("Connection successful");
					String sql = "select bprod_id,count(bprod_id) from f17_3_purchase,f17_3_books where bprod_id=prod_id and sell_date between ? and ? group by(bprod_id) having count(bprod_id)>1 order by count(bprod_id) desc";
					PreparedStatement st = conn.prepareStatement(sql);
					st.setString(1, sdate.getText());
					st.setString(2, edate.getText());

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
		
		JLabel lblStartDate = new JLabel("Start Date");
		lblStartDate.setBounds(371, 15, 89, 14);
		getContentPane().add(lblStartDate);
		
		JLabel lblEndDate = new JLabel("End Date");
		lblEndDate.setBounds(640, 15, 68, 14);
		getContentPane().add(lblEndDate);
		
		sdate = new JTextField();
		sdate.setBounds(466, 12, 86, 20);
		getContentPane().add(sdate);
		sdate.setColumns(10);
		
		edate = new JTextField();
		edate.setBounds(722, 12, 86, 20);
		getContentPane().add(edate);
		edate.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Date Format - 01-Jan-17");
		lblNewLabel.setBounds(371, 43, 437, 23);
		getContentPane().add(lblNewLabel);
	}


}

