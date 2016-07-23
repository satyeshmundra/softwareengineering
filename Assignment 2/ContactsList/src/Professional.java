import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Professional implements Serializable{

	private JFrame frame;
	private JFrame frmDetails;
	private JTextField txtName;
	private JTextField txtMobileNo;
	private JTextField txtEmail;
	private JTextField txtCommon;

	
	
	private String name, mob, email, common;
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

	public String getCommon() {
		return common;
	}

	public void setCommon(String common) {
		this.common = common;
	}


	private JButton btnNewButton;
	private JLabel lblName;
	private JLabel lblMobileNo;
	private JLabel lblEmailAddress;
	private JLabel lblCommon;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public Professional() {
		name = mob = email = common = "";
		
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
		frmDetails.setBounds(100, 100, 496, 300);
		frmDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDetails.getContentPane().setLayout(null);
		
		txtName = new JTextField();
		txtName.setBounds(157, 22, 175, 20);
		frmDetails.getContentPane().add(txtName);
		txtName.setColumns(10);
		txtName.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				name = txtName.getText();
				// TODO Auto-generated method stub
				
			}
		});
		
		txtMobileNo = new JTextField();
		txtMobileNo.setBounds(157, 80, 175, 20);
		frmDetails.getContentPane().add(txtMobileNo);
		txtMobileNo.setColumns(10);
		txtMobileNo.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						mob = txtMobileNo.getText();
						// TODO Auto-generated method stub
						
					}
				});
		
		txtEmail = new JTextField();
		txtEmail.setBounds(157, 144, 175, 20);
		frmDetails.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		txtEmail.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						email = txtEmail.getText();
						// TODO Auto-generated method stub
						
					}
				});
		
		
		txtCommon = new JTextField();
		txtCommon.setBounds(157, 203, 175, 20);
		frmDetails.getContentPane().add(txtCommon);
		txtCommon.setColumns(10);
		
		btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtName.getText().equals("") || txtMobileNo.getText().equals("") || txtEmail.getText().equals("") || txtCommon.getText().equals(""))
   	             	JOptionPane.showMessageDialog(frmDetails, "Fields cannot be empty");
				else if(txtCommon.getText().length() > 100)
 				{
 					JOptionPane.showMessageDialog(frmDetails, "Common too long! (Max 100 characters)");
 				}
				else
				{
				name = txtName.getText();
				mob = txtMobileNo.getText();
				email = txtEmail.getText();
				common = txtCommon.getText();
				frmDetails.dispose();
				}
			}
		});
		btnNewButton.setBounds(371, 56, 72, 91);
		frmDetails.getContentPane().add(btnNewButton);
		
		lblName = new JLabel("Name");
		lblName.setBounds(21, 28, 46, 14);
		frmDetails.getContentPane().add(lblName);
		
		lblMobileNo = new JLabel("Mobile No.");
		lblMobileNo.setBounds(21, 83, 84, 14);
		frmDetails.getContentPane().add(lblMobileNo);
		
		lblEmailAddress = new JLabel("Email address");
		lblEmailAddress.setBounds(21, 150, 84, 14);
		frmDetails.getContentPane().add(lblEmailAddress);
		
		lblCommon = new JLabel("Common");
		lblCommon.setBounds(21, 209, 72, 14);
		frmDetails.getContentPane().add(lblCommon);
		/*txtCommon.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						common = txtCommon.getText();
						// TODO Auto-generated method stub
						
					}
				});*/
	}
	
	public void display_details()
	{
		frmDetails = new JFrame();
		frmDetails.setVisible(true);
		frmDetails.setTitle("Details (Professional) ");
		frmDetails.setBounds(100, 100, 496, 300);
		frmDetails.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmDetails.getContentPane().setLayout(null);
		
		txtName = new JTextField();
		txtName.setEditable(false);
		txtName.setBounds(157, 22, 175, 20);
		frmDetails.getContentPane().add(txtName);
		txtName.setColumns(10);
		txtName.setText(name);
		
		txtMobileNo = new JTextField();
		txtMobileNo.setEditable(false);
		txtMobileNo.setBounds(157, 80, 175, 20);
		frmDetails.getContentPane().add(txtMobileNo);
		txtMobileNo.setColumns(10);
		txtMobileNo.setText(mob);
		
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setBounds(157, 144, 175, 20);
		frmDetails.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		txtEmail.setText(email);
		
		txtCommon = new JTextField();
		txtCommon.setEditable(false);
		txtCommon.setBounds(157, 203, 175, 20);
		frmDetails.getContentPane().add(txtCommon);
		txtCommon.setColumns(10);
		txtCommon.setText(common);
		
		btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmDetails.dispose();

			}
		});
		btnNewButton.setBounds(371, 56, 72, 91);
		frmDetails.getContentPane().add(btnNewButton);
		
		lblName = new JLabel("Name");
		lblName.setBounds(21, 28, 46, 14);
		frmDetails.getContentPane().add(lblName);
		
		lblMobileNo = new JLabel("Mobile No.");
		lblMobileNo.setBounds(21, 83, 84, 14);
		frmDetails.getContentPane().add(lblMobileNo);
		
		lblEmailAddress = new JLabel("Email address");
		lblEmailAddress.setBounds(21, 150, 84, 14);
		frmDetails.getContentPane().add(lblEmailAddress);
		
		lblCommon = new JLabel("Common");
		lblCommon.setBounds(21, 209, 72, 14);
		frmDetails.getContentPane().add(lblCommon);
		
	}
}
