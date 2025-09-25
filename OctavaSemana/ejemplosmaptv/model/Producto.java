public class Producto {
    private String codigo;
    private String descripcion;
    private int cantidad;

    public Producto(int cantidad, String codigo, String descripcion) {
        this.cantidad = cantidad;
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public Producto() {
    }

    @Override
    public String toString() {
        return "Producto [codigo=" + codigo + ", descripcion=" + descripcion + ", cantidad=" + cantidad + "]";
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
