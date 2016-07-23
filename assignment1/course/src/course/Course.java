package course;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 * 
 * @Satyesh Mundra
 *  14CS10058 
 * 
 */
public class Course implements Serializable
{
	SimpleDateFormat ft = new SimpleDateFormat ("dd-MM-yyyy");
	static transient Scanner scan = new Scanner(System.in);
	static transient Scanner scan2 = new Scanner(System.in);
    String test;
    int i, ch, feature_id , p_id , f_id , no_i , no_p;
    int no_of_instructors;
    int no_of_participants;
    String name;
    double fee;
    Date date;
    int duration;
    Faculty coordinator = new Faculty();
    Faculty instructors[] = new Faculty[5];
    Participant p[] = new Participant[5];
 

    public int get_int()
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
    public void course_assign()
    {
    
    	
    	
         System.out.println("Enter name of the course:");
         name = scan.nextLine();
      
        		 System.out.println("Enter the fee:");
        		 fee = get_int();
        
        while(true)
        {
	         System.out.println("Enter starting date of the course in dd-mm-yyyy:");
	         String input = scan.nextLine();
	         try { 
	             date = ft.parse(input);
	             break;
	             //System.out.println(); 
	         } catch (ParseException e) { 
	             System.out.println("Unparseable using " + ft); 
	         }
	         
        }
         while(true)
         {
        	 System.out.println("Enter duration of the course in days (max 14 days) :");
        	 duration = get_int();
        	 if(duration >14)
 			{
 				System.out.println("Enter valid duration < 14");
 				continue;
 			}
 			break;
 		}
    }

    public Faculty initialize_coordinator()
    {
        return coordinator;
    }
    
    public Faculty initialize_instructor()
    {
        instructors[no_of_instructors] = new Faculty();
        no_of_instructors++;
        return instructors[no_of_instructors - 1];
        
    }
    
    public Participant initialize_participant()
    {
        p[no_of_participants] = new Participant();
        no_of_participants++;
        return p[no_of_participants - 1];
        
    }
    public void display_details()
    {
    	System.out.println("1. Name : "+name);
    	System.out.println("2. Fee : "+fee);
    	System.out.println("3. Date : "+date);
    	System.out.println("4. Duration (days) : "+duration);
    	System.out.print("5. Coordinator : ");
    	coordinator.display_name();
    	System.out.println("6. No. of participants =  "+no_of_participants);
    	System.out.println("7. No. of instructors = "+no_of_instructors);
    	System.out.println("Participants : ");
    	for(i=0; i<no_of_participants; i++)
    	{
    		System.out.print((i+1)+" :");
    		p[i].display_name();
    	}
    	System.out.println("Instructors : ");
    	for(i=0; i<no_of_instructors; i++)
    	{
    		System.out.print((i+1)+" :");
    		instructors[i].display_name();
    	}
    	
    }
    
    public void display_name()
    {
        System.out.println(name);
    }
    
    public void alter_courses()
    {
    	while(true)
    	{
	    	System.out.println("Enter the id of the feature to be altered :  Press 6 to exit");
	    	System.out.println("1. Name : ");
	    	System.out.println("2. fee : ");
	    	System.out.println("3. date : ");
	    	System.out.println("4. duration : ");
	    	System.out.println("5. coordinator : ");
	    	feature_id = get_int();
	    	if(feature_id ==1)
	    	{
	    		System.out.println("Enter new name " );
	    		name =scan.nextLine();
	    	}
	    	else if(feature_id ==2)
	    	{
	    		System.out.println("Enter new fee " );
	    		fee = get_int();
	    	}
	    	else if(feature_id ==3)
	    	{
	    		while(true)
	            {
	    	         System.out.println("Enter starting date of the course in dd-mm-yyyy:");
	    	         String input = scan.nextLine();
	    	         try { 
	    	             date = ft.parse(input);
	    	             break;
	    	             //System.out.println(); 
	    	         } catch (ParseException e) { 
	    	             System.out.println("Unparseable using " + ft); 
	    	         }
	    	         
	            }
	    	}
	    	else if(feature_id ==4)
	    	{
	    		while(true)
	    		{
	    			System.out.println("Enter new duration " );
	    			duration =get_int();
	    			if(duration >14)
	    			{
	    				System.out.println("Enter valid duration < 14");
	    				continue;
	    			}
	    			break;
	    		}
	    	}
	    	else if(feature_id ==5)
	    	{
	    		coordinator.faculty_assign();
	    	}
	    	else 
	    		break;
	    }
    }
    
    
    
    
    public void course_menu()
    {
    	
    	
    	while(true)
    	{
	    	System.out.println("");
	    	System.out.println("Menu:");
	    	System.out.println("1. Display the details of the course");
	        System.out.println("2. Display the details of participants");
	        System.out.println("3. Display the details of instructors");
	        System.out.println("4. Alter the details of the courses");
	        System.out.println("5. Alter the details of participants");
	        System.out.println("6. Alter the details of the instructors");
	        System.out.println("7. Add participants");
	        System.out.println("8. Add instructors");
	        System.out.println("9. Delete participants");
	        System.out.println("10. Delete instructors");
	        System.out.println("11. Exit to previous menu");
	        ch = get_int();
	        
	        if(ch==1)
	        {
	        	display_details();
	        }
	        else if (ch == 2)
	        {
	        	for(i = 0; i<no_of_participants ; i++)
	        	{
	        		System.out.println("Participant "+ (i+1));
	        		p[i].display_details();
	        		System.out.println("");
	        	}
	        }
	        else if (ch == 3)
	        {
	        	System.out.println("Coordinator" );
	        	coordinator.display_details();
	        	
	        	for(i = 0; i<no_of_instructors ; i++)
	        	{
	        		System.out.println("Instructor "+ (i+1));
	        		instructors[i].display_details();
	        		System.out.println("");
	        	}
	        }
	        
	        else if (ch == 4)
	        {
	        	alter_courses();
	        	
	        }
	        
	        else if (ch == 5)
	        {
	        	for(i = 0; i<no_of_participants ; i++)
	        	{
	        		System.out.println("Participant "+ (i+1));
	        		p[i].display_name();
	        		System.out.println("");
	        	}
	        	
	        	System.out.println("Enter the id of the participant ");
	        	p_id = get_int();
	        	p[p_id - 1].alter_participants();
	        	
	        }
	        else if (ch == 6)
	        {
	        	for(i = 0; i<no_of_instructors ; i++)
	        	{
	        		System.out.println("Instructors "+ (i+1));
	        		instructors[i].display_name();
	        		System.out.println("");
	        	}
	        	
	        	System.out.println("Enter the id of the instructor ");
	        	f_id = get_int();
	        	instructors[f_id - 1].alter_faculty();
	        	
	        }
	        
	        else if(ch == 7)
	        {
	        	System.out.println("Enter no of participants (max " + (5 - no_of_participants) +" ):");
	            no_p = get_int();
	            
	            for(i =0 ; i < no_p ; i++)
	            {
	                initialize_participant().participant_assign();   
	            }
	        }
	        
	        else if(ch ==8)
	        {
	        	System.out.println("Enter no of instructors (max " + (5 - no_of_instructors) +" ):");
	            no_i = get_int();
	            
	            for(i =0 ; i < no_i ; i++)
	            {
	                initialize_instructor().faculty_assign();   
	            }
	        }
	        
	        else if(ch == 9)
	        {
	        	for(i = 0; i<no_of_participants ; i++)
	        	{
	        		System.out.println("Participant "+ (i+1));
	        		p[i].display_name();
	        		System.out.println("");
	        	}
	        	System.out.println("Enter the id of the participant to be deleted ");
	        	p_id = get_int();
	        	if(p[p_id] != null)
	        	{
		        	p[p_id -1] = null;
		        	for(i = p_id -1 ; i<no_of_participants -1 ; i++)
		        	{
		        		p[i] = new Participant();
		        		p[i] = p[i+1];
		        	}
		        	p[i] = null;
		        	no_of_participants-- ;
	        	}
	        	
	        }
	        else if(ch == 10)
	        {
	        	for(i = 0; i<no_of_instructors ; i++)
	        	{
	        		System.out.println("Instructors "+ (i+1));
	        		instructors[i].display_name();
	        		System.out.println("");
	        	}
	        	System.out.println("Enter the id of the instructor to be deleted ");
	        	f_id = get_int();
	        	if(instructors[f_id-1] != null)
	        	{
	        		instructors[f_id -1] = null;
	        		for(i = f_id -1 ; i<no_of_instructors -1 ; i++)
	        		{
	        			instructors[i] = new Faculty();
	        			instructors[i] = instructors[i+1];
	        		}
	        		instructors[i] = null;
	        		no_of_instructors-- ;
	        	}
	        }
	        else
	        	break;
	        
    	}        
        
        
    }
    
}

