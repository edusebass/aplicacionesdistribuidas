import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class hiloCliente extends Thread {
    Socket socket_client;

    public hiloCliente(Socket socket_client) {
        this.socket_client = socket_client;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket_client.getInputStream()));
            PrintWriter salida = new PrintWriter(socket_client.getOutputStream(), true);
            String datos_recibidos;
            while ((datos_recibidos = entrada.readLine()) != null) {
                //leer los datos recibidos por el cliente almacendados en la nube
                System.out.println("El mensaje recibido del cliente: " +  datos_recibidos);

                //escribe los daots a enviar a salida
                System.out.println("Ingrese el mensaje para el cliente: ");
                String mensaje_enviar = scanner.nextLine();
                salida.println((mensaje_enviar));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
