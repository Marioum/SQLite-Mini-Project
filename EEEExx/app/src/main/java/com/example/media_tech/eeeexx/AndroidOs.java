package com.example.media_tech.eeeexx;

/**
 * Created by Media_Tech on 24/11/2016.
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
}
