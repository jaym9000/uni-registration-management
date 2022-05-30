import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
       	 ArrayList <Student> Array = new ArrayList<>();
	 ArrayList <Course> Catalog = new ArrayList<>();
  
	try
        {
            FileInputStream fis = new FileInputStream("Student");
            ObjectInputStream ois = new ObjectInputStream(fis);
           	 Array= (ArrayList) ois.readObject();
	   	 //Catalog = (ArrayList) ois.readObject(); 
            ois.close();
            fis.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            return;
        }
	
	try
        {
            FileInputStream is = new FileInputStream("Catalog");
            ObjectInputStream os = new ObjectInputStream(is);
	   	 Catalog = (ArrayList) os.readObject(); 
            os.close();
            is.close();
        } 
        catch (Exception ei) 
        {
            ei.printStackTrace();
            return;
        }
	
	
	
           
	boolean iv = false;
          
            System.out.print("Enter ID (4 digit unique code): ");
            String ID = scan.next();
            for (int i =0; i<Array.size() ; i++)
             {
                if (ID.equals(Array.get(i).getID()))
                 {
                    System.out.print("Enter Password: ");
                    String psswd = scan.next();
		    iv =true;
                    if(psswd.equals(Array.get(i).getPassword()))
                     {
                        System.out.println("Access Granted! Welcome " + Array.get(i).getName());
			System.out.println("Your email is: " + Array.get(i).getemail());
			System.out.println("Do you want to see the Course Catalog University offering this semester? Yes/No");
			String c = scan.next();
			if (c.equals("Yes"))
			   {
                              for (int y =0; y<Catalog.size(); y++) 
 	   	 		 {
          	     		   System.out.println(y+1 + "). " + Catalog.get(y).toString() + "\n");
	   		         }	
			   }
			System.out.println("Do you want to see the courses you are enrolled in: yes/no");
                	String choice = scan.next();
			  if (choice.equals("yes"))
			   {
                              Array.get(i).getCourseSchedule(Array.get(i).getCourselist());
			   }
			  Array.get(i).printBilling();

			System.out.println("Do you want to see the Calender: yes/no");
                	String choice1 = scan.next();
			  if (choice1.equals("yes"))
				{
  				    Array.get(i).getCalender();
				}
			System.out.println("Do you want to drop a course: yes/no");
                          String choice2 = scan.next();
			  if (choice2.equals("yes"))
				{
				 System.out.println("Enter the course code you want to drop: ");
                                 String code = scan.next();
				  //Course temp = Array[i].getCourseSchedule();
  				    Array.get(i).drop(code, Array.get(i).getCourselist());
				}
			             System.out.println("Do you want to add a course: yes/no");
                       		     String choice3 = scan.next();
						if (choice3.equals("yes"))
						  {
						     System.out.println("You can select any course from the catalog");
						     System.out.println("Do you want to see the course catalog again? yes/no");
						      String ch = scan.next();
							if (ch.equals("Yes"))
			   				{
                             					 for (int y =0; y<Catalog.size(); y++) 
 	   	 							 {
          	     		  					 System.out.println(y+1 + "). " + Catalog.get(y).toString() + "\n");
	   		         					}	
			   				}
						     System.out.println("Enter the course code you want to add: ");
                              			     String code = scan.next();
  						     Array.get(i).add(code, Array.get(i).getCourselist(), Catalog);
						   }
			break;
                     }
		    else
		     {
			System.out.println("Invalid Password");
		     }
             }
          }
            if(iv==false)
	    {
                System.out.println("Invalid ID!");
                System.out.println("If you want to create an account contact University Administration at XYZ@m.ca");
            }
		

	try
        {
            FileOutputStream s = new FileOutputStream("Student");
            ObjectOutputStream oo = new ObjectOutputStream(s);
            oo.writeObject(Array);
	    //oo.writeObject(Catalog);
            oo.close();
            s.close();
       } 
        catch (Exception io) 
        {
           io.printStackTrace();
        }
	
       
    }
}
