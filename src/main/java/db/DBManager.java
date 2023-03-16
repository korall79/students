package db;

import entity.*;
import servises.StringService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBManager {

    private static Statement statement;
    private static final String ID = "id";
    private static final String SURNAME = "surname";
    private static final String NAME = "name";
    private static final String DATE = "date";
    private static final String GROUP = "group";
    private static final String TERM_NAME = "term";
    private static final String GRADE_VALUE = "grade";
    private static final String DISCIPLINE_ID = "id_discipline";
    private static final String DISCIPLINE_NAME = "discipline";


    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_3?user=root&password=Krilova1984/");
            statement = connection.createStatement();
        } catch (Exception e) {
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
                student.setSurname(result.getString(SURNAME));
                student.setName(result.getString(NAME));
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

    public static int getGroupId(String groupName) {
        try {
            ResultSet resultSet = statement.executeQuery(String.format("select id from groupp as g where g.group = '%s';", groupName));

            while (resultSet.next()) {
                return resultSet.getInt(ID);
            }

            statement.execute(String.format("insert into `groupp` (`group`) values ('%s');", groupName));
            resultSet = statement.executeQuery(String.format("select id from groupp as g where g.group = '%s';", groupName));

            while (resultSet.next()) {
                return resultSet.getInt(ID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Ошибка создания группы.");
        }
        return -1;
    }

    public static void createStudent(String surname, String name, int groupId, String date) {
        try {
            statement.execute(String.format("insert into `student` (`surname`, `name`, `id_group`, `date`) values ('%s', '%s', '%d', '%s');", surname, name, groupId, date));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteStudents(String[] ids) {
        try {
            statement.execute(String.format("update `student` set `status` = '0' where id in (%s);",
                    StringService.convertIdsIntoString(ids)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Student getStudentById(String id) {
        Student student = new Student();
        try {
            ResultSet resultSet = statement.executeQuery(String.format("select s.id, surname, name, date, g.group" +
                    "from student as s left join groupp as g on s.id_group = g.id where s.id = '%s';", id));
            while (resultSet.next()) {
                student.setId(resultSet.getInt(ID));
                student.setSurname(resultSet.getString(SURNAME));
                student.setName(resultSet.getString(NAME));
                student.setDate(resultSet.getDate(DATE));

                Group group = new Group();
                group.setName(resultSet.getString(GROUP));
                student.setGroup(group);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    public static void modifyStudent(String id, String surname, String name, int groupId, String date) {
        try {
            statement.execute(String.format("UPDATE `student` SET `surname` = '%s', `name` = '%s'," +
                    " `id group` = '%d' `date` = '%s' WHERE (`id` = '%s');", id, surname, name, groupId, date));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static List<Term> getAllActiveTerms() {
        List<Term> terms = new ArrayList<>();
        try {
            ResultSet result = statement.executeQuery("SELECT id, term FROM term WHERE status = '1';");

            while (result.next()) {
                Term term = new Term();
                term.setId(result.getInt(ID));
                term.setName(result.getString(TERM_NAME));
                terms.add(term);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return terms;
    }

    public  static List<Grade> getGradesByStudentAndTermIds(String studentId, String termId){
        List<Grade> grades = new ArrayList<>();
        try{
            ResultSet resultSet = statement.executeQuery(String.format("select id_discipline, discipline, grade"+
                    " from grade as g"+
                    "left join term_discipline as td on g.id_term_discipline = td.id" +
                    " left join discipline as d on td.id_discipline = d.id +" +
                    "where g.id_student = '1' and td.id_term = '1';"));

            while (resultSet.next()){
                Grade grade = new Grade();
                grade.setValue(Integer.parseInt(resultSet.getString(GRADE_VALUE)));

                Discipline discipline = new Discipline();
                discipline.setId(resultSet.getInt(DISCIPLINE_ID));
                discipline.setName(resultSet.getString(DISCIPLINE_NAME));
                grade.setDiscipline(discipline);

                grades.add(grade);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
            return  grades;
    }
}
