/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author Mladen
 */
@OdoPrimaryKey( primaryKey = "PrijavaId" )
public abstract class Prijava implements OpstiDomenskiObjekat, Serializable{
    
    private int prijavaId;
    private Calendar datumPodnosenja;
    private boolean upoznatSaPonudom;
    private Calendar datumObilaska;
    private boolean dokazoUplatiDepozita;
    private boolean dokazoVlasnistvu;
    private boolean regPoljGazdinstva;
    private Mesto mesto;
    private Nadmetanje nadmetanje;

    
    
    public Prijava() {
        datumPodnosenja = Calendar.getInstance();        
        datumObilaska = Calendar.getInstance();
       // Date date = new Date();        
                       
        //datumObilaska.setTime();
        mesto = new Mesto();
        nadmetanje = new Nadmetanje();
    }

    public int getPrijavaId() {
        return prijavaId;
    }

    public void setPrijavaId(int prijavaId) {
        this.prijavaId = prijavaId;
    }

    
    
    public Calendar getDatumPodnosenja() {
        return datumPodnosenja;
    }

    public void setDatumPodnosenja(Calendar datumPodnosenja) {
        this.datumPodnosenja = datumPodnosenja;
    }

    public boolean isUpoznatSaPonudom() {
        return upoznatSaPonudom;
    }

    public void setUpoznatSaPonudom(boolean upoznatSaPonudom) {
        this.upoznatSaPonudom = upoznatSaPonudom;
    }

    public Calendar getDatumObilaska() {
        return datumObilaska;
    }

    public void setDatumObilaska(Calendar datumObilaska) {
        this.datumObilaska = datumObilaska;
    }

    public boolean isDokazoUplatiDepozita() {
        return dokazoUplatiDepozita;
    }

    public void setDokazoUplatiDepozita(boolean dokazoUplatiDepozita) {
        this.dokazoUplatiDepozita = dokazoUplatiDepozita;
    }

    public boolean isDokazoVlasnistvu() {
        return dokazoVlasnistvu;
    }

    public void setDokazoVlasnistvu(boolean dokazoVlasnistvu) {
        this.dokazoVlasnistvu = dokazoVlasnistvu;
    }

    public boolean isRegPoljGazdinstva() {
        return regPoljGazdinstva;
    }

    public void setRegPoljGazdinstva(boolean regPoljGazdinstva) {
        this.regPoljGazdinstva = regPoljGazdinstva;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    public Nadmetanje getNadmetanje() {
        return nadmetanje;
    }

    public void setNadmetanje(Nadmetanje nadmetanje) {
        this.nadmetanje = nadmetanje;
    }
    
    @Override
    public String vratiVrednostAtributa() {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return "" + prijavaId + 
               ",'" + formatter.format(datumPodnosenja.getTime())+"'"+
               "," + (upoznatSaPonudom ? 1 : 0) + 
               ",'" + formatter.format(datumObilaska.getTime())+"'"+
               "," + (dokazoUplatiDepozita ? 1: 0) + 
               "," + (dokazoVlasnistvu ? 1 : 0) + 
               "," + (regPoljGazdinstva ? 1 : 0) + 
               "," + mesto.getMestoId() + 
               "," + nadmetanje.getOglas().getOglasId() + 
               "," + nadmetanje.getRb();
    }

    @Override
    public String postaviVrednostAtributa() {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return " DatumPodnosenja='" + formatter.format(datumPodnosenja.getTime())+"'"+
               ", UpoznatSaPonudom = " + (upoznatSaPonudom ? 1: 0) + 
               ", DatumObilaska = '" + formatter.format(datumObilaska.getTime())+"'"+
               ", DokazoUplatiDepozita = " + (dokazoUplatiDepozita ? 1: 0) + 
               ", DokazoVlasnistvu = " + (dokazoVlasnistvu ? 1: 0) + 
               ", RegPoljGazdinstva = " + (regPoljGazdinstva ? 1: 0) +
               ", MestoId = " + mesto.getMestoId() + 
               ", OglasId = " + nadmetanje.getOglas().getOglasId() + 
               ", Rb = " + nadmetanje.getRb();
    }

    @Override
    public String vratiImeKlase() {
        return "Prijava";
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return "PrijavaId = " + prijavaId;
    }

    @Override
    public String vratiUslovZaNadjiSlogove() {
        return "OglasId = " + nadmetanje.getOglas().getOglasId() + 
                " AND Rb = " + nadmetanje.getRb();
    }

    @Override
    public String vratiAtributPretrazivanja() {
        return "PrijavaId";
    }

    @Override
    public boolean Napuni(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean posaviVrednostZaAtributPretrazivanja(ResultSet rs) {
        try {
            prijavaId = rs.getInt("Max");
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
         return true;
    }

    @Override
    public OpstiDomenskiObjekat vratiVezaniObjekat(int brojVezanogObjekata) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Napuni(ResultSet rs, int brojSloga, int brojVeznogObjekta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void kreirajVezaniObjekat(int brojStavkiVeznogObjekata, int brojVeznogObjekta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int vratiBrojVezanihObjekata() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OpstiDomenskiObjekat vratiSlogVezanogObjekta(int brojVeznogObjekta, int brojSloga) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int vratiBrojSlogovaVezanogObjekta(int brojVeznogObjekta) {
        switch (brojVeznogObjekta){
                case 0:
                    if(mesto != null) return 1;
                    break;
                case 1:
                    if(nadmetanje == null) return 1;
                    break;                
        }
        return 0;
    }

    @Override
    public String vratiNazivNovogObjekta() {
        return "npva prijava";
    }

    @Override
    public String vratiNazivObjkta() {
        return "prijava";
    }

    @Override
    public String vratiVrednostZaSelect() {
        return  "SELECT a.*"+
                " FROM " + "%s"+                
                " WHERE " + "%s" ;
    }

    @Override
    public String vratiVrednostZaInsert() {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return "INSERT INTO " + "%s" +
                " VALUES ('"+ formatter.format(datumPodnosenja.getTime())+ "'"+
               ", " + (upoznatSaPonudom ? 1: 0) + 
               ",'" + formatter.format(datumObilaska.getTime())+ "'" +
               "," + (dokazoUplatiDepozita ? 1: 0) + 
               "," + (dokazoVlasnistvu ? 1: 0) +
               "," + (regPoljGazdinstva ? 1: 0) +
               "," + mesto.getMestoId() + 
               "," + nadmetanje.getOglas().getOglasId() + 
               "," + nadmetanje.getRb() + ")";
    }

    @Override
    public String vratiVrednostZaUpdate() {
         return  "UPDATE %s"+
                "\n SET " + "%s"+                
                "\n  WHERE " + "%s" ;
    }

    @Override
    public boolean Napuni(ResultSet rs, Map<String, String> map, String superClassName) {
        String index = map.get(superClassName != null ? superClassName : vratiImeKlase());
        try {
            prijavaId = rs.getInt(index+".[prijavaId]");
            
            datumPodnosenja.setTime(rs.getTimestamp(index+".[datumPodnosenja]"));
            
            dokazoUplatiDepozita = rs.getInt(index+".[dokazoUplatiDepozita]") != 0;
            upoznatSaPonudom = rs.getInt(index+".[upoznatSaPonudom]") != 0;
            
            Timestamp timestamp = rs.getTimestamp(index+".[datumObilaska]");
            if(timestamp != null)datumObilaska.setTime(timestamp);
           
            dokazoVlasnistvu = rs.getInt(index+".[dokazoVlasnistvu]") != 0;
            regPoljGazdinstva = rs.getInt(index+".[regPoljGazdinstva]") != 0;                    
            mesto.Napuni(rs, map, null);
            
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    } 
    
    
}
