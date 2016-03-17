package model;


import controller.Main;
import java.sql.*;
import java.util.ArrayList;


/**
 * Class for storing and representing exercises
 */
public class Exercise {
    protected static Connection myConnection = Main.getDB().getConnection();
    private String name;
    private String description;


    private int category_id_fk;
    private int can_replace_id_fk;

    /**
     * Constructor that initialises the object
     * @param name
     * @param description
     * @param category_id_fk the category the exercise shoudl be a part of
     */
    public Exercise(String name, String description, int category_id_fk){
        this.name = name;
        this.description = description;
        this.category_id_fk = category_id_fk;
    }

    /**
     * Constructor that initialises the object that can replace another exercise
     * @param name
     * @param description
     * @param category_id_fk the category the exercise shoudl be a part of
     * @param can_replace_id_fk the id of the exercise this exercise can replace
     */
    public Exercise(String name, String description, int category_id_fk, int can_replace_id_fk){
        this.name = name;
        this.description = description;
        this.category_id_fk = category_id_fk;
        this.can_replace_id_fk = can_replace_id_fk;
    }


    /**
     * Function for storing exercise that can replace another exercise
     */
    public void storeCanReplaceExercise(){
        try{
            String sql = "INSERT INTO Can_replace_exercise(exercise_id_fk,can_replace_id_fk) VALUES(?,?)";
            PreparedStatement ps = myConnection.prepareStatement(sql);
            ps.setInt(1,Exercise.fetchBiggestId());
            ps.setInt(2,this.can_replace_id_fk);
            ps.execute();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }


    /**
     * Function for getting the biggest id from exercises in the database
     * @return the biggest id
     */
    public static int fetchBiggestId() {
        int id = -1;
        try {
            String sql  = "SELECT MAX(exercise_id) as maks from Exercise";
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


    /**
     * Function for storing Exercise in the database
     */
    public void storeExercise(){
        try{
            String sql = "INSERT INTO Exercise(name,description,category_id_fk) VALUES(?,?,?)";
            PreparedStatement ps = myConnection.prepareStatement(sql);
            ps.setString(1,this.name);
            ps.setString(2,this.description);
            ps.setInt(3,this.category_id_fk);
            ps.execute();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }


    /**
     * Function for getting all the categories that are stored in the database
     * @return ArrayList with all the exercises
     */
    public static ArrayList<String> fetchAllExercises(){
        ArrayList<String> array = new ArrayList<>();
        try{
            String sql = "SELECT exercise_id as id, name from Exercise";
            PreparedStatement ps = myConnection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                array.add(String.valueOf(id)+","+name);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return array;
    }


    /**
     * Function that gets the name of the exercise
     * @return name of exercise
     */
    public String getName() {
        return name;
    }

    /**
     * Function for setting the name of the exercise
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

}
