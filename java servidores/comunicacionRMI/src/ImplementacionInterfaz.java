
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ImplementacionInterfaz extends UnicastRemoteObject implements interfaz {
    // Constructor
    public ImplementacionInterfaz() throws RemoteException {
        super();
    }

    // Implementar los métodos indicados en la interfaz
    public String mensaje() throws RemoteException {
        return "Hola, soy el administrador.";
    }

    public String obtenerOpciones() throws RemoteException {
        return "Seleccione una operación:\n" +
                "1. Suma\n" +
                "2. Resta\n" +
                "3. Multiplicación\n" +
                "4. División\n" +
                "5. Salir\n";
    }

    public double realizarOperacion(int opcion, double a, double b) throws RemoteException {
        switch (opcion) {
            case 1:
                return suma(a, b);
            case 2:
                return resta(a, b);
            case 3:
                return multiplicacion(a, b);
            case 4:
                if (b == 0) {
                    throw new RemoteException("División por cero no permitida.");
                }
                return division(a, b);
            default:
                throw new RemoteException("Opción no válida.");
        }
    }

    private double suma(double a, double b) {
        return a + b;
    }

    private double resta(double a, double b) {
        return a - b;
    }

    private double multiplicacion(double a, double b) {
        return a * b;
    }

    private double division(double a, double b) {
        return a/b;
}
}
