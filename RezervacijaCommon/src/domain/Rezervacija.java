/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java.util.List;

/**
 *
 * @author Djapac
 */
public class Rezervacija extends DomainObject implements Serializable{
    
    private long rezervacijaID;
    private LocalDateTime datumOd;
    private String komentar;
    private int brojLjudi;
    private List<StavkaRezervacije> listaStavki;
    private Korisnik korisnik;
    private ZaposleniUBaru zaposleni;
    private int brojRezervacije;
    
  
    public Rezervacija() {
    }

    public Rezervacija(LocalDateTime datumOd, String komentar, int brojLjudi, List<StavkaRezervacije> listaStavki, Korisnik korisnik, ZaposleniUBaru zaposleni, int brojRezervacije) {
        this.datumOd = datumOd;
        this.komentar = komentar;
        this.brojLjudi = brojLjudi;
        this.listaStavki = listaStavki;
        this.korisnik = korisnik;
        this.zaposleni = zaposleni;
        this.brojRezervacije = brojRezervacije;
    }

    
    
    

    public int getBrojLjudi() {
        return brojLjudi;
    }

    public void setBrojLjudi(int brojLjudi) {
        this.brojLjudi = brojLjudi;
    }

    public long getRezervacijaID() {
        return rezervacijaID;
    }

    public void setRezervacijaID(long rezervacijaID) {
        this.rezervacijaID = rezervacijaID;
    }

    

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

    @Override
    public String toString() {
        return "Rezervacija{" + "rezervacijaID=" + rezervacijaID + ", datumOd=" + datumOd + ", komentar=" + komentar + ", brojLjudi=" + brojLjudi + ", listaStavki=" + listaStavki + ", korisnik=" + korisnik + ", zaposleni=" + zaposleni + ", brojRezervacije=" + brojRezervacije + '}';
    }

    

    @Override
    public String getColumnsForSelect() {
        return "*";
    }

    @Override
    public String getTableName() {
        return "rezervacija";
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

    public List<StavkaRezervacije> getListaStavki() {
        return listaStavki;
    }

    public void setListaStavki(List<StavkaRezervacije> listaStavki) {
        this.listaStavki = listaStavki;
    }

    @Override
    public String getColumnsForInsert() {
        return "datumOd,komentar,brojLjudi,korisnikID,zaposleniID,brojRezervacije";
    }

    @Override
    public void setParamsForInsert(PreparedStatement statement, DomainObject domainObject) {
        if (domainObject instanceof Rezervacija) {
            try {
                Rezervacija rez = (Rezervacija) domainObject;
                statement.setTimestamp(1, Timestamp.valueOf(datumOd));
                statement.setString(2, rez.getKomentar());
                statement.setInt(3, rez.getBrojLjudi());
                statement.setLong(4, rez.getKorisnik().getKorisnikID());
                statement.setLong(5, rez.getZaposleni().getZaposleniID());
                statement.setInt(6, rez.getBrojRezervacije());
                
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            throw new IllegalArgumentException("Ocekivan objekat tipa Rezervacija.");
        }
    }

    @Override
    public void setAutoIncrementPrimaryKey(long aLong) {
        setRezervacijaID(aLong);
        
    }

    @Override
    public String getParamsForInsert() {
        return "?,?,?,?,?,?";
    }

    @Override
    public List<DomainObject> getParamsForSelect(ResultSet rs) throws Exception {
        List<DomainObject> lista = new ArrayList<>();
        
        while (rs.next()) {
            Rezervacija rez = new Rezervacija();
            rez.setRezervacijaID(rs.getLong("rezervacijaID"));
            rez.setKomentar(rs.getString("komentar"));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime datumOd = LocalDateTime.parse(rs.getString("datumOd"), formatter); 
            rez.setDatumOd(datumOd);
            rez.setBrojLjudi(rs.getInt("brojLjudi"));
            rez.setBrojRezervacije(rs.getInt("brojRezervacije"));
            
            
       
            ZaposleniUBaru zaposleni = new ZaposleniUBaru();
            zaposleni.setZaposleniID(rs.getLong("z.zaposleniID"));
            zaposleni.setKorisnickoIme(rs.getString("z.korisnickoIme"));
            zaposleni.setIme(rs.getString("z.ime"));
            zaposleni.setPrezime(rs.getString("z.prezime"));
            zaposleni.setSifra(rs.getString("z.sifra"));
            zaposleni.setBrojLK(rs.getString("brojLK"));
            
            Korisnik korisnik = new Korisnik();
            korisnik.setKorisnikID(rs.getLong("k.korisnikID"));
            korisnik.setIme(rs.getString("k.ime"));
            korisnik.setPrezime(rs.getString("k.prezime"));
            korisnik.setDatumRodjenja(rs.getDate("k.datumRodjenja").toLocalDate());
            korisnik.setBrojTelefona(rs.getString("k.telefon"));
            
            rez.setZaposleni(zaposleni);
            rez.setKorisnik(korisnik);
            
            lista.add(rez);   
        }
        return lista;
    }

    @Override
    public String getReqForSearch() {
        return "brojRezervacije";
    }

    @Override
    public void setParamsForSearch(PreparedStatement statement, DomainObject domainObject) {
        if (domainObject instanceof Rezervacija) {
            try {
                Rezervacija rez = (Rezervacija) domainObject;
                int brRez = rez.getBrojRezervacije();
                statement.setString(1, "%" + brRez + "%");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } 
        else{
            throw new IllegalArgumentException("Ocekivan objekat tipa Rezervacija");
        }
    }

    @Override
    public String getParamsForUpdate() {
        return "datumOd=?,komentar=?,brojLjudi=?,korisnikID=?,zaposleniID=?,brojRezervacije=? WHERE brojRezervacije=?";
    }

    @Override
    public void setParamsForUpdate(PreparedStatement statement, DomainObject domainObject) {
        if (domainObject instanceof Rezervacija) {
            try {
                Rezervacija rez = (Rezervacija) domainObject;
                statement.setTimestamp(1, Timestamp.valueOf(datumOd));
                statement.setString(2, rez.getKomentar());
                statement.setInt(3, rez.getBrojLjudi());
                statement.setLong(4, rez.getKorisnik().getKorisnikID());
                statement.setLong(5, rez.getZaposleni().getZaposleniID());
                statement.setInt(6, rez.getBrojRezervacije());
                statement.setInt(7, rez.getBrojRezervacije());
                
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            throw new IllegalArgumentException("Ocekivan objekat tipa Rezervacija.");
        }
    }

    @Override
    public String getInnerJoin1() {
        return "korisnik k ON r.korisnikID=k.korisnikID";
    }

    @Override
    public String getInnerJoin2() {
        return "zaposleni z ON r.zaposleniID=z.zaposleniID";
    }

    @Override
    public String getTableName2() {
        return "rezervacija r";
    }

    @Override
    public String getParamsForDelete() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setParamsForDelete(PreparedStatement statement, DomainObject domainObject) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public ZaposleniUBaru getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(ZaposleniUBaru zaposleni) {
        this.zaposleni = zaposleni;
    }

    public LocalDateTime getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(LocalDateTime datumOd) {
        this.datumOd = datumOd;
    }


    public int getBrojRezervacije() {
        return brojRezervacije;
    }

    public void setBrojRezervacije(int brojRezervacije) {
        this.brojRezervacije = brojRezervacije;
    }
    
    
    
    
    
    
}
