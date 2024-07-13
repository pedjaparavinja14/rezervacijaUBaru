/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Djapac
 */
public class Korisnik extends DomainObject implements Serializable{
    
    private long korisnikID;
    private String ime;
    private String prezime;
    private LocalDate datumRodjenja;
    private String brojTelefona;

    public Korisnik() {
    }

    public Korisnik(long korisnikID, String ime, String prezime, LocalDate datumRodjenja, String brojTelefona) {
        this.korisnikID = korisnikID;
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
        this.brojTelefona = brojTelefona;
    }

    public Korisnik(String ime, String prezime, LocalDate datumRodjenja, String brojTelefona) {
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
        this.brojTelefona = brojTelefona;
    }


    

   

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public long getKorisnikID() {
        return korisnikID;
    }

    public void setKorisnikID(long korisnikID) {
        this.korisnikID = korisnikID;
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

    

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Korisnik other = (Korisnik) obj;
        if (this.korisnikID != other.korisnikID) {
            return false;
        }
        if (!Objects.equals(this.ime, other.ime)) {
            return false;
        }
        if (!Objects.equals(this.prezime, other.prezime)) {
            return false;
        }
        if (!Objects.equals(this.brojTelefona, other.brojTelefona)) {
            return false;
        }
        return Objects.equals(this.datumRodjenja, other.datumRodjenja);
    }
    
    

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public String getColumnsForSelect() {
        return "*";
    }

    @Override
    public String getTableName() {
        return "korisnik";
    }

    @Override
    public void setParamsForSelect(PreparedStatement statement, DomainObject domainObject) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DomainObject getParamsForSelect2(ResultSet rs, DomainObject domainObject) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getParamsForSelect1() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getColumnsForInsert() {
        return "ime,prezime,datumRodjenja,telefon";
    }

    @Override
    public void setParamsForInsert(PreparedStatement statement, DomainObject domainObject) {
        
        if (domainObject instanceof Korisnik) {
            try {
                Korisnik korisnik = (Korisnik) domainObject;
                statement.setString(1, korisnik.getIme());
                statement.setString(2, korisnik.getPrezime());
                statement.setDate(3, java.sql.Date.valueOf(korisnik.getDatumRodjenja()));
                statement.setString(4, korisnik.getBrojTelefona());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            throw new IllegalArgumentException("Ocekivan objekat tipa Korisnik.");
        }
    }

    @Override
    public void setAutoIncrementPrimaryKey(long aLong) {
        setKorisnikID(aLong);
    }
    

    @Override
    public String getParamsForInsert() {
        return "?,?,?,?";
    }

    @Override
    public List<DomainObject> getParamsForSelect(ResultSet rs) throws Exception {
        List<DomainObject> lista = new ArrayList<>();
        while (rs.next()) {
            Korisnik korisnik = new Korisnik();
            korisnik.setKorisnikID(rs.getLong("korisnikID"));
            korisnik.setIme(rs.getString("ime"));
            korisnik.setPrezime(rs.getString("prezime"));
            
            LocalDate datumRodjenja = LocalDate.parse(rs.getString("datumRodjenja")); 
            korisnik.setDatumRodjenja(datumRodjenja);
            korisnik.setBrojTelefona(rs.getString("telefon"));
            lista.add(korisnik);
        }
        return lista;
    }

    @Override
    public String getReqForSearch() {
        return "ime";
    }

    @Override
    public void setParamsForSearch(PreparedStatement statement, DomainObject domainObject) {
        if (domainObject instanceof Korisnik) {
            try {
                Korisnik korisnik = (Korisnik) domainObject;
                String tekst =korisnik.getIme();
              
                statement.setString(1, "%" + tekst + "%");
                
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } 
        else{
            throw new IllegalArgumentException("Ocekivan objekat tipa Korisnik");
        }
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
        return "WHERE korisnikID = ?";
    }

    @Override
    public void setParamsForDelete(PreparedStatement statement, DomainObject domainObject) {
        if (domainObject instanceof Korisnik) {
            try {
                Korisnik korisnik = (Korisnik) domainObject;
                statement.setLong(1, korisnik.getKorisnikID());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            throw new IllegalArgumentException("Očekivan objekat tipa Korisnik.");
        }
    }

    public LocalDate getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(LocalDate datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }
    
    
    
   
   
    
    
    
}
