import java.util.Scanner;
public class Ejercicio6Arrays {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] elementosIngresados = new int[10];
        int[] elementosValido = {1,2,3,4,5,6,7,8,9};
        
        System.out.println("Ingresa 10 números del 1 al 9 para mostrar las ocurrencias");
        
        for (int i = 0; i < elementosIngresados.length; i++) {
            System.out.print("Ingresa el número " + (i+1) + ": ");
            elementosIngresados[i] = sc.nextInt();
            
            while (elementosIngresados[i] < 1 || elementosIngresados[i] > 9) {
                System.out.println("Error: El número debe estar entre 1 y 9");
                System.out.print("Ingresa el número " + (i+1) + " nuevamente: ");
                elementosIngresados[i] = sc.nextInt();
            }
        }
        
        System.out.print("Arreglo ingresado: [");
        for (int i = 0; i < elementosIngresados.length; i++) {
            System.out.print(elementosIngresados[i]);
            if (i < elementosIngresados.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
        
        int maxOcurrencias = 0;
        int elementoMasRepetido = 0;
        for (int i : elementosValido) {
            int contador = 0;
            for (int num : elementosIngresados) {
                if (num==i){
                    contador++;
                }
            }
            if (contador > maxOcurrencias){
                maxOcurrencias = contador;
                elementoMasRepetido = i;
            }
        }
        
        System.out.println("1.- La mayor ocurrencia es: " + maxOcurrencias);
        System.out.println("2.- El elemento que más veces se repite es: " + elementoMasRepetido);        
        sc.close();
    }
}
