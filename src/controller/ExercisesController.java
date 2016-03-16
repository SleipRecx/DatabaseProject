package controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import java.util.ArrayList;
import java.util.HashMap;
import model.*;

public class ExercisesController {

    public ComboBox replaceChoice;
    public ComboBox partOfChoice;
    public TextField categoryNameField;
    public ComboBox categoryChoice;
    public TextField exerciseDescField;
    public TextField exerciseNameField;
    public HashMap<String, Integer> categoryMap;
    public HashMap<String, Integer> partOfMap;
    public HashMap<String, Integer> replaceMap;
    private MainController main;

    public void fillChoiceBoxes() {
        ArrayList<String> categoryNameArray = new ArrayList<>();
        ArrayList<String> array = Category.fecthAllCategories();
        array.forEach(c-> {
            int id = Integer.parseInt(c.split(",")[0]);
            String name = c.split(",")[1];
            categoryMap.put(name, id);
            categoryNameArray.add(name);
        });
        categoryChoice.setItems(FXCollections.observableArrayList(Category.categoryNameArray()));
        partOfChoice.setItems(FXCollections.observableArrayList(Category.categoryNameArray()));
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
