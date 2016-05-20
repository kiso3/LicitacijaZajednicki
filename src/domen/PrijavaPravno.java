/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.util.Map;

/**
 *
 * @author Mladen
 */
public class PrijavaPravno extends Prijava{
    
    private boolean izvodIzPrivrednogRegistra;
    private UcesnikPravno ucesnikPravno;

    public PrijavaPravno() {
        ucesnikPravno = new UcesnikPravno();
    }

    public boolean isIzvodIzPrivrednogRegistra() {
        return izvodIzPrivrednogRegistra;
    }

    public void setIzvodIzPrivrednogRegistra(boolean IzvodIzPrivrednogRegistra) {
        this.izvodIzPrivrednogRegistra = IzvodIzPrivrednogRegistra;
    }

    public UcesnikPravno getUcesnikPravno() {
        return ucesnikPravno;
    }

    public void setUcesnikPravno(UcesnikPravno ucesnikPravno) {
        this.ucesnikPravno = ucesnikPravno;
    }

    @Override
    public String vratiVrednostAtributa() {
        return ", " +  (izvodIzPrivrednogRegistra ? 1: 0) +                
            ", " + ucesnikPravno.getUcesnikId();
    }

    @Override
    public String postaviVrednostAtributa() {
        return " IzvodIzPrivrednogRegistra =  " +  (izvodIzPrivrednogRegistra ? 1: 0) +            
            ", UcesnikId = " + ucesnikPravno.getUcesnikId();
    }

    @Override
    public String vratiImeKlase() {
        return "PrijavaPravno";
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return super.vratiUslovZaNadjiSlog();
    }

    @Override
    public String vratiUslovZaNadjiSlogove() {
        return super.vratiUslovZaNadjiSlogove();
    }

    @Override
    public String vratiAtributPretrazivanja() {
        return super.vratiAtributPretrazivanja();
    }

    @Override
    public boolean Napuni(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean posaviVrednostZaAtributPretrazivanja(ResultSet rs) {
        return super.posaviVrednostZaAtributPretrazivanja(rs);
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
        return "nova prijava pravno";
    }

    @Override
    public String vratiNazivObjkta() {
        return "prijava pravno";
    }

    @Override
    public String vratiVrednostZaSelect() {
        return  String.format(super.vratiVrednostZaSelect(), super.vratiImeKlase(), super.vratiUslovZaNadjiSlog()) +
            "\nSELECT *"+
            " FROM " + vratiImeKlase() +
            " WHERE " + vratiUslovZaNadjiSlog();
    }

    @Override
    public String vratiVrednostZaInsert() {
        return String.format(super.vratiVrednostZaInsert(),super.vratiImeKlase()) +
            "\nINSERT INTO "+vratiImeKlase()+
            " VALUES ((SELECT MAX("+super.vratiAtributPretrazivanja()+") as "+"'"+super.vratiAtributPretrazivanja()+"'"+
            " FROM " + super.vratiImeKlase() + ")" + vratiVrednostAtributa() + ")";
    }

    @Override
    public String vratiVrednostZaUpdate() {
        return String.format(super.vratiVrednostZaUpdate(),super.vratiImeKlase(), super.postaviVrednostAtributa(), vratiUslovZaNadjiSlog()) +
            "\nUPDATE " + vratiImeKlase() +
            "\n SET " +  postaviVrednostAtributa() +
            "\n WHERE "  + vratiUslovZaNadjiSlog();
    }

    @Override
    public boolean Napuni(ResultSet rs, Map<String, String> map, String superClassName) {
        super.Napuni(rs, map, super.vratiImeKlase() );
        String index = map.get(superClassName != null ? superClassName : vratiImeKlase());
        try {            
            ucesnikPravno.Napuni(rs, map, null);
            izvodIzPrivrednogRegistra = rs.getInt(index+".[izvodIzPrivrednogRegistra]") != 0;            
            
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
    
    
}
