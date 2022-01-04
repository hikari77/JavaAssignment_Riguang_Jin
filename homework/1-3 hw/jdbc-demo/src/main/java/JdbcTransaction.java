import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTransaction {

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(JdbcConfig.URL, JdbcConfig.USER, JdbcConfig.PASSWORD);
             Statement statement = connection.createStatement()) {

            connection.setAutoCommit(false);

            JdbcSelect.selectAll(connection);
            JdbcUpdate.updatePersonAge(connection, "Kevin", 999);
            JdbcSelect.selectAll(connection);

            // rollback to previous age 41
            connection.rollback();
            JdbcSelect.selectAll(connection);


            JdbcUpdate.updatePersonAge(connection, "Kevin", 88);
            connection.commit();
            // commit age 88,  result should be 88
            JdbcSelect.selectAll(connection);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
