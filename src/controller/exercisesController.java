package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class ExercisesController {


    public ComboBox replaceBox;
    public ComboBox partOfBox;
    public TextField categoryNameField;
    public ComboBox exerciseCategoryBox;
    public TextField exerciseDescField;
    public TextField exerciseNameField;
    private MainController main;



    public void fillCategoriesBox() {

    }

    public void fillPartOfBox(){

    }

    public void addExercisePressed(ActionEvent actionEvent) {
        main.updateExercises();

    }

    public void addCategoryPressed(ActionEvent actionEvent) {
      main.updateCategories();
    }

    public void attachMain(MainController controller) {
        this.main = controller;
    }


}
