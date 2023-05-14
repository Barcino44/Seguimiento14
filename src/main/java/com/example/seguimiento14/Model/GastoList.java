package com.example.seguimiento14.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class GastoList {
    private ObservableList<Object> gastos = FXCollections.observableArrayList();

    //Constructor privado
    public ObservableList<Object> getGastos() {
        return gastos;
    }

    public void setGastos(ObservableList<Object> gastos) {
        this.gastos = gastos;
    }

    //Patron singleton, solo puedo crear un objeto "Contact list" y solo lo puede crear esta clase.

    private GastoList(){} //Solo lo puedo crear objetos en esta clase, por eso el private.

    private static GastoList instance = null;
    public static GastoList getInstance(){ //Mecanismo para crear la instancia de la clase.
        if(instance==null){
            instance=new GastoList(); //Solo puedo crear una instancia (Por ello el if) (Solo una lista de contactos)
        }
        return instance;
    }
    public ObservableList<Object> orderGastosByDate(){
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < gastos.size() - 1; i++) {
                if(gastos.get(i)instanceof Gasto){
                    if ((((Gasto) gastos.get(i)).orderByDate()<((Gasto)gastos.get(i + 1)).orderByDate())) {
                        swapped = true;
                        Object current = gastos.get(i);
                        Object next = gastos.get(i + 1);
                        gastos.set(i, next);
                        gastos.set(i + 1, current);
                    }
                }
            }
        } while (swapped);
        return gastos;
    }
}
