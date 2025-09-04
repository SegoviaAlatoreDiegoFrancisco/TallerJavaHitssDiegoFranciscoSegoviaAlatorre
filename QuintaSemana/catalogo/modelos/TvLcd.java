package catalogo.modelos;
import catalogo.abstractos.Electronico;
import catalogo.interfaces.IProducto;

public class TvLcd  extends Electronico implements IProducto{
    private int precio;
    private int pulgadas;
    public TvLcd(String fabricante, int precio, int pulgadas) {
        super(fabricante);
        this.precio = precio;
        this.pulgadas = pulgadas;
    }
    @Override
    public int getPrecio() {
        // TODO Auto-generated method stub
        return precio;
    }
    @Override
    public double getPrecioVenta() {
        // TODO Auto-generated method stub
        return precio *1.15;
    }
    public int getPulgadas() {
        return pulgadas;
    }

    
    
}
