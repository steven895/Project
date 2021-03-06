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
 * @author Tobar
 * @author Rivera
 */
public class Sensor {

    private String id;
    //private static String[] propiedades={""};
    private ArrayList<Observacion> observaciones;

    public Sensor(String id) {
        this.id = id;
        this.observaciones = new ArrayList();
    }
    /**
     * Este metodo agrega observaciones al sensor
     * @param ob 
     */
    public void addObservacion(Observacion ob){
        this.observaciones.add(ob);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Observacion> getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(ArrayList<Observacion> observaciones) {
        this.observaciones = observaciones;
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
