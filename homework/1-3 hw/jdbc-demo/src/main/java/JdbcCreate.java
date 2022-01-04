import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcCreate {



    public static final String CREATE_TABLE_STATEMENT = "CREATE TABLE  person (" +
        "age INT," +
        "name VARCHAR(100)," +
        "email VARCHAR(100)" +
        ");";

    public static void createTable(Connection connection) {
        try (
                Statement statement = connection.createStatement()
                ) {

            statement.execute(CREATE_TABLE_STATEMENT);

        } catch (SQLException ex) {

            ex.printStackTrace();
        }
    }
}
