/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.net.Socket;

/**
 *
 * @author Djapac
 */
public class Receiver implements Serializable{
    private Socket socket;

    public Receiver(Socket socket) {
        this.socket = socket;
    }
    
      public Object receive() throws Exception{
        try {
            ObjectInputStream in=new ObjectInputStream(socket.getInputStream());
            return in.readObject();
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new Exception("Error receiving object!\n"+ex.getMessage());
        }
    }
    
}
