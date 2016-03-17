package model;

import controller.Main;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;


/**
 * Class for representing and storing the sessions
 */
public class Session {
    protected int sessionid;
    protected Date date;
    protected int duration;
    protected Note note;
    protected ArrayList<Exercise> exercises;
    protected static Connection myConnection = Main.getDB().getConnection();


    /**
     * Constructor for the session
     * @param date
     * @param duration
     */
    public Session(Date date, int duration){
        this.date = date;
        this.duration = duration;
    }

    /**
     * Funtion for storing the session to the database
     */
    public void storeSession(){
        try {
            PreparedStatement ps = myConnection.prepareStatement("INSERT INTO Training_session(date,duration) VALUES (?,?)");
            ps.setDate(1,getDate());
            ps.setInt(2,getDuration());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Function for getting the biggest id of the sessions in the databse
     * @return the biggest id
     */
    public static int getBiggestId(){
        int id = -1;
        try {
            String sql  = "SELECT MAX(session_id) as maks from Training_session";
            PreparedStatement ps = myConnection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            while(rs.next()){
                 id  = rs.getInt("maks");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    /**
     * Function for getting all the sessions that are stored in the database
     * @return ArrayList with all the sessions
     */
    public static ArrayList<String> fecthAllSessionsString(){
        ArrayList<String> array = new ArrayList<>();
        try{
            String sql = "SELECT date, session_id as id from Training_session";
            PreparedStatement ps = myConnection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            while(rs.next()){
                int id= rs.getInt("id");
                Date date = rs.getDate("date");
                array.add(String.valueOf(id)+"-"+date.toString());
            }
            rs.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return array;
    }


    /**
     * Function for getting the date of the session
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Function for getting the duration of the session
     * @return duration
     */
    public int getDuration() {
        return duration;
    }

}
