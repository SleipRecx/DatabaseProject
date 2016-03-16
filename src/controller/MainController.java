package controller;

import javafx.fxml.FXML;

public class MainController {

    @FXML ExercisesController exercisesController;
    @FXML SessionsController sessionsController;
    @FXML ResultsController resultsController;



    public void initialize() {
        sessionsController.attachMain(this);
        exercisesController.attachMain(this);
        resultsController.attachMain(this);
    }


    public void updateExercises() {
        resultsController.fillExerciseBox();
        exercisesController.fillExerciseChoiceBoxes();
    }

    public void updateCategories() {
        exercisesController.fillChoiceBoxes();

    }

    public void updateSessions() {
        resultsController.fillSessionsBox();
    }
}
