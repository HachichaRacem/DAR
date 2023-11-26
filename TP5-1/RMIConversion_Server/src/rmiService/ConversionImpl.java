package rmiService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ConversionImpl extends UnicastRemoteObject implements IConversion{

    // "protected" : Le constructeur est accessible que dans le même package
    // "public" dans notre cas car il est dans un autre package.
    public ConversionImpl() throws RemoteException {
        super();
    }

    // Euros -> TND
    @Override
    public double convertirMontant(double mt) {
        return mt*3.3;
    }
}