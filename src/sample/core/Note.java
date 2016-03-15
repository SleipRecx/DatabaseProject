package sample.core;

import sample.Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Note {
    private int shape;
    private int performance;
    private String exercise_purpose;
    private String tips;
    private int session_id_fk;
    protected Connection myConnection = Main.getDB().getConnection();

    public Note(int shape, int performance, String exercise_purpose, String tips,int session_id_fk){
        this.shape = shape;
        this.performance = performance;
        this.exercise_purpose = exercise_purpose;
        this.tips = tips;
        this.session_id_fk = session_id_fk;
    }

    public void storeNote(){
        try {
            PreparedStatement ps = myConnection.prepareStatement("INSERT INTO Notes(session_id_fk,personal_shape,performance,exercise_purpose,tips) VALUES (?,?,?,?,?)");
            ps.setInt(1,session_id_fk);
            ps.setInt(2,shape);
            ps.setInt(3,performance);
            ps.setString(4,exercise_purpose);
            ps.setString(5,tips);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public int getShape() {
        return shape;
    }

    public void setShape(int shape) {
        this.shape = shape;
    }

    public int getPerformance() {
        return performance;
    }

    public void setPerformance(int performance) {
        this.performance = performance;
    }

    public String getExercise_purpose() {
        return exercise_purpose;
    }

    public void setExercise_purpose(String exercise_purpose) {
        this.exercise_purpose = exercise_purpose;
    }

}
