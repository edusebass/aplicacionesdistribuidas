//hilocliente
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class hiloCliente extends Thread {
    Socket socket_client;
    Scanner scanner = new Scanner(System.in);
    String[] preguntas = {"¿Cuál es la capital de Ecuador?", "¿Cuál es la capital de España?", "¿Cuál es la capital de Francia?", "¿Cuál es la capital de Italia?", "¿Cuál es la capital de Japón?"};
    String[] respuestas = {"quito", "madrid", "paris", "roma", "tokio"};
    int indexPregunta = 0;

    public hiloCliente(Socket socket_client) {
        this.socket_client = socket_client;
    }

    public void run() {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket_client.getInputStream()));
            PrintWriter salida = new PrintWriter(socket_client.getOutputStream(), true);
            String datos_recibidos;

            while (indexPregunta < preguntas.length) {
                // Enviar pregunta al cliente
                salida.println(preguntas[indexPregunta]);

                // Leer respuesta del cliente
                datos_recibidos = entrada.readLine();
                System.out.println("Respuesta del cliente: " + datos_recibidos);

                // Comparar respuesta del cliente con respuesta correcta
                if (datos_recibidos.equalsIgnoreCase(respuestas[indexPregunta])) {
                    System.out.println("Respuesta Correcta");
                    salida.println("Respuesta Correcta");
                } else {
                    System.out.println("Respuesta Incorrecta. La respuesta correcta es: " + respuestas[indexPregunta]);
                    salida.println("Respuesta Incorrecta. La respuesta correcta es: " + respuestas[indexPregunta]);

                }

                indexPregunta++; // Pasar a la siguiente pregunta
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}