
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Factura {
    private int id;
    private Cliente cliente;
    private LocalDate fecha;
    private LocalDate fechaVencimiento;
    private List<Venta> ventas;

    public Factura(Cliente cliente, LocalDate fecha, LocalDate fechaVencimiento, int id) {
        this.cliente = cliente;
        this.fecha = fecha;
        this.fechaVencimiento = fechaVencimiento;
        this.id = id;
        this.ventas= new ArrayList<>();
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void agregarVenta(Venta venta){
        ventas.add(venta);
    }
    public double getTotal(){
        return ventas.stream().mapToDouble(Venta::getSubTotalDeVenta).sum();
    }
    public boolean estaVencida(){
        return fechaVencimiento.isBefore(LocalDate.now());

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Factura{");
        sb.append(", cliente=").append(cliente.getNombre());
        sb.append(", fecha=").append(fecha);
        sb.append(", ventas=").append(ventas);
        sb.append('}');
        return sb.toString();
    }


}
