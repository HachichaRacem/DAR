package rmiServer;

import rmiService.ConversionImpl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

// Serveur
public class ConversionServer {
    public static void main(String[] args) {
        try{
            final int PORT = 1999;
            final String URL = "rmi://localhost:1999/service";

            // Réservation du PORT.
            LocateRegistry.createRegistry(PORT);

            // Object distant qui va être distribué
            ConversionImpl service = new ConversionImpl();
            System.out.println(service);

            // Publication de la réference de l'object distant (service)
            Naming.rebind(URL, service);

        }catch(RemoteException e){
            System.out.println("RemoteException : " + e);
        }catch(MalformedURLException e){
            System.out.println("MalFormedURLException : " + e);
        }
    }
}