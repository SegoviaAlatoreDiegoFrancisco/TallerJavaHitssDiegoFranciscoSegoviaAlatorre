import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        SupermercadoService service = new SupermercadoService();
        Cliente cliente = new Cliente(123, "Pedro Antonio", TipoCliente.VIP);
        List<Producto> productos = Arrays.asList(
            new Producto(213, "Calculadora Kadiz ", 180, 12),
            new Producto(566, "Bloc. 100 Hojas. Cuadro chico", 90, 60),
            new Producto(985, "Calculadora Graficadora Casio CMZD-1212", 999.99, 9)
        );
        Empleado empleado = new Empleado(612, "Adan Augusto", "Vendedor de piso");
        Venta venta = new Venta(cliente,empleado,1, productos, service.calcularTotal.apply(productos));

        service.imprimirTicket.accept(venta);
        service.imprimirDetalleVenta.accept(venta);
        service.notificarClienteCompraProcesada.accept(cliente, empleado);
        
    }
}
