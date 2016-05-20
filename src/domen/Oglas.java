/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.Array;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 *
 * @author Mladen
 */
@OdoPrimaryKey( primaryKey = "OglasId" )
public class Oglas implements OpstiDomenskiObjekat, Serializable{
    
    private int oglasId;
    private Calendar zaGodinu;
    private double licitacijskiKorak;
    private String nazivOpstine;
    private double maxPovrsinaZakupa;
    private List<Nadmetanje> nadnetanjeList;

    public Oglas() {
        zaGodinu = Calendar.getInstance();
        nazivOpstine = new String();
        nadnetanjeList = new ArrayList<>();
    }

    public int getOglasId() {
        return oglasId;
    }

    public void setOglasId(int oglasId) {
        this.oglasId = oglasId;
    }

    public Calendar getZaGodinu() {
        return zaGodinu;
    }

    public void setZaGodinu(Calendar zaGodinu) {
        this.zaGodinu = zaGodinu;
    }

    public double getLicitacijskiKorak() {
        return licitacijskiKorak;
    }

    public void setLicitacijskiKorak(double licitacijskiKorak) {
        this.licitacijskiKorak = licitacijskiKorak;
    }

    public String getNazivOpstine() {
        return nazivOpstine;
    }

    public void setNazivOpstine(String nazivOpstine) {
        this.nazivOpstine = nazivOpstine;
    }

    public double getMaxPovrsinaZakupa() {
        return maxPovrsinaZakupa;
    }

    public void setMaxPovrsinaZakupa(double maxPovrsinaZakupa) {
        this.maxPovrsinaZakupa = maxPovrsinaZakupa;
    }

    public List<Nadmetanje> getNadnetanjeList() {
        return nadnetanjeList;
    }

    public void setNadnetanjeList(List<Nadmetanje> nadnetanjeList) {
        this.nadnetanjeList = nadnetanjeList;
    }       

    @Override
    public String vratiVrednostAtributa() {
         return ""+oglasId+", '"+zaGodinu.get(Calendar.YEAR)+
                 "', "+licitacijskiKorak+", '"+nazivOpstine+
                 "' ,"+maxPovrsinaZakupa;
    }

    @Override
    public String postaviVrednostAtributa() {
        return "OglasId = "+oglasId+", ZaGodinu='"+zaGodinu+
                "', LicitacijskiKorak = "+licitacijskiKorak+
                ", NazivOpstine = '"+nazivOpstine+
                "', MaxPovrsinaZakupa = "+maxPovrsinaZakupa;
    }

    @Override
    public String vratiImeKlase() {
        return "Oglas";
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return "OglasId = "+oglasId;
    }

    @Override
    public String vratiUslovZaNadjiSlogove() {
        return "";
    }

    @Override
    public String vratiAtributPretrazivanja() {
        return "OglasId";
    }

    @Override
    public boolean Napuni(ResultSet rs) {
        nadnetanjeList = null;
        try {
         oglasId = rs.getInt("OglasId");
         zaGodinu = (Calendar)rs.getObject("ZaGodinu");
         licitacijskiKorak = rs.getDouble("LicitacijskiKorak");
         nazivOpstine = rs.getString("NazivOpstine");
         maxPovrsinaZakupa = rs.getDouble("MaxPovrsinaZakupa");
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
    
    @Override
    public void kreirajVezaniObjekat(int brojStavkiVeznogObjekata, int brojVeznogObjekta) {
        if(brojVeznogObjekta == 0) nadnetanjeList = new ArrayList<Nadmetanje>();       
    }

    @Override
    public OpstiDomenskiObjekat vratiVezaniObjekat(int brojVezanogObjekata) {
        if(brojVezanogObjekata == 0) return new Nadmetanje(this); return null;
    }

    @Override
    public void Napuni(ResultSet rs, int brojSloga, int brojVeznogObjekta) {
        if(brojVeznogObjekta == 0) nadnetanjeList.add(brojSloga, new Nadmetanje(rs,this) );
    }

    @Override
    public int vratiBrojVezanihObjekata() {
        return 1;
    }

    @Override
    public OpstiDomenskiObjekat vratiSlogVezanogObjekta(int brojVeznogObjekta, int brojSloga) {
        if(brojVeznogObjekta == 0) return nadnetanjeList.get(oglasId); return null;
    }

    @Override
    public int vratiBrojSlogovaVezanogObjekta(int brojVeznogObjekta) {
        if(brojVeznogObjekta == 0){
            if(this.nadnetanjeList == null){
               return 0;
            }
            return this.nadnetanjeList.size();
        }
        return 0;
    }

    @Override
    public String vratiNazivNovogObjekta() {
        return "novi oglas";
    }

    @Override
    public String vratiNazivObjkta() {
        return "oglas";
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
        String index = map.get(vratiImeKlase());
        try {
            oglasId = rs.getInt(index+".[oglasId]");
            zaGodinu.setTime(rs.getTimestamp(index+".[zaGodinu]"));
            maxPovrsinaZakupa = rs.getDouble(index+".[maxPovrsinaZakupa]");
            nazivOpstine = rs.getString(index+".[nazivOpstine]");
            
            
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

    
    @Override
    public String toString() {
        return Integer.toString(zaGodinu.get(Calendar.YEAR));
    }
   
    
    
}
