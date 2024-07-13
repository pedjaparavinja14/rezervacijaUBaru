/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.DomainObject;
import domain.Sto;

/**
 *
 * @author Djapac
 */
public class IzmeniSto extends AbstractSO{

    public IzmeniSto() throws Exception {
        super();
    }
    
    

    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Sto)) {
            throw new Exception("Object is not valid");
        }
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        databaseBroker.update((DomainObject) object);
    }
    
}
