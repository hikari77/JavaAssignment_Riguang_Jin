import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AppRunner {

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(
                JdbcConfig.URL,
                JdbcConfig.USER,
                JdbcConfig.PASSWORD)) {

            JdbcSelect.selectAll(connection);

            //insert two rows - Kevin, Bosco
            JdbcInsert.insertPerson(connection);
            JdbcSelect.selectAll(connection);
//
            // delete Bosco row
            JdbcDelete.deleteByName(connection, "Bosco");
            JdbcSelect.selectAll(connection);

//            // update Kevin age to 41
            JdbcUpdate.updatePersonAge(connection, "Kevin", 41);
            JdbcSelect.selectAll(connection);

        } catch (SQLException ex) {
            System.out.println("failed");
            ex.printStackTrace();
        }
    }
}
