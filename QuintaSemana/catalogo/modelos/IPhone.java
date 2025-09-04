package catalogo.modelos;
import catalogo.abstractos.Electronico;
import catalogo.interfaces.IProducto;

public class IPhone extends Electronico implements IProducto{
    private int precio;
    private String color;
    private String modelo;
    public IPhone(String fabricante, int precio, String color, String modelo) {
        super(fabricante);
        this.precio = precio;
        this.color = color;
        this.modelo = modelo;
    }
    @Override
    public int getPrecio() {
        // TODO Auto-generated method stub
        return precio;
    }
    @Override
    public double getPrecioVenta() {
        // TODO Auto-generated method stub
        return precio *1.2;
    }
    public String getColor() {
        return color;
    }
    public String getModelo() {
        return modelo;
    }

    
}
