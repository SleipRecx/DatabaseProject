package model;


import controller.Main;

import java.sql.*;
import java.util.ArrayList;

public class Exercise {
    protected static Connection myConnection = Main.getDB().getConnection();


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

}
