import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class CourseObj implements Serializable{

	private JFrame frmCourseDetails;
	private JFrame frmI , frmP, frmC;

	SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");

	
	
	private int flag = 0;
	private String name;
	private double fee;
	private Date date;
	private  int duration;
	private  String temp;
	private  int no_p , no_i ;
	private  Boolean bool1, bool2, bool3, bool4;
	private Faculty coordinator = new Faculty();
	private  ArrayList<Faculty> instructors = new ArrayList<Faculty>();
	private  ArrayList<Participant> p = new ArrayList<Participant>();
    private JTextField Name;
    private JTextField Mob;
    private JTextField Fee;
    private JTextField Duration;
    private JTextField Date;
    
    private JTextField No_I;
    private JTextField No_P;
    
    private JTextField Email;
    private JTextField Address;
    
    private JTextField Department;
    private JTextField Organization;
    private JTextField Coordinator;
    
    private JFrame frmCourses;
	
	private JButton btnSave;
	private JList listI, listP;
	private JTextField TextC;
    
    
    //Faculty instructors[] = new Faculty[5];
    //Participant p[] = new Participant[5];
    
	/**
	 * Launch the application.
	 */


	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public double getFee() {
		return fee;
	}



	public void setFee(double fee) {
		this.fee = fee;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public int getDuration() {
		return duration;
	}



	public void setDuration(int duration) {
		this.duration = duration;
	}



	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public CourseObj() {
		
		//display_details();
	}
		//initialize();
	


	
	/**
	 * @wbp.parser.entryPoint
	 */
	
	public void display_details()
	{
		frmCourses = new JFrame();
		frmCourses.setVisible(true);
		frmCourses.setTitle("Courses");
		frmCourses.setBounds(100, 100, 796, 530);
		frmCourses.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCourses.getContentPane().setLayout(null);
		
		listI = new JList();
		listI.setVisibleRowCount(5);
		listI.setBounds(305, 167, 212, 197);
		frmCourses.getContentPane().add(listI);
		
		listP = new JList();
		listP.setVisibleRowCount(5);
		listP.setBounds(538, 167, 212, 197);
		frmCourses.getContentPane().add(listP);
		
		Fee = new JTextField();
		Fee.setBounds(33, 137, 245, 20);
		frmCourses.getContentPane().add(Fee);
		Fee.setColumns(10);
		
		
		Name = new JTextField();
		Name.setColumns(10);
		Name.setBounds(33, 40, 245, 20);
		frmCourses.getContentPane().add(Name);
		
		
		
		Date = new JTextField();
		Date.setColumns(10);
		Date.setBounds(33, 183, 245, 20);
		frmCourses.getContentPane().add(Date);
		
		Duration = new JTextField();
		Duration.setColumns(10);
		Duration.setBounds(33, 242, 245, 20);
		frmCourses.getContentPane().add(Duration);
		
		TextC = new JTextField();
		TextC.setColumns(10);
		TextC.setBounds(33, 87, 245, 20);
		frmCourses.getContentPane().add(TextC);
		
		
		JLabel lblCourseName = new JLabel("Course Name");
		lblCourseName.setBounds(33, 26, 95, 14);
		frmCourses.getContentPane().add(lblCourseName);
		
		JLabel lblFacultyCoordinatorclick = new JLabel("Faculty Coordinator: (Click to Select)");
		lblFacultyCoordinatorclick.setBounds(33, 71, 212, 14);
		frmCourses.getContentPane().add(lblFacultyCoordinatorclick);
		
		JLabel lblInstructorsclickTo = new JLabel("Instructors: (Click to Select)");
		lblInstructorsclickTo.setBounds(305, 149, 212, 14);
		frmCourses.getContentPane().add(lblInstructorsclickTo);
		
		JLabel lblParticipantsclickTo = new JLabel("Participants: (Click to Select)");
		lblParticipantsclickTo.setBounds(538, 149, 196, 14);
		frmCourses.getContentPane().add(lblParticipantsclickTo);
		
		JLabel lblFee = new JLabel("Fee:");
		lblFee.setBounds(33, 117, 46, 14);
		frmCourses.getContentPane().add(lblFee);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(33, 168, 46, 14);
		frmCourses.getContentPane().add(lblDate);
		
		JLabel lblDurationdays = new JLabel("Duration: (days)");
		lblDurationdays.setBounds(33, 227, 126, 14);
		frmCourses.getContentPane().add(lblDurationdays);
		

		
		
		JButton btnEditData = new JButton("Edit Data");
		btnEditData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				bool1 = bool2 = true;
				
				btnSave.setEnabled(true);
				Name.setEditable(true);
				Fee.setEditable(true);
				Date.setEditable(true);
				Duration.setEditable(true);
				TextC.setEditable(true);
	
			}
		});
		btnEditData.setBounds(33, 301, 89, 23);
		frmCourses.getContentPane().add(btnEditData);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

				if(Name.getText().equals("") || Fee.getText().equals("")|| Date.getText().equals("") || Duration.getText().equals("") || TextC.getText().equals(""))
				{
					JOptionPane.showMessageDialog(frmCourses, "Field cannot be empty!");
				}
				else if(bool1 || bool2 )
				{
					try { 
						fee = Double.parseDouble(Fee.getText());
	   	             	bool1 = false;
	   	             	Fee.setEditable(false);
						} catch (Exception er) { 
							
								JOptionPane.showMessageDialog(frmCourses, "Enter valid Fee");
						}
				
					try { 
						duration = Integer.parseInt(Duration.getText());
	   	             	Duration.setEditable(false);
	   	             	bool2 = false;
						} catch (Exception er) { 
							
								JOptionPane.showMessageDialog(frmCourses, "Enter valid Duration");
						}
				
				
				}
				else if(Integer.parseInt(Duration.getText()) > 14 )
				{
					Duration.setEditable(true);
					bool2 = true;
					JOptionPane.showMessageDialog(frmCourses, "Duration too long! (Max 14 days)");

				}
				
				else
				{
				name = Name.getText();
				 
				fee = Double.parseDouble(Fee.getText());
   	             
   	             
					
				//temp = Fee.getText();
				//fee = Double.parseDouble(temp);
				
				try { 
					
					ft.setLenient(false);

   	             date = ft.parse(Date.getText());
   	             
   	        
   	             //System.out.println(); 
   	         } catch (ParseException er) { 
   	             JOptionPane.showMessageDialog(frmCourses, "Enter valid Date");
   	         }
   	         
				
				duration = Integer.parseInt(Duration.getText());
   	             
   	             
				//temp = Duration.getText();
				//duration = Integer.parseInt(temp);
				
				coordinator.setName(TextC.getText());
				
			if(date != null){
				btnSave.setEnabled(false);
				Name.setEditable(false);
				Fee.setEditable(false);
				Date.setEditable(false);
				Duration.setEditable(false);
				TextC.setEditable(false);
			}
				}
			}
		});
		btnSave.setBounds(167, 301, 89, 23);
		frmCourses.getContentPane().add(btnSave);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frmCourses.dispose();
			}
		});
		btnBack.setBounds(96, 370, 89, 23);
		frmCourses.getContentPane().add(btnBack);
		
		JButton btnViewDetails = new JButton("Refresh");
		btnViewDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Fee.setText(String.valueOf(fee));
				Name.setText(name);
				Date.setText(ft.format(date));
				Duration.setText(String.valueOf(duration));
				TextC.setText(coordinator.getName());
				
				btnSave.setEnabled(false);
				Name.setEditable(false);
				Fee.setEditable(false);
				Date.setEditable(false);
				Duration.setEditable(false);
				TextC.setEditable(false);
				
				
				DefaultListModel<String> DLMI = new DefaultListModel<String>();
				for(int i=0 ; i<instructors.size(); i++)
				{
					DLMI.addElement(instructors.get(i).getName());
				}
				listI.setModel(DLMI);
				
				/*listI.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
					
					//@Override
					public void valueChanged(ListSelectionEvent arg0) {
						
						int pos = listI.getSelectedIndex();
						
						instructors.get(pos).details();
					}
			});*/
				DefaultListModel<String> DLMP = new DefaultListModel<String>();
				for(int i=0 ; i<p.size(); i++)
				{
					DLMP.addElement(p.get(i).getName());
				}
				listP.setModel(DLMP);
			}
		});
				
				/*listP.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
					
					//@Override
					public void valueChanged(ListSelectionEvent arg0) {
						
						int posp = listP.getSelectedIndex();
						
						p.get(posp).details();
					}
			});*/
			
				
				
		btnViewDetails.setBounds(529, 29, 205, 43);
		frmCourses.getContentPane().add(btnViewDetails);
		
		JButton btnAddInstructors = new JButton("Add Instructor");
		btnAddInstructors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(instructors.size() == 5 )
				{
					JOptionPane.showMessageDialog(frmCourses, "Max 5 instructors allowed");
				}
				else
				{
				Faculty in = new Faculty();
				in.details();
				instructors.add(in);
				}
			}
		});
		btnAddInstructors.setBounds(305, 443, 212, 23);
		frmCourses.getContentPane().add(btnAddInstructors);
		
		JButton btnAddParticipant = new JButton("Add Participant");
		btnAddParticipant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(p.size() == 5 )
				{
					JOptionPane.showMessageDialog(frmCourses, "Max 5 partcipants allowed");
				}
				else
				{
				Participant part = new Participant();
				part.details();
				p.add(part);
				}
			}
		});
		btnAddParticipant.setBounds(538, 443, 212, 23);
		frmCourses.getContentPane().add(btnAddParticipant);
		
		JButton btnViewDetailsOf = new JButton("View Selected Instructor");
		btnViewDetailsOf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int posi = listI.getSelectedIndex();
				if(posi < 0)
					JOptionPane.showMessageDialog(frmCourses, "Select an Instructor");
				else
				instructors.get(posi).details();
			}
		});
		btnViewDetailsOf.setBounds(305, 375, 212, 23);
		frmCourses.getContentPane().add(btnViewDetailsOf);
		
		JButton btnViewSelectedParticipant = new JButton("View Selected Participant");
		btnViewSelectedParticipant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int posp = listP.getSelectedIndex();
				if(posp < 0)
					JOptionPane.showMessageDialog(frmCourses, "Select a Participant");
				else
				p.get(posp).details();
				
			}
		});
		btnViewSelectedParticipant.setBounds(538, 375, 212, 23);
		frmCourses.getContentPane().add(btnViewSelectedParticipant);
		
		JButton btnViewCoordinator = new JButton("View Coordinator");
		btnViewCoordinator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				coordinator.details();
			}
		});
		btnViewCoordinator.setBounds(305, 89, 212, 23);
		frmCourses.getContentPane().add(btnViewCoordinator);
		
		JButton btnDeleteSelectedInstructor = new JButton("Delete Selected Instructor");
		btnDeleteSelectedInstructor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int posi = listI.getSelectedIndex();
				if(posi < 0)
					JOptionPane.showMessageDialog(frmCourses, "Select an Instructor");
				else
				instructors.remove(posi);
			}
		});
		btnDeleteSelectedInstructor.setBounds(305, 409, 212, 23);
		frmCourses.getContentPane().add(btnDeleteSelectedInstructor);
		
		JButton btnDeleteSelectedParticipant = new JButton("Delete Selected Participant");
		btnDeleteSelectedParticipant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int posp = listP.getSelectedIndex();
				if(posp < 0)
					JOptionPane.showMessageDialog(frmCourses, "Select a Participant");
				else
				p.remove(posp);
			}
		});
		btnDeleteSelectedParticipant.setBounds(538, 409, 212, 23);
		frmCourses.getContentPane().add(btnDeleteSelectedParticipant);
		
		
	}
	
	public void instructor_details()
	{
		if(flag < no_i)
		{
			Faculty instructor = new Faculty();
			frmI = new JFrame();
			frmI.setVisible(true);
			frmI.setTitle("Instructor Details");
			frmI.setBounds(100, 100, 560, 330);
			frmI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frmI.getContentPane().setLayout(null);
			
			Name = new JTextField();
			Name.setBounds(167, 25, 283, 20);
			frmI.getContentPane().add(Name);
			Name.setColumns(10);
			
			Mob = new JTextField();
			Mob.setBounds(167, 67, 283, 20);
			frmI.getContentPane().add(Mob);
			Mob.setColumns(10);
			
			Email = new JTextField();
			Email.setBounds(167, 111, 283, 20);
			frmI.getContentPane().add(Email);
			Email.setColumns(10);
			
			Address = new JTextField();
			Address.setBounds(167, 153, 283, 20);
			frmI.getContentPane().add(Address);
			Address.setColumns(10);
			
			Department = new JTextField();
			Department.setBounds(167, 194, 283, 20);
			frmI.getContentPane().add(Department);
			Department.setColumns(10);
			
			JLabel lblName = new JLabel("Name");
			lblName.setBounds(10, 28, 46, 14);
			frmI.getContentPane().add(lblName);
			
			JLabel lblFee = new JLabel("Mob No.");
			lblFee.setBounds(10, 70, 46, 14);
			frmI.getContentPane().add(lblFee);
			
			JLabel lblDuration = new JLabel("Address");
			lblDuration.setBounds(10, 156, 46, 14);
			frmI.getContentPane().add(lblDuration);
			
			JLabel lblNewLabel = new JLabel("Email");
			lblNewLabel.setBounds(10, 114, 46, 14);
			frmI.getContentPane().add(lblNewLabel);
			
			JLabel lblCoordinator = new JLabel("Department");
			lblCoordinator.setBounds(10, 197, 70, 14);
			frmI.getContentPane().add(lblCoordinator);
			
			JButton btnNext = new JButton("Next >");
			btnNext.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					
					if(Name.getText().equals("") || Mob.getText().equals("")|| Email.getText().equals("") || Address.getText().equals("") || Department.getText().equals(""))
					{
						JOptionPane.showMessageDialog(frmI, "Field cannot be empty!");
					}
					else
					{
					instructor.setName(Name.getText());
					instructor.setMob(Mob.getText());
					
					instructor.setEmail(Email.getText());
					instructor.setAddress(Address.getText());
					
					instructor.setDept(Department.getText());
					
					
					instructors.add(instructor);
					flag = flag + 1;
					frmI.dispose();
					instructor_details();
					}
					
				}
			});
			btnNext.setBounds(269, 241, 89, 23);
			frmI.getContentPane().add(btnNext);
		
		}
		else
		{
			flag = 0;
			
		}
		
	}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void participant_details()
	{
		if(flag < no_p)
		{
			Participant participant = new Participant();
			frmP = new JFrame();
			frmP.setVisible(true);
			frmP.setTitle("Participant Details");
			frmP.setBounds(100, 100, 568, 330);
			frmP.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frmP.getContentPane().setLayout(null);
			
			Name = new JTextField();
			Name.setBounds(181, 25, 283, 20);
			frmP.getContentPane().add(Name);
			Name.setColumns(10);
			
			Mob = new JTextField();
			Mob.setBounds(181, 67, 283, 20);
			frmP.getContentPane().add(Mob);
			Mob.setColumns(10);
			
			Email = new JTextField();
			Email.setBounds(181, 111, 283, 20);
			frmP.getContentPane().add(Email);
			Email.setColumns(10);
			
			Address = new JTextField();
			Address.setBounds(181, 153, 283, 20);
			frmP.getContentPane().add(Address);
			Address.setColumns(10);
			
			Organization = new JTextField();
			Organization.setBounds(181, 194, 283, 20);
			frmP.getContentPane().add(Organization);
			Organization.setColumns(10);
			
			JLabel lblName = new JLabel("Name");
			lblName.setBounds(10, 28, 46, 14);
			frmP.getContentPane().add(lblName);
			
			JLabel lblFee = new JLabel("Mob No.");
			lblFee.setBounds(10, 70, 46, 14);
			frmP.getContentPane().add(lblFee);
			
			JLabel lblDuration = new JLabel("Address");
			lblDuration.setBounds(10, 156, 46, 14);
			frmP.getContentPane().add(lblDuration);
			
			JLabel lblNewLabel = new JLabel("Email");
			lblNewLabel.setBounds(10, 114, 46, 14);
			frmP.getContentPane().add(lblNewLabel);
			
			JLabel lblCoordinator = new JLabel("Organization");
			lblCoordinator.setBounds(10, 197, 70, 14);
			frmP.getContentPane().add(lblCoordinator);
			
			JButton btnNext = new JButton("Next >");
			btnNext.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					if(Name.getText().equals("") || Mob.getText().equals("")|| Email.getText().equals("") || Address.getText().equals("") || Organization.getText().equals(""))
					{
						JOptionPane.showMessageDialog(frmP, "Field cannot be empty!");
					}
					else
					{
					participant.setName(Name.getText());
					participant.setMob(Mob.getText());
					
					participant.setEmail(Email.getText());
					participant.setAddress(Address.getText());
					
					participant.setOrg(Organization.getText());
					
					flag = flag + 1;
					frmP.dispose();
					participant_details();
					p.add(participant);
					
					}
				}
			});
			btnNext.setBounds(276, 242, 89, 23);
			frmP.getContentPane().add(btnNext);
			
		}
		else
		{
			flag = 0;
			instructor_details();
		}
	}
	
	/*public void getinstructors()
	{
		for (int i = 0; i < no_i ; i++) 
		{
			instructor_details();
		}
	}*/
	/*public void participants()
	{
		for( int i = 0 ; i < no_p ; i++)
			participant_details();
		
		getinstructors();
	}*/
	/**
	 * @wbp.parser.entryPoint
	 */
	public void coordinator_details()
	{
		frmC = new JFrame();
		frmC.setVisible(true);
		frmC.setTitle("Coordinator Details");
		frmC.setBounds(100, 100, 537, 330);
		frmC.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmC.getContentPane().setLayout(null);
		
		Name = new JTextField();
		Name.setBounds(167, 25, 283, 20);
		frmC.getContentPane().add(Name);
		Name.setColumns(10);
		
		Mob = new JTextField();
		Mob.setBounds(167, 67, 283, 20);
		frmC.getContentPane().add(Mob);
		Mob.setColumns(10);
		
		Email = new JTextField();
		Email.setBounds(167, 111, 283, 20);
		frmC.getContentPane().add(Email);
		Email.setColumns(10);
		
		Address = new JTextField();
		Address.setBounds(167, 153, 283, 20);
		frmC.getContentPane().add(Address);
		Address.setColumns(10);
		
		Department = new JTextField();
		Department.setBounds(167, 194, 283, 20);
		frmC.getContentPane().add(Department);
		Department.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 28, 46, 14);
		frmC.getContentPane().add(lblName);
		
		JLabel lblFee = new JLabel("Mob No.");
		lblFee.setBounds(10, 70, 46, 14);
		frmC.getContentPane().add(lblFee);
		
		JLabel lblDuration = new JLabel("Address");
		lblDuration.setBounds(10, 156, 46, 14);
		frmC.getContentPane().add(lblDuration);
		
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setBounds(10, 114, 46, 14);
		frmC.getContentPane().add(lblNewLabel);
		
		JLabel lblCoordinator = new JLabel("Department");
		lblCoordinator.setBounds(10, 197, 70, 14);
		frmC.getContentPane().add(lblCoordinator);
		
		JButton btnNext = new JButton("Next >");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(Name.getText().equals("") || Mob.getText().equals("")|| Email.getText().equals("") || Address.getText().equals("") || Department.getText().equals(""))
				{
					JOptionPane.showMessageDialog(frmC, "Field cannot be empty!");
				}
				else
				{
				coordinator.setName(Name.getText());
				coordinator.setMob(Mob.getText());
				
				coordinator.setEmail(Email.getText());
				coordinator.setAddress(Address.getText());
				
				coordinator.setDept(Department.getText());
				
				participant_details();
				frmC.dispose();
				}
			}
		});
		btnNext.setBounds(267, 242, 89, 23);
		frmC.getContentPane().add(btnNext);
		
	}
	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	public void getDetails() 
	{
		bool1 = bool2 = bool3 = bool4 = true;
		frmCourseDetails = new JFrame();
		frmCourseDetails.setVisible(true);
		frmCourseDetails.setTitle("Course Details");
		frmCourseDetails.setBounds(100, 100, 618, 395);
		frmCourseDetails.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCourseDetails.getContentPane().setLayout(null);
		
		Name = new JTextField();
		Name.setBounds(175, 25, 283, 20);
		frmCourseDetails.getContentPane().add(Name);
		Name.setColumns(10);
		
		Fee = new JTextField();
		Fee.setBounds(175, 67, 283, 20);
		frmCourseDetails.getContentPane().add(Fee);
		Fee.setColumns(10);
		
		Date = new JTextField();
		Date.setBounds(175, 111, 283, 20);
		frmCourseDetails.getContentPane().add(Date);
		Date.setColumns(10);
		
		Duration = new JTextField();
		Duration.setBounds(175, 153, 283, 20);
		frmCourseDetails.getContentPane().add(Duration);
		Duration.setColumns(10);
		
		Coordinator = new JTextField();
		Coordinator.setBounds(175, 194, 283, 20);
		frmCourseDetails.getContentPane().add(Coordinator);
		Coordinator.setColumns(10);
		
		No_P = new JTextField();
		No_P.setBounds(199, 235, 259, 20);
		frmCourseDetails.getContentPane().add(No_P);
		No_P.setColumns(10);
		
		No_I = new JTextField();
		No_I.setBounds(199, 276, 259, 20);
		frmCourseDetails.getContentPane().add(No_I);
		No_I.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 28, 46, 14);
		frmCourseDetails.getContentPane().add(lblName);
		
		JLabel lblFee = new JLabel("Fee:");
		lblFee.setBounds(10, 70, 46, 14);
		frmCourseDetails.getContentPane().add(lblFee);
		
		JLabel lblDuration = new JLabel("Duration:");
		lblDuration.setBounds(10, 156, 46, 14);
		frmCourseDetails.getContentPane().add(lblDuration);
		
		JLabel lblNewLabel = new JLabel("Date:");
		lblNewLabel.setBounds(10, 114, 46, 14);
		frmCourseDetails.getContentPane().add(lblNewLabel);
		
		JLabel lblCoordinator = new JLabel("Coordinator:");
		lblCoordinator.setBounds(10, 197, 70, 14);
		frmCourseDetails.getContentPane().add(lblCoordinator);
		
		JLabel lblNoOfParticipants = new JLabel("No. of participants (Max 5) :");
		lblNoOfParticipants.setBounds(10, 238, 164, 14);
		frmCourseDetails.getContentPane().add(lblNoOfParticipants);
		
		JLabel lblNoOfInstructors = new JLabel("No. of instructors (Max 5):");
		lblNoOfInstructors.setBounds(10, 279, 164, 14);
		frmCourseDetails.getContentPane().add(lblNoOfInstructors);
		
		JButton btnNext = new JButton("Next >");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				
				
				if(Name.getText().equals("") || Fee.getText().equals("")|| Date.getText().equals("") || Duration.getText().equals("") || Coordinator.getText().equals("") || No_P.getText().equals("") || No_I.getText().equals(""))
				{
					JOptionPane.showMessageDialog(frmCourseDetails, "Field cannot be empty!");
				}
				else if(bool1 || bool2 || bool3 || bool4)
				{
					try { 
						fee = Double.parseDouble(Fee.getText());
	   	             	bool1 = false;
	   	             	Fee.setEditable(false);
						} catch (Exception er) { 
							
								JOptionPane.showMessageDialog(frmCourseDetails, "Enter valid Fee");
						}
				
					try { 
						duration = Integer.parseInt(Duration.getText());
	   	             	Duration.setEditable(false);
	   	             	bool2 = false;
						} catch (Exception er) { 
							
								JOptionPane.showMessageDialog(frmCourseDetails, "Enter valid Duration");
						}
				
					try { 
						temp = No_P.getText();
						no_p = Integer.parseInt(temp);
						No_P.setEditable(false);
						bool3 = false;
	   	             
						} catch (Exception er) { 
							
								JOptionPane.showMessageDialog(frmCourseDetails, "Enter valid No. of participants");
						}
				
					try { 
						temp = No_I.getText();
						no_i = Integer.parseInt(temp);
						No_I.setEditable(false);
						bool4 = false;
	   	             
						} catch (Exception er) { 
							
								JOptionPane.showMessageDialog(frmCourseDetails, "Enter valid No. of instructors");
						}
				}
				else if(Integer.parseInt(Duration.getText()) > 14 )
				{
					Duration.setEditable(true);
					bool2 = true;
					JOptionPane.showMessageDialog(frmCourseDetails, "Duration too long! (Max 14 days)");

				}
				else if(Integer.parseInt(No_P.getText()) > 5 )
				{
					No_P.setEditable(true);
					bool3 = true;
					JOptionPane.showMessageDialog(frmCourseDetails, "No. of participants too large! (Max 5)");

				}
				else if(Integer.parseInt(No_I.getText()) > 5 )
				{
					No_I.setEditable(true);
					bool4 = true;
					JOptionPane.showMessageDialog(frmCourseDetails, "No. of instructors too large! (Max 5)");

				}
				else
				{
				name = Name.getText();
				 
				fee = Double.parseDouble(Fee.getText());
   	             
   	             
					
				//temp = Fee.getText();
				//fee = Double.parseDouble(temp);
				
				try { 
					
					ft.setLenient(false);

   	             	date = ft.parse(Date.getText());
   	             	
   	             	
   	             //System.out.println(); 
					} catch (ParseException er) { 
						JOptionPane.showMessageDialog(frmCourseDetails, "Enter valid Date");
					}	
   	         
				
				duration = Integer.parseInt(Duration.getText());
   	             
   	             
				//temp = Duration.getText();
				//duration = Integer.parseInt(temp);
				
				coordinator.setName(Coordinator.getText());
				
				temp = No_P.getText();
				no_p = Integer.parseInt(temp);
				
				temp = No_I.getText();
				no_i = Integer.parseInt(temp);
				
				if(date != null)
				{
				coordinator_details();
				frmCourseDetails.dispose();
				}
				}
			}
		});
		btnNext.setBounds(261, 322, 89, 23);
		frmCourseDetails.getContentPane().add(btnNext);
	}

}
