import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class cliente {
    public static void main(String[] args) {
        Scanner  scanner = new Scanner(System.in);
        int port = 5000;
        try {

            Socket socket_client = new Socket("localhost", port);
            System.out.println("cliente conectado");

            while (true) {
                BufferedReader entrada = new BufferedReader(new InputStreamReader(socket_client.getInputStream()));
                PrintWriter salida = new PrintWriter(socket_client.getOutputStream(), true);

                //escribe los daots a enviar a salida
                System.out.println("Ingrese mensaje al servidor => ");
                String mensaje_enviar = scanner.nextLine();
                salida.println((mensaje_enviar));

                //leer los datos recibidos por el cliente almacendados en la nube
                String datos_recibidos = entrada.readLine();
                System.out.println("El mensaje recibido del servidor es: " +  datos_recibidos);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
