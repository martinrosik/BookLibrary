import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Class for connecting to the database
public class DatabaseConnection {
    //Database url
    private static String url = "";
    //Database login
    private static String login = "";
    //Database password
    private static String password = "";

    public static Connection getConnection() {
        //Connecting to the database and initializing database informations (url database, login database, password for database)
        try {
            return DriverManager.getConnection(url, login, password);

            //Catching if something went wrong while connecting to the database
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
            return null;
        }
    }
}
