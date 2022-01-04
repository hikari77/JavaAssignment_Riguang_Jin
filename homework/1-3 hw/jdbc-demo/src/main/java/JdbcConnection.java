import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
    public static void main(String[] args) {

        try (Connection connection =
                     DriverManager.getConnection(JdbcConfig.URL, JdbcConfig.USER, JdbcConfig.PASSWORD)
        ) {
            if (connection != null) {
                System.out.println("Connected.");

                // create person table
                JdbcCreate.createTable(connection);
            } else {
                System.out.println("connection null");
            }


        } catch (SQLException ex) {
            System.out.println("Failed");
            ex.printStackTrace();
        }

    }
}
