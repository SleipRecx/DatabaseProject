package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Strength_condition_to_result extends Result{
    private int weight;
    private int reps;
    private int sets;
    private int result_id_fk;

    public Strength_condition_to_result(int exercise_id_fk, int session_id_fk,int weight, int reps, int sets){
        super(exercise_id_fk,session_id_fk);
        this.weight = weight;
        this.reps = reps;
        this.sets = sets;
    }

    public void storeStrength_condition_to_result(){
        try {
            PreparedStatement ps = myConnection.prepareStatement("INSERT INTO Strength_condition_to_result(result_id_fk,weight,reps,sets) VALUES (?,?,?,?)");
            ps.setInt(1,result_id_fk);
            ps.setInt(2,weight);
            ps.setInt(3,reps);
            ps.setInt(4,sets);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setResult_id_fk(int id){
        this.result_id_fk = id;
    }
}
