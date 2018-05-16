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


public class UpdateFrame extends JFrame {

	private static final long serialVersionUID = 503839066780868824L;
	JButton updateButton = new JButton("UPDATE");
	JButton backButton = new JButton("BACK");
	JTextField designation = new JTextField(30);
	JTextField ssn = new JTextField(15);

	public UpdateFrame() {
		super("Bookstore Management System");
		setLayout(new FlowLayout());
		add(new JLabel("Designation"));
		add(designation);
		add(new JLabel("SSN"));
		add(ssn);		
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
	        //System.out.println("source - "+source.getText()+" | id - "+id.getText()+" | salary - "+salary.getText());
	        if (source == updateButton) {
	        	System.out.println("Update button clicked");
	        	try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sysapp","jk3115");
					String sql = "update f17_3_employee set designation = ? where ssn = ?";
					PreparedStatement st = conn.prepareStatement(sql);
					st.setString(1, designation.getText());
					st.setString(2,ssn.getText());
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
