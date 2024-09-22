
package Ex4;

import java.text.SimpleDateFormat;
import java.util.Date;


public abstract class Student extends Person{
    float gpa;
    String major;

    public Student(String major, String name1, Date dateOfBirth1, float gpa, String major1) {
        this.gpa = gpa;
        this.major = major;
    }
    public Student() {
    }

    public float getGpa() {
        return gpa;
    }

    public String getMajor() {
        return major;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public void setMajor(String major) {
        this.major = major;
    }
    
    public void addPerson(){
        
    }
    public void updatePerson(String id)
    {
        
    }
    public void displayInfo(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String date = dateFormat.format(getDateOfBirth());
        System.out.println("id: "+id);
        System.out.println("name: "+name);
        System.out.println("dateOfBirth: "+date);
        System.out.println("gpa: "+gpa);
        System.out.println("mahor: "+major);
    }

  
}