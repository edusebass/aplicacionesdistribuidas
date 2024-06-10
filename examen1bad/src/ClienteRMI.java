import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ClienteRMI {
    public static void main(String[] args) {
        try {
            // Obtener el registro
            Registry registro = LocateRegistry.getRegistry("localhost", 1099);
            // Buscar el objeto remoto en el registro RMI
            ConversorRemoto conversor = (ConversorRemoto) registro.lookup("ConversorRemoto");

            Scanner scanner = new Scanner(System.in);

            while (true) {
                // Mostrar opciones de conversión
                System.out.println("Seleccione la conversión:");
                System.out.println("1. Celsius a Fahrenheit");
                System.out.println("2. Fahrenheit a Celsius");
                System.out.println("3. Salir");
                System.out.print("Ingrese opción: ");
                int opcion = scanner.nextInt();

                if (opcion == 3) {
                    System.out.println("Gracias por utilizar el conversor de temperaturas");
                    break;
                }

                System.out.println("\n----------------------");
                System.out.print("Ingrese la temperatura: ");
                double temperatura = scanner.nextDouble();

                double resultado;
                switch (opcion) {
                    case 1:
                        resultado = conversor.celsiusToFahrenheit(temperatura);
                        System.out.println(temperatura + " Celsius es igual a " + resultado + " Fahrenheit.");
                        break;
                    case 2:
                        resultado = conversor.fahrenheitToCelsius(temperatura);
                        System.out.println(temperatura + " Fahrenheit es igual a " + resultado + " Celsius.");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
                System.out.println("----------------------\n");
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}