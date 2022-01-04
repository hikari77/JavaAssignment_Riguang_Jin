import java.sql.*;

public class JdbcSelect {

    public static final String SELECT_ALL_STATEMENT = "select * from person";


    public static void selectAll(Connection connection) {
        try (
                Statement statement = connection.createStatement()
                ) {

            ResultSet rs = statement.executeQuery(SELECT_ALL_STATEMENT);

            int count = 0;
            System.out.println(" --------------------------------------------");

            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                int age = rs.getInt("age");
                System.out.println(" Name: " + name +
                        " | Email: " + email +
                        " | Age: " + age);
                count++;
            }

            if (count == 0) System.out.println("  Empty table. ");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }


    }

}
