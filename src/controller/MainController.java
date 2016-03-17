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

    /**
     *
     * @param location fxml-location that calls the method
     * Attaches all controllers to mainController
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sessionsController.attachMain(this);
        exercisesController.attachMain(this);
        resultsController.attachMain(this);
        resultTableController.attachMain(this);
    }

    /**
     * Updates exercises with filling the choiceboxes
     */
    public void updateExercises() {
        resultsController.fillExerciseBox();
        exercisesController.fillExerciseChoiceBoxes();
        resultTableController.fillData();
    }

    /**
     * Updates categories with filling the choiceboxes
     */
    public void updateCategories() {
        exercisesController.fillChoiceBoxes();

    }

    /**
     * Updates sessions with filling the choiceboxes
     */
    public void updateSessions() {
        resultsController.fillSessionsBox();
        resultTableController.fillBox();
    }


}
