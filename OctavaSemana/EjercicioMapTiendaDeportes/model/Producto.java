package model;
import java.util.HashMap;
import java.util.Map;

public class Producto{
    private String sku;
    private String nombre;
    private String categoria;
    private Map<String, Integer> stockPorSucursal;

    public Producto(String categoria, String nombre, String sku) {
        this.categoria = categoria;
        this.nombre = nombre;
        this.sku = sku;
        this.stockPorSucursal = new HashMap<>();
    }

    public Producto() {
    }

    public String getSku() {
        return sku;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void actualizarStock(String sucursal, int cantidad){
        stockPorSucursal.put(sucursal, stockPorSucursal.getOrDefault(sucursal,0)+ cantidad);
    }
    public int getStockTotal(){
        return stockPorSucursal.values().stream().mapToInt(Integer::intValue).sum(); 
    }

    public Map<String, Integer> getStockPorSucursal() {
        return stockPorSucursal;
    }

    @Override
    public String toString() {
        return "Producto [sku=" + sku + ", nombre=" + nombre + ", categoria=" + categoria + ", stockTotal="
                + getStockTotal() + "]";
    }

     
}