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
public class PronadjiSto extends AbstractSO{
    
    private List<Sto> listaKorisnika = new ArrayList<>();
    private Sto sto;

    public PronadjiSto(Sto sto) throws Exception {
        this.sto = sto;
    }

    
    
    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Sto)) {
            throw new Exception("Object is not valid");
        }
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        List<DomainObject> domainObjects = databaseBroker.search((DomainObject) object);

        
        for (DomainObject domainObject : domainObjects) {
            if (domainObject instanceof Sto) {
                listaKorisnika.add((Sto) domainObject);
            }
        }  
        if (listaKorisnika.isEmpty()) {
           throw new Exception("Lista stolova je prazna");
        }
    }

    public List<Sto> getListaStolova() {
        return listaKorisnika;
    }
    
    
    
}
