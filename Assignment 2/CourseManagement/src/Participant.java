import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.awt.event.ActionEvent;

public class Participant implements Serializable {

	
	private String name;
	private  String address;
	private  String email;
	private String mob;
	private String org;
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

	public String getOrg() {
		return org;
	}

	public void setOrg(String org) {
		this.org = org;
	}

	private JFrame frmParticipant;
	private JTextField textName;
	private JTextField textMob;
	private JTextField textEmail;
	private JTextField textAddress;
	private JTextField textOrg;
	private JButton btnSave;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public Participant() {
		//initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	public void details() {
		frmParticipant = new JFrame();
		frmParticipant.setVisible(true);
		frmParticipant.setTitle("Participant");
		frmParticipant.setBounds(100, 100, 450, 300);
		frmParticipant.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmParticipant.getContentPane().setLayout(null);
		
		textName = new JTextField();
		textName.setText(name);
		textName.setEditable(false);
		textName.setBounds(96, 23, 195, 20);
		frmParticipant.getContentPane().add(textName);
		textName.setColumns(10);
		
		textMob = new JTextField();
		textMob.setText(mob);
		textMob.setEditable(false);
		textMob.setBounds(96, 54, 195, 20);
		frmParticipant.getContentPane().add(textMob);
		textMob.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setText(email);
		textEmail.setEditable(false);
		textEmail.setBounds(96, 94, 195, 20);
		frmParticipant.getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		textAddress = new JTextField();
		textAddress.setText(address);
		textAddress.setEditable(false);
		textAddress.setBounds(96, 134, 195, 20);
		frmParticipant.getContentPane().add(textAddress);
		textAddress.setColumns(10);
		
		textOrg = new JTextField();
		textOrg.setText(org);
		textOrg.setEditable(false);
		textOrg.setBounds(96, 176, 195, 20);
		frmParticipant.getContentPane().add(textOrg);
		textOrg.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(21, 26, 46, 14);
		frmParticipant.getContentPane().add(lblName);
		
		JLabel lblMobileNo = new JLabel("Mobile No.");
		lblMobileNo.setBounds(21, 57, 55, 14);
		frmParticipant.getContentPane().add(lblMobileNo);
		
		JLabel lblNewLabel = new JLabel("Email:");
		lblNewLabel.setBounds(21, 97, 46, 14);
		frmParticipant.getContentPane().add(lblNewLabel);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(21, 137, 55, 14);
		frmParticipant.getContentPane().add(lblAddress);
		
		JLabel lblOrganization = new JLabel("Organization:");
		lblOrganization.setBounds(21, 179, 65, 14);
		frmParticipant.getContentPane().add(lblOrganization);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				btnSave.setEnabled(true);
				textAddress.setEditable(true);
				textEmail.setEditable(true);
				textMob.setEditable(true);
				textName.setEditable(true);
				textOrg.setEditable(true);
			}
		});
		btnEdit.setBounds(50, 227, 89, 23);
		frmParticipant.getContentPane().add(btnEdit);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				if(textName.getText().equals("") || textMob.getText().equals("")|| textEmail.getText().equals("") || textAddress.getText().equals("") || textOrg.getText().equals(""))
				{
					JOptionPane.showMessageDialog(frmParticipant, "Field cannot be empty!");
				}
				else
				{
				name = textName.getText();
				mob = textMob.getText();
				email = textEmail.getText();
				address = textAddress.getText();
				org = textOrg.getText();
				
				btnSave.setEnabled(false);
				textAddress.setEditable(false);
				textEmail.setEditable(false);
				textMob.setEditable(false);
				textName.setEditable(false);
				textOrg.setEditable(false);
				}
				
			}
		});
		btnSave.setBounds(189, 227, 89, 23);
		btnSave.setEnabled(false);
		frmParticipant.getContentPane().add(btnSave);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frmParticipant.dispose();
			}
		});
		btnBack.setBounds(329, 227, 78, 23);
		frmParticipant.getContentPane().add(btnBack);
	}

}
