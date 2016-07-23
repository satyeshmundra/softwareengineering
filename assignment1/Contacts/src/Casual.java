import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Casual implements Serializable
{
	SimpleDateFormat ft = new SimpleDateFormat ("dd-MM-yyyy");

	String name;
	String mob;
	String email;
	Date when; //date
	String where;
	String circumstances;
	String useful;
	
	static transient Scanner scan = new Scanner(System.in);
	public void getData()
	{
     System.out.println("Enter details of the personal acquaintance :");
     System.out.println("Name:");
     name = scan.nextLine();
     System.out.println("mob no.:");
     mob = scan.nextLine();
     System.out.println("email:");
     email = scan.nextLine();
     while(true)
     {
	         System.out.println("Enter date when met in dd-mm-yyyy:");
	         String input = scan.nextLine();
	         try { 
	             when = ft.parse(input);
	             break;
	             //System.out.println(); 
	         } catch (ParseException e) { 
	             System.out.println("Unparseable using " + ft); 
	         }
	         
     }
     System.out.println("Where met");
     where = scan.nextLine();
     while(true)
     {
    	 System.out.println("Circumstances : (max 100 chars)");
    	 circumstances = scan.nextLine();
    	 if(circumstances.length() > 100)
    	 {
    		 System.out.println("too lengthy");
    		 continue;
    	 }
    	 break; 
     }
     
     while(true)
     {
    	 System.out.println("Useful information : (max 100 chars)");
    	 
	     useful = scan.nextLine();
	     if(useful.length() > 100)
		 {
			 System.out.println("too lengthy");
			 continue;
		 }
	     break;
     }
	}
	public void display_name()
	{
		System.out.println(name);
	}
	
	public void display_info()
	{
		System.out.println("Name: " + name);
		System.out.println("mob no: " + mob);
		System.out.println("email :" + email);
		System.out.println("when: " + when);
		System.out.println("where :" + where);
		System.out.println("circumstances :" + circumstances);
		System.out.println("useful: " + useful);
		

	}
}
