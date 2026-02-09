package lab2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {

    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://root:anish2061@localhost:3306/advancedjavalab");
        }catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static int addStudent(Connection conn, Student student) {
        try(PreparedStatement ps =
                    conn.prepareStatement("insert into student(name, phone) values(?,?)");
        ){
            ps.setString(1, student.getName());
            ps.setString(2, student.getPhone());

            return ps.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return -1;
    }

    public static int updateStudent(Connection conn, Student student){
        try(PreparedStatement
                    ps = conn.prepareStatement("UPDATE student SET name=?, phone=? WHERE id=?");
        ){
            ps.setString(1, student.getName());
            ps.setString(2, student.getPhone());
            ps.setInt(3, student.getId());
            return ps.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return -1;
    }

    public static int deleteStudent(Connection conn, int id){
        try(
        PreparedStatement ps = conn.prepareStatement("DELETE from student where id=?");
        ){
            ps.setInt(1, id);
            return ps.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return -1;
    }

    public static List<Student> showStudents(Connection conn){
        List<Student> students=new ArrayList<>();
        try(
            PreparedStatement ps= conn.prepareStatement("select * from student");
        ){
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setPhone(resultSet.getString("phone"));
                students.add(student);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return students;
    }

}



