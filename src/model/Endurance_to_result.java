package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Endurance_to_result extends Result {
    private double km;
    private int time;
    private int result_id_fk;

    public Endurance_to_result(int exercise_id_fk,int session_id_fk,double km, int time){
        super(exercise_id_fk,session_id_fk);
        this.km = km;
        this.time = time;
    }

    public void storeEndurance_to_result(){
        try {
            PreparedStatement ps = myConnection.prepareStatement("INSERT INTO Endurance_to_result(result_id_fk,km,time) VALUES (?,?,?)");
            ps.setInt(1,result_id_fk);
            ps.setDouble(2,km);
            ps.setInt(3,time);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setResult_id_fk(int id){
        this.result_id_fk = id;
    }

}
