package controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import model.*;

public class ExercisesController implements Initializable{

    public ComboBox<String> replaceChoice;
    public ComboBox<String> partOfChoice;
    public TextField categoryNameField;
    public ComboBox<String> categoryChoice;
    public TextField exerciseDescField;
    public TextField exerciseNameField;
    public HashMap<String, Integer> categoryMap;
    public HashMap<String, Integer> replaceMap;
    private MainController main;


    /**
     * Initializes HashMaps and runs fucntions to fill the choiceboxes.
     * @param location fxml-location that calls the method
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        categoryMap = new HashMap<>();
        replaceMap = new HashMap<>();
        fillChoiceBoxes();
        fillExerciseChoiceBoxes();
    }

    /**
     * Fills choicebox "replaceChoice"
     */
    public void fillExerciseChoiceBoxes(){
        ArrayList<String> exerciseNameArray = new ArrayList<>();
        ArrayList<String> array = Exercise.fetchAllExercises();
        array.forEach(s->{
            int id = Integer.parseInt(s.split(",")[0]);
            String name = s.split(",")[1];
            replaceMap.put(name,id);
            exerciseNameArray.add(name);
        });
        replaceChoice.setItems(FXCollections.observableArrayList(exerciseNameArray));
    }

    /**
     * Fills choiceboxes "categoryChoice" and "partOfChoice"
     */
    public void fillChoiceBoxes() {
        ArrayList<String> categoryNameArray = new ArrayList<>();
        ArrayList<String> array = Category.fetchAllCategories();
        array.forEach(string-> {
            int id = Integer.parseInt(string.split(",")[0]);
            String name = string.split(",")[1];
            categoryMap.put(name,id);
            categoryNameArray.add(name);
        });
        categoryChoice.setItems(FXCollections.observableArrayList(categoryNameArray));
        partOfChoice.setItems(FXCollections.observableArrayList(categoryNameArray));
    }

    /**
     *
     * @param actionEvent the events that calls the method
     * Adds exercise after filling in info
     */
    public void addExercisePressed(ActionEvent actionEvent) {
        String name = exerciseNameField.getText();
        String desc = exerciseDescField.getText();
        int categoryId = categoryMap.get(categoryChoice.getValue());
        if(replaceChoice.getValue()!=null){
            int replaceId = replaceMap.get(replaceChoice.getValue());
            Exercise exercise = new Exercise(name,desc,categoryId,replaceId);
            exercise.storeExercise();
            exercise.storeCanReplaceExercise();
        }
        else {
            Exercise exercise = new Exercise(name,desc,categoryId);
            exercise.storeExercise();
        }
        exerciseNameField.setText("");
        exerciseDescField.setText("");
        categoryChoice.setValue(null);
        replaceChoice.setValue(null);
        main.updateExercises();

    }

    /**
     *
     * @param actionEvent the events that calls the method
     * Adds category/partOf-category after filling in info
     */
    public void addCategoryPressed(ActionEvent actionEvent) {
        String name = categoryNameField.getText();
        if(partOfChoice.getValue()!=null){
            int id = categoryMap.get(partOfChoice.getValue());
            Category category = new Category(name,id);
            category.storeCategory();
            category.storeCategory_belongs();
        }
        else{
            Category category = new Category(name);
            category.storeCategory();
        }
        categoryNameField.setText("");
        partOfChoice.setValue(null);
        main.updateCategories();
    }

    /**
     *
     * @param controller is the main controller
     * Attaches the controller to the main controller
     */
    public void attachMain(MainController controller) {
        this.main = controller;
    }



}
