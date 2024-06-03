//servidor

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class servidor {
    public static void main(String[] args) {
        try {
            // Crear una instancia de la implementación de la interfaz
            interfaz objetoRemoto = new ImplementacionInterfaz();
            // Crear registro RMI en un puerto (por ejemplo, 1099)
            Registry registro = LocateRegistry.createRegistry(1099);

            // Vinculación remota con un nombre
            registro.rebind("CalculadoraRemota", objetoRemoto);

            System.out.println("Servidor Iniciado");
        } catch (Exception e) {
            System.out.println(e);
 }
}
}