import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUpdate {

    public static void updatePersonAge(Connection connection, String name, int age) {
        try (Statement statement = connection.createStatement()) {

            String updateQuery = "UPDATE person SET age = " + age + " WHERE name = '" + name + "'";
            statement.execute(updateQuery);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


}
