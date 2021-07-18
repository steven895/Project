/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Tago
 * @author Tobar
 * @author Rivera
 */
public class Usuario {
    private String id;
    private String password;
    private ArrayList<Notificacion> notificaciones;

    public Usuario(String id, String password) {
        this.id = id;
        this.password = password;
    }
    public void addNotificacion(Notificacion noti){
        notificaciones.add(noti);
    }

    public ArrayList<Notificacion> getNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(ArrayList<Notificacion> notificaciones) {
        this.notificaciones = notificaciones;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Usuario){
            Usuario user=(Usuario)obj;
            if(user.id.equals(this.id))return true;
        }
        return false;
    }
    
    
}
