package com.example.kress_000.bazsigeriapp;

/**
 * Created by kress_000 on 2015. 10. 03..
 */

public class Pia {

    private String nev;
    private int ar;
    private float menny;
    private float tart;
    private float tisztaszeszar;

    Pia(String n, int a, float m, float t){
        this.nev = n;
        this.ar=a;
        this.menny=m;
        this.tart=t;
        this.tisztaszeszar=(a * (1-(t/100)) / m);
    }

    String getNev(){
        return nev;
    }
    int getAr(){
        return ar;
    }
    float getMenny(){
        return menny;
    }
    float getTart(){
        return tart;
    }
    float getTisztaszesz(){
        return tisztaszeszar;
    }

    @Override
    public boolean equals(Object obj){
        if(obj==null){
            return false;
        }
        if(obj instanceof Pia){
            Pia tmp = (Pia) obj;
            return (this.nev==tmp.nev &&
                    this.ar==tmp.ar &&
                    this.menny==tmp.menny &&
                    this.tart==tmp.tart);
        }
        return false;
    }

    @Override
    public String toString(){
        return this.nev;
    }


}
