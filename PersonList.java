package Ex4;
import java.util.ArrayList;

public class PersonList {

    
    private ArrayList<Person> personList = new ArrayList<>();

    
    public void addStudent(Student student) {
        personList.add(student);
    }

  
    public void addTeacher(Teacher teacher) {
        personList.add(teacher);
    }

 
    public void updatePerson(String id, Person updatedPerson) {
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getId().equals(id)) {
                personList.set(i, updatedPerson);
                
                return;
            }
        }
        System.out.println("Person with ID: " + id + " not found.");
    }

  
    public void deletePersonById(String id) {
        personList.removeIf(person->person.getId().equals(id));
        }


    public Person findPersonById(String id) {
        for (Person person : personList) {
            if (person.getId().equals(id)) {
                return person;
            }
        }
        System.out.println("Person with ID: " + id + " not found.");
        return null;
    }

   
    public void displayEveryone() {
        for (Person person : personList) {
            person.displayInfo();
        }
    }

    
    public Student findTopStudent() {
        Student topStudent = null;
        for (Person person : personList) {
            if (person instanceof Student) {
                Student student = (Student) person;
                if (topStudent == null || student.getGpa() > topStudent.getGpa()) {
                    topStudent = student;
                }
            }
        }
        if (topStudent != null) {
            System.out.println("Top Student: " + topStudent.getName() + " with GPA: " + topStudent.getGpa());
        } else {
            System.out.println("No students found.");
        }
        return topStudent;
    }

    public Teacher findTeacherByDepartment(String department) {
        for (Person person : personList) {
            if (person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                if (teacher.getDepartment().equals(department)) {
                    System.out.println("Teacher found: " + teacher.getName() + " in department: " + department);
                    return teacher;
                }
            }
        }
        System.out.println("No teacher found in department: " + department);
        return null;
    }
}