/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread;

import com.sun.nio.sctp.SendFailedNotification;
import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.Sender;
import domain.DomainObject;
import domain.Korisnik;
import domain.Rezervacija;
import domain.StavkaRezervacije;
import domain.Sto;
import domain.ZaposleniUBaru;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.Controller;
import server.Server;

/**
 *
 * @author Djapac
 */
public class ClientThread extends Thread{
    private final Socket clientSocket;
    private Sender sender;
    private Receiver receiver;
    private Controller controller;
    private Server server;
    private boolean kraj=false;
    private ZaposleniUBaru zaposleni;
    
    
     public ClientThread(Socket clientSocket, Server server) {
        this.clientSocket = clientSocket;
        this.server = server;
        sender = new Sender(clientSocket);
        receiver = new Receiver(clientSocket);
        controller = new Controller();
    }

    
   

    @Override
    public void run() {
        
        while(!kraj){
       
       
            try {
                Request request = (Request) receiver.receive();
                System.out.println("Server primio zahtev");
                Response response = new Response();

                try {
                    switch (request.getOperation()) {
                        
                        case LOGIN:
                           ZaposleniUBaru zaposleni = (ZaposleniUBaru) request.getArgument(); 
                           zaposleni = (ZaposleniUBaru) controller.login(zaposleni);
                                
                            if (server.notLogin(zaposleni) ) {
                                response.setResult(zaposleni);
                                this.zaposleni = zaposleni;          
                            } else {
                                throw new Exception("Zaposleni je vec prijavljen.");
                            }
                            break;
                        case PRIKAZI_KORISNIKE:
                            response.setResult(controller.getAllUsers());
                            break;
                        case KREIRAJ_KORISNIKA:
                            Korisnik korisnik = (Korisnik) request.getArgument();
                            controller.createUser(korisnik);
                            response.setResult(korisnik);
                            System.out.println(korisnik);
                            break;
                        case KREIRAJ_STO:
                            Sto sto = (Sto) request.getArgument();
                            controller.createTable(sto);
                            response.setResult(sto);
                            System.out.println(sto);
                            break;
                        case PRIKAZI_STOLOVE:
                            response.setResult(controller.getAllTables());
                            break;
                        case PRETRAZI_KORISNIKE:
                            Korisnik pretragaKorisnika = (Korisnik) request.getArgument();
                            response.setResult(controller.searchUsers(pretragaKorisnika));
                            break;
                        case OBRISI_KORISNIKA:
                            Korisnik obrisanKorisnik = (Korisnik) request.getArgument();
                            controller.deleteUser(obrisanKorisnik);
                            response.setResult(obrisanKorisnik);
                            break;
                        case PRETRAZI_STOLOVE:
                            Sto pretragaStola = (Sto) request.getArgument();
                            response.setResult(controller.searchTables(pretragaStola));
                            break;
                        case IZMENI_STO:
                            Sto izmenjenSto = (Sto) request.getArgument();
                            controller.updateTable(izmenjenSto);
                            response.setResult(izmenjenSto);
                            break;
                        case KREIRAJ_REZERVACIJU:
                            Rezervacija rezervacija = (Rezervacija) request.getArgument();
                            controller.createReservation(rezervacija);
                            response.setResult(rezervacija);
                            break;
                        case PRIKAZI_REZERVACIJE:
                            response.setResult(controller.getAllReservations());
                            break;
                        case PRETRAZI_REZERVACIJE:
                            Rezervacija pretragaRezervacije = (Rezervacija) request.getArgument();
                            response.setResult(controller.searchReservations(pretragaRezervacije));
                            break;
                        case PRETRAZI_STAVKE:
                            StavkaRezervacije pretragaStavke = (StavkaRezervacije) request.getArgument();
                            response.setResult(controller.searchReservationItems(pretragaStavke));
                            break;
                        case IZMENI_REZERVACIJU:
                            Rezervacija izmenjenaRez = (Rezervacija) request.getArgument();
                            controller.updateReservation(izmenjenaRez);
                            response.setResult(izmenjenaRez);
                            break;
                    
                           
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    response.setException(e);
                }
                sender.send(response);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        
    }
    }

    
  
    public void setKraj(boolean kraj) {
        this.kraj = kraj;
    }

    public ZaposleniUBaru getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(ZaposleniUBaru zaposleni) {
        this.zaposleni = zaposleni;
    }
    
    
    
    
    
}
