import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Faculty implements Serializable {

	private JFrame frmFaculty;

	
	
	private JTextField textName;
	private JTextField textMob;
	private JTextField textEmail;
	private JTextField textAddress;
	private JTextField textDept;
	private JButton btnSave;
	
	private String name;
	private String address;
	private String email;
	private String mob;
	private String dept;
	/**
	 * Launch the application.
	 */
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMob() {
		return mob;
	}

	public void setMob(String mob) {
		this.mob = mob;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	/**
	 * Create the application.
	 */
	public Faculty() {
		//initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	public void details() {
		
		
		frmFaculty = new JFrame();
		frmFaculty.setTitle("Faculty");
		frmFaculty.setVisible(true);
		frmFaculty.setBounds(100, 100, 450, 300);
		frmFaculty.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmFaculty.getContentPane().setLayout(null);
		
		textName = new JTextField();
		textName.setText(name);
		textName.setEditable(false);
		textName.setBounds(96, 23, 195, 20);
		frmFaculty.getContentPane().add(textName);
		textName.setColumns(10);
		
		textMob = new JTextField();
		textMob.setText(mob);
		textMob.setEditable(false);
		textMob.setBounds(96, 54, 195, 20);
		frmFaculty.getContentPane().add(textMob);
		textMob.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setText(email);
		textEmail.setEditable(false);
		textEmail.setBounds(96, 94, 195, 20);
		frmFaculty.getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		textAddress = new JTextField();
		textAddress.setText(address);
		textAddress.setEditable(false);
		textAddress.setBounds(96, 134, 195, 20);
		frmFaculty.getContentPane().add(textAddress);
		textAddress.setColumns(10);
		
		textDept = new JTextField();
		textDept.setText(dept);
		textDept.setEditable(false);
		textDept.setBounds(96, 176, 195, 20);
		frmFaculty.getContentPane().add(textDept);
		textDept.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(21, 26, 46, 14);
		frmFaculty.getContentPane().add(lblName);
		
		JLabel lblMobileNo = new JLabel("Mobile No.");
		lblMobileNo.setBounds(21, 57, 55, 14);
		frmFaculty.getContentPane().add(lblMobileNo);
		
		JLabel lblNewLabel = new JLabel("Email:");
		lblNewLabel.setBounds(21, 97, 46, 14);
		frmFaculty.getContentPane().add(lblNewLabel);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(21, 137, 55, 14);
		frmFaculty.getContentPane().add(lblAddress);
		
		JLabel lblDepartment = new JLabel("Department:");
		lblDepartment.setBounds(21, 179, 65, 14);
		frmFaculty.getContentPane().add(lblDepartment);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				btnSave.setEnabled(true);
				textAddress.setEditable(true);
				textEmail.setEditable(true);
				textMob.setEditable(true);
				textName.setEditable(true);
				textDept.setEditable(true);
			}
		});
		btnEdit.setBounds(50, 227, 89, 23);
		frmFaculty.getContentPane().add(btnEdit);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(textName.getText().equals("") || textMob.getText().equals("")|| textEmail.getText().equals("") || textAddress.getText().equals("") || textDept.getText().equals(""))
				{
					JOptionPane.showMessageDialog(frmFaculty, "Field cannot be empty!");
				}
				else
				{
				name = textName.getText();
				mob = textMob.getText();
				email = textEmail.getText();
				address = textAddress.getText();
				dept = textDept.getText();
				
				btnSave.setEnabled(false);
				textAddress.setEditable(false);
				textEmail.setEditable(false);
				textMob.setEditable(false);
				textName.setEditable(false);
				textDept.setEditable(false);
				}
				
			}
		});
		btnSave.setBounds(183, 227, 89, 23);
		btnSave.setEnabled(false);
		frmFaculty.getContentPane().add(btnSave);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frmFaculty.dispose();
			}
		});
		btnBack.setBounds(314, 227, 78, 23);
		frmFaculty.getContentPane().add(btnBack);
	}

}
