/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.DomainObject;
import domain.ZaposleniUBaru;

/**
 *
 * @author Djapac
 */
public class PrijaviZaposlenogUBaru extends AbstractSO{

    private ZaposleniUBaru zaposleniUBaru;

    public PrijaviZaposlenogUBaru() throws Exception {
        super();
    }
    
    
    
    
    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof ZaposleniUBaru)) {
            throw new Exception("Object is not valid");
        }
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        
        DomainObject domainObject=databaseBroker.login((DomainObject)object);
        
        if (domainObject instanceof ZaposleniUBaru) {
            zaposleniUBaru = (ZaposleniUBaru)domainObject;
        }
    }

    public ZaposleniUBaru getZaposleniUBaru() {
        return zaposleniUBaru;
    }
    
    
    
    
}
