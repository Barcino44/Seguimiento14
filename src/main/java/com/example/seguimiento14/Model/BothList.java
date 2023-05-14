package com.example.seguimiento14.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BothList {
    private ObservableList<Object> gastosAndIngresos = FXCollections.observableArrayList();

    //Constructor privado
    public ObservableList<Object> getGastosAndIngresos() {
        return gastosAndIngresos;
    }

    public void setGastos(ObservableList<Object> gastosAndIngresos) {
        this.gastosAndIngresos = gastosAndIngresos;
    }

    //Patron singleton, solo puedo crear un objeto "Contact list" y solo lo puede crear esta clase.

    private BothList() {
    } //Solo lo puedo crear objetos en esta clase, por eso el private.

    private static BothList instance = null;

    public static BothList getInstance() { //Mecanismo para crear la instancia de la clase.
        if (instance == null) {
            instance = new BothList(); //Solo puedo crear una instancia (Por ello el if) (Solo una lista de contactos)
        }
        return instance;
    }
    public ObservableList<Object> orderIngresosByDate(){
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < gastosAndIngresos.size() - 1; i++) {
                if(gastosAndIngresos.get(i)instanceof Movements){
                    if (((Movements) gastosAndIngresos.get(i)).orderByDate()<((Movements)gastosAndIngresos.get(i + 1)).orderByDate()) {
                        swapped = true;
                        Object current = gastosAndIngresos.get(i);
                        Object next = gastosAndIngresos.get(i + 1);
                        gastosAndIngresos.set(i, next);
                        gastosAndIngresos.set(i + 1, current);
                    }
                }
            }
        } while (swapped);
        return gastosAndIngresos;
    }
}
