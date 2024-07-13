/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.DomainObject;
import domain.Sto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Djapac
 */
public class UcitajListuStolova extends AbstractSO{

    private List<Sto> listaStolova = new ArrayList<>();
    
    
    public UcitajListuStolova() throws Exception {
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
        List<DomainObject> domainObjects = databaseBroker.getAll((DomainObject) object);

        for (DomainObject domainObject : domainObjects) {
            if (domainObject instanceof Sto) {
                listaStolova.add((Sto) domainObject);
            }
        }

        if (listaStolova.isEmpty()) {
            throw new Exception("Lista stolova je prazna.");
        }
    }

    public List<Sto> getListaStolova() {
        return listaStolova;
    }
    
    
    
}