//insert into f17_3_Customer(CID,PHONE,SSN,NAME,ADDRESS,CUST_TYPE,FEE,MEM_ID,BID)
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


public class InsFrame1 extends JFrame {

	private static final long serialVersionUID = 503839066780868824L;
	JButton insertButton = new JButton("INSERT");
	JButton backButton = new JButton("BACK");
	JTextField cid = new JTextField(10);
	JTextField phone = new JTextField(10);
	JTextField ssn = new JTextField(9);
	JTextField name = new JTextField(30);
	JTextField address = new JTextField(30);
	JTextField cust_type = new JTextField(30);
	JTextField fee = new JTextField(3);
	JTextField mem_id = new JTextField(10);
	JTextField bid = new JTextField(10);

	
	
	public InsFrame1() {
		super("Bookstore Management System");
		setLayout(new FlowLayout());
		add(new JLabel("CID"));
		add(cid);
		add(new JLabel("Phone"));
		add(phone);
		add(new JLabel("SSN"));
		add(ssn);
		add(new JLabel("Name"));
		add(name);
		add(new JLabel("Address"));
		add(address);
		add(new JLabel("Cust_Type"));
		add(cust_type);
		add(new JLabel("Fee"));
		add(fee);
		add(new JLabel("MEM_ID"));
		add(mem_id);
		add(new JLabel("Branch ID"));
		add(bid);
		
		
		insertButton.addActionListener(insertListener);
		backButton.addActionListener(insertListener);
		add(insertButton);
		add(backButton);	
		setSize(1260, 725);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}
		
	private final ActionListener insertListener = new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent ae) {
	    	System.out.println("insert listner executed");
	        JButton source = (JButton) ae.getSource();
	        if (source == insertButton) {
	        	System.out.println("insert button clicked");
	        	try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sysapp","jk3115");
					String sql = "insert into f17_3_Customer(CID,PHONE,SSN,NAME,ADDRESS,CUST_TYPE,FEE,MEM_ID,BID) values (?,?,?,?,?,?,?,?,?)";
					PreparedStatement st = conn.prepareStatement(sql);
					st.setString(1, cid.getText());
					st.setString(2, phone.getText());
					//pst.setDate(6, new java.sql.Date(newDate.getTime()));
					st.setString(3, ssn.getText());
					st.setString(4, name.getText());
					st.setString(5, address.getText());
					st.setString(6, cust_type.getText());
					st.setString(7, fee.getText());
					st.setString(8, mem_id.getText());
					st.setString(9, bid.getText());
					
					System.out.println("sql - "+st.toString());
					int rs = st.executeUpdate();
					System.out.println("result - "+rs);
					if(rs==1) {
						JOptionPane.showMessageDialog(null, 
	                              "Record inserted successfully", 
	                              "TITLE", 
	                              JOptionPane.WARNING_MESSAGE);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				} 
	
	        } else if (source == backButton) {
	        	System.out.println("Back button clicked");
	        	setVisible(false);
	        	new BookstoreGUI().setVisible(true);
	        	
	        } 
	    }
	};
}

