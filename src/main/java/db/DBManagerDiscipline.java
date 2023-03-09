package db;

import entity.Discipline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBManagerDiscipline {

    private static Statement statement;
    private static final String ID = "id";
    private static final String NAME = "discipline";


    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_3?user=root&password=Krilova1984/");
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static List<Discipline> getAllActiveDisciplines() {
        List<Discipline> disciplines = new ArrayList<>();
        try {
            ResultSet result = statement.executeQuery("select discipline.id, discipline from discipline;");

            while (result.next()) {
                Discipline discipline = new Discipline();
                discipline.setId(result.getInt(ID));
                discipline.setName(result.getString(NAME));

                disciplines.add(discipline);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return disciplines;
    }

    public  static void createDiscipline(String disciplineName){
        try{
            statement.execute(String.format("insert into `discipline` (`discipline`) values ('%s');",disciplineName));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
