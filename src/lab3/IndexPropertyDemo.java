//Write a Java program to illustrate the use of Indexed Properties.
package lab3;

public class IndexPropertyDemo {

    public static void main(String[] args) {

        IndexedBean student = new IndexedBean();

        student.setSubjects(0, "Java");
        student.setSubjects(1, "Networking");
        student.setSubjects(2, "DBMS");

        System.out.println("Subjects:");
        for (int i = 0; i < 3; i++) {
            System.out.println(student.getSubjects(i));
        }
    }
}

