/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Djapac
 */
public class ZaposleniUBaru extends DomainObject implements Serializable{
    
    private long zaposleniID;
    private String korisnickoIme;
    private String ime;
    private String prezime;
    private String sifra;
    private String brojLK;

    public ZaposleniUBaru() {
    }

    public ZaposleniUBaru(long zaposleniID, String korisnickoIme, String ime, String prezime, String sifra, String brojLK) {
        this.zaposleniID = zaposleniID;
        this.korisnickoIme = korisnickoIme;
        this.ime = ime;
        this.prezime = prezime;
        this.sifra = sifra;
        this.brojLK = brojLK;
    }

    public ZaposleniUBaru(String korisnickoIme, String sifra) {
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
    }
    

    public String getBrojLK() {
        return brojLK;
    }

    public void setBrojLK(String brojLK) {
        this.brojLK = brojLK;
    }

    public long getZaposleniID() {
        return zaposleniID;
    }

    public void setZaposleniID(long zaposleniID) {
        this.zaposleniID = zaposleniID;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    @Override
    public String toString() {
        return ime + " " + prezime + " Korisnicko ime: " + korisnickoIme;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ZaposleniUBaru other = (ZaposleniUBaru) obj;
        if (this.zaposleniID != other.zaposleniID) {
            return false;
        }
        if (!Objects.equals(this.korisnickoIme, other.korisnickoIme)) {
            return false;
        }
        if (!Objects.equals(this.ime, other.ime)) {
            return false;
        }
        if (!Objects.equals(this.prezime, other.prezime)) {
            return false;
        }
        if (!Objects.equals(this.sifra, other.sifra)) {
            return false;
        }
        return Objects.equals(this.brojLK, other.brojLK);
    }
    

    
    
    @Override
    public String getColumnsForSelect() {
        return "*";
    }

    @Override
    public String getTableName() {
        return "zaposleni";
    }

    @Override
    public void setParamsForSelect(PreparedStatement statement, DomainObject domainObject) {
        if (domainObject instanceof ZaposleniUBaru) {
             try {
                 ZaposleniUBaru zaposleni = (ZaposleniUBaru)domainObject;
                 statement.setString(1, zaposleni.getKorisnickoIme());
                 statement.setString(2, zaposleni.getSifra());
             } catch (SQLException ex) {
                 ex.printStackTrace();
             }
        }
    }

    @Override
    public DomainObject getParamsForSelect2(ResultSet rs, DomainObject domainObject) {
        ZaposleniUBaru zaposleni = new ZaposleniUBaru();
        if (domainObject instanceof ZaposleniUBaru) {
            try {
                zaposleni = (ZaposleniUBaru)domainObject;
                if (rs.next()) {
                    zaposleni.setZaposleniID(rs.getLong("zaposleniID"));
                    zaposleni.setIme(rs.getString("ime"));
                    zaposleni.setPrezime(rs.getString("prezime"));
                }
                else{
                    zaposleni=null;
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return (DomainObject)zaposleni;
    }

    @Override
    public String getParamsForSelect1() {
        return "korisnickoIme=? AND sifra=?";
    }

    @Override
    public String getColumnsForInsert() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setParamsForInsert(PreparedStatement statement, DomainObject domainObject) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setAutoIncrementPrimaryKey(long aLong) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getParamsForInsert() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<DomainObject> getParamsForSelect(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getReqForSearch() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setParamsForSearch(PreparedStatement statement, DomainObject domainObject) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getParamsForUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setParamsForUpdate(PreparedStatement statement, DomainObject domainObject) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getInnerJoin1() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getInnerJoin2() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getTableName2() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getParamsForDelete() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setParamsForDelete(PreparedStatement statement, DomainObject domainObject) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
    
}
