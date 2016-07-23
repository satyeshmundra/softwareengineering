import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

public class Contacts implements Serializable {

	JFrame frmMenu;
	private JFrame frmTypes, frmDisplay;
	private JFrame frmSearch;
	private JTextField textField;
	private JButton btnBack;
	private JLabel lblNewLabel;
	private JList list;
	
	private ArrayList<Relatives> rel = new ArrayList<Relatives>();
	private ArrayList<Personal> person = new ArrayList<Personal>();
	private ArrayList<Professional> prof = new ArrayList<Professional>();
	private ArrayList<Casual> cas = new ArrayList<Casual>();
	
	
	private String del;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Contacts window = new Contacts();
					window.frmMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Contacts() {
		//displayTypesDisplay();
		initialize();
	}

	public void saverelatives(ArrayList<Relatives> rel){
	     try{
	         FileOutputStream first =new FileOutputStream("Relatives.ser");
	         ObjectOutputStream second = new ObjectOutputStream(first);
	         second.writeObject(rel);
	         
	        // System.out.println("Changes saved successfully");

	         }
	     catch(Exception e){
	         
	         JOptionPane.showMessageDialog(frmMenu, "Error in Saving");
	     }
	 }
	
	public  void readrelatives(){
	     try{
	         FileInputStream first =new FileInputStream("Relatives.ser");
	         ObjectInputStream second = new ObjectInputStream(first);
	         rel = (ArrayList<Relatives>) second.readObject();
	 	       
	     }
	     catch(Exception e){
	    	 JOptionPane.showMessageDialog(frmMenu, "Error in Reading");
	         
	     }
	 }
	
	public void savepersonal(ArrayList<Personal> person){
	     try{
	         FileOutputStream first =new FileOutputStream("Personal.ser");
	         ObjectOutputStream second = new ObjectOutputStream(first);
	         second.writeObject(person);
	         
	        // System.out.println("Changes saved successfully");

	         }
	     catch(Exception e){
	         
	         JOptionPane.showMessageDialog(frmMenu, "Error in Saving");
	     }
	 }
	
	public  void readpersonal(){
	     try{
	         FileInputStream first =new FileInputStream("Personal.ser");
	         ObjectInputStream second = new ObjectInputStream(first);
	         person = (ArrayList<Personal>) second.readObject();
	 	       
	     }
	     catch(Exception e){
	    	 JOptionPane.showMessageDialog(frmMenu, "Error in Reading");
	         
	     }
	 }
	
	
	public void saveprofessional(ArrayList<Professional> prof){
	     try{
	         FileOutputStream first =new FileOutputStream("Professional.ser");
	         ObjectOutputStream second = new ObjectOutputStream(first);
	         second.writeObject(person);
	         
	        // System.out.println("Changes saved successfully");

	         }
	     catch(Exception e){
	         
	         JOptionPane.showMessageDialog(frmMenu, "Error in Saving");
	     }
	 }
	
	public  void readprofessional(){
	     try{
	         FileInputStream first =new FileInputStream("Professional.ser");
	         ObjectInputStream second = new ObjectInputStream(first);
	         prof = (ArrayList<Professional>) second.readObject();
	 	       
	     }
	     catch(Exception e){
	    	 JOptionPane.showMessageDialog(frmMenu, "Error in Reading");
	         
	     }
	 }
	
	public void savecasual(ArrayList<Casual> cas){
	     try{
	         FileOutputStream first =new FileOutputStream("Casual.ser");
	         ObjectOutputStream second = new ObjectOutputStream(first);
	         second.writeObject(cas);
	         
	        // System.out.println("Changes saved successfully");

	         }
	     catch(Exception e){
	         
	         JOptionPane.showMessageDialog(frmMenu, "Error in Saving");
	     }
	 }
	
	public  void readcasual(){
	     try{
	         FileInputStream first =new FileInputStream("Casual.ser");
	         ObjectInputStream second = new ObjectInputStream(first);
	         cas = (ArrayList<Casual>) second.readObject();
	 	       
	     }
	     catch(Exception e){
	    	 JOptionPane.showMessageDialog(frmMenu, "Error in Reading");
	         
	     }
	 }
	/**
	 * Initialize the contents of the frame.
	 */
	
	public void SearchMenu()
	{
		frmSearch = new JFrame();
		frmSearch.setVisible(true);
		frmSearch.setTitle("Search");
		frmSearch.setBounds(100, 100, 450, 300);
		frmSearch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSearch.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(65, 76, 202, 20);
		frmSearch.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String search = textField.getText();
				int flag = Search(search);
				textField.setText("");
				
				if(flag == 0)
				{
					lblNewLabel.setText("Search Not Found");
				}
				
			}
		});
		btnSearch.setBounds(290, 75, 89, 23);
		frmSearch.getContentPane().add(btnSearch);
		
		JLabel lblEnterName = new JLabel("Enter Name");
		lblEnterName.setBounds(65, 57, 123, 14);
		frmSearch.getContentPane().add(lblEnterName);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frmSearch.dispose();
			}
		});
		btnBack.setBounds(290, 158, 89, 50);
		frmSearch.getContentPane().add(btnBack);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(65, 144, 202, 64);
		frmSearch.getContentPane().add(lblNewLabel);
	}
	
	
	public void Delete(String sc)
	{
		int flag = 0;
		for(int i=0 ; i<rel.size() ; i++)
		{
			if(sc.compareTo(rel.get(i).getName()) == 0)
			{
				//System.out.println("Search found in Relatives");
				rel.remove(i);
				flag = 1;
				break;
			}
		}
	
	if(flag == 0)
	{
		for(int i=0 ; i<person.size() ; i++)
		{
			if(sc.compareTo(person.get(i).getName()) == 0)
			{
				//System.out.println("Search found in Relatives");
				person.remove(i);
				flag = 1;
				break;
			}
		}
	
	}
	if (flag == 0)
	{
		for(int i=0 ; i<prof.size() ; i++)
		{
			if(sc.compareTo(prof.get(i).getName()) == 0)
			{
				//System.out.println("Search found in Relatives");
				prof.remove(i);
				flag = 1;
				break;
			}
		}
	
	}
	if (flag == 0)
	{
		for(int i=0 ; i<cas.size() ; i++)
		{
			if(sc.compareTo(cas.get(i).getName()) == 0)
			{
				//System.out.println("Search found in Relatives");
				cas.remove(i);
				flag = 1;
				break;
			}
		}
	}
	}
	public int Search(String sc)
	{
		int flag = 0;
		for(int i=0 ; i<rel.size() ; i++)
		{
			if(sc.compareTo(rel.get(i).getName()) == 0)
			{
				//System.out.println("Search found in Relatives");
				rel.get(i).display_details();
				flag = 1;
				break;
			}
		}
	
	
		for(int i=0 ; i<person.size() ; i++)
		{
			if(sc.compareTo(person.get(i).getName()) == 0)
			{
				//System.out.println("Search found in Relatives");
				person.get(i).display_details();
				flag = 1;
				break;
			}
		}
	
	
		for(int i=0 ; i<prof.size() ; i++)
		{
			if(sc.compareTo(prof.get(i).getName()) == 0)
			{
				//System.out.println("Search found in Relatives");
				prof.get(i).display_details();
				flag = 1;
				break;
			}
		}
	
	
		for(int i=0 ; i<cas.size() ; i++)
		{
			if(sc.compareTo(cas.get(i).getName()) == 0)
			{
				//System.out.println("Search found in Relatives");
				cas.get(i).display_details();
				flag = 1;
				break;
			}
		}
	
	return flag;
	}
	public void displayTypes()
	{
		frmTypes = new JFrame();
		frmTypes.setTitle("Types");
		frmTypes.setVisible(true);
		frmTypes.setBounds(100, 100, 450, 300);
		frmTypes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTypes.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("1. Relatives");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatives r = new Relatives();
				r.enter_details();
				rel.add(r);
				frmTypes.dispose();
			}
		});
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setBounds(45, 39, 287, 23);
		frmTypes.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("2. Personal");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Personal per = new Personal();
				per.enter_details();
				person.add(per);
				frmTypes.dispose();
			}
		});
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.setBounds(45, 88, 287, 23);
		frmTypes.getContentPane().add(btnNewButton_1);
		
		JButton btnProfessional = new JButton("3. Professional");
		btnProfessional.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
				Professional pro = new Professional();
				pro.enter_details();
				prof.add(pro);
				frmTypes.dispose();
			}
		});
		btnProfessional.setHorizontalAlignment(SwingConstants.LEFT);
		btnProfessional.setBounds(45, 132, 287, 23);
		frmTypes.getContentPane().add(btnProfessional);
		
		JButton btnNewButton_2 = new JButton("4. Casual");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Casual c = new Casual();
				c.enter_details();
				cas.add(c);
				frmTypes.dispose();
			}
		});
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_2.setBounds(45, 181, 287, 23);
		frmTypes.getContentPane().add(btnNewButton_2);
		
	}
	
	public void displayTypesDisplay()
	{
		frmDisplay = new JFrame();
		frmDisplay.setVisible(true);
		frmDisplay.setTitle("Display");
		frmDisplay.setBounds(100, 100, 450, 374);
		frmDisplay.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmDisplay.getContentPane().setLayout(null);
		
		list = new JList();
		list.setBounds(25, 86, 256, 164);
		frmDisplay.getContentPane().add(list);
		//frmDisplay.getContentPane().add(new JScrollPane(list));
		
		
		JLabel lblNames = new JLabel("Names (Click to know details)");
		lblNames.setBounds(25, 61, 191, 14);
		frmDisplay.getContentPane().add(lblNames);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frmDisplay.dispose();
			}
		});
		btnBack.setBounds(315, 131, 89, 23);
		frmDisplay.getContentPane().add(btnBack);
		
		JButton btnRelatives = new JButton("Relatives");
		btnRelatives.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DefaultListModel DLM = new DefaultListModel();
				for(int i=0 ; i<rel.size(); i++)
				{
					DLM.addElement(rel.get(i).getName());
				}
				list.setModel(DLM);
				
				/*list.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
					
					@Override
					public void valueChanged(ListSelectionEvent arg0) {
						String search = (String) list.getSelectedValue();
						int flag = Search(search);
						
						
						// TODO Auto-generated method stub
						
					}
				});*/
			}
		});
		btnRelatives.setBounds(25, 22, 89, 23);
		frmDisplay.getContentPane().add(btnRelatives);
		
		JButton btnPersonal = new JButton("Personal");
		btnPersonal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DefaultListModel DLM = new DefaultListModel();
				for(int i=0 ; i<person.size(); i++)
				{
					DLM.addElement(person.get(i).getName());
				}
				list.setModel(DLM);
				/*list.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
					
					@Override
					public void valueChanged(ListSelectionEvent arg0) {
						
						String search = (String) list.getSelectedValue();
						int s = Search(search);
						// TODO Auto-generated method stub
						
					}
				});*/
			}
		});
		btnPersonal.setBounds(124, 22, 89, 23);
		frmDisplay.getContentPane().add(btnPersonal);
		
		JButton btnProfessional = new JButton("Professional");
		btnProfessional.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DefaultListModel DLM = new DefaultListModel();
				for(int i=0 ; i<prof.size(); i++)
				{
					DLM.addElement(prof.get(i).getName());
				}
				list.setModel(DLM);
				/*list.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
					
					@Override
					public void valueChanged(ListSelectionEvent arg0) {
						
						String search = (String) list.getSelectedValue();
						int s = Search(search);

						// TODO Auto-generated method stub
						
					}
				});*/
			}
		});
		btnProfessional.setBounds(223, 22, 96, 23);
		frmDisplay.getContentPane().add(btnProfessional);
		
		JButton btnCasual = new JButton("Casual");
		btnCasual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultListModel DLM = new DefaultListModel();
				for(int i=0 ; i<cas.size(); i++)
				{
					DLM.addElement(cas.get(i).getName());
				}
				list.setModel(DLM);
				/*list.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
					
					@Override
					public void valueChanged(ListSelectionEvent arg0) {
						
						String search = (String) list.getSelectedValue();
						int s = Search(search);

						// TODO Auto-generated method stub
						
					}
				});*/
			}
		});
		btnCasual.setBounds(329, 22, 89, 23);
		frmDisplay.getContentPane().add(btnCasual);
		
		JButton btnShowAll = new JButton("Show all");
		btnShowAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DefaultListModel DLM = new DefaultListModel();
				for(int i=0 ; i<rel.size(); i++)
				{
					DLM.addElement(rel.get(i).getName());
				}
				for(int i=0 ; i<person.size(); i++)
				{
					DLM.addElement(person.get(i).getName());
				}
				for(int i=0 ; i<prof.size(); i++)
				{
					DLM.addElement(prof.get(i).getName());
				}
				for(int i=0 ; i<cas.size(); i++)
				{
					DLM.addElement(cas.get(i).getName());
				}
				list.setModel(DLM);
				/*list.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
					
					@Override
					public void valueChanged(ListSelectionEvent arg0) {
						
						String search = (String) list.getSelectedValue();
						int s = Search(search);

						// TODO Auto-generated method stub
						
					}
				}); */
			}
		});
		btnShowAll.setBounds(329, 52, 89, 23);
		frmDisplay.getContentPane().add(btnShowAll);
		
		JButton btnViewSelectedAcquaintance = new JButton("View Selected Acquaintance");
		btnViewSelectedAcquaintance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(list.getSelectedIndex() < 0)
					JOptionPane.showMessageDialog(frmDisplay, "Select an acquaintance");
				
				else
				{
				String search = (String) list.getSelectedValue();
				int s = Search(search);
				}
			}
		});
		btnViewSelectedAcquaintance.setBounds(25, 277, 256, 23);
		frmDisplay.getContentPane().add(btnViewSelectedAcquaintance);
	}
	
	
	public void displayTypesdelete()
	{
		
		frmDisplay = new JFrame();
		frmDisplay.setVisible(true);
		frmDisplay.setTitle("Display");
		frmDisplay.setBounds(100, 100, 450, 300);
		frmDisplay.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmDisplay.getContentPane().setLayout(null);
		
		JList list = new JList();
		list.setBounds(25, 86, 256, 164);
		frmDisplay.getContentPane().add(list);
		
		JLabel lblNames = new JLabel("Names (Click to select)");
		lblNames.setBounds(25, 61, 191, 14);
		frmDisplay.getContentPane().add(lblNames);
		
		JButton btnBack = new JButton("Delete");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(list.getSelectedIndex() < 0)
					JOptionPane.showMessageDialog(frmDisplay, "Select an acquaintance");
				else
				{
				del = (String) list.getSelectedValue();
				Delete(del);
				frmDisplay.dispose();
			
				}
			}
		});
		btnBack.setBounds(315, 131, 89, 23);
		frmDisplay.getContentPane().add(btnBack);
		
		JButton btnRelatives = new JButton("Relatives");
		btnRelatives.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DefaultListModel DLM = new DefaultListModel();
				for(int i=0 ; i<rel.size(); i++)
				{
					DLM.addElement(rel.get(i).getName());
				}
				list.setModel(DLM);
				/*list.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
					
					@Override
					public void valueChanged(ListSelectionEvent arg0) {
						
						del = (String) list.getSelectedValue();
						//Delete(del);
						// TODO Auto-generated method stub
						
					}
				});*/
				
			}
		});
		btnRelatives.setBounds(25, 22, 89, 23);
		frmDisplay.getContentPane().add(btnRelatives);
		
		JButton btnPersonal = new JButton("Personal");
		btnPersonal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DefaultListModel DLM = new DefaultListModel();
				for(int i=0 ; i<person.size(); i++)
				{
					DLM.addElement(person.get(i).getName());
				}
				list.setModel(DLM);
			/*	list.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
					
					@Override
					public void valueChanged(ListSelectionEvent arg0) {
						
						del = (String) list.getSelectedValue();
						//Delete(del);
						// TODO Auto-generated method stub
						
					}
				});*/
			}
		});
		btnPersonal.setBounds(124, 22, 89, 23);
		frmDisplay.getContentPane().add(btnPersonal);
		
		JButton btnProfessional = new JButton("Professional");
		btnProfessional.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DefaultListModel DLM = new DefaultListModel();
				for(int i=0 ; i<prof.size(); i++)
				{
					DLM.addElement(prof.get(i).getName());
				}
				list.setModel(DLM);
			/*	list.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
					
					@Override
					public void valueChanged(ListSelectionEvent arg0) {
						
						del = (String) list.getSelectedValue();
						//Delete(del);

						// TODO Auto-generated method stub
						
					}
				});*/
			}
		});
		btnProfessional.setBounds(223, 22, 96, 23);
		frmDisplay.getContentPane().add(btnProfessional);
		
		JButton btnCasual = new JButton("Casual");
		btnCasual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultListModel DLM = new DefaultListModel();
				for(int i=0 ; i<cas.size(); i++)
				{
					DLM.addElement(cas.get(i).getName());
				}
				list.setModel(DLM);
			/*	list.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
					
					@Override
					public void valueChanged(ListSelectionEvent arg0) {
						
						del = (String) list.getSelectedValue();
						//Delete(del);

						// TODO Auto-generated method stub
						
					}
				});*/
			}
		});
		btnCasual.setBounds(329, 22, 89, 23);
		frmDisplay.getContentPane().add(btnCasual);
		
		
	}
	
	private void initialize() {
		
		readrelatives();
		readprofessional();
		readpersonal();
		readcasual();
		
		
		frmMenu = new JFrame();
		frmMenu.setTitle("MENU");
		frmMenu.setBounds(100, 100, 490, 317);
		frmMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMenu.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("1. Create New Contact");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Types obj = new Types();
				
			displayTypes();
				//Relatives a = new Relatives();
			
			}
		});
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setBounds(33, 34, 322, 23);
		frmMenu.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("2. Display Acquaintances");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				displayTypesDisplay();
			}
		});
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_2.setBounds(33, 81, 322, 23);
		frmMenu.getContentPane().add(btnNewButton_2);
		
		JButton btnSearchFor = new JButton("3. Search for a given acquaintance");
		btnSearchFor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				SearchMenu();
			}
		});
		btnSearchFor.setHorizontalAlignment(SwingConstants.LEFT);
		btnSearchFor.setBounds(33, 128, 322, 23);
		frmMenu.getContentPane().add(btnSearchFor);
		
		JButton btnNewButton_3 = new JButton("4. Delete an Acquaintance");
		btnNewButton_3.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				displayTypesdelete();
			}
		});
		btnNewButton_3.setBounds(33, 173, 322, 23);
		frmMenu.getContentPane().add(btnNewButton_3);
		
		JButton btnSaveAndExit = new JButton("Save And Exit");
		btnSaveAndExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				saverelatives(rel);
				savepersonal(person);
				saveprofessional(prof);
				savecasual(cas);
				
				frmMenu.dispose();
				
			}
		});
		btnSaveAndExit.setBounds(33, 220, 322, 23);
		frmMenu.getContentPane().add(btnSaveAndExit);
	}
}
