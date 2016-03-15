package model;

import controller.Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Result {
    protected int exercise_id_fk;
    protected int training_session_id_fk;
    protected static Connection myConnection = Main.getDB().getConnection();

    public Result(int exercise_id_fk,int training_session_id_fk){
        this.exercise_id_fk = exercise_id_fk;
        this.training_session_id_fk = training_session_id_fk;
    }


    public void storeResult(){
        try {
            PreparedStatement ps = myConnection.prepareStatement("INSERT INTO Result(exercise_id_fk,training_session_id_fk) VALUES (?,?)");
            ps.setInt(1,exercise_id_fk);
            ps.setInt(2,training_session_id_fk);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int getBiggestId(){
        int id = -1;
        try {
            String sql  = "SELECT MAX(session_id) as maks from Result";
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

    public int getExercise_id_fk() {return exercise_id_fk;}
    public void setExercise_id_fk(int exercise_id_fk) {this.exercise_id_fk = exercise_id_fk;}
    public int getTraining_session_id_fk() {return training_session_id_fk;}
    public void setTraining_session_id_fk(int training_session_id_fk) {this.training_session_id_fk = training_session_id_fk;}
}
