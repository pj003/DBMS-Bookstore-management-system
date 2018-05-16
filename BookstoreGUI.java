
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import java.awt.Button;
import java.awt.Font;
import javax.swing.SwingConstants;

public class BookstoreGUI extends JFrame  {

	private static final long serialVersionUID = 503839066780868824L;
	JButton insertOK = new JButton("INSERT");
	JButton updateOK = new JButton("UPDATE");
	JButton deleteOK = new JButton("DELETE");
    JButton generate1 = new JButton("GENERATE");
	JComboBox<String> comboLanguage = new JComboBox<String>();
	public BookstoreGUI() {
		super("Bookstore Management System");
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.NORTH, generate3, 220, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, 0, SpringLayout.SOUTH, generate3);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, 0, SpringLayout.SOUTH, generate4);
		springLayout.putConstraint(SpringLayout.NORTH, generate5a, 322, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, generate4, 271, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, 0, SpringLayout.SOUTH, generate5a);
		springLayout.putConstraint(SpringLayout.NORTH, generate5b, 33, SpringLayout.SOUTH, generate5a);
		springLayout.putConstraint(SpringLayout.WEST, lblBGenerate, 0, SpringLayout.WEST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, lblBGenerate, 0, SpringLayout.SOUTH, generate5b);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_5, 92, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_5, 0, SpringLayout.SOUTH, generate6);
		springLayout.putConstraint(SpringLayout.NORTH, generate7, 492, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, generate6, 436, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, generate8, 40, SpringLayout.SOUTH, lblNewLabel_7);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_7, 0, SpringLayout.WEST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_7, 0, SpringLayout.SOUTH, generate7);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_7, -48, SpringLayout.WEST, generate7);
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, -4, SpringLayout.NORTH, generate8);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, 0, SpringLayout.EAST, generate1);
		springLayout.putConstraint(SpringLayout.EAST, generate7, 0, SpringLayout.EAST, generate1);
		springLayout.putConstraint(SpringLayout.EAST, generate6, 0, SpringLayout.EAST, generate1);
		springLayout.putConstraint(SpringLayout.EAST, generate5b, 0, SpringLayout.EAST, generate1);
		springLayout.putConstraint(SpringLayout.EAST, generate5a, 0, SpringLayout.EAST, generate1);
		springLayout.putConstraint(SpringLayout.EAST, generate4, 0, SpringLayout.EAST, generate1);
		springLayout.putConstraint(SpringLayout.EAST, generate3, 0, SpringLayout.EAST, generate1);
		springLayout.putConstraint(SpringLayout.NORTH, generate1, -4, SpringLayout.NORTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, generate1, 124, SpringLayout.EAST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, insertOK, -754, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, deleteOK, 35, SpringLayout.EAST, insertOK);
		springLayout.putConstraint(SpringLayout.WEST, generate8, 0, SpringLayout.WEST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, updateOK, -38, SpringLayout.WEST, insertOK);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_4, -593, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, comboLanguage, -45, SpringLayout.WEST, updateOK);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 29, SpringLayout.SOUTH, lblNewLabel_4);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_4, 0, SpringLayout.WEST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 92, SpringLayout.WEST, getContentPane());
		getContentPane().setLayout(springLayout);
		
		getContentPane().add(lblNewLabel);
		JLabel label = new JLabel("Choose an Option ");
		springLayout.putConstraint(SpringLayout.NORTH, deleteOK, -4, SpringLayout.NORTH, label);
		springLayout.putConstraint(SpringLayout.NORTH, insertOK, -4, SpringLayout.NORTH, label);
		springLayout.putConstraint(SpringLayout.WEST, comboLanguage, 30, SpringLayout.EAST, label);
		springLayout.putConstraint(SpringLayout.NORTH, updateOK, -4, SpringLayout.NORTH, label);
		springLayout.putConstraint(SpringLayout.NORTH, label, 13, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, comboLanguage, -3, SpringLayout.NORTH, label);
		springLayout.putConstraint(SpringLayout.WEST, label, 0, SpringLayout.WEST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, label, 89, SpringLayout.WEST, lblNewLabel);
		getContentPane().add(label);
		
		
		// add items to the combo box
		comboLanguage.addItem("Select");
		comboLanguage.addItem("Employee");
		comboLanguage.addItem("Customer");

//		comboLanguage.addItem("Books");
//		comboLanguage.addItem("Merchandise");
			
		getContentPane().add(comboLanguage);
		
	
	//	buttonOK.addActionListener(this);
		insertOK.addActionListener(fileReconButton);
		//add(fileReconProgressBar);
		//fileReconProgressBar.setVisible(false);
		updateOK.addActionListener(fileReconButton);
		deleteOK.addActionListener(fileReconButton);
		generate1.addActionListener(fileReconButton);
		getContentPane().add(insertOK);
		getContentPane().add(updateOK);
		getContentPane().add(deleteOK);
		getContentPane().add(generate1);
		
		JLabel lblReportOn = new JLabel("2. Report on what category of books were rented the most in the last 6 months");
		springLayout.putConstraint(SpringLayout.WEST, lblReportOn, 0, SpringLayout.WEST, lblNewLabel);
		getContentPane().add(lblReportOn);
		
		JButton generate2 = new JButton("GENERATE");
		springLayout.putConstraint(SpringLayout.SOUTH, generate2, -22, SpringLayout.NORTH, generate3);
		springLayout.putConstraint(SpringLayout.NORTH, lblReportOn, 4, SpringLayout.NORTH, generate2);
		springLayout.putConstraint(SpringLayout.EAST, generate2, 0, SpringLayout.EAST, generate1);
		generate2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
	        	new SelectSec().setVisible(true);
			}
		});
		getContentPane().add(generate2);
		
		getContentPane().add(lblNewLabel_1);
		generate3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
	        	new SelectThird().setVisible(true);
			}
		});
		
		getContentPane().add(generate3);
		
		getContentPane().add(lblNewLabel_2);
		generate4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
	        	new SelectFourth().setVisible(true);
			}
		});
		
		getContentPane().add(generate4);
		
		getContentPane().add(lblNewLabel_3);
		generate5a.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
	        	new SelectFifth().setVisible(true);
			}
		});
		
		getContentPane().add(generate5a);
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 18));
		
		getContentPane().add(lblNewLabel_4);
		
		getContentPane().add(lblBGenerate);
		getContentPane().add(generate5b);
		
		
		getContentPane().add(lblNewLabel_5);
		generate6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
	        	new SelectSixth().setVisible(true);
			}
		});
		
		getContentPane().add(generate6);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.LEFT);
		
		getContentPane().add(lblNewLabel_7);
		generate7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
	        	new SelectSeventh().setVisible(true);
			}
		});
		
		getContentPane().add(generate7);
		
		getContentPane().add(generate8);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
	        	new SelectEighth().setVisible(true);
			}
		});
		
		getContentPane().add(btnNewButton);
		generate5b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
	        	new SelectFifthb().setVisible(true);
			}
		});
		
		
		
		setSize(1360, 725);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}
	
	private final ActionListener fileReconButton = new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent ae) {
	    	System.out.println("onclick action listner executed");
	        JButton source = (JButton) ae.getSource();
	        String value = comboLanguage.getSelectedItem().toString();
	        System.out.println("source - "+source.getText()+" | Combo box value - "+value);
	        
	        if ((source == insertOK) && (value == "Employee")) {
	        	System.out.println("insert button clicked");
	        	setVisible(false);
	        	new InsertFrame().setVisible(true);       	
	   
	        } else if ((source == updateOK) && (value == "Employee")) {
	        	System.out.println("update button clicked");
	        	setVisible(false);
	        	new UpdateFrame().setVisible(true);
	        	
	        } else if ((source == deleteOK) && (value == "Employee")) {
	        	System.out.println("delete button clicked");
	        	setVisible(false);
	        	new DeleteFrame().setVisible(true);
	        	
	        } else if ((source == insertOK) && (value == "Customer")) {
	        	System.out.println("Insert button clicked");
	        	setVisible(false);
	        	new InsFrame1().setVisible(true);
	        }
	        
	        else if ((source == updateOK) && (value == "Customer")) {
	        	System.out.println("Update button clicked");
	        	setVisible(false);
	        	new UpdFrame1().setVisible(true);
	        }
	        
	        else if ((source == deleteOK) && (value == "Customer")) {
	        	System.out.println("Delete button clicked");
	        	setVisible(false);
	        	new DelFrame1().setVisible(true);
	        }
	        else if (source == generate1)
	        { 
	        	 setVisible(false);
	        	 new SelectInit().setVisible(true);
	        }
	      //  else if (source == generate2)
	      //  { 
	      //  	 setVisible(false);
	      //  	 new SelectInit().setVisible(true);
	      //  }	        
	    }
	};
	private final JLabel lblNewLabel = new JLabel("1. List of employees sorted according to the years of experience they have with the store");
	private final JLabel lblNewLabel_1 = new JLabel("3. Identify the proft obtained by each branch");
	private final JButton generate3 = new JButton("GENERATE");
	private final JLabel lblNewLabel_2 = new JLabel("4. Give a report on the total no. of books and merchandise (irrespective of the categories) sold");
	private final JButton generate4 = new JButton("GENERATE");
	private final JLabel lblNewLabel_3 = new JLabel("5. a. Generate report to find out which books were sold most in the last 3 months");
	private final JButton generate5a = new JButton("GENERATE");
	private final JLabel lblNewLabel_4 = new JLabel("LIST OF REPORTS");
	private final JLabel lblBGenerate = new JLabel("5. b. Generate report to find out which books were sold least in the last 3 months");
	private final JButton generate5b = new JButton("GENERATE");
	private final JLabel lblNewLabel_5 = new JLabel("6. Type of merchandise that got sold the most in the past three months");
	private final JButton generate6 = new JButton("GENERATE");
	private final JLabel lblNewLabel_7 = new JLabel("7. List the members who made top 10 purchases among the bookstore members last year");
	private final JButton generate7 = new JButton("GENERATE");
	private final JLabel generate8 = new JLabel("8. Report listing the details of the books that havent been sold for more than a year");
	private final JButton btnNewButton = new JButton("GENERATE");

	

	public static void main(String[] args) {

		new BookstoreGUI().setVisible(true);
	}
}
