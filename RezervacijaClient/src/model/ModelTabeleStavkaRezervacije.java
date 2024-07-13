/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import domain.StavkaRezervacije;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Djapac
 */
public class ModelTabeleStavkaRezervacije extends AbstractTableModel{
    
    List<StavkaRezervacije> lista;
    private String[] kolone;
    
    public ModelTabeleStavkaRezervacije(){
        lista = new ArrayList<>();
        kolone = new String[]{"Datum", "Sto", "Status rezervacije"};
    }
    
    public ModelTabeleStavkaRezervacije(List <StavkaRezervacije> lista) {
        this.lista = lista;
        kolone = new String[]{"Datum", "Sto", "Status rezervacije"};
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
       
        StavkaRezervacije stavka = lista.get(rowIndex);
       DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
       String formattedDate = stavka.getDatumRezervacije().format(dateFormatter);
        
        switch(columnIndex){
            case 0: return formattedDate;
            case 1: return stavka.getSto().getBrojStola() + " " + stavka.getSto().getRaspolozivost() +" " + stavka.getSto().getVrstaStola();
            case 2: return stavka.getStatus();
            default: return "N/A";
        }
    }
    
    public List<StavkaRezervacije> getLista() {
        return lista;
    }

    public void popuniStavke(StavkaRezervacije s) {
        boolean postojiStavka = false;
    for (StavkaRezervacije stavka : lista) {
        if (stavka.getSto().getRbStola() == s.getSto().getRbStola()){
            postojiStavka = true;
            break;
        }
    }
    if (!postojiStavka) {
        lista.add(s);
        fireTableDataChanged();
    }
       
    }
    
    public void updateTable(List<StavkaRezervacije> lista) {
        this.lista=lista;
        fireTableDataChanged();
    }

    public void refresh() {
        fireTableDataChanged();
    }

    public StavkaRezervacije getStavkaRezervacije(int red) {
        return lista.get(red);
    }
    
}
