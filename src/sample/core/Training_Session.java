package sample.core;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;



public class Training_Session {

    public static final String SESSION_ID_FIELD_NAME = "session_id";

    public static final String DATE_FIELD_NAME = "date";

    public static final String DURATION_FIELD_NAME = "duration";

    public static final String VENTILATION_FIELD_NAME = "ventilation";

    public static final String SPECTATORS_FIELD_NAME = "spectators";

    public static final String WEATHER_FIELD_NAME = "weather_condtition";

    public static final String TEMPERATURE_FIELD_NAME = "temp";

    private int sessionid;

    private Date date;

    private int duration;

    //Inside Session
    private String ventilation;

    private int spectators;

    //Outside Session
    private String  weather;

    private double temperature;



    private Note note;
    private ArrayList<Exercise> exercises;
    private Connection myConnection;
    private Statement myStatement;


    public Training_Session(Date date, int duration, int spectators, String ventilation){
        this.date = date;
        this.duration = duration;
        this.spectators = spectators;
        this.ventilation = ventilation;
    }

    public Training_Session(Date date, int duration, double temperature, String weather){
        this.date = date;
        this.duration = duration;
        this.temperature = temperature;
        this.weather = weather;
    }


    public ArrayList<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(ArrayList<Exercise> exercises) {
        this.exercises = exercises;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getVentilation() {
        return ventilation;
    }

    public void setVentilation(String ventilation) {
        this.ventilation = ventilation;
    }

    public int getSpectators() {
        return spectators;
    }

    public void setSpectators(int spectators) {
        this.spectators = spectators;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public int getSessionid() {
        return sessionid;
    }

    public void setSessionid(int sessionid) {
        this.sessionid = sessionid;
    }

    public void storeSessionInDatabase(){
        createStatement();
        String sql = String.format("");
        try {
            myStatement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createStatement() {
        try {
            this.myStatement = myConnection.createStatement();
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Statement could not be created");
        }
    }

}
