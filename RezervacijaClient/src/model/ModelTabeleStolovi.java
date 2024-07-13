/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import domain.Sto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Djapac
 */
public class ModelTabeleStolovi extends AbstractTableModel{

    private List<Sto> lista;
    private String[] kolone;
    
    public ModelTabeleStolovi(List<Sto> lista) {
        this.lista = lista;
        kolone = new String[]{"Raspolozivost", "Broj", "Vrsta stola", "Kapacitet", "Rejon"};
    }
    
    public ModelTabeleStolovi(){
        lista = new ArrayList<>();
        kolone = new String[]{"Raspolozivost", "Broj", "Vrsta stola", "Kapacitet", "Rejon"};
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
        Sto sto = lista.get(rowIndex);
        
        switch(columnIndex){
            case 0: return sto.getRaspolozivost();
            case 1: return sto.getBrojStola();
            case 2: return sto.getVrstaStola();
            case 3: return sto.getKapacitetStola();
            case 4: return sto.getRejon();
            default: return "N/A";
        }
        
    }

    public Sto getSto(int red){
        return lista.get(red);
    }
    
    public void refresh(List<Sto> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }

    public List<Sto> getLista() {
        return lista;
    }
    
    
}
