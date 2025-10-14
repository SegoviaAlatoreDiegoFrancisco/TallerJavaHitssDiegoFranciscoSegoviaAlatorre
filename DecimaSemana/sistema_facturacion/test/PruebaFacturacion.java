
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PruebaFacturacion {
    public static void main(String[] args) {
        /*
         * Sistema de facturacion
         * Una empresa necesita manejar:
         * Clientes
         * Productos
         * Facturas
         * Ventas(linea de factura)
         * 
         * y generar reprotes comom: 
         * 1.- total de ventas por cliente
         * 2.- ventas en un rango de fechas
         * 3.- top 3 mas vendidos
         * 4.- clientes con facturas vencidas
         * 5.- Validar politicas (todos los clientes tienen email corporativo?)
         */
        Cliente c1 = new Cliente("asdfas@gmail.com", 1, "Pedro Antonio");
        Cliente c2 = new Cliente("asdfass@gmail.com", 2, "Pedro Antonio2");
        Cliente c3 = new Cliente("asdfasas@hitss.com", 3, "Pedro Antonio3");
        Cliente c4 = new Cliente("asdfasss@gmail.com", 5, "Pedro Antonio5");
        Cliente c5 = new Cliente("asdfas@hitss.com", 4, "Pedro Antonio4");

        Producto p1 = new Producto(1, "Laptop", 12000);
        Producto p2 = new Producto(2, "Mouse", 100);
        Producto p3 = new Producto(3, "Teclado", 2300);
        Producto p4 = new Producto(4, "Monitor", 6000);
        Producto p5 = new Producto(5, "Camara", 1200);
        
        Factura f1 = new Factura(c5, LocalDate.of(2025,10,12), LocalDate.of(2026,12,30), 1);
        f1.agregarVenta( new Venta(4, p5)); 
        f1.agregarVenta(new Venta(4, p3));
        f1.agregarVenta( new Venta(2, p1));

        Factura f2 = new Factura(c1, LocalDate.of(2025,9,1), LocalDate.of(2026,12,12), 2);
        f2.agregarVenta( new Venta(4, p5)); 
        f2.agregarVenta(new Venta(4, p3));
        f2.agregarVenta( new Venta(2, p1));
        
        Factura f3 = new Factura(c3, LocalDate.of(2025,8,12), LocalDate.of(2025,9,5), 3);
        f3.agregarVenta( new Venta(4, p2)); 
        f3.agregarVenta(new Venta(4, p4));
        f3.agregarVenta( new Venta(2, p1));
        
        //List o Stream
        List<Factura> facturas = List.of(f1,f2,f3);
        
        //1.- total de ventas por cliente
        System.out.println("====Total de ventas=====");
        System.out.println("Factura 1; "+f1.getTotal());
        System.out.println("Factura 3:"+f3.getTotal());
        System.out.println("======Total de ventas por cliente=====");
        OperacionesService.totalVentas(facturas);

        // 2.- ventas en un rango de fechas
        System.out.println("\n========ventas en un rango de fechas=======");
        LocalDate inicio = LocalDate.of(2025, 10, 1);
        LocalDate fin = LocalDate.of(2025, 10, 3);
        double totalEntreFechas = facturas.stream()
            .filter(f -> !f.getFecha().isBefore(inicio) && f.getFecha().isAfter(fin))
            .mapToDouble(Factura::getTotal)
            .sum();
        System.out.println("Total entre fechas: $"+ totalEntreFechas);

        // 3.- top 3 mas vendidos
        System.out.println("=====Top 3 de productos mas vendidos=====");
        facturas.stream()
            .flatMap(f -> f.getVentas().stream())
            .collect(Collectors.groupingBy(Venta::getProducto,
                                Collectors.summingInt(Venta::getCantidad)))
                                .entrySet().stream()
                                .sorted(Map.Entry.<Producto,Integer>comparingByValue().reversed())
                                .limit(3)
                                .forEach(e  -> System.out.println(e.getKey().getNombre()+"->"+e.getValue()));
                                
        // 4.- clientes con facturas vencidas
        System.out.println("====Clientes con facturas vencidas=========");
        facturas.stream().filter(Factura::estaVencida).forEach(System.out::println);
        // 5.- Validar politicas (todos los clientes tienen email corporativo?)
        System.out.println("\n=====Validar politicas del cliente======");
        boolean todosCorporativo = facturas.stream()
            .map(Factura::getCliente)
            .allMatch(c -> c.getEmail().endsWith("@hitss.com"));
        System.out.println("¿todos los clientes tienen email corporativo? "+ todosCorporativo);

        



        
    }
}
