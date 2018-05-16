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


public class DeleteFrame extends JFrame {

	private static final long serialVersionUID = 503839066780868824L;
	JButton deleteButton = new JButton("DELETE");
	JButton backButton = new JButton("BACK");
	JTextField id = new JTextField(15);

	public DeleteFrame() {
		super("Bookstore Management System");
		setLayout(new FlowLayout());
		add(new JLabel("Employee ID"));
		add(id);		
		deleteButton.addActionListener(deleteListener);
		backButton.addActionListener(deleteListener);
		add(deleteButton);
		add(backButton);	
		setSize(1260, 725);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}
	
	private final ActionListener deleteListener = new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent ae) {
	    	System.out.println("Delete listner executed");
	        JButton source = (JButton) ae.getSource();
	        System.out.println("source - "+source.getText()+" | id - "+id.getText());
	        if (source == deleteButton) {
	        	System.out.println("Delete button clicked");
	        	try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sysapp","jk3115");
					String sql = "delete from employee where empid = ?";
					PreparedStatement st = conn.prepareStatement(sql);
					st.setString(1,id.getText());
					System.out.println("sql - "+st.toString());
					int rs = st.executeUpdate();
					System.out.println("result - "+rs);
					if(rs==1) {
						JOptionPane.showMessageDialog(null, 
	                              "Record deleted successfully", 
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
