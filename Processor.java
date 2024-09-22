package Ex4;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;


public class Processor {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        PersonList personList = new PersonList();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        boolean running = true;

        while (running) {
            System.out.println("1. Add a new student");
            System.out.println("2. Add a new teacher");
            System.out.println("3. Update person");
            System.out.println("4. Delete person by id");
            System.out.println("5. Find person by id");
            System.out.println("6. Display all students and teachers");
            System.out.println("7. Find the student with the highest GPA");
            System.out.println("8. Find a teacher by department");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1: 
                    try {
                        System.out.print("Enter student ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Enter full name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter date of birth (dd/MM/yyyy): ");
                        String dob = scanner.nextLine();
                        Date dateOfBirth = dateFormat.parse(dob);
                        System.out.print("Enter GPA: ");
                        float gpa = scanner.nextFloat();
                        scanner.nextLine(); 
                        System.out.print("Enter major: ");
                        String major = scanner.nextLine();

                        personList.addStudent(new Student(id, name, dateOfBirth, gpa, major) {
                            @Override
                            public void updatePerson() {
                                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                            }
                        });
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please use dd/MM/yyyy.");
                    }
                    break;



               case 2: 
                        try {
                            System.out.print("Enter teacher ID: ");
                            String Tid = scanner.nextLine();
                            System.out.print("Enter full name: ");
                            String Tname = scanner.nextLine();
                            System.out.print("Enter date of birth (dd/MM/yyyy): ");
                            String TDob = scanner.nextLine();
                            Date teacherDob = dateFormat.parse(TDob); // Correct date parsing
                            System.out.print("Enter department: ");
                            String department = scanner.nextLine();
                            System.out.print("Enter teaching subject: ");
                            String subject = scanner.nextLine();

                            personList.addTeacher(new Teacher(Tid, Tname, teacherDob, department, subject) {
                                @Override
                                public void updatePerson(String id) {
                                    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                                }
                            });
                        } catch (ParseException e) {
                            System.out.println("Invalid date format. Please use dd/MM/yyyy.");
                        }
                        break;


                case 3: 
                        try {
                            System.out.println("Enter the ID of the person to update: ");
                            String updateId = scanner.nextLine();

                            Person existingPerson = personList.findPersonById(updateId);
                            if (existingPerson == null) {
                                System.out.println("Person not found or invalid ID.");
                                break;
                            }

                            System.out.println("Enter full name: ");
                            String updateName = scanner.nextLine();
                            System.out.println("Enter date of birth (dd/MM/yyyy): ");
                            String updateDob = scanner.nextLine();
                            Date updateDateOfBirth = dateFormat.parse(updateDob);

                            if (existingPerson instanceof Student) {
                                System.out.println("Enter GPA: ");
                                float updateGpa = scanner.nextFloat();
                                scanner.nextLine(); 
                                System.out.println("Enter major: ");
                                String updateMajor = scanner.nextLine();
                                personList.updatePerson(updateId, new Student(updateId, updateName, updateDateOfBirth, updateGpa, updateMajor) {
                                    @Override
                                    public void updatePerson() {
                                        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                                    }
                                });
                            } else if (existingPerson instanceof Teacher) {
                                System.out.println("Enter department: ");
                                String updateDepartment = scanner.nextLine();
                                System.out.println("Enter teaching subject: ");
                                String updateSubject = scanner.nextLine();
                                personList.updatePerson(updateId, new Teacher(updateId, updateName, updateDateOfBirth, updateDepartment, updateSubject) {
                                    @Override
                                    public void updatePerson(String id) {
                                        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                                    }
                                });
                            }
                        } catch (ParseException e) {
                            System.out.println("Invalid date format. Please use dd/MM/yyyy.");
                        }
                     break;


                case 4: 
                    System.out.println("Enter the ID of the person to delete: ");
                    String deleteId = scanner.nextLine();
                    personList.deletePersonById(deleteId);
                    break;

                case 5: 
                    System.out.println("Enter the ID of the person to find: ");
                    String findId = scanner.nextLine();
                    Person foundPerson = personList.findPersonById(findId);
                    if (foundPerson != null) {
                        foundPerson.displayInfo();
                    }
                    break;

                case 6: 
                    System.out.println("Displaying all students and teachers:");
                    personList.displayEveryone();
                    break;

                case 7: 
                    System.out.println("Finding the student with the highest GPA:");
                    Student topStudent = personList.findTopStudent();
                    if (topStudent != null) {
                        topStudent.displayInfo();
                    }
                    break;

                case 8: 
                    System.out.println("Enter the department to search for a teacher: ");
                    String searchDepartment = scanner.nextLine();
                    Teacher foundTeacher = personList.findTeacherByDepartment(searchDepartment);
                    if (foundTeacher != null) {
                        foundTeacher.displayInfo();
                    }
                    break;

                case 9: 
                    running = false;
                    System.out.println("Exiting the program...");
                    break;

                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
                    break;
            }
        }
        scanner.close();
    }
}