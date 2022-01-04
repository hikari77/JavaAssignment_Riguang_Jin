import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDelete {

    public static void deleteByName(Connection connection, String name) {
        try (
                Statement statement = connection.createStatement();
                ) {
            String deleteQuery = "DELETE FROM person WHERE name = '" + name + "'";

            statement.execute(deleteQuery);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
