/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author Tago
 */
public class Sensor {

    private String id;
    //private static String[] propiedades={""};
    private ArrayList<Observacion> observaciones;

    public Sensor(String id) {
        this.id = id;
        this.observaciones = new ArrayList();
    }
    public void addObservacion(Observacion ob){
        this.observaciones.add(ob);
    }
    @Override
    public boolean equals(Object obj) {
      if(obj instanceof Sensor){
          Sensor s= (Sensor)obj;
          if( s.id.equals(this.id)){
          return true;
          }
      }
      return false;
    }

    @Override
    public String toString() {
        return "Sensor{" + "id=" + id + ", observaciones=" + observaciones.size() + '}';
    }
    
}
