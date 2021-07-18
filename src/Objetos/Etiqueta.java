/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.util.ArrayList;

/**
 *
 * @author Tago
 * @author Tobar
 * @author Rivera
 */
public abstract class Etiqueta {
    private String name;

    public Etiqueta(String name) {
        this.name = name;
    }
    /**
     * Este metodo sirve para ver si el rango de la etiqueta intersecta con otra etiquetan evitando ese error
     * @param etiquetas lista de eqtiquetas
     * @return boolean
     */
    public boolean hasintersection(ArrayList<Etiqueta> etiquetas){
        boolean intersection=false;
        for(Etiqueta et:etiquetas){
            intersection=this.isintersected(et);
        }
        return intersection;
    }
    /**
     * Metodo abstracto que implementas las clases hijas para decir si se intersectan con otra etiqueta o no
     * @param et Etiqueta
     * @return boolean
     */
    public abstract boolean isintersected(Etiqueta et);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
