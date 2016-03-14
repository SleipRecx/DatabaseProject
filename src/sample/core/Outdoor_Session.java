package sample.core;


import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Outdoor_Session extends Session {

    public static final String WEATHER_FIELD_NAME = "weather_condtition";

    public static final String TEMPERATURE_FIELD_NAME = "temp";

    private String  weather;

    private double temperature;

    public Outdoor_Session(Date date, int duration, double temperature, String weather) {
        super(date, duration);
        this.temperature = temperature;
        this.weather = weather;
    }


    public void storeOutdoorSession(){
        try {
            Statement statement = myConnection.createStatement();
            String sql = String.format("");
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
