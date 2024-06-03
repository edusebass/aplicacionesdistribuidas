import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class HiloCliente extends Thread  {
    private DatagramPacket paqueteEntrada;
    private DatagramSocket socket;
    public HiloCliente(DatagramSocket socket, DatagramPacket paqueteEntrada){
        this.socket = socket;
        this.paqueteEntrada = paqueteEntrada;
    }


    public void run() {
        Scanner scanner = new Scanner(System.in);
        try {
            //extraer la infomracion del paquete

            String mensajeRecibido = new String(paqueteEntrada.getData());
            System.out.println("Mensaje recibido desde el cliente: => " + mensajeRecibido);

            //obtner direccion del cliente
            InetAddress direccionIp_cliente = paqueteEntrada.getAddress();
            int puerto_cliente = paqueteEntrada.getPort();

            while(true) {
                //crear un arreglo de bytes para enviar los datos del cliente
                System.out.println("Ingresa el mesnaje desde el servidor: ");
                String mensajeSalida = scanner.nextLine();
                byte[] bufferSalida = mensajeSalida.getBytes();
                //crea un objeto para enviar los datos
                DatagramPacket paqueteSalida = new DatagramPacket(bufferSalida, bufferSalida.length, direccionIp_cliente, puerto_cliente);
                socket.send(paqueteSalida);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
