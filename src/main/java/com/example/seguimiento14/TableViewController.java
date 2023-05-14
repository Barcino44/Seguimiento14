package com.example.seguimiento14;
import com.example.seguimiento14.Model.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.*;

import static com.example.seguimiento14.RegisterController.arr;


public class TableViewController implements Initializable {

    static double diference=0;
    @FXML
    private TableColumn<Object, LocalDate> FechaTC;
    @FXML
    private TableColumn<Object, String> DescriptionTC;

    @FXML
    private TableView<Object> Tableview;

    @FXML
    private TableColumn<Object, String> TipoTC;

    @FXML
    private TableColumn<Object, Integer> ValueTC;
    @FXML
    private Button registrarBTN;
    @FXML
    private Label diferenceLabel;

    @FXML
    private Button verAmbosBTN;

    @FXML
    private Button verGastosBTN;

    @FXML
    private Button verIngresosBTN;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        DescriptionTC.setCellValueFactory(new PropertyValueFactory<>("description"));
        ValueTC.setCellValueFactory(new PropertyValueFactory<>("amount"));
        TipoTC.setCellValueFactory(new PropertyValueFactory<>("type"));
        FechaTC.setCellValueFactory(new PropertyValueFactory<>("date"));

        double gastos=0;
        double ingresos=0;
        for (int i=0;i<arr.size();i++){
            if(arr.get(i)instanceof Gasto) {
                gastos = gastos + ((Gasto) arr.get(i)).getAmount();
            }
            else if(arr.get(i)instanceof Ingreso){
                ingresos=ingresos + ((Ingreso) arr.get(i)).getAmount();
            }
        }
        diference = ingresos-gastos;

        diferenceLabel.setText(String.valueOf(diference));

        registrarBTN.setOnAction(event -> {
            HelloApplication.openWindow("Register.fxml"); //Esta me abre el otro fxml, junto con su controlador.
            Stage stage = (Stage) registrarBTN.getScene().getWindow(); //Literalmente, me cierro a mi mismo.
            stage.close();
        });
        verGastosBTN.setOnAction(event -> {
            Tableview.setItems(
            GastoList.getInstance().orderGastosByDate());
        });
        verIngresosBTN.setOnAction(event -> {
            Tableview.setItems(
                    IngresoList.getInstance().orderIngresosByDate());
        });
        verAmbosBTN.setOnAction(event -> {
            Tableview.setItems(
                    BothList.getInstance().orderIngresosByDate());
        });
   }
}