package com.example.seguimiento14.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class IngresoList {
        private ObservableList<Object> ingresos = FXCollections.observableArrayList();

        //Constructor privado
        public ObservableList<Object> getIngresos() {
            return ingresos;
        }

        public void setIngresos(ObservableList<Object> ingresos) {
            this.ingresos= ingresos;
        }

        //Patron singleton, solo puedo crear un objeto "Contact list" y solo lo puede crear esta clase.

        private IngresoList(){} //Solo lo puedo crear objetos en esta clase, por eso el private.

        private static IngresoList instance = null;
        public static IngresoList getInstance(){ //Mecanismo para crear la instancia de la clase.
            if(instance==null){
                instance=new IngresoList(); //Solo puedo crear una instancia (Por ello el if) (Solo una lista de contactos)
            }
            return instance;
        }
    public ObservableList<Object> orderIngresosByDate(){
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < ingresos.size() - 1; i++) {
                if(ingresos.get(i)instanceof Ingreso){
                    if ((((Ingreso) ingresos.get(i)).orderByDate()<((Ingreso)ingresos.get(i + 1)).orderByDate())) {
                        swapped = true;
                        Object current = ingresos.get(i);
                        Object next = ingresos.get(i + 1);
                        ingresos.set(i, next);
                        ingresos.set(i + 1, current);
                    }
                }
            }
        } while (swapped);
        return ingresos;
    }
}
