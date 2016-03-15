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
    }

    public void updateCategories() {
        exercisesController.fillCategoriesBox();
        exercisesController.fillPartOfBox();
    }

    public void updateSessions() {
        resultsController.fillSessionsBox();
    }
}
