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


public class UpdFrame1 extends JFrame {

	private static final long serialVersionUID = 503839066780868824L;
	JButton updateButton = new JButton("UPDATE");
	JButton backButton = new JButton("BACK");
	JTextField cust_type = new JTextField(30);
	JTextField cid = new JTextField(15);

	public UpdFrame1() {
		super("Bookstore Management System");
		setLayout(new FlowLayout());
		add(new JLabel("Cust_Type"));
		add(cust_type);
		add(new JLabel("CID"));
		add(cid);		
		updateButton.addActionListener(updateListener);
		backButton.addActionListener(updateListener);
		add(updateButton);
		add(backButton);	
		setSize(1260, 725);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}
	
	private final ActionListener updateListener = new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent ae) {
	    	System.out.println("Update listner executed");
	        JButton source = (JButton) ae.getSource();
	        if (source == updateButton) {
	        	System.out.println("Update button clicked");
	        	try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sysapp","jk3115");
					String sql = "update f17_3_customer set cust_type = ? where cid = ?";
					PreparedStatement st = conn.prepareStatement(sql);
					st.setString(1,cust_type.getText());
					st.setString(2,cid.getText());
					System.out.println("sql - "+st.toString());
					int rs = st.executeUpdate();
					System.out.println("result - "+rs);
					if(rs==1) {
						JOptionPane.showMessageDialog(null, 
	                              "Record updated successfully", 
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
