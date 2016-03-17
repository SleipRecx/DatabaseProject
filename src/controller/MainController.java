package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML ExercisesController exercisesController;
    @FXML SessionsController sessionsController;
    @FXML ResultsController resultsController;
    @FXML ResultTableController resultTableController;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sessionsController.attachMain(this);
        exercisesController.attachMain(this);
        resultsController.attachMain(this);
        resultTableController.attachMain(this);
    }

    public void updateExercises() {
        resultsController.fillExerciseBox();
        exercisesController.fillExerciseChoiceBoxes();
        resultTableController.fillData();
    }

    public void updateCategories() {
        exercisesController.fillChoiceBoxes();

    }

    public void updateSessions() {
        resultsController.fillSessionsBox();
        resultTableController.fillBox();
    }


}
