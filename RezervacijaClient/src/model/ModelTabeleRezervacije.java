/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import domain.Rezervacija;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Djapac
 */
public class ModelTabeleRezervacije extends AbstractTableModel{

    private List<Rezervacija> lista;
    private String[] kolone;
    
    public ModelTabeleRezervacije(){
        lista = new ArrayList<>();
        kolone = new String[]{"Broj rezervacije", "Datum od", "Komentar", "Broj ljudi", "Korisnik: ime i prezime"};
    }
    public ModelTabeleRezervacije(List<Rezervacija> lista){
        this.lista = lista;
        kolone = new String[]{"Broj rezervacije", "Datum od", "Komentar", "Broj ljudi", "Korisnik: ime i prezime"};
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Rezervacija rez = lista.get(rowIndex);
        
        switch(columnIndex){
            case 0: return rez.getBrojRezervacije();
            case 1: return rez.getDatumOd();
            case 2: return rez.getKomentar();
            case 3: return rez.getBrojLjudi();
            case 4: return rez.getKorisnik().getIme() + " " +rez.getKorisnik().getPrezime();
            default: return "N/A"; 
        } 
    }
    
    public List<Rezervacija> getLista() {
        return lista;
    }
    
    public Rezervacija getRezervacija(int red){
        return lista.get(red);
    }
    
    
    
}
