package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Strength_condition_to_result extends Result{
    private SimpleIntegerProperty weight = new SimpleIntegerProperty();
    private SimpleIntegerProperty reps = new SimpleIntegerProperty();
    private SimpleIntegerProperty sets = new SimpleIntegerProperty();
    private SimpleIntegerProperty result_id_fk = new SimpleIntegerProperty();
    private SimpleStringProperty name = new SimpleStringProperty();


    public Strength_condition_to_result(int exercise_id_fk, int session_id_fk, int weight, int reps, int sets){
        super(exercise_id_fk,session_id_fk);
        this.weight.set(weight);
        this.reps.set(reps);
        this.sets.set(sets);
    }

    public void storeStrength_condition_to_result(){
        try {
            PreparedStatement ps = myConnection.prepareStatement("INSERT INTO Strength_condition_to_result(result_id_fk,weight,reps,sets) VALUES (?,?,?,?)");
            ps.setInt(1,result_id_fk.get());
            ps.setInt(2,weight.get());
            ps.setInt(3,reps.get());
            ps.setInt(4,sets.get());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Strength_condition_to_result> fetchResultWithId(int session_id){
        ArrayList<Strength_condition_to_result> result = new ArrayList<>();
        try{
            String sql = "SELECT exercise_id,sets, weight,reps " +
                    "FROM Result JOIN Exercise ON exercise_id = exercise_id_fk " +
                    "JOIN Training_session ON session_id = training_session_id_fk " +
                    "JOIN Strength_condition_to_result ind ON ind.result_id_fk = result_id " +
                    "WHERE training_session_id_fk = ?";

            PreparedStatement ps = myConnection.prepareStatement(sql);
            ps.setInt(1,session_id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Strength_condition_to_result  resultObj =
                        new Strength_condition_to_result(rs.getInt("exercise_id"),session_id,
                                rs.getInt("weight"),rs.getInt("reps"),rs.getInt("sets"));
                resultObj.setName(resultObj.fetchExerciseName());
                result.add(resultObj);
            }

        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public String fetchExerciseName(){
        String result = "";
        try{
            String sql = "SELECT name FROM Exercise where exercise_id = ?";
            PreparedStatement ps = myConnection.prepareStatement(sql);
            ps.setInt(1,this.exercise_id_fk);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                result = rs.getString("name");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }


    public String getName(){
        return name.get();
    }

    public void setName(String name){
        this.name.set(name);
    }

    public void setResult_id_fk(int id){
        this.result_id_fk.set(id);
    }
}
