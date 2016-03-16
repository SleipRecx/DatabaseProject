package model;

import controller.Main;

import java.sql.*;
import java.util.ArrayList;

public class Category {
    private int category_id;
    private String type;
    private int parent_category_id_fk;
    private static Connection myConnection = Main.getDB().getConnection();

    public Category(String type){
        this.type = type;
    }

    public Category(String type, int parent_category_id_fk){
        this.type = type;
        this.parent_category_id_fk = parent_category_id_fk;
    }

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


    public void storeCategory(){
        try {
            PreparedStatement ps = myConnection.prepareStatement("INSERT INTO Category(type) VALUES (?)");
            ps.setString(1,type);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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

    public int getCategory_id() {return category_id;}
    public void setCategory_id(int category_id) {this.category_id = category_id;}
    public String getType() {return type;}
    public void setType(String type) {this.type = type;}
    public int getParent_category_id_fk() {return parent_category_id_fk;}
    public void setBelongs_to(int parent_category_id_fk) {this.parent_category_id_fk = parent_category_id_fk;}


}
