package model;
import java.sql.*;

/**
 * Class for setting up connection to the database
 */
public class DB_Setup {
    private static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
    private final String DATABASE_URL;
    private final String DB_USERNAME;
    private final String DB_PASSWORD;
    private Connection myConnection;

    /**
     * Constructor where the connection is made
     * @param DB_URL URL for the database
     * @param DB_USERNAME Username for the database
     * @param DB_PASSWORD Password for the database
     */
    public DB_Setup(String DB_URL, String DB_USERNAME, String DB_PASSWORD) {
        this.DATABASE_URL = DB_URL;
        this.DB_USERNAME = DB_USERNAME;
        this.DB_PASSWORD = DB_PASSWORD;
        createConnect();
    }

    /**
     * Method for creating connection
     */
    private void createConnect(){
        try {
            System.out.println("Connecting to selected database...");
            Class.forName(MYSQL_DRIVER);
            myConnection = DriverManager.getConnection(this.DATABASE_URL,this.DB_USERNAME,this.DB_PASSWORD);
            System.out.println("Connected database successfully...");

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Database connection failed...");
            e.printStackTrace();
        }
    }

    /**
     * Method for closing connection
     */
    public void closeConnection(){
        try {
            myConnection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method for getting the connection
     * @return connection to the database
     */
    public Connection getConnection() {
        return myConnection;
    }
}
