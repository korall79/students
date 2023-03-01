package db;

import entity.Group;
import entity.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBManager {

    private static Statement statement;
    private static final  String ID = "id";
    private static final  String SURNAME = "surname";
    private static final  String NAME = "name";
    private static final  String DATE = "date";
    private static final  String GROUP = "group";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_3?user=root&password=Krilova1984/");
            statement = connection.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static List<Student> getAllActiveStudents() {
List<Student> students = new ArrayList<>();
        try {
            ResultSet result = statement.executeQuery("select s.id, surname, name, date," +
                    " g.group from student as s left join groupp as g on s.id_group = g.id" +
                    " where status = '1';");

            while (result.next()) {
              Student student = new Student();
              student.setId(result.getInt(ID));
                student.setId(result.getInt(SURNAME));
                student.setSurname(result.getString(NAME));
                student.setDate(result.getDate(DATE));

                Group group = new Group();
                group.setName(result.getString(GROUP));
                student.setGroup(group);

                students.add(student);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }
}
