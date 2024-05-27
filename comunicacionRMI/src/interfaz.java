import java.rmi.Remote;
import java.rmi.RemoteException;

public interface interfaz extends Remote {
    //metodos que el cliente puede enviar de forma remota
    String mensaje() throws RemoteException;
    double suma(double a, double b) throws RemoteException;


}
