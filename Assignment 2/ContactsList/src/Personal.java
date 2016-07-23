import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Personal implements Serializable{
	
	SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");


	private JFrame frame;
	private JFrame frmDetails;
	private JTextField txtName;
	private JTextField txtMobileNo;
	private JTextField txtEmail;
	private JTextField txtContext;
	private JTextField txtFirstMeet;
	private JTextField txtEvents;

	
	
	
	
	private String name, mob, email, context, events ;
	private Date when;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMob() {
		return mob;
	}

	public void setMob(String mob) {
		this.mob = mob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Date getWhen() {
		return when;
	}

	public void setWhen(Date when) {
		this.when = when;
	}

	public String getEvents() {
		return events;
	}

	public void setEvents(String events) {
		this.events = events;
	}	
	private JButton btnNewButton;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public Personal() {
		name = mob = email = context =  events = "";
		//initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void enter_details()
	{
		frmDetails = new JFrame();
		frmDetails.setVisible(true);
		frmDetails.setTitle("Details");
		frmDetails.setBounds(100, 100, 484, 300);
		frmDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDetails.getContentPane().setLayout(null);
		
		txtName = new JTextField();
		txtName.setBounds(137, 25, 195, 20);
		frmDetails.getContentPane().add(txtName);
		txtName.setColumns(10);
		/*txtName.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				name = txtName.getText();
				// TODO Auto-generated method stub
				
			}
		});*/
		
		txtMobileNo = new JTextField();
		txtMobileNo.setBounds(137, 56, 195, 20);
		frmDetails.getContentPane().add(txtMobileNo);
		txtMobileNo.setColumns(10);
		/*txtMobileNo.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						mob = txtMobileNo.getText();
						// TODO Auto-generated method stub
						
					}
				});
				*/
		
		txtEmail = new JTextField();
		txtEmail.setBounds(137, 100, 195, 20);
		frmDetails.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		/*txtEmail.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						email = txtEmail.getText();
						// TODO Auto-generated method stub
						
					}
				});
		
		*/
		txtContext = new JTextField();
		txtContext.setBounds(137, 141, 195, 20);
		frmDetails.getContentPane().add(txtContext);
		txtContext.setColumns(10);
		/*txtContext.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						context = txtContext.getText();
						// TODO Auto-generated method stub
						
					}
				});
		*/
		txtFirstMeet = new JTextField();
		txtFirstMeet.setBounds(137, 183, 195, 20);
		frmDetails.getContentPane().add(txtFirstMeet);
		txtFirstMeet.setColumns(10);
		/*txtFirstMeet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				when = txtFirstMeet.getText();
				// TODO Auto-generated method stub
				
			}
		});
		*/
		txtEvents = new JTextField();
		txtEvents.setBounds(137, 230, 195, 20);
		frmDetails.getContentPane().add(txtEvents);
		txtEvents.setColumns(10);
		
		btnNewButton = new JButton("Enter");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtName.getText().equals("") || txtMobileNo.getText().equals("") || txtEmail.getText().equals("") || txtEvents.getText().equals(""))
   	             	JOptionPane.showMessageDialog(frmDetails, "Fields cannot be empty");
				else if(txtEvents.getText().length() > 100)
 				{
 					JOptionPane.showMessageDialog(frmDetails, "Event too long! (Max 100 characters)");
 				}
				else
				{
				name = txtName.getText();
				mob = txtMobileNo.getText();
				email = txtEmail.getText();
				
					
		    	         try { 
		    	        		ft.setLenient(false);

		    	             when = ft.parse(txtFirstMeet.getText());
		    	        
		    	             //System.out.println(); 
		    	         } catch (ParseException er) { 
		    	             JOptionPane.showMessageDialog(frmDetails, "Enter valid Date");
		    	         }
		    	         
		 				
		         
				events = txtEvents.getText();
				if(when != null )
				frmDetails.dispose();

			}
			}
		});
		btnNewButton.setBounds(342, 56, 79, 98);
		frmDetails.getContentPane().add(btnNewButton);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(22, 31, 46, 14);
		frmDetails.getContentPane().add(lblName);
		
		JLabel lblMobileNo = new JLabel("Mobile No.");
		lblMobileNo.setBounds(20, 62, 79, 14);
		frmDetails.getContentPane().add(lblMobileNo);
		
		JLabel lblEmailAddress = new JLabel("email address");
		lblEmailAddress.setBounds(22, 106, 105, 14);
		frmDetails.getContentPane().add(lblEmailAddress);
		
		JLabel lblContext = new JLabel("Context");
		lblContext.setBounds(22, 147, 63, 14);
		frmDetails.getContentPane().add(lblContext);
		
		JLabel lblDateWhenMet = new JLabel("Date when met");
		lblDateWhenMet.setBounds(22, 189, 88, 14);
		frmDetails.getContentPane().add(lblDateWhenMet);
		
		JLabel lblEvents = new JLabel("Events");
		lblEvents.setBounds(22, 236, 46, 14);
		frmDetails.getContentPane().add(lblEvents);
		/*txtEvents.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						events = txtEvents.getText();
						// TODO Auto-generated method stub
						
					}
				});
		*/
		
	}

	
	public void display_details()
	{
		frmDetails = new JFrame();
		frmDetails.setVisible(true);
		frmDetails.setTitle("Details (Personal) ");
		frmDetails.setBounds(100, 100, 484, 300);
		frmDetails.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmDetails.getContentPane().setLayout(null);
		
		txtName = new JTextField();
		txtName.setEditable(false);
		txtName.setBounds(137, 25, 195, 20);
		frmDetails.getContentPane().add(txtName);
		txtName.setColumns(10);
		txtName.setText(name);
		
		txtMobileNo = new JTextField();
		txtMobileNo.setEditable(false);
		txtMobileNo.setBounds(137, 56, 195, 20);
		frmDetails.getContentPane().add(txtMobileNo);
		txtMobileNo.setColumns(10);
		txtMobileNo.setText(mob);
		
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setBounds(137, 100, 195, 20);
		frmDetails.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		txtEmail.setText(email);
		
		txtContext = new JTextField();
		txtContext.setEditable(false);
		txtContext.setBounds(137, 141, 195, 20);
		frmDetails.getContentPane().add(txtContext);
		txtContext.setColumns(10);
		txtContext.setText(context);
		
		txtFirstMeet = new JTextField();
		txtFirstMeet.setEditable(false);
		txtFirstMeet.setBounds(137, 183, 195, 20);
		frmDetails.getContentPane().add(txtFirstMeet);
		txtFirstMeet.setColumns(10);
		txtFirstMeet.setText(ft.format(when));
		
		txtEvents = new JTextField();
		txtEvents.setEditable(false);
		txtEvents.setBounds(137, 230, 195, 20);
		frmDetails.getContentPane().add(txtEvents);
		txtEvents.setColumns(10);
		txtEvents.setText(events);
		btnNewButton = new JButton("Back");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					frmDetails.dispose();

			}
		});
		btnNewButton.setBounds(342, 56, 79, 98);
		frmDetails.getContentPane().add(btnNewButton);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(22, 31, 46, 14);
		frmDetails.getContentPane().add(lblName);
		
		JLabel lblMobileNo = new JLabel("Mobile No.");
		lblMobileNo.setBounds(20, 62, 79, 14);
		frmDetails.getContentPane().add(lblMobileNo);
		
		JLabel lblEmailAddress = new JLabel("email address");
		lblEmailAddress.setBounds(22, 106, 105, 14);
		frmDetails.getContentPane().add(lblEmailAddress);
		
		JLabel lblContext = new JLabel("Context");
		lblContext.setBounds(22, 147, 63, 14);
		frmDetails.getContentPane().add(lblContext);
		
		JLabel lblDateWhenMet = new JLabel("Date when met");
		lblDateWhenMet.setBounds(22, 189, 88, 14);
		frmDetails.getContentPane().add(lblDateWhenMet);
		
		JLabel lblEvents = new JLabel("Events");
		lblEvents.setBounds(22, 236, 46, 14);
		frmDetails.getContentPane().add(lblEvents);
		
	}

}
