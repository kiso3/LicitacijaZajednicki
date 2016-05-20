/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.Serializable;

/**
 *
 * @author Mladen
 */
public class TransferObjekat implements Serializable{
    private Object parametar;
    private int operacija;
    private Object odgovor;
    private String signal;
    private String poruka;
    private Object kiterijumPretrage;

    public Object getParametar() {
        return parametar;
    }

    public void setParametar(Object parametar) {
        this.parametar = parametar;
    }

    public int getOperacija() {
        return operacija;
    }

    public void setOperacija(int operacija) {
        this.operacija = operacija;
    }

    public Object getOdgovor() {
        return odgovor;
    }

    public void setOdgovor(Object odgovor) {
        this.odgovor = odgovor;
    }

    public String getSignal() {
        return signal;
    }

    public void setSignal(String signal) {
        this.signal = signal;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public Object getKiterijumPretrage() {
        return kiterijumPretrage;
    }

    public void setKiterijumPretrage(Object kiterijumPretrage) {
        this.kiterijumPretrage = kiterijumPretrage;
    }
    
    
}
