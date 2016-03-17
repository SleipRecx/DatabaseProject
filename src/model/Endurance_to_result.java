package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Class for representing and storing Endurance that belongs to result in the database
 */
public class Endurance_to_result extends Result {
    private double km;
    private int time;
    private int result_id_fk;

    /**
     * Constructor that initialises the result with values
     * @param exercise_id_fk the id of the exercise that is should be linked to endurance
     * @param session_id_fk the id of the session this result should be linked to
     * @param km
     * @param time
     */
    public Endurance_to_result(int exercise_id_fk,int session_id_fk,double km, int time){
        super(exercise_id_fk,session_id_fk);
        this.km = km;
        this.time = time;
    }

    /**
     * Function for storing the endurance result to the database
     */
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

    /**
     * Function for setting which result it belongs to
     * @param id
     */
    public void setResult_id_fk(int id){
        this.result_id_fk = id;
    }

}
