import java.util.Scanner;

public class Ejercicio2CicloFor {
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cantidad;
        do {
            System.out.print("¿Cuántos números deseas comparar? (mínimo 10, o 0 para salir): ");
            cantidad = scanner.nextInt();
            if (cantidad == 0) {
                System.out.println("Programa terminado por el usuario.");
                scanner.close();
                return;
            }
        } while (cantidad < 10);

        int menor = Integer.MAX_VALUE;
        for (int i = 1; i <= cantidad; i++) {
            System.out.print("Ingresa el número " + i + ": ");
            int num = scanner.nextInt();
            if (num < menor) {
                menor = num;
            }
        }
        String msg = (menor < 10) ? "El número menor es menor que 10" : "El número menor es igual o mayor que 10";
        System.out.println("El número menor es: " + menor);
        System.out.println(msg);
        /*if (menor == 10) {
            System.out.println("El número menor es igual a 10");
        } else if (menor < 10) {
            System.out.println("El número menor es menor que 10");
        } else {
            System.out.println("El número menor es mayor que 10");
        }*/
        scanner.close();
    }
}
