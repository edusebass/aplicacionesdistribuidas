import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class servidor {
    public static void main(String[] args) {
        //crear socket
        int port = 5000;
        try {
            ServerSocket socket_server = new ServerSocket(port);
            System.out.println("Esperando conexion");
            //esperar y aceptar condiciones

            while (true) {
                Socket socket_client = socket_server.accept();
                //crear un hilo para cada cliente
                hiloCliente hilo = new hiloCliente(socket_client);
                hilo.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}