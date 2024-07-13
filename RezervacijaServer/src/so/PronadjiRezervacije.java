/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.DomainObject;
import domain.Rezervacija;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Djapac
 */
public class PronadjiRezervacije extends AbstractSO{

   private List <Rezervacija> listaRezervacija = new ArrayList<>();
   private Rezervacija rezervacija;
    
    public PronadjiRezervacije(Rezervacija rezervacija) throws Exception {
        this.rezervacija = rezervacija;
    }
    
    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Rezervacija)) {
            throw new Exception("Object is not valid");
        }
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        List<DomainObject> domainObjects = databaseBroker.searchWithDoubleInnerJoin((DomainObject) object);
        for (DomainObject domainObject : domainObjects) {
            if (domainObject instanceof Rezervacija) {
                listaRezervacija.add((Rezervacija) domainObject);
            }
        }

        if (listaRezervacija.isEmpty()) {
           throw new Exception("Lista rezervacija je prazna");
        }
    }

    public List <Rezervacija> getListaRezervacija() {
        return listaRezervacija;
    }
    
    
    
}
