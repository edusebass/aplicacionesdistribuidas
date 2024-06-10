import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServidorRMI {
    public static void main(String[] args) {
        try {
            // Crear una instancia de la implementación de la interfaz
            ConversorRemotoImpl conversor = new ConversorRemotoImpl();

            // Crear registro RMI en un puerto
            Registry registro = LocateRegistry.createRegistry(1099);

            // Vinculación con un nombre
            registro.rebind("ConversorRemoto", conversor);

            System.out.println("Servidor RMI listo.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}