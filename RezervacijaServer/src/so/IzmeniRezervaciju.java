/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.DomainObject;
import domain.Rezervacija;
import domain.StatusRezervacije;
import domain.StavkaRezervacije;

/**
 *
 * @author Djapac
 */
public class IzmeniRezervaciju extends AbstractSO{

    public IzmeniRezervaciju(Rezervacija izmenjenaRez) throws Exception {
        super();
    }
    
    

    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Rezervacija)) {
            throw new Exception("Object is not valid");
        }
        
        
        
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
         databaseBroker.update((Rezervacija) object);
        
        Rezervacija rez = (Rezervacija) object;
        for (StavkaRezervacije stavka : rez.getListaStavki()){
            
            if(stavka.getStatus().equals(StatusRezervacije.OTKAZANA)){
                stavka.setRezervacija(rez);
                databaseBroker.delete(stavka);
                
            }else if(stavka.getStatus().equals(StatusRezervacije.IZMENJENA)){
                
            stavka.setRezervacija(rez);
            databaseBroker.update(stavka);
                
            }
            
            
        }
    }
    }
    
