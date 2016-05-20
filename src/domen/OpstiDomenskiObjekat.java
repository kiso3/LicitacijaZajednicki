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
public interface OpstiDomenskiObjekat {

    public String vratiVrednostAtributa();
    
    public String postaviVrednostAtributa();
    
    public String vratiImeKlase();

    public String vratiUslovZaNadjiSlog();
    
    public String vratiUslovZaNadjiSlogove();

    public String vratiAtributPretrazivanja();
            
    public boolean Napuni(ResultSet rs);
    
    public boolean posaviVrednostZaAtributPretrazivanja(ResultSet rs);
    
    public OpstiDomenskiObjekat vratiVezaniObjekat(int brojVezanogObjekata);
    
    public void Napuni(ResultSet rs, int brojSloga, int brojVeznogObjekta);
    
    public void kreirajVezaniObjekat(int brojStavkiVeznogObjekata, int brojVeznogObjekta);
    
    public int vratiBrojVezanihObjekata();
    
    public OpstiDomenskiObjekat vratiSlogVezanogObjekta(int brojVeznogObjekta, int brojSloga);
    
    public int vratiBrojSlogovaVezanogObjekta(int brojVeznogObjekta);
    
    public String vratiNazivNovogObjekta();
    
    public String vratiNazivObjkta();
    
    public String vratiVrednostZaSelect();
    
    public String vratiVrednostZaInsert();
    
    public String vratiVrednostZaUpdate();

    public boolean Napuni(ResultSet rs, Map<String, String> map, String superClassName);

}
