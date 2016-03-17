package controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Session;
import model.Strength_condition_to_result;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class ResultTableController implements Initializable{

    public TableView<Strength_condition_to_result> table;
    public TableColumn<Strength_condition_to_result,String> nameColumn;
    public TableColumn<Strength_condition_to_result,Integer> setsColumn;
    public TableColumn<Strength_condition_to_result,Integer> weightColumn;
    public TableColumn<Strength_condition_to_result,Integer> repsColumn;
    public ComboBox<String> comboBox;
    private HashMap<String,Integer> map = new HashMap<>();
    private ObservableList<Strength_condition_to_result> list;
    private MainController main;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fillBox();
        comboBox.valueProperty().addListener((obj,oldValue,newValue)->{
            list = FXCollections.observableArrayList(Strength_condition_to_result.fetchResultWithId(map.get(newValue)));
            fillData();
        });

    }

    public void fillBox(){
        ArrayList<String> result = Session.fecthAllSessionsString();
        result.forEach(s->{
            int id = Integer.valueOf(s.split("-")[0]);
            map.put(s,id);
        });
        comboBox.setItems(FXCollections.observableArrayList(result));
    }

    public void fillData(){
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        setsColumn.setCellValueFactory(new  PropertyValueFactory<>("sets"));
        repsColumn.setCellValueFactory(new  PropertyValueFactory<>("reps"));
        weightColumn.setCellValueFactory(new  PropertyValueFactory<>("weight"));
        table.setItems(list);
    }

    public void attachMain(MainController main){
        this.main = main;
    }

}
