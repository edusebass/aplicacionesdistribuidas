import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class servidor {
    public static void main(String[] args) {
        try{

            interfaz objetoRemoto = new ImplementacionInterfaz();
            Registry registro = LocateRegistry.createRegistry(1099);
            registro.rebind("Cliente remoto", objetoRemoto);
        }catch (RemoteException e){
            e.printStackTrace();

        }
        //Crear una instancia de la implementacion de la interfaz
    }
}
