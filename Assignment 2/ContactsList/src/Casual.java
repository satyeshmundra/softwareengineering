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
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Casual implements Serializable {
	
	SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");


	private JFrame frame;
	private JFrame frmDetails;
	private JTextField txtName;
	private JTextField txtMobileNo;
	private JTextField txtEmail;
	private JTextField txtWhere;
	private JTextField txtFirstMeet;
	private JTextField txtCircumstances;
	private JTextField txtUsefulInfo;

	
	
	
	private String name , mob , email, circumstances,  where ,info;
	private Date when  ;
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

	public String getCircumstances() {
		return circumstances;
	}

	public void setCircumstances(String circumstances) {
		this.circumstances = circumstances;
	}

	public Date getWhen() {
		return when;
	}

	public void setWhen(Date when) {
		this.when = when;
	}

	public String getWhere() {
		return where;
	}

	public void setWhere(String where) {
		this.where = where;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}


	private JButton btnNewButton;
	private JLabel lblName;
	private JLabel lblNewLabel;
	private JLabel lblEmailAddress;
	private JLabel lblWhere;
	private JLabel lblDateWhenMet;
	private JLabel lblCircumstances;
	private JLabel lblUsefulInformation;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public Casual() {
		name = mob = email = circumstances =  info = "";
		
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
		frmDetails.setBounds(100, 100, 492, 300);
		frmDetails.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmDetails.getContentPane().setLayout(null);
		
		txtName = new JTextField();
		txtName.setBounds(152, 22, 180, 20);
		frmDetails.getContentPane().add(txtName);
		txtName.setColumns(10);
		/*txtName.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				name = txtName.getText();
				// TODO Auto-generated method stub
				
			}
		});
		*/
		txtMobileNo = new JTextField();
		txtMobileNo.setBounds(152, 56, 180, 20);
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
		txtEmail.setBounds(152, 87, 180, 20);
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
		
		txtWhere = new JTextField();
		txtWhere.setBounds(152, 118, 180, 20);
		frmDetails.getContentPane().add(txtWhere);
		txtWhere.setColumns(10);
		/*txtWhere.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						where = txtWhere.getText();
						// TODO Auto-generated method stub
						
					}
				});
		*/
		txtFirstMeet = new JTextField();
		txtFirstMeet.setBounds(152, 149, 180, 20);
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
		txtCircumstances = new JTextField();
		txtCircumstances.setBounds(152, 180, 180, 20);
		frmDetails.getContentPane().add(txtCircumstances);
		txtCircumstances.setColumns(10);
		/*txtCircumstances.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				circumstances = txtCircumstances.getText();
				// TODO Auto-generated method stub
				
			}
		});
		*/
		txtUsefulInfo = new JTextField();
		txtUsefulInfo.setBounds(152, 217, 180, 33);
		frmDetails.getContentPane().add(txtUsefulInfo);
		txtUsefulInfo.setColumns(10);
		
		btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtName.getText().equals("") || txtMobileNo.getText().equals("") || txtEmail.getText().equals("") || txtWhere.getText().equals("") || txtUsefulInfo.getText().equals("") || txtCircumstances.getText().equals(""))
   	             	JOptionPane.showMessageDialog(frmDetails, "Fields cannot be empty");
				else if(txtCircumstances.getText().length() > 100)
 				{
 					JOptionPane.showMessageDialog(frmDetails, "Circumstances too long! (Max 100 characters)");
 				}
				else if(txtWhere.getText().length() > 100)
 				{
 					JOptionPane.showMessageDialog(frmDetails, "Where too long! (Max 100 characters)");
 				}
				else if(txtUsefulInfo.getText().length() > 100)
 				{
 					JOptionPane.showMessageDialog(frmDetails, "Useful info too long! (Max 100 characters)");
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
		    	         
				where = txtWhere.getText();
				circumstances = txtCircumstances.getText();
				info = txtUsefulInfo.getText();
				
				if(when != null)
				frmDetails.dispose();

				}
			}
		});
		btnNewButton.setBounds(350, 46, 74, 102);
		frmDetails.getContentPane().add(btnNewButton);
		
		lblName = new JLabel("Name");
		lblName.setBounds(23, 28, 46, 14);
		frmDetails.getContentPane().add(lblName);
		
		lblNewLabel = new JLabel("Mobile No.");
		lblNewLabel.setBounds(23, 62, 80, 14);
		frmDetails.getContentPane().add(lblNewLabel);
		
		lblEmailAddress = new JLabel("Email address");
		lblEmailAddress.setBounds(23, 93, 80, 14);
		frmDetails.getContentPane().add(lblEmailAddress);
		
		lblWhere = new JLabel("Where");
		lblWhere.setBounds(23, 124, 46, 14);
		frmDetails.getContentPane().add(lblWhere);
		
		lblDateWhenMet = new JLabel("Date when met");
		lblDateWhenMet.setBounds(23, 155, 94, 14);
		frmDetails.getContentPane().add(lblDateWhenMet);
		
		lblCircumstances = new JLabel("Circumstances");
		lblCircumstances.setBounds(23, 186, 94, 14);
		frmDetails.getContentPane().add(lblCircumstances);
		
		lblUsefulInformation = new JLabel("Useful Information");
		lblUsefulInformation.setBounds(23, 226, 119, 14);
		frmDetails.getContentPane().add(lblUsefulInformation);
		/*txtUsefulInfo.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						info = txtUsefulInfo.getText();
						// TODO Auto-generated method stub
						
					}
				});
				*/
	}
	
	public void display_details()
	{
		frmDetails = new JFrame();
		frmDetails.setVisible(true);
		frmDetails.setTitle("Details (Casual) ");
		frmDetails.setBounds(100, 100, 492, 300);
		frmDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDetails.getContentPane().setLayout(null);
		
		txtName = new JTextField();
		txtName.setEditable(false);
		txtName.setBounds(152, 22, 180, 20);
		frmDetails.getContentPane().add(txtName);
		txtName.setColumns(10);
		txtName.setText(name);
		
		txtMobileNo = new JTextField();
		txtMobileNo.setEditable(false);
		txtMobileNo.setBounds(152, 56, 180, 20);
		frmDetails.getContentPane().add(txtMobileNo);
		txtMobileNo.setColumns(10);
		txtMobileNo.setText(mob);
		
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setBounds(152, 87, 180, 20);
		frmDetails.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		txtEmail.setText(email);
		
		txtWhere = new JTextField();
		txtWhere.setEditable(false);
		txtWhere.setBounds(152, 118, 180, 20);
		frmDetails.getContentPane().add(txtWhere);
		txtWhere.setColumns(10);
		txtWhere.setText(where);
		
		txtFirstMeet = new JTextField();
		txtFirstMeet.setEditable(false);
		txtFirstMeet.setBounds(152, 149, 180, 20);
		frmDetails.getContentPane().add(txtFirstMeet);
		txtFirstMeet.setColumns(10);
		txtFirstMeet.setText(ft.format(when));
		
		txtCircumstances = new JTextField();
		txtCircumstances.setEditable(false);
		txtCircumstances.setBounds(152, 180, 180, 20);
		frmDetails.getContentPane().add(txtCircumstances);
		txtCircumstances.setColumns(10);
		txtCircumstances.setText(circumstances);
		
		txtUsefulInfo = new JTextField();
		txtUsefulInfo.setEditable(false);
		txtUsefulInfo.setBounds(152, 217, 180, 33);
		frmDetails.getContentPane().add(txtUsefulInfo);
		txtUsefulInfo.setColumns(10);
		txtUsefulInfo.setText(info);
		
		btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmDetails.dispose();

			}
		});
		btnNewButton.setBounds(350, 46, 74, 102);
		frmDetails.getContentPane().add(btnNewButton);
		
		lblName = new JLabel("Name");
		lblName.setBounds(23, 28, 46, 14);
		frmDetails.getContentPane().add(lblName);
		
		lblNewLabel = new JLabel("Mobile No.");
		lblNewLabel.setBounds(23, 62, 80, 14);
		frmDetails.getContentPane().add(lblNewLabel);
		
		lblEmailAddress = new JLabel("Email address");
		lblEmailAddress.setBounds(23, 93, 80, 14);
		frmDetails.getContentPane().add(lblEmailAddress);
		
		lblWhere = new JLabel("Where");
		lblWhere.setBounds(23, 124, 46, 14);
		frmDetails.getContentPane().add(lblWhere);
		
		lblDateWhenMet = new JLabel("Date when met");
		lblDateWhenMet.setBounds(23, 155, 94, 14);
		frmDetails.getContentPane().add(lblDateWhenMet);
		
		lblCircumstances = new JLabel("Circumstances");
		lblCircumstances.setBounds(23, 186, 94, 14);
		frmDetails.getContentPane().add(lblCircumstances);
		
		lblUsefulInformation = new JLabel("Useful Information");
		lblUsefulInformation.setBounds(23, 226, 119, 14);
		frmDetails.getContentPane().add(lblUsefulInformation);
		
	}
}
