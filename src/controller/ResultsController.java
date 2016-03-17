package controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import model.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;


public class ResultsController implements Initializable {
    public TextField timeField;
    public TextField distanceField;
    public Label timeLabel;
    public Label distanceLabel;
    public Text messageLable;
    public Label repsLabel;
    public Label weigthLabel;
    public TextField repsField;
    public TextField weigthField;
    public RadioButton strengthButton;
    public RadioButton enduranceButton;
    public ComboBox<String> sessionChoice;
    public HashMap<String,Integer> sessionMap;
    public ComboBox<String> exerciseChoice;
    private HashMap<String,Integer> exerciseMap;
    public TextField setsField;
    public Label setsLabel;
    private MainController main;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ToggleGroup group = new ToggleGroup();
        sessionMap = new HashMap<>();
        exerciseMap = new HashMap<>();
        strengthButton.setToggleGroup(group);
        enduranceButton.setToggleGroup(group);
        strengthButton.setSelected(true);
        fillSessionsBox();
        fillExerciseBox();
        enduranceButton.selectedProperty().addListener((obj,oldValue,newValue)->{
            if(newValue) {
                timeLabel.setVisible(true);
                timeField.setVisible(true);
                distanceLabel.setVisible(true);
                distanceField.setVisible(true);
                setsField.setVisible(false);
                setsLabel.setVisible(false);
                repsLabel.setVisible(false);
                repsField.setVisible(false);
                weigthField.setVisible(false);
                weigthLabel.setVisible(false);
            }else{
                timeLabel.setVisible(false);
                timeField.setVisible(false);
                distanceLabel.setVisible(false);
                distanceField.setVisible(false);
                setsLabel.setVisible(true);
                setsField.setVisible(true);
                repsLabel.setVisible(true);
                repsField.setVisible(true);
                weigthField.setVisible(true);
                weigthLabel.setVisible(true);
            }
        });
    }


    protected void fillSessionsBox(){
        sessionChoice.setItems(FXCollections.observableArrayList(Session.fecthAllSessionsString()));
        ArrayList<String> array = Session.fecthAllSessionsString();
        array.forEach(s->{
            int id = Integer.parseInt(s.split("-")[0]);
            sessionMap.put(s,id);
        });
    }

    protected void fillExerciseBox(){
        ArrayList<String> array = Exercise.fetchAllExercises();
        ArrayList<String> nameArray = new ArrayList<>();
        array.forEach(s->{
            int id = Integer.parseInt(s.split(",")[0]);
            String name = s.split(",")[1];
            exerciseMap.put(name,id);
            nameArray.add(name);
        });
        exerciseChoice.setItems(FXCollections.observableArrayList(nameArray));
    }

    public void buttonPressed(ActionEvent actionEvent) {
        int exercise_id_fk = exerciseMap.get(exerciseChoice.getValue());
        int session_id_fk = sessionMap.get(sessionChoice.getValue());
        Result result = new Result(exercise_id_fk,session_id_fk);
        if(enduranceButton.isSelected()){

            Endurance_to_result endurance_result = new Endurance_to_result(exercise_id_fk,session_id_fk,
                    Double.parseDouble(distanceField.getText()),
                    Integer.parseInt(timeField.getText()));
            result.storeResult();
            endurance_result.setResult_id_fk(Result.getBiggestId());
            endurance_result.storeEndurance_to_result();
        }
        else{
            Strength_condition_to_result strength_condition_result = new Strength_condition_to_result(exercise_id_fk,session_id_fk,
                    Integer.parseInt(weigthField.getText()),
                    Integer.parseInt(repsField.getText()),
                    Integer.parseInt(setsField.getText()));
            result.storeResult();
            strength_condition_result.setResult_id_fk(Result.getBiggestId());
            strength_condition_result.storeStrength_condition_to_result();

        }
        clearFields();
    }

    private void clearFields() {
        timeField.setText("");
        distanceField.setText("");
        setsField.setText("");
        repsField.setText("");
        weigthField.setText("");
        exerciseChoice.setValue(null);
        sessionChoice.setValue(null);
    }


    public void attachMain(MainController controller) {
        this.main = controller;
    }


}
