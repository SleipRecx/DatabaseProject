package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static DB_Setup db = new DB_Setup("jdbc:mysql://mysql.stud.ntnu.no/markua_treningprosjekt","markua_dbproject","dbproject");


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("DB_project");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        if (db != null) {
            db.closeConnection();
        }
    }

    public static DB_Setup getDB() {
        return db;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
