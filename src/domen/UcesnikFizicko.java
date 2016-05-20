/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.lang.reflect.Constructor;
import java.sql.ResultSet;
import java.util.Map;

/**
 *
 * @author Mladen
 */
public class UcesnikFizicko extends Ucesnik{
    
    private String jmbg;
    private String ime;
    private String imeRoditelja;
    private String prezime;

    public UcesnikFizicko() {
        super();
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getImeRoditelja() {
        return imeRoditelja;
    }

    public void setImeRoditelja(String imeRoditelja) {
        this.imeRoditelja = imeRoditelja;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    @Override
    public String vratiVrednostAtributa() {
        return ", '" + jmbg + 
                "', '" + ime + "', '" + imeRoditelja + "', '" + prezime + "'";
    }

    @Override
    public String postaviVrednostAtributa() {
        return  " Jmbg = '" + jmbg +
                "', Ime = '" + ime + "', ImeRoditelja = '" + imeRoditelja +
                "', Prezime = '" + prezime + "'";
    }

    
    public String vratiImeKlase() {
        return "UcesnikFizicko";
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return "UcesnikId = " + super.getUcesnikId();
    }

    @Override
    public String vratiUslovZaNadjiSlogove() {
        return "(1=1)";
    }       

    @Override
    public String vratiAtributPretrazivanja() {
        return super.vratiAtributPretrazivanja();
    }

    @Override
    public boolean Napuni(ResultSet rs) {
        super.Napuni(rs);
        try {
            jmbg = rs.getString("Jmbg");
            ime = rs.getString("Ime");
            imeRoditelja = rs.getString("ImeRoditelja");
            prezime = rs.getString("Prezime");
            
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean posaviVrednostZaAtributPretrazivanja(ResultSet rs) {
        return super.posaviVrednostZaAtributPretrazivanja(rs);
    }
    
    @Override
    public OpstiDomenskiObjekat vratiVezaniObjekat(int brojVezanogObjekata) {        
        //return super.vratiVezaniObjekat(brojVezanogObjekata);
        return null;
    }

    @Override
    public void Napuni(ResultSet rs, int brojSloga, int brojVeznogObjekta) {
        super.Napuni(rs, brojSloga, brojVeznogObjekta);
    }

    @Override
    public void kreirajVezaniObjekat(int brojStavkiVeznogObjekata, int brojVeznogObjekta) {
        super.kreirajVezaniObjekat(brojStavkiVeznogObjekata, brojVeznogObjekta);
    }

    @Override
    public int vratiBrojVezanihObjekata() {
        return super.vratiBrojVezanihObjekata() + 0;
    }

    @Override
    public OpstiDomenskiObjekat vratiSlogVezanogObjekta(int brojVeznogObjekta, int brojSloga) {
        return super.vratiSlogVezanogObjekta(brojVeznogObjekta, brojSloga);
    }

    @Override
    public int vratiBrojSlogovaVezanogObjekta(int brojVeznogObjekta) {
        return super.vratiBrojSlogovaVezanogObjekta(brojVeznogObjekta);
    }

    @Override
    public String vratiNazivNovogObjekta() {
        return "novi učesnik fizičko";
    }

    @Override
    public String vratiNazivObjkta() {       
        return "učesnik fizičko";
    }

    
    public String vratiVrednostZaInsert() {
        return String.format(super.vratiVrednostZaInsert(),super.vratiImeKlase()) +
            "\nINSERT INTO "+vratiImeKlase()+
            " VALUES ((SELECT MAX("+super.vratiAtributPretrazivanja()+") as "+"'"+super.vratiAtributPretrazivanja()+"'"+
            " FROM " + super.vratiImeKlase() + ")" + vratiVrednostAtributa() + ")";
    }

    @Override
    public String vratiVrednostZaSelect() {
        return  String.format(super.vratiVrednostZaSelect(), super.vratiImeKlase(), super.vratiUslovZaNadjiSlog()) +
                "\nSELECT *"+
                " FROM " + vratiImeKlase() +
                " WHERE " + vratiUslovZaNadjiSlog();
    }

    @Override
    public boolean Napuni(ResultSet rs, Map<String, String> map, String superClassName) {
        super.Napuni(rs, map, super.vratiImeKlase() );
        String index = map.get(superClassName != null ? superClassName : vratiImeKlase());
        try {
            jmbg = rs.getString(index+".[jmbg]");
            ime = rs.getString(index+".[ime]");
            imeRoditelja = rs.getString(index+".[imeRoditelja]");
            prezime = rs.getString(index+".[prezime]");
            
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    public String vratiVrednostZaUpdate() {
        return String.format(super.vratiVrednostZaUpdate(),super.vratiImeKlase(), super.postaviVrednostAtributa(), vratiUslovZaNadjiSlog()) +
            "\nUPDATE " + vratiImeKlase() +
            "\n SET " +  postaviVrednostAtributa() +
            "\n WHERE "  + vratiUslovZaNadjiSlog();
    }

}
