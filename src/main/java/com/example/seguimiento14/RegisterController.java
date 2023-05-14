package com.example.seguimiento14;
import com.example.seguimiento14.Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

    static ArrayList<Object> arr = new ArrayList<>();
    @FXML
    private Button ToTableViewBTN;
    @FXML
    private Label DiferenceLabel;
    @FXML
    private DatePicker FechaDP;

    @FXML
    private Button AddBTN;

    @FXML
    private TextField DescriptionTF;

    @FXML
    private ChoiceBox<String> TypeCB;

    @FXML
    private TextField valueTF;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TypeCB.getItems().add("Gasto");
        TypeCB.getItems().add("Ingreso");
        FechaDP.setEditable(false);
        DiferenceLabel.setText(String.valueOf(TableViewController.diference));

        ToTableViewBTN.setOnAction(action->{
            HelloApplication.openWindow("TableView.fxml"); //Esta me abre el otro fxml, junto con su controlador.
            Stage stage = (Stage) AddBTN.getScene().getWindow(); //Literalmente, me cierro a mi mismo.
            stage.close();
        });

        AddBTN.setOnAction(action->{
            if(TypeCB.getValue()!=null&&DescriptionTF.getText()!=null&&valueTF.getText()!=null) {
                if (Double.parseDouble(valueTF.getText()) > 0) {
                    if (TypeCB.getValue().equals("Gasto")) {
                        Gasto gasto = new Gasto(DescriptionTF.getText(), TypeCB.getValue(), Double.parseDouble(valueTF.getText()), FechaDP.getValue());
                        GastoList.getInstance().getGastos().add(gasto);
                        BothList.getInstance().getGastosAndIngresos().add(gasto);
                        arr.add(gasto);
                    } else {
                        Ingreso ingreso = new Ingreso(DescriptionTF.getText(), TypeCB.getValue(), Double.parseDouble(valueTF.getText()), FechaDP.getValue());
                        IngresoList.getInstance().getIngresos().add(ingreso);
                        BothList.getInstance().getGastosAndIngresos().add(ingreso);
                        arr.add(ingreso);
                    }
                    HelloApplication.openWindow("TableView.fxml"); //Esta me abre el otro fxml, junto con su controlador.
                    Stage stage = (Stage) AddBTN.getScene().getWindow(); //Literalmente, me cierro a mi mismo.
                    stage.close();
                    }
                else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setContentText("No puedes añadir valores negativos");
                    alert.showAndWait();
                    }
                }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Faltan campos por llenar");
                alert.showAndWait();
            }
        });
    }
}
