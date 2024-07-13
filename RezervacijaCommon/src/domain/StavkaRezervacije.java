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
import java.util.Date;
import java.util.List;

/**
 *
 * @author Djapac
 */
public class StavkaRezervacije extends DomainObject implements Serializable{
    
    private long redniBroj;
    private Rezervacija rezervacija;
    private LocalDate datumRezervacije;
    private Sto sto;
    private StatusRezervacije status;
    
    public StavkaRezervacije() {
    }

    public StavkaRezervacije(Rezervacija rezervacija, LocalDate datumRezervacije, Sto sto) {
       
        this.rezervacija = rezervacija;
        this.datumRezervacije = datumRezervacije;
        this.sto = sto;
    }

    public StavkaRezervacije(Rezervacija rezervacija, LocalDate datumRezervacije, Sto sto, StatusRezervacije status) {
        this.rezervacija = rezervacija;
        this.datumRezervacije = datumRezervacije;
        this.sto = sto;
        this.status = status;
    }
   
    

    

    public long getRedniBroj() {
        return redniBroj;
    }

    public void setRedniBroj(long redniBroj) {
        this.redniBroj = redniBroj;
    }

    public Rezervacija getRezervacija() {
        return rezervacija;
    }

    public void setRezervacija(Rezervacija rezervacija) {
        this.rezervacija = rezervacija;
    }

    @Override
    public String toString() {
        return "StavkaRezervacije{" + "redniBroj=" + redniBroj + ", rezervacija=" + rezervacija + ", datumRezervacije=" + datumRezervacije + '}';
    }


    @Override
    public String getColumnsForSelect() {
        return "*";
    }

    @Override
    public String getTableName() {
        return "stavkarezervacije";
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
        return "datumRezervacije,rezervacijaID,stoID,status";
        
   }

    @Override
    public void setParamsForInsert(PreparedStatement statement, DomainObject domainObject) {
        if (domainObject instanceof StavkaRezervacije) {
            try {
                StavkaRezervacije stavka = (StavkaRezervacije) domainObject;
                statement.setDate(1, java.sql.Date.valueOf(stavka.getDatumRezervacije()));
                statement.setLong(2, stavka.getRezervacija().getRezervacijaID());
                statement.setLong(3, stavka.getSto().getRbStola());
                statement.setString(4, stavka.getStatus().toString());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            throw new IllegalArgumentException("Očekivan objekat nije tipa Stavka rezervacije.");
        }
    }

    @Override
    public void setAutoIncrementPrimaryKey(long aLong) {
        setRedniBroj(aLong);
        
    }

    @Override
    public String getParamsForInsert() {
        return "?,?,?,?";
        
    }

    @Override
    public List<DomainObject> getParamsForSelect(ResultSet rs) throws Exception {
        List<DomainObject> lista = new ArrayList<>();
        
        while (rs.next()){
         StavkaRezervacije stavkaRez = new StavkaRezervacije();
         Rezervacija rez = new Rezervacija();
         rez.setRezervacijaID(rs.getLong("rezervacijaID"));
         
         stavkaRez.setRezervacija(rez);
         stavkaRez.setRedniBroj(rs.getLong("redniBroj"));
         
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
         LocalDate datumOd = LocalDate.parse(rs.getString("datumRezervacije"), formatter); 
         stavkaRez.setDatumRezervacije(datumOd);
         
         String statusStr = rs.getString("status");
         StatusRezervacije status = StatusRezervacije.valueOf(statusStr);
         stavkaRez.setStatus(status);
         
         Sto sto = new Sto();
         sto.setRbStola(rs.getLong("s.stoID"));  
         sto.setBrojStola(rs.getInt("s.brojStola"));
       
         String raspolozivostStr = rs.getString("s.raspolozivostStola");
         RaspolozivostStola raspolozivost = RaspolozivostStola.valueOf(raspolozivostStr);
         sto.setRaspolozivost(raspolozivost);
         
         String vrstaStolaString = rs.getString("s.vrstaStola");
         VrstaStola vrstaStola = VrstaStola.valueOf(vrstaStolaString);
         sto.setVrstaStola(vrstaStola);
         sto.setKapacitetStola(rs.getInt("s.kapacitetStola"));
            
         String rejonStolaString = rs.getString("s.rejonStola");
         RejonStola rejonStola = RejonStola.valueOf(rejonStolaString);
         sto.setRejon(rejonStola);
         
         stavkaRez.setSto(sto);
        
         
         
         
         
            
            
        lista.add(stavkaRez);
        }
        return lista;
    }

    @Override
    public String getReqForSearch() {
        return "rezervacijaID";
    }

    @Override
    public void setParamsForSearch(PreparedStatement statement, DomainObject domainObject) {
        if (domainObject instanceof StavkaRezervacije) {
            try {
                StavkaRezervacije stavkaRez = (StavkaRezervacije) domainObject;
                long brRez = stavkaRez.getRezervacija().getRezervacijaID();
                statement.setString(1, "%" + brRez + "%");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } 
        else{
            throw new IllegalArgumentException("Ocekivan objekat tipa Stavka rezervacije");
        }
    }

    @Override
    public String getParamsForUpdate() {
        return "datumRezervacije=?,rezervacijaID=?,stoID=?,status=? WHERE rezervacijaID = ?";
    }

    @Override
    public void setParamsForUpdate(PreparedStatement statement, DomainObject domainObject) {
        if (domainObject instanceof StavkaRezervacije) {
            try {
                StavkaRezervacije stavkaRez = (StavkaRezervacije) domainObject;
                statement.setDate(1, java.sql.Date.valueOf(stavkaRez.getDatumRezervacije()));
                statement.setLong(2, stavkaRez.getRezervacija().getRezervacijaID());
                statement.setLong(3, stavkaRez.getSto().getRbStola());
                statement.setString(4, stavkaRez.getStatus().toString());
                statement.setLong(5, stavkaRez.getRezervacija().getRezervacijaID());
                
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            throw new IllegalArgumentException("Očekivan objekat nije tipa Stavka rezervacije.");
        }
    }

    @Override
    public String getInnerJoin1() {
        return "sto s ON sr.stoID=s.stoID";
    }

    @Override
    public String getInnerJoin2() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getTableName2() {
        return "stavkarezervacije sr";
    }

    @Override
    public String getParamsForDelete() {
        return "WHERE rezervacijaID = ?";
    }

    @Override
    public void setParamsForDelete(PreparedStatement statement, DomainObject domainObject) {
        if (domainObject instanceof StavkaRezervacije) {
            try {
                StavkaRezervacije st = (StavkaRezervacije) domainObject;
                statement.setLong(1, st.getRezervacija().getRezervacijaID());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            throw new IllegalArgumentException("Očekivan objekat tipa Stavka rezervacije.");
        }
    }

    public Sto getSto() {
        return sto;
    }

    public void setSto(Sto sto) {
        this.sto = sto;
    }

    public LocalDate getDatumRezervacije() {
        return datumRezervacije;
    }

    public void setDatumRezervacije(LocalDate datumRezervacije) {
        this.datumRezervacije = datumRezervacije;
    }

    public StatusRezervacije getStatus() {
        return status;
    }

    public void setStatus(StatusRezervacije status) {
        this.status = status;
    }
    
    
    
}
