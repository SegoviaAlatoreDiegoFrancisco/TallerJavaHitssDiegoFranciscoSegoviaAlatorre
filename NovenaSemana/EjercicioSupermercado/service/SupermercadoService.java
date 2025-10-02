
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class SupermercadoService {
    //filtro: productos stock<5
    public Predicate<Producto> stockMenorCinco = p -> p.getStock() < 5;
    
    //Calcular Total
    public Function<List<Producto>, Double> calcularTotal = productos-> 
    productos.stream().mapToDouble(Producto::getPrecio).sum();

    //detalle de venta
    public Consumer<Venta> imprimirDetalleVenta = venta ->{
        System.out.println("ID venta: "+venta.getId());
        System.out.println("Cliente: "+venta.getCliente().getNombre());
        System.out.println("Empleado: "+venta.getEmpleado().getNombre());
        System.out.println("Productos: ");
        venta.getProductosLista().forEach(p -> System.out.println("\t"+ p.getNombre()
            +": $"+p.getPrecio()));
        
        System.out.println("TOTAL: $"+venta.getTotal());
    };

    //producto para test
    public Supplier<Producto> productoDePrueba =() -> new Producto(3312, "**PRODUCTO DE PRUEBAS**",299.50, 299);

    //descuento del 10%
    UnaryOperator<Venta> aplicarDescuentoDelDiez = v -> {
        v.setTotal(v.getTotal()*.9);
        return v;

    };
    //comparar qeu producto es mas caro
    public BinaryOperator<Producto> productoMasCaro = (p1,p2) -> p1.getPrecio() > p2.getPrecio() ?p1 : p2;

    //verificar compra minima y tipo de cliente
    public BiPredicate<Cliente,Double> clienteAccedeADescuento = 
        (cliente, total) -> cliente.getTipo()==TipoCliente.VIP && total > 1000;
    
    //Imprimir ticket de compra en consola
    public Consumer<Venta> imprimirTicket = venta -> { 
        System.out.println("*".repeat(5)+"Ticket de Compra"+"*".repeat(5));
        System.out.println("Cliente: \n\t"+venta.getCliente().getNombre()+"\n\t"+venta.getCliente().getTipo());
        System.out.println("Productos:");
        venta.getProductosLista().forEach(p -> 
                System.out.println("\t"+p.getNombre()+ "\n"+".".repeat(70)+p.getPrecio()));
        System.out.println("\nTotal:"+".".repeat(70)+venta.getTotal());
        if (venta.getCliente().getTipo()==TipoCliente.VIP && venta.getTotal()>1000){
            System.out.println("\nDescuento (10%):"+".".repeat(70)+aplicarDescuentoDelDiez.apply(venta).getTotal());
            
        }
        System.out.println("*".repeat(80));
        
    };
    //notificar al clinete que su compra fue procesada por el empleado [EMPLEADO]
    public BiConsumer <Cliente, Empleado> notificarClienteCompraProcesada = (cliente, empleado)->
        System.out.println("Estimado "+cliente.getNombre()+ " fue antentido por "+empleado.getNombre()+". Agradecemos su compra, vuelva pronto :).");
        

}
