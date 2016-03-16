package model;


import controller.Main;
import java.sql.*;
import java.util.ArrayList;

public class Exercise {
    protected static Connection myConnection = Main.getDB().getConnection();
    private String name;
    private String description;


    private int category_id_fk;
    private int can_replace_id_fk;

    public Exercise(String name, String description, int category_id_fk){
        this.name = name;
        this.description = description;
        this.category_id_fk = category_id_fk;
    }

    public Exercise(String name, String description, int category_id_fk, int can_replace_id_fk){
        this.name = name;
        this.description = description;
        this.category_id_fk = category_id_fk;
        this.can_replace_id_fk = can_replace_id_fk;
    }


    public void storeCanReplaceExercise(){
        try{
            String sql = "INSERT INTO Can_replace_exercise(can_replace_id_fk) VALUES(?)";
            PreparedStatement ps = myConnection.prepareStatement(sql);
            ps.setInt(1,this.can_replace_id_fk);
            ps.execute();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

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


    public int getCategory_id_fk() {
        return category_id_fk;
    }
    public void setCategory_id_fk(int category_id_fk) {
        this.category_id_fk = category_id_fk;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }


}
