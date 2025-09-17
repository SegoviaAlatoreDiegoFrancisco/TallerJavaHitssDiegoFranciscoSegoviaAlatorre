import genericos.Identificable;
import java.util.List;


public class Factura implements Identificable<Long>{
    private long id;
    private Cliente cliente;
    private List<Producto> productos;

    
    public Factura(long id, Cliente cliente, List<Producto> productos) {
        this.id = id;
        this.cliente = cliente;
        this.productos = productos;
    }


    @Override
    public Long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }


    public Cliente getCliente() {
        return cliente;
    }


    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    public List<Producto> getProductos() {
        return productos;
    }


    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    //Metodo dinámico para agregar un producto a la factura
    public void agregarProducto(Producto producto){
        productos.add(producto);
        System.out.println("Producto agregado a la factura: "+ producto);
    }
    //Eliminar un producto de forma dinámica
    public boolean eliminarProducto(int idProducto){
        for (int i=0; i<productos.size();i++){
            if(productos.get(i).getId()==idProducto){
                Producto producto = productos.remove(i);
                System.out.println("Producto eliminado de la lista"+producto);
                return true; 
            }
        }
        return false;
    }
    public double calcularTotal(){
        double total=0;
        for (Producto producto : productos){
        total+=producto.getPrecio();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Factura{id: "+id+", cliente: "+cliente+", productos: "
        +productos+", total: "+ calcularTotal()+"}";
    }
   
}
