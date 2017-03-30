package com.example.acer.osadd;

/**
 * Created by Acer on 20/11/2016.
 */
public class Statistique {
    int nombre_user;
    int nombre_version;
    int nombre_smart  ;

    public Statistique(int nombre_user, int nombre_version, int nombre_smart) {
        this.nombre_user = nombre_user;
        this.nombre_version = nombre_version;
        this.nombre_smart = nombre_smart;
    }

    public int getNombre_user() {
        return nombre_user;
    }

    public int getNombre_version() {
        return nombre_version;
    }

    public void setNombre_version(int nombre_version) {
        this.nombre_version = nombre_version;
    }

    public int getNombre_smart() {
        return nombre_smart;
    }

    public void setNombre_smart(int nombre_smart) {
        this.nombre_smart = nombre_smart;
    }

    public void setNombre_user(int nombre_user) {
        this.nombre_user = nombre_user;
    }
}
