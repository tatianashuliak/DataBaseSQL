package database;

import java.sql.*;

public class DBConnection {
    private Connection connect = null;
    private Statement statement = null;

    public void connect(){
        try {
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/aqa20onl?"
                                + "user=root&password=23041997nik&useSSL=true&serverTimezone=GMT");
            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ResultSet selectFrom(String tableName) {
        try {
            return statement
                    .executeQuery(String.format("select * from %s", tableName));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public ResultSet select(String query) {
        try {
            return statement
                    .executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public int executeQuery(String query) {
        try {
            return statement
                    .executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public void insertInto(String query) {
        System.out.println("Количество измененных строк - " + executeQuery("INSERT INTO " + query));
    }



    public static void writeResultSetTable1(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String cityId = resultSet.getString("cityId");
            System.out.println("ID: " + id);
            System.out.println("NAME: " + name);
            System.out.println("CITYID: " + cityId);
        }
    }
    public static void writeResultSetTable2(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            System.out.println("ID: " + id);
            System.out.println("NAME: " + name);
        }
    }

    // You need to close the resultSet
    public void close() {
        try {

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        }catch (Exception ignored) {
        }
    }

}
