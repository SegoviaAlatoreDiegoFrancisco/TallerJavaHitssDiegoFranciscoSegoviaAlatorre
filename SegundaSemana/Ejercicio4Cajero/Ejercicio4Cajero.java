package Ejercicio4Cajero;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Programa que simula un sistema de restaurante con archivos de texto
 * Permite al cajero registrar pedidos, ver el total de ventas y guarda sesiones
 */
public class Ejercicio4Cajero {
    private static final String ARCHIVO_SESIONES = "SegundaSemana/Ejercicio4Cajero/sesiones_cajero.txt";
    private static String nombreCajero;
    private static LocalDateTime horaInicio;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalVentas = 0.0;
        int opcion;
        
        // Crear archivo de sesiones si no existe
        inicializarArchivoSesiones();
        
        // Autenticación del cajero
        if (!autenticarCajero(scanner)) {
            System.out.println("Error en la autenticación. Saliendo del sistema...");
            scanner.close();
            return;
        }
        
        // Registrar inicio de sesión
        horaInicio = LocalDateTime.now();
        registrarInicioSesion();
        
        System.out.println("=== SISTEMA DE RESTAURANTE ===");
        System.out.println("Bienvenido al sistema de caja, " + nombreCajero);
        
        do {
            // Mostrar menú de opciones
            mostrarMenu();
            
            // Leer opción del usuario
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            
            // Procesar la opción seleccionada
            switch (opcion) {
                case 1:
                    totalVentas = registrarPedido(scanner, totalVentas);
                    break;
                case 2:
                    mostrarTotalVentas(totalVentas);
                    break;
                case 3:
                    System.out.println("¡Gracias por usar el sistema! Hasta luego.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione 1, 2 o 3.");
            }
            
            // Pausa para que el usuario pueda ver el resultado de la opción seleccionada
            if (opcion != 3) {
                System.out.println("\nPresione Enter para continuar...");
                scanner.nextLine(); // Limpiar buffer del nextInt()
                scanner.nextLine(); // Esperar Enter del usuario
            }
            
        } while (opcion != 3);
        
        // Registrar cierre de sesión
        registrarCierreSesion(totalVentas);
        
        scanner.close();
    }
    
    /**
     * Autentica al cajero solicitando su nombre
     * Scanner para entrada de datos
     * true si la autenticación es exitosa
     */
    public static boolean autenticarCajero(Scanner scanner) {
        System.out.println("=== AUTENTICACIÓN DE CAJERO ===");
        System.out.print("Por favor, ingrese su nombre: ");
        
        // Leer directamente el nombre del cajero
        nombreCajero = scanner.nextLine().trim();
        
        if (nombreCajero.isEmpty()) {
            System.out.println("Error: El nombre no puede estar vacío.");
            return false;
        }
        
        System.out.println("¡Bienvenido, " + nombreCajero + "!");
        return true;
    }
    
    /**
     * Inicializa el archivo de sesiones creando el encabezado si no existe
     */
    public static void inicializarArchivoSesiones() {
        File archivo = new File(ARCHIVO_SESIONES);
        
        if (!archivo.exists()) {
            try (PrintWriter writer = new PrintWriter(new FileWriter(archivo, true))) {
                writer.println("=== REGISTRO DE SESIONES DE CAJERO ===");
                writer.println("Formato: Cajero | Fecha | Hora Inicio | Hora Cierre | Total Ventas");
                writer.println("=".repeat(80));
            } catch (IOException e) {
                System.err.println("Error al crear el archivo de sesiones: " + e.getMessage());
            }
        }
        System.out.println("Archivo de sesiones inicializado correctamente en: " + archivo.getAbsolutePath());
    }
    
    /**
     * Registra el inicio de sesión en el archivo de texto
     */
    public static void registrarInicioSesion() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ARCHIVO_SESIONES, true))) {
            String fecha = horaInicio.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String horaInicioStr = horaInicio.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            
            writer.printf("%s | %s | %s | %s | $%.2f%n", 
                nombreCajero, fecha, horaInicioStr, "EN CURSO", 0.0);
            
            System.out.println("Sesión iniciada y registrada en el archivo.");
            
        } catch (IOException e) {
            System.err.println("Error al registrar inicio de sesión: " + e.getMessage());
        }
    }
    
    /**
     * Registra el cierre de sesión y actualiza la información en el archivo
     * totalVentas Total de ventas de la sesión
     */
    public static void registrarCierreSesion(double totalVentas) {
        LocalDateTime horaCierre = LocalDateTime.now();
        
        try {
            // Leer el archivo completo
            File archivo = new File(ARCHIVO_SESIONES);
            StringBuilder contenido = new StringBuilder();
            boolean sesionActualizada = false;
            
            try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
                String linea;
                while ((linea = reader.readLine()) != null) {
                    if (linea.contains("EN CURSO") && linea.contains(nombreCajero)) {
                        // Actualizar la línea de la sesión actual
                        String fecha = horaInicio.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                        String horaInicioStr = horaInicio.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
                        String horaCierreStr = horaCierre.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
                        
                        String nuevaLinea = String.format("%s | %s | %s | %s | $%.2f", 
                            nombreCajero, fecha, horaInicioStr, horaCierreStr, totalVentas);
                        
                        contenido.append(nuevaLinea).append("\n");
                        sesionActualizada = true;
                    } else {
                        contenido.append(linea).append("\n");
                    }
                }
            }
            
            // Escribir el archivo actualizado
            if (sesionActualizada) {
                try (PrintWriter writer = new PrintWriter(new FileWriter(archivo))) {
                    writer.print(contenido.toString());
                }
                
                System.out.println("\n=== RESUMEN DE SESIÓN ===");
                System.out.println("Cajero: " + nombreCajero);
                System.out.println("Hora de inicio: " + horaInicio.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
                System.out.println("Hora de cierre: " + horaCierre.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
                System.out.printf("Total de ventas: $%.2f\n", totalVentas);
                System.out.println("Sesión cerrada y guardada en el archivo.");
            } else {
                System.out.println("Error: No se pudo actualizar la sesión en el archivo.");
            }
            
        } catch (IOException e) {
            System.err.println("Error al cerrar sesión: " + e.getMessage());
        }
    }
    
    /**
     * Muestra el menú principal del sistema
     */
    public static void mostrarMenu() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("           MENÚ PRINCIPAL");
        System.out.println("=".repeat(40));
        System.out.println("1.- Registrar un pedido");
        System.out.println("2.- Mostrar el total de ventas");
        System.out.println("3.- Salir del sistema");
        System.out.println("=".repeat(40));
    }
    
    /**
     * Registra un nuevo pedido y valida el precio
     * @param scanner Scanner para entrada de datos
     * @param totalVentas Total actual de ventas
     * @return Nuevo total de ventas
     */
    public static double registrarPedido(Scanner scanner, double totalVentas) {
        System.out.println("\n--- REGISTRAR PEDIDO ---");
        System.out.print("Ingrese el precio del pedido: $");
        
        double precio = scanner.nextDouble();
        
        // Validar que el precio sea positivo
        if (precio > 0) {
            totalVentas += precio;
            System.out.println("✓ Pedido registrado exitosamente");
            System.out.printf("Precio: $%.2f\n", precio);
            System.out.printf("Total de ventas acumulado: $%.2f\n", totalVentas);
        } else {
            System.out.println("✗ Error: El precio debe ser mayor a $0.00");
            System.out.println("El pedido no fue registrado.");
        }
        
        return totalVentas;
    }
    
    /**
     * Muestra el total de ventas acumulado
     * totalVentas Total de ventas a mostrar
     */
    public static void mostrarTotalVentas(double totalVentas) {
        System.out.println("\n--- TOTAL DE VENTAS ---");
        if (totalVentas > 0) {
            System.out.printf("El total de ventas del día es: $%.2f\n", totalVentas);
        } else {
            System.out.println("No se han registrado ventas aún.");
        }
    }
}
