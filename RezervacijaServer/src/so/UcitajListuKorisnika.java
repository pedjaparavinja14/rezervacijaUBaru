/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.DomainObject;
import domain.Korisnik;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Djapac
 */
public class UcitajListuKorisnika extends AbstractSO{
    
     private List<Korisnik> listaKorisnika = new ArrayList<>();

    public UcitajListuKorisnika() throws Exception {
        super();
    }


    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Korisnik)) {
            throw new Exception("Object is not valid");
        }
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        List<DomainObject> domainObjects = databaseBroker.getAll((DomainObject) object);

        for (DomainObject domainObject : domainObjects) {
            if (domainObject instanceof Korisnik) {
                listaKorisnika.add((Korisnik) domainObject);
            }
        }

        if (listaKorisnika.isEmpty()) {
            throw new Exception("Lista korisnika je prazna.");
        }
        
    }
    
    public List<Korisnik> getListaKorisnika() {
        return listaKorisnika;
    }
    
    
    
}
