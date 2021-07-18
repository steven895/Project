/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursos;

import Objetos.Observacion;
import Objetos.Sensor;
import Objetos.Usuario;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Tago
 * @author Tobar
 * @author Rivera
 */
public class ManejoArchivo {
    public static ArrayList<Sensor> LeeSensores(String nombrearchivo) {
        ArrayList<Sensor> sensores = new ArrayList<>();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(nombrearchivo);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            br.readLine();
            while ((linea = br.readLine()) != null) {
                String [] lista= linea.split(",");
                for(int i=0;i<lista.length;i++){
                    lista[i]=lista[i].replace("\"","");
                }
                Sensor s= new Sensor(lista[1]);
                Observacion ob= new Observacion(lista[2],lista[3],lista[4],lista[5],lista[6],lista[7],lista[8],lista[9]);
                if(sensores.contains(s)){
                    //agregando observacion a a sensores existentes
                    sensores.get(sensores.indexOf(s)).addObservacion(ob);
                }
                else{
                    s.addObservacion(ob);
                    sensores.add(s);
                }
                

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return sensores;

    }
    public static void EscribirArchivo(String nombreArchivo, String linea) {

        FileWriter fichero = null;
        BufferedWriter bw = null;
        try {
            fichero = new FileWriter(nombreArchivo,false);
            bw = new BufferedWriter(fichero);
            bw.write(linea);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    //fichero.close();
                    bw.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    public static ArrayList<Usuario> obtenerUsuarios(String nombrearchivo){
        ArrayList<Usuario> usuarios= new ArrayList<Usuario>();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(nombrearchivo);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            br.readLine();
            while ((linea = br.readLine()) != null) {
                String [] lista= linea.split(",");
                Usuario us= new Usuario(lista[0],lista[1]);
                usuarios.add(us);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return usuarios;
    }
}
