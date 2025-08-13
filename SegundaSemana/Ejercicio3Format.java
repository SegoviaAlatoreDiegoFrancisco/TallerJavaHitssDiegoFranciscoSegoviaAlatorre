import java.util.Scanner;

public class Ejercicio3Format {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Variables para almacenar las notas y realizar cálculos
        double[] notas = new double[20];
        double sumaTotal = 0.0;
        double sumaAprobados = 0.0;//var >=6
        double sumaReprobados = 0.0;//var <6
        int contadorAprobados = 0;//var >=6
        int contadorReprobados = 0;//var <6
        int contadorNotasUno = 0;//var =1
        boolean errorEnNota = false;
        
        System.out.println("=== PROGRAMA DE GESTIÓN DE NOTAS ===");
        System.out.println("Introduce las 20 notas finales de alumnos (escala 1.0 a 10.0)");
        System.out.println("Nota: Las notas pueden incluir decimales (ej: 7.5, 8.0, 6.8)\n");
        
        // Bucle for para pedir las 20 notas
        for (int i = 0; i < 20; i++) {
            System.out.print("Ingresa la nota " + (i + 1) + " de 20: ");
            
            // Validar que se ingrese un número válido
            if (sc.hasNextDouble()) {
                double nota = sc.nextDouble();
                
                // Validar rango de la nota (1.0 a 10.0)
                if (nota < 1.0 || nota > 10.0) {
                    System.out.println("ERROR: La nota " + nota + " está fuera del rango válido (1.0 - 10.0)");
                    System.out.println("El programa se detendrá.");
                    errorEnNota = true;
                    break;
                }
                
                // Almacenar la nota en el arreglo
                notas[i] = nota;
                
                // Acumular para el promedio total
                sumaTotal += nota;
                
                // Clasificar la nota y acumular según corresponda
                if (nota >= 6.0) {
                    sumaAprobados += nota;
                    contadorAprobados++;
                } else {
                    sumaReprobados += nota;
                    contadorReprobados++;
                }
                
                // Contar notas iguales a 1.0
                if (nota == 1.0) {
                    contadorNotasUno++;
                }
                
            } else {
                System.out.println("ERROR: Debes ingresar un número válido.");
                System.out.println("El programa se detendrá.");
                errorEnNota = true;
                sc.next(); // Limpiar el buffer
                break;
            }
        }
        
        // Mostrar resultados solo si no hubo errores
        if (!errorEnNota) {
            System.out.println("\n=== RESULTADOS ===");
            System.out.println("Notas ingresadas exitosamente: " + (contadorAprobados + contadorReprobados) + "/20");
            
            // Mostrar todas las notas ingresadas
            System.out.print("Notas ingresadas: ");
            for (int i = 0; i < 20; i++) {
                System.out.printf("%.1f", notas[i]);
                if (i < 19) System.out.print(", ");
            }
            System.out.println();
            
            // Calcular y mostrar promedios
            if (contadorAprobados > 0) {
                double promedioAprobados = sumaAprobados / contadorAprobados;
                System.out.printf("Promedio de notas >= 6.0: %.2f (%d notas)\n", 
                                promedioAprobados, contadorAprobados);
            } else {
                System.out.println("Promedio de notas >= 6.0: No hay notas aprobadas");
            }
            
            if (contadorReprobados > 0) {
                double promedioReprobados = sumaReprobados / contadorReprobados;
                System.out.printf("Promedio de notas < 6.0: %.2f (%d notas)\n", 
                                promedioReprobados, contadorReprobados);
            } else {
                System.out.println("Promedio de notas < 6.0: No hay notas reprobadas");
            }
            
            // Mostrar cantidad de notas iguales a 1.0
            System.out.println("Cantidad de notas iguales a 1.0: " + contadorNotasUno);
            
            // Mostrar promedio total
            double promedioTotal = sumaTotal / 20;
            System.out.printf("Promedio total de todas las notas: %.2f\n", promedioTotal);
            
        } else {
            System.out.println("\n=== PROGRAMA TERMINADO POR ERROR ===");
            System.out.println("No se pueden mostrar resultados debido al error en la entrada de datos.");
        }
        
        sc.close();
        System.out.println("\nPrograma finalizado.");
    }
}