/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.DomainObject;
import domain.Sto;
import java.util.List;

/**
 *
 * @author Djapac
 */
public class ZapamtiSto extends AbstractSO{
    
    public ZapamtiSto() throws Exception {
        super();
    }

    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Sto)) {
        throw new Exception("Prosleđeni objekat nije tipa Sto");
    }
        Sto sto = (Sto) object;
        
        List<DomainObject> lista = databaseBroker.getAll(sto);
        
        for(DomainObject domainObject : lista){
            if(domainObject instanceof Sto){
                 Sto baza = (Sto) domainObject;
                 
                 if(sto.getBrojStola() == baza.getBrojStola()){
                     throw new Exception("Sto sa ovim rednim brojem već postoji u bazi!");
                 }
            }
        }
        
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        databaseBroker.add((Sto) object);
    }
    
    
}
