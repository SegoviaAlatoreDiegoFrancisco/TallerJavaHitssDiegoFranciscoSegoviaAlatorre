
import java.util.List;

public class Venta {
    private int id;
    private Cliente cliente;
    private Empleado empleado;
    private List<Producto> productosLista;
    private double total;

    public Venta() {
    }

    public Venta(Cliente cliente, Empleado empleado, int id, List<Producto> productosLista, double total) {
        this.cliente = cliente;
        this.empleado = empleado;
        this.id = id;
        this.productosLista = productosLista;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public List<Producto> getProductosLista() {
        return productosLista;
    }

    public void setProductosLista(List<Producto> productosLista) {
        this.productosLista = productosLista;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }


}
