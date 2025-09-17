import entidades.*;
import genericos.*;
import java.util.Arrays;
import java.util.List;
public class testMain {
    public static void main(String[] args) {
    //        sISTEMA DE FACTURACION UTILIZANDO LAS SIGUINETES ENTIDDADES:
    //Cliente, Producto,Factura
    //Unservicio generico con las siguentes opreaciones
    //guardar-agregar elementos
    //Listar elementos
    //Buscar por ID
    //Eliminar por ID
    //Ina interfaz generica Idenitificable que se implemente y que obligue a cada entidad
    //tener un metodo getID()

    ServicioGenerico<Cliente, String> clienteServicio = new ServicioGenerico<>();
    ServicioGenerico<Producto, Integer> productoServicio = new ServicioGenerico<>();
    ServicioGenerico<Factura, Long> facturaServicio= new ServicioGenerico<>();

    Cliente c1 = new Cliente("C001", "Pedro");
    Cliente c2 = new Cliente("C002", "Paramo");
    Cliente c3 = new Cliente("C004", "Sergio");
    clienteServicio.agregar(c1);
    clienteServicio.agregar(c2);
    clienteServicio.agregar(c3);

    Producto p1 = new Producto(1, "Lenovo Thinkpad T430", 2300);
    Producto p2 = new Producto(2, "mouse", 540);
    Producto p3 = new Producto(3, "Teclado", 850);
    productoServicio.agregar(p1);
    productoServicio.agregar(p2);
    productoServicio.agregar(p3);

    Factura f1 = new Factura(1001L,c1, Arrays.asList(p1,p2));
    Factura f2 = new Factura(1002L, c3, Arrays.asList(p1,p2,p3));
    facturaServicio.agregar(f1);
    facturaServicio.agregar(f2);
    
    Archivos.guardarFactura(f1);
    Archivos.guardarFactura(f2);

    Archivos.leerFactura(1002L);
    Archivos.leerFactura(1002L);
    List<String> facturas = Archivos.listarFacturas();
    System.out.println(facturas);
    }
}
