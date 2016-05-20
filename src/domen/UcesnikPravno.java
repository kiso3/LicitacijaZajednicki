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
public class UcesnikPravno extends Ucesnik{
    
    private String mb;
    private String naziv;
    private String pib;

    public UcesnikPravno() {
    }

    public String getMb() {
        return mb;
    }

    public void setMb(String mb) {
        this.mb = mb;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    @Override
    public String vratiVrednostAtributa() {
        return ", '" + mb + "', '" + naziv +
                "', '" + pib + "'";
    }

    @Override
    public String postaviVrednostAtributa() {
        return  " Mb = '" + mb + "'"+
                ", Naziv = '" + naziv + "'"+
                ", Pib = '" + pib +"'";
                
    }

    @Override
    public String vratiImeKlase() {
        return "UcesnikPravno";
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
            mb = rs.getString("mb");
            naziv = rs.getString("Naziv");
            pib = rs.getString("Pib");            
            
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
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
        return "novi učesnik pravno";
    }

    @Override
    public String vratiNazivObjkta() {
        return "učesnik pravno";
    }

    @Override
    public String vratiVrednostZaInsert(){
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
            mb = rs.getString(index+".[mb]");
            naziv = rs.getString(index+".[naziv]");
            pib = rs.getString(index+".[pib]");            
            
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
