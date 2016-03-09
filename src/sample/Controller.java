package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Controller {
    private Connection myConnection;
    private Statement myStatement;

    @FXML ListView<String> list;
    @FXML Button button;
    @FXML Button addButton;
    @FXML TextField input;

    public void initialize(){
        DB_Setup db = Main.getDB();
        this.myConnection = db.getConnection();
        createStatement();
        getAllPersons();
    }


    private void createStatement(){
        try {
            this.myStatement = myConnection.createStatement();
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Statement could not be created");
        }
    }

    private void getAllPersons(){
        ObservableList<String> items;
        items = FXCollections.observableArrayList();
        try {
            ResultSet result = myStatement.executeQuery("SELECT name FROM test");
            while (result.next()){
              items.add(result.getString("name"));
            }
            list.setItems(items);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void refresh() {
        list.getItems().clear();
        getAllPersons();
    }

    public void addButtonPressed() {
        String value = input.getText();
        String sql = String.format("INSERT INTO test(name) VALUES ('%s')", value);
        try {
            myStatement.executeUpdate(sql);
            refresh();
            input.clear();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
