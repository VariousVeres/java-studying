package examples;

import org.junit.Test;

import java.sql.*;

/**Приклад найпростішого використання JDBC**/

public class JavaDataBaseConnection {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost/test_db";

    static final String USER = "root";
    static final String PASSWORD = "azAZ09@-";

    @Test
    public void method() throws SQLException {
        Connection connection = null;
        Statement statement = null;

        System.out.println("Registering JDBC driver...");
       try {
        Class.forName(JDBC_DRIVER).getDeclaredConstructor().newInstance();}
       catch (Exception e)  {
           System.out.println(e+"");
       }

        System.out.println("Creating database connection...");
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

        System.out.println("Executing statement...");
        statement = connection.createStatement();

        String sql;
        sql = "SELECT * FROM test_db.my_guests";

        ResultSet resultSet = statement.executeQuery(sql);

        System.out.println("Retrieving data from database...");
        System.out.println("\nmy_guests:");

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("firstname");
            String surname = resultSet.getString("lastname");
            String email = resultSet.getString("email");

            System.out.println("\n================\n");
            System.out.println("id: " + id);
            System.out.println("Name: " + name);
            System.out.println("Specialty: " + surname);
            System.out.println("Salary: $" + email);

            System.out.println("Closing connection and releasing resources...");

        }
        resultSet.close();
        statement.close();
        connection.close();

    }


}
