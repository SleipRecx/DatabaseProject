package model;

import controller.Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class for representing and storing results in the databse
 */
public class Result {
    protected int exercise_id_fk;
    protected int training_session_id_fk;
    protected static Connection myConnection = Main.getDB().getConnection();

    /**
     * Constructor for the result object
     * @param exercise_id_fk the exercise the result should be linked to
     * @param training_session_id_fk the session the result should be linked to
     */
    public Result(int exercise_id_fk,int training_session_id_fk){
        this.exercise_id_fk = exercise_id_fk;
        this.training_session_id_fk = training_session_id_fk;
    }


    /**
     * Function for storing the result in the databse
     */
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

    /**
     * Gets the biggest id of the results stored in the databse
     * @return the biggest id
     */
    public static int getBiggestId(){
        int id = -1;
        try {
            String sql  = "SELECT MAX(result_id) as maks from Result";
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


}
