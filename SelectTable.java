import java.sql.*;
import java.awt.Color;
import java.awt.FlowLayout;
//import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import net.proteanit.sql.DbUtils;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class SelectTable extends JFrame
{
	
	private JTable table;
	public SelectTable() {
		
		
		
		//JScrollPane scroll = new JScrollPane(table); // add scrollpane
		
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JButton btnLoadReport = new JButton("Load Report");
		btnLoadReport.addActionListener(new ActionListener() {
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
		springLayout.putConstraint(SpringLayout.NORTH, btnLoadReport, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnLoadReport, 750, SpringLayout.WEST, getContentPane());
		getContentPane().add(btnLoadReport);
		
		//DefaultTableModel def = new DefaultTableModel();
		//Object [] columnnames = {"SSN, Name"};
		//def.setColumnIdentifiers(columnnames);
		
		table = new JTable();
		springLayout.putConstraint(SpringLayout.NORTH, table, 24, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, table, 20, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, table, -29, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, table, -23, SpringLayout.WEST, btnLoadReport);        
		getContentPane().add(table);
	}
}
