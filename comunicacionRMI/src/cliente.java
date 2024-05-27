import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class cliente {
    public static void main(String[] args) {

        try{
            Registry registro = LocateRegistry.getRegistry("localhost", 1099);
            interfaz objetoRemoto = (interfaz) registro.lookup("Cliente");

            String mensaje = objetoRemoto.mensaje();
            System.out.println(mensaje);

            double nuevo = objetoRemoto.suma(10,4);
            System.out.println(nuevo);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
