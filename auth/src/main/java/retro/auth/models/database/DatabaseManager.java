package retro.auth.models.database;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import retro.auth.services.Utils;

@Component
public class DatabaseManager {

    @Autowired
    private Utils utils;
    public static DatabaseManager dbManager;

    private DatabaseManager() {
        //No-op
    }

    public static final DatabaseManager getInstance() {
        if (dbManager == null) {
            dbManager = new DatabaseManager();
        }
        return dbManager;
    }

    private Connection getConnection() throws SQLException, ClassNotFoundException {
        String url = "jdbc:derby:UserDB;create=true";
        Connection conn = DriverManager.getConnection(url);
        String driver = "org.apache.derby.jdbc.EmbeddedDriver";
        Class.forName(driver);
        return conn;
    }

    public void insertUserToDB(String username, String password) {
        String insertUsers = "INSERT INTO users (username, password) VALUES (?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement prepStm = conn.prepareStatement(insertUsers)) {
            String encodedPassword = utils.hashPassword(password);
            prepStm.setString(1, username);
            prepStm.setString(2, encodedPassword);
            prepStm.execute();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTableUsers() {
        String tableUsers = "CREATE TABLE users (" +
                " id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
                " username VARCHAR(30) NOT NULL," +
                " password VARCHAR(50) NOT NULL," +
                " UNIQUE (username)," +
                " PRIMARY KEY(id))";
        try (Connection conn = getConnection();
             Statement stm = conn.createStatement()) {
            stm.execute(tableUsers);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Map<String, String> getUser(String username, String encodedPassword) {
        Map<String, String> user = new HashMap<>();
        String resultsQuery = "SELECT username, password FROM users WHERE username = (?) and password = (?)";
        try (Connection conn = getConnection();
             PreparedStatement prepStm = conn.prepareStatement(resultsQuery)) {
            prepStm.setString(1, username);
            prepStm.setString(2, encodedPassword);
            try (ResultSet rs = prepStm.executeQuery()) {
                if (rs.next()) {
                    String dbUsername = rs.getString("username");
                    String dbPassword = rs.getString("password");
                    user.put(dbUsername, dbPassword);
                    //  System.out.println(rs.getString("username") + " - " + rs.getString("password"));
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


    public void deleteUser(String username) {
        String deleteUser = "DELETE FROM users WHERE username = (?)";
        try (Connection conn = getConnection();
             PreparedStatement prepStm = conn.prepareStatement(deleteUser)) {
            prepStm.setString(1, username);
            prepStm.execute();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // public static void main(String[] args) throws SQLException, ClassNotFoundException {
    // DatabaseManager dbm = new DatabaseManager();
    // dbm.getUser();
    // dbm.createTableUsers();
    // dbm.insertUserToDB("Stamat", "parola");
    // dbm.deleteUser("Stamat");
    // }
}
