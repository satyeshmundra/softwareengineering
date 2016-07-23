import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Professional implements Serializable
{
	SimpleDateFormat ft = new SimpleDateFormat ("dd-MM-yyyy");

	String name;
	String mob;
	String email;
	String common;
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
    	 System.out.println("Common : (max 100 chars)");
    	 
	     common = scan.nextLine();
	     if(common.length() > 100)
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
		System.out.println("common :" + common);

	}
}
