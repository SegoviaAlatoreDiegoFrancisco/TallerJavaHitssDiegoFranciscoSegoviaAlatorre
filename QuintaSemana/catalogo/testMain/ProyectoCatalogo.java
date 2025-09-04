package catalogo.testMain;

import catalogo.interfaces.IProducto;
import catalogo.modelos.*;
import java.util.Date;
import java.time.LocalDate;

public class ProyectoCatalogo {
    public static void main(String[] args) {
        IProducto[] productos = new IProducto[5];

        productos[0] = new IPhone("Apple", 1200,"Negro","15 pro max");
        productos[1] = new TvLcd("Samsung", 800, 55);
        productos[2] = new Libro(800, LocalDate.of(1605, 1, 16), "Miguel de Cervantes Saavedra", "Don Quijote de la Mancha", "Nova");
        productos[3] = new TvLcd("LG", 600, 42);
        productos[4] = new IPhone("Apple", 700, "Blanco", "14");
        
        for (IProducto p : productos) {
            System.out.println("Precio base: " + p.getPrecio() + " | Precio venta: " + p.getPrecioVenta());
        }
    }
}
