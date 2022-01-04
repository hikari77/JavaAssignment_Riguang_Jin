import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcInsert {

    public static void insertPerson(Connection connection) {
        try (
                Statement statement = connection.createStatement();
                ) {
            String insertQuery = "INSERT INTO person VALUES" +
                                "(20,'Bosco', 'bosco@email.com')," +
                                "(31, 'Kevin', 'kevin@email.com'); ";

            statement.execute(insertQuery);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
