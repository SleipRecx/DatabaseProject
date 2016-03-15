package sample.model;

import sample.Main;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;


public class Session {

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

    public int getBiggestId(){
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
