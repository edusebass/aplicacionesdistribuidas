import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServidorRMI {
    public static void main(String[] args) {
        try {
            // Crear e iniciar el registro RMI
            LocateRegistry.createRegistry(1099);

            // Crear la instancia del objeto remoto
            ConversorRemotoImpl conversor = new ConversorRemotoImpl();

            // Registrar el objeto remoto en el registro RMI
            Naming.rebind("localhost", conversor);

            System.out.println("Servidor RMI listo.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
