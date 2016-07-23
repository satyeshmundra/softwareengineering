package course;

import java.io.Serializable;
import java.util.*;
/**
 * 
 * @Satyesh Mundra
 *  14CS10058 
 * 
 */
public class Faculty implements Serializable
{
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
    static transient Scanner scan = new Scanner(System.in);
    static transient Scanner scan2 = new Scanner(System.in);
    int feature_id; 
    String name;
    String address;
    String email;
    String mob;
    String dept;
    
    public Faculty()
    {
        name = address = email = mob = dept = "";
    }
    
    public void faculty_assign()
    {
        System.out.println("Enter details of the faculty :");
         System.out.println("Name:");
         name = scan.nextLine();
         System.out.println("address:");
         address = scan.nextLine();
         System.out.println("email:");
         email = scan.nextLine();
         System.out.println("mob no.:");
         mob = scan.nextLine();
         System.out.println("department:");
         dept = scan.nextLine();
        
    }
    
    public void display_name()
    {
        System.out.println(name);
    }
    
    public void display_details()
    {
    	System.out.println("Name : "+name);
    	System.out.println("Address : "+address);
    	System.out.println("email : "+email);
    	System.out.println("mob : "+mob);
    	System.out.println("dept : "+dept);
    }
    public void alter_faculty()
    {
    	while(true)
    	{
	    	System.out.println("Enter the id of the feature to be altered :  Press 6 to exit");
	    	System.out.println("1. Name : ");
	    	System.out.println("2. Address : ");
	    	System.out.println("3. email : ");
	    	System.out.println("4. mob : ");
	    	System.out.println("5. department : ");
	   		feature_id = get_int();
	    	if(feature_id ==1)
	    	{
	    		System.out.println("Enter new name " );
	    		name =scan.nextLine();
	    	}
	    	else if(feature_id ==2)
	    	{
	    		System.out.println("Enter new address " );
	    		address = scan.nextLine();
	    	}
	    	else if(feature_id ==3)
	    	{
	    		System.out.println("Enter new email " );
	    		email =scan.nextLine();
	    	}
	    	else if(feature_id ==4)
	    	{
	    		System.out.println("Enter new mob no. " );
	    		mob =scan.nextLine();
	    	}
	    	else if(feature_id ==5)
	    	{
	    		System.out.println("Enter new department " );
	    		dept =scan.nextLine();
	    	}
	    	else
	    		break;
    	}
    }
    
}
