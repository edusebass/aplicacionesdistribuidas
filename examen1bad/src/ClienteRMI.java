import java.rmi.Naming;
import java.util.Scanner;

public class ClienteRMI {
    public static void main(String[] args) {
        try {
            // Buscar el objeto remoto en el registro RMI
            ConversorRemoto conversor = (ConversorRemoto) Naming.lookup("localhost");

            Scanner scanner = new Scanner(System.in);

            System.out.println("Ingrese la temperatura:");
            double temperatura = scanner.nextDouble();
            scanner.nextLine();  // Consumir el salto de línea

            System.out.println("Seleccione la conversión:");
            System.out.println("1. Celsius a Fahrenheit");
            System.out.println("2. Fahrenheit a Celsius");
            int opcion = scanner.nextInt();

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

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
