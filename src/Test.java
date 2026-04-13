import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {

    public static void main(String[] args) {

        try {

            // 1. Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Get Connection
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydb",
                    "root",
                    "mom@852130"
            );

            // 3. Create Statement
            Statement statement = connection.createStatement();

            // 4. Execute Query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM students");

            // 5. Process Data
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2));
            }

            // 6. Close Connection
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}