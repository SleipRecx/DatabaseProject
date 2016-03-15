package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.text.Text;

public class resultsController {

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
    public ComboBox sessionChoice;

    public void initialize() {

        ToggleGroup group = new ToggleGroup();
        strengthButton.setToggleGroup(group);
        enduranceButton.setToggleGroup(group);
        strengthButton.setSelected(true);

        enduranceButton.selectedProperty().addListener((obj,oldValue,newValue)->{
            if(newValue) {
                timeLabel.setVisible(true);
                timeField.setVisible(true);
                distanceLabel.setVisible(true);
                distanceField.setVisible(true);
                repsLabel.setVisible(false);
                repsField.setVisible(false);
                weigthField.setVisible(false);
                weigthLabel.setVisible(false);
            }else{
                timeLabel.setVisible(false);
                timeField.setVisible(false);
                distanceLabel.setVisible(false);
                distanceField.setVisible(false);
                repsLabel.setVisible(true);
                repsField.setVisible(true);
                weigthField.setVisible(true);
                weigthLabel.setVisible(true);
            }
        });
    }

    public void fetchSessions(){

        
    }

    public void buttonPressed(ActionEvent actionEvent) {

    }
}
