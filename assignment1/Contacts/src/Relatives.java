import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Relatives implements Serializable
{
	SimpleDateFormat ft = new SimpleDateFormat ("dd-MM-yyyy");

	String name;
	String mob;
	String email;
	Date bday; //date
	Date last_meet; //date
	static transient Scanner scan = new Scanner(System.in);
	public void getData()
	  {
		 System.out.println("Enter details of the relative :");
         System.out.println("Name:");
         name = scan.nextLine();
         System.out.println("mob no.:");
         mob = scan.nextLine();
         System.out.println("email:");
         email = scan.nextLine();
         while(true)
         {
    	         System.out.println("Enter birthday in dd-mm-yyyy:");
    	         String input = scan.nextLine();
    	         try { 
    	             bday = ft.parse(input);
    	             break;
    	             //System.out.println(); 
    	         } catch (ParseException e) { 
    	             System.out.println("Unparseable using " + ft); 
    	         }
    	         
         }
         while(true)
         {
    	         System.out.println("Enter date when last met in dd-mm-yyyy:");
    	         String input = scan.nextLine();
    	         try { 
    	             last_meet = ft.parse(input);
    	             break;
    	             //System.out.println(); 
    	         } catch (ParseException e) { 
    	             System.out.println("Unparseable using " + ft); 
    	         }
    	         
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
		System.out.println("birthday: " + bday);
		System.out.println("Last meeting date :" + last_meet);
	}
}
