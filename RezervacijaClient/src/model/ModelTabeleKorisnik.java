/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import domain.Korisnik;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Djapac
 */
public class ModelTabeleKorisnik extends AbstractTableModel{
    
    private List<Korisnik> lista;
    private String[] kolone;
    

    public ModelTabeleKorisnik(List<Korisnik> listaKorisnika) {
        this.lista = listaKorisnika;
        kolone = new String[]{"Ime", "Prezime", "Datum rodjenja", "Broj telefona"};
    }
    
    public ModelTabeleKorisnik(){
        lista = new ArrayList<>();
        kolone = new String[]{"Ime", "Prezime", "Email", "Telefon"};
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
        Korisnik k = lista.get(rowIndex);
        switch(columnIndex){
            case 0: return k.getIme();
            case 1: return k.getPrezime();
            case 2: return k.getDatumRodjenja();
            case 3: return k.getBrojTelefona();
            default: return "N/A";
            
        }
    }
    
    public Korisnik getKorisnik(int red){
        return lista.get(red);
    }
    
    public void refresh(List<Korisnik> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }

    public List<Korisnik> getLista() {
        return lista;
    }


    
    
}
