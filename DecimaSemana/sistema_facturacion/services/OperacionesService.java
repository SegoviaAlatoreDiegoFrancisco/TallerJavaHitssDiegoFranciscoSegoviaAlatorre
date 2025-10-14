
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OperacionesService {
    public static void totalVentas(List<Factura> facturas){
        Map<Cliente, Double> totalPorCliente = facturas
        .stream()
            .collect(Collectors.groupingBy(Factura::getCliente, Collectors.summingDouble(Factura::getTotal)));
        
        // Imprimir el total de ventas por cliente
        totalPorCliente.forEach((cliente, total) -> 
            System.out.println("Cliente: " + cliente.getNombre() + ", Total ventas: " + total)
        );
    }
}
