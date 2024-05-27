import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ImplementacionInterfaz extends UnicastRemoteObject implements interfaz {
    protected ImplementacionInterfaz() throws RemoteException {
        super();
    }


    //constructor
    public String mensaje() throws RemoteException{
        return "Hola desde el servidor";
    }

    public double suma(double a, double b) throws RemoteException{
        return a + b;
    }
}
