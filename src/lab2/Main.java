package lab2;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static Connection conn;


    public static void main(String[] args){

        conn = DatabaseConnection.getConnection();
        while(true) {
            int option = showOptions();

            if(option == 0){
                System.exit(0);
            }

            switch (option) {
                case 1:
                    insertStudent();
                    break;
                case 2:
                    updateStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    viewStudents();
                    break;
            }
        }

    }

    private static void viewStudents(){
        System.out.println("Fetching Students...");
        List<Student> students = DatabaseConnection.showStudents(conn);
        if(students.isEmpty()){
            System.out.println("No student found!");
        }else{
            for(Student s: students){
                System.out.println("Id: "+s.getId()+" Name: "+s.getName()+" Phone: "+s.getPhone());
            }
        }

        System.out.println("--------------------------------------------------");
    }

    private static void deleteStudent(){
        System.out.println("Enter id of student:");
        int id = sc.nextInt();
        int affectedRow = DatabaseConnection.deleteStudent(conn, id);
        if(affectedRow>0)
            System.out.println("Deleted");
        else
            System.out.println("Failed to delete");
        System.out.println("--------------------------------------------------");

    }

    private static void updateStudent(){
        System.out.println("Enter id of student:");
        int id = sc.nextInt();
        Student student = fillInfo();
        student.setId(id);
        int affectedRow = DatabaseConnection.updateStudent(conn, student);
        if(affectedRow>0)
            System.out.println("Updated");
        else
            System.out.println("Failed to update");
        System.out.println("--------------------------------------------------");

    }

    private static void insertStudent() {
        Student student = fillInfo();
        int affectedRow = DatabaseConnection.addStudent(conn, student);
        if(affectedRow>0){
            System.out.println("Added");
        }else
            System.out.println("Failed to add");
        System.out.println("--------------------------------------------------");

    }

    private static Student fillInfo(){
        Student student = new Student();
        System.out.println("Enter name of student");
        student.setName(sc.next());

        System.out.println("Enter phone of student");
        student.setPhone(sc.next());
        return student;
    }

    private static int showOptions(){
        System.out.println("-------------------- Choose operation: -------------------");
        System.out.println("Press 0 to exit");
        System.out.println("Insert new student: press 1");
        System.out.println("Update existing student: press 2");
        System.out.println("Delete student: press 3");
        System.out.println("View all students: press 4");
        return sc.nextInt();
    }

}
