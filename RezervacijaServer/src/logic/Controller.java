/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import domain.DomainObject;
import domain.Korisnik;
import domain.Rezervacija;
import domain.StavkaRezervacije;
import domain.Sto;
import domain.ZaposleniUBaru;
import java.util.List;
import so.IzmeniRezervaciju;
import so.IzmeniSto;
import so.ObrisiKorisnika;
import so.PrijaviZaposlenogUBaru;
import so.PronadjiKorisnike;
import so.PronadjiRezervacije;
import so.PronadjiStavke;
import so.PronadjiSto;
import so.SacuvajRezervaciju;
import so.UcitajListuKorisnika;
import so.UcitajListuRezervacija;
import so.UcitajListuStolova;
import so.ZapamtiKorisnika;
import so.ZapamtiSto;

/**
 *
 * @author Djapac
 */
public class Controller {
    
    public Object login(ZaposleniUBaru zaposleni) throws Exception {
        PrijaviZaposlenogUBaru loginZaposleni = new PrijaviZaposlenogUBaru();
        loginZaposleni.execute(zaposleni);
        return loginZaposleni.getZaposleniUBaru();
    }

    public Object getAllUsers() throws Exception{
        UcitajListuKorisnika ucitajKorisnike = new UcitajListuKorisnika();
        ucitajKorisnike.execute(new Korisnik());
        return ucitajKorisnike.getListaKorisnika();    }

    public void createUser(Korisnik korisnik) throws Exception {
        ZapamtiKorisnika kreiraniKorisnik = new ZapamtiKorisnika();
        kreiraniKorisnik.execute(korisnik);
    }

    public void createTable(Sto sto) throws Exception {
        ZapamtiSto kreiraniSto = new ZapamtiSto();
        kreiraniSto.execute(sto);
        
    }

    public Object getAllTables() throws Exception{
        UcitajListuStolova ucitajStolove = new UcitajListuStolova();
        ucitajStolove.execute(new Sto());
        return ucitajStolove.getListaStolova();
        
    }

    public Object searchUsers(Korisnik pretragaKorisnika) throws Exception{
       PronadjiKorisnike pronadjiKorisnike = new PronadjiKorisnike(pretragaKorisnika);
        pronadjiKorisnike.execute(pretragaKorisnika);
        return pronadjiKorisnike.getListaKorisnika();
    }

    public void deleteUser(Korisnik obrisanKorisnik) throws Exception{
        ObrisiKorisnika obrisiKorisnika = new ObrisiKorisnika();
        obrisiKorisnika.execute(obrisanKorisnik);
    }

    public Object searchTables(Sto pretragaStola) throws Exception{
        PronadjiSto pronadjiSto = new PronadjiSto(pretragaStola);
        pronadjiSto.execute(pretragaStola);
        return pronadjiSto.getListaStolova();
    }

    public void updateTable(Sto izmenjenSto) throws Exception{
        IzmeniSto izmeniSto = new IzmeniSto();
        izmeniSto.execute(izmenjenSto);
        
    }

    public void createReservation(Rezervacija rezervacija) throws Exception {
        SacuvajRezervaciju sacuvajRezervaciju = new SacuvajRezervaciju();
        sacuvajRezervaciju.execute(rezervacija);
        
    }

    public Object getAllReservations() throws Exception{
        UcitajListuRezervacija ucitajRezervacije = new UcitajListuRezervacija();
        ucitajRezervacije.execute(new Rezervacija());
        return ucitajRezervacije.getListaRezervacija();
    }

    public Object searchReservations(Rezervacija pretragaRezervacije) throws Exception{
        PronadjiRezervacije pronadjiRezervacije = new PronadjiRezervacije(pretragaRezervacije);
        pronadjiRezervacije.execute(pretragaRezervacije);
        return pronadjiRezervacije.getListaRezervacija();
    }

    public List<StavkaRezervacije> searchReservationItems(StavkaRezervacije pretragaStavke) throws Exception{
        PronadjiStavke pronadjiStavke = new PronadjiStavke(pretragaStavke);
        pronadjiStavke.execute(pretragaStavke);
        return pronadjiStavke.getListaStavki();
    }

    public void updateReservation(Rezervacija izmenjenaRez) throws Exception {
        IzmeniRezervaciju izmeniRezervacije = new IzmeniRezervaciju(izmenjenaRez);
        izmeniRezervacije.execute(izmenjenaRez);
        
    }
    
    
    
}
