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
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Djapac
 */
public class Sto extends DomainObject implements Serializable{
    
    private long rbStola;
    private int brojStola;
    private VrstaStola vrstaStola;
    private int kapacitetStola;
    private RejonStola rejon;
    private RaspolozivostStola raspolozivost;

    public Sto() {
    }

    public Sto(int brojStola, VrstaStola vrstaStola, int kapacitetStola, RejonStola rejon, RaspolozivostStola raspolozivost) {
        this.brojStola = brojStola;
        this.vrstaStola = vrstaStola;
        this.kapacitetStola = kapacitetStola;
        this.rejon = rejon;
        this.raspolozivost = raspolozivost;
    }

   
    

    

    public int getBrojStola() {
        return brojStola;
    }

    public void setBrojStola(int brojStola) {
        this.brojStola = brojStola;
    }

    public long getRbStola() {
        return rbStola;
    }

    public void setRbStola(long rbStola) {
        this.rbStola = rbStola;
    }

    @Override
    public String toString() {
        return brojStola + " " + vrstaStola + " " ;
    }

    public VrstaStola getVrstaStola() {
        return vrstaStola;
    }

    public void setVrstaStola(VrstaStola vrstaStola) {
        this.vrstaStola = vrstaStola;
    }

    public int getKapacitetStola() {
        return kapacitetStola;
    }

    public void setKapacitetStola(int kapacitetStola) {
        this.kapacitetStola = kapacitetStola;
    }

    public RejonStola getRejon() {
        return rejon;
    }

    public void setRejon(RejonStola rejon) {
        this.rejon = rejon;
    }

    public RaspolozivostStola getRaspolozivost() {
        return raspolozivost;
    }

    public void setRaspolozivost(RaspolozivostStola raspolozivost) {
        this.raspolozivost = raspolozivost;
    }
    

    

    @Override
    public String getColumnsForSelect() {
        return "*";
    }

    @Override
    public String getTableName() {
        return "sto";
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
        return "raspolozivostStola,brojStola,vrstaStola,kapacitetStola,rejonStola";
    }

    @Override
    public void setParamsForInsert(PreparedStatement statement, DomainObject domainObject) {
        if (domainObject instanceof Sto) {
            try {
                Sto sto = (Sto) domainObject;
                statement.setString(1, sto.getRaspolozivost().toString());
                statement.setInt(2, sto.getBrojStola());
                statement.setString(3, sto.getVrstaStola().toString());
                statement.setInt(4, sto.getKapacitetStola());
                statement.setString(5, sto.getRejon().toString());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            throw new IllegalArgumentException("Očekivan objekat tipa Sto.");
        }
    }

    @Override
    public void setAutoIncrementPrimaryKey(long aLong) {
        setRbStola(aLong);
        
    }

    @Override
    public String getParamsForInsert() {
        return "?,?,?,?,?";
    }

    @Override
    public List<DomainObject> getParamsForSelect(ResultSet rs) throws Exception {
        List<DomainObject> lista = new ArrayList<>();
        while (rs.next()) {
            Sto sto = new Sto();
            sto.setRbStola(rs.getLong("stoID"));
            String raspolozivostStolaString = rs.getString("raspolozivostStola");
            RaspolozivostStola raspolozivost = RaspolozivostStola.valueOf(raspolozivostStolaString);
            sto.setRaspolozivost(raspolozivost);
            sto.setBrojStola(rs.getInt("brojStola"));
       
            String vrstaStolaString = rs.getString("vrstaStola");
            VrstaStola vrstaStola = VrstaStola.valueOf(vrstaStolaString);
            sto.setVrstaStola(vrstaStola);
            sto.setKapacitetStola(rs.getInt("kapacitetStola"));
            
            String rejonStolaString = rs.getString("rejonStola");
            RejonStola rejon = RejonStola.valueOf(rejonStolaString);
            sto.setRejon(rejon);
            
            
            lista.add(sto);
        }
        return lista;
    }

    @Override
    public String getReqForSearch() {
        return "brojStola";
    }

    @Override
    public void setParamsForSearch(PreparedStatement statement, DomainObject domainObject) {
        if (domainObject instanceof Sto) {
            try {
                Sto sto = (Sto) domainObject;
                int tekst =sto.getBrojStola();
              
                statement.setString(1, "%" + tekst + "" + "%");
                
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } 
        else{
            throw new IllegalArgumentException("Očekivan objekat tipa Sto");
        }
    }

    @Override
    public String getParamsForUpdate() {
        return "raspolozivostStola=?, brojStola=?, vrstaStola=?, kapacitetStola=?,rejonStola=? WHERE brojStola=?";
    }

    @Override
    public void setParamsForUpdate(PreparedStatement statement, DomainObject domainObject) {
        if (domainObject instanceof Sto) {
            try {
                Sto sto = (Sto) domainObject;
                statement.setString(1, sto.getRaspolozivost().toString());
                statement.setInt(2, sto.getBrojStola());
                statement.setString(3, sto.getVrstaStola().toString());
                statement.setInt(4, sto.getKapacitetStola());
                statement.setString(5, sto.getRejon().toString());
                statement.setInt(6, sto.getBrojStola());
                
                
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            throw new IllegalArgumentException("Očekivan objekat tipa Sto.");
        }
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
