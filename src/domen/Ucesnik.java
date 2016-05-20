/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.Map;

//import java.util.Date;
/**
 *
 * @author Mladen
 */
@OdoPrimaryKey( primaryKey = "UcesnikId" )
public abstract class Ucesnik implements OpstiDomenskiObjekat, Serializable{

    private int ucesnikId;
    private String email;
    private String telefon;
    private String adresa;    
    private Mesto mesto;

    
    public Ucesnik() {
        this.mesto = new Mesto();
    }

    public int getUcesnikId() {
        return ucesnikId;
    }

    public void setUcesnikId(int ucesnikId) {
        this.ucesnikId = ucesnikId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }    

    public Mesto getMesto() {       
            return mesto;                
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    @Override
    public String vratiVrednostAtributa() {
        return "" + ucesnikId + ", '" + email + "', '" + telefon + 
               "', '" + adresa + "', " + mesto.getMestoId();
    }
    
    @Override
    public String postaviVrednostAtributa() {
        return " Email = '" + email + 
                "', Telefon = '" + telefon + "', Adresa = '" + adresa +
                "', MestoId = " + mesto.getMestoId();
    }
    

    @Override
    public boolean Napuni(ResultSet rs) {
        try {
            ucesnikId = rs.getInt("UcesnikId");
            email = rs.getString("Email");
            telefon = rs.getString("Telefon");
            adresa = rs.getString("Adresa");            
            mesto.Napuni(rs);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
    
    @Override
    public boolean posaviVrednostZaAtributPretrazivanja(ResultSet rs) {
        try {
            ucesnikId = rs.getInt("Max");
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
         return true;
    }
    /*
    public OpstiDomenskiObjekat vratiVezaniObjekat(int brojVezanogObjekata) {
        if(brojVezanogObjekata == 0 ) return new Mesto(); return null;
    
    }
    */
    
    @Override
    public void Napuni(ResultSet rs, int brojSloga, int brojVeznogObjekta) {
        //if(brojVeznogObjekta == 0) mesto.Napuni(rs);
    }
    
    @Override
    public int vratiBrojVezanihObjekata() {
        return 0;
    }
    
    
    @Override
    public OpstiDomenskiObjekat vratiSlogVezanogObjekta(int brojVeznogObjekta, int brojSloga) {
        return null;
        //if(brojVeznogObjekta == 0) return mesto; return null;
    }
    
    @Override
    public void kreirajVezaniObjekat(int brojStavkiVeznogObjekata, int brojVeznogObjekta) {
        //if(brojVeznogObjekta == 0) mesto = new Mesto(); 
    }
    
    @Override
    public int vratiBrojSlogovaVezanogObjekta(int brojVeznogObjekta) {
        if(brojVeznogObjekta == 0){
            if(mesto == null){
                return 0;
            }
            return 1;
        }        
        return 0;
    }
    
    @Override
    public String vratiVrednostZaInsert() {
        return "INSERT INTO " + "%s" +
                " VALUES ('"+ email + "', '" + telefon + 
                "', '" + adresa + "', " + mesto.getMestoId() +")";
    }
    
    @Override
    public String vratiAtributPretrazivanja() {
        return "UcesnikId";
    }
    
    public String vratiImeKlase() {        
        return "Ucesnik";
    }
    
    @Override
    public String vratiUslovZaNadjiSlog() {
        return "UcesnikId = " + getUcesnikId();
    }
    
    @Override
    public String vratiUslovZaNadjiSlogove() {
        return "";
    }        
    
    public String ukljuciObjekatSelect()
    {
         return mesto.vratiVrednostAtributa();
    }
    
    public String ukljuciObjekatFrom()
    {
         return  ", " + mesto.vratiImeKlase() + " b ";
    }
    @Override
    public String vratiVrednostZaSelect() {
        return  "SELECT a.*"+
                " FROM " + "%s"+                
                " WHERE " + "%s" ;
    }
    
    
    public boolean Napuni(ResultSet rs, Map<String, String> map, String superClassName) {
        String index = map.get(superClassName != null ? superClassName : vratiImeKlase());
        try {
            ucesnikId = rs.getInt(index+".[ucesnikId]");
            email = rs.getString(index+".[email]");
            telefon = rs.getString(index+".[telefon]");
            adresa = rs.getString(index+".[adresa]");
            mesto.Napuni(rs, map, null);
            
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
    
    @Override
    public String vratiVrednostZaUpdate() {
           return  "UPDATE %s"+
                "\n SET " + "%s"+                
                "\n  WHERE " + "%s" ;
    }

}
