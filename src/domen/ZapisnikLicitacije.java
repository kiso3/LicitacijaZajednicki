/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.util.Date;

/**
 *
 * @author Mladen
 */
@OdoPrimaryKey( primaryKey = "ZapisnikLicitacijeId")
public class ZapisnikLicitacije {
    
    private int zapisnikLicitacijeId;
    private Date datumVremePocetka;
    private Date datumVremeZavrsetka;
    private String adresaLicitacije;
    private Mesto mesto;
    private Nadmetanje nadetanje;

    public ZapisnikLicitacije() {
    }

    public int getZapisnikLicitacijeId() {
        return zapisnikLicitacijeId;
    }

    public Date getDatumVremePocetka() {
        return datumVremePocetka;
    }

    public void setDatumVremePocetka(Date datumVremePocetka) {
        this.datumVremePocetka = datumVremePocetka;
    }

    public Date getDatumVremeZavrsetka() {
        return datumVremeZavrsetka;
    }

    public void setDatumVremeZavrsetka(Date datumVremeZavrsetka) {
        this.datumVremeZavrsetka = datumVremeZavrsetka;
    }

    public String getAdresaLicitacije() {
        return adresaLicitacije;
    }

    public void setAdresaLicitacije(String adresaLicitacije) {
        this.adresaLicitacije = adresaLicitacije;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    public Nadmetanje getNadetanje() {
        return nadetanje;
    }

    public void setNadetanje(Nadmetanje nadetanje) {
        this.nadetanje = nadetanje;
    }
    
    
}
