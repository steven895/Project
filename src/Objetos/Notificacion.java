/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 *
 * @author Tago
 * @author Tobar
 * @author Rivera
 */
public class Notificacion {

    private ArrayList<Sensor> sensores;
    private String propiedad;
    private ArrayList<String> enlazados;
    private ArrayList<Etiqueta> etiquetas;
    private boolean estado;

    public Notificacion(ArrayList<Sensor> sensores, String propiedad) {
        this.sensores = sensores;
        this.propiedad = propiedad;
        this.enlazados = new ArrayList();
        this.etiquetas = new ArrayList();
        this.estado=true;
    }

    public void addDispositivo(String device) {
        enlazados.add(device);
    }
    public String getNotificaciones(Date inicio, Date fin){
        String cadena="";
        for(Sensor s:sensores){
            for(Observacion ob: s.getObservaciones()){
                if(enlazados.isEmpty()){
                    cadena+=generarNotificacion(ob,inicio,fin);
                }
                else if(enlazados.contains(s.getId())){
                    cadena+=generarNotificacion(ob,inicio,fin);
                }
            }
        }
        return cadena;
    }

    public String generarNotificacion(Observacion ob, Date inicio, Date fin) {
        //String cadena = "Nombre etiqueta,nombre propiedad,valor propiedad,fecha\n"; PARA EL SISTEMA ESTE ENCABEZADO
        String cadena="";
        for (Etiqueta et : etiquetas) {
            switch (propiedad) {
                case "CO":
                    double co = ob.getCo();
                    if (et instanceof EtiquetaNumerico && ob.getFecha().after(inicio) && ob.getFecha().before(fin)) {
                        EtiquetaNumerico etn = (EtiquetaNumerico) et;
                        if (etn.contains(co)) {
                            cadena += et.getName() + "," + propiedad + "," + co + "," + printDate(ob.getFecha()) + "\n";
                        }
                    }
                    break;
                case "Ligth":
                    boolean ligth = ob.isLigth();
                    if (et instanceof EtiquetaBool && ob.getFecha().after(inicio) && ob.getFecha().before(fin)) {
                        EtiquetaBool etb = (EtiquetaBool) et;
                        if (etb.isValor()==ligth) {
                            cadena += et.getName() + "," + propiedad + "," + ligth + "," + printDate(ob.getFecha()) + "\n";
                        }
                    }
                    break;
                case "LPG":
                    double lpg = ob.getLpg();
                    if (et instanceof EtiquetaNumerico && ob.getFecha().after(inicio) && ob.getFecha().before(fin)) {
                        EtiquetaNumerico etn = (EtiquetaNumerico) et;
                        if (etn.contains(lpg)) {
                            cadena += et.getName() + "," + propiedad + "," + lpg + "," + printDate(ob.getFecha()) + "\n";
                        }
                    }
                    break;
                case "Motion":
                    boolean motion = ob.isMotion();
                    if (et instanceof EtiquetaBool && ob.getFecha().after(inicio) && ob.getFecha().before(fin)) {
                        EtiquetaBool etb = (EtiquetaBool) et;
                        if (etb.isValor()==motion) {
                            cadena += et.getName() + "," + propiedad + "," + motion + "," + printDate(ob.getFecha()) + "\n";
                        }
                    }
                    break;
                case "Smoke":
                    double smoke = ob.getSmoke();
                    if (et instanceof EtiquetaNumerico && ob.getFecha().after(inicio) && ob.getFecha().before(fin)) {
                        EtiquetaNumerico etn = (EtiquetaNumerico) et;
                        if (etn.contains(smoke)) {
                            cadena += et.getName() + "," + propiedad + "," + smoke + "," + printDate(ob.getFecha()) + "\n";
                        }
                    }
                    break;
                case "Temp":
                    double temp = ob.getTemp();
                    if (et instanceof EtiquetaNumerico && ob.getFecha().after(inicio) && ob.getFecha().before(fin)) {
                        EtiquetaNumerico etn = (EtiquetaNumerico) et;
                        if (etn.contains(temp)) {
                            cadena += et.getName() + "," + propiedad + "," + temp + "," + printDate(ob.getFecha()) + "\n";
                        }
                    }
                    break;
                default:
            }
        }
        return cadena;
    }

    public void makeNotificacion() {
        switch (propiedad) {
            case "CO":
                rangosNumericos();
                break;
            case "Ligth":
                rangosBooleanos();
                break;
            case "LPG":
                rangosNumericos();
                break;
            case "Motion":
                rangosBooleanos();
                break;
            case "Smoke":
                rangosNumericos();
                break;
            case "Temp":
                rangosNumericos();
                break;
        }
    }

    private void rangosNumericos() {
        System.out.print("Elija el numero de etiquetas a crear: ");
        Scanner sc = new Scanner(System.in);
        int veces = sc.nextInt();
        while (veces > 0) {
            Scanner sc2 = new Scanner(System.in);
            System.out.println("Ingrese nombre de etiqueta: ");
            String etiqueta = sc2.nextLine();
            System.out.println("Puede escoger los siguientes valores para los limites : infinito, -infinito, un valor numerico entero(3, 5, 100, -100)");
            System.out.println("Ingrese limite inferior: ");
            String strinf = sc2.nextLine();
            double inferior = asignarValorNum(strinf);
            System.out.println("Ingrese limite superior: ");
            String strsup = sc2.nextLine();
            double superior = asignarValorNum(strsup);
            EtiquetaNumerico et = new EtiquetaNumerico(inferior, superior, etiqueta);
            if (et.hasintersection(etiquetas)) {
                System.out.println("ADVERTENCIA: Los Rangos ingresados intersectan con otra etiqueta intentelo de nuevo");
            } else {
                veces--;
                etiquetas.add(et);
                System.out.println("|||   Ingreso de etiqueta exitoso   |||");
            }
        }
    }

    private void rangosBooleanos() {
        System.out.println("Para esta categoria debe ingresar 2 etiquetas");
        int veces = 2;
        while (veces > 0) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese nombre de la etiqueta: ");
            String etiqueta = sc.nextLine();
            System.out.println("Ingrese el valor de la etiqueta (true/false): ");
            String strval = sc.nextLine();
            boolean valor = asignarValorBool(strval);
            EtiquetaBool et = new EtiquetaBool(valor, etiqueta);
            if (et.hasintersection(etiquetas)) {
                System.out.println("ADVERTENCIA: El Valor ingresados intersectan con otra etiqueta intentelo de nuevo");
            } else {
                veces--;
                etiquetas.add(et);
                System.out.println("|||   Ingreso de etiqueta exitoso   |||");
            }

        }
    }

    private double asignarValorNum(String valor) {
        double limite = 0;
        switch (valor) {
            case "infinito":
                limite = Double.POSITIVE_INFINITY;
                break;
            case "-infinito":
                limite = Double.NEGATIVE_INFINITY;
                break;
            default:
                limite = Double.parseDouble(valor);
                break;
        }
        return limite;
    }

    private boolean asignarValorBool(String valor) {
        String val = valor.toLowerCase();
        if (val.equals("true")) {
            return true;
        } else {
            return false;
        }
    }
    private String printDate(Date fecha){
        String cadena=fecha.getDate()+"/"+(fecha.getMonth()+1)+"/"+(fecha.getYear()+1900)+" "+fecha.getHours()+":"+fecha.getMinutes();
        return cadena;
    }

    public ArrayList<String> getEnlazados() {
        return enlazados;
    }

    public void setEnlazados(ArrayList<String> enlazados) {
        this.enlazados = enlazados;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(String propiedad) {
        this.propiedad = propiedad;
    }
    

}
