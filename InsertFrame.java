import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class InsertFrame extends JFrame {

	private static final long serialVersionUID = 503839066780868824L;
	JButton insertButton = new JButton("INSERT");
	JButton backButton = new JButton("BACK");
	JTextField name = new JTextField(30);
	JTextField ssn = new JTextField(9);
	JTextField doj = new JTextField(11);
	JTextField phone = new JTextField(10);
	JTextField designation = new JTextField(30);
	JTextField address = new JTextField(30);
	JTextField bid = new JTextField(10);
	
	
	public InsertFrame() {
		super("Bookstore Management System");
		setLayout(new FlowLayout());
		add(new JLabel("SSN"));
		add(ssn);
		add(new JLabel("Name"));
		add(name);
		add(new JLabel("DOJ"));
		add(doj);
		add(new JLabel("Phone"));
		add(phone);
		add(new JLabel("Designation"));
		add(designation);
		add(new JLabel("Address"));
		add(address);
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
	
	
	// INSERT INTO f17_3_Employee(ssn,name,doj,phone,designation,address,bid) 

	
	private final ActionListener insertListener = new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent ae) {
	    	System.out.println("insert listner executed");
	        JButton source = (JButton) ae.getSource();
	        //System.out.println("source - "+source.getText()+" | name - "+name.getText()+" | id - "+id.getText()+" | salary - "+salary.getText()+" | age - "+age.getText());
	        if (source == insertButton) {
	        	System.out.println("insert button clicked");
	        	try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sysapp","jk3115");
					String sql = "INSERT INTO f17_3_Employee(ssn,name,doj,phone,designation,address,bid) values (?,?,?,?,?,?,?)";
					PreparedStatement st = conn.prepareStatement(sql);
					st.setString(1, ssn.getText());
					st.setString(2, name.getText());
					//pst.setDate(6, new java.sql.Date(newDate.getTime()));
					st.setString(3, doj.getText());
					st.setString(4, phone.getText());
					st.setString(5, designation.getText());
					st.setString(6, address.getText());
					st.setString(7, bid.getText());
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
