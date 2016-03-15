package controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import model.*;

import java.sql.Date;

public class sessionsController {

    public TextField ventilationField;
    public TextField spectatorsField;
    public TextField tempField;
    public TextField weatherField;
    public ChoiceBox<String> choiceBox;
    public DatePicker datePicker;
    public TextField durationField;
    public Label spectatorsLable;
    public Label ventilationLable;
    public Label tempLable;
    public Label weatherLable;
    public TextField performanceField;
    public TextField shapeField;
    public TextField purposeField;
    public TextArea tipsField;


    public void initialize(){
        choiceBox.setItems(FXCollections.observableArrayList("Outside Session", "Inside Session"));
        choiceBox.valueProperty().setValue("Outside Session");
        choiceBox.valueProperty().addListener((obj,oldValue,newValue) -> {
            if(newValue.equals("Inside Session")){
                weatherField.setVisible(false);
                tempField.setVisible(false);
                weatherLable.setVisible(false);
                tempLable.setVisible(false);
                spectatorsField.setVisible(true);
                spectatorsLable.setVisible(true);
                ventilationField.setVisible(true);
                ventilationLable.setVisible(true);
            }
            else{
                weatherField.setVisible(true);
                tempField.setVisible(true);
                weatherLable.setVisible(true);
                tempLable.setVisible(true);
                spectatorsField.setVisible(false);
                spectatorsLable.setVisible(false);
                ventilationField.setVisible(false);
                ventilationLable.setVisible(false);
            }
        });

    }

    public void buttonPressed(ActionEvent actionEvent) {

        Date date = Date.valueOf(datePicker.getValue());
        int duration = Integer.parseInt(durationField.textProperty().getValue());
        int id;

        if(choiceBox.valueProperty().getValue().equals("Inside Session")){
            String ventilation = ventilationField.textProperty().getValue();
            int spectators = Integer.parseInt(spectatorsField.textProperty().getValue());
            Inside_Session session = new Inside_Session(date,duration,spectators,ventilation);
            session.storeSession();
            id = session.getBiggestId();
            session.setSession_id_fk(id);
            session.storeInsideSession();

        }
        else{
            String condition = weatherField.getText();
            Double temp = Double.parseDouble(tempField.getText());
            Outdoor_Session session = new Outdoor_Session(date,duration,temp,condition);
            session.storeSession();
            id = session.getBiggestId();
            session.setSession_id_fk(id);
            session.storeOutdoorSession();
        }
        int performance = Integer.parseInt(performanceField.getText());
        int shape = Integer.parseInt(shapeField.getText());
        String purpose = purposeField.getText();
        String tips = tipsField.getText();
        Note note = new Note(shape,performance,purpose,tips,id);
        note.storeNote();
    }
}
