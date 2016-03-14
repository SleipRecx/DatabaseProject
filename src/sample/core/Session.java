package sample.core;

import sample.Main;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;


public class Session {

    public static final String SESSION_ID_FIELD_NAME = "session_id";

    public static final String DATE_FIELD_NAME = "date";

    public static final String DURATION_FIELD_NAME = "duration";


    protected int sessionid;
    protected Date date;
    protected int duration;

    protected Note note;
    protected ArrayList<Exercise> exercises;

    protected Connection myConnection = Main.getDB().getConnection();


    public Session(Date date, int duration){
        this.date = date;
        this.duration = duration;
    }



    // START Getters and Setters
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

    // END Getters and Setters

}
