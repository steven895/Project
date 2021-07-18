/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema;

import Objetos.Notificacion;
import Objetos.Sensor;
import Objetos.Usuario;
import Recursos.ManejoArchivo;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Tago
 */
public class Sistema {

    ArrayList<Sensor> sensores = cargarSensores();

    public static void main(String[] args) {
        // TODO code application logic here

    }

    public static ArrayList<Sensor> cargarSensores() {
        ArrayList<Sensor> sensores = ManejoArchivo.LeeFichero("data.csv");
        return sensores;
    }

    public void crearNotiXPropiedad(Usuario user) {
        String[] propiedades = {"CO", "Ligth", "LPG", "Motion", "Smoke", "Temp"};
        System.out.println("|||||    Propiedades Observables    |||||");
        System.out.println("1." + propiedades[0]);
        System.out.println("2." + propiedades[1]);
        System.out.println("3." + propiedades[2]);
        System.out.println("4." + propiedades[3]);
        System.out.println("5." + propiedades[4]);
        System.out.println("6." + propiedades[5]);
        int op = 0;

        while (op <= 0 || op > 6) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Seleccione un numero: ");
            op = sc.nextInt();
        }
        Notificacion noti = new Notificacion(sensores, propiedades[op - 1]);
        noti.makeNotificacion();
        user.addNotificacion(noti);
    }

    public void crearNotiXDispositivo(Usuario user) {
        System.out.println("|||||    Dispositivos Disponibles    |||||");
        for (Sensor s : sensores) {
            System.out.println("1." + s.getId());
        }
        int op = 0;
        while (op <= 0 || op > sensores.size()) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Seleccione un numero: ");
            op = sc.nextInt();
        }
        boolean flag = true;
        for (Notificacion noti : user.getNotificaciones()) {
            if (!noti.getEnlazados().contains(sensores.get(op - 1).getId())) {
                noti.addDispositivo(sensores.get(op - 1).getId());
            } else {
                flag = false;
            }
        }
        if (flag) {
            System.out.println("|||   Dispositivo agregado con exito   |||");
        } else {
            System.out.println("ADVERTENCIA: Este dispositivo ya a sido agregado anteriormente intente de nuevo");
        }
    }
}
