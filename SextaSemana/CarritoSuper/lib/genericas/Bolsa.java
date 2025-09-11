package genericas;

import java.util.ArrayList;
import java.util.List;
public class Bolsa<T> {
    private List<T> productos = new ArrayList<>();

    public void addProducto(T producto){
        productos.add(producto);
    }
    public List<T> getProductos(){
        return productos;
    }
}

