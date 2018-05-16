import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.FlowLayout;
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

import javax.swing.JButton;
import javax.swing.JFrame;

public class InsertFrame1 extends JFrame {
	public InsertFrame1() {
	}}
	
/*	private static final long serialVersionUID = 503839066780868824L;
	JFrame frame, frame1;
	JTextField textbox;
	JLabel label;
	JButton button;
	JPanel panel;
	static JTable table;
	JButton backButton = new JButton("BACK");
		public static void main(String[] args) {
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:xe","username","password");
				String[] columnNames = {"SSN","Name","DOJ","Phone","Designation","Address","Bid"};
					
			}
		}
		
		private final ActionListener updateListener = new ActionListener() {
		    @Override
		    	public void actionPerformed(ActionEvent ae)
				{
				generate1 = (JButton)ae.getSource();
				System.out.println("Showing Table Data.......");
				showTableData(); 
				} 
		    	public void showTableData()
		    	{

		    		frame1 = new JFrame("Database Search Result");
		    frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame1.setLayout(new BorderLayout()); 
		    //TableModel tm = new TableModel();
		    DefaultTableModel model = new DefaultTableModel();
		    model.setColumnIdentifiers(columnNames);
		    //DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames()); 
		    //table = new JTable(model);
		    table = new JTable();
		    table.setModel(model); 
		    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		    table.setFillsViewportHeight(true);
		    JScrollPane scroll = new JScrollPane(table);
		    scroll.setHorizontalScrollBarPolicy(
		    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		    scroll.setVerticalScrollBarPolicy(
		    JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		    String textvalue = textbox.getText();
		    String roll= "";
		    String name= "";
		    String cl = "";
		    String sec = "";
		    try
		    { 
		    Class.forName(driverName); 
		    Connection con = DriverManager.getConnection(url, userName, password);
		    String sql = "select * from student where rollno = "+textvalue;
		    PreparedStatement ps = con.prepareStatement(sql);
		    ResultSet rs = ps.executeQuery();
		    int i =0;
		    if(rs.next())
		    {
		    roll = rs.getString("rollno");
		    name = rs.getString("name");
		    cl = rs.getString("class");
		    sec = rs.getString("section"); 
		    model.addRow(new Object[]{roll, name, cl, sec});
		    i++; 
		    }
		    
			//	Statement st=con.createStatement();
		//		String sql="select SSN, NAME, round(sysdate-doj), BID as DayswithCompany from f17_3_employee order by round(sysdate-DOJ) desc;";
				

}
*/