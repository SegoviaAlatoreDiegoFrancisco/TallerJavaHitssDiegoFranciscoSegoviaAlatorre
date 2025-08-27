import java.util.*;

public class Main{
    private static List<CuentaBancaria> cuentas = new ArrayList<>();
    private static List<Transaccion> transacciones = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Crear CuentaBancaria");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Mostrar cuentas");
            System.out.println("5. Mostrar transacciones");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> crearCuenta();
                case 2 -> realizarOperacion("Depósito");
                case 3 -> realizarOperacion("Retiro");
                case 4 -> mostrarCuentas();
                case 5 -> mostrarTransacciones();
                case 0 -> System.out.println("¡Hasta luego!");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private static void crearCuenta() {
        System.out.print("Nombre del titular: ");
        String titular = scanner.nextLine();
        System.out.print("Depósito inicial: ");
        double saldo = scanner.nextDouble();
        CuentaBancaria cuenta = new CuentaBancaria(titular, saldo);
        cuentas.add(cuenta);
        System.out.println("Cuenta creada: " + cuenta);
    }

    private static void realizarOperacion(String tipo) {
        System.out.print("ID de la cuenta: ");
        int id = scanner.nextInt();
        Optional<CuentaBancaria> cuentaOpt = cuentas.stream().filter(c -> c.getId() == id).findFirst();

        if (cuentaOpt.isEmpty()) {
            System.out.println("Cuenta no encontrada.");
            return;
        }

        CuentaBancaria cuenta = cuentaOpt.get();
        System.out.print("Monto: ");
        double monto = scanner.nextDouble();

        boolean exito = switch (tipo) {
            case "Depósito" -> {
                cuenta.depositar(monto);
                yield true;
            }
            case "Retiro" -> cuenta.retirar(monto);
            default -> false;
        };

        if (exito) {
            Transaccion t = new Transaccion(tipo, monto, cuenta);
            transacciones.add(t);
            System.out.println("Transacción registrada: " + t);
        } else {
            System.out.println("Operación fallida.");
        }
    }

    private static void mostrarCuentas() {
        System.out.println("\n=== Cuentas Registradas ===");
        cuentas.forEach(System.out::println);
    }

    private static void mostrarTransacciones() {
        System.out.println("\n=== Historial de Transacciones ===");
        transacciones.forEach(System.out::println);
    }
}
