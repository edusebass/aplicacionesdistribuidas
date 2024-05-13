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
            Socket socket_client = socket_server.accept();
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket_client.getInputStream()));
            PrintWriter salida = new PrintWriter(socket_client.getOutputStream(), true);

            //leer los datos recibidos por el cliente almacendados en la nube
            String datos_recibidos = entrada.readLine();
            System.out.println("El mensaje recibido es: " +  datos_recibidos);

            //escribe los daots a enviar a salida
            String mensaje_enviar = "Hola";
            salida.println((mensaje_enviar));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}