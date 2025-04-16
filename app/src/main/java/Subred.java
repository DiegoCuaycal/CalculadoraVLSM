package com.diegocuaycal.myapplication;

public class Subred {
    public String nombre;
    public int hosts;
    public String direccionRed;
    public String mascara;
    public int prefijo;
    public String rangoAsignable;
    public String broadcast;

    public Subred(String nombre, int hosts, String direccionRed, String mascara, int prefijo, String rangoAsignable, String broadcast) {
        this.nombre = nombre;
        this.hosts = hosts;
        this.direccionRed = direccionRed;
        this.mascara = mascara;
        this.prefijo = prefijo;
        this.rangoAsignable = rangoAsignable;
        this.broadcast = broadcast;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHosts() {
        return hosts;
    }

    public String getDireccionRed() {
        return direccionRed;
    }

    public String getMascara() {
        return mascara;
    }

    public int getPrefijo() {
        return prefijo;
    }

    public String getRangoAsignable() {
        return rangoAsignable;
    }

    public String getBroadcast() {
        return broadcast;
    }

}
