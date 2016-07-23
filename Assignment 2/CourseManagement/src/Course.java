import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Course implements Serializable {

	
	private JFrame frmCourseMenu;
	private JFrame frmCourses;

	private ArrayList<CourseObj> course = new ArrayList<CourseObj>();
	private Date current_date = new Date();
	
	private String sc;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Course window = new Course();
					window.frmCourseMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public void savecourses(ArrayList<CourseObj> course){
	     try{
	         FileOutputStream first =new FileOutputStream("Courses.ser");
	         ObjectOutputStream second = new ObjectOutputStream(first);
	         second.writeObject(course);
	         
	        // System.out.println("Changes saved successfully");

	         }
	     catch(Exception e){
	         
	         JOptionPane.showMessageDialog(frmCourseMenu, "Error in Saving");
	     }
	 }
	
	public  void readcourses(){
	     try{
	         FileInputStream first =new FileInputStream("Courses.ser");
	         ObjectInputStream second = new ObjectInputStream(first);
	         course = (ArrayList<CourseObj>) second.readObject();
	 	       
	     }
	     catch(Exception e){
	    	 JOptionPane.showMessageDialog(frmCourseMenu, "Error in Reading");
	         
	     }
	 }
	
	/**
	 * Create the application.
	 */
	public Course() {
		//Display_Courses();
		initialize();
	}

	public void Search(String sc)
	{
		for(int i=0 ; i<course.size() ; i++)
		{
			if(sc.compareTo(course.get(i).getName()) == 0)
			{
				//System.out.println("Search found in Relatives");
				course.get(i).display_details();
				
				break;
			}
		}
	}
	
	public void DisplayFive()
	{
        Calendar cal = Calendar.getInstance();

		frmCourses = new JFrame();
		frmCourses.setVisible(true);
		frmCourses.setTitle("Courses");
		frmCourses.setBounds(100, 100, 475, 342);
		frmCourses.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCourses.getContentPane().setLayout(null);
		
		JList<String> list = new JList<String>();
		list.setVisibleRowCount(10);
		list.setBounds(23, 63, 304, 187);
		frmCourses.getContentPane().add(list);
		
		JLabel lblCoursesclickTo = new JLabel("Courses:  (Click to edit or display details) ");
		lblCoursesclickTo.setBounds(23, 38, 304, 14);
		frmCourses.getContentPane().add(lblCoursesclickTo);
		
		JButton btnView = new JButton("Refresh");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DefaultListModel<String> DLM = new DefaultListModel<String>();
				for(int i=0 ; i<course.size(); i++)
				{
					cal.setTime(course.get(i).getDate());
            		int year=cal.get(Calendar.YEAR);
            		
     			   	cal.setTime(current_date);
     			   	if((year - cal.get(Calendar.YEAR))  < 5 && (year - cal.get(Calendar.YEAR)) > 0)
					DLM.addElement(course.get(i).getName());
				}
				list.setModel(DLM);
				
				
			}
		});
		btnView.setBounds(335, 97, 91, 23);
		frmCourses.getContentPane().add(btnView);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frmCourses.dispose();
			}
		});
		btnBack.setBounds(337, 163, 89, 23);
		frmCourses.getContentPane().add(btnBack);
		
		JButton btnNewButton_1 = new JButton("View details of the selected course");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int pos = list.getSelectedIndex();
				if(pos < 0)
					JOptionPane.showMessageDialog(frmCourses, "Select a course");
				else
					sc = list.getSelectedValue();
					Search(sc);
			}
		});
		btnNewButton_1.setBounds(23, 261, 304, 23);
		frmCourses.getContentPane().add(btnNewButton_1);
		
	}
	
	
	public void Create_Courses()
	{
		CourseObj obj = new CourseObj();
		obj.getDetails();
		course.add(obj);
		
	}
	
	
	public void Display_Courses()
	{
		frmCourses = new JFrame();
		frmCourses.setVisible(true);
		frmCourses.setTitle("Courses");
		frmCourses.setBounds(100, 100, 475, 342);
		frmCourses.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCourses.getContentPane().setLayout(null);
		
		JList<String> list = new JList<String>();
		list.setVisibleRowCount(10);
		list.setBounds(23, 63, 304, 187);
		frmCourses.getContentPane().add(list);
		
		JLabel lblCoursesclickTo = new JLabel("Courses:  (Click to edit or display details) ");
		lblCoursesclickTo.setBounds(23, 38, 304, 14);
		frmCourses.getContentPane().add(lblCoursesclickTo);
		
		JButton btnView = new JButton("Refresh");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DefaultListModel<String> DLM = new DefaultListModel<String>();
				for(int i=0 ; i<course.size(); i++)
				{
					DLM.addElement(course.get(i).getName());
				}
				list.setModel(DLM);
				
				
			}
		});
		btnView.setBounds(335, 97, 91, 23);
		frmCourses.getContentPane().add(btnView);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frmCourses.dispose();
			}
		});
		btnBack.setBounds(337, 163, 89, 23);
		frmCourses.getContentPane().add(btnBack);
		
		JButton btnNewButton_1 = new JButton("View details of the selected course");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int pos = list.getSelectedIndex();
				if(pos < 0)
					JOptionPane.showMessageDialog(frmCourses, "Select a course");
				else
				course.get(pos).display_details();
			}
		});
		btnNewButton_1.setBounds(23, 261, 304, 23);
		frmCourses.getContentPane().add(btnNewButton_1);
		
		/*list.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent event) {
				
				int pos = list.getSelectedIndex();
				
				course.get(pos).display_details();
			}
	});*/
		
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		readcourses();
		frmCourseMenu = new JFrame();
		frmCourseMenu.setTitle("Course Menu");
		frmCourseMenu.setBounds(100, 100, 450, 300);
		frmCourseMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCourseMenu.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Create a Course");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Create_Courses();
			}
		});
		btnNewButton.setBounds(24, 26, 338, 23);
		frmCourseMenu.getContentPane().add(btnNewButton);
		
		JButton btnDisplayAll = new JButton("Display all the Courses (Click to Edit)");
		btnDisplayAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Display_Courses();
			}
		});
		btnDisplayAll.setBounds(24, 65, 338, 23);
		frmCourseMenu.getContentPane().add(btnDisplayAll);
		
		JButton btnDisplayTheCourses = new JButton("Display the Courses for 5 year");
		btnDisplayTheCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DisplayFive();
			}
		});
		btnDisplayTheCourses.setBounds(24, 108, 338, 23);
		frmCourseMenu.getContentPane().add(btnDisplayTheCourses);
		
		JButton btnSaveAndExit = new JButton("Save and Exit");
		btnSaveAndExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				savecourses(course);
				frmCourseMenu.dispose();
			}
		});
		btnSaveAndExit.setBounds(105, 177, 189, 43);
		frmCourseMenu.getContentPane().add(btnSaveAndExit);
	}

}
