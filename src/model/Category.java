package model;

import controller.Main;

import java.sql.*;
import java.util.ArrayList;

/**
 * Class to represent and store categories
 */
public class Category {
    private int category_id;
    private String type;
    private int parent_category_id_fk;
    private static Connection myConnection = Main.getDB().getConnection();

    /**
     * Constructor for making a new category
     * @param type
     */
    public Category(String type){
        this.type = type;
    }

    /**
     * Constructor for making a category and adding it as a sub-category
     * @param type
     * @param parent_category_id_fk
     */
    public Category(String type, int parent_category_id_fk){
        this.type = type;
        this.parent_category_id_fk = parent_category_id_fk;
    }

    /**
     * Method for getting all the categories stored in the database
     * @return ArrayList with all the categories
     */
    public static ArrayList<String> fetchAllCategories(){
        ArrayList<String> array = new ArrayList<>();
        try{
            PreparedStatement ps = myConnection.prepareStatement("SELECT * FROM Category");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int id= rs.getInt("category_id");
                String name = rs.getString("type");
                array.add(String.valueOf(id)+","+name);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return array;
    }

    /**
     * Method for storing a category to the db
     */
    public void storeCategory(){
        try {
            PreparedStatement ps = myConnection.prepareStatement("INSERT INTO Category(type) VALUES (?)");
            ps.setString(1,type);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method for storing a category that is a part of another category
     */
    public void storeCategory_belongs(){
        try {
            String sql = "INSERT INTO Category_belongs(parent_category_id_fk,category_id_fk) VALUES (?,?)";
            PreparedStatement ps = myConnection.prepareStatement(sql);
            ps.setInt(1,parent_category_id_fk);
            ps.setInt(2,Category.getBiggestId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method for getting the biggest ID from the Category table in the database
     * @return the biggest id
     */
    public static int getBiggestId(){
        int id = -1;
        try {
            String sql  = "SELECT MAX(category_id) as maks from Category";
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
