package xamples;

import org.junit.Test;

import java.sql.*;

/**Приклад найпростішого використання JDBC**/

public class JavaDataBaseConnection {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://doo-staging8-db.crvi7fl8triw.eu-central-1.rds.amazonaws.com";

    static final String USER = "ebroot";
    static final String PASSWORD = "Ulapifobu231";

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
        sql = "SELECT * FROM ebdb.event_attribute WHERE organizer_id = 13017";

        ResultSet resultSet = statement.executeQuery(sql);

        System.out.println("Retrieving data from database...");
        System.out.println("\nmy_guests:");

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String templateId = resultSet.getString("template_id");
            String type = resultSet.getString("type");
            String name = resultSet.getString("name");

            System.out.println("\n================\n");
            System.out.println("id: " + id);
            System.out.println("Template id: " + templateId);
            System.out.println("Type: " + type);
            System.out.println("Name: " + name);

            System.out.println("Closing connection and releasing resources...");

        }
        resultSet.close();
        statement.close();
        connection.close();

    }


}
