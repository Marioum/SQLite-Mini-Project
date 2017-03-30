package edu.dhib.tpintentoperationsystems;

/**
 * Created by dhib on 24/11/2016.
 */
public class OperatingSystem {
    String name;
    String description;
    String nombreUtilisateurs;
    String nombreVersions;
    String nombreSmartphones;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNombreUtilisateurs() {
        return nombreUtilisateurs;
    }

    public void setNombreUtilisateurs(String nombreUtilisateurs) {
        this.nombreUtilisateurs = nombreUtilisateurs;
    }

    public String getNombreVersions() {
        return nombreVersions;
    }

    public void setNombreVersions(String nombreVersions) {
        this.nombreVersions = nombreVersions;
    }

    public String getNombreSmartphones() {
        return nombreSmartphones;
    }

    public void setNombreSmartphones(String nombreSmartphones) {
        this.nombreSmartphones = nombreSmartphones;
    }

    public OperatingSystem(String name, String nombreUtilisateurs, String nombreSmartphones, String nombreVersions) {
        this.name = name;
        this.nombreUtilisateurs = nombreUtilisateurs;
        this.nombreSmartphones = nombreSmartphones;
        this.nombreVersions = nombreVersions;
    }

    public OperatingSystem() {
    }
}
