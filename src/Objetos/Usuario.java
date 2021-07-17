/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Objects;

=======
>>>>>>> a650824f123749caafce42ca3ec6140d5631b5ca
/**
 *
 * @author Tago
 */
public class Usuario {
    private String id;
    private String password;

    public Usuario(String id, String password) {
        this.id = id;
        this.password = password;
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
