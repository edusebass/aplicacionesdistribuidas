import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class servidor {
    public static void main(String[] args) throws SocketException {
        int puerto = 5000;
            try {
                //crear un objeto socket
                DatagramSocket socket = new DatagramSocket(puerto);
                System.out.println("x: servidor esperarndo conexxiones");

                while (true) {
                    //crear arreglo de bytes para recibir datos del lado del cliente
                    byte[] bufferEntrada = new byte[1024];
                    //crear un objeto datahtam para recibir los datos
                    DatagramPacket paqueteEntrada = new DatagramPacket(bufferEntrada, bufferEntrada.length);

                    //recibir el paquete
                    socket.receive(paqueteEntrada);

                    ////////////////////////////////////////
                    //iniciar un hilo para cada cliente
                    Thread hiloCliente = new HiloCliente(socket, paqueteEntrada);
                    hiloCliente.start();
                }


            } catch (Exception e) {
                //catch block
                e.printStackTrace();
            }
    }
}