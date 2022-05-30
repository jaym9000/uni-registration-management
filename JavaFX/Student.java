import java.util.*;
import java.io.*;
import java.util.Arrays;

public class Student implements Serializable{
   private String name;
	private String email;
	private String id;
	private String password;
   
	ArrayList<Course> course = new ArrayList<>();
   transient Scanner scan =new Scanner(System.in);
	
   // construct a new student with given fields
	public Student(String name,String email,String id,String password,ArrayList<Course> course){
      this.id=id;
		this.password=password;
		this.name = name;
		this.email = email;
		this.course=course;
	}
   
	public String getID(){
		return id;
	}

	public String getPassword(){
	   return password;
	}

	public String getName(){
	   return name;
	}

	public String getemail(){
	   return email;
	}


	public String getCourseSchedule(ArrayList<Course> b){
      if (b.get(0) == null){
         System.out.println("YOU ARE NOT ENROLLED IN ANY COURSE"); 
	   }else{
		   System.out.println("Courses: ");
	   	for (int i =0; i<b.size(); i++){
          	     System.out.println(i+1 + "). " + b.get(i).toString());
	   	}
	   }
      return "All Courses";
	}
	
	public ArrayList<Course> getCourselist(){
	   return course;
	}
 	
	public void printBilling(){
	   double Fees = course.size() * 2500;
		System.out.println("Your semester fees is: $" + Fees);
	}
	
	public String getCalender(){
  	   try{ 
         File myObj = new File("Schedule.txt");
      	Scanner myReader = new Scanner(myObj);
      	while (myReader.hasNextLine()) {
        	String data = myReader.nextLine();
      	System.out.println(data);
		}
      myReader.close();
		} catch (FileNotFoundException e) {
         System.out.println("An error occurred.");}
         return "For more Details contact ADMIN";
 	 }
		
   public void drop(String X, ArrayList<Course> a){
	   System.out.println("You can not Drop course after deadline");
		System.out.println("Which is 25th October");

		if (a.get(0) == null ){ 
         System.out.println("YOU ARE NOT ENROLLED IN ANY COURSE"); 
      }else{
		   for (int i=0; i<a.size(); i++){
		      if(X.equals(a.get(i).getCourseID())){
 	   	 	   a.remove(i);
				   System.out.println("Your courselist after dropping the course is: \n");
				   for (int y =0; y<a.size(); y++){
          	     		    System.out.println(y+1 + "). " + a.get(y).toString());
	   			}		
		       	break; 
		      }
		   }
		}
   }


   public void add(String Y,ArrayList<Course> c, ArrayList<Course> d){
      for (int i=0; i<d.size(); i++){
         if(Y.equals(d.get(i).getCourseID())){
			   System.out.println("This course is offered this semester");
			   Course g = new Course(d.get(i).getName(),d.get(i).getCourseID(),d.get(i).getProfessor(),d.get(i).getPreReq(),d.get(i).getNumberOfStudents());
			   c.add(g);	
	     	}else{
            System.out.println("This course is not offered this semester");	
			}
		}
      
      System.out.println("Your courselist after adding the course is: \n");
		for (int y =0; y<c.size(); y++){
         System.out.println(y+1 + "). " + c.get(y).toString());
	   }
   }
	  
	public static void main(String[] args) throws Exception {
      Course M= new Course ("CS", "cs2263", "Dr.McNally", "cs1222, cs1233", 3);
      Course N= new Course ("INFO", "cs2403", "Dr.Kaser", "cs1222, cs1233", 3);
      Course O= new Course ("CHE", "cs2403", "Dr.Walton", "cs1222, cs1233", 3);
      Course P= new Course ("CE", "cs2403", "Dr.Riley", "cs1222, cs1233", 3);
      Course Q= new Course ("BIO", "cs2403", "Dr.Bye", "cs1222, cs1233", 3);
      Course R= new Course ("BA", "cs2403", "Dr.Hello", "cs1222, cs1233", 3);
      Course S= new Course ("ACCA", "cs2403", "Dr.This", "cs1222, cs1233", 3);
      Course T= new Course ("FML", "cs2403", "Dr.That", "cs1222, cs1233", 3);
      Course U= new Course ("FRENCH", "cs2403", "Dr.Before", "cs1222, cs1233", 3);
      Course V= new Course ("FRS", "cs2403", "Dr.Now", "cs1222, cs1233", 3);
      Course W= new Course ("AN", "cs2403", "Dr.Project", "cs1222, cs1233", 3);
      Course X= new Course ("CS", "cs2403", "Dr.Kim", "cs1222, cs1233", 3);
		Course Y= new Course ("ECE", "ECE2214", "Dr.Gadoura", "ECE2221, cs1233", 5);
		Course Z= new Course ("ME", "ME2321", "Dr.White", "CS1222, ME2323", 7);
      
		ArrayList<Course> allcourse = new ArrayList<>();
		allcourse.add(M);allcourse.add(N);allcourse.add(O);allcourse.add(P);
		allcourse.add(Q);allcourse.add(R);allcourse.add(S);allcourse.add(T);
   	allcourse.add(U);allcourse.add(V);allcourse.add(W);allcourse.add(X);
		allcourse.add(Y);allcourse.add(Z);
      
		ArrayList<Course> course1= new ArrayList<>();
		ArrayList<Course> course2= new ArrayList<>();
		ArrayList<Course> course3= new ArrayList<>();
		ArrayList<Course> course4= new ArrayList<>(); 
		course1.add(Y);
		course1.add(Z);
		course2.add(X);
		course2.add(Y);
		course3.add(X);
		course3.add(Z);
		course4.add(X);
		course4.add(Y);
		course4.add(Z);
      Student A = new Student("Bob X","XYX@abc","1234","0000",course1);
      Student B = new Student("Natasha Z","asX@abc","5678","5678",course2);
      Student C = new Student("Max P","mX@abc","3668","9999",course3);
		Student D = new Student("Sheila S","NX@abc","2668","888",course4);
      ArrayList <Student> Array = new ArrayList<>();
	   Array.add(A);
	   Array.add(B);
	   Array.add(C);
	   Array.add(D);
      
  	   try{
            FileOutputStream fos = new FileOutputStream("Student");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(Array);
            oos.close();
            fos.close();
      }catch (IOException ioe){
         ioe.printStackTrace();
      }
  	

      try{
         FileOutputStream f = new FileOutputStream("Catalog");
         ObjectOutputStream s = new ObjectOutputStream(f);
	      s.writeObject(allcourse);
         s.close();
         f.close();
      }catch (IOException ie){
         ie.printStackTrace();
      }

	 }
}
