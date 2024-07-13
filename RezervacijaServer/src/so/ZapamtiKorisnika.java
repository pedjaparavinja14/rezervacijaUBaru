/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.Korisnik;

/**
 *
 * @author Djapac
 */
public class ZapamtiKorisnika extends AbstractSO{
    
    public ZapamtiKorisnika() throws Exception {
        super();
    }

    @Override
    protected void validate(Object object) throws Exception {
        if (!(object instanceof Korisnik)) {
        throw new Exception("Prosleđeni objekat nije tipa Korisnik");
    }
    }

    @Override
    protected void executeOperation(Object object) throws Exception {
        databaseBroker.add((Korisnik) object);
    }
    
}
