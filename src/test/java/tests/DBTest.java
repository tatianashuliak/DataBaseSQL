package tests;

import database.DBConnection;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBTest {
    private DBConnection dbConnection = new DBConnection();

    @Test
    public void dataBaseTest() {
        dbConnection.connect();
            dbConnection.insertInto("students (name, cityId) VALUES ('Jim', 3)");
        dbConnection.close();
    }
}
