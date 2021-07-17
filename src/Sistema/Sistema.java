/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema;

import Objetos.Sensor;
import Recursos.ManejoArchivo;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Tago
 */
public class Sistema {

    public static void main(String[] args) {
        // TODO code application logic here

    }

    public static ArrayList<Sensor> cargarSensores() {
        ArrayList<Sensor> sensores = ManejoArchivo.LeeFichero("data.csv");
        return sensores;
    }
}
