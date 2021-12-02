package examples;

import org.junit.Test;

import java.sql.*;

/**
 * Приклад найпростішого використання JDBC
 **/

public class JDBC {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DATABASE_URL = "";

    static final String USER = "";
    static final String PASSWORD = "";

    @Test
    public void method() throws SQLException {
        Connection connection = null;
        Statement statement = null;

        System.out.println("Registering JDBC driver...");
        try {
            Class.forName(JDBC_DRIVER).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            System.out.println(e + "");
        }

        System.out.println("Creating database connection...");
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

        System.out.println("Executing statement...");
        statement = connection.createStatement();

        String sql;
        sql = "SELECT * FROM `ebdb`.`additional_question` WHERE `question_id` = 657";

        ResultSet resultSet = statement.executeQuery(sql);


        System.out.println(resultSet.toString());

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String label = resultSet.getString("label");
            String type = resultSet.getString("type");
            String position = resultSet.getString("position");

            System.out.println("\n================\n");
            System.out.println("id: " + id);
            System.out.println("Name: " + label);
            System.out.println("Specialty: " + type);
            System.out.println("Salary: $" + position);

            System.out.println("Closing connection and releasing resources...");

        }
        resultSet.close();
        statement.close();
        connection.close();

    }


}
