/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Map;

/**
 *
 * @author Mladen
 */
@OdoPrimaryKey( primaryKey = {"OglasId", "Rb"} )
public class Nadmetanje implements OpstiDomenskiObjekat, Serializable{
    
    private Oglas oglas;
    private int rb;
    private String oznaka;
    private double pocetnaCena;
    private double depozit;
    private double povrsina;

    public Nadmetanje() {
    }

    Nadmetanje(Oglas oglas) {
        this.oglas = oglas;
        rb = 0;
        oznaka = new String("");
        pocetnaCena = 0.0;
        depozit = 0.0;
        povrsina = 0.0;
    }

    Nadmetanje(ResultSet rs, Oglas oglas) {
        this.oglas = oglas;
        try {
            rb = rs.getInt("Rb");
            oznaka = rs.getString("Oznaka");
            pocetnaCena = rs.getDouble("PocetnaCena");
            depozit = rs.getDouble("Depozit");
            povrsina = rs.getDouble("Povrsina");
            
        } catch (Exception e) {
            System.out.println(e);            
        }
        
    }

    public Oglas getOglas() {
        return oglas;
    }

    public void setOglas(Oglas oglas) {
        this.oglas = oglas;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public String getOznaka() {
        return oznaka;
    }

    public void setOznaka(String oznaka) {
        this.oznaka = oznaka;
    }

    public double getPocetnaCena() {
        return pocetnaCena;
    }

    public void setPocetnaCena(double pocetnaCena) {
        this.pocetnaCena = pocetnaCena;
    }

    public double getDepozit() {
        return depozit;
    }

    public void setDepozit(double depozit) {
        this.depozit = depozit;
    }

    public double getPovrsina() {
        return povrsina;
    }

    public void setPovrsina(double povrsina) {
        this.povrsina = povrsina;
    }

    @Override
    public String vratiVrednostAtributa() {
        return ""+this.oglas.getOglasId()+", "+rb+
                ", '" +oznaka+"', "+pocetnaCena+
                ", " + depozit + ", "+ povrsina;
    }

    @Override
    public String postaviVrednostAtributa() {
        return "OglasId = "+oglas.getOglasId()+", Rb = "+rb+
                ", Oznaka = '"+oznaka+"', PocetnaCena = "+ pocetnaCena+
                ", Depozit = "+depozit+", Povrsina="+povrsina;
    }

    @Override
    public String vratiImeKlase() {
        return "Nadmetanje";
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return " [%1$d].OglasId = "+oglas.getOglasId() + " AND [%1$d].Rb = " + rb;
    }

    @Override
    public String vratiUslovZaNadjiSlogove() {
        return " OglasId = "+this.oglas.getOglasId();
    }

    @Override
    public String vratiAtributPretrazivanja() {
        return "";
    }

    @Override
    public boolean Napuni(ResultSet rs) {
        return false;
    }

    @Override
    public OpstiDomenskiObjekat vratiVezaniObjekat(int brojVezanogObjekata) {
        return null;
    }

    @Override
    public void Napuni(ResultSet rs, int brojSloga, int brojVeznogObjekta) {
        
    }

    @Override
    public int vratiBrojVezanihObjekata() {
        return 0;
    }

    @Override
    public OpstiDomenskiObjekat vratiSlogVezanogObjekta(int brojVeznogObjekta, int brojSloga) {
        return null;
    }

    @Override
    public int vratiBrojSlogovaVezanogObjekta(int brojVeznogObjekta) {
        return 0;
    }

    @Override
    public String vratiNazivNovogObjekta() {
        return "novo nadmetanje";
    }

    @Override
    public String vratiNazivObjkta() {
        return "nadmetanje";
    }

    @Override
    public void kreirajVezaniObjekat(int brojStavkiVeznogObjekata, int brojVeznogObjekta) {
        
    }

    @Override
    public boolean posaviVrednostZaAtributPretrazivanja(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostZaInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostZaSelect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Napuni(ResultSet rs, Map<String, String> map, String superClassName) {        
        try {
         oglas.Napuni(rs, map, null);         
         rb = rs.getInt("Rb");
         oznaka = rs.getString("Oznaka");
         depozit = rs.getDouble("Depozit");
         pocetnaCena = rs.getDouble("PocetnaCena");
         povrsina = rs.getDouble("Povrsina");
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    public String vratiVrednostZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
