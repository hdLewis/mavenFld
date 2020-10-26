package com.mvca.model;

import java.io.Serializable;

public class Fld  implements Serializable{
    private int flda;
    private String fldb;
    private float fldc;
    private String fldd;

    public String getFldd() {
        return fldd;

    }

    public void setFldd(String fldd) {
        this.fldd = fldd;
    }

    public Fld() {
    }

    public Fld(int flda, String fldb, float fldc) {
        this.flda = flda;
        this.fldb = fldb;
        this.fldc = fldc;

    }

    public int getFlda() {
        return flda;
    }

    public void setFlda(int flda) {
        this.flda = flda;
    }

    public String getFldb() {
        return fldb;
    }

    public void setFldb(String fldb) {
        this.fldb = fldb;
    }

    public float getFldc() {
        return fldc;
    }

    public void setFldc(float fldc) {
        this.fldc = fldc;
    }
}
