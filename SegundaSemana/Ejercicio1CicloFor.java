import java.util.Scanner;

public class Ejercicio1CicloFor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Para multiplicar dos números enteros...\nIngresa el primer número entero: ");
        int num1 = scanner.nextInt();
        System.out.print("Ingresa el segundo número entero: ");
        int num2 = scanner.nextInt();

        int resultado = 0;
        int absNum2 = Math.abs(num2);       
        for (int i = 0; i < absNum2; i++) {
            resultado += num1;
        }

        if ((num1 < 0 && num2 > 0) || (num1 > 0 && num2 < 0)) {
            resultado = -Math.abs(resultado);
        } else {
            resultado = Math.abs(resultado);
        }

        System.out.println(num1 + " * " + num2 + " = " + resultado);
        scanner.close();
    }
}
