import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class HiloCliente extends Thread  {
    private DatagramPacket paqueteEntrada;
    private DatagramSocket socket;
    public HiloCliente(DatagramSocket socket, DatagramPacket paqueteEntrada){
        this.socket = socket;
        this.paqueteEntrada = paqueteEntrada;
    }

    public void run() {
        try {
            //extraer la infomracion del paquete
            String mensajeRecibido = new String(paqueteEntrada.getData());
            System.out.println("Mensaje recibido: => " + mensajeRecibido);

            //obtner direccion del cliente
            InetAddress direccionIp_cliente = paqueteEntrada.getAddress();
            int puerto_cliente = paqueteEntrada.getPort();

            //crear un arreglo de bytes para enviar los datos del cliente
            String mensajeSalida = "HOlaaa soy el como se llama";
            byte[] bufferSalida = mensajeSalida.getBytes();
            //crea un objeto para enviar los datos
            DatagramPacket paqueteSalida = new DatagramPacket(bufferSalida, bufferSalida.length, direccionIp_cliente, puerto_cliente);
            socket.send(paqueteSalida);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
