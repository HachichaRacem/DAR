package rmiClient;

import rmiService.IConversion;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ConversionClient {
    public static void main(String[] args) {
        final String URL = "rmi://localhost:1999/service";
        try{
            IConversion stub = (IConversion) Naming.lookup(URL);
            System.out.println(stub.convertirMontant(100));
        } catch (MalformedURLException | NotBoundException | RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
