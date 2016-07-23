package course;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class Main implements Serializable
{
	
	
	 static transient Scanner scan = new Scanner(System.in);
     static transient Scanner scan2 = new Scanner(System.in);
     static Date current_date = new Date();
     static int i , course_no;
     static int no_of_courses = 0 ,  no_of_instructors, no_of_participants ;
    
     public static int get_int()
     {
    	 String  temp = null;
    	 while(true)
    	 {
    		 try{
    			 temp = scan.nextLine();
    			 int temp2 = Integer.parseInt(temp);
    			 return temp2;
    		 }
    		 catch(Exception e)
    		 {
    			 System.out.println("Entry not valid");
    		 }
    	 }
     }
     
     public static void save(Course course[])
 	{
 	     try{
 	         FileOutputStream first =new FileOutputStream("Course file.ser");
 	         ObjectOutputStream second = new ObjectOutputStream(first);
 	         second.writeObject(no_of_courses);
 	         for(i =0 ; i< no_of_courses ; i++)
 	         {
 	        	second.writeObject(course[i]);
 	         }
 	         System.out.println("Changes saved successfully");
 	     }
 	     catch(Exception e){
 	         
 	         System.out.println("Error in saving: "+e);
 	     }
 	 }
 	
 	public static void read(Course course[])
 	{
 	     try{
 	         FileInputStream first =new FileInputStream("Course file.ser");
 	         ObjectInputStream second = new ObjectInputStream(first);
 	         no_of_courses = (int) second.readObject();
 	        for(i =0 ; i< no_of_courses ; i++)
	         {
	        	course[i] = (Course) second.readObject();
	         }
 	     }
 	     catch(Exception e){
 	         System.out.println("Error while Reading: "+e);
 	       
 	     }
 	 }
	 public static void create_courses(Course course[] )
	 {
		course[no_of_courses] = new Course();
        course[no_of_courses].course_assign();
       
        System.out.println("The faculty coordinator:");
        course[no_of_courses].initialize_coordinator().faculty_assign();
        
        System.out.println("Enter no of instructors (max 5):");
        no_of_instructors = get_int();
        
        for(i =0 ; i < no_of_instructors ; i++)
        {
            course[no_of_courses].initialize_instructor().faculty_assign();
            
        }
        
        System.out.println("Enter no of participants (max 5):");
        no_of_participants = get_int();
        
        for(i =0 ; i < no_of_participants ; i++)
        {

            course[no_of_courses].initialize_participant().participant_assign();
            
        }
           System.out.println("Course created");
           no_of_courses++;
             
	}
	public static void display_courses(Course course[] )
	{
		int i;
		System.out.println("The courses are : ");
        for(i =0 ; i < no_of_courses ; i++)
        {
            System.out.print((i+1) + ":  " );
            course[i].display_name();
        }
	}
    public static void main(String args[])
    {
    	System.out.println("current date = "+current_date);
        Course course[] = new Course[10];
        System.out.println("Enter 1 to begin from saved files or else will begin from new");
        int choice = get_int();
        
        if(choice == 1)
        	read(course);
        Calendar cal = Calendar.getInstance();
        while(true)
        {
        	
            System.out.println("Menu:");
            System.out.println("1. Create a course");
            System.out.println("2. Display the courses for 1 year");
            System.out.println("3. Display all the courses");
            System.out.println("4. Select a course");
            System.out.println("5. Delete a course");
            System.out.println("6. Save");
            System.out.println("7. Exit and Save");
            
            int ch = get_int();
            
            if(ch == 1 )
            {
            	create_courses(course);         
            }
            
            else if (ch == 2)
            {
            	int k = 1;
            	for(i=0 ; i<no_of_courses ; i++)
            	{
            		cal.setTime(course[i].date);
            		int year=cal.get(Calendar.YEAR);
            		
     			   	cal.setTime(current_date);
     			   	if(cal.get(Calendar.YEAR)==(year+1))
     			   	{
     			   		System.out.print(k + ". ");
     			   		course[i].display_name();
     			   		k++;
     			   	}
     		   }
            }
            
            else if(ch == 3)
            {
            	display_courses(course );
            }
            
            else if(ch == 4)
            {
            	display_courses(course );
                System.out.println("Enter course no.: ");
                course_no = get_int();
                course[course_no-1].course_menu();
                
            }
            else if(ch == 5)
            {
            	display_courses(course );
            	System.out.println("Enter course no.: ");
                course_no = get_int();
                course[course_no - 1] = null;
                for(i=course_no -1 ; i<no_of_courses -1 ; i++)
                {
                	course[i] = new Course();
                	course[i] = course[i+1];
                }
                no_of_courses--;
                course[i] = null;
            }
            else if (ch == 6)
            {
            	save(course);
                //break;
            }
            else
            {
            	save(course);
            	break;
            }
        }
    }
}
