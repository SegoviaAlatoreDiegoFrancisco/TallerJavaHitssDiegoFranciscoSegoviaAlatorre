
import java.util.LinkedHashMap;
import java.util.Map;

public class TestProducto {
    public static void main(String[] args) {
        //LinkedHashMap mantiene el orden de insercion
        Map<String,Producto> inventario = new LinkedHashMap<>();

        //Agregar productos
        inventario.put("P001", new Producto(5,"P001", "Laprop"));
        inventario.put("P005", new Producto(10,"P005", "Mouse"));
        inventario.put("P002", new Producto(15, "P002", "Tecaldo"));
        imprimirMapa(inventario);
        //actualizar un producto
        System.out.println("Actualizando producto P002");
        inventario.get("P002").setCantidad(9);
        imprimirMapa(inventario);

        String codigo = "P002";
        if (inventario.containsKey(codigo)){
            System.out.println("Nombre del producto: "+ inventario.get(codigo).getCodigo());
            inventario.get(codigo).setCantidad(10);
        }

        imprimirMapa(inventario);
        //Eliminar un producto
        System.out.println("Producto eliminado "+ inventario.remove(codigo));
        imprimirMapa(inventario);
        inventario.put("P006", new Producto(12,"P006", "Monitor"));
        System.out.println("Despues de agregar un producto");
        imprimirMapa(inventario);
        
    }
        public static void imprimirMapa(Map<String, Producto> productos){
        for (Map.Entry<String,Producto> producto : productos.entrySet()) {
            System.out.println(producto.getKey() + " -> "+producto.getValue());
        }
    }
}
