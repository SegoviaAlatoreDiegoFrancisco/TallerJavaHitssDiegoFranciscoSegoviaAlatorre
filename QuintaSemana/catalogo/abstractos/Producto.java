package catalogo.abstractos;
import catalogo.interfaces.IProducto;
public abstract class Producto implements IProducto{
    protected int precio;

    public Producto(int precio){
        this.precio = precio;
    }

    @Override
    public int getPrecio() {
        // TODO Auto-generated method stub
        return precio;
    }    
}
