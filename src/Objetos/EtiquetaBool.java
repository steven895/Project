/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author Tago
 */
public class EtiquetaBool extends Etiqueta{
    private boolean valor;

    public EtiquetaBool(boolean valor, String name) {
        super(name);
        this.valor = valor;
    }

    @Override
    public boolean isintersected(Etiqueta et) {
        if(et instanceof EtiquetaBool){
            EtiquetaBool etb= (EtiquetaBool)et;
            return etb.valor==this.valor;
        }
        return false;
    }

    public boolean isValor() {
        return valor;
    }

    public void setValor(boolean valor) {
        this.valor = valor;
    }
    
}
