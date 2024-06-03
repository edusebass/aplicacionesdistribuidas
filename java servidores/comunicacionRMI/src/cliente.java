//cliente

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class cliente {
    public static void main(String[] args) {
        try {
            // Obtener el registro
            Registry registro = LocateRegistry.getRegistry("25.62.115.218", 1099);
            // Crear instancia de la implementación de la interfaz
            interfaz objetoRemoto = (interfaz) registro.lookup("CalculadoraRemota");

            Scanner scanner = new Scanner(System.in);

            while (true) {
                // Obtener y mostrar las opciones desde el servidor
                String opciones = objetoRemoto.obtenerOpciones();
                System.out.print(opciones);
                int opcion = scanner.nextInt();

                if (opcion == 5) {
                    System.out.println("Saliendo...");
                    break;
                }

                System.out.println("Ingrese el primer número:");
                double num1 = scanner.nextDouble();
                System.out.println("Ingrese el segundo número:");
                double num2 = scanner.nextDouble();

                double resultado = objetoRemoto.realizarOperacion(opcion, num1, num2);
                System.out.println("Resultado: " + resultado);
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println(e);
}
}
}