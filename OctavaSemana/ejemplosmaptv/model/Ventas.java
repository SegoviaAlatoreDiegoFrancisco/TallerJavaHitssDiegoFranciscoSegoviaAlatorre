public class Ventas {
    private int id;
    private String vendedor;
    private double total;

    public Ventas(int id, double total, String vendedor) {
        this.id = id;
        this.total = total;
        this.vendedor = vendedor;
    }

    public Ventas() {
    }

    public int getId() {
        return id;
    }

    public String getVendedor() {
        return vendedor;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Ventas [id=" + id + ", vendedor=" + vendedor + ", total=" + total + "]";
    }


}
