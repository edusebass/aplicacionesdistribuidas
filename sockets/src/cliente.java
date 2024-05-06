import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class cliente {
    public static void main(String[] args) throws SocketException {
        int puerto = 5000;
        try {
            //crear un objeto socket
            DatagramSocket socket = new DatagramSocket();

            //direccion ip servidor
            InetAddress direccionIp_servidor = InetAddress.getByName( "localhost");

            //crear un arreglo de bytes para enviar los datos del cliente
            String mensajeSalida = "HOlaaa soy el como se llama";
            byte[] bufferSalida = mensajeSalida.getBytes();
            //crea un objeto para enviar los datos
            DatagramPacket paqueteSalida = new DatagramPacket(bufferSalida, bufferSalida.length, direccionIp_servidor
                    , puerto);
            socket.send(paqueteSalida);

            //crear arreglo de bytes para recibir datos del lado del cliente
            byte[] bufferEntrada = new byte[1024];
            //crear un objeto datahtam para recibir los datos
            DatagramPacket paqueteEntrada = new DatagramPacket(bufferEntrada, bufferEntrada.length);

            //recibir el paquete
            socket.receive(paqueteEntrada);

            //extraer la infomracion del paquete
            String mensajeRecibido = new String(paqueteEntrada.getData());
            System.out.println("Mensaje recibido: => " + mensajeRecibido);
        } catch (Exception e) {
            //catch block
            e.printStackTrace();
        }
    }
}