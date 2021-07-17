/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.util.Date;

/**
 *
 * @author Tago
 */
public class Observacion {
    private double co;
    private double humidity;
    private boolean ligth;
    private double lpg;
    private boolean motion;
    private double smoke;
    private double temp;
    private Date fecha;

    public Observacion(String co, String humidity, String ligth, String lpg, String motion, String smoke, String temp, String fecha) {
        this.co = Double.parseDouble(co);
        this.humidity = Double.parseDouble(humidity);
        this.ligth = Boolean.parseBoolean(ligth);
        this.lpg = Double.parseDouble(lpg);
        this.motion = Boolean.parseBoolean(motion);
        this.smoke = Double.parseDouble(smoke);
        this.temp = Double.parseDouble(temp);
        Date date= new Date();
        String []fec=fecha.split(" ")[0].split("/");
        String time[]=fecha.split(" ")[1].split(":");
        int dia=Integer.parseInt(fec[0]);
        int mes=Integer.parseInt(fec[1]);
        int anio=Integer.parseInt(fec[2]);
        int hora=Integer.parseInt(time[0]);
        int minuto=Integer.parseInt(time[1]);
        date.setDate(dia);
        date.setMonth(mes-1);
        date.setYear(anio-1900);
        date.setHours(hora);
        date.setMinutes(minuto);
        date.setSeconds(0);
        this.fecha = date;
    }

    public double getCo() {
        return co;
    }

    public void setCo(double co) {
        this.co = co;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public boolean isLigth() {
        return ligth;
    }

    public void setLigth(boolean ligth) {
        this.ligth = ligth;
    }

    public double getLpg() {
        return lpg;
    }

    public void setLpg(double lpg) {
        this.lpg = lpg;
    }

    public boolean isMotion() {
        return motion;
    }

    public void setMotion(boolean motion) {
        this.motion = motion;
    }

    public double getSmoke() {
        return smoke;
    }

    public void setSmoke(double smoke) {
        this.smoke = smoke;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

  
}
