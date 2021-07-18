/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author Tago
 * @author Tobar
 * @author Rivera
 */
public class EtiquetaNumerico extends Etiqueta {
    private double inferior;
    private double superior;

    public EtiquetaNumerico(double inferior, double superior, String name) {
        super(name);
        this.inferior = inferior;
        this.superior = superior;
    }
    public boolean contains(double valor){
        if(valor>=this.inferior && valor<=superior){
            return true;
        }
        return false;
    }
    @Override
    public boolean isintersected(Etiqueta et) {
        if(et instanceof EtiquetaNumerico){
            EtiquetaNumerico etn=(EtiquetaNumerico)et;
            if((etn.inferior>=this.inferior && etn.inferior<=this.superior) || (etn.superior>=this.inferior && etn.superior<=superior)){
                return true;
            }
        }
        return false;
    }

    public double getInferior() {
        return inferior;
    }

    public void setInferior(double inferior) {
        this.inferior = inferior;
    }

    public double getSuperior() {
        return superior;
    }

    public void setSuperior(double superior) {
        this.superior = superior;
    }
    
    
}
