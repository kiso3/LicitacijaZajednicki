/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

/**
 *
 * @author Mladen
 */
@OdoPrimaryKey( primaryKey = {"ZapisnikLicitacijeId", "Rb"} )
public class StavkaZapisnikaLicitacije {
    
    private ZapisnikLicitacije zapisnikLicitacije;
    private int rb;
    private boolean pobednik;
    private boolean licitiranaCena;
    private int brLicitatorskeKartice;
    private boolean prisutan;
    private String prigovorPrimedba;
    private String odluka;
    private Prijava prijava;

    public StavkaZapisnikaLicitacije() {
    }

    public ZapisnikLicitacije getZapisnikLicitacije() {
        return zapisnikLicitacije;
    }

    public void setZapisnikLicitacije(ZapisnikLicitacije zapisnikLicitacije) {
        this.zapisnikLicitacije = zapisnikLicitacije;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public boolean isPobednik() {
        return pobednik;
    }

    public void setPobednik(boolean pobednik) {
        this.pobednik = pobednik;
    }

    public boolean isLicitiranaCena() {
        return licitiranaCena;
    }

    public void setLicitiranaCena(boolean licitiranaCena) {
        this.licitiranaCena = licitiranaCena;
    }

    public int getBrLicitatorskeKartice() {
        return brLicitatorskeKartice;
    }

    public void setBrLicitatorskeKartice(int brLicitatorskeKartice) {
        this.brLicitatorskeKartice = brLicitatorskeKartice;
    }

    public boolean isPrisutan() {
        return prisutan;
    }

    public void setPrisutan(boolean prisutan) {
        this.prisutan = prisutan;
    }

    public String getPrigovorPrimedba() {
        return prigovorPrimedba;
    }

    public void setPrigovorPrimedba(String prigovorPrimedba) {
        this.prigovorPrimedba = prigovorPrimedba;
    }

    public String getOdluka() {
        return odluka;
    }

    public void setOdluka(String odluka) {
        this.odluka = odluka;
    }

    public Prijava getPrijava() {
        return prijava;
    }

    public void setPrijava(Prijava prijava) {
        this.prijava = prijava;
    }
    
    
    
}
