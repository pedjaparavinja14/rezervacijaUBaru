/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.DomainObject;
import domain.Rezervacija;
import domain.StavkaRezervacije;
import java.util.List;

/**
 *
 * @author Djapac
 */
public class SacuvajRezervaciju extends AbstractSO{

    public SacuvajRezervaciju() throws Exception {
        super();
    }

    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Rezervacija)) {
            throw new Exception("Object is not valid");
        }
        Rezervacija rez = (Rezervacija) object;
        
        List<DomainObject> lista = databaseBroker.getAllWithDoubleInnerJoin(rez);
        
        for(DomainObject domainObject : lista){
            if(domainObject instanceof Rezervacija){
                 Rezervacija baza = (Rezervacija) domainObject;
                 
                 if(rez.getBrojRezervacije() == baza.getBrojRezervacije()){
                     throw new Exception("Rezervacija sa ovim brojem rezervacije već postoji u bazi!");
                 }
            }
        }
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        databaseBroker.add((Rezervacija) object);
        
        Rezervacija rez = (Rezervacija) object;
        for (StavkaRezervacije stavka : rez.getListaStavki()){
            stavka.setRezervacija(rez);
            databaseBroker.add(stavka);
        }
    }
    
}
