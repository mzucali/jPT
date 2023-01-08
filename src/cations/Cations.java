package cations;
/*
 * Cations.java
 *
 * Created on July 22, 2007, 10:38 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

//package Phases;

/**
 *
 * @author miki
 */


import java.io.Serializable;

@SuppressWarnings({ "serial", "rawtypes" })
public class Cations implements Comparable, Serializable {

     private int ID;

    private String catLabel;

    private double catVal;
    
    /** Creates a new instance of Cations */
    public Cations() {
    }
    
    
    
    
    
    public int compareTo(Object o) {

        Cations e = (Cations) o;
        if (ID < e.ID) {
            return -1;
        }
        if (ID > e.ID) {
            return 1;
        }
        return 0;
    }

    public void setCatIDandLabel(int id, String string) {
        ID = id;
        catLabel = string;
        return;
    }
            
    public void setCatLabel(String catlabel) {
        catLabel = catlabel;
        return;
    }
    public String getCatLabel() {
        return catLabel;
    }
    
    public void setCatVal(double catval) {
        catVal = catval;
        return;
    }
    
        public double getCatVal() {
        return catVal;
    }
            

    
    
    
}
