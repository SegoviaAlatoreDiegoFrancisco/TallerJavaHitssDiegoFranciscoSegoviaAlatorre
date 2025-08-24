import java.util.Arrays;
import java.util.Scanner;
public class Ejercicio5Arrays {
        public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] numeros =new int[10];
        System.out.println("Ingresa 10 números para almacenarlos en una lista");
        for (int i=0;i<numeros.length;i++){
            System.out.printf("Número[%d]: ",(i+1));
            numeros[i]=scanner.nextInt();
        }
        scanner.close();
        for (int i=0; i<5;i++){
            System.out.println(numeros[numeros.length-1-i]);
            System.out.println(numeros[i]);
        }
        System.out.println(Arrays.toString(numeros));
        System.out.println(numeros.length);
    }
}
