package tests;

import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseTest {
    @Test
    public void checkQuery() throws SQLException {
        try (Connection connection = DataBaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM information_schema.sql_features")) {


            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }
        }
    }

}
