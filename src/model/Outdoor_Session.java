package model;


import java.sql.SQLException;
import java.sql.*;

/**
 * Class to represent and store a session that is outside
 */
public class Outdoor_Session extends Session {


    private String  weather;
    private double temperature;
    private int session_id_fk;


    /**
     * Constructor for the outside session
     * @param date
     * @param duration
     * @param temperature
     * @param weather
     */
    public Outdoor_Session(Date date, int duration, double temperature, String weather) {
        super(date, duration);
        this.temperature = temperature;
        this.weather = weather;
    }


    /**
     * Fucntion for storing the session in the databse
     */
    public void storeOutdoorSession(){
        try {
            PreparedStatement ps = myConnection.prepareStatement("insert into Outdoor_training(session_id_fk,temp,weather_condtition) values(?,?,?)");
            ps.setInt(1,session_id_fk);
            ps.setDouble(2, temperature);
            ps.setString(3, weather);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Function for setting the id to the session this outside_session should be linked to
     * @param session_id_fk
     */
    public void setSession_id_fk(int session_id_fk) {
        this.session_id_fk = session_id_fk;
    }


}
