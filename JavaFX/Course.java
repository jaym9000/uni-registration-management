import java.io.*;
public class Course implements Serializable {
    private String name;
    private String courseID;
    private String professor;
    private String preReq;
    private int numStudents;

    public Course(String name, String courseID, String professor, String preReq, int numStudents){
        this.name = name;
        this.courseID = courseID;
        this.professor = professor;
        this.preReq = preReq;
        this.numStudents = numStudents;
    }

    public String getName(){
        return name;
    }

    public String getCourseID(){
        return courseID;
    }

    public String getProfessor(){
        return professor;
    }

    public String getPreReq(){
        return preReq;
    }

    int getNumberOfStudents(){
        return numStudents;
    }

    public String toString(){
      return "Course name: "+name + ", " + courseID + "\nThe professor is: "+ professor +"\nPrerequisite: "+preReq+"\nNumber of Students: "+numStudents;
   }
}
