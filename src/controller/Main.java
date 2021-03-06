package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.DB_Setup;

public class Main extends Application {

    private static DB_Setup db = new
    DB_Setup("jdbc:mysql://mysql.stud.ntnu.no/markua_treningprosjekt","markua_dbproject","dbproject");

    /**
     * Starts the application
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../view/main.fxml"));
        primaryStage.setTitle("DB_project");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }

    /**
     * stops the database-connection
     */
    @Override
    public void stop() throws Exception {
        if (db != null) {
            db.closeConnection();
        }
    }

    /**
     * @return database
     */
    public static DB_Setup getDB() {
        return db;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
