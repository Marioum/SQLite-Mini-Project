package com.example.dell.sqliteproject;

/**
 * Created by DELL on 02/12/2016.
 */

public class AndroidOs {
    public String name;
    public int nbUser;
    public int nbVersion;
    public int nbsmart;
    public AndroidOs(String name,int nbUser,int nbVersion,int nbsmart){
        this.name=name;
        this.nbUser=nbUser;
        this.nbVersion=nbVersion;
        this.nbsmart=nbsmart;

    }

    public String getName(){
        return name;
    }
    public int getNbUser(){
        return nbUser;
    }
    public int getNbVersion(){
        return nbVersion;
    }
    public int getNbsmart(){
        return nbsmart;
    }
}