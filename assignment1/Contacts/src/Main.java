import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;



public class Main implements Serializable
{
	static int i ,id , ch , type , no_of_relatives = 0 , no_of_personal = 0 , no_of_professional = 0 , no_of_casual = 0 ;
	static transient Scanner scan = new Scanner(System.in);
	
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
	
	
	public static void saverelatives(Relatives rel[]){
	     try{
	         FileOutputStream first =new FileOutputStream("Relatives.ser");
	         ObjectOutputStream second = new ObjectOutputStream(first);
	         second.writeObject(no_of_relatives);
 	         for(i =0 ; i< no_of_relatives ; i++)
 	         {
 	        	second.writeObject(rel[i]);
 	         }
 	         System.out.println("Changes saved successfully");

 	         }
	     catch(Exception e){
	         
	         System.out.println("Error in saving: "+e);
	     }
	 }
	
	public static void readrelatives(Relatives rel[]){
	     try{
	         FileInputStream first =new FileInputStream("Relatives.ser");
	         ObjectInputStream second = new ObjectInputStream(first);
	         no_of_relatives = (int) second.readObject();
	 	        for(i =0 ; i< no_of_relatives ; i++)
		         {
		        	rel[i] = (Relatives) second.readObject();
		         }
	     }
	     catch(Exception e){
	         System.out.println("Error while Reading: "+e);
	         
	     }
	 }
	
	public static void savepersonal(Personal person[]){
	     try{
	         FileOutputStream first =new FileOutputStream("Personal.ser");
	         ObjectOutputStream second = new ObjectOutputStream(first);
	         second.writeObject(no_of_personal);
	         for(i =0 ; i< no_of_personal ; i++)
	         {
	        	second.writeObject(person[i]);
	         }
 	         System.out.println("Changes saved successfully");

	         }
	     catch(Exception e){
	         
	         System.out.println("Error in saving: "+e);
	     }
	 }
	
	public static void readpersonal(Personal person[]){
	     try{
	         FileInputStream first =new FileInputStream("Personal.ser");
	         ObjectInputStream second = new ObjectInputStream(first);
	         no_of_personal = (int) second.readObject();
	 	        for(i =0 ; i< no_of_personal ; i++)
		         {
		        	person[i] = (Personal) second.readObject();
		         }
	 	         
	     }
	     catch(Exception e){
	         System.out.println("Error while Reading: "+e);
	         
	     }
	 }
	
	public static void saveprofessional(Professional prof[]){
	     try{
	         FileOutputStream first =new FileOutputStream("Professional.ser");
	         ObjectOutputStream second = new ObjectOutputStream(first);
	         second.writeObject(no_of_professional);
	         for(i =0 ; i< no_of_professional ; i++)
	         {
	        	second.writeObject(prof[i]);
	         }
 	         System.out.println("Changes saved successfully");

	         }
	     catch(Exception e){
	         
	         System.out.println("Error in saving: "+e);
	     }
	 }
	
	public static void readprofessional(Professional prof[]){
	     try{
	         FileInputStream first =new FileInputStream("Professional.ser");
	         ObjectInputStream second = new ObjectInputStream(first);
	         no_of_professional = (int) second.readObject();
	 	        for(i =0 ; i< no_of_professional ; i++)
		         {
		        	prof[i] = (Professional) second.readObject();
		         }
	     }
	     catch(Exception e){
	         System.out.println("Error while Reading: "+e);
	         
	     }
	 }
	
	public static void savecasual(Casual casual[]){
	     try{
	         FileOutputStream first =new FileOutputStream("Casual.ser");
	         ObjectOutputStream second = new ObjectOutputStream(first);
	         second.writeObject(no_of_casual);
	         for(i =0 ; i< no_of_casual ; i++)
	         {
	        	second.writeObject(casual[i]);
	         }
 	         System.out.println("Changes saved successfully");

	         }
	     catch(Exception e){
	         
	         System.out.println("Error in saving: "+e);
	     }
	 }
	
	public static void readcasual(Casual casual[]){
	     try{
	         FileInputStream first =new FileInputStream("Casual.ser");
	         ObjectInputStream second = new ObjectInputStream(first);
	         no_of_casual = (int) second.readObject();
	 	        for(i =0 ; i< no_of_casual ; i++)
		         {
		        	casual[i] = (Casual) second.readObject();
		         }
	     }
	     catch(Exception e){
	         System.out.println("Error while Reading: "+e);
	         
	     }
	 }
	public static void display_types()
	{
		System.out.println("1. Relatives :");
		System.out.println("2. Personal :");
		System.out.println("3. Professional :");
		System.out.println("4. Casual :");
		
	}
	public static void main(String args[])
	{ 
		Relatives rel[] = new Relatives[50];
		Personal person[] = new Personal[50];
		Casual casual[] = new Casual[50];
		Professional prof[] = new Professional[50];
		System.out.println("Enter 1 to continue from saved files or it will start from new");
		int temp_ch = get_int();
		if(temp_ch == 1)
		{
			readrelatives(rel);
			readprofessional(prof);
			readpersonal(person);
			readcasual(casual);
		}
		while(true)
		{
			System.out.println("Menu :");
			System.out.println("1. Create acquaintances :");
			System.out.println("2. Display all acquaintances :");
			System.out.println("3. Display specific acquaintances :");
			System.out.println("4. Delete an acquaintance :");
			System.out.println("5. Delete a type of acquaintances (entire) :");
			System.out.println("6. Search for an acquaintance :");
			System.out.println("7. Save: ");
			System.out.println("8. Exit and Save in files:");
			
			ch = get_int();
			if(ch == 1)
			{
				System.out.println("Choose the type of acquaintance");
				display_types();
				type = get_int();
				if(type ==1 )
				{
					rel[no_of_relatives] = new Relatives();
					rel[no_of_relatives].getData();
					no_of_relatives++;
				}
				else if(type ==2 )
				{
					person[no_of_personal] = new Personal();
					person[no_of_personal].getData();
					no_of_personal++;
				}
				else if(type ==3 )
				{
					prof[no_of_professional] = new Professional();
					prof[no_of_professional].getData();
					no_of_professional++;
				}
				else if(type ==4 )
				{
					casual[no_of_casual] = new Casual();
					casual[no_of_casual].getData();
					no_of_casual++;
				}
				System.out.println("Acquaintance created ");
			}
			
			else if(ch == 2)
			{
				System.out.println("Relatives :");
				for(i=0 ; i<no_of_relatives ; i++)
				{
					System.out.print((i+1) + ". ");
					rel[i].display_name();
				}
				System.out.println("Personal :");
				for(i=0 ; i<no_of_personal ; i++)
				{
					System.out.print((i+1) + ". ");
					person[i].display_name();
				}
				System.out.println("Professional :");
				for(i=0 ; i<no_of_professional ; i++)
				{
					System.out.print((i+1) + ". ");
					prof[i].display_name();
				}
				System.out.println("Casual :");
				for(i=0 ; i<no_of_casual ; i++)
				{
					System.out.print((i+1) + ". ");
					casual[i].display_name();
				}
			}
			
			else if(ch == 3)
			{
				System.out.println("Choose the type of acquaintance");
				display_types();
				type = get_int();
				if(type == 1)
				{
					System.out.println("Relatives :");
					for(i=0 ; i<no_of_relatives ; i++)
					{
						System.out.print((i+1) + ". ");
					    rel[i].display_name();
					}
				}
				else if (type == 2)
				{
					System.out.println("Personal :");
					for(i=0 ; i<no_of_personal ; i++)
					{
						System.out.print((i+1)+ ". ");
						person[i].display_name();
					}
				}
				else if (type == 3)
				{
					System.out.println("Professional :");
					for(i=0 ; i<no_of_professional ; i++)
					{
						System.out.print((i+1) + ". ");
						prof[i].display_name();
					}
				}
				else if(type == 4)
				{
					System.out.println("Casual :");
					for(i=0 ; i<no_of_casual ; i++)
					{
						System.out.print((i+1) + ". ");
						casual[i].display_name();
					}
				}
			}
			
			else if(ch == 4 )
			{
				System.out.println("Choose the type of acquaintance");
				display_types();
				type = get_int();
				if(type == 1)
				{
					System.out.println("Select the id from Relatives :");
					for(i=0 ; i<no_of_relatives ; i++)
					{
						System.out.print((i+1) + ". ");
						rel[i].display_name();
					}
					id = get_int();
					rel[id -1] = null;
					for(i = id-1 ; i< no_of_relatives -1 ; i++)
					{
						rel[i] = rel[i+1];
					}
					rel[i] = null;
					no_of_relatives -- ;
				}
				else if (type == 2)
				{
					System.out.println("Select id of the  Personal acquaintance:");
					for(i=0 ; i<no_of_personal ; i++)
					{
						System.out.print((i+1) + ". ");
						person[i].display_name();
					}
					id = get_int();
					person[id -1] = null;
					for(i = id-1 ; i< no_of_personal -1 ; i++)
					{
						person[i] = person[i+1];
					}
					person[i] = null;
					no_of_personal --; 
				}
				else if (type == 3)
				{
					System.out.println("Select id of the  professional acquaintance:");
					for(i=0 ; i<no_of_professional ; i++)
					{
						System.out.print((i+1) + ". ");
						prof[i].display_name();
					}
					id = get_int();
					prof[id -1] = null;
					for(i = id-1 ; i< no_of_professional -1 ; i++)
					{
						prof[i] = prof[i+1];
					}
					prof[i] = null;
					no_of_professional --; 
				}
				else if(type == 4)
				{
					System.out.println("Select id of the  casual acquaintance:");
					for(i=0 ; i<no_of_casual ; i++)
					{
						System.out.print((i+1) + ". ");
						casual[i].display_name();
					}
					id = get_int();
					casual[id -1] = null;
					for(i = id-1 ; i< no_of_casual -1 ; i++)
					{
						casual[i] = casual[i+1];
					}
					casual[i] = null;
					no_of_casual --;
				}
			}
			else if (ch ==5) 
			{
				System.out.println("Choose the type of acquaintance");
				display_types();
				type = get_int();
				if(type == 1)
				{
					System.out.println("Deleting all Relatives :");
					for(i=0 ; i<no_of_relatives ; i++)
					{
						rel[i] = null;
					}
					no_of_relatives = 0;
				}
				else if (type == 2)
				{
					System.out.println("Deleting Personal :");
					for(i=0 ; i<no_of_personal ; i++)
					{
						person[i] = null;
					}
					no_of_personal = 0; 
				}
				else if (type == 3)
				{
					System.out.println("Deleting Professional :");
					for(i=0 ; i<no_of_professional ; i++)
					{
						prof[i] = null;
					}
					no_of_professional = 0;
				}
				else if(type == 4)
				{
					System.out.println("Deleting Casual :");
					for(i=0 ; i<no_of_casual ; i++)
					{
						casual[i] = null;
					}
					no_of_casual = 0;
				}
			}
			else if (ch == 6)
			{
				System.out.println("Enter the name of the acquaintance to be searched");
				String sc = scan.nextLine();
				int flag = 0;
					for(i=0 ; i<no_of_relatives ; i++)
					{
						if(sc.compareTo(rel[i].name) == 0)
						{
							System.out.println("Search found in Relatives");
							rel[i].display_info();
							flag = 1;
							break;
						}
					}
				
				
					for(i=0 ; i<no_of_personal ; i++)
					{
						if(sc.compareTo(person[i].name) == 0)
						{
							System.out.println("Search found in Personal");
							person[i].display_info();
							flag = 1;
							break;
						}
					}
				
				
					for(i=0 ; i<no_of_professional ; i++)
					{
						if(sc.compareTo(prof[i].name) == 0)
						{
							System.out.println("Search found in Professionals");
							prof[i].display_info();
							flag = 1;
							break;
						}
					}
				
				
				
					for(i=0 ; i<no_of_casual ; i++)
					{
						if(sc.compareTo(casual[i].name) == 0)
						{
							System.out.println("Search found in Casual");
							casual[i].display_info();
							flag = 1;
							break;
						}
					}
				
				if(flag == 0)
				{
					System.out.println("Search not found ");
				}
				
			}
			else if(ch == 7)
			{
				saverelatives(rel);
				savepersonal(person);
				saveprofessional(prof);
				savecasual(casual);
			}
			else 
			{
				saverelatives(rel);
				savepersonal(person);
				saveprofessional(prof);
				savecasual(casual);
				break;
			}
			
		}
		
		
		
	}
}