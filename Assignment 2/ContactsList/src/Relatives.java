import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class Relatives implements Serializable{

	private JFrame frame;
	private JFrame frmDetails;
	private JTextField txtName;
	private JTextField txtMobileNo;
	private JTextField txtEmail;
	private JTextField txtBirthdayddmmyyyy;
	private JTextField txtLastMeetddmmyyyy;
	
	
	
	SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");
	
	

	private String name , mob, email;
	private Date bday, lastmeet;
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

	public Date getBday() {
		return bday;
	}

	public void setBday(Date bday) {
		this.bday = bday;
	}

	public Date getLastmeet() {
		return lastmeet;
	}

	public void setLastmeet(Date lastmeet) {
		this.lastmeet = lastmeet;
	}

	private JButton btnNewButton;
	private JLabel lblName;
	private JLabel lblMobileNo;
	private JLabel lblEmailAddress;
	private JLabel lblBirthdayddmmyyyy;
	private JLabel lblLastMeetddmmyyyy;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 */
	public Relatives() {
		
		name = email = mob; 
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
		frame.getContentPane().setLayout(null);
	}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void enter_details()
	{
		frmDetails = new JFrame();
		frmDetails.setVisible(true);
		frmDetails.setTitle("Details");
		frmDetails.setBounds(100, 100, 481, 300);
		frmDetails.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmDetails.getContentPane().setLayout(null);
		
		txtName = new JTextField();
		txtName.setBounds(161, 29, 171, 20);
		frmDetails.getContentPane().add(txtName);
		txtName.setColumns(10);
	/*	txtName.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				name = txtName.getText();
				// TODO Auto-generated method stub
				
			}
		});
		*/
		txtMobileNo = new JTextField();
		txtMobileNo.setBounds(161, 71, 171, 20);
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
		txtEmail.setBounds(161, 121, 171, 20);
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
		
		txtBirthdayddmmyyyy = new JTextField();
		txtBirthdayddmmyyyy.setBounds(161, 169, 171, 20);
		frmDetails.getContentPane().add(txtBirthdayddmmyyyy);
		txtBirthdayddmmyyyy.setColumns(10);
		/*txtBirthdayddmmyyyy.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						while(true)
				         {
							
				    	         try { 
				    	             bday = ft.parse(txtBirthdayddmmyyyy.getText());
				    	             break;
				    	             //System.out.println(); 
				    	         } catch (ParseException er) { 
				    	             System.out.println("Unparseable using " + ft); 
				    	         }
				    	         
				         }
					
						// TODO Auto-generated method stub
						
					}
				});
		*/
		txtLastMeetddmmyyyy = new JTextField();
		txtLastMeetddmmyyyy.setBounds(161, 214, 171, 20);
		frmDetails.getContentPane().add(txtLastMeetddmmyyyy);
		txtLastMeetddmmyyyy.setColumns(10);
		
		btnNewButton = new JButton("Enter");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtName.getText().equals("") || txtMobileNo.getText().equals("") || txtEmail.getText().equals(""))
				{
   	             	JOptionPane.showMessageDialog(frmDetails, "Fields cannot be empty");
				}
				else
				{
				name = txtName.getText();
				mob = txtMobileNo.getText();
				email = txtEmail.getText();
			
		    	         try { 
		    	        		ft.setLenient(false);

		    	             bday = ft.parse(txtBirthdayddmmyyyy.getText());
		    	        
		    	             //System.out.println(); 
		    	         } catch (ParseException er) { 
		    	             JOptionPane.showMessageDialog(frmDetails, "Enter valid Birthday");
		    	         }
		    	         
		    	         try { 
		    	        		ft.setLenient(false);

		    	             lastmeet = ft.parse(txtLastMeetddmmyyyy.getText());
		    	             
		    	             //System.out.println(); 
		    	         } catch (ParseException er) { 
		    	             JOptionPane.showMessageDialog(frmDetails, "Enter valid Last meet date");
		    	         }
		    	         
		    	         if(bday != null && lastmeet != null)
		    	        	 frmDetails.dispose();
		     
				}
			}
		});
		btnNewButton.setBounds(354, 54, 70, 111);
		frmDetails.getContentPane().add(btnNewButton);
		
		lblName = new JLabel("Name");
		lblName.setBounds(25, 35, 46, 14);
		frmDetails.getContentPane().add(lblName);
		
		lblMobileNo = new JLabel("Mobile No.");
		lblMobileNo.setBounds(25, 77, 90, 14);
		frmDetails.getContentPane().add(lblMobileNo);
		
		lblEmailAddress = new JLabel("Email address");
		lblEmailAddress.setBounds(25, 127, 90, 14);
		frmDetails.getContentPane().add(lblEmailAddress);
		
		lblBirthdayddmmyyyy = new JLabel("Birthday (dd/mm/yyyy)");
		lblBirthdayddmmyyyy.setBounds(25, 175, 126, 14);
		frmDetails.getContentPane().add(lblBirthdayddmmyyyy);
		
		lblLastMeetddmmyyyy = new JLabel("Last meet (dd/mm/yyyy)");
		lblLastMeetddmmyyyy.setBounds(25, 220, 126, 14);
		frmDetails.getContentPane().add(lblLastMeetddmmyyyy);
		/*txtLastMeetddmmyyyy.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						lastmeet = txtLastMeetddmmyyyy.getText();
						// TODO Auto-generated method stub
						
					}
				});
				*/
	}
	
	public void display_details()
	{
		frmDetails = new JFrame();
		frmDetails.setVisible(true);
		frmDetails.setTitle("Details (Relatives) ");
		frmDetails.setBounds(100, 100, 481, 300);
		frmDetails.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmDetails.getContentPane().setLayout(null);
		
		txtName = new JTextField();
		txtName.setEditable(false);
		txtName.setBounds(161, 29, 171, 20);
		frmDetails.getContentPane().add(txtName);
		txtName.setColumns(10);
		txtName.setText(name);
		
		txtMobileNo = new JTextField();
		txtMobileNo.setEditable(false);
		txtMobileNo.setBounds(161, 71, 171, 20);
		frmDetails.getContentPane().add(txtMobileNo);
		txtMobileNo.setColumns(10);
		txtMobileNo.setText(mob);
		
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setBounds(161, 121, 171, 20);
		frmDetails.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		txtEmail.setText(email);
		
		txtBirthdayddmmyyyy = new JTextField();
		txtBirthdayddmmyyyy.setEditable(false);
		txtBirthdayddmmyyyy.setBounds(161, 169, 171, 20);
		frmDetails.getContentPane().add(txtBirthdayddmmyyyy);
		txtBirthdayddmmyyyy.setColumns(10);
		txtBirthdayddmmyyyy.setText(ft.format(bday));
		
		txtLastMeetddmmyyyy = new JTextField();
		txtLastMeetddmmyyyy.setEditable(false);
		txtLastMeetddmmyyyy.setBounds(161, 214, 171, 20);
		frmDetails.getContentPane().add(txtLastMeetddmmyyyy);
		txtLastMeetddmmyyyy.setColumns(10);
		
		
		btnNewButton = new JButton("Back");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frmDetails.dispose();
			}
		});
		btnNewButton.setBounds(354, 54, 70, 111);
		frmDetails.getContentPane().add(btnNewButton);
		
		lblName = new JLabel("Name");
		lblName.setBounds(25, 35, 46, 14);
		frmDetails.getContentPane().add(lblName);
		
		lblMobileNo = new JLabel("Mobile No.");
		lblMobileNo.setBounds(25, 77, 90, 14);
		frmDetails.getContentPane().add(lblMobileNo);
		
		lblEmailAddress = new JLabel("Email address");
		lblEmailAddress.setBounds(25, 127, 90, 14);
		frmDetails.getContentPane().add(lblEmailAddress);
		
		lblBirthdayddmmyyyy = new JLabel("Birthday (dd/mm/yyyy)");
		lblBirthdayddmmyyyy.setBounds(25, 175, 126, 14);
		frmDetails.getContentPane().add(lblBirthdayddmmyyyy);
		
		lblLastMeetddmmyyyy = new JLabel("Last meet (dd/mm/yyyy)");
		lblLastMeetddmmyyyy.setBounds(25, 220, 126, 14);
		frmDetails.getContentPane().add(lblLastMeetddmmyyyy);
		txtLastMeetddmmyyyy.setText(ft.format(lastmeet));
	}

}
