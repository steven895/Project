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
 */
public abstract class Notificacion {
    private Usuario usuario;
    private ArrayList<Sensor> sensores;

    public Notificacion(Usuario usuario, ArrayList<Sensor> sensores) {
        this.usuario = usuario;
        this.sensores = sensores;
    }

    /**
     *Este metodo abstracto notificara al usuario de cada observacion asignada
     */
    public abstract void notificarUsuario();

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
