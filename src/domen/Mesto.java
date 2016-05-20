/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.Map;

/**
 *
 * @author Mladen
 */
@OdoPrimaryKey( primaryKey = "MestoId" )
public class Mesto implements OpstiDomenskiObjekat, Serializable{
    
    private int mestoId;
    private String naziv;

    public Mesto() {
    }

    public Mesto(int mestoId, String naziv) {
        this.mestoId = mestoId;
        this.naziv = naziv;
    }
    
    
   
    public int getMestoId() {
        return mestoId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setMestoId(int mestoId) {
        this.mestoId = mestoId;
    }
    
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String vratiVrednostAtributa() {
        return "" + mestoId + ", '"+naziv+"'";
    }

    @Override
    public String postaviVrednostAtributa() {
        return "MestoId = " + mestoId + ", Naziv ='" + naziv + "'" ; 
    }
    
    @Override
    public String vratiImeKlase() {
        return "Mesto";
    }

    @Override
    public String vratiAtributPretrazivanja() {
        return "MestoId";
    }
    
    @Override
    public String vratiUslovZaNadjiSlog() {        
        return " MestoId = " + getMestoId();
    }      

    @Override
    public boolean Napuni(ResultSet rs) {
        
        try {
            setMestoId(rs.getInt("MestoId"));
            setNaziv(rs.getString("Naziv")); 
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
        
    }        

    @Override
    public String vratiUslovZaNadjiSlogove() {
        return "(1=1)";
    }

    @Override
    public OpstiDomenskiObjekat vratiVezaniObjekat(int brojVezanogObjekata) {
        return null;
    }

    @Override
    public void Napuni(ResultSet rs, int brojSloga, int brojVeznogObjekta) {
        
    }

    @Override
    public void kreirajVezaniObjekat(int brojStavkiVeznogObjekata, int brojVeznogObjekta) {
        
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
    public int vratiBrojSlogovaVezanogObjekta(int brojVeyanogobjekta) {
        return 0;
    }
    
    @Override
    public String vratiNazivNovogObjekta() {
        return "novo mesto";
    }

    @Override
    public String vratiNazivObjkta() {
        return "meto";
    }

    @Override
    public String toString() {
        return naziv;
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
        return "SELECT *"+
               " FROM " + "%s"+
               " WHERE " + "%s";
    }

    @Override
    public boolean Napuni(ResultSet rs, Map<String, String> map, String superClassName) {
        String index = map.get(vratiImeKlase());
        try {
            mestoId = rs.getInt(index+".[mestoId]");
            naziv = rs.getString(index+".[naziv]");            
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
