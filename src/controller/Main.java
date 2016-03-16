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


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../view/main.fxml"));
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

    /*
    Chill Query
    select session_id,Exercise.name,sets, weight,reps from `Result`
    join Exercise on exercise_id = exercise_id_fk
    join Training_session on session_id = training_session_id_fk
    join `Strength_condition_to_result` ind on ind.result_id_fk = `result_id`
    group by training_session_id_fk,exercise_id

     */
    public static DB_Setup getDB() {
        return db;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
