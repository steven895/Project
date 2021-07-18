/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notificacionsensores;

import Objetos.Sensor;
import Recursos.ManejoArchivo;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Tago
 */
public class NotificacionSensores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Date date= new Date();
        date.setYear(120);
        System.out.println(date);
        System.out.println(date.getDate());
        System.out.println(date.getMonth());
        System.out.println(date.getYear());
        String cadena="Hola pato /: lobo / casa";
        String [] separado=cadena.split("/");
        for(String cad: separado){
            System.out.println(cad);
        }
        System.out.println("Pensando****");
        ArrayList<Sensor> sensores=ManejoArchivo.LeeFichero("data.csv");
        for(Sensor s:sensores){
            System.out.println(s);
        }
        System.out.println("Terminado****");
        Date date2= new Date();
        System.out.println(date2);
        System.out.println(date2.after(date));
    }
    
}
