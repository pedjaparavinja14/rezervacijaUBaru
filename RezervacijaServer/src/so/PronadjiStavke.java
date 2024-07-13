/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.DomainObject;
import domain.StavkaRezervacije;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Djapac
 */
public class PronadjiStavke extends AbstractSO{

    private List<StavkaRezervacije> listaStavki = new ArrayList<>();
    private StavkaRezervacije stavkaRez;
    
    public PronadjiStavke(StavkaRezervacije pretragaStavke) throws Exception {
        this.stavkaRez = pretragaStavke;
    }
    
    
    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof StavkaRezervacije)) {
            throw new Exception("Object is not valid!");
        }
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        List<DomainObject> domainObjects = databaseBroker.searchWithInnerJoin((DomainObject) object);

        
        for (DomainObject domainObject : domainObjects) {
            if (domainObject instanceof StavkaRezervacije) {
                listaStavki.add((StavkaRezervacije) domainObject);
            }
        }  
        if (listaStavki.isEmpty()) {
           throw new Exception("Lista stavki je prazna");
        }
    }

    public List<StavkaRezervacije> getListaStavki() {
        return listaStavki;
    }
    
    
    
}
