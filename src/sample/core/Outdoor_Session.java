package sample.core;


import java.sql.SQLException;
import java.sql.*;

public class Outdoor_Session extends Session {

    public static final String WEATHER_FIELD_NAME = "weather_condtition";

    public static final String TEMPERATURE_FIELD_NAME = "temp";

    private String  weather;

    private double temperature;

    private int session_id_fk;

    public Outdoor_Session(Date date, int duration, double temperature, String weather) {
        super(date, duration);
        this.temperature = temperature;
        this.weather = weather;
    }


    public void storeOutdoorSession(){
        //TODO INSERT INTO DATABASE
    }

    public int getSession_id_fk() {
        return session_id_fk;
    }

    public void setSession_id_fk(int session_id_fk) {
        this.session_id_fk = session_id_fk;
    }


}