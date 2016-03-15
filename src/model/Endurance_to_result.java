package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by eddern on 15/03/16.
 */
public class Endurance_to_result extends Result {
    private double km;
    private int time;
    private int result_id_fk;

    public Endurance_to_result(double km, int time){
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
