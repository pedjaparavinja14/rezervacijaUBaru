/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import communication.Operation;
import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.Sender;
import domain.Korisnik;
import domain.Rezervacija;
import domain.StavkaRezervacije;
import domain.Sto;
import domain.ZaposleniUBaru;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Djapac
 */
public class Controller {
    Socket socket;
    Sender sender;
    Receiver receiver;
    private static Controller instance;
    private List<ZaposleniUBaru> listaPrijavljenih;

    private Controller() throws Exception {
        socket = new Socket("127.0.0.1", 9000);
        sender = new Sender(socket);
        receiver = new Receiver(socket);
        listaPrijavljenih = new ArrayList<>();
    }

    public static Controller getInstance() throws Exception{
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public ZaposleniUBaru login(ZaposleniUBaru zap) throws Exception{
       
        Request request = new Request(Operation.LOGIN, zap);
        sender.send(request);
        System.out.println("Poslao zahtev");
        Response response = (Response) receiver.receive();
        System.out.println("Primio zahtev");
        if (response.getException() == null) {
            ZaposleniUBaru prijavljen = (ZaposleniUBaru) response.getResult();
            listaPrijavljenih.add(prijavljen);
            return (ZaposleniUBaru) response.getResult();
            
        } else {
            throw response.getException();
        }
    }

    public List<Korisnik> getAllUsers() throws Exception{
        
        Request request = new Request(Operation.PRIKAZI_KORISNIKE, null);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Korisnik>) response.getResult();
        } else {
            throw response.getException();
        }
        
    }

    public void createUser(Korisnik korisnik) throws Exception{
        Request request = new Request(Operation.KREIRAJ_KORISNIKA, korisnik);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            korisnik.setKorisnikID(((Korisnik) response.getResult()).getKorisnikID());
        } else {
            throw response.getException();
        }
    }

    public void createTable(Sto sto) throws Exception{
        Request request = new Request(Operation.KREIRAJ_STO, sto);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            sto.setRbStola(((Sto) response.getResult()).getRbStola());
        } else {
            throw response.getException();
        }
    }

    public List<Sto> getAllTables() throws Exception{
        Request request = new Request(Operation.PRIKAZI_STOLOVE, null);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Sto>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public List<Korisnik> searchUsers(Korisnik korisnik) throws Exception{
        Request request = new Request(Operation.PRETRAZI_KORISNIKE, korisnik);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Korisnik>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public Korisnik deleteUser(Korisnik korisnik) throws Exception {
        Request request = new Request(Operation.OBRISI_KORISNIKA, korisnik);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if(response.getException() == null){
            return (Korisnik) response.getResult();
        }else{
            throw response.getException();
        }
    }

    public List<Sto> searchTables(Sto sto) throws Exception{
        Request request = new Request(Operation.PRETRAZI_STOLOVE, sto);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Sto>) response.getResult();
        } else {
            throw response.getException();
        }
        
    }

    public void updateTable(Sto izmenjen) throws Exception{
        Request request = new Request(Operation.IZMENI_STO, izmenjen);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            izmenjen.setRbStola(((Sto) response.getResult()).getRbStola());
        } else {
            throw response.getException();
        }
    }

    public List<ZaposleniUBaru> getListaPrijavljenih() {
        return listaPrijavljenih;
    }

    public void createReservation(Rezervacija r) throws Exception{
        Request request = new Request(Operation.KREIRAJ_REZERVACIJU, r);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            r.setRezervacijaID(((Rezervacija)response.getResult()).getRezervacijaID());
           
        } else {
            throw response.getException();
        }
    }

    public List<Rezervacija> getAllReservations() throws Exception{
        Request request = new Request(Operation.PRIKAZI_REZERVACIJE, null);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List <Rezervacija>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public List<Rezervacija> searchReservations(Rezervacija rez) throws Exception{
        Request request = new Request(Operation.PRETRAZI_REZERVACIJE, rez);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Rezervacija>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public List<StavkaRezervacije> findReservationItems(StavkaRezervacije sr) throws Exception{
        Request request = new Request(Operation.PRETRAZI_STAVKE, sr);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<StavkaRezervacije>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public void updateReservation(Rezervacija izabranaRez) throws Exception {
        Request request = new Request(Operation.IZMENI_REZERVACIJU, izabranaRez);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            izabranaRez.setRezervacijaID(((Rezervacija) response.getResult()).getRezervacijaID());
        } else {
            throw response.getException();
        }
    }
    
    
}
