import java.util.Scanner;
public class Ejercicio7Matrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa el tamaño de la matriz cuadrada para generar un patrón de x");
        int n =  scanner.nextInt();
        char[][] matriz = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = '_';
            }
        }

        for (int i = 0; i < n; i++) {
            matriz[i][i] = 'X'; // Diagonal principal
            matriz[i][n - i - 1] = 'X'; // Diagonal secundaria
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matriz[i][j]);
            }
            System.out.println();
            scanner.close();
        }
    }
}
