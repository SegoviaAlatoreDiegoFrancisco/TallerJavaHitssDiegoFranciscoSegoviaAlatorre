public class Venta {
    private Producto producto;
    private int cantidad;
    //private double subtotal;

    public Venta(int cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubTotalDeVenta(){
        return producto.getPrecio() * cantidad;
    }
    public double getTotal(){
        return producto.getPrecio() * cantidad;
    }
    @Override
    public String toString() {
        return producto.getNombre() +" ==> "+cantidad+" TOTAL="+ getCantidad();
    }

}
