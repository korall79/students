package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;


@WebServlet(name = "StudentsController", urlPatterns = "/students")
public class StudentsController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //соед с бд и получ данных
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_3?user=root&password=Krilova1984/");
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select * from student;");

            while (result.next()){
                String text = result.getInt("id")+ " " + result.getString("surname" + " "
                        + result.getString("name"));
                System.out.println(text);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        req.getRequestDispatcher("WEB-INF/jsp/students.jsp").forward(req,resp);
    }

}
