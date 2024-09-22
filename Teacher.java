
package Ex4;

import java.text.SimpleDateFormat;
import java.util.Date;


public abstract class Teacher extends Person {
    String department;
    String teachingSubject;

    public Teacher(String department, String teachingSubject, Date teacherDob, String department1, String subject) {
        this.department = department;
        this.teachingSubject = teachingSubject;
    }

    public Teacher() {
    }
    public String getDepartment() {
        return department;
    }

    public String getTeachingSubject() {
        return teachingSubject;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setTeachingSubject(String teachingSubject) {
        this.teachingSubject = teachingSubject;
    }
    
    public void addPerson(){
        
    }
    public void updatePerson(){
        
    }
    public void displayInfo(){
        SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy");
        String date = dateFormat.format(getDateOfBirth());
        System.out.println("id: "+id);
        System.out.println("name: "+name);
        System.out.println("dateOfBirth: "+date);
        System.out.println("department: "+ department);
        System.out.println("teachingSubject: "+teachingSubject);
    }
}