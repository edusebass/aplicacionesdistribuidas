//interfaz

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface interfaz extends Remote {
    // Métodos que el cliente puede invocar de forma remota
    String mensaje() throws RemoteException;
    String obtenerOpciones() throws RemoteException;
    double realizarOperacion(int opcion, double a, double b) throws RemoteException;
}